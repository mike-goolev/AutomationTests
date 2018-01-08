import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyProfileEditPage extends BasePage {

    Locators.EditProfilePageLocators editProfilePageLocators;

    public HourlyProfileEditPage(WebDriver driver) {
        super(driver);
        editProfilePageLocators = new Locators.EditProfilePageLocators();
    }

    /**
     * Clicks the Personal Info link from the side menu on the edit profile page
     */
    public void clickSideMenuPersonalInfoLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfilePersonalInfoLink));
        driver.findElement(editProfilePageLocators.editProfilePersonalInfoLink).click();
    }

    /**
     * Clicks the Experience link from the side menu on the edit profile page
     */
    public void clickSideMenuExperienceLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileExperienceLink));
        driver.findElement(editProfilePageLocators.editProfileExperienceLink).click();
    }

    /**
     * Clicks the Work Availability link from the side menu on the edit profile page
     */
    public void clickSideMenuWorkAvailabilityLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileWorkAvailabilityLink));
        driver.findElement(editProfilePageLocators.editProfileWorkAvailabilityLink).click();
    }

    /**
     * Clicks the Skills link from the side menu on the edit profile page
     */
    public void clickSideMenuSkillsLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileSkillsLink));
        driver.findElement(editProfilePageLocators.editProfileSkillsLink).click();
    }

    /**
     * Clicks the Certifications link from the side menu on the edit profile page
     */
    public void clickSideMenuCertificationsLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileCertificationsLink));
        driver.findElement(editProfilePageLocators.editProfileCertificationsLink).click();
    }

    /**
     * Clicks the About link from the side menu on the edit profile page
     */
    public void clickSideMenuAboutLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileAboutLink));
        driver.findElement(editProfilePageLocators.editProfileAboutLink).click();
    }

    /**
     * Clicks the Education link from the side menu on the edit profile page
     */
    public void clickSideMenuEducationLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileEducationLink));
        driver.findElement(editProfilePageLocators.editProfileEducationLink).click();
    }

    /**
     * Clicks the View Profile link from the side menu on the edit profile page
     */
    public void clickSideMenuViewProfileLink() {
        wait.until(elementToBeClickable(editProfilePageLocators.editProfileViewProfileLink));
        driver.findElement(editProfilePageLocators.editProfileViewProfileLink).click();
    }
}
