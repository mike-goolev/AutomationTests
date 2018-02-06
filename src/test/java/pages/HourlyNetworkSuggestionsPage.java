package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HourlyNetworkSuggestionsPage extends BasePage {

    Locators.HourlyNetworkPageLocators hourlyNetworkPageLocators;
    NavPage navPage;
    Locators.ProfilePageLocators profilePageLocators;


    public HourlyNetworkSuggestionsPage(WebDriver driver) {
        super(driver);
        hourlyNetworkPageLocators = new Locators.HourlyNetworkPageLocators();
        profilePageLocators = new Locators.ProfilePageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the suggested connection's photo is displayed

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not the suggested connection's photo is displayed
     */
    public boolean isSuggestedConnectionsPhotoDisplayed(String index) {
        return elementExists(hourlyNetworkPageLocators.findSuggestionCardImgByIndex(index));
    }

    /**
     * Get suggested connection's name

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The suggested connection's name
     */
    public String getSuggestedConnectionsName(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findSuggestionCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get suggested connection's reason

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The suggested connection's reason
     */
    public String getSuggestedConnectionReason(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findSuggestionCardReasonTxtByIndex(index)).getText();
    }

    /**
     * Clicks a suggested connection's view button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsViewButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findSuggestionCardViewBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findSuggestionCardViewBtnByIndex(index)).click();
        wait.until(visibilityOfElementLocated(profilePageLocators.personInfoUserPhotoImg));
    }

    /**
     * Clicks a suggested connection's connect button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsConnectButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findSuggestionCardConnectBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findSuggestionCardConnectBtnByIndex(index)).click();
    }
}
