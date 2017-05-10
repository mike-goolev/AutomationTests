import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
        System.out.println("Finished initialization, starting work history tests");
    }

    @Test
    public void testWorkHistory() throws Exception {
        /* Start test on the content feed page */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify the empty text state on the card */
        Assert.assertTrue(profilePage.isWorkHistoryEmptyCardTextPresent(), "Work history card should be in the empty state");

        /* Go to the work history page and add an entry */
        profilePage.clickAddWorkHistory();
        workHistoryPage.enterWhereHaveYouWorkedText(employer);

        /* Grab the list of google places results */
        ArrayList<WebElement> stores = (ArrayList<WebElement>) workHistoryPage.getGooglePlacesElements();
        stores.get(0).click();

        /* Select a job position and click save */
        workHistoryPage.selectJobPosition(jobPosition);
        workHistoryPage.clickAddWorkHistorySaveBtn();

        /* Verify that the success banner shows on go back to the view profile page */
        Assert.assertTrue(profilePage.verifySuccessToast(), "The success toast should be displayed");
        profilePage.clickBackBtn();

        /* Verify that the work history card is now showing 1 entry */
        profilePage.waitForEditWorkHistoryBtn();
        Assert.assertTrue(profilePage.isEmployerLogoPresent("0"), "Employer logo should be present");
        Assert.assertTrue(profilePage.isEmployerNamePresent("0"), "Employer name should be present");
        Assert.assertTrue(profilePage.isJobPositionPresent("0", "0"), "Job position should be present");
        Assert.assertTrue(profilePage.isEmployerLocationPresent("0"), "Employer location should be present");
        Assert.assertTrue(profilePage.isTimePeriodPresent("0"), "Time period should be present");

        /* Go back to edit work history and delete the entry */
        profilePage.clickEditWorkHistory();
        workHistoryPage.clickEditWorkHistory("0");
        workHistoryPage.clickDeleteBtn();

        /* Accept modal confirmation and verify success banner */
        workHistoryPage.clickYesDeleteBtn();
        Assert.assertTrue(profilePage.verifySuccessToast(),"The success toast should be displayed");
        Thread.sleep(300);

        /* Go back to the view profile page and verify the empty card state */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.isWorkHistoryEmptyCardTextPresent(), "Work history card should be in an empty state");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("Logging out and shutting down selenium for the skills test");
        navPage.logout();
        driver.quit();
    }
}
