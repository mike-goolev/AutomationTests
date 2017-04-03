import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HourlyBasicInfo extends BaseTest {

    WebDriverWait wait;
    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    BasicInfoPage basicInfoPage;

    String username;
    String password;
    String userGuid;
    String token;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing basic info UI test...");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        basicInfoPage = new BasicInfoPage(driver);
        username = (String) TestDataImporter.get("HourlyBasicInfo", "Hourly Basic Info").get("username");
        password = (String) TestDataImporter.get("HourlyBasicInfo", "Hourly Basic Info").get("password");
        userGuid = (String) TestDataImporter.get("HourlyBasicInfo", "Hourly Basic Info").get("userguid");
        token = (String) TestDataImporter.get("HourlyBasicInfo", "Hourly Basic Info").get("token");
        SeasonedTestRestAPI seasonedTestRestAPI = new SeasonedTestRestAPI(token);
        System.out.println("Making a PUT request to /user/guid/eligibility to clear basic info");
        seasonedTestRestAPI.clearEligibilityAnswersForUser(userGuid);
    }

    @Test
    public void testBasicInfo() {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> basic info page */
        navPage.navigateToProfilePage();
        profilePage.clickAddBasicInfo();

        /* Verify that none of the questions have been answered */
        Assert.assertTrue(basicInfoPage.areAllQuestionsNotAnswered(), "All questions should not be answered.");

        /* Answer Yes for all basic info questions and click save */
        basicInfoPage.clickYesBtnForAge();
        basicInfoPage.clickYesBtnForTransport();
        basicInfoPage.clickYesBtnForLegal();
        basicInfoPage.clickSaveBtn();

        /* Verify that the green success banner is displayed. */
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed.");

        /* Verify that all questions are in a selected 'Yes' state */
        Assert.assertTrue(basicInfoPage.areAllQuestionsAnsweredYes(), "All questions should be answered yes.");

        /* Go back to the profile and verify that the basic info reflects the answers for each question */
        basicInfoPage.clickBackBtn();
        Assert.assertTrue(profilePage.basicInfoQuestionsAnsweredYes(), "All questions should be answered yes on the view profile page.");

        /* Click the edit basic info page and verify that the yes answers persisted */
        profilePage.clickEditBasicInfo();
        Assert.assertTrue(basicInfoPage.areAllQuestionsAnsweredYes(), "All questions answered yes should persist after leaving page.");

        /* Answer no for all questions */
        basicInfoPage.clickNoBtnForAge();
        basicInfoPage.clickNoBtnForTransport();
        basicInfoPage.clickNoBtnForLegal();
        basicInfoPage.clickSaveBtn();
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed.");
        Assert.assertTrue(basicInfoPage.areAllQuestionsAnsweredNo(), "All questions should be answered no.");

        /* Go back to the view profile page and verify that the basic info reflects our answers */
        basicInfoPage.clickBackBtn();
        Assert.assertTrue(profilePage.basicInfoQuestionsAnsweredNo(), "All questions should be answered no.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium test for basic info");
        navPage.logout();
        driver.quit();
    }
}
