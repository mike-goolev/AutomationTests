import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BeSuccessfulPage extends BasePage {

    Locators.HourlyBeSuccessfulPageLocators hourlyBeSuccessfulPageLocators;

    public BeSuccessfulPage(WebDriver driver) {
        super(driver);
        hourlyBeSuccessfulPageLocators = new Locators.HourlyBeSuccessfulPageLocators();
    }

    /**
     * Verifies that the be successful header is displayed
     * @return Whether or not the be successful header is displayed
     */
    public boolean isHeaderDisplayed() {
        return elementExists(hourlyBeSuccessfulPageLocators.beSuccessfulTitleTxt);
    }
}
