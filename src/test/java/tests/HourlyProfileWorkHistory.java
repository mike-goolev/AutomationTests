package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pages.*;
import utils.TestDataImporter;
import utils.TestConfig;
import restInterfaces.*;

public class HourlyProfileWorkHistory extends BaseTest {

    HourlyLoginPage hourlyLoginPage;
    HourlyJobSearchPage hourlyJobSearchPage;
    HourlyProfileViewPage hourlyProfileViewPage;
    HourlyProfileWorkHistoryPage hourlyProfileWorkHistoryPage;
    HourlyProfileEditPage hourlyProfileEditPage;
    SeasonedRestAPI api;

    String username;
    String password;
    String employer1;
    String employer2;
    String employer2Formatted;
    String jobPosition1;
    String jobPosition2;
    String userLocation;
    String month;
    String yearCurrent;
    String yearLast;
    String timePeriodPresent;
    String timePeriodPast;
    String durationPresent;
    String durationPast;
    String shortDateCurrent;
    String shortDatePast;
    String jobDescription1;
    String jobDescription2;
    String jobDescription2Formatted;
    private List<String> whGuids;
    String userGuid;
    String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setup() throws SQLException {
        System.out.println("Initializing work history test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileWorkHistoryPage = new HourlyProfileWorkHistoryPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);

        username = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("username");
        password = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("password");
        employer1 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("employer1");
        employer2 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("employer2");
        employer2Formatted = employer2 + " Football Club";
        jobPosition1 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("job1");
        jobPosition2 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("job2");
        userLocation = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("userLocation");
        jobDescription1 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("jobDescription1");
        jobDescription2 = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("jobDescription2");
        userGuid = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("userGuid");
        token = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("userToken");
        jobDescription2Formatted = jobDescription2.substring(0, jobDescription2.length() - 66);
        Calendar now = Calendar.getInstance();
        shortDateCurrent = testUtils.getFormattedMonthYear(0);
        shortDatePast = testUtils.getFormattedMonthYear(-1);
        month = now.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        int year = now.get(Calendar.YEAR);
        yearCurrent = String.valueOf(year);
        yearLast = String.valueOf(year -1);
        timePeriodPresent = shortDateCurrent + TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("timePeriodPresent");
        timePeriodPast = shortDatePast + " - " + shortDateCurrent + "  ";
        durationPresent = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("durationPresent");
        durationPast = (String) TestDataImporter.get("HourlyProfileWorkHistory", "HourlyProfileWorkHistory").get("durationPast");

        api = new SeasonedRestAPI(token);
        whGuids = sqlSelect.getUserWorkHistoryByGuid(userGuid);
        for (String guid : whGuids)
            api.deleteWorkHistoryByGuid(guid);
    }

    @Test
    public void testAddWorkHistory() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        hourlyProfileViewPage.clickAddExperience();

        /* Select a job position */
        hourlyProfileWorkHistoryPage.clickJobPosition("16");

        /* Enter an employer */
        hourlyProfileWorkHistoryPage.enterWhereHaveYouWorkedText(employer1 + " Occidental");

        /* Set work history from dates */
        hourlyProfileWorkHistoryPage.selectMonthFromDate(month);
        hourlyProfileWorkHistoryPage.selectYearFromDate(yearCurrent);

        /* Select the current work history toggle */
        hourlyProfileWorkHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Enter job description */
        hourlyProfileWorkHistoryPage.enterAddJobDescriptionTxt(jobDescription1);

        /* Verify first job check is deselected */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Save add work history form */
        hourlyProfileWorkHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyAddExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getEmployerName("0"), employer1);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getDuration("0"), durationPresent);

        /* Navigate to profile view */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job in profile summary section */
        Assert.assertEquals(hourlyProfileViewPage.getSummaryPrimaryJob(), jobPosition1 + " @ " + employer1);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(hourlyProfileViewPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileViewPage.getEmployerName("0"), employer1);
        Assert.assertEquals(hourlyProfileViewPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(hourlyProfileViewPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(hourlyProfileViewPage.getDuration("0"), durationPresent);
        Assert.assertEquals(hourlyProfileViewPage.getDescription("0"), jobDescription1);

        /* Go back to edit work history and delete the entry */
        hourlyProfileViewPage.clickEditExperience();
        hourlyProfileWorkHistoryPage.clickEditWorkHistory("0");
        hourlyProfileWorkHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        hourlyProfileWorkHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyDeleteExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissDeleteExperienceSuccessToast();

        /* Verify add work history form displayed in an empty state */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Navigate to the profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history card should be displayed");
    }

    @Test
    public void testAddWorkHistoryFirstJob() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        hourlyProfileViewPage.clickAddExperience();

        /* Verify first job check is deselected */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Select first job checkbox */
        hourlyProfileWorkHistoryPage.clickFirstJobChk();

        /* Save add work history form */
        hourlyProfileWorkHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyAddExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify first job check is selected */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be selected");

        /* Navigate to the profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history card should be displayed");
        // Nothing else to assert here at the moment until we add info to the card concerning the user's 'first job' selection

        /* Go to the work history page and add an entry */
        hourlyProfileViewPage.clickAddExperience();

        /* Verify first job check is selected */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be selected");

        /* Select first job checkbox */
        hourlyProfileWorkHistoryPage.clickFirstJobChk();

        /* Save add work history form */
        hourlyProfileWorkHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyAddExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify first job check is selected */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");
    }

    @Test
    public void testAddWorkHistoryPrimaryJob() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the work history card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        hourlyProfileViewPage.clickAddExperience();

        /* Select a job position */
        hourlyProfileWorkHistoryPage.clickJobPosition("16");

        /* Enter an employer */
        hourlyProfileWorkHistoryPage.enterWhereHaveYouWorkedText(employer1 + " Occidental");

        /* Set work history from dates */
        hourlyProfileWorkHistoryPage.selectMonthFromDate(month);
        hourlyProfileWorkHistoryPage.selectYearFromDate(yearCurrent);

        /* Select the current work history toggle */
        hourlyProfileWorkHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Enter job description */
        hourlyProfileWorkHistoryPage.enterAddJobDescriptionTxt(jobDescription1);

        /* Verify primary job check is selected */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be selected");

        /* Verify first job check is deselected */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Save add work history form */
        hourlyProfileWorkHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyAddExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getEmployerName("0"), employer1);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getDuration("0"), durationPresent);

        /* Navigate to profile view */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job and job location displayed in profile summary section */
        Assert.assertEquals(hourlyProfileViewPage.getSummaryPrimaryJob(), jobPosition1 + " @ " + employer1);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(hourlyProfileViewPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileViewPage.getEmployerName("0"), employer1);
        Assert.assertEquals(hourlyProfileViewPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(hourlyProfileViewPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(hourlyProfileViewPage.getDuration("0"), durationPresent);
        Assert.assertEquals(hourlyProfileViewPage.getDescription("0"), jobDescription1);

        /* Go back to edit work history and delete the entry */
        hourlyProfileViewPage.clickEditExperience();

        /* Add another work history entry */
        hourlyProfileWorkHistoryPage.clickAddWorkHistoryBtn();

        /* Select a job position */
        hourlyProfileWorkHistoryPage.clickJobPosition("14");

        /* Enter an employer */
        hourlyProfileWorkHistoryPage.enterWhereHaveYouWorkedText(employer2 + " Nova");

        /* Set work history from dates */
        hourlyProfileWorkHistoryPage.selectMonthFromDate(month);
        hourlyProfileWorkHistoryPage.selectYearFromDate(yearLast);

        /* Set work history end dates */
        hourlyProfileWorkHistoryPage.selectMonthToDate(month);
        hourlyProfileWorkHistoryPage.selectYearToDate(yearCurrent);

        /* Enter job description */
        hourlyProfileWorkHistoryPage.enterAddJobDescriptionTxt(jobDescription2);

        /* Verify primary job check is selected */
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be deselected");

        /* Set work history as primary */
        hourlyProfileWorkHistoryPage.clickAddPrimaryJobChk();

        /* Save add work history form */
        hourlyProfileWorkHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyAddExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isEmployerLogoPresent("1"), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getJobPosition("1", "0"), jobPosition2);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getEmployerName("1"), employer2Formatted);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getTimePeriod("1"), timePeriodPast);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getDuration("1"), durationPast);

        /* Navigate to profile view */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job and job location displayed in profile summary section */
        Assert.assertEquals(hourlyProfileViewPage.getSummaryPrimaryJob(), jobPosition2 + " @ " + employer2Formatted);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(hourlyProfileViewPage.isEmployerLogoPresent("1"), "Employer logo should be present");
        Assert.assertEquals(hourlyProfileViewPage.getEmployerName("1"), employer2Formatted);
        Assert.assertEquals(hourlyProfileViewPage.getJobPosition("1", "0"), jobPosition2);
        Assert.assertEquals(hourlyProfileViewPage.getTimePeriod("1"), timePeriodPast);
        Assert.assertEquals(hourlyProfileViewPage.getDuration("1"), durationPast);
        Assert.assertEquals(hourlyProfileViewPage.getDescription("1"), jobDescription2Formatted);

        /* Go to the work history page */
        hourlyProfileViewPage.clickEditExperience();

        /* View and delete the first work history entry */
        hourlyProfileWorkHistoryPage.clickEditWorkHistory("0");
        Assert.assertFalse(hourlyProfileWorkHistoryPage.isEditPrimaryJobChkSelected());
        hourlyProfileWorkHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        hourlyProfileWorkHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyDeleteExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissDeleteExperienceSuccessToast();

        /* View and delete the first work history entry */
        hourlyProfileWorkHistoryPage.clickEditWorkHistory("0");
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isEditPrimaryJobChkSelected());
        hourlyProfileWorkHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        hourlyProfileWorkHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.verifyDeleteExperienceSuccessToast());
        hourlyProfileWorkHistoryPage.dismissDeleteExperienceSuccessToast();

         /* Verify primary job check is selected */
        Assert.assertTrue(hourlyProfileWorkHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be selected");

        /* Navigate to the profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(hourlyProfileViewPage.isExperienceHeaderDisplayed(), "Work history header should be displayed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out for the work history test");
        navPage.attemptLogout();
    }

    @AfterClass
    public void classTearDown() {
        driver.quit();
    }
}
