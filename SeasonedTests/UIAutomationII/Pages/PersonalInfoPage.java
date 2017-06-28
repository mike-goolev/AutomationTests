import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PersonalInfoPage extends BasePage {

    Locators.PersonalInfoPageLocators personalInfoPageLocators;
    NavPage navPage;


    public PersonalInfoPage(WebDriver driver) {
        super(driver);
        personalInfoPageLocators = new Locators.PersonalInfoPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Update the user's first + last name field
     * @param name The text to enter into the field
     */
    public void updateUserFirstAndLastNameTxt(String name) {
        removeUserNameTxt();
        enterUserFirstAndLastName(name);
    }

    /**
     * Check to see the if the name text field equals the text parameter
     * @param name The text to compare against
     * @return Whether or not the text in the name field is the same as the text parameter
     */
    public boolean verifyUserFirstAndLastNameTxt(String name) {
        return driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).getAttribute("value").equals(name);
    }

    /**
     * Get user's location from the text field
     * @return User's name
     */
    public String getUserFirstAndLastNameTxt() {
        return driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).getAttribute("value");
    }

    /**
     * Enter text into the name text field
     * @param firstLastName The first and last name of the user
     */
    public void enterUserFirstAndLastName(String firstLastName) {
        driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).sendKeys(firstLastName);
    }

    /**
     * Update the user's location field
     * @param location The text to enter into the field
     */
    public void updateUserLocationTxt(String location) throws Exception {
        removeUserLocationTxt();
        enterUserLocation(location);
        selectUserLocation();
    }

    /**
     * Check to see the if the location text field equals the text parameter
     * @param location The text to compare against
     * @return Whether or not the text in the location field is the same as the text parameter
     */
    public boolean verifyUserLocationTxt(String location) {
        return driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).getAttribute("value").equals(location);
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
     * Check to see the if the phone text field equals the text parameter
     * @param phone The text to compare against
     * @return Whether or not the text in the phone field is the same as the text parameter
     */
    public boolean verifyUserPhoneTxt(String phone) {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).getAttribute("value").equals(phone);
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
     * Check to see if the phone text field is empty
     * @return Whether or not the phone text field is empty or not
     */
    public boolean isUserPhoneTxtFieldEmpty() {
        return driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).getAttribute("value").equals("");
    }

    /**
     * Click the save button
     */
    public void clickSaveBtn() {
        driver.findElement(personalInfoPageLocators.personalInfoSaveBtn).click();
        /*navPage.waitForActivtyIndicator();*/
    }

    /**
     * Clears out name text field
     */
    public void removeUserNameTxt() {
        int textLength = driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).getAttribute("value").length();
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoFirstLastNameTxtField));
        driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).click();
        for (int i = 0; i < textLength; i++) {
            driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).sendKeys("\u0008");
        }
    }

    /**
     * Clears out location text field
     */
    public void removeUserLocationTxt() {
        int textLength = driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).getAttribute("value").length();
        wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoLocationTxtField));
        driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).click();
        for (int i = 0; i < textLength; i++) {
            driver.findElement(personalInfoPageLocators.personalInfoLocationTxtField).sendKeys("\u0008");
        }
    }

    /**
     * Clears out phone text field
     */
     public void removeUserPhoneTxt() {
         int textLength = driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).getAttribute("value").length();
         wait.until(elementToBeClickable(personalInfoPageLocators.personalInfoPhoneTxtField));
         driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).click();
         for (int i = 0; i < textLength; i++) {
             driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).sendKeys("\u0008");
         }
         //Initiate hack job sequence...
         driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).sendKeys(Keys.ARROW_RIGHT);
         driver.findElement(personalInfoPageLocators.personalInfoFirstLastNameTxtField).sendKeys(Keys.ARROW_RIGHT);
         driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).sendKeys("\u0008");
         driver.findElement(personalInfoPageLocators.personalInfoPhoneTxtField).sendKeys("\u0008");
     }
}