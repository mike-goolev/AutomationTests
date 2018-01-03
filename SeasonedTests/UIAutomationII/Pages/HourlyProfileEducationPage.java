import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyProfileEducationPage extends BasePage {

    Locators.EducationPageLocators educationPageLocators;
    TestUtils testUtils;

    public HourlyProfileEducationPage(WebDriver driver) {
        super(driver);
        educationPageLocators = new Locators.EducationPageLocators();
        testUtils = new TestUtils(driver);
    }

    /**
     * Enters in the supplied text to the education school field
     * @param school The text to enter in to the school field
     */
    public void enterSchoolTxt(String school) {
        wait.until(elementToBeClickable(educationPageLocators.educationSchoolTxtField));
        driver.findElement(educationPageLocators.educationSchoolTxtField).sendKeys(school);
    }

    /**
     * Enters in the supplied text to the education degree field
     * @param degree The text to enter in the degree field
     */
    public void enterDegreeTxt(String degree) {
        wait.until(elementToBeClickable(educationPageLocators.educationDegreeTxtField));
        driver.findElement(educationPageLocators.educationDegreeTxtField).sendKeys(degree);
    }

    /**
     * Clicks the save button on the education page
     */
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationSaveBtn));
        driver.findElement(educationPageLocators.educationSaveBtn).click();
    }

    /**
     * Clicks the cancel button on the education page
     */
    public void clickCancelBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationCancelBtn));
        driver.findElement(educationPageLocators.educationCancelBtn).click();
    }

    /**
     * Clicks the delete button on the education page
     */
    public void clickDeleteBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationDeleteBtn));
        driver.findElement(educationPageLocators.educationDeleteBtn).click();
    }

    /**
     * Clicks the delete button on the delete education modal
     */
    public void clickDeleteModalDeleteBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationDeleteModalDeleteBtn));
        driver.findElement(educationPageLocators.educationDeleteModalDeleteBtn).click();
    }

    /**
     * Clicks the cancel button on the delete education modal
     */
    public void clickDeleteModalCancelBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationDeleteModalCancelBtn));
        driver.findElement(educationPageLocators.educationDeleteModalCancelBtn).click();
    }

    /**
     * Clicks on the edit education button at a given index
     * @param index Index of the edit education button to click on
     */
    public void clickEditEducationBtn(String index) {
        wait.until(elementToBeClickable(educationPageLocators.editEducationBtn(index)));
        driver.findElement(educationPageLocators.editEducationBtn(index)).click();
    }

    /**
     * Clicks the 'X' button on the green success banner
     */
    public void clickCloseSuccessBannerBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationSuccessToastCloseBtn));
        driver.findElement(educationPageLocators.educationSuccessToastCloseBtn).click();
    }

    /**
     * Clicks the 'X' button on the edit education green success banner
     */
    public void clickCloseEditSuccessBannerBtn() {
        wait.until(elementToBeClickable(educationPageLocators.educationEditSuccessToastCloseBtn));
        driver.findElement(educationPageLocators.educationEditSuccessToastCloseBtn).click();
    }

    /**
     * Opens the from year drop down and selects the supplied year
     * @param year The year string to select in the drop down
     */
    public void selectFromYear(String year) {
        wait.until(elementToBeClickable(educationPageLocators.educationFromDateSelect));
        Select fromYearSelect = new Select(driver.findElement(educationPageLocators.educationFromDateSelect));
        fromYearSelect.selectByVisibleText(year);
    }

    /**
     * Opens the to year drop down and selects the supplied year
     * @param year The year string to select in the drop down
     */
    public void selectToYear(String year) {
        wait.until(elementToBeClickable(educationPageLocators.educationToDateSelect));
        Select toYearSelect = new Select(driver.findElement(educationPageLocators.educationToDateSelect));
        toYearSelect.selectByVisibleText(year);
    }

    /**
     * Verifies that the green success banner is displayed
     * @return Whether or not the green success banner is displayed after saving changes
     */
    public boolean verifyEducationSuccessBanner() {
        return elementExistsLongTimeout(educationPageLocators.educationSuccessToast);
    }

    /**
     * Verifies that the green success banner is displayed after editing an education
     * @return Whether or not the green success banner is displayed after saving changes
     */
    public boolean verifyEditEducationSuccessBanner() {
        return elementExistsLongTimeout(educationPageLocators.educationEditSuccessToast);
    }

}
