import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
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
    String employer;
    String jobPosition;
    String userLocation;
    String month;
    String strYear;
    String timePeriodPresent;
    String timePeriodPast;
    String durationPresent;
    String durationPast;
    String shortMonth;
    String jobDescription;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing work history tests...");
        driver = new FirefoxDriver();
        navPage = new NavPage(driver);
        testUtils = new TestUtils(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);
        profilePage = new ProfilePage(driver);
        workHistoryPage = new WorkHistoryPage(driver);
        editProfilePage = new EditProfilePage(driver);

        username = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("username");
        password = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("password");
        employer = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("employer");
        jobPosition = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("job");
        userLocation = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("userLocation");
        jobDescription = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("jobDescription");
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MMM yyyy");
        shortMonth = format.format(now.getTime());
        month = now.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        int year = now.get(Calendar.YEAR);
        strYear = String.valueOf(year);
        timePeriodPresent = shortMonth + TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("timePeriodPresent");
        timePeriodPast = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("timePeriodPast");
        durationPresent = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("durationPresent");
        durationPast = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("durationPast");
        System.out.println("Finished initialization, starting work history tests");
    }

    @Test
    public void testAddWorkHistory() throws Exception {
        /* Start test on the content feed page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Verify job search page displayed */
        Assert.assertTrue(jobSearchPage.verifyPositionDropdown(), "Job search page should be displayed");

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isExperienceHeaderDisplayed(), "Work history card should be displayed");

        /* Go to the work history page and add an entry */
        profilePage.clickEditProfile();
        editProfilePage.clickSideMenuExperienceLink();

        /* Select a job position */
        workHistoryPage.clickJobPosition("16");

        /* Enter an employer */
        workHistoryPage.enterWhereHaveYouWorkedText(employer);

        /* Grab the list of google places results */
        ArrayList<WebElement> stores = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores.get(0).click();

        /* Set work history from dates */
        workHistoryPage.selectMonthFromDate(month);
        workHistoryPage.selectYearFromDate(strYear);

        /* Select the current work history toggle */
        workHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Enter job description */
        workHistoryPage.enterAddJobDescriptionTxt(jobDescription);

        /* Verify first job check is deselected */
        Assert.assertFalse(workHistoryPage.isFirstJobChkSelected(), "First job checkbox should be deselected");

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry */
        Assert.assertTrue(workHistoryPage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(workHistoryPage.getJobPosition("0", "0"), jobPosition);
        Assert.assertEquals(workHistoryPage.getEmployerName("0"), employer);
        Assert.assertEquals(workHistoryPage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(workHistoryPage.getDuration("0"), durationPresent);

        /* Navigate to profile view */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify the user's primary job and job location displayed in profile summary section */
        Assert.assertEquals(profilePage.getSummaryPrimaryJob("0"), jobPosition);
        Assert.assertEquals(profilePage.getSummaryLocation(), "in " + userLocation);

        /* Verify that the work history card on profile view is now showing the new entry */
        Assert.assertTrue(profilePage.isEmployerLogoPresent(""), "Employer logo should be present");
        Assert.assertEquals(profilePage.getEmployerName("0"), employer);
        Assert.assertEquals(profilePage.getJobPosition("0", "0"), jobPosition);
        Assert.assertEquals(profilePage.getTimePeriod("0"), timePeriodPresent);
        Assert.assertEquals(profilePage.getDuration("0"), durationPresent);
        Assert.assertEquals(profilePage.getDescription("0"), jobDescription);

        /* Go back to edit work history and delete the entry */
        profilePage.clickEditProfile();
        editProfilePage.clickSideMenuExperienceLink();
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

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the work history test");
        navPage.attemptLogout();
        driver.quit();
    }
}
