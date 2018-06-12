package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class EmployerRegistrationPage extends BasePage {

    Locators.EmployerSignUpLocators employerSignUpLocators;
    TestUtils testUtils;

    public EmployerRegistrationPage(WebDriver driver) {
        super(driver);
        employerSignUpLocators = new Locators.EmployerSignUpLocators();
        testUtils = new TestUtils(driver);
    }

    /*--------- Registration: Choose Method ----------*/
    /**
     * Get sign up method title text
     * @return The sign up method title text
     */
    public String getSignupMethodTitleTxt() {
        return driver.findElement(employerSignUpLocators.signUpTitleTxt).getText();
    }

    /**
     * Selects email sign up
     */
    public void signupEmail(){
        wait.until(elementToBeClickable(employerSignUpLocators.signUpByEmailBtn));
        driver.findElement(employerSignUpLocators.signUpByEmailBtn).click();
    }

    /**
     * Selects Facebook sign up
     */
    public void signupFacebook(){
        wait.until(elementToBeClickable(employerSignUpLocators.signUpByFacebookBtn));
        driver.findElement(employerSignUpLocators.signUpByFacebookBtn).click();
    }

    /**
     * Selects the 'Back' button to return to hourly sign up page
     */
    public void selectSignUpMethodBackBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.signUpMethodBackBtn));
        driver.findElement(employerSignUpLocators.signUpMethodBackBtn).click();
    }

    /*--------- Registration: Register via email ----------*/

    /**
     * Get email sign up title text
     * @return The email sign up title text
     */
    public String getEmailSignupTitleTxt() {
        return driver.findElement(employerSignUpLocators.emailSignupTitleTxt).getText();
    }

    /**
     * Register user with an email and password
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email    User's email
     * @param password User's password
     */
    public void registerEmail(String firstName, String lastName, String email, String password) {
        wait.until(elementToBeClickable(employerSignUpLocators.firstNameField));
        driver.findElement(employerSignUpLocators.firstNameField).click();
        driver.findElement(employerSignUpLocators.firstNameField).sendKeys(firstName);
        driver.findElement(employerSignUpLocators.lastNameField).click();
        driver.findElement(employerSignUpLocators.lastNameField).sendKeys(lastName);
        driver.findElement(employerSignUpLocators.emailField).sendKeys(email);
        driver.findElement(employerSignUpLocators.passwordField).sendKeys(password);
    }

    /**
     * Selects the 'Next' button to continue to the store location step
     */
    public void selectSignUpEmailNextBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.emailSignupNextBtn));
        driver.findElement(employerSignUpLocators.emailSignupNextBtn).click();
    }

    /**
     * Selects the 'Back' button to return to signup method
     */
    public void selectSignUpEmailBackBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.signUpMethodBackBtn));
        driver.findElement(employerSignUpLocators.signUpMethodBackBtn).click();
    }

    /*--------- Registration: Set location ----------*/

    /**
     * Get location title text
     * @return The location title text
     */
    public String getLocationTitleTxt() {
        return driver.findElement(employerSignUpLocators.storeLocationTtitleTxt).getText();
    }

    /**
     * Sets user's location
     * @param location Employer's location
     */
    public void setEmployerLocation(String location) {
        driver.manage().window().maximize();
        wait.until(elementToBeClickable(employerSignUpLocators.storeLocationSearchField));
        driver.findElement(employerSignUpLocators.storeLocationSearchField).click();
        driver.findElement(employerSignUpLocators.storeLocationSearchField).clear();
        driver.findElement(employerSignUpLocators.storeLocationSearchField).sendKeys(location);
    }

    /**
     * Get search result employer text
     * @param index The index (Starting at 0) of the search result suggestion you wish to locate
     * @return The search result employer text
     */
    public String getSearchResultEmployerTxt(String index) {
        return driver.findElement(employerSignUpLocators.findEmployerResultByIndex(index)).getText();
    }

    /**
     * Selects an employer location suggestion by index
     * @param index The index (Starting at 0) of the search result suggestion you wish to locate
     */
    public void selectEmployerByIndex(String index){
        wait.until(elementToBeClickable(employerSignUpLocators.findEmployerResultByIndex(index)));
        driver.findElement(employerSignUpLocators.findEmployerResultByIndex(index)).click();
    }

    /**
     * Get employer name text
     * @return The selected employer's name
     */
    public String getSelectedEmployerNameTxt() {
        return driver.findElement(employerSignUpLocators.storeNameTxt).getText();
    }

    /**
     * Get employer location text
     * @return The selected employer's location
     */
    public String getSelectedEmployerLocationTxt() {
        return driver.findElement(employerSignUpLocators.storeLocationTxt).getText();
    }

    /**
     * Selects the 'Next' button to continue to store logo step
     */
    public void selectSignUpLocationNextBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeLocationNextBtn));
        driver.findElement(employerSignUpLocators.storeLocationNextBtn).click();
    }

    /**
     * Selects the 'Cancel' button to exit registration wizard
     */
    public void selectSignUpLocationCancelBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeLocationCancelBtn));
        driver.findElement(employerSignUpLocators.storeLocationCancelBtn).click();
    }

    /*--------- Registration: Set logo ----------*/

    /**
     * Get logo title text
     * @return The logo title text
     */
    public String getLogoTitleTxt() {
        return driver.findElement(employerSignUpLocators.storeLogoTtitleTxt).getText();
    }

    /**
     * Selects the upload button to bring up the system file explorer
     */
    public void selectUploadPhotoBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.storeLogoUploadBtn));
        driver.findElement(employerSignUpLocators.storeLogoUploadBtn).click();
    }

    /**
     * Sets the employer logo by specifying filename/path of the logo
     */
    public void setLogo(String fileName) {
        selectUploadPhotoBtn();
        wait.until(presenceOfElementLocated(employerSignUpLocators.storeLogoFileInput));
        driver.findElement(employerSignUpLocators.storeLogoFileInput).sendKeys(fileName);
        selectLogoPreviewSaveBtn();
    }

    /**
     * Selects the 'Save' button to save the logo
     */
    public void selectLogoPreviewSaveBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.storeLogoCropSaveBtn));
        driver.findElement(employerSignUpLocators.storeLogoCropSaveBtn).click();
    }

    /**
     * Selects the 'Cancel' button to exit registration wizard
     */
    public void selectSignUpLogoBackBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.storeLogoCancelBtn));
        driver.findElement(employerSignUpLocators.storeLocationCancelBtn).click();
    }

    /**
     * Selects the 'Next' button to continue to store photos step
     */
    public void selectSignUpLogoNextBtn() {
        wait.until(elementToBeClickable(employerSignUpLocators.storeLogoNextBtn));
        driver.findElement(employerSignUpLocators.storeLogoNextBtn).click();
    }

    /*--------- Registration: Set photos ----------*/

    /**
     * Get logo title text
     * @return The logo title text
     */
    public String getPhotosTitleTxt() {
        return driver.findElement(employerSignUpLocators.storePhotosTitleTxt).getText();
    }

    /**
     * Selects an employer photo suggestion by index
     * @param index The index (Starting at 0) of the employer photo suggestion you wish to locate
     */
    public void selectPhotoByIndex(String index){
        wait.until(elementToBeClickable(employerSignUpLocators.findStorePhotoBtnByIndex(index)));
        driver.findElement(employerSignUpLocators.findStorePhotoBtnByIndex(index)).click();
    }

    /**
     * Selects the back button on the photos screen
     */
    public void selectSignUpPhotosBackButton(){
        wait.until(elementToBeClickable(employerSignUpLocators.storePhotosBackBtn));
        driver.findElement(employerSignUpLocators.storePhotosBackBtn).click();
    }

    /**
     * Selects the next button to continue to store type selection screen
     */
    public void selectSignUpPhotosNextBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.storePhotosNextBtn));
        driver.findElement(employerSignUpLocators.storePhotosNextBtn).click();
    }

    /*--------- Registration: Set store type and job postings ----------*/

    /**
     * Get store type title text
     * @return The store type title text
     */
    public String getStoreTypeTitleTxt() {
        return driver.findElement(employerSignUpLocators.storeTypeTitleTxt).getText();
    }

    /**
     * Selects store type dropdown
     */
    public void selectStoreTypeDropdown(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeTypeDropdownBtn));
        driver.findElement(employerSignUpLocators.storeTypeDropdownBtn).click();
    }

    /**
     * Selects a store type by index
     * @param index The index (Starting at 0) of the store type you wish to locate
     */
    public void selectStoreTypeByIndex(String index){
        selectStoreTypeDropdown();
        WebElement storeType = driver.findElement(employerSignUpLocators.findStoreTypeByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", storeType);
        wait.until(elementToBeClickable(employerSignUpLocators.findStoreTypeByIndex(index)));
        driver.findElement(employerSignUpLocators.findStoreTypeByIndex(index)).click();
    }

    /**
     * Selects the back button on the store type screen
     */
    public void selectSignUpStoreTypeBackButton(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeTypeBackBtn));
        driver.findElement(employerSignUpLocators.storeTypeBackBtn).click();
    }

    /**
     * Selects the finish button on the store type selection screen
     */
    public void selectSignUpStoreTypeFinishBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeTypeFinishBtn));
        driver.findElement(employerSignUpLocators.storeTypeFinishBtn).click();
    }

    /*--------- Registration: Registration completed modal ----------*/

    /**
     * Selects the edit profile button on the store created screen
     */
    public void selectStoreCreatedEditProfileButton(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeCreatedEditProfileBtn));
        driver.findElement(employerSignUpLocators.storeCreatedEditProfileBtn).click();
    }

    /**
     * Selects the view profile button on the store created screen
     */
    public void selectStoreCreatedViewProfileButton(){
        wait.until(elementToBeClickable(employerSignUpLocators.storeCreatedViewProfileBtn));
        driver.findElement(employerSignUpLocators.storeCreatedViewProfileBtn).click();
    }
}
