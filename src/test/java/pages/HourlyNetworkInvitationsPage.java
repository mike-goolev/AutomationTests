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

}
