import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyAbout extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private AboutPage aboutPage;

    private String username;
    private String password;
    private String aboutMeTxt;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly profile test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        aboutPage = new AboutPage(driver);
        aboutMeTxt = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("aboutMe");
        username = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("username");
        password = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("password");
        System.out.println("Starting hourly profile test!");
    }

    @Test
    public void testAbout() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the HourlyAbout page */
        navPage.navigateToProfilePage();
        profilePage.clickAddAbout();

        /* Verify that there is no text in the about text field */
        Assert.assertTrue(aboutPage.aboutTxtFieldIsEmpty(), "HourlyAbout text field should be empty");
        aboutPage.addAboutTxt(aboutMeTxt);

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed");

        /* Go back and verify that the text shows on the view profile page */
        profilePage.clickBackBtn();
        profilePage.verifyAboutTxt(aboutMeTxt);

        /* Go to edit about and verify that there is text, then remove it */
        profilePage.clickEditAbout();
        Assert.assertTrue(aboutPage.aboutTxtEquals(aboutMeTxt), "HourlyAbout text field should be )" + aboutMeTxt);
        aboutPage.removeAboutTxt();

        /* Verify success banner */
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed");
        Thread.sleep(500);

        /* Go back to view profile and verify that there is no about text */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.isAboutTxtEmptyStatePresent(), "The user should NOT have about text");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the about test");
        navPage.logout();
        driver.quit();
    }
}
