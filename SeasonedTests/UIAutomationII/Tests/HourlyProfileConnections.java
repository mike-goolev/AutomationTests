import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyProfileConnections extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private HourlyNetworkMyConnectionsPage hourlyNetworkMyConnectionsPage;

    private String username;
    private String password;
    private String connectionIndex;
    private String connectionCount;
    private String connectionName;
    private String connectionJob;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly profile Connections test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);

        username = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("username");
        password = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("password");
        connectionIndex = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionIndex");
        connectionCount = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionCount");
        connectionName = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionJob");
        fromUserGuid = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("fromUserGuid");
        toUserGuid = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("toUserGuid");
        token = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);

        System.out.println("Starting hourly profile Connections test!");
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);
    }

    @Test//(enabled = false)
    public void viewHourlyProfileConnections() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* The connection card should not be visible if user has 0 connections */
        Assert.assertFalse(profilePage.isConnectionsTitleTxtPresent());

        /* Navigate to connections page and verify the empty connection state */
        navPage.navigateToNetworkMyConnectionsPage();
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isEmptyConnectionTitleTxtDisplayed());

        /* Create and accept a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);
        seasonedRestAPI.updateConnectionRequest(fromUserGuid, toUserGuid);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify new connection is displayed */
        Assert.assertTrue(profilePage.isConnectionsTitleTxtPresent());
        Assert.assertEquals(profilePage.getConnectionsCount(), connectionCount);
        Assert.assertTrue(profilePage.isConnectionsPhotoPresent(connectionIndex));
        Assert.assertEquals(profilePage.getConnectionsName(connectionIndex), connectionName);

        /* Navigate to the hourly connections page */
        profilePage.clickViewAllConnections();

        /* Verify connection's card is displayed */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex));
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly profile connections test");
        navPage.attemptLogout();
        driver.quit();
    }
}
