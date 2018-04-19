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
    private String usernameEmptyState;
    private String password;
    private String connectionIndex;
    private String connectionCount;
    private String connectionName;
    private String connectionJob;
    private String connectionCity;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws Exception {
        System.out.println("Initializing hourly profile Connections test...");
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyNetworkMyConnectionsPage = new HourlyNetworkMyConnectionsPage(driver);

        username = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("username");
        usernameEmptyState = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("usernameEmptyState");
        password = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("password");
        connectionIndex = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionIndex");
        connectionCount = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionCount");
        connectionName = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionName");
        connectionJob = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionJob");
        connectionCity = (String) TestDataImporter.get("HourlyProfileConnections", "HourlyProfileConnections").get("connectionCity");

        System.out.println("Starting hourly profile Connections test!");
    }

    @Test
    public void testHourlyProfileConnections() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify connection's info */
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "The connection card should be visible if user has >= 1 connection");        Assert.assertEquals(hourlyProfileViewPage.getConnectionsCount(), connectionCount);
        Assert.assertTrue(hourlyProfileViewPage.isConnectionsPhotoPresent(connectionIndex), "The connection's photo should be displayed");
        Assert.assertEquals(hourlyProfileViewPage.getConnectionsName(connectionIndex), connectionName);

        /* Navigate to the hourly connections page */
        hourlyProfileViewPage.clickViewAllConnections();

        /* Verify connection's card is displayed */
        Assert.assertTrue(hourlyNetworkMyConnectionsPage.isConnectionPhotoDisplayed(connectionIndex), "The connection's photo should be displayed");
//        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionName(connectionIndex), connectionName + ", " + connectionCity);
//        Assert.assertEquals(hourlyNetworkMyConnectionsPage.getConnectionJob(connectionIndex), connectionJob);
    }

    @Test
    public void testHourlyProfileEmptyConnections() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmptyState, password);

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* The connection card should not be visible if user has 0 connections */
        Assert.assertFalse(hourlyProfileViewPage.isConnectionsTitleTxtPresent(), "The connection card should not be visible if user has 0 connections");
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
