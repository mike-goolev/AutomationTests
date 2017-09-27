import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class EmployerSignUpPage extends BasePage {

    Locators.EmployerSignUpLocators employerSignUpLocators;
    TestUtils testUtils;

    public EmployerSignUpPage(WebDriver driver) {
        super(driver);
        employerSignUpLocators = new Locators.EmployerSignUpLocators();
        testUtils = new TestUtils(driver);
    }

    /**
     * Get location title text
     * @return The location page's title text
     */
    public String getTitleTxt(){
        return driver.findElement(employerSignUpLocators.signUpTitleTxt).getText();
    }

    /**
     * Selects the 'Back' button to return to hourly sign up page
     */
    public void clickBackBtn(){
        wait.until(elementToBeClickable(employerSignUpLocators.signUpBackBtn));
        driver.findElement(employerSignUpLocators.signUpByEmailBtn).click();
    }
}
