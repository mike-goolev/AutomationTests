import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EmployerProfileEditPage extends BasePage {

    Locators.EmployerProfileEditPageLocators employerProfileEditPageLocators;
    EmployerProfileViewPage employerProfileViewPage;

    public EmployerProfileEditPage(WebDriver driver) {
        super(driver);
        employerProfileEditPageLocators = new Locators.EmployerProfileEditPageLocators();
        employerProfileViewPage = new EmployerProfileViewPage(driver);
    }

    /**
     * Selects the Info link from the side menu on the edit profile page
     */
    public void selectMenuInfoLink() {
        wait.until(elementToBeClickable(employerProfileEditPageLocators.employerProfileEditInfoBtn));
        driver.findElement(employerProfileEditPageLocators.employerProfileEditInfoBtn).click();
    }

    /**
     * Selects the Photos link from the side menu on the edit profile page
     */
    public void selectMenuPhotosLink() {
        wait.until(elementToBeClickable(employerProfileEditPageLocators.employerProfileEditPhotosBtn));
        driver.findElement(employerProfileEditPageLocators.employerProfileEditPhotosBtn).click();
    }

    /**
     * Selects the About link from the side menu on the edit profile page
     */
    public void selectMenuAboutLink() {
        wait.until(elementToBeClickable(employerProfileEditPageLocators.employerProfileEditAboutBtn));
        driver.findElement(employerProfileEditPageLocators.employerProfileEditAboutBtn).click();
    }

    /**
     * Selects the Hiring link from the side menu on the edit profile page
     */
    public void selectMenuHiringLink() {
        wait.until(elementToBeClickable(employerProfileEditPageLocators.employerProfileEditJobsBtn));
        driver.findElement(employerProfileEditPageLocators.employerProfileEditJobsBtn).click();
    }

    /**
     * Selects the View Profile link from the side menu on the edit profile page
     */
    public void selectMenuViewProfileLink() {
        driver.findElement(employerProfileEditPageLocators.employerProfileEditViewProfileBtn).click();
        employerProfileViewPage.waitForLoadingIndicator();
    }
}
