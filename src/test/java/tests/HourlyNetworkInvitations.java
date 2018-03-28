package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import sql.SqlSelects;
import utils.TestDataImporter;
import restInterfaces.*;

import java.sql.SQLException;

public class HourlyNetworkInvitations extends BaseTest {

    private HourlyLoginPage hourlyLoginPage;
    //private HourlyNetworkInvitationsPage hourlyNetworkInvitationsPage;
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
    //private String invitationsEmptyTitle;
    //private String invitationsEmptyTxt;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;
    private String tokenFrom;

    @BeforeMethod(dependsOnMethods = {"setUpMain"}, groups = { "smoketests" })
    public void setUp() throws SQLException {
        System.out.println("Initializing hourly network invitations test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
       // hourlyNetworkInvitationsPage = new HourlyNetworkInvitationsPage(driver);
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
        //invitationsEmptyTitle = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationsEmptyTitle");
        //invitationsEmptyTxt = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("invitationsEmptyTxt");

        SqlSelects sqlNew = new SqlSelects();
        fromUserGuid = sqlNew.getUserGUIDByEmail((String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("username"));
        // fromUserGuid = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("fromUserGuid");
        toUserGuid = sqlNew.getUserGUIDByEmail((String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("fromUserEmail"));
       // toUserGuid = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("toUserGuid");

      //  token = (String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("token");
        SeasonedRestAPI seasonedRestAPIforToken = new SeasonedRestAPI();
        token = "Bearer " + seasonedRestAPIforToken.getToken((String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("username"),(String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("password"));
        tokenFrom = "Bearer " + seasonedRestAPIforToken.getToken((String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("fromUserEmail"),(String) TestDataImporter.get("HourlyNetworkInvitations", "HourlyNetworkInvitations").get("fromUserPassword"));

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
        navPage.navigateToGetConnectedPage();

        /* Verify invitations empty state */
        Assert.assertFalse(hourlyNetworkPage.getNoInvitations());
        //Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyTitleText(), invitationsEmptyTitle);
        //Assert.assertEquals(hourlyNetworkInvitationsPage.getInvitationEmptyText(), invitationsEmptyTxt);

        /* Create a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(tokenFrom);
        seasonedRestAPI.postConnectionRequest(toUserGuid, fromUserGuid);

        /* Navigate to My Connections */
        navPage.navigateToJobsPage();
        navPage.navigateToGetConnectedPage();

        /* Verify invitation is displayed on Get Connections Invitations section */
        //  driver.navigate().refresh();
        Thread.sleep(6000);
        Assert.assertEquals(hourlyNetworkPage.getInvitationsCount(), invitationCount);
        Assert.assertTrue(hourlyNetworkPage.isInvitationPhotoDisplayed(invitationIndex));
        Assert.assertEquals(hourlyNetworkPage.getInvitationName(invitationIndex), invitationName);
        Assert.assertEquals(hourlyNetworkPage.getInvitationJob(invitationIndex), invitationJob);


        /* Accept connection request */
        hourlyNetworkPage.clickInvitationConnectBtn(invitationIndex);

        /* Verify invitations empty state */
        Thread.sleep(3000);
        Assert.assertFalse(hourlyNetworkPage.getNoInvitations());

        /* Navigate to my connections */
        hourlyNetworkPage.clickNetworkMyConnections();

        /* Verify connection accepted */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex));
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);

    }

    @Test(groups = { "smoketests" })
    public void testHourlyNetworkInvitationsFunc() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to My Connections */
        navPage.navigateToGetConnectedPage();

        /* Verify invitations empty state
        check  "Invitation Requests" section is not displayed  */
        Assert.assertFalse(hourlyNetworkPage.getNoInvitations());

        /* Create a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(tokenFrom);
        seasonedRestAPI.postConnectionRequest(toUserGuid, fromUserGuid);

        /* Navigate to My Connections */
        navPage.navigateToJobsPage();
        navPage.navigateToGetConnectedPage();

        /* Verify invitation is displayed on My Connections Invitations section */
        driver.navigate().refresh();
        Assert.assertEquals(hourlyNetworkPage.getInvitationsCount(), invitationCount);
    }

    @AfterMethod(groups = { "smoketests" })
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly network Invitations test");
        navPage.attemptLogout();
        driver.quit();
    }
}
