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
     * Takes the user to the profile page via nav header and clicking profile
     */
    public void navigateToProfilePage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
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
     * Logs the user out via nav header and clicking log out
     */
    public void logout() {
        wait.until(elementToBeClickable(navPageLocators.userPhotoBtn));
        driver.findElement(navPageLocators.userPhotoBtn).click();
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
            System.out.println("An error occured while attempting to log the user out of the app.");
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Waits for activity indicator

    public void waitForActivtyIndicator() {
        wait.until(presenceOfElementLocated(navPageLocators.loader));
        wait.until(invisibilityOfElementLocated(navPageLocators.loader));
    }
     */
}
