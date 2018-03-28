package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;

public class HourlyNetworkSuggestions extends BaseTest {

    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyNetworkSuggestionsPage hourlyNetworkSuggestionsPage;
    private HourlyNetworkPage hourlyNetworkPage;

    private String username;
    private String password;
    private String suggestionIndex;
    private String suggestionName;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        System.out.println("Initializing hourly network Suggestions test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyNetworkSuggestionsPage = new HourlyNetworkSuggestionsPage(driver);
        hourlyNetworkPage = new HourlyNetworkPage(driver);

        username = (String) TestDataImporter.get("HourlyNetworkSuggestions", "HourlyNetworkSuggestions").get("username");
        password = (String) TestDataImporter.get("HourlyNetworkSuggestions", "HourlyNetworkSuggestions").get("password");
        suggestionIndex = (String) TestDataImporter.get("HourlyNetworkSuggestions", "HourlyNetworkSuggestions").get("suggestionIndex");
    }

    @Test
    public void testHourlyNetworkSuggestions() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to Get Connected page */
        navPage.navigateToGetConnectedPage();

        /* Verify suggested connection card */
        Assert.assertTrue(hourlyNetworkSuggestionsPage.isSuggestedConnectionsPhotoDisplayed(suggestionIndex), "Suggested connection's photo should be displayed");
        suggestionName = hourlyNetworkSuggestionsPage.getSuggestedConnectionsName(suggestionIndex);
        System.out.println("Suggestion name: " + suggestionName);

        /* View suggested connection at specified index */
        hourlyNetworkSuggestionsPage.clickSuggestedConnectionsBox(suggestionIndex);

        /* Navigate to Get Connected page */
        navPage.navigateToGetConnectedPage();

        /* Send suggested connection at specified index a connection request */
        hourlyNetworkSuggestionsPage.clickSuggestedConnectionsConnectButton(suggestionIndex);
        Thread.sleep(2000);

        /* Verify user removed from list of connections */
        Assert.assertNotEquals(hourlyNetworkSuggestionsPage.getSuggestedConnectionsName(suggestionIndex), suggestionName);

        /* Search for user and view profile */
        hourlyNetworkPage.submitUserSearchByName(suggestionName, "0");
        hourlyNetworkPage.selectMemberSearchResult("0");

        /* Cancel pending connection request */
        //Will fail until the "Connect" issue is solver - network improvements FBR
        hourlyProfileViewPage.clickCancelConnectionRequestBtn();

        /* Return to suggested connections */
        navPage.navigateToGetConnectedPage();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly network Suggestions test");
        navPage.attemptLogout();
        driver.quit();
    }
}
