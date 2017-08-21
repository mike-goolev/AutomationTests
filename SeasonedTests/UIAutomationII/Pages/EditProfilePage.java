import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EditProfilePage extends BasePage {

    Locators.ProfileNavPageLocators profileNavPageLocators;

    public EditProfilePage(WebDriver driver) {
        super(driver);
        profileNavPageLocators = new Locators.ProfileNavPageLocators();
    }

    /**
     * Clicks the Personal Info link from the side menu on the edit profile page
     */
    public void clickSideMenuPersonalInfoLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfilePersonalInfoLink));
        driver.findElement(profileNavPageLocators.editProfilePersonalInfoLink).click();
    }

    /**
     * Clicks the Experience link from the side menu on the edit profile page
     */
    public void clickSideMenuExperienceLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileExperienceLink));
        driver.findElement(profileNavPageLocators.editProfileExperienceLink).click();
    }

    /**
     * Clicks the Work Availability link from the side menu on the edit profile page
     */
    public void clickSideMenuWorkAvailabilityLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileWorkAvailabilityLink));
        driver.findElement(profileNavPageLocators.editProfileWorkAvailabilityLink).click();
    }

    /**
     * Clicks the Skills link from the side menu on the edit profile page
     */
    public void clickSideMenuSkillsLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileSkillsLink));
        driver.findElement(profileNavPageLocators.editProfileSkillsLink).click();
    }

    /**
     * Clicks the Certifications link from the side menu on the edit profile page
     */
    public void clickSideMenuCertificationsLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileCertificationsLink));
        driver.findElement(profileNavPageLocators.editProfileCertificationsLink).click();
    }

    /**
     * Clicks the About link from the side menu on the edit profile page
     */
    public void clickSideMenuAboutLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileAboutLink));
        driver.findElement(profileNavPageLocators.editProfileAboutLink).click();
    }

    /**
     * Clicks the View Profile link from the side menu on the edit profile page
     */
    public void clickSideMenuViewProfileLink() {
        wait.until(elementToBeClickable(profileNavPageLocators.editProfileViewProfileLink));
        driver.findElement(profileNavPageLocators.editProfileViewProfileLink).click();
    }
}
