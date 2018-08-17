package pages;

import org.openqa.selenium.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import utils.TestUtils;
import utils.Locators;

public class HomePage extends BasePage {

    Locators.LoginPageLocators loginPageLocators;
    TestUtils testUtils;

    public HomePage (WebDriver driver) {
        super(driver);
        testUtils = new TestUtils(driver);
        loginPageLocators = new Locators.LoginPageLocators();
    }

    public By signUpWithFbBtn = By.id("signUpFacebookBtn");
    public By registerWithEmailBtn = By.id("seasonedHomeJoinBtn");
    public By signInLink = By.id("seasonedHomeSignInLinks");

    public void clickSignInLink() {
        wait.until(elementToBeClickable(signInLink));
        driver.findElement(signInLink).click();
    }

    public void signUpWithFbBtn(String fbEmail, String fbPassword) {
        String parentWindow = driver.getWindowHandle();
        wait.until(elementToBeClickable(signUpWithFbBtn));
        driver.findElement(signUpWithFbBtn).click();
        testUtils.switchToNewWindow(parentWindow);
        wait.until(elementToBeClickable(loginPageLocators.faceBookEmailField));
        driver.findElement(loginPageLocators.faceBookEmailField).sendKeys(fbEmail);
        driver.findElement(loginPageLocators.faceBookPasswordField).sendKeys(fbPassword);
        driver.findElement(loginPageLocators.facebookLoginBtn).click();
        testUtils.switchToParentWindow(parentWindow);
    }
}
