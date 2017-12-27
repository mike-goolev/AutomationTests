import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HourlyAutoprovisionSignupPage extends BasePage {
    Locators.AutoProvisionSignUpLocators autoProvisionSignUpLocators;
    Locators.NavPageLocators navPageLocators;
    TestUtils testUtils;
    NavPage navPage;

    public HourlyAutoprovisionSignupPage(WebDriver driver) {
        super(driver);
        autoProvisionSignUpLocators = new Locators.AutoProvisionSignUpLocators();
        navPageLocators = new Locators.NavPageLocators();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
    }

    /**
     * Register user with an email and password
     *
     * @param password  User's password
     */
    public void registerEmail(String password) throws Exception {
        wait.until(visibilityOfElementLocated(autoProvisionSignUpLocators.passwordField));
        driver.findElement(autoProvisionSignUpLocators.passwordField).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(autoProvisionSignUpLocators.createAccountBtn).submit();
        wait.until(visibilityOfElementLocated(navPageLocators.userNameBtn));
    }
}
