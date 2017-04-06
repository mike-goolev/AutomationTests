import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Checks to see if a given element exists on the page
     * @param identifier In this case, the by object e.g. basicInfoPageLocators.transportYesBtnSelected
     * @return Whether or not the element exists
     */
    public boolean elementExists(By identifier) {
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(identifier);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return true;
    }
}
