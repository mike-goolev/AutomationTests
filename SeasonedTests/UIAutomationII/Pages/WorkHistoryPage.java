import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WorkHistoryPage extends BasePage {

    Locators.WorkHistoryPageLocators workHistoryPageLocators;

    public WorkHistoryPage(WebDriver d) {
        super(d);
        workHistoryPageLocators = new Locators.WorkHistoryPageLocators();
    }

    /**
     * Enters text in to the edit work history where have you worked field
     * @param s The text to enter in the where you have worked field
     */
    public void enterWhereHaveYouWorkedText(String s) throws Exception {
        wait.until(elementToBeClickable(workHistoryPageLocators.employerLocationTxtField));
        driver.findElement(workHistoryPageLocators.employerLocationTxtField).sendKeys(s);
        Thread.sleep(500);
        driver.findElement(workHistoryPageLocators.employerLocationTxtField).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
    }

    /**
     * Selects a job position from the position drop down
     * @param value the job position to select in the drop down
     */
    public void selectJobPosition(String value) {
        wait.until(elementToBeClickable(workHistoryPageLocators.jobPositionSelect));
        Select jobPositionDropDown = new Select(driver.findElement(workHistoryPageLocators.jobPositionSelect));
        jobPositionDropDown.selectByValue(value);
    }

    /**
     * Selects a month on the from date field
     * @param month the month to select from the from date drop down
     */
    public void selectMonthFromDate(String month) {
        wait.until(elementToBeClickable(workHistoryPageLocators.fromMonthDateSelect));
        Select fromMonthSelect = new Select(driver.findElement(workHistoryPageLocators.fromMonthDateSelect));
        fromMonthSelect.selectByValue(month);
    }

    /**
     * Selects a year on the from date field
     * @param year the year to select from the from date drop down
     */
    public void selectYearFromDate(String year) {
        wait.until(elementToBeClickable(workHistoryPageLocators.fromYearDateSelect));
        Select fromYearSelect = new Select(driver.findElement(workHistoryPageLocators.fromYearDateSelect));
        fromYearSelect.selectByValue(year);
    }

    /**
     * Selects a month on the to date field
     * @param month the month to select from the to date drop down
     */
    public void selectMonthToDate(String month) {
        wait.until(elementToBeClickable(workHistoryPageLocators.toMonthDateSelect));
        Select toMonthSelect = new Select(driver.findElement(workHistoryPageLocators.toMonthDateSelect));
        toMonthSelect.selectByValue(month);
    }

    /**
     * Selects a year on the to date field
     * @param year the year to select from the to date drop down
     */
    public void selectYearToDate(String year) {
        wait.until(elementToBeClickable(workHistoryPageLocators.toYearDateSelect));
        Select toYearSelect = new Select(driver.findElement(workHistoryPageLocators.toYearDateSelect));
        toYearSelect.selectByValue(year);
    }

    /**
     * Clicks on the edit work history button for a given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     */
    public void clickEditWorkHistory(String index) {
        driver.findElement(workHistoryPageLocators.findEditWorkHistoryItemByIndex(index)).click();
    }

    /**
     * Clicks the Yes, Delete button on the delete work history entry modal
     */
    public void clickYesDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.yesDeleteBtn));
        driver.findElement(workHistoryPageLocators.yesDeleteBtn).click();
    }

    /**
     * Clicks cancel on the delete work history modal
     */
    public void clickCancelDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.cancelDeleteBtn));
        driver.findElement(workHistoryPageLocators.cancelDeleteBtn);
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
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistorySaveBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistorySaveBtn).click();
    }

    /**
     * Clicks on the edit work history cancel button
     */
    public void clickCancelBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistoryCancelBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistoryCancelBtn).click();
    }

    /**
     * Clicks on the edit work history delete button
     */
    public void clickDeleteBtn() {
        wait.until(elementToBeClickable(workHistoryPageLocators.editWorkHistoryDeleteBtn));
        driver.findElement(workHistoryPageLocators.editWorkHistoryDeleteBtn).click();
    }

    /**
     * returns a list of elements returned by the location drop down when typing in a location/store
     * @return a list of elements that represents the stores returned by google places
     */
    public List<WebElement> getGooglePlacesElements() {
        return driver.findElements(workHistoryPageLocators.googlePlacesMyStoreBtns);
    }
}
