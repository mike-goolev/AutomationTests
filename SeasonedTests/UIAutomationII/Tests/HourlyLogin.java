import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HourlyLogin extends BaseTest {

    WebDriverWait wait;
    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    AboutPage aboutPage;

    String usernameEmail;
    String passwordEmail;
    String usernameHS;
    String passwordHS;
    String usernameFB;
    String passwordFB;

    @BeforeClass
    public void setUp() {
        System.out.println("Starting Tests. HourlyAbout test for hourly profile...");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        usernameEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginEmail").get("password");
        usernameHS = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginHS").get("username");
        passwordHS = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginHS").get("password");
        usernameFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("username");
        passwordFB = (String) TestDataImporter.get("HourlyLogin", "testHourlyLoginFB").get("password");
        System.out.println("Starting test run!");
    }

    @Test
    public void testHourlyLoginEmail() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);
    }

    @Test
    public void testHourlyLoginFacebook() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithFacebook(usernameFB, passwordFB);
    }

    @Test
    public void testHourlyLoginHS() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithHS(usernameHS, passwordHS);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the about test");
        navPage.logout();
        driver.quit();
    }
}