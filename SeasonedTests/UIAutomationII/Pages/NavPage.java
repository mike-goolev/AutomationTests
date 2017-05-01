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
     * Clicks the managers link in the nav header
     */
    public void clickManagersBtn() {
        wait.until(elementToBeClickable(navPageLocators.managerBtn));
        driver.findElement(navPageLocators.managerBtn).click();
    }

    /*---------- Auth'd methods ---------*/

    /**
     * Takes the user to the profile page via nav header and clicking profile
     */
    public void navigateToProfilePage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuProfileLink).click();
    }

    /**
     * Takes the user to the settings page via nav header and clicking settings
     */
    public void navigateToSettingsPage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuSettingsLink).click();
    }

    /**
     * Logs the user out via nav header and clicking log out
     */
    public void logout() {
        wait.until(elementToBeClickable(navPageLocators.userPhotoBtn));
        driver.findElement(navPageLocators.userPhotoBtn).click();
        driver.findElement(navPageLocators.menuLogoutLink).click();
    }

    /**
     * Waits for activity indicator
     */
    public void waitForActivtyIndicator() {
        wait.until(presenceOfElementLocated(navPageLocators.loader));
        wait.until(invisibilityOfElementLocated(navPageLocators.loader));
    }
}
