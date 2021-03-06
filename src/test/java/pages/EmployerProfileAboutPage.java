package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import utils.Locators;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class EmployerProfileAboutPage extends BasePage {

    Locators.EmployerProfileEditAboutPageLocators employerProfileEditAboutPageLocators;
    public EmployerProfileAboutPage(WebDriver driver) {
        super(driver);
        employerProfileEditAboutPageLocators = new Locators.EmployerProfileEditAboutPageLocators();
    }

    /**
     * Get about title text
     * @return The about title text
     */
    public String getAboutTitleTxt() {
        return driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutTitleTxt).getText();
    }

    /**
     * Get about text
     * @return The about text
     */
    public String getAboutTxt() {
        return driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutField).getText();
    }

    /**
     * Add employer about description
     * @param description the employer's about description
     */
    public void addAboutDescription(String description){
        driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutField).sendKeys(description);
    }

    /**
     * Delete employer about description
     */
    public void deleteAboutDescription(){
        driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutField).clear();
    }

    /**
     * Update employer about description
     * @param description the employer's about description
     */
    public void updateAboutDescription(String description){
        deleteAboutDescription();
        addAboutDescription(description);
    }

    /**
     * Checks to see if the employer about save button is enabled
     * @return Whether or not the employer about save button is enabled
     */
    public boolean isSaveButtonEnabled(){
        return (driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutSaveBtn).isEnabled());
    }

    /**
     * Selects the employer about save button
     */
    public void selectSaveBtn(){
        driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutSaveBtn).click();
        wait.until(presenceOfElementLocated(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToast));
    }

    /**
     * Checks to see if the employer about success toast is visible
     * @return Whether or not the employer about success toast is visible
     */
    public boolean verifyEmployerAboutSuccessToast(){
        wait.until(visibilityOfElementLocated(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToast));
        return driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToast).isDisplayed();
    }

    /**
     * Selects the 'X' to dismiss the employer about success toast
     */
    public void dismissEmployerAboutSuccessToast(){
        wait.until(elementToBeClickable(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToastDismissBtn));
        driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToastDismissBtn).click();
        wait.until(invisibilityOfElementLocated(employerProfileEditAboutPageLocators.employerProfileEditAboutSuccessToast));
    }

    /**
     * Checks to see if the employer about tooltip is displayed
     * @return Whether or not the employer about tooltip is displayed
     */
    public boolean isEmployerAboutTooltipDisplayed() {
        return elementExists(employerProfileEditAboutPageLocators.employerProfileEditAboutTooltipTitle) &&
        elementExists(employerProfileEditAboutPageLocators.employerProfileEditAboutTooltipTxt);
    }

    /**
     * Waits for the loading indicator on the view profile page
     */
    public void waitForLoader() {
        try {
            if (driver.findElement(employerProfileEditAboutPageLocators.employerProfileEditAboutSaveSpinner).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(employerProfileEditAboutPageLocators.employerProfileEditAboutSaveSpinner));
            }
        } catch (NoSuchElementException e) {
            System.out.println("***\n" + "Loader not displayed due to NoSuchElementException..." + "\n***");
        } catch (StaleElementReferenceException se) {
            System.out.println("***\n" +"Loader not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }
}
