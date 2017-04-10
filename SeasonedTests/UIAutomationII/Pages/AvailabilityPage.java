import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AvailabilityPage extends BasePage {

    Locators.AvailabilityPageLocators availabilityPageLocators;

    public AvailabilityPage(WebDriver driver) {
        super(driver);
        availabilityPageLocators = new Locators.AvailabilityPageLocators();
    }

    /**
     *  Set all availability from an empty state, regardless of state
     */
    public void clickAllAvailabilityBoxes() {
        wait.until(elementToBeClickable(availabilityPageLocators.morningCheckbox));
        driver.findElement(availabilityPageLocators.morningCheckbox).click();
        driver.findElement(availabilityPageLocators.afternoonCheckbox).click();
        driver.findElement(availabilityPageLocators.eveningCheckbox).click();
        driver.findElement(availabilityPageLocators.nightsCheckbox).click();
        driver.findElement(availabilityPageLocators.saveBtn).click();
    }

    /**
     * Verify that morning, afternoon, evening, and nights have been selected
     * @return Whether or not if all availability has been selected
     */
    public boolean allAvailabilitySelected() {
        if(isMorningSelected() && isAfternoonSelected() && isEveningSelected() && isNightSelected()) {
            return true;
        }
        return false;
    }

    /**
     * Verify that morning, afternoon, evening, and nights have NOT been selected
     * @return Whether or not if all availability has NOT been selected
     */
    public boolean noAvailabilitySelected() {
        if(!isMorningSelected()&& !isAfternoonSelected() && !isEveningSelected() && !isNightSelected()) {
            return true;
        }
        return false;
    }

    /**
     * Checks to see if the morning checkbox is selected
     * @return Whether or not the morning checkbox is selected
     */
    public boolean isMorningSelected() {
        return isCheckboxSelected(driver.findElement(availabilityPageLocators.morningCheckbox));
    }

    /**
     * Checks to see if the afternoon checkbox is selected
     * @return Whether or not the afternoon checkbox is selected
     */
    public boolean isAfternoonSelected() {
        return isCheckboxSelected(driver.findElement(availabilityPageLocators.afternoonCheckbox));
    }

    /**
     * Checks to see if the evening checkbox is selected
     * @return Whether or not the evening checkbox is selected
     */
    public boolean isEveningSelected() {
        return isCheckboxSelected(driver.findElement(availabilityPageLocators.eveningCheckbox));
    }

    /**
     * Checks to see if the night checkbox is selected
     * @return Whether or not the night checkbox is selected
     */
    public boolean isNightSelected() {
        return isCheckboxSelected(driver.findElement(availabilityPageLocators.nightsCheckbox));
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
