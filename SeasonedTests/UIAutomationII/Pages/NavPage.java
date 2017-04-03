import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class NavPage extends BasePage {

    Locators.NavPageLocators navPageLocators;

    public NavPage(WebDriver driver) {
        super(driver);
        navPageLocators = new Locators.NavPageLocators();
    }

    /* Non auth methods */
    public void clickLoginBtn() {
        wait.until(elementToBeClickable(navPageLocators.loginBtn));
        driver.findElement(navPageLocators.loginBtn).click();
    }

    public void clickManagersBtn() {
        wait.until(elementToBeClickable(navPageLocators.managerBtn));
        driver.findElement(navPageLocators.managerBtn).click();
    }

    /* Auth'd methods */
    public void navigateToProfilePage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuProfileLink).click();
    }

    public void navigateToSettingsPage() {
        wait.until(elementToBeClickable(navPageLocators.userNameBtn));
        driver.findElement(navPageLocators.userNameBtn).click();
        driver.findElement(navPageLocators.menuSettingsLink).click();
    }

    public void logout(){
        wait.until(elementToBeClickable(navPageLocators.userPhotoBtn));
        driver.findElement(navPageLocators.userPhotoBtn).click();
        driver.findElement(navPageLocators.menuLogoutLink).click();
    }
}
