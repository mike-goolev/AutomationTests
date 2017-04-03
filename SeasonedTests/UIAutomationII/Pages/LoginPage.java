import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BasePage {

    Locators.LoginPageLocators loginPageLocators;

    public LoginPage(WebDriver driver) {
        super(driver);
        loginPageLocators = new Locators.LoginPageLocators();
    }

    /**
     * Logs the user in with the standard email/password format
     * @param email User's email their account is associated with
     * @param password User's password for their account
     */
    public void loginWithEmail(String email, String password) {
        wait.until(elementToBeClickable(loginPageLocators.emailTxtField));
        driver.findElement(loginPageLocators.emailTxtField).sendKeys(email);
        driver.findElement(loginPageLocators.passwordTxtField).sendKeys(password);
        driver.findElement(loginPageLocators.loginButton).click();
    }
}
