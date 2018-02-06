package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Locators;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HourlyProfileEducationPage extends BasePage {

    Locators.EducationPageLocators educationPageLocators;
    TestUtils testUtils;

    public HourlyProfileEducationPage(WebDriver driver) {
        super(driver);
        educationPageLocators = new Locators.EducationPageLocators();
    }

    /**
     * Clicks on the Add Education button
     */
    public void clickAddEducationBtn() {
        driver.findElement(educationPageLocators.educationAddBtn).click();
    }

    /**
     * Clicks on the Edit Education button for a given index
     * @param index the index (starting at 0) of the education record you'd like to edit
     */
    public void clickEditEducationBtn(String index) {
        driver.findElement(educationPageLocators.findEducationEditBtnByIndex(index)).click();
    }

    /**
     * Enter text into the add education school field
     * @param school the user's school
     */
    public void setAddEducationSchoolTxt(String school) {
        driver.findElement(educationPageLocators.educationAddSchoolField).click();
        driver.findElement(educationPageLocators.educationAddSchoolField).sendKeys(school);
    }

    /**
     * Enter text into the edit education school field
     * @param school the user's school
     */
    public void setEditEducationSchoolTxt(String school) {
        driver.findElement(educationPageLocators.educationEditSchoolField).click();
        driver.findElement(educationPageLocators.educationEditSchoolField).sendKeys(school);
    }

    /**
     * Delete text in the edit education school field
     */
    public void deleteEditEducationSchoolTxt() {
        driver.findElement(educationPageLocators.educationEditSchoolField).click();
        driver.findElement(educationPageLocators.educationEditSchoolField).clear();
    }

    /**
     * Update text in the edit education school field
     * @param school the user's school
     */
    public void updateEditEducationSchoolTxt(String school) {
        deleteEditEducationSchoolTxt();
        setEditEducationSchoolTxt(school);
    }

    /**
     * Enter text into the add education degree field
     * @param degree the user's degree
     */
    public void setAddEducationDegreeTxt(String degree) {
        driver.findElement(educationPageLocators.educationAddDegreeField).click();
        driver.findElement(educationPageLocators.educationAddDegreeField).sendKeys(degree);
    }

    /**
     * Enter text into the edit education degree field
     * @param degree the user's degree
     */
    public void setEditEducationDegreeTxt(String degree) {
        driver.findElement(educationPageLocators.educationEditDegreeField).click();
        driver.findElement(educationPageLocators.educationEditDegreeField).sendKeys(degree);
    }

    /**
     * Delete text from the edit education degree field
     */
    public void deleteEditEducationDegreeTxt() {
        driver.findElement(educationPageLocators.educationEditDegreeField).click();
        driver.findElement(educationPageLocators.educationEditDegreeField).clear();
    }

    /**
     * Update text in the edit education degree field
     * @param degree the user's school
     */
    public void updateEditEducationDegreeTxt(String degree) {
        deleteEditEducationDegreeTxt();
        setEditEducationDegreeTxt(degree);
    }

    /**
     * Selects a year from the 'From' drop down
     * @param year The year to select from the 'From' year drop down
     */
    public void selectAddEducationYearFromDate(String year) {
        Select fromYearSelect = new Select(driver.findElement(educationPageLocators.educationAddFromYearSelect));
        fromYearSelect.selectByVisibleText(year);
    }

    /**
     * Selects a year from the 'From' drop down
     * @param year The year to select from the 'From' year drop down
     */
    public void selectEditEducationYearFromDate(String year) {
        Select fromYearSelect = new Select(driver.findElement(educationPageLocators.educationEditFromYearSelect));
        fromYearSelect.selectByVisibleText(year);
    }

    /**
     * Selects a year from the 'To' drop down
     * @param year The year to select from the 'To' year drop down
     */
    public void selectAddEducationYearToDate(String year) {
        Select fromYearSelect = new Select(driver.findElement(educationPageLocators.educationAddToYearSelect));
        fromYearSelect.selectByVisibleText(year);
    }

    /**
     * Selects a year from the 'To' drop down
     * @param year The year to select from the 'To' year drop down
     */
    public void selectEditEducationYearToDate(String year) {
        Select fromYearSelect = new Select(driver.findElement(educationPageLocators.educationEditToYearSelect));
        fromYearSelect.selectByVisibleText(year);
    }

    /**
     * Clicks on the add education save button
     */
    public void clickAddEducationSaveBtn() {
        driver.findElement(educationPageLocators.educationAddSaveBtn).click();
        verifyAddEducationSuccessToast();
        dismissAddEducationSuccessToast();
    }

    /**
     * Clicks on the add education cancel button
     */
    public void clickAddEducationCancelBtn() {
        driver.findElement(educationPageLocators.educationAddCancelBtn).click();
    }

    /**
     * Clicks on the edit education cancel button
     */
    public void clickEditEducationSaveBtn() {
        driver.findElement(educationPageLocators.educationEditSaveBtn).click();
        verifyEditEducationSuccessToast();
        dismissEditEducationSuccessToast();
    }

    /**
     * Clicks on the edit education cancel button
     */
    public void clickEditEducationCancelBtn() {
        driver.findElement(educationPageLocators.educationEditCancelBtn).click();
    }

    /**
     * Clicks on the edit education delete button
     */
    public void clickEditEducationDeleteBtn() {
        driver.findElement(educationPageLocators.educationEditDeleteBtn).click();
    }

    /**
     * Clicks on the edit education confirm delete button
     */
    public void clickEditEducationConfirmDeleteBtn() {
        driver.findElement(educationPageLocators.educationEditDeleteConfirmationBtn).click();
    }

    /**
     * Deletes an education record for a given index
     * @param index the index (starting at 0) of the education record you'd like to delete
     */
    public void deleteEducationByIndex(String index) {
        driver.findElement(educationPageLocators.findEducationEditBtnByIndex(index)).click();
        clickEditEducationDeleteBtn();
        clickEditEducationConfirmDeleteBtn();
        verifyEditEducationSuccessToast();
        dismissEditEducationSuccessToast();
    }

    /**
     * Checks to see if the add education success toast is visible
     * @return Whether or not the add education success toast is visible
     */
    public boolean verifyAddEducationSuccessToast(){
        wait.until(visibilityOfElementLocated(educationPageLocators.educationAddSuccessToast));
        return elementExists(educationPageLocators.educationAddSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the add education success toast
     */
    public void dismissAddEducationSuccessToast(){
        wait.until(elementToBeClickable(educationPageLocators.educationAddSuccessToastCloseBtn));
        driver.findElement(educationPageLocators.educationAddSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(educationPageLocators.educationAddSuccessToast));
    }

    /**
     * Checks to see if the edit education success toast is visible
     * @return Whether or not the edit education success toast is visible
     */
    public boolean verifyEditEducationSuccessToast(){
        wait.until(visibilityOfElementLocated(educationPageLocators.educationEditSuccessToast));
        return elementExists(educationPageLocators.educationEditSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the edit education success toast
     */
    public void dismissEditEducationSuccessToast(){
        wait.until(elementToBeClickable(educationPageLocators.educationEditSuccessToastCloseBtn));
        driver.findElement(educationPageLocators.educationEditSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(educationPageLocators.educationEditSuccessToast));
    }

    /**
     * Gets the education school from the given index
     * @param index The index (Starting at 0) of the education school you wish to locate
     * @return The education school text at the given index
     */
    public String getEducationSchoolTxtByIndex(String index) {
        return driver.findElement(educationPageLocators.findEducationSchoolTxtByIndex(index)).getText();
    }

    /**
     * Gets the education degree from the given index
     * @param index The index (Starting at 0) of the education degree you wish to locate
     * @return The education degree text at the given index
     */
    public String getEducationDegreeTxtByIndex(String index) {
        return driver.findElement(educationPageLocators.findEducationDegreeTxtByIndex(index)).getText();
    }

    /**
     * Gets the education duration at the given index
     * @param index The index (Starting at 0) of the education duration you wish to locate
     * @return The duration text at the given index
     */
    public String getEducationDurationTxtByIndex(String index) {
        return driver.findElement(educationPageLocators.findEducationDurationTxtByIndex(index)).getText();
    }

    /**
     * Checks to see if the add education tooltip is displayed
     * @return Whether or not the add education tooltip is displayed
     */
    public boolean isAddEducationTooltipDisplayed() {
        return elementExists(educationPageLocators.educationAddTooltipTitleTxt) &&
                elementExists(educationPageLocators.educationAddTooltipP1Txt) &&
                elementExists(educationPageLocators.educationAddTooltipP2Txt);
    }

    /**
     * Checks to see if the edit education tooltip is displayed
     * @return Whether or not the edit education tooltip is displayed
     */
    public boolean isEditEducationTooltipDisplayed() {
        return elementExists(educationPageLocators.educationEditTooltipTitleTxt) &&
                elementExists(educationPageLocators.educationEditTooltipP1Txt) &&
                elementExists(educationPageLocators.educationEditTooltipP2Txt);
    }
}
