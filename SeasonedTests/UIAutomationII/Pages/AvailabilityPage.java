import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AvailabilityPage extends BasePage {

    Locators.AvailabilityPageLocators availabilityPageLocators;

    public AvailabilityPage(WebDriver driver) {
        super(driver);
        availabilityPageLocators = new Locators.AvailabilityPageLocators();
    }

    /**
     *  Set all availability from an empty state
     */
    public void selectAllAvailability() {
        wait.until(elementToBeClickable(availabilityPageLocators.morningCheckbox));
        driver.findElement(availabilityPageLocators.morningCheckbox).click();
        driver.findElement(availabilityPageLocators.afternoonCheckbox).click();
        driver.findElement(availabilityPageLocators.eveningCheckbox).click();
        driver.findElement(availabilityPageLocators.nightsCheckbox).click();
        driver.findElement(availabilityPageLocators.saveBtn).click();
    }

    /**
     * Remove all availability from a state where every checkbox is selected
     */
    public void removeAllAvailability() {
        wait.until(elementToBeClickable(availabilityPageLocators.morningCheckboxSelected));
        driver.findElement(availabilityPageLocators.morningCheckboxSelected).click();
        driver.findElement(availabilityPageLocators.afternoonCheckboxSelected).click();
        driver.findElement(availabilityPageLocators.eveningCheckboxSelected).click();
        driver.findElement(availabilityPageLocators.nightsCheckboxSelected).click();
        driver.findElement(availabilityPageLocators.saveBtn).click();
    }

    /**
     * Verify that morning, afternoon, evening, and nights have been selected
     * @return Whether or not if all availability has been selected
     */
    public boolean allAvailabilitySelected() {
        if(driver.findElement(availabilityPageLocators.morningCheckboxSelected) != null &&
                driver.findElement(availabilityPageLocators.afternoonCheckboxSelected) != null &&
                driver.findElement(availabilityPageLocators.eveningCheckboxSelected) != null &&
                driver.findElement(availabilityPageLocators.nightsCheckboxSelected) != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that morning, afternoon, evening, and nights have NOT been selected
     * @return Whether or not if all availability has NOT been selected
     */
    public boolean noAvailabilitySelected() {
        if(driver.findElement(availabilityPageLocators.morningCheckbox) != null &&
                driver.findElement(availabilityPageLocators.afternoonCheckbox) != null &&
                driver.findElement(availabilityPageLocators.eveningCheckbox) != null &&
                driver.findElement(availabilityPageLocators.nightsCheckbox) != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that the success toast is displayed after saving.
     * @return Whether or not if the success toast has been displayed
     */
    public boolean verifySuccessToast() {
        if(driver.findElement(availabilityPageLocators.successToastDiv) != null) {
            return true;
        }

        return false;
    }
}
