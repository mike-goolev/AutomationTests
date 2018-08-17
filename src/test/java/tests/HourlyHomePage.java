package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HourlyLoginPage;

import utils.TestDataImporter;

public class HourlyHomePage extends BaseTest {

    protected HomePage homePage;
    protected HourlyLoginPage hourlyLoginPage;

    protected String username;
    protected String password;
    protected String fbEmail;
    protected String fbPassword;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Hourly Home Page test...");

        username = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        password = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        fbEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("username");
        fbPassword = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("password");
        System.out.println("Starting test run!");
    }

    @BeforeMethod
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
    }


    @Test
    public void testLoginFromHomePage() {

        /* Launch home page */
        testUtils.loadHomePage();

        /* Sign in */
        homePage.clickSignInLink();

        /* Login with email*/
        hourlyLoginPage.loginWithEmail(username, password);

        /* Verify that the user's name is in the nav bar*/
        Assert.assertTrue(navPage.isUserNameDisplayed(), "User name should be displayed in the nav bar");
    }

    @Test
    public void testSignUpWithFb(){
        /* Launch home page */
        testUtils.loadHomePage();
        /* Sign Up with FB */
        homePage.signUpWithFbBtn(fbEmail, fbPassword);
        /* Verify that the user's name is in the nav bar*/
        Assert.assertTrue(navPage.isUserNameDisplayed(), "User name should be displayed in the nav bar");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Hourly Home Page test");
        navPage.attemptLogout();
        driver.quit();
    }
}
