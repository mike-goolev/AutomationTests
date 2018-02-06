package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyProfilePersonalInfoPage extends BasePage {

    utils.Locators.PersonalInfoPageLocators personalInfoPageLocators;

    public HourlyProfilePersonalInfoPage(WebDriver driver) {
        super(driver);
        personalInfoPageLocators = new utils.Locators.PersonalInfoPageLocators();
    }

    /**
     * Checks to see if the user avatar is displayed
     * @return Whether or not the user avatar is displayed
     */
    public boolean isUserAvatarDisplayed() {
        return elementExists(personalInfoPageLocators.personalInfoUserPhotoAvatarImg);
    }

    /**
     * Checks to see if the user photo is displayed
     * @return Whether or not the user photo is displayed
     */
    public boolean isUserPhotoDisplayed() {
        return elementExists(personalInfoPageLocators.personalInfoUserPhotoImg);
    }

    /**
     * Get photo message from the text
     * @return Personal info photo text
     */
    public String getPhotoText() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhotoTxt).getText();
    }

    /**
     * Get user's first name from the text field
     * @return User's first name
     */
    public String getUserFirstName() {
        return driver.findElement(personalInfoPageLocators.personalInfoFirstNameTxtField).getAttribute("value");
    }

    /**
     * Get user's last name from the text field
     * @return User's last name
     */
    public String getUserLastName() {
        return driver.findElement(personalInfoPageLocators.personalInfoLastNameTxtField).getAttribute("value");
    }

    /**
     * Update the user's first + last name fields
     * @param firstName The user's first name
     * @param lastName The user's last name
     */
    public void updateUserFirstAndLastName(String firstName, String lastName) {
        removeUserFirstNameTxt();
        enterUserFirstName(firstName);
        removeUserLastName();
        enterUserLastName(lastName);
    }

    /**
     * Enter text into the first name text field
     * @param firstName The first and last name of the user
     */
    public void enterUserFirstName(String firstName) {
        driver.findElement(personalInfoPageLocators.personalInfoFirstNameTxtField).sendKeys(firstName);
    }

    /**
     * Enter text into the last name text field
     * @param lastName The first and last name of the user
     */
    public void enterUserLastName(String lastName) {
        driver.findElement(personalInfoPageLocators.personalInfoLastNameTxtField).sendKeys(lastName);
    }

    /**
     * Clears out first name text field
     */
    public void removeUserFirstNameTxt() {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoFirstNameTxtField));
        driver.findElement(personalInfoPageLocators.personalInfoFirstNameTxtField).click();
        driver.findElement(personalInfoPageLocators.personalInfoFirstNameTxtField).clear();
    }

    /**
     * Clears out last name text field
     */
    public void removeUserLastName() {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoLastNameTxtField));
        driver.findElement(personalInfoPageLocators.personalInfoLastNameTxtField).click();
        driver.findElement(personalInfoPageLocators.personalInfoLastNameTxtField).clear();
    }

    /**
     * Update the user's location field
     * @param location The text to enter into the field
     */
    public void updateUserLocation(String location) throws Exception {
        removeUserLocation();
        enterUserLocation(location);
        selectUserLocation();
    }

    /**
     * Get user's location from the text field
     * @return User's location
     */
    public String getUserLocation() {
        return driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).getAttribute("value");
    }

    /**
     * Enter text into the location text field
     * @param location The home location of the user
     */
    public void enterUserLocation(String location) {
        driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).sendKeys(location);
    }

    /**
     * Selects location from a list of Google Map API result list
     */
    public void selectUserLocation() throws Exception{
        Thread.sleep(1000);
        driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    /**
     * Clears out location text field
     */
    public void removeUserLocation() {
        driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).clear();
    }


    /**
     * Get user's phone from the text field
     * @return User's phone
     */
    public String getUserPhone() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).getAttribute("value");
    }

    /**
     * Enter text into the phone text field
     * @param phone The user's phone #
     */
    public void enterUserPhone(String phone) {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoPhoneTxtField));
        driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).click();
        driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).sendKeys(phone);
    }

    /**
     * Clears out phone text field
     */
    public void removeUserPhone() {
        driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).clear();
    }

    /**
     * Check to see if the phone text field is empty
     * @return Whether or not the phone text field is empty or not
     */
    public boolean isUserPhoneTxtFieldEmpty() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).getAttribute("value").equals("");
    }

    /**
     * Selects a month on the date dropdown
     * @param month The month to select from the date dropdown
     */
    public void selectMonthFromDate(String month) {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoBirthdayMonthSelect));
        Select monthSelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayMonthSelect));
        monthSelect.selectByValue(month);
    }

    /**
     * Selects a day on the date dropdown
     * @param day The day to select from the date dropdown
     */
    public void selectDayFromDate(String day) {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoBirthdayDaySelect));
        Select daySelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayDaySelect));
        daySelect.selectByValue(day);
    }

    /**
     * Selects a year on the date dropdown
     * @param year The year to select from the date dropdown
     */
    public void selectYearFromDate(String year) {
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoBirthdayYearSelect));
        Select yearSelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayYearSelect));
        yearSelect.selectByValue(year);
    }

    /**
     * Get user's dob Month from the dropdown
     * @return User's dob Month
     */
    public String getSelectedMonth() {
        wait.until(visibilityOfElementLocated(personalInfoPageLocators.personalInfoBirthdayMonthSelect));
        Select monthSelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayMonthSelect));
        String monthText = monthSelect.getFirstSelectedOption().getText();
        return monthText;
    }

    /**
     * Get user's dob Day from the dropdown
     * @return User's dob Day
     */
    public String getSelectedDay() {
        wait.until(visibilityOfElementLocated(personalInfoPageLocators.personalInfoBirthdayDaySelect));
        Select daySelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayDaySelect));
        String dayText = daySelect.getFirstSelectedOption().getText();
        return dayText;
    }

    /**
     * Get user's dob Year from the dropdown
     * @return User's dob Year
     */
    public String getSelectedYear() {
        wait.until(visibilityOfElementLocated(personalInfoPageLocators.personalInfoBirthdayYearSelect));
        Select yearSelect = new Select(driver.findElement(personalInfoPageLocators.personalInfoBirthdayYearSelect));
        String yearText = yearSelect.getFirstSelectedOption().getText();
        return yearText;
    }

    /**
     * Check to see if the birthday Month dropdown is empty
     * @return Whether or not the birthday Month dropdown is empty or not
     */
    public Boolean isBirthdayMonthEmpty(){
        return getSelectedMonth().equals("Month");
    }

    /**
     * Check to see if the birthday Day dropdown is empty
     * @return Whether or not the birthday Day dropdown is empty or not
     */
    public Boolean isBirthdayDayEmpty(){
        return getSelectedDay().equals("Day");
    }

    /**
     * Check to see if the birthday Year dropdown is empty
     * @return Whether or not the birthday Year dropdown is empty or not
     */
    public Boolean isBirthdayYearEmpty(){
        return getSelectedYear().equals("Year");
    }

    /**
     * Check to see if the birthday dropdowns are empty
     * @return Whether or not the birthday dropdowns are empty or not
     */
    public Boolean isBirthdayEmpty(){
        if (isBirthdayMonthEmpty() && isBirthdayDayEmpty() && isBirthdayYearEmpty()){
            return true;
        }
        return false;
    }

    /**
     * Click the save button
     */
    public void clickSaveBtn() {
        driver.findElement(personalInfoPageLocators.personalInfoSaveBtn).click();
    }

    /**
     * Checks to see if the personal info save button is enabled
     * @return Whether or not the personal info save button is enabled
     */
    public boolean isSaveButtonEnabled(){
        return driver.findElement(personalInfoPageLocators.personalInfoSaveBtn).isEnabled();
    }

    /**
     * Checks to see if the personal info success toast is visible
     * @return Whether or not the personal info success toast is visible
     */
    public boolean verifyPersonalInfoSuccessToast(){
         wait.until(visibilityOfElementLocated(personalInfoPageLocators.personalInfoSuccessToast));
         return elementExists(personalInfoPageLocators.personalInfoSuccessToast);
     }

    /**
     * Clicks the 'X' to dismiss the personal info success toast
     */
     public void dismissPersonalInfoSuccessToast(){
         wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoSuccessToastCloseBtn));
         driver.findElement(personalInfoPageLocators.personalInfoSuccessToastCloseBtn).click();
         wait.until(invisibilityOfElementLocated(personalInfoPageLocators.personalInfoSuccessToast));
     }

    /**
     * Checks to see if the personal info tooltip is displayed
     * @return Whether or not the personal info tooltip is displayed
     */
     public boolean isPersonalInfoTooltipDisplayed() {
        return elementExists(personalInfoPageLocators.personalInfoTooltip);
    }

    /**
     * Get location title from the personal info tooltip
     * @return The location tooltip title
     */
    public String getLocationTitleTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoLocationTitleTooltip).getText();
    }

    /**
     * Get phone title from the personal info tooltip
     * @return The phone tooltip text
     */
    public String getPhoneTitleTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTitleTooltip).getText();
    }

    /**
     * Get birthdate title from the personal info tooltip
     * @return The birthdate tooltip text
     */
    public String getBirthdateTitleTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoBirthdateTitleTooltip).getText();
    }

    /**
     * Checks to see if location text tooltip is displayed
     * @return The location tooltip text
     */
    public String getLocationTxtTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoLocationTxtTooltip).getText();
    }

    /**
     * Checks to see if phone text tooltip is displayed
     * @return The phone tooltip text
     */
    public String getPhoneTxtTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtTooltip).getText();
    }

    /**
     * Checks to see if birthdate text tooltip is displayed
     * @return The birthdate tooltip text
     */
    public String getBirthdateTxtTooltip() {
        return driver.findElement(personalInfoPageLocators.personalInfoBirthdateTxtTooltip).getText();
    }
}
