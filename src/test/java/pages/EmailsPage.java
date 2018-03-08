package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Locators;
import utils.TestConfig;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class EmailsPage extends BasePage {

    Locators.MailinatorLocators mailinatorLocators;
    Actions actions;
    TestUtils testUtils;

    private String parentWindow;

    public EmailsPage(WebDriver driver) {
        super(driver);
        mailinatorLocators = new Locators.MailinatorLocators();
        actions = new Actions(driver);
        testUtils = new TestUtils(driver);
    }

    /**
     * Navigate to the mailinator homepage
     */
    public void loadMailinatorHomePage() {

        driver.get(TestConfig.getMailinatorHomepageUrl());
    }

    /**
     * Open an email in mailinator for the given email address
     * @param email The user's email
     */
    public void openInboxMessageByEmailAddress(String email) throws Exception {
        loadMailinatorHomePage();
        wait.until(elementToBeClickable(mailinatorLocators.inboxField));
        driver.findElement(mailinatorLocators.inboxField).sendKeys(email);
        driver.findElement(mailinatorLocators.checkEmailBtn).click();
        driver.findElement(mailinatorLocators.emailSubjectLink).click();
        Thread.sleep(2000);
    }

    /**
     * Selects the activation action link from the email
     */
    public void selectEmailActivationAction() {
        parentWindow = driver.getWindowHandle();
        WebElement iframe = driver.findElement(mailinatorLocators.iFrame);
        driver.switchTo().frame(iframe);
        driver.findElement(mailinatorLocators.activationActionLink).click();
        driver.switchTo().defaultContent();
        testUtils.switchToNewWindow(parentWindow);
    }

    /**
     * Selects the view job action link from the email
     */
    public void selectEmailViewJobAction() {
        parentWindow = driver.getWindowHandle();
        WebElement iframe = driver.findElement(mailinatorLocators.iFrame);
        driver.switchTo().frame(iframe);
        driver.findElement(mailinatorLocators.viewJobActionLink).click();
        driver.switchTo().defaultContent();
        testUtils.switchToNewWindow(parentWindow);
    }

    /**
     * Selects the view job action link from the email
     */
    public void selectEmailViewApplicantAction() {
        parentWindow = driver.getWindowHandle();
        WebElement iframe = driver.findElement(mailinatorLocators.iFrame);
        driver.switchTo().frame(iframe);
        driver.findElement(mailinatorLocators.viewApplicantActionLink).click();
        driver.switchTo().defaultContent();
        testUtils.switchToNewWindow(parentWindow);
    }
}
