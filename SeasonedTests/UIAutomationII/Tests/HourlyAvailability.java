import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HourlyAvailability extends BaseTest {

    private WebDriverWait wait;
    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private AvailabilityPage availabilityPage;

    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing test... ");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        availabilityPage = new AvailabilityPage(driver);
        username = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("username");
        password = (String) TestDataImporter.get("HourlyAvailability", "Hourly Availability").get("password");
        System.out.println("Starting test run!");
    }

    @Test
    public void testAvailability() {
        /* Start on the content feed page */
        testUtils.loadContentFeedPage();

        /* Click the login button from the nav header and login */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the Tests.Availability page */
        navPage.navigateToProfilePage();
        profilePage.clickAddAvailability();

        /* Verify that no availability has been selected, then select all availability and save. A success toast should appear. */
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "The user should have no availability selected.");
        availabilityPage.selectAllAvailability();
        Assert.assertTrue(availabilityPage.verifySuccessToast(), "The profile saved successfully toast is displayed.");

        //Verify that all checkboxes are selected then unselect all availability
        Assert.assertTrue(availabilityPage.allAvailabilitySelected(), "All availability has been been selected");
        availabilityPage.removeAllAvailability();

        //Verify that a success toast appears and that all availability has been removed
        Assert.assertTrue(availabilityPage.verifySuccessToast(), "The profile saved successfully toast is displayed.");
        Assert.assertTrue(availabilityPage.noAvailabilitySelected(), "No availability is selected.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting selenium down for Availability test.");
        navPage.logout();
        driver.quit();
    }
}
