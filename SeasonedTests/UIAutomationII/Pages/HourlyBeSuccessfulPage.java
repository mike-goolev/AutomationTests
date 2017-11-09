import org.openqa.selenium.WebDriver;

public class HourlyBeSuccessfulPage extends BasePage {

    Locators.HourlyBeSuccessfulPageLocators hourlyBeSuccessfulPageLocators;

    public HourlyBeSuccessfulPage(WebDriver driver) {
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
