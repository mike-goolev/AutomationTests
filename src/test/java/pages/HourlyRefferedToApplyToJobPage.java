package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HourlyRefferedToApplyToJobPage extends BasePage{

    protected HourlyRefferedToApplyToJobLocators hourlyRefferedToApplyToJobLocators;

    public class HourlyRefferedToApplyToJobLocators{

        public By referredWelcomeDialog = By.id("referralWelcomeInterviewDialogBasicDialog");
        public By referredWelcomeDialogHeader = By.xpath(".//div[@class='content-wrapper']/h4");
        public By referredWelcomeDialogText = By.xpath(".//div[@class='content-wrapper']/p");
        public By getReferredWelcomeDialogCloseBtn = By.id("closeDialogBtn");

    }

    public HourlyRefferedToApplyToJobPage(WebDriver driver) {
        super(driver);
        hourlyRefferedToApplyToJobLocators = new HourlyRefferedToApplyToJobPage.HourlyRefferedToApplyToJobLocators();
    }

    public boolean checkReferredWelcomeDialogExists(){
        return  elementExists(hourlyRefferedToApplyToJobLocators.referredWelcomeDialog);
    }
    /**
     * Gets the Referred Welcome Dialog Header
     * @return
     */
    public String getReferredWelcomeDialogTitle(){
        return driver.findElement(hourlyRefferedToApplyToJobLocators.referredWelcomeDialogHeader).getText();
    }

    /**
     * Gets Referred Welcome Dialog Info Text
     * @return
     */
    public String getReferredWelcomeDialogText(){
        return driver.findElement(hourlyRefferedToApplyToJobLocators.referredWelcomeDialogText).getText();
    }

    /**
     * Clicks Let's See it button
     */
    public void clickReferredWelcomeDialogLetsSeeItBtn(){
        driver.findElement(hourlyRefferedToApplyToJobLocators.getReferredWelcomeDialogCloseBtn).click();
    }

}
