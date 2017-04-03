import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

    Locators.AboutPageLocators aboutPageLocators = new Locators.AboutPageLocators();

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter in some text in to the field and save
     * @param s The text to enter in to the field
     */
    public void addAboutTxt(String s) {
        enterAboutTxt(s);
        clickSaveBtn();
    }

    /**
     * Removes all text in the about text field and saves.
     */
    public void removeAboutTxt() {
        clearAboutTxtField();
        clickSaveBtn();
    }

    /**
     * Check to see if the about text field is empty
     * @return Whether or not the about text field is empty or not
     */
    public boolean aboutTxtFieldIsEmpty() {
        return driver.findElement(aboutPageLocators.aboutTextField).getText().equals("");
    }

    /**
     * Check to see the if the about text field equals the text parameter
     * @param text The text to compare against
     * @return Whether or not the text in the about field is the same as the text parameter
     */
    public boolean aboutTxtEquals(String text) {
        return driver.findElement(aboutPageLocators.aboutTextField).getText().equals(text);
    }

    /**
     * Enter text in to the about text field
     * @param text
     */
    public void enterAboutTxt(String text) {
        driver.findElement(aboutPageLocators.aboutTextField).sendKeys(text);
    }

    /**
     * Click the save button
     */
    public void clickSaveBtn() {
        driver.findElement(aboutPageLocators.aboutSaveBtn).click();
    }

    /**
     * Clears out about text field
     */
    public void clearAboutTxtField() {
        int textLength = driver.findElement(aboutPageLocators.aboutTextField).getText().length();
        driver.findElement(aboutPageLocators.aboutTextField).click();
        for(int i = 0; i < textLength; i++) {
            driver.findElement(aboutPageLocators.aboutTextField).sendKeys("\u0008");
        }
    }
}
