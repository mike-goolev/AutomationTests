package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;

public class HourlyProfileConnections extends BaseTest {

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

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        System.out.println("Initializing hourly profile Connections test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
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
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);
        System.out.println("Starting hourly profile Connections test!");
    }

    @Test
    public void testViewHourlyProfileConnections() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* The connection card should not be visible if user has 0 connections */
        Assert.assertFalse(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "The connection card should not be visible if user has 0 connections");

        /* Navigate to connections page and verify the empty connection state */
        navPage.navigateToNetworkMyConnectionsPage();
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isEmptyConnectionTitleTxtDisplayed(), "The empty connections state title should be displayed");

        /* Create and accept a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);
        Thread.sleep(2000);
        seasonedRestAPI.updateConnectionRequest(fromUserGuid, toUserGuid);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify new connection is displayed */
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "The connection title should be displayed");
        Assert.assertEquals(hourlyProfileViewPage.getConnectionsCount(), connectionCount);
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsPhotoPresent(connectionIndex), "The connection's photo should be displayed");
        Assert.assertEquals(hourlyProfileViewPage.getConnectionsName(connectionIndex), connectionName);

        /* Navigate to the hourly connections page */
        hourlyProfileViewPage.clickViewAllConnections();

        /* Verify connection's card is displayed */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex), "The connection's photo should be displayed");
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly profile connections test");
        navPage.attemptLogout();
        driver.quit();
    }
}
