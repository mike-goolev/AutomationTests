import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class HourlyLogin extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    JobSearchPage jobSearchPage;

    String usernameEmail;
    String passwordEmail;
    String usernameFB;
    String passwordFB;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing Hourly Login test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);

        usernameEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        usernameFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("username");
        passwordFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("password");
        System.out.println("Starting test run!");
    }

    @Test
    public void testHourlyLoginFromJobSearchPageByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on job search page */
        jobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlyLoginFromJobSearchPageByFacebook() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on job search page */
        jobSearchPage.verifyPositionDropdown();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Login test");
        navPage.attemptLogout();
        driver.quit();
    }
}