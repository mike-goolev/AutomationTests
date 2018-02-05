import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class EmployerProfilePhotosPage extends BasePage {

    Locators.EmployerProfileEditPhotosPageLocators employerProfileEditPhotosPageLocators;

    public EmployerProfilePhotosPage(WebDriver driver) {
        super(driver);
        employerProfileEditPhotosPageLocators = new Locators.EmployerProfileEditPhotosPageLocators();
    }

    /**
     * Get photo title text
     * @return The photo title text
     */
    public String getPhotosTitleTxt() {
        return driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosTitleTxt).getText();
    }

    /**
     * Selects an employer photo by index
     * @param index The index (Starting at 0) of the employer photo you wish to locate
     */
    public void selectPhotoByIndex(String index){
        wait.until(elementToBeClickable(employerProfileEditPhotosPageLocators.findEmployerPhotoByIndex(index)));
        driver.findElement(employerProfileEditPhotosPageLocators.findEmployerPhotoByIndex(index)).click();
    }

    /**
     * Checks to see if the employer photo is present
     * @param index The index (starting at 0) of the employer photo
     * @return Whether or not the employer photo is present
     */
    public boolean isPhotoPresent(String index){
        return elementExists(employerProfileEditPhotosPageLocators.findEmployerPhotoByIndex(index));
    }

    /**
     * Deletes an employer photo by index
     * @param index The index (Starting at 0) of the employer photo you wish to locate
     */
    public void deletePhotoByIndex(String index){
        wait.until(visibilityOfElementLocated(employerProfileEditPhotosPageLocators.employerProfileEditPhotosDeletePhotosBtn));
        selectPhotoByIndex(index);
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosDeletePhotosBtn).click();
        deletePhotoConfirmDelete();
    }

    /**
     * Selects the upload button to bring up the system file explorer
     */
    public void selectUploadPhotoBtn() {
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosUploadBtn).click();
    }

    /**
     * Selects the upload button to bring up the system file explorer
     */
    public void waitForPhotoUploadLoadingIndicator() {
        if (driver.findElement(employerProfileEditPhotosPageLocators.employerProfilePhotosUploadLoadingIndicator).isDisplayed()) {
            wait.until(invisibilityOfElementLocated(employerProfileEditPhotosPageLocators.employerProfilePhotosUploadLoadingIndicator));
        }
    }

    /**
     * Selects the upload button to bring up the system file explorer
     */
    public void waitForPhotoDeleteLoadingIndicator() {
        if (driver.findElement(employerProfileEditPhotosPageLocators.employerProfilePhotosDeleteLoadingIndicator).isDisplayed()) {
            wait.until(invisibilityOfElementLocated(employerProfileEditPhotosPageLocators.employerProfilePhotosDeleteLoadingIndicator));
        }
    }

    /**
     * Adds a new employer photo
     * @param fileName the name and path of the file
     */
    public void addEmployerPhoto(String fileName) throws Exception{
        selectUploadPhotoBtn();
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosFileInput).sendKeys(fileName);
        waitForPhotoUploadLoadingIndicator();
    }



    /**
     * Selects the confirm delete button
     */
    public void deletePhotoConfirmDelete() {
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosDeleteConfirmYesBtn).click();
    }

    /**
     * Selects the cancel delete button
     */
    public void deletePhotoCancelDelete() {
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosDeleteConfirmYesBtn).click();
    }

    /**
     * Checks to see if the employer photos delete button is enabled
     * @return Whether or not the employer photos delete button is enabled
     */
    public boolean isDeleteButtonEnabled(){
        return (driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosDeletePhotosBtn).isEnabled());
    }

    /**
     * Checks to see if the employer photos success toast is visible
     * @return Whether or not the employer photos success toast is visible
     */
    public boolean verifyEmployerPhotosSuccessToast(){
        wait.until(visibilityOfElementLocated(employerProfileEditPhotosPageLocators.employerProfileEditPhotosSuccessToast));
        return elementExists(employerProfileEditPhotosPageLocators.employerProfileEditPhotosSuccessToast);
    }

    /**
     * Clicks the 'X' to dismiss the employer photos success toast
     */
    public void dismissEmployerPhotosSuccessToast(){
        wait.until(elementToBeClickable(employerProfileEditPhotosPageLocators.employerProfileEditPhotosSuccessToastCloseBtn));
        driver.findElement(employerProfileEditPhotosPageLocators.employerProfileEditPhotosSuccessToastCloseBtn).click();
        wait.until(invisibilityOfElementLocated(employerProfileEditPhotosPageLocators.employerProfileEditPhotosSuccessToast));
    }

    /**
     * Checks to see if the employer photos tooltip is displayed
     * @return Whether or not the employer photos tooltip is displayed
     */
    public boolean isEmployerPhotosTooltipDisplayed() {
        return elementExists(employerProfileEditPhotosPageLocators.employerProfileEditPhotoTooltipTitle) &&
        elementExists(employerProfileEditPhotosPageLocators.employerProfileEditPhotoTooltipTxt);
    }
}
