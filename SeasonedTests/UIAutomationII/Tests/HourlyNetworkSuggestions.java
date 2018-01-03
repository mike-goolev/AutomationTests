import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyNetworkSuggestions extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyNetworkSuggestionsPage hourlyNetworkSuggestionsPage;
    private HourlyNetworkPage hourlyNetworkPage;

    private String username;
    private String password;
    private String suggestionIndex;
    private String suggestionName;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly network Suggestions test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
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
        navPage.navigateToNetworkSuggestedConnectionsPage();

        /* Verify suggested connection card */
        Assert.assertTrue(hourlyNetworkSuggestionsPage.isSuggestedConnectionsPhotoDisplayed(suggestionIndex), "Suggested connection's photo should be displayed");
        suggestionName = hourlyNetworkSuggestionsPage.getSuggestedConnectionsName(suggestionIndex);
        System.out.println("Suggestion name: " + suggestionName);

        /* View suggested connection at specified index */
        hourlyNetworkSuggestionsPage.clickSuggestedConnectionsViewButton(suggestionIndex);

        /* Navigate to Get Connected page */
        navPage.navigateToNetworkSuggestedConnectionsPage();

        /* Send suggested connection at specified index a connection request */
        hourlyNetworkSuggestionsPage.clickSuggestedConnectionsConnectButton(suggestionIndex);
        Thread.sleep(2000);

        /* Verify user removed from list of connections */
        Assert.assertNotEquals(hourlyNetworkSuggestionsPage.getSuggestedConnectionsName(suggestionIndex), suggestionName);

        /* Search for user and view profile */
        hourlyNetworkPage.submitUserSearchByName(suggestionName);

        /* Cancel pending connection request */
        hourlyProfileViewPage.clickCancelConnectionRequestBtn();

        /* Return to suggested connections */
        navPage.navigateToNetworkSuggestedConnectionsPage();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly network Suggestions test");
        navPage.attemptLogout();
        driver.quit();
    }
}
