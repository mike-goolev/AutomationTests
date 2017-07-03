import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class HourlyLogin extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;

    String usernameEmail;
    String passwordEmail;
    String usernameFB;
    String passwordFB;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing HourlyLogin test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);

        usernameEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        usernameFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("username");
        passwordFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("password");
        System.out.println("Starting test run!");
    }

//    @Test
//    public void testHourlyLoginFromContentPageByEmail() throws Exception {
//        /* Start test on the content feed page */
//        testUtils.loadContentFeedPage();
//
//        /* Log in */
//        navPage.clickLoginBtn();
//        loginPage.loginWithEmail(usernameEmail, passwordEmail);
//    }

    @Test
    public void testHourlyLoginFromJobSearchPageByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);
    }

//    @Test
//    public void testHourlyLoginFromContentPageByFacebook() throws Exception {
//        /* Start test on the content feed page */
//        testUtils.loadContentFeedPage();
//
//        /* Log in */
//        navPage.clickLoginBtn();
//        loginPage.loginWithFacebook(usernameFB, passwordFB);
//    }

    @Test
    public void testHourlyLoginFromJobSearchPageByFacebook() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the HourlyLogin test");
        navPage.attemptLogout();
        driver.quit();
    }
}