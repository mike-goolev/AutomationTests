package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyNetworkInvitationsPage extends BasePage {

    Locators.HourlyNetworkPageLocators hourlyNetworkPageLocators;
    NavPage navPage;


    public HourlyNetworkInvitationsPage(WebDriver driver) {
        super(driver);
        hourlyNetworkPageLocators = new Locators.HourlyNetworkPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the invitation's photo is displayed

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return Whether or not the invitation's photo is displayed
     */
    public boolean isInvitationPhotoDisplayed(String index) {
        return elementExists(hourlyNetworkPageLocators.findInvitationCardImgByIndex(index));
    }

    /**
     * Get invitation's job

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return The invitation's job
     */
    public String getInvitationJob(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationCardJobTxtByIndex(index)).getText();
    }

    /**
     * Get invitation's name

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return The invitation's name
     */
    public String getInvitationName(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationCardNameTxtByIndex(index)).getText();
    }

    /**
     * Clicks an invitation's ignore button

     * @param index The index (Starting at 0) of the invitation you wish to locate
     */
    public void clickInvitationIgnoreButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationCardIgnoreBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationCardIgnoreBtnByIndex(index)).click();
    }

    /**
     * Clicks an invitation's connect button

     * @param index The index (Starting at 0) of the invitation you wish to locate
     */
    public void clickInvitationConnectButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationCardConnectBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationCardConnectBtnByIndex(index)).click();
    }

    /**
     * Get invitation empty title text

     * @return The invitation title text
     */
    public String getInvitationEmptyTitleText() {
        return driver.findElement(hourlyNetworkPageLocators.invitationEmptyTitleTxt).getText();
    }

    /**
     * Get invitation empty text

     * @return The invitation empty text
     */
    public String getInvitationEmptyText() {
        return driver.findElement(hourlyNetworkPageLocators.invitationEmptyTxt).getText();
    }

    /**
     * Clicks empty invitation's suggested connections button
     */
    public void clickSuggestionsButton() {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.invitationEmptySuggestionsBtn));
        driver.findElement(hourlyNetworkPageLocators.invitationEmptySuggestionsBtn).click();
    }
}
