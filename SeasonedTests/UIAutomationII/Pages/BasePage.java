import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    /**
     * Checks to see if a given element exists on the page using a 5 second implicit wait
     * @param identifier In this case, the by object e.g. basicInfoPageLocators.transportYesBtnSelected
     * @return Whether or not the element exists
     */
    public boolean elementExistsLongTimeout(By identifier) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(identifier);
        }
        catch(NoSuchElementException e) {
            return false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return true;
    }

    /**
     * Checks to see if a checkbox is in a selected state by looking at the class attribute for checked
     * @param box the web element for the checkbox
     * @return whether or not a checkbox has been selected
     */
    public boolean isCheckboxSelected(WebElement box) {
        if(box.getAttribute("class").contains("checked")) {
            return true;
        }

        return false;
    }
}
