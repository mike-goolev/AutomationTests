import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyConnections extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private ConnectionsPage connectionsPage;

    private String username;
    private String password;
    private String connectionIndex;
    private String connectionCount;
    private String connectionName;
    private String connectionJob;
    private String connectionLocation;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly profile test...");
        /*driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        connectionsPage = new ConnectionsPage(driver);

        username = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("username");
        password = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("password");
        connectionIndex = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("connectionIndex");
        connectionCount = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("connectionCount");
        connectionName = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("connectionJob");
        connectionLocation = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("connectionLocation");
        fromUserGuid = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("fromUserGuid");
        toUserGuid = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("toUserGuid");
        token = (String) TestDataImporter.get("HourlyConnections", "testHourlyConnections").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);

        System.out.println("Starting hourly profile test!");
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);
        seasonedRestAPI.updateConnectionRequest(fromUserGuid, toUserGuid);
    }

    @Test
    public void testHourlyConnections() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile */
        navPage.navigateToProfilePage();
        profilePage.isConnectionsTitleTxtPresent();
        Assert.assertEquals(profilePage.getConnectionsCount(), connectionCount);
        Assert.assertTrue(profilePage.isConnectionsPhotoPresent(connectionIndex));

        /* Navigate to the hourly connections page */
        profilePage.clickViewAllConnections();
        /*navPage.waitForActivtyIndicator();*/

        /* Verify connection card in connections list */
        Assert.assertTrue(connectionsPage.isConnectionPhotoPresent(connectionIndex));
        Assert.assertEquals(connectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(connectionsPage.getConnectionLocation(connectionIndex), connectionLocation);

        /* View connection's profile */
        connectionsPage.clickConnectionViewButton(connectionIndex);
        /*navPage.waitForActivtyIndicator();*/

        /* Verify connection's profile displays */
        Assert.assertTrue(profilePage.isDisconnectButtonPresent());
        Assert.assertTrue(profilePage.isUserProfilePhotoPresent());
        Assert.assertEquals(profilePage.getFirstAndLastNameTxt(), connectionName);
        Assert.assertEquals(profilePage.getLocationTxt(), connectionLocation);

        /* Click 'Back' to return to logged in user's profile */
        profilePage.clickPublicProfileViewBackBtn();
        /*navPage.waitForActivtyIndicator();*/
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly connections test");
        navPage.attemptLogout();
        driver.quit();
    }
}
