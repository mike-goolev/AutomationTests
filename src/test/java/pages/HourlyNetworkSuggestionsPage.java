package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.util.List;

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
        return driver.findElement(hourlyNetworkPageLocators.findSuggestionCardLinkbyIndex(index)).findElement(hourlyNetworkPageLocators.findSuggestionCardNameTxtByIndex).getText();
    }

    /**
     * Get suggested connection's reason
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The suggested connection's reason
     */
    //TODO
    public String getSuggestedConnectionReason(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findSuggestionCardReasonTxtByIndex(index)).getText();
    }

    /**
     * Clicks a suggested connection's view button
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsViewButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findSuggestionCardLinkbyIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findSuggestionCardLinkbyIndex(index)).click();
        wait.until(visibilityOfElementLocated(profilePageLocators.personInfoUserPhotoImg));
    }

    /**
     * Clicks a suggested connection's connect button
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsConnectButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findSuggestionCardLinkbyIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findSuggestionCardLinkbyIndex(index)).findElement(hourlyNetworkPageLocators.findSuggestionCardConnectBtnByIndex).click();
    }

    /**
     * Clicks a suggested connection's Image
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickSuggestedConnectionsBox(String index) {

       // List<WebElement> elem = driver.findElements(By.xpath("//div[@class='row ']/*"));
      // elem.get(Integer.valueOf(index)).click();
        driver.findElement(hourlyNetworkPageLocators.findSuggestionCardImgByIndex(index)).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(visibilityOfElementLocated(profilePageLocators.personInfoUserPhotoImg));
    }
}
