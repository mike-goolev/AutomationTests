import org.testng.Assert;
import org.testng.annotations.*;

public class HourlyLogin extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    JobSearchPage jobSearchPage;
    HourlyConnectionsPage hourlyConnectionsPage;
    BeSuccessfulPage beSuccessfulPage;

    String usernameEmail;
    String passwordEmail;
    String usernameFB;
    String passwordFB;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing Hourly Login test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);
        hourlyConnectionsPage = new HourlyConnectionsPage(driver);
        beSuccessfulPage = new BeSuccessfulPage(driver);

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

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on job search page */
        jobSearchPage.verifyPositionDropdown();
    }

    @Test(enabled = false)
    public void testHourlyLoginFromJobSearchPageByFacebook() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on job search page */
        jobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlyLoginFromConnectionsPageByEmail() throws Exception {
        /* Start test on the connections page */
        testUtils.loadConnectionsPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on connections page */
        Assert.assertTrue(hourlyConnectionsPage.isUserSearchFieldPresent());
    }

    @Test(enabled = false)
    public void testHourlyLoginFromConnectionsByFacebook() throws Exception {
        /* Start test on the connections page */
        testUtils.loadConnectionsPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on connections page */
        Assert.assertTrue(hourlyConnectionsPage.isUserSearchFieldPresent());
    }

    @Test
    public void testHourlyLoginFromBeSuccessfulPageByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on be successful page */
        Assert.assertTrue(beSuccessfulPage.isHeaderDisplayed());
    }

    @Test(enabled = false)
    public void testHourlyLoginFromBeSuccessfulByFacebook() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on be successful page */
        Assert.assertTrue(beSuccessfulPage.isHeaderDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Login test");
        navPage.attemptLogout();
        driver.quit();
    }
}