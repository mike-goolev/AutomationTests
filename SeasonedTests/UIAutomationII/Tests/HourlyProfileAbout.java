import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyProfileAbout extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfileAboutPage hourlyProfileAboutPage;
    private HourlyProfileEditPage hourlyProfileEditPage;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String id;
    private String guid;
    private String token;
    private String aboutMeTxt;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly profile About test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileAboutPage = new HourlyProfileAboutPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);
        aboutMeTxt = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("aboutMe");
        username = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("username");
        password = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("password");
        firstname = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("firstname");
        lastname = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("lastname");
        id = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("userid");
        guid = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("userguid");
        token = (String) TestDataImporter.get("HourlyProfileAbout", "HourlyProfileAbout").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateUserAbout(id, guid, firstname, lastname, username, "");
        System.out.println("Starting hourly profile About test!");
    }

    @Test
    public void testAbout() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile */
        navPage.navigateToProfilePage();
        Assert.assertTrue(hourlyProfileViewPage.isAboutHeaderDisplayed());

        /* Navigate to edit about */
        hourlyProfileViewPage.clickAddAbout();

        /* Verify that there is no text in the about text field */
        Assert.assertTrue(hourlyProfileAboutPage.aboutTxtFieldIsEmpty(), "HourlyAbout text field should be empty");
        hourlyProfileAboutPage.addAboutTxt(aboutMeTxt);

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(hourlyProfileAboutPage.verifyAboutSuccessBanner(), "Success toast should be displayed");
        hourlyProfileAboutPage.clickCloseAboutBannerBtn();

        /* Go back and verify that the text shows on the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertEquals(hourlyProfileViewPage.getAboutTxt(), aboutMeTxt);

        /* Go to edit about and verify that there is text, then remove it */
        hourlyProfileViewPage.clickEditProfile();
        hourlyProfileEditPage.clickSideMenuAboutLink();
        Assert.assertTrue(hourlyProfileAboutPage.aboutTxtEquals(aboutMeTxt), "HourlyAbout text field should be )" + aboutMeTxt);
        hourlyProfileAboutPage.removeAboutTxt();

        /* Verify success banner */
        Assert.assertTrue(hourlyProfileAboutPage.verifyAboutSuccessBanner(), "Success toast should be displayed");
        hourlyProfileAboutPage.clickCloseAboutBannerBtn();

        /* Go back to view profile and verify that there is no about text */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertFalse(hourlyProfileViewPage.isAboutSectionPresent(), "The user should NOT have about text");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly profile about test");
        navPage.attemptLogout();
        driver.quit();
    }
}
