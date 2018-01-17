import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class HourlyLogin extends BaseTest {

    protected HourlyLoginPage hourlyLoginPage;
    protected HourlyJobSearchPage hourlyJobSearchPage;
    protected HourlyNetworkMyConnectionsPage hourlyNetworkMyConnectionsPage;
    protected HourlyNetworkPage hourlyNetworkPage;
    protected HourlyBeSuccessfulPage hourlyBeSuccessfulPage;
    protected Locators.NavPageLocators navPageLocators;

    protected String usernameEmail;
    protected String passwordEmail;
    protected String usernameFB;
    protected String passwordFB;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Hourly Login test...");

        usernameEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        usernameFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("username");
        passwordFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("password");
        System.out.println("Starting test run!");
    }

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUpTest(){
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);
        hourlyNetworkPage = new HourlyNetworkPage(driver);
        hourlyBeSuccessfulPage = new HourlyBeSuccessfulPage(driver);
        navPageLocators = new Locators.NavPageLocators();

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
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Hourly Login test");
        navPage.attemptLogout();
        driver.quit();
    }
}