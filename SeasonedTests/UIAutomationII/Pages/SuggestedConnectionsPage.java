import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SuggestedConnectionsPage extends BasePage {

    Locators.HourlySuggestedConnectionPageLocators hourlySuggestedConnectionPageLocators;
    NavPage navPage;


    public SuggestedConnectionsPage(WebDriver driver) {
        super(driver);
        hourlySuggestedConnectionPageLocators = new Locators.HourlySuggestedConnectionPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the suggested connection's photo is displayed
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not the suggested connection's photo is displayed
     */
    public boolean isSuggestedConnectionsPhotoPresent(String index) {
        return elementExists(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardImgByIndex(index));
    }

    /**
     * Get suggested connection's name
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The suggested connection's name
     */
    public String getSuggestedConnectionsName(String index) {
        return driver.findElement(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get suggested connection's reason
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The suggested connection's reason
     */
    public String getSuggestedConnectionsReason(String index) {
        return driver.findElement(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardReasonTxtByIndex(index)).getText();
    }

    /**
     * Clicks a suggested connection's view button
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsViewButton(String index) {
        wait.until(elementToBeClickable(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardViewBtnByIndex(index)));
        driver.findElement(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardViewBtnByIndex(index)).click();
    }

    /**
     * Clicks a suggested connection's connect button
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsConnectButton(String index) {
        wait.until(elementToBeClickable(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardConnectBtnByIndex(index)));
        driver.findElement(hourlySuggestedConnectionPageLocators.findSuggestedConnectionCardConnectBtnByIndex(index)).click();
    }

    /**
     * Clicks back button to return to user profile
     */
    public void clickSuggestedConnectionsBackButton() {
        wait.until(elementToBeClickable(hourlySuggestedConnectionPageLocators.suggestedConnectionBackBtn));
        driver.findElement(hourlySuggestedConnectionPageLocators.suggestedConnectionBackBtn).click();
    }
}
