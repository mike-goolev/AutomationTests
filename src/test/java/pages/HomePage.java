package pages;

import org.openqa.selenium.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import utils.TestUtils;

public class HomePage extends BasePage {

    TestUtils testUtils;

    public HomePage (WebDriver driver) {
        super(driver);
        testUtils = new TestUtils(driver);
    }

    public By signUpWithFbBtn = By.id("signUpFacebookBtn");
    public By registerWithEmailBtn = By.id("seasonedHomeJoinBtn");
    public By signInLink = By.id("seasonedHomeSignInLinks");

    public void clickSignInLink() {
        wait.until(elementToBeClickable(signInLink));
        driver.findElement(signInLink).click();
    }

}
