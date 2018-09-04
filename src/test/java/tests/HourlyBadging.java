package tests;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HourlyLoginPage;
import pages.HourlyProfileViewPage;
import utils.TestDataImporter;
import utils.TestUtils;

public class HourlyBadging extends BaseTest {

    HourlyLoginPage hourlyLoginPage;
    HourlyProfileViewPage hourlyProfileViewPage;

    String usernameEmail;
    String passwordEmail;
    String usernameBadging;
    String passwordBadging;

    @BeforeMethod(dependsOnGroups = {"setUpMain"})
    public void setUp() {
        System.out.println("Method set up");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);

        usernameEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        usernameBadging = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginUnlockedBadges").get("username");
        passwordBadging = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginUnlockedBadges").get("password");
    }

    @Test
    public void checkingLockedBadges() throws Exception {

        /* Go to be successful page */
        TestUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Go to member's profile page */
        navPage.navigateToProfilePage();

        /* Checking locked badges are displayed */
        Assert.assertTrue(hourlyProfileViewPage.isLockedProfileBadgePresent());
        Assert.assertTrue(hourlyProfileViewPage.isLockedConnectionBadgePresent());
    }

        @Test
        public void checkingUnlockedBadges() throws Exception {

            /* Go to be successful page */
            TestUtils.loadBeSuccessfulPage();

            /* Log in with special credentials when user has unlocked badges */
            navPage.clickLoginBtn();
            hourlyLoginPage.loginUnlockedBadges(usernameBadging, passwordBadging);

            /* Go to member's profile page */
            navPage.navigateToProfilePage();

            /* Checking unlocked badges are displayed */
            Assert.assertTrue(hourlyProfileViewPage.isUnlockedProfileBadgePresent());
            Assert.assertTrue(hourlyProfileViewPage.isUnlockedConnectionBadgePresent());
        }

    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println("Method tear down");
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Hourly Login test");
        navPage.attemptLogout();
        driver.quit();
    }
}