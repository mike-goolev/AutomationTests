import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HourlyWorkHistory extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    JobSearchPage jobSearchPage;
    ProfilePage profilePage;
    WorkHistoryPage workHistoryPage;
    EditProfilePage editProfilePage;

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

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing work history tests...");
        driver = BrowserFactory.getDriver("firefox");
        navPage = new NavPage(driver);
        testUtils = new TestUtils(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);
        profilePage = new ProfilePage(driver);
        workHistoryPage = new WorkHistoryPage(driver);
        editProfilePage = new EditProfilePage(driver);

        username = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("username");
        password = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("password");
        employer1 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("employer1");
        employer2 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("employer2");
        employer2Formatted = employer2 + " Football Club";
        jobPosition1 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("job1");
        jobPosition2 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("job2");
        userLocation = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("userLocation");
        jobDescription1 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("jobDescription1");
        jobDescription2 = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("jobDescription2");
        jobDescription2Formatted = jobDescription2.substring(0, jobDescription2.length() - 66);
        Calendar now = Calendar.getInstance();
        shortDateCurrent = testUtils.getFormattedMonthYear(0);
        shortDatePast = testUtils.getFormattedMonthYear(-1);
        month = now.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        int year = now.get(Calendar.YEAR);
        yearCurrent = String.valueOf(year);
        yearLast = String.valueOf(year -1);
        timePeriodPresent = shortDateCurrent + TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("timePeriodPresent");
        timePeriodPast = shortDatePast + " - " + shortDateCurrent + "  ";
        durationPresent = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("durationPresent");
        durationPast = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("durationPast");
        System.out.println("Finished initialization, starting work history tests");
    }

    @Test
    public void testAddWorkHistory() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        profilePage.clickAddExperience();

        /* Select a job position */
        workHistoryPage.clickJobPosition("16");

        /* Enter an employer */
        workHistoryPage.enterWhereHaveYouWorkedText(employer1 + " Occidental");

        /* Grab the list of google places results */
        ArrayList<WebElement> stores = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores.get(0).click();

        /* Set work history from dates */
        workHistoryPage.selectMonthFromDate(month);
        workHistoryPage.selectYearFromDate(yearCurrent);

        /* Select the current work history toggle */
        workHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Enter job description */
        workHistoryPage.enterAddJobDescriptionTxt(jobDescription1);

        /* Verify first job check is deselected */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(workHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(workHistoryPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(workHistoryPage.getEmployerName("0"), employer1);
        Assert.assertEquals(workHistoryPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(workHistoryPage.getDuration("0"), durationPresent);

        /* Navigate to profile view */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job in profile summary section */
        Assert.assertEquals(profilePage.getSummaryPrimaryJob(), jobPosition1 + " @ " + employer1);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(profilePage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(profilePage.getEmployerName("0"), employer1);
        Assert.assertEquals(profilePage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(profilePage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(profilePage.getDuration("0"), durationPresent);
        Assert.assertEquals(profilePage.getDescription("0"), jobDescription1);

        /* Go back to edit work history and delete the entry */
        profilePage.clickEditExperience();
        workHistoryPage.clickEditWorkHistory("0");
        workHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        workHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyDeleteExperienceSuccessToast());
        workHistoryPage.dismissDeleteExperienceSuccessToast();

        /* Verify add work history form displayed in an empty state */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Navigate to the profile page */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history card should be displayed");
    }

    @Test
    public void testAddWorkHistoryFirstJob() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        profilePage.clickAddExperience();

        /* Verify first job check is deselected */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Select first job checkbox */
        workHistoryPage.clickFirstJobChk();

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify first job check is selected */
        Assert.assertTrue(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be selected");

        /* Navigate to the profile page */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history card should be displayed");
        // Nothing else to assert here at the moment until we add info to the card concerning the user's 'first job' selection

        /* Go to the work history page and add an entry */
        profilePage.clickAddExperience();

        /* Verify first job check is selected */
        Assert.assertTrue(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be selected");

        /* Select first job checkbox */
        workHistoryPage.clickFirstJobChk();

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify first job check is selected */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");
    }

    @Test
    public void testAddWorkHistoryPrimaryJob() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the work history card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history header should be displayed");

        /* Go to the work history page and add an entry */
        profilePage.clickAddExperience();

        /* Select a job position */
        workHistoryPage.clickJobPosition("16");

        /* Enter an employer */
        workHistoryPage.enterWhereHaveYouWorkedText(employer1 + " Occidental");

        /* Grab the list of google places results */
        ArrayList<WebElement> stores1 = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores1.get(0).click();

        /* Set work history from dates */
        workHistoryPage.selectMonthFromDate(month);
        workHistoryPage.selectYearFromDate(yearCurrent);

        /* Select the current work history toggle */
        workHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Enter job description */
        workHistoryPage.enterAddJobDescriptionTxt(jobDescription1);

        /* Verify primary job check is selected */
        Assert.assertTrue(workHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be selected");

        /* Verify first job check is deselected */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(workHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(workHistoryPage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(workHistoryPage.getEmployerName("0"), employer1);
        Assert.assertEquals(workHistoryPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(workHistoryPage.getDuration("0"), durationPresent);

        /* Navigate to profile view */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job and job location displayed in profile summary section */
        Assert.assertEquals(profilePage.getSummaryPrimaryJob(), jobPosition1 + " @ " + employer1);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(profilePage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(profilePage.getEmployerName("0"), employer1);
        Assert.assertEquals(profilePage.getJobPosition("0", "0"), jobPosition1);
        Assert.assertEquals(profilePage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(profilePage.getDuration("0"), durationPresent);
        Assert.assertEquals(profilePage.getDescription("0"), jobDescription1);

        /* Go back to edit work history and delete the entry */
        profilePage.clickEditExperience();

        /* Add another work history entry */
        workHistoryPage.clickAddWorkHistoryBtn();

        /* Select a job position */
        workHistoryPage.clickJobPosition("14");

        /* Enter an employer */
        workHistoryPage.enterWhereHaveYouWorkedText(employer2 + " Nova");

        /* Grab the list of google places results */
        ArrayList<WebElement> stores2 = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores2.get(0).click();

        /* Set work history from dates */
        workHistoryPage.selectMonthFromDate(month);
        workHistoryPage.selectYearFromDate(yearLast);

        /* Set work history end dates */
        workHistoryPage.selectMonthToDate(month);
        workHistoryPage.selectYearToDate(yearCurrent);

        /* Enter job description */
        workHistoryPage.enterAddJobDescriptionTxt(jobDescription2);

        /* Verify primary job check is selected */
        Assert.assertFalse(workHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be deselected");

        /* Set work history as primary */
        workHistoryPage.clickAddPrimaryJobChk();

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(workHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(workHistoryPage.getJobPosition("1", "0"), jobPosition2);
        Assert.assertEquals(workHistoryPage.getEmployerName("1"), employer2Formatted);
        Assert.assertEquals(workHistoryPage.getTimePeriod("1"), timePeriodPast);
        Assert.assertEquals(workHistoryPage.getDuration("1"), durationPast);

        /* Navigate to profile view */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job and job location displayed in profile summary section */
        Assert.assertEquals(profilePage.getSummaryPrimaryJob(), jobPosition2 + " @ " + employer2Formatted);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(profilePage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(profilePage.getEmployerName("1"), employer2Formatted);
        Assert.assertEquals(profilePage.getJobPosition("1", "0"), jobPosition2);
        Assert.assertEquals(profilePage.getTimePeriod("1"), timePeriodPast);
        Assert.assertEquals(profilePage.getDuration("1"), durationPast);
        Assert.assertEquals(profilePage.getDescription("1"), jobDescription2Formatted);

        /* Go to the work history page */
        profilePage.clickEditExperience();

        /* View and delete the first work history entry */
        workHistoryPage.clickEditWorkHistory("0");
        Assert.assertFalse(workHistoryPage.isEditPrimaryJobChkSelected());
        workHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        workHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyDeleteExperienceSuccessToast());
        workHistoryPage.dismissDeleteExperienceSuccessToast();

        /* View and delete the first work history entry */
        workHistoryPage.clickEditWorkHistory("0");
        Assert.assertTrue(workHistoryPage.isEditPrimaryJobChkSelected());
        workHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        workHistoryPage.clickConfirmDeleteBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyDeleteExperienceSuccessToast());
        workHistoryPage.dismissDeleteExperienceSuccessToast();

         /* Verify primary job check is selected */
        Assert.assertTrue(workHistoryPage.isAddPrimaryJobChkSelected(), "Primary job checkbox should be selected");

        /* Navigate to the profile page */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history header should be displayed");
    }

    @AfterMethod
    public void methodTearDown(){
        System.out.println("Logging out for the work history test");
        navPage.attemptLogout();
    }

    @AfterClass
    public void classTearDown() {
        driver.quit();
    }
}
