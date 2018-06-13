package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return true;
    }

    /**
     * Checks to see if a checkbox is in a selected state by looking at the aria-checked attribute for true
     * @param box The web element for the checkbox
     * @return whether or not a checkbox has been selected
     */
    public boolean isCheckboxSelected(WebElement box) {
        if(box.getAttribute("aria-checked").contains("true")) {
            return true;
        }

        return false;
    }

    /**
     * Checks to see if a card is in a selected state by looking at the class attribute for selected
     * @param card the web element for the card
     * @return whether or not a card has been selected
     */
    public boolean isCardSelected(WebElement card) {
        if(card.getAttribute("class").contains("selected")) {
            return true;
        }

        return false;
    }
}
