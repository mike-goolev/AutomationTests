package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Locators;

import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HourlyProfileWorkHistoryPage extends BasePage {

    Locators.WorkHistoryPageLocators workHistoryPageLocators;

    public HourlyProfileWorkHistoryPage(WebDriver d) {
        super(d);
        workHistoryPageLocators = new Locators.WorkHistoryPageLocators();
    }

    /**
     * Clicks on the Add Experience button
     */
    public void clickAddWorkHistoryBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.addWorkHistoryBtn));
        driver.findElement(workHistoryPageLocators.addWorkHistoryBtn).click();
    }

    /**
     * Enters text in to the edit work history employer/store field
     * @param employer The text to enter in the employer/store field
     */
    public void enterWhereHaveYouWorkedText(String employer) throws Exception {
        wait.until(elementToBeClickable(workHistoryPageLocators.employerLocationTxtField));
        driver.findElement(workHistoryPageLocators.employerLocationTxtField).sendKeys(employer);
        Thread.sleep(500);
        driver.findElement(workHistoryPageLocators.employerLocationTxtField).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(workHistoryPageLocators.employerLocationTxtField).sendKeys(Keys.ENTER);
    }

    /**
     * Selects a job position from the position drop down
     * @param index The index (Starting at 0) of the position you wish to locate
     */
    public void clickJobPosition(String index) {
        wait.until(elementToBeClickable(workHistoryPageLocators.jobPositionDropdown));
        driver.findElement(workHistoryPageLocators.jobPositionDropdown).click();
        wait.until(elementToBeClickable(workHistoryPageLocators.findPositionByIndex(index)));
        driver.findElement(workHistoryPageLocators.findPositionByIndex(index)).click();
    }

    /**
     * Removes a job position from the user's selected positions
     * @param index The index (Starting at 0) of the position you wish to locate
     */
    public void removeJobPosition(String index) {
        wait.until(elementToBeClickable(workHistoryPageLocators.findSelectedPositionRemoveBtnByIndex(index)));
        driver.findElement(workHistoryPageLocators.findSelectedPositionRemoveBtnByIndex(index)).click();
    }

    /**
     * Selects a month from the from month drop down
     * @param month The month to select from the from month drop down
     */
    public void selectMonthFromDate(String month) {
        wait.until(elementToBeClickable(workHistoryPageLocators.fromMonthDateSelect));
        Select fromMonthSelect = new Select(driver.findElement(workHistoryPageLocators.fromMonthDateSelect));
        fromMonthSelect.selectByVisibleText(month);
    }

    /**
     * Selects a year from the from year drop down
     * @param year The year to select from the from year drop down
     */
    public void selectYearFromDate(String year) {
        wait.until(elementToBeClickable(workHistoryPageLocators.fromYearDateSelect));
        Select fromYearSelect = new Select(driver.findElement(workHistoryPageLocators.fromYearDateSelect));
        fromYearSelect.selectByValue(year);
    }

    /**
     * Selects a month from the to date drop down
     * @param month The month to select from the to month drop down
     */
    public void selectMonthToDate(String month) {
        wait.until(elementToBeClickable(workHistoryPageLocators.toMonthDateSelect));
        Select toMonthSelect = new Select(driver.findElement(workHistoryPageLocators.toMonthDateSelect));
        toMonthSelect.selectByVisibleText(month);
    }

    /**
     * Selects a year from the to year drop down
     * @param year The year to select from the to year drop down
     */
    public void selectYearToDate(String year) {
        wait.until(elementToBeClickable(workHistoryPageLocators.toYearDateSelect));
        Select toYearSelect = new Select(driver.findElement(workHistoryPageLocators.toYearDateSelect));
        toYearSelect.selectByValue(year);
    }

    /**
     * Toggles current position off
     */
    public void clickCurrentlyWorkHereOnBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.currentWorkHistoryEnableBtn));
        driver.findElement(workHistoryPageLocators.currentWorkHistoryEnableBtn).click();
    }

    /**
     * Toggles current position on
     */
    public void clickCurrentlyWorkHereOffBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.currentWorkHistoryDisableBtn));
        driver.findElement(workHistoryPageLocators.currentWorkHistoryDisableBtn).click();
    }

    /**
     * Enter text in to the add job description text field
     * @param description
     */
    public void enterAddJobDescriptionTxt(String description) {
        driver.findElement(workHistoryPageLocators.addjobDescriptionField).click();
        driver.findElement(workHistoryPageLocators.addjobDescriptionField).sendKeys(description);
    }

    /**
     * Enter text in to the edit job description text field
     * @param description
     */
    public void enterEditJobDescriptionTxt(String description) {
        driver.findElement(workHistoryPageLocators.editjobDescriptionField).click();
        driver.findElement(workHistoryPageLocators.editjobDescriptionField).sendKeys(description);
    }

    /**
     * Gets the work history description in edit mode
     * @return The description text in edit mode
     */
    public String getJobDescription() {
        return driver.findElement(workHistoryPageLocators.editjobDescriptionField).getText();
    }

    /**
     * Toggles first job selection on/off
     */
    public void clickFirstJobChk() {
        wait.until(elementToBeClickable(workHistoryPageLocators.firstJobChk));
        driver.findElement(workHistoryPageLocators.firstJobChk).click();
    }

    /**
     * Checks to see if the first job checkbox is selected
     * @return Whether or not the first job checkbox is selected
     */
    public boolean isFirstJobChkSelected() {
        return isCheckboxSelected(driver.findElement(workHistoryPageLocators.firstJobChk));
    }

    /**
     * Clicks on the edit work history button for a given index
     * @param index The index (Starting at 0) of the work history edit button you wish to locate
     */
    public void clickEditWorkHistory(String index) {
        driver.findElement(workHistoryPageLocators.findEditWorkHistoryItemByIndex(index)).click();
    }

    /**
     * Clicks the Delete confirmation button on the delete work history modal
     */
    public void clickConfirmDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.deleteWorkHistoryDeleteBtn));
        driver.findElement(workHistoryPageLocators.deleteWorkHistoryDeleteBtn).click();
    }

    /**
     * Clicks cancel on the delete work history modal
     */
    public void clickCancelDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.deleteWorkHistoryCancelBtn));
        driver.findElement(workHistoryPageLocators.deleteWorkHistoryCancelBtn);
    }

    /**
     * Clicks on the add work history save button
     */
    public void clickAddWorkHistorySaveBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.addWorkHistorySaveBtn));
        driver.findElement(workHistoryPageLocators.addWorkHistorySaveBtn).click();
    }

    /**
     * Clicks on the edit work history save button
     */
    public void clickEditWorkHistorySaveBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistorySaveBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistorySaveBtn).click();
    }

    /**
     * Clicks on the edit work history cancel button
     */
    public void clickEditWorkHistoryCancelBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistoryCancelBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistoryCancelBtn).click();
    }

    /**
     * Clicks on the edit work history delete button
     */
    public void clickEditWorkHistoryDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistoryDeleteBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistoryDeleteBtn).click();
    }

    /**
     * Returns a list of elements returned in the location drop down when typing in an employer
     * @return a list of elements that represents the stores returned by google places
     */
    public List<WebElement> getGooglePlacesElements() {
        return driver.findElements(workHistoryPageLocators.googlePlacesMyStoreBtns);
    }

    /**
     * Verifies that the employer logo is present at the given index
     * @param index The index (Starting at 0) of the employer logo you wish to locate
     * @return Whether or not the employer logo is present at the given index
     */
    public boolean isEmployerLogoPresent(String index) {
        return elementExists(workHistoryPageLocators.findWorkHistoryEmployerLogoByIndex(index));
    }

    /**
     * Gets the job position name at the given index
     * @param employerIndex The index (Starting at 0) of the employer you wish to locate
     * @param positionIndex The index (Starting at 0) of the position name you wish to locate
     * @return The job position text at the given index
     */
    public String getJobPosition(String employerIndex, String positionIndex) {
        return driver.findElement(workHistoryPageLocators.findWorkHistoryPositionByIndex(employerIndex, positionIndex)).getText();
    }

    /**
     * Gets the employer name from the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return The employer name text at the given index
     */
    public String getEmployerName(String index) {
        return driver.findElement(workHistoryPageLocators.findWorkHistoryEmployerByIndex(index)).getText();
    }

    /**
     * Gets the time period at the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return The time period text at the given index
     */
    public String getTimePeriod(String index) {
        return driver.findElement(workHistoryPageLocators.findWorkHistoryTimePeriodByIndex(index)).getText();
    }

    /**
     * Gets the work history duration at the given index
     * @param index The index (Starting at 0) of the work history duration you wish to locate
     * @return The duration text at the given index
     */
    public String getDuration(String index) {
        return driver.findElement(workHistoryPageLocators.findWorkHistoryDurationByIndex(index)).getText();
    }

    /**
     * Checks to see if the edit experience success toast is visible
     * @return Whether or not the edit experience success toast is visible
     */
    public boolean verifyEditExperienceSuccessToast(){
        wait.until(visibilityOfElementLocated(workHistoryPageLocators.editExperienceSuccessToast));
        return elementExists(workHistoryPageLocators.editExperienceSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the edit experience success toast
     */
    public void dismissEditExperienceSuccessToast(){
        wait.until(elementToBeClickable(workHistoryPageLocators.editExperienceSuccessToastCloseBtn));
        driver.findElement(workHistoryPageLocators.editExperienceSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(workHistoryPageLocators.editExperienceSuccessToast));
    }

    /**
     * Checks to see if the add experience success toast is visible
     * @return Whether or not the add experience success toast is visible
     */
    public boolean verifyAddExperienceSuccessToast(){
        wait.until(visibilityOfElementLocated(workHistoryPageLocators.addExperienceSuccessToast));
        return elementExists(workHistoryPageLocators.addExperienceSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the add experience success toast
     */
    public void dismissAddExperienceSuccessToast(){
        wait.until(elementToBeClickable(workHistoryPageLocators.addExperienceSuccessToastCloseBtn));
        driver.findElement(workHistoryPageLocators.addExperienceSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(workHistoryPageLocators.addExperienceSuccessToast));
    }

    /**
     * Checks to see if the delete experience success toast is visible
     * @return Whether or not the delete experience success toast is visible
     */
    public boolean verifyDeleteExperienceSuccessToast(){
        wait.until(visibilityOfElementLocated(workHistoryPageLocators.deleteWorkHistorySuccessToast));
        return elementExists(workHistoryPageLocators.deleteWorkHistorySuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the delete experience success toast
     */
    public void dismissDeleteExperienceSuccessToast(){
        wait.until(elementToBeClickable(workHistoryPageLocators.deleteWorkHistorySuccessToastCloseBtn));
        driver.findElement(workHistoryPageLocators.deleteWorkHistorySuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(workHistoryPageLocators.deleteWorkHistorySuccessToast));
    }

    /**
     * Checks to see if the work history tooltip is displayed

     * @return Whether or not the work history tooltip is displayed
     */
    public boolean isWorkHistoryTooltipDisplayed() {
        return elementExists(workHistoryPageLocators.workHistoryTooltip);
    }
}
