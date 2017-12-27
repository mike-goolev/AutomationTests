import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class HourlyMyHome extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyContentFeedPage hourlyContentFeedPage;

    private String firstName;
    private String username;
    private String password;
    private String url;
    private String siteName;
    private String imageUrl;
    private String imageUrlGif;
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
        System.out.println("Initializing hourly content feed test test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyContentFeedPage = new HourlyContentFeedPage(driver);

        firstName = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("firstName");
        username = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("username");
        password = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("password");
        token = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("token");
        url = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("url");
        siteName = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("siteName");
        imageUrl = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("imageUrl");
        imageUrlGif = (String) TestDataImporter.get("HourlyMyHome", "testHourlyHomeContentFeed").get("imageUrlGif");
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
        seasonedRestAPI.updateArticlePublishedStatus(articleGuid, url, siteName, imageUrlGif, title, description, publishedDate, createdDate, updatedDate, publisherId, labels);
        System.out.println("Starting hourly content feed test!");
    }

    @Test
    public void testHourlyMyHomeContentFeed() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to My Home */
        navPage.navigateToMyHomePage();

        /* Verify My Home header */
        Assert.assertEquals(hourlyContentFeedPage.getMyHomeHeader(), "Hi " + firstName + ", Can we get you started with some news?");
        hourlyContentFeedPage.waitForLoadingIndicator();

        /* Verify article attributes */
        Assert.assertTrue(hourlyContentFeedPage.isArticleImageDisplayed(articleIndex), "Article image should be displayed");
        Assert.assertEquals(hourlyContentFeedPage.getArticleTitle(articleIndex), title);
        Assert.assertEquals(hourlyContentFeedPage.getArticleSiteName(articleIndex), siteName);
        Assert.assertTrue(hourlyContentFeedPage.isArticlePublisherImageDisplayed(articleIndex), "Article publisher image should be displayed");
        Assert.assertEquals(hourlyContentFeedPage.getArticlePublisherName(articleIndex), publisherName);
        Assert.assertEquals(hourlyContentFeedPage.getArticlePublishedDate(articleIndex), "Just now");
        Assert.assertTrue(hourlyContentFeedPage.isArticleLikeButtonDisplayed(articleIndex), "Article like button should be displayed");
        Assert.assertEquals(hourlyContentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount0);

        /* Like article */
        hourlyContentFeedPage.clickArticleLikeButton(articleIndex);
        Thread.sleep(2000);
        Assert.assertEquals(hourlyContentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount1);
        
        /* Unlike article */
        hourlyContentFeedPage.clickArticleLikeButton(articleIndex);
        Thread.sleep(2000);
        Assert.assertEquals(hourlyContentFeedPage.getArticleLikeCount(articleIndex), articleLikeCount0);

        /* View article */
        hourlyContentFeedPage.viewArticle(articleIndex);

        /* Switch to new window */
        parentWindow = driver.getWindowHandle();
        testUtils.switchToNewWindow(parentWindow);
        Assert.assertEquals(driver.getTitle(), title);

        /* Switch back to content page */
        testUtils.switchToParentWindow(parentWindow);
    }

    @AfterClass
    public void deleteArticle() {
        System.out.println("Logging out and shutting down selenium for the hourly content feed test");
        navPage.attemptLogout();
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteArticle(articleGuid);
        driver.quit();
    }
}
