import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class NavPage extends BasePage {

    Locators.NavPageLocators navPageLocators;

    public NavPage(WebDriver driver) {
        super(driver);
        navPageLocators = new Locators.NavPageLocators();
    }

    /*---------- Non auth'd methods ---------*/

    /**
     * Clicks the login link in the nav header
     */
    public void clickLoginBtn() {
        wait.until(elementToBeClickable(navPageLocators.loginBtn));
        driver.findElement(navPageLocators.loginBtn).click();
    }

    /**
     * Clicks the join link in the nav header
     */
    public void clickJoinBtn() {
        wait.until(elementToBeClickable(navPageLocators.signUpBtn));
        driver.findElement(navPageLocators.signUpBtn).click();
    }

    /*---------- Auth'd methods ---------*/

    /**
     * Checks to see if the user avatar is displayed in the menu

     * @return Whether or not the user avatar is displayed in the menu
     */
    public boolean isNavMenuAvatarDisplayed() {
        return elementExists(navPageLocators.userAvatarImg);
    }

    /**
     * Checks to see if the user photo is displayed in the menu

     * @return Whether or not the user photo is displayed in the menu
     */
    public boolean isNavMenuPhotoDisplayed() {
        return elementExists(navPageLocators.userPhotoImg);
    }

    /**
     * Get user's first name and last name initial from the menu text

     * @return User's first name and last name initial
     */
    public String getUserFirstNameLastInitial() {
        return driver.findElement(navPageLocators.userNameTxt).getText();
    }

    /**
     * Takes the user to the My Home page
     */
    public void navigateToMyHomePage() {
        wait.until(elementToBeClickable(navPageLocators.myHomeBtn));
        driver.findElement(navPageLocators.myHomeBtn).click();
    }

    /**
     * Takes the user to the jobs page
     */
    public void navigateToJobsPage() {
        wait.until(elementToBeClickable(navPageLocators.findJobsBtn));
        driver.findElement(navPageLocators.findJobsBtn).click();
    }

    /**
     * Takes the user to the profile page via nav header and clicking profile
     */
    public void navigateToProfilePage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        wait.until(elementToBeClickable(navPageLocators.menuProfileBtn));
        driver.findElement(navPageLocators.menuProfileBtn).click();
    }

    /**
     * Takes the user to the settings page via nav header and clicking settings
     */
    public void navigateToSettingsPage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuSettingsBtn).click();
    }

    /**
     * Clicks on the "Okay, got it." button to dismiss the rebranding modal
     */
    public void dismissRebrandingModal() {
        wait.until(elementToBeClickable(navPageLocators.rebrandingModalBtn));
        driver.findElement(navPageLocators.rebrandingModalBtn).click();
    }

    /**
     * Logs the user out via nav header and clicking log out
     */
    public void logout() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuLogoutBtn).click();
    }

    /**
     * Attempts to log the user out of the web app. Handles errors so that tear down can finish shutting down selenium.
     * This method is intended to be used in the tearDown() method.
     */
    public void attemptLogout() {
        try {
            logout();
        }
        catch(Exception e) {
            System.out.println("An error occurred while attempting to log the user out of the app.");
            System.out.println(e.getLocalizedMessage());
        }
    }
}
