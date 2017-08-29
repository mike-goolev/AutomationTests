import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyAvailability extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private AvailabilityPage availabilityPage;
    private EditProfilePage editProfilePage;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String empInterestStatus;
    private String empInterestType;
    private String gigInterestStatus;
    private String id;
    private String userGuid;
    private String token;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Hourly Availability test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        availabilityPage = new AvailabilityPage(driver);
        editProfilePage = new EditProfilePage(driver);
        username = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("username");
        password = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("password");
        firstname = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("firstname");
        lastname = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("lastname");
        empInterestStatus = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("empintereststatus");
        empInterestType = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("empinteresttype");
        gigInterestStatus = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("gigintereststatus");
        id = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("userid");
        userGuid = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("userguid");
        token = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.clearAvailabilityForUser(userGuid);
        seasonedRestAPI.setAvailabilityStatus(id, userGuid, firstname, lastname, username, empInterestStatus, empInterestType, gigInterestStatus);
        System.out.println("Starting Availability Test!");
    }

    @Test
    public void testAvailability() throws Exception {
        /* Start on the content feed page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Click the login button from the nav header and login */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the Availability page */
        navPage.navigateToProfilePage();
        profilePage.clickEditProfile();
        editProfilePage.clickSideMenuWorkAvailabilityLink();

        /* Verify that no availability has been selected, then select all availability and save. A success toast should appear. */
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "The user should have no availability selected");
        Assert.assertFalse(availabilityPage.isGigsSelected(), "The user should not have gigs selected");
        availabilityPage.clickAllAvailabilityBoxes();
        availabilityPage.clickGigsCheckbox();
        availabilityPage.selectAvailabilityStatus("LOOKING");
        availabilityPage.clickAvailabilityTypeFullTime();
        availabilityPage.clickSaveButton();
        Assert.assertTrue(availabilityPage.verifyAvailabilitySuccessBanner(), "The profile saved successfully toast is displayed");
        availabilityPage.clickCloseAvailabilityBannerBtn();

        /* Verify that the availability is persisted on the view profile screen */
        navPage.navigateToProfilePage();
        Assert.assertTrue(profilePage.verifyAllAvailabilitySelected(), "All availability should be selected on the view profile page");
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt("I'm looking for a job"), "The interest status text should say: I'm looking for a job");
        Assert.assertTrue(profilePage.verifyAvailabilityInterestTypeTxt("full-time"),"The interest type text should say: full-time");

        /* Go back to the profile page */
        profilePage.clickEditProfile();
        editProfilePage.clickSideMenuWorkAvailabilityLink();

        /* Verify that all availability cards are selected then un-select all availability */
        Assert.assertTrue(availabilityPage.allAvailabilitySelected(), "All availability has been been selected");
        availabilityPage.clickAllAvailabilityBoxes();
        availabilityPage.selectAvailabilityStatus("OPEN");
        availabilityPage.clickAvailabilityTypeAnything();
        availabilityPage.clickGigsCheckbox();
        availabilityPage.clickSaveButton();

        /* Verify that a success toast appears and that all availability has been removed */
        Assert.assertTrue(availabilityPage.verifyAvailabilitySuccessBanner(), "The profile saved successfully toast is displayed");
        availabilityPage.clickCloseAvailabilityBannerBtn();
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "No availability is selected");

        /* Verify that the availability card is in an empty state on the view profile page */
        Thread.sleep(300);
        editProfilePage.clickSideMenuViewProfileLink();
        Assert.assertFalse(profilePage.verifyAllAvailabilitySelected(), "No availability should be on the view profile page");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting selenium down for Availability test.");
        navPage.attemptLogout();
        driver.quit();
    }
}
