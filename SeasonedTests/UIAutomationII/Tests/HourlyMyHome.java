import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class HourlyMyHome extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ContentFeedPage contentFeedPage;

    private String firstName;
    private String username;
    private String password;
    private String url;
    private String siteName;
    private String imageUrl;
    private String title;
    private String description;
    private ArrayList labels;
    private String token;
    private String articleGuid;
    private Long publishedDate;
    private Long createdDate;
    private Long updatedDate;
    private String publisherId;
    private String publisherName;
    private String articleIndex;
    private String articleLikeCount0;
    private String articleLikeCount1;
    private String parentWindow;

    @BeforeClass
    public void initializeTestDataAndCreateArticle() {
        driver = BrowserFactory.getDriver("firefox");        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        contentFeedPage = new ContentFeedPage(driver);

        firstName = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("firstName");
        username = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("username");
        password = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("password");
        token = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("token");
        url = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("url");
        siteName = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("siteName");
        imageUrl = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("imageUrl");
        title = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("title");
        description = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("description");
        publisherId = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("publisherId");
        labels = (ArrayList) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("labels");
        articleIndex = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("articleIndex");
        articleLikeCount0 = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("articleLikeCount0");
        articleLikeCount1 = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("articleLikeCount1");
        publisherName = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("publisherName");
        publishedDate = System.currentTimeMillis();
        createdDate = System.currentTimeMillis();
        updatedDate = System.currentTimeMillis();

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        articleGuid = seasonedRestAPI.postArticle(url, siteName, imageUrl, title, description, labels);
        seasonedRestAPI.updateArticlePublishedStatus(articleGuid, url, siteName, imageUrl, title, description, publishedDate, createdDate, updatedDate, publisherId, labels);
    }

    @BeforeMethod
    public void setUp() {
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        contentFeedPage = new ContentFeedPage(driver);
    }

    @Test
    public void testHourlyMyHomeContentFeed() throws Exception {
        System.out.println("Starting hourly content feed test!");
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to My Home */
        navPage.navigateToMyHomePage();

        /* Verify My Home header */
        Assert.assertEquals(contentFeedPage.getMyHomeHeader(), "Hi " + firstName + ", we have some articles that we think you may like.");
        // Explicit wait for certs to load and display until we have loading indicators
        Thread.sleep(2000);

        /* Verify article attributes */
        Assert.assertEquals(contentFeedPage.getArticleTitle(articleIndex), title);
        Assert.assertEquals(contentFeedPage.getArticleSiteName(articleIndex), siteName);
        Assert.assertTrue(contentFeedPage.isArticleImageDisplayed(articleIndex), "Article image should be displayed");
        Assert.assertTrue(contentFeedPage.isArticlePublisherImageDisplayed(articleIndex), "Article publisher image should be displayed");
        Assert.assertEquals(contentFeedPage.getArticlePublisherName(articleIndex), publisherName);
        Assert.assertEquals(contentFeedPage.getArticlePublishedDate(articleIndex), "Just now");
        Assert.assertTrue(contentFeedPage.isArticleLikeButtonDisplayed(articleIndex), "Article like button should be displayed");
        Assert.assertEquals(contentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount0);

        /* Like article */
        contentFeedPage.clickArticleLikeButton(articleIndex);
        Thread.sleep(2000);
        Assert.assertEquals(contentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount1);
        
        /* Unlike article */
        contentFeedPage.clickArticleLikeButton(articleIndex);
        Thread.sleep(2000);
        Assert.assertEquals(contentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount0);

        /* View article */
        contentFeedPage.viewArticle(articleIndex);

        /* Switch to new window */
        parentWindow = driver.getWindowHandle();
        testUtils.switchToNewWindow(parentWindow);
        Assert.assertEquals(driver.getTitle(), title);

        /* Switch back to content page */
        testUtils.switchToParentWindow(parentWindow);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly My Home test");
        navPage.attemptLogout();
        driver.quit();
    }

    @AfterClass
    public void deleteArticle() {
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteArticle(articleGuid);
    }
}
