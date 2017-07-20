import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HourlyWorkHistory extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    WorkHistoryPage workHistoryPage;

    String username;
    String password;
    String employer;
    String jobPosition;
    String month;
    String strYear;
    String timePeriodPresent;
    String timePeriodPast;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing work history tests...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        workHistoryPage = new WorkHistoryPage(driver);

        username = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("username");
        password = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("password");
        employer = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("employer");
        jobPosition = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("job");
        Calendar now = Calendar.getInstance();
        month = now.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        int year = now.get(Calendar.YEAR);
        strYear = String.valueOf(year);
        timePeriodPresent = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("timePeriodPresent");
        timePeriodPast = (String) TestDataImporter.get("HourlyWorkHistory", "testWorkHistory").get("timePeriodPast");
        System.out.println("Finished initialization, starting work history tests");
    }

    @Test
    public void testAddWorkHistory() throws Exception {
        /* Start test on the content feed page */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertFalse(profilePage.isExperienceHeaderDisplayed(), "Work history card should not be displayed");

        /* Go to the work history page and add an entry */
        profilePage.clickEditProfile();
        workHistoryPage.navigateToEditExperience();

        /* Click to add a new position */
        workHistoryPage.clickAddWorkHistoryBtn();

        /* Select a job position */
        workHistoryPage.clickJobPosition("15");
        workHistoryPage.removeJobPosition("0");

        /* Enter an employer*/
        workHistoryPage.enterWhereHaveYouWorkedText(employer);

        /* Grab the list of google places results */
        ArrayList<WebElement> stores = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores.get(0).click();

        /* Set work history from dates */
        workHistoryPage.selectMonthFromDate(month);
        workHistoryPage.selectYearFromDate(strYear);

        /* Select the current work history toggle */
        workHistoryPage.clickCurrentlyWorkHereOffBtn();

        /* Save add work history form */
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify success toast */
        Assert.assertTrue(workHistoryPage.verifyAddExperienceSuccessToast());
        workHistoryPage.dismissAddExperienceSuccessToast();

        /* Verify the edit work history list displays the new entry*/
        /* Below line is commented out because we don't have indexes on the employer logos yet
        /*Assert.assertTrue(workHistoryPage.isEmployerLogoPresent("0"), "Employer logo should be present");*/
        Assert.assertEquals(workHistoryPage.getJobPosition("0", "0"), jobPosition);
        Assert.assertEquals(workHistoryPage.getEmployerName("0"), employer);
        Assert.assertEquals(workHistoryPage.getTimePeriod("0"), timePeriodPresent);

        /* Navigate to profile view */
        navPage.navigateToProfilePage();

        /* Verify that the work history card on profile view is now showing the new entry */
        /* Below line is commented out because we don't have indexes on the employer logos yet
        /*Assert.assertTrue(profilePage.isEmployerLogoPresent("0"), "Employer logo should be present");*/
        Assert.assertEquals(profilePage.getEmployerName("0"), employer);
        Assert.assertEquals(profilePage.getJobPosition("0", "0"), jobPosition);
        Assert.assertEquals(profilePage.getTimePeriod("0"), timePeriodPresent);

        /* Go back to edit work history and delete the entry */
        profilePage.clickEditProfile();
        workHistoryPage.navigateToEditExperience();
        workHistoryPage.clickEditWorkHistory("0");
        workHistoryPage.clickEditWorkHistoryDeleteBtn();

        /* Accept modal confirmation */
        workHistoryPage.clickConfirmDeleteBtn();

        /* To do -- Assert empty edit profile state once all elements have IDs */

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertFalse(profilePage.isExperienceHeaderDisplayed(), "Work history card should not be displayed");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the work history test");
        navPage.attemptLogout();
        driver.quit();
    }
}
