import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
        wait.until(elementToBeClickable(availabilityPageLocators.morningCard));
        driver.findElement(availabilityPageLocators.morningCard).click();
        driver.findElement(availabilityPageLocators.afternoonCard).click();
        driver.findElement(availabilityPageLocators.eveningCard).click();
        driver.findElement(availabilityPageLocators.nightsCard).click();
    }

    /**
     * Clicks the edit availability save button
     */
    public void clickSaveButton() {
        wait.until(elementToBeClickable(driver.findElement(availabilityPageLocators.saveBtn)));
        driver.findElement(availabilityPageLocators.saveBtn).click();
    }

    /**
     * Clicks the Gigs checkbox on the edit availability page
     */
    public void clickGigsCheckbox(){
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityGigsChkBox));
        driver.findElement(availabilityPageLocators.availabilityGigsChkBox).click();
    }

    /**
     * Clicks on the full time availability type card
     */
    public void clickAvailabilityTypeFullTime() {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityFullTimeCard));
        driver.findElement(availabilityPageLocators.availabilityFullTimeCard).click();
    }

    /**
     * Clicks on the part time availability type card
     */
    public void clickAvailabilityTypePartTime() {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityPartTimeCard));
        driver.findElement(availabilityPageLocators.availabilityPartTimeCard).click();
    }

    /**
     * Clicks on the seasonal availability type card
     */
    public void clickAvailabilityTypeSeasonal() {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilitySeasonalCard));
        driver.findElement(availabilityPageLocators.availabilitySeasonalCard).click();
    }

    /**
     * Clicks on the full time availability type card
     */
    public void clickAvailabilityTypeAnything() {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityAnythingCard));
        driver.findElement(availabilityPageLocators.availabilityAnythingCard).click();
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
     * Checks to see if the morning card is selected
     * @return Whether or not the morning card is selected
     */
    public boolean isMorningSelected() {
        return isCardSelected(driver.findElement(availabilityPageLocators.morningCard));
    }

    /**
     * Checks to see if the afternoon card is selected
     * @return Whether or not the afternoon card is selected
     */
    public boolean isAfternoonSelected() {
        return isCardSelected(driver.findElement(availabilityPageLocators.afternoonCard));
    }

    /**
     * Checks to see if the evening card is selected
     * @return Whether or not the evening card is selected
     */
    public boolean isEveningSelected() {
        return isCardSelected(driver.findElement(availabilityPageLocators.eveningCard));
    }

    /**
     * Checks to see if the night card is selected
     * @return Whether or not the night card is selected
     */
    public boolean isNightSelected() {
        return isCardSelected(driver.findElement(availabilityPageLocators.nightsCard));
    }

    /**
     * Checks to see if the gigs checkbox is selected
     * @return Whether or not the gigs checkbox is selected
     */
    public boolean isGigsSelected() {
        return isCheckboxSelected(driver.findElement(availabilityPageLocators.availabilityGigsChkBox));
    }

    /**
     * Verifies that the success banner is displayed after saving changes
     * @return Whether or not the success banner is displayed
     */
    public boolean verifyAvailabilitySuccessBanner() {
        return elementExistsLongTimeout(availabilityPageLocators.availabilitySuccessToastDiv);
    }

    /**
     * Clicks the 'X' button on the success/fail banner on the edit availability page
     */
    public void clickCloseCertificationBannerBtn() {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityBannerCloseBtn));
        driver.findElement(availabilityPageLocators.availabilityBannerCloseBtn).click();
    }

    /**
     * Selects the status (by value) passed in by the user
     * @param status The availability status value to set on the drop down
     */
    public void selectAvailabilityStatus(String status) {
        wait.until(elementToBeClickable(availabilityPageLocators.availabilityStatusDropDown));
        try {
            Select availabilityStatusSelect = new Select(driver.findElement(availabilityPageLocators.availabilityStatusDropDown));
            availabilityStatusSelect.selectByValue(status);
        }
        catch(Exception e) {
            System.out.println("Could not select the given value: " + status);
            System.out.println(e.getLocalizedMessage());
        }
    }
}
