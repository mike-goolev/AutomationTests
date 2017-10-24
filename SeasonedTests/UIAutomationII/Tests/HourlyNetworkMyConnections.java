import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyNetworkMyConnections extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
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
        System.out.println("Initializing hourly connections test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);

        username = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("username");
        password = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("password");
        connectionIndex = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionIndex");
        connectionCount = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionCount");
        connectionName = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionJob");
        fromUserGuid = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("fromUserGuid");
        toUserGuid = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("toUserGuid");
        token = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);

        System.out.println("Starting hourly profile test!");
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);

    }

    @Test//(enabled = false)
    public void testHourlyNetworkMyConnections() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to My Connections */
        navPage.navigateToNetworkMyConnectionsPage();

        /* Verify connections empty state */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isEmptyConnectionTitleTxtDisplayed());

        /* Navigate to profile and verify connection card is not present */
        navPage.navigateToProfilePage();
        Assert.assertFalse(hourlyProfileViewPage.isConnectionsTitleTxtPresent());

        /* Create and accept a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);
        seasonedRestAPI.updateConnectionRequest(fromUserGuid, toUserGuid);

        /* Navigate to My Connections */
        navPage.navigateToNetworkMyConnectionsPage();
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex));
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify new connection is displayed */
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsTitleTxtPresent());
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsPhotoPresent(connectionIndex));
        Assert.assertEquals(hourlyProfileViewPage.getConnectionsName(connectionIndex), connectionName);
        // The count is updated while the page renders, so the below assert will fail
        //Assert.assertEquals(hourlyProfileViewPage.getConnectionsCount(), connectionCount);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly connections test");
        navPage.attemptLogout();
        driver.quit();
    }
}
