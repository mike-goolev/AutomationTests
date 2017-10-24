import org.testng.Assert;
import org.testng.annotations.*;

public class HourlyLogin extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    HourlyLoginPage hourlyLoginPage;
    HourlyJobSearchPage hourlyJobSearchPage;
    HourlyNetworkMyConnectionsPage hourlyNetworkMyConnectionsPage;
    HourlyNetworkPage hourlyNetworkPage;
    HourlyBeSuccessfulPage hourlyBeSuccessfulPage;
    Locators.NavPageLocators navPageLocators;

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
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);
        hourlyNetworkPage = new HourlyNetworkPage(driver);
        hourlyBeSuccessfulPage = new HourlyBeSuccessfulPage(driver);
        navPageLocators = new Locators.NavPageLocators();

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
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on job search page */
        hourlyJobSearchPage.verifyPositionDropdown();
    }

    @Test(enabled = false)
    public void testHourlyLoginFromJobSearchPageByFacebook() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on job search page */
        hourlyJobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlyLoginFromConnectionsPageByEmail() throws Exception {
        /* Start test on the connections page */
        testUtils.loadConnectionsPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on connections page */
        Assert.assertTrue(hourlyNetworkPage.isUserSearchFieldPresent());
    }

    @Test(enabled = false)
    public void testHourlyLoginFromConnectionsByFacebook() throws Exception {
        /* Start test on the connections page */
        testUtils.loadConnectionsPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on connections page */
        Assert.assertTrue(hourlyNetworkPage.isUserSearchFieldPresent());
    }

    @Test
    public void testHourlyLoginFromBeSuccessfulPageByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Verify user lands on be successful page */
        Assert.assertTrue(hourlyBeSuccessfulPage.isHeaderDisplayed());
    }

    @Test(enabled = false)
    public void testHourlyLoginFromBeSuccessfulByFacebook() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithFacebook(usernameFB, passwordFB);

        /* Verify user lands on be successful page */
        Assert.assertTrue(hourlyBeSuccessfulPage.isHeaderDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Login test");
        navPage.attemptLogout();
        driver.quit();
    }
}