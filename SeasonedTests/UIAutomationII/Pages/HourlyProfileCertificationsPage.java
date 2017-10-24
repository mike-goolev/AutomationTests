import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyProfileCertificationsPage extends BasePage {

    Locators.CertificationsPageLocators certificationsPageLocators;

    public HourlyProfileCertificationsPage(WebDriver driver) {
        super(driver);
        certificationsPageLocators = new Locators.CertificationsPageLocators();
    }

    /**
     * Clicks on the Alcohol Seller Checkbox regardless of state
     */
    public void clickAlcoholSellerChk() {
        wait.until(elementToBeClickable(certificationsPageLocators.alcoholSellerChk));
        driver.findElement(certificationsPageLocators.alcoholSellerChk).click();
    }

    /**
     * Clicks on the Food Handler Checkbox regardless of state
     */
    public void clickFoodHandlerChk() {
        wait.until(elementToBeClickable(certificationsPageLocators.foodHandlerChk));
        driver.findElement(certificationsPageLocators.foodHandlerChk).click();
    }

    /**
     * Clicks on the Food Protection Manager Checkbox regardless of state
     */
    public void clickFoodProtectionManagerChk() {
        wait.until(elementToBeClickable(certificationsPageLocators.foodProtectionChk));
        driver.findElement(certificationsPageLocators.foodProtectionChk).click();
    }

    /**
     * Clicks on the HACCP Checkbox regardless of state
     */
    public void clickHACCPChk() {
        wait.until(elementToBeClickable(certificationsPageLocators.haccpChk));
        driver.findElement(certificationsPageLocators.haccpChk).click();
    }

    /**
     * Clicks the save button if a change has been made, otherwise it will fail
     */
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(certificationsPageLocators.saveBtn));
        driver.findElement(certificationsPageLocators.saveBtn).click();
    }

    /**
     * Clicks on all certification checkboxes regardless of state
     */
    public void selectAllCertifications() {
        clickAlcoholSellerChk();
        clickFoodHandlerChk();
        clickFoodProtectionManagerChk();
        clickHACCPChk();
        clickSaveBtn();
    }

    /**
     * Checks to see if the alcohol seller certification is selected
     * @return Whether or not the alcohol seller certification is selected
     */
    public boolean isAlcoholSelected() {
        return isCheckboxSelected(driver.findElement(certificationsPageLocators.alcoholSellerChkBox));
    }

    /**
     * Checks to see if the food handler certification is selected
     * @return Whether or not the food handler certification is selected
     */
    public boolean isFoodHandlerSelected() {
        return isCheckboxSelected(driver.findElement(certificationsPageLocators.foodHandlerChkBox));
    }

    /**
     * Checks to see if the food protection manager certification is selected
     * @return Whether or not the food protection manager certification is selected
     */
    public boolean isFoodProtectionManagerSelected() {
        return isCheckboxSelected(driver.findElement(certificationsPageLocators.foodProtectionChkBox));
    }

    /**
     * Checks to see if the HACCP certification is selected
     * @return Whether or not the HACCP certification is selected
     */
    public boolean isHACCPSelected() {
        return isCheckboxSelected(driver.findElement(certificationsPageLocators.haccpChkBox));
    }

    /**
     * Checks to see if all certifications are selected
     * @return Whether or not all certifications are selected
     */
    public boolean areAllCertsSelected() {
        return isAlcoholSelected() &&
                isFoodHandlerSelected() &&
                isFoodProtectionManagerSelected() &&
                isHACCPSelected();
    }

    /**
     * Checks to see if no certifications are selected
     * @return Whether or not no certifications are selected
     */
    public boolean areNoCertsSelected() {
        return !isAlcoholSelected() &&
                !isFoodHandlerSelected() &&
                !isFoodProtectionManagerSelected() &&
                !isHACCPSelected();
    }

    /**
     * Checks to see if the upload button is displayed after the alcohol seller cert is selected
     * @return Whether or not the alcohol seller upload button is displayed
     */
    public boolean isAlcoholUploadBtnDisplayed() {
        return elementExists(certificationsPageLocators.alcoholSellerUploadBtn);
    }

    /**
     * Checks to see if the upload button is displayed after the food handler cert is selected
     * @return Whether or not the food handler upload button is displayed
     */
    public boolean isFoodHandlerUploadBtnDisplayed() {
        return elementExists(certificationsPageLocators.foodHandlerUploadBtn);
    }

    /**
     * Checks to see if the upload button is displayed after the food protection manager cert is selected
     * @return Whether or not the food protection manager upload button is displayed
     */
    public boolean isFoodProtectionUploadBtnDisplayed() {
        return elementExists(certificationsPageLocators.foodProtectionUploadBtn);
    }

    /**
     * Checks to see if the upload button is displayed after the HACCP cert is selected
     * @return Whether or not the HACCP upload button is displayed
     */
    public boolean isHACCPUploadBtnDisplayed() {
        return elementExists(certificationsPageLocators.haccpUploadBtn);
    }

    /**
     * Checks to see if all upload cert buttons are displayed when all certs are selected
     * @return Whether or not all upload cert buttons are displayed
     */
    public boolean areAllCertUploadBtnsDisplayed() {
        return isAlcoholUploadBtnDisplayed() &&
                isFoodHandlerUploadBtnDisplayed() &&
                isFoodProtectionUploadBtnDisplayed() &&
                isHACCPUploadBtnDisplayed();
    }

    /**
     * Checks to see if no upload cert buttons are present when no certs are selected
     * @return Whether or not cert upload buttons are selected
     */
    public boolean areNoCertUploadBtnsDisplayed() {
        return !isAlcoholUploadBtnDisplayed() &&
                !isFoodHandlerUploadBtnDisplayed() &&
                !isFoodProtectionUploadBtnDisplayed() &&
                !isHACCPUploadBtnDisplayed();
    }

    /**
     * Verifies that the success banner is displayed after saving changes
     * @return Whether or not the success banner is displayed
     */
    public boolean verifyCertificationSuccessBanner() {
        return elementExistsLongTimeout(certificationsPageLocators.certsSuccessToastDiv);
    }

    /**
     * Clicks the 'X' button on the success/fail banner on the edit certification page
     */
    public void clickCloseCertificationBannerBtn() {
        wait.until(elementToBeClickable(certificationsPageLocators.certsBannerCloseBtn));
        driver.findElement(certificationsPageLocators.certsBannerCloseBtn).click();
    }

    /**
     * Checks to see if the certifications tooltip is displayed
     * @return Whether or not the certifications tooltip is displayed
     */
    public boolean isCertsTooltipDisplayed() {
        return elementExists(certificationsPageLocators.certsTooltip);
    }

    /**
     * Get certifications title from the certifications tooltip
     * @return The certifications tooltip title
     */
    public String getCertsTitleTooltip() {
        return driver.findElement(certificationsPageLocators.certsTitleTooltip).getText();
    }

    /**
     * Get certifications text from the certifications tooltip
     * @return The certifications tooltip text
     */
    public String getCertsTxtTooltip() {
        return driver.findElement(certificationsPageLocators.certsTxtTooltip).getText();
    }
}
