package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EmployerProfileInfoPage extends BasePage {

    Locators.EmployerProfileEditInfoPageLocators employerProfileEditInfoPageLocators;
    TestUtils testUtils;

    public EmployerProfileInfoPage(WebDriver driver) {
        super(driver);
        employerProfileEditInfoPageLocators = new Locators.EmployerProfileEditInfoPageLocators();
        testUtils = new TestUtils(driver);
    }

    /**
     * Checks to see if the employer logo is displayed
     * @return Whether or not the employer logo is displayed
     */
    public boolean isEmployerLogoDisplayed() {
        return elementExists(employerProfileEditInfoPageLocators.employerProfileEditInfoLogoImg);
    }

    /**
     * Get the logo heading label
     * @return Logo heading label
     */
    public String getLogoLbl() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoLogoLbl).getText();
    }

    /**
     * Get logo message from the text
     * @return Employer info logo text
     */
    public String getLogoText() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoLogoTxt).getText();
    }

    /**
     * Click the logo upload button
     */
    public void selectLogoUploadBtn() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoLogoUploadBtn).click();
    }

    /**
     * Click the logo edit button
     */
    public void selectLogoEditBtn() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoLogoEditBtn).click();
    }


    /**
     * Get employer's name from the text field
     * @return Employer's name
     */
    public String getEmployerName() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoNameField).getAttribute("value");
    }

    /**
     * Update the employer name
     * @param employer The employer's name
     */
    public void updateEmployerName(String employer) {
        removeEmployerNameTxt();
        enterEmployertName(employer);
    }

    /**
     * Enter text into the employer name text field
     * @param employer The employer's name
     */
    public void enterEmployertName(String employer) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoNameField).sendKeys(employer);
    }

    /**
     * Clears out first name text field
     */
    public void removeEmployerNameTxt() {
        wait.until(elementToBeClickable(employerProfileEditInfoPageLocators.employerProfileEditInfoNameField));
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoNameField).click();
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoNameField).clear();
    }

    /**
     * Get employer's address from the text field
     * @return Employer's location
     */
    public String getEmployerAddress() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoAddress1Field).getAttribute("value");
    }

    /**
     * Update the employer's address field
     * @param address The employer's address
     */
    public void updateEmployerAddress(String address) {
        removeEmployerAddress();
        enterEmployerAddress(address);
    }

    /**
     * Enter text into the address text field
     * @param address The employer's address
     */
    public void enterEmployerAddress(String address) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoAddress1Field).sendKeys(address);
    }

    /**
     * Clears out address text field
     */
    public void removeEmployerAddress() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoAddress1Field).clear();
    }

    /**
     * Get employer's city from the text field
     * @return Employer's city
     */
    public String getEmployerCity() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoCityField).getAttribute("value");
    }

    /**
     * Update the employer's city field
     * @param city The employer's city
     */
    public void updateEmployerCity(String city) {
        removeEmployerCity();
        enterEmployerCity(city);
    }

    /**
     * Enter text into the city text field
     * @param city The employer's city
     */
    public void enterEmployerCity(String city) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoCityField).sendKeys(city);
    }

    /**
     * Clears out city text field
     */
    public void removeEmployerCity() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoCityField).clear();
    }

    /**
     * Get employer's state from the text field
     * @return Employer's state
     */
    public String getEmployerState() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoStateTxt).getText();
    }

    /**
     * Gets list of states from dropdown
     * @param index The index of the state to select
     */
    public void selectState(String index) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoStateDropdownBtn).click();
        WebElement stateSelection = driver.findElement(employerProfileEditInfoPageLocators.findEmployerStateByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", stateSelection);
        driver.findElement(employerProfileEditInfoPageLocators.findEmployerStateByIndex(index)).click();
    }

    /**
     * Get employer's zip from the text field
     * @return Employer's zip
     */
    public String getEmployerZip() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoZipField).getAttribute("value");
    }

    /**
     * Update the employer's zip field
     * @param zip The employer's zip
     */
    public void updateEmployerZip(String zip) {
        removeEmployerZip();
        enterEmployerZip(zip);
    }

    /**
     * Enter text into the zip text field
     * @param zip The employer's zip
     */
    public void enterEmployerZip(String zip) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoZipField).sendKeys(zip);
    }

    /**
     * Clears out zip text field
     */
    public void removeEmployerZip() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoZipField).clear();
    }

    /**
     * Get employer's phone # from the text field
     * @return Employer's phone #
     */
    public String getEmployerPhone() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoPhoneField).getAttribute("value");
    }

    /**
     * Update the employer's phone field
     * @param phone The employer's phone #
     */
    public void updateEmployerPhone(String phone) {
        removeEmployerPhone();
        enterEmployerPhone(phone);
    }

    /**
     * Enter text into the phone text field
     * @param phone The employer's phone #
     */
    public void enterEmployerPhone(String phone) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoPhoneField).sendKeys(phone);
    }

    /**
     * Clears out website text field
     */
    public void removeEmployerPhone() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoPhoneField).clear();
    }

    /**
     * Get employer's website from the text field
     * @return Employer's website
     */
    public String getEmployerWebsite() {
        return driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoWebsiteField).getAttribute("value");
    }

    /**
     * Update the employer's website field
     * @param website The employer's website
     */
    public void updateEmployerWebsite(String website) {
        removeEmployerWebsite();
        enterEmployerWebsite(website);
    }

    /**
     * Enter text into the website text field
     * @param website The employer's website
     */
    public void enterEmployerWebsite(String website) {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoWebsiteField).sendKeys(website);
    }

    /**
     * Clears out website text field
     */
    public void removeEmployerWebsite() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoWebsiteField).clear();
    }

    /**
     * Click the save button
     */
    public void clickSaveBtn() {
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoSaveBtn).click();
    }

    /**
     * Checks to see if the employer info save button is enabled
     * @return Whether or not the employer info save button is enabled
     */
    public boolean isSaveButtonEnabled(){
        return (driver.findElement(employerProfileEditInfoPageLocators.employerProfileEditInfoSaveBtn).isEnabled());
    }

    /**
     * Checks to see if the employer info success toast is visible
     * @return Whether or not the employer info success toast is visible
     */
    public boolean verifyEmployerInfoSuccessToast(){
        wait.until(visibilityOfElementLocated(employerProfileEditInfoPageLocators.employerProfileInfoSuccessToast));
        return elementExists(employerProfileEditInfoPageLocators.employerProfileInfoSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the employer info success toast
     */
    public void dismissEmployerInfoSuccessToast(){
        wait.until(elementToBeClickable(employerProfileEditInfoPageLocators.employerProfileInfoSuccessToastCloseBtn));
        driver.findElement(employerProfileEditInfoPageLocators.employerProfileInfoSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(employerProfileEditInfoPageLocators.employerProfileInfoSuccessToast));
    }

    /**
     * Checks to see if the employer info tooltip is displayed
     * @return Whether or not the employer info tooltip is displayed
     */
    public boolean isEmployerInfoTooltipDisplayed() {
        return elementExists(employerProfileEditInfoPageLocators.employerProfileEditInfoTooltipTitle) &&
        elementExists(employerProfileEditInfoPageLocators.employerProfileEditInfoTooltipTxt);
    }
}
