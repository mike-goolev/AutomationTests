import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HourlyLoginPage extends BasePage {

    Locators.LoginPageLocators loginPageLocators;
    TestUtils testUtils;

    public HourlyLoginPage(WebDriver driver) {
        super(driver);
        loginPageLocators = new Locators.LoginPageLocators();
        testUtils = new TestUtils(driver);
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
        driver.findElement(loginPageLocators.loginBtn).click();
    }

    /**
     * Logs the user in with Facebook email/password credentials
     * @param email User's Facebook email
     * @param password User's Facebook password
     */
    public void loginWithFacebook(String email, String password) {
        String parentWindow = driver.getWindowHandle();
        wait.until(elementToBeClickable(loginPageLocators.loginFacebookBtn));
        driver.findElement(loginPageLocators.loginFacebookBtn).click();
        testUtils.switchToNewWindow(parentWindow);
        wait.until(elementToBeClickable(loginPageLocators.faceBookEmailField));
        driver.findElement(loginPageLocators.faceBookEmailField).sendKeys(email);
        driver.findElement(loginPageLocators.faceBookPasswordField).sendKeys(password);
        driver.findElement(loginPageLocators.facebookLoginBtn).click();
        testUtils.switchToParentWindow(parentWindow);
    }
}
