import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class HourlyNetworkInvitations extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyNetworkInvitationsPage hourlyNetworkInvitationsPage;
    private HourlyNetworkMyConnectionsPage hourlyNetworkMyConnectionsPage;
    private HourlyNetworkPage hourlyNetworkPage;

    private String username;
    private String password;
    private String invitationIndex;
    private String invitationName;
    private String invitationJob;
    private String invitationCount;
    private String connectionIndex;
    private String connectionName;
    private String connectionJob;
    private String invitationsEmptyTitle;
    private String invitationsEmptyTxt;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;

    @BeforeClass
    public void setUp() throws SQLException {
        System.out.println("Initializing hourly network invitations test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyNetworkInvitationsPage = new HourlyNetworkInvitationsPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);
        hourlyNetworkPage = new HourlyNetworkPage(driver);

        username = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("username");
        password = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("password");
        invitationIndex = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationIndex");
        invitationName = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationName");
        invitationJob = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationJob");
        invitationCount = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationCount");
        connectionIndex = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("connectionIndex");
        connectionName = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("connectionJob");
        invitationsEmptyTitle = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationsEmptyTitle");
        invitationsEmptyTxt = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationsEmptyTxt");
        fromUserGuid = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("fromUserGuid");
        toUserGuid = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("toUserGuid");
        token = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("token");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);
        System.out.println("Starting hourly network Invitations test!");
    }

    @Test
    public void testHourlyNetworkInvitations() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to My Connections */
        navPage.navigateToNetworkInvitationsPage();

        /* Verify invitations empty state */
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyTitleText(), invitationsEmptyTitle);
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyText(), invitationsEmptyTxt);

        /* Create a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);

        /* Navigate to My Connections */
        hourlyNetworkPage.clickNetworkMyConnections();

        /* Verify invitation is displayed on My Connections Invitations section */
        Assert.assertEquals(hourlyNetworkPage.getInvitationCount(), invitationCount);
        Assert.assertTrue(hourlyNetworkPage.isInvitationPhotoDisplayed(invitationIndex));
        Assert.assertEquals(hourlyNetworkPage.getInvitationName(invitationIndex), invitationName);
        Assert.assertEquals(hourlyNetworkPage.getInvitationJob(invitationIndex), invitationJob);

        /* Navigate to network invitations page */
        hourlyNetworkPage.clickNetworkInvitations();

        /* Verify invitation is displayed */
        Assert.assertTrue(hourlyNetworkInvitationsPage.isInvitationPhotoDisplayed(invitationIndex));
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationName(invitationIndex), invitationName);
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationJob(invitationIndex), invitationJob);

        /* Accept connection request */
        hourlyNetworkInvitationsPage.clickInvitationConnectButton(invitationIndex);

        /* Verify invitations empty state */
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyTitleText(), invitationsEmptyTitle);
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyText(), invitationsEmptyTxt);

        /* Navigate to my connections */
        hourlyNetworkPage.clickNetworkMyConnections();

        /* Verify connection accepted */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex));
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);

        /* Navigate to invitations */
        hourlyNetworkPage.clickNetworkInvitations();

        /* Verify invitations empty state */
        Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyTitleText(), invitationsEmptyTitle);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly network Invitations test");
        navPage.attemptLogout();
        driver.quit();
    }
}