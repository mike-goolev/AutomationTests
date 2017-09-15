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
    private EditProfilePage editProfilePage;

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
        System.out.println("Initializing hourly profile test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        aboutPage = new AboutPage(driver);
        editProfilePage = new EditProfilePage(driver);
        aboutMeTxt = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("aboutMe");
        username = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("username");
        password = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("password");
        firstname = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("firstname");
        lastname = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("lastname");
        id = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("userid");
        guid = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("userguid");
        token = (String) TestDataImporter.get("HourlyAbout", "HourlyAbout").get("token");
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
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile */
        navPage.navigateToProfilePage();
        Assert.assertTrue(profilePage.isAboutHeaderDisplayed());

        /* Navigate to edit about */
        profilePage.clickAddAbout();

        /* Verify that there is no text in the about text field */
        Assert.assertTrue(aboutPage.aboutTxtFieldIsEmpty(), "HourlyAbout text field should be empty");
        aboutPage.addAboutTxt(aboutMeTxt);

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(aboutPage.verifyAboutSuccessBanner(), "Success toast should be displayed");
        aboutPage.clickCloseAboutBannerBtn();

        /* Go back and verify that the text shows on the view profile page */
        editProfilePage.clickSideMenuViewProfileLink();
        Assert.assertEquals(profilePage.getAboutTxt(), aboutMeTxt);

        /* Go to edit about and verify that there is text, then remove it */
        profilePage.clickEditProfile();
        editProfilePage.clickSideMenuAboutLink();
        Assert.assertTrue(aboutPage.aboutTxtEquals(aboutMeTxt), "HourlyAbout text field should be )" + aboutMeTxt);
        aboutPage.removeAboutTxt();

        /* Verify success banner */
        Assert.assertTrue(aboutPage.verifyAboutSuccessBanner(), "Success toast should be displayed");
        aboutPage.clickCloseAboutBannerBtn();

        /* Go back to view profile and verify that there is no about text */
        editProfilePage.clickSideMenuViewProfileLink();
        Assert.assertFalse(profilePage.isAboutSectionPresent(), "The user should NOT have about text");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the about test");
        navPage.attemptLogout();
        driver.quit();
    }
}
