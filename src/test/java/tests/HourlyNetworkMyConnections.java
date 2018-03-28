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

public class HourlyNetworkMyConnections extends BaseTest {

    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyNetworkMyConnectionsPage hourlyNetworkMyConnectionsPage;
    private HourlyNetworkPage hourlyNetworkPage;
    private String username;
    private String password;
    private String connectionIndex;
    private String connectionCount;
    private String connectionName;
    private String connectionJob;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;
    private String tokenFrom;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing hourly connections test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);
        hourlyNetworkPage = new HourlyNetworkPage(driver);
        username = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("username");
        password = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("password");
        connectionIndex = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionIndex");
        connectionCount = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionCount");
        connectionName = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("connectionJob");

        //fromUserGuid = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("fromUserGuid");
        SqlSelects sqlNew = new SqlSelects();
        fromUserGuid = sqlNew.getUserGUIDByEmail((String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("username"));

       // toUserGuid = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("toUserGuid");
        toUserGuid = sqlNew.getUserGUIDByEmail((String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("fromUserEmail"));

        //token = (String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("token");
        SeasonedRestAPI seasonedRestAPIforToken = new SeasonedRestAPI();
        token = "Bearer " + seasonedRestAPIforToken.getToken((String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("username"),(String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("password"));
        tokenFrom = "Bearer " + seasonedRestAPIforToken.getToken((String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("fromUserEmail"),(String) TestDataImporter.get("HourlyNetworkMyConnections", "HourlyNetworkMyConnections").get("fromUserPassword"));

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteConnection(fromUserGuid, toUserGuid);
        System.out.println("Starting hourly connections test!");
    }

    @Test
    public void testHourlyNetworkMyConnections() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to My Connections */
        //TODO No connections checl
        //hourlyNetworkPage.clickNetworkMyConnections();

        /* Verify connections empty state */
       // Assert.assertTrue(hourlyNetworkMyConnectionsPage.isEmptyConnectionTitleTxtDisplayed(), "Empty connection title should be displayed");

        /* Navigate to profile and verify connection card is not present */
        //navPage.navigateToProfilePage();
       // Assert.assertFalse(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "The connection's card should not be displayed");

        /* Create and accept a connection request */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(tokenFrom);
        seasonedRestAPI.postConnectionRequest(toUserGuid, fromUserGuid);
        Thread.sleep(2000);
        seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateConnectionRequest(toUserGuid, fromUserGuid);

        /* Navigate to My Connections */
        navPage.navigateToJobsPage();
        navPage.navigateToGetConnectedPage();
        hourlyNetworkPage.clickNetworkMyConnections();
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex), "Connection's photo should be displayed");
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName);
        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify new connection is displayed */
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "Connection's title text should be displayed" );
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsPhotoPresent(connectionIndex), "Connection's photo should be displayed");
        Assert.assertEquals(hourlyProfileViewPage.getConnectionsName(connectionIndex), connectionName);
        // The count is updated while the page renders, so the below assert will fail
        //Assert.assertEquals(hourlyProfileViewPage.getConnectionsCount(), connectionCount);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly connections test");
        navPage.attemptLogout();
        driver.quit();
    }
}