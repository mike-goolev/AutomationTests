import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ContentFeedPage extends BasePage {
    Locators.ContentPageLocators contentPageLocators;
    NavPage navPage;


    public ContentFeedPage(WebDriver driver) {
        super(driver);
        contentPageLocators = new Locators.ContentPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Gets the My Home header text
     * @return The My Home header text
     */
    public String getMyHomeHeader() {
        return driver.findElement(contentPageLocators.myHomeHeaderTxt).getText();
    }

    /**
     * Clicks the article to view in a new tab/window
     * @param index The index of the article to select
     */
    public void viewArticle(String index){
        wait.until(elementToBeClickable(contentPageLocators.artcleTitleTxtByIndex(index)));
        driver.findElement(contentPageLocators.artcleTitleTxtByIndex(index)).click();
    }

    /**
     * Verifies that the article's image is displayed
     * @param index The index (Starting at 0) of the article image you wish to locate
     * @return Whether or not the article's image is displayed
     */
    public boolean isArticleImageDisplayed(String index) {
        return elementExistsLongTimeout(contentPageLocators.articleImgByIndex(index));
    }

    /**
     * Gets the article's title
     * @param index The index (Starting at 0) of the article title you wish to locate
     * @return The article's title
     */
    public String getArticleTitle(String index) {
        return driver.findElement(contentPageLocators.artcleTitleTxtByIndex(index)).getText();
    }

    /**
     * Gets the article's site name
     * @param index The index (Starting at 0) of the article site name you wish to locate
     * @return The article's site name
     */
    public String getArticleSiteName(String index) {
        return driver.findElement(contentPageLocators.articleSiteTxtByIndex(index)).getText();
    }

    /**
     * Verifies that the article's publisher image is displayed
     * @param index The index (Starting at 0) of the article publisher image you wish to locate
     * @return Whether or not the article's publisher image is displayed
     */
    public boolean isArticlePublisherImageDisplayed(String index) {
        return elementExistsLongTimeout(contentPageLocators.articlePublisherImgByIndex(index));
    }

    /**
     * Gets the article's publisher name
     * @param index The index (Starting at 0) of the article publisher name you wish to locate
     * @return The article's publisher name
     */
    public String getArticlePublisherName(String index) {
        return driver.findElement(contentPageLocators.articlePublisherNameTxtByIndex(index)).getText();
    }

    /**
     * Gets the article's published date
     * @param index The index (Starting at 0) of the article published date you wish to locate
     * @return The article's published date
     */
    public String getArticlePublishedDate(String index) {
        return driver.findElement(contentPageLocators.articlePublishedDateTxtByIndex(index)).getText();
    }

    /**
     * Verifies that the article's like button is displayed
     * @param index The index (Starting at 0) of the article like button you wish to locate
     * @return Whether or not the article's like button is displayed
     */
    public boolean isArticleLikeButtonDisplayed(String index) {
        return elementExists(contentPageLocators.articleLikeBtnByIndex(index));
    }

    /**
     * Clicks an article's like button
     * @param index The index of the article like button to select
     */
    public void clickArticleLikeButton(String index){
        wait.until(elementToBeClickable(contentPageLocators.articleLikeBtnByIndex(index)));
        driver.findElement(contentPageLocators.articleLikeBtnByIndex(index)).click();
    }


    /**
     * Gets the article's like count
     * @param index The index (Starting at 0) of the article like count you wish to locate
     * @return The article's like count
     */
    public String getArticleLikeCount(String index) {
        return driver.findElement(contentPageLocators.articleLikeCountTxtByIndex(index)).getText();
    }

    /**
     * Verifies that the trending article header is displayed
     * @return Whether or not the trending article title is displayed
     */
    public boolean isTrendingArticleHeaderDisplayed() {
        return elementExists(contentPageLocators.trendingTitle);
    }

    /**
     * Verifies that the trending article's image is displayed
     * @param index The index (Starting at 0) of the trending article image you wish to locate
     * @return Whether or not the trending article's image is displayed
     */
    public boolean isTrendingArticleImageDisplayed(String index) {
        return elementExists(contentPageLocators.articlePublisherImgByIndex(index));
    }
}
