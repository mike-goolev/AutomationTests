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

    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Hourly Availability test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        availabilityPage = new AvailabilityPage(driver);
        username = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("username");
        password = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("password");
        System.out.println("Starting Availability Test!");
    }

    @Test
    public void testAvailability() throws Exception {
        /* Start on the content feed page */
        testUtils.loadContentFeedPage();

        /* Click the login button from the nav header and login */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the Tests.Availability page */
        navPage.navigateToProfilePage();
        profilePage.clickAddAvailability();

        /* Verify that no availability has been selected, then select all availability and save. A success toast should appear. */
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "The user should have no availability selected");
        availabilityPage.clickAllAvailabilityBoxes();
        Assert.assertTrue(profilePage.verifySuccessToast(), "The profile saved successfully toast is displayed");

        /* Verify that the availability is persisted on the view profile screen */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.verifyAllAvailabilitySelected(), "All availability should be selected on the view profile page");

        /* Go back to the profile page */
        profilePage.clickEditAvailability();

        /* Verify that all checkboxes are selected then unselect all availability */
        Assert.assertTrue(availabilityPage.allAvailabilitySelected(), "All availability has been been selected");
        availabilityPage.clickAllAvailabilityBoxes();

        /* Verify that a success toast appears and that all availability has been removed */
        Assert.assertTrue(profilePage.verifySuccessToast(), "The profile saved successfully toast is displayed");
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "No availability is selected");

        /* Verify that the availability card is in an empty state on the view profile page */
        profilePage.clickBackBtn();
        Thread.sleep(200);
        Assert.assertFalse(profilePage.verifyAllAvailabilitySelected(), "No availability should be on the view profile page");

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting selenium down for Availability test.");
        navPage.logout();
        driver.quit();
    }
}
