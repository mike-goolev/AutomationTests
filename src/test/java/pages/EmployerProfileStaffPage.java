package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import utils.Locators;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EmployerProfileStaffPage extends BasePage {

    Locators.EmployerProfileStaffPageLocators employerProfileStaffPageLocators;
    Locators.EmployerProfileEditPageLocators employerProfileEditPageLocators;
    public EmployerProfileStaffPage(WebDriver driver) {
        super(driver);
        employerProfileStaffPageLocators = new Locators.EmployerProfileStaffPageLocators();
        employerProfileEditPageLocators = new Locators.EmployerProfileEditPageLocators();
    }

    /**
     * Get staff title text
     * @return The staff title text
     */
    public String getStaffTitleTxt() {
        return driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffListLabelTxt).getText();
    }

    /**
     * Checks to see if the employer staff tooltip is displayed
     * @return Whether or not the employer staff tooltip is displayed
     */
    public boolean isEmployerStaffTooltipDisplayed() {
        return elementExists(employerProfileStaffPageLocators.employerProfileEditStaffTooltipTitleTxt) &&
                elementExists(employerProfileStaffPageLocators.employerProfileEditStaffTooltipTxt);
    }

    /**
     * Select add new staff member
     */
    public void selectAddStaffMember() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffAddNewStaffBtn).click();
    }

    /**
     * Search for a staff member
     * @param name the staff members name
     */
    public void searchStaffMember(String name) {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffSearchField).sendKeys(name);
    }

    /**
     * Select a staff member to add
     * @param index the index (starting at 0) of the selected staff member
     * @param searchIndex the index (starting at 1) of the staff member search result
     */
    public void selectStaffMember(String index, Integer searchIndex) {
        wait.until(elementToBeClickable(employerProfileStaffPageLocators.findInviteStaffSearchResultByIndex(searchIndex)));
        driver.findElement(employerProfileStaffPageLocators.findInviteStaffSearchResultByIndex(searchIndex)).click();
        wait.until(visibilityOfElementLocated(employerProfileStaffPageLocators.findInviteStaffSelectionByIndex(index)));
    }

    /**
     * Select staff member add button
     */
    public void selectStaffMemberAddButton() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffAddBtn).click();
    }

    /**
     * Select staff member done button
     */
    public void selectStaffMemberDoneButton() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffAddedConfirmationBtn).click();
    }


    /**
     * Add new staff member
     * @param name the staff member's name
     * @param index the index of the selected staff member
     * @param searchIndex the index (starting at 1) of the staff member search result
     */
    public void addStaffMember(String name, String index, Integer searchIndex) {
        selectAddStaffMember();
        searchStaffMember(name);
        selectStaffMember(index, searchIndex);
        selectStaffMemberAddButton();
        waitForSaveBtnLoader();
        //selectStaffMemberDoneButton();
        //waitForPageLoader();
    }

    /**
     * Checks to see if the staff member's avatar is displayed
     *
     * @param index The index of the staff member
     * @return Whether or not the staff member's avatar is displayed
     */
    public boolean isStaffMemberAvatarDisplayed(String index){
        return (driver.findElement(employerProfileStaffPageLocators.findStaffAvatarByIndex(index)).isDisplayed());
    }

    /**
     * Get staff member's name
     *
     * @param index The index of the staff member
     * @return The staff member's name
     */
    public String getStaffMemberName(String index) {
        return driver.findElement(employerProfileStaffPageLocators.findStaffNameByIndex(index)).getText();
    }

    /**
     * Get staff member's added date
     *
     * @param index The index of the staff member
     * @return The staff member's added date
     */
    public String getStaffMemberAddedDate(String index) {
        return driver.findElement(employerProfileStaffPageLocators.findStaffAddedDateByIndex(index)).getText();
    }

    /**
     * Select staff member edit button
     * @param index The index of the staff member
     */
    public void selectStaffMemberEditButton(String index) {
        driver.findElement(employerProfileStaffPageLocators.findStaffEditBtnByIndex(index)).click();
    }

    /**
     * Checks to see if the staff member's avatar is displayed
     * @return Whether or not the staff member's avatar is displayed
     */
    public boolean isEditStaffMemberAvatarDisplayed(){
        return (driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberAvatarImg).isDisplayed());
    }

    /**
     * Get staff member's name
     * @return The staff member's name
     */
    public String getEditStaffMemberName() {
        return driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberNameTxt).getText();
    }

    /**
     * Get staff member's added date
     * @return The staff member's added date
     */
    public String getEditStaffMemberAddedDate() {
        return driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberAddedDateTxt).getText();
    }

    /**
     * Add staff member description
     * @param description The staff member's description
     */
    public void addStaffMemberDescription(String description) {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberDescriptionTxt).sendKeys(description);
    }

    /**
     * Delete staff member description
     */
    public void deleteStaffMemberDescription(){
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberDescriptionTxt).clear();
    }

    /**
     * Update staff member description
     * @param description the staff member's description
     */
    public void updateStaffMembertDescription(String description){
        deleteStaffMemberDescription();
        addStaffMemberDescription(description);
    }

    /**
     * Selects/deselects the staff member's profile visibility
     */
    public void setStaffMemberProfileVisibility() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberDisplayProfileChk).click();
    }

    /**
     * Select edit staff member save button
     */
    public void selectEditStaffMemberSaveButton() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffSaveBtn).click();
    }

    /**
     * Select edit staff member remove button
     */
    public void selectEditStaffMemberRemoveButton() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffRemoveBtn).click();
    }

    /**
     * Select edit staff member remove confirmation button
     */
    public void selectEditStaffMemberRemoveConfirmationButton() {
        driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffMemberRemoveConfirmationRemoveBtn).click();
    }

    /**
     * Select edit staff member remove confirmation button
     */
    public void deleteStaffMember() {
        selectEditStaffMemberRemoveButton();
        selectEditStaffMemberRemoveConfirmationButton();
    }



    /**
     * Checks to see if the employer edit staff tooltip is displayed
     * @return Whether or not the employer edit staff tooltip is displayed
     */
    public boolean isEmployerEditStaffTooltipDisplayed() {
        return elementExists(employerProfileStaffPageLocators.employerProfileEditStaffMemberTooltipTitleTxt) &&
                elementExists(employerProfileStaffPageLocators.employerProfileEditStaffMemberTooltipTxt);
    }

    /**
     * Checks to see if the staff member success toast is visible
     * @return Whether or not the staff member success toast is visible
     */
    public boolean verifyStaffMemberSuccessToast(){
        wait.until(visibilityOfElementLocated(employerProfileStaffPageLocators.getEmployerProfileEditStaffMemberRemoveSuccessToast));
        return driver.findElement(employerProfileStaffPageLocators.getEmployerProfileEditStaffMemberRemoveSuccessToast).isDisplayed();
    }

    /**
     * Selects the 'X' to dismiss the staff member success toast
     */
    public void dismissStaffMemberSuccessToast(){
        wait.until(elementToBeClickable(employerProfileStaffPageLocators.getEmployerProfileEditStaffMemberRemoveSuccessToastCloseBtn));
        driver.findElement(employerProfileStaffPageLocators.getEmployerProfileEditStaffMemberRemoveSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(employerProfileStaffPageLocators.getEmployerProfileEditStaffMemberRemoveSuccessToast));
    }

    /**
     * Waits for the save button loader
     */
    public void waitForSaveBtnLoader() {
        try {
            if (driver.findElement(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffSaveBtnLoader).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(employerProfileStaffPageLocators.employerProfileEditStaffInviteStaffSaveBtnLoader));
            }
        } catch (NoSuchElementException e) {
            System.out.println("***\n" + "Loader not displayed due to NoSuchElementException..." + "\n***");
        } catch (StaleElementReferenceException se) {
            System.out.println("***\n" +"Loader not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }

    /**
     * Waits for the page loader
     */
    public void waitForPageLoader() {
        try {
            if (driver.findElement(employerProfileEditPageLocators.employerProfileEditPageLoader).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(employerProfileEditPageLocators.employerProfileEditPageLoader));
            }
        } catch (NoSuchElementException e) {
            System.out.println("***\n" + "Loader not displayed due to NoSuchElementException..." + "\n***");
        } catch (StaleElementReferenceException se) {
            System.out.println("***\n" +"Loader not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }
}
