package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class EmployerRequestReferralPage extends BasePage {

    protected RequestReferralModalLocators employerRequestReferralModalLocators ;

    public  class RequestReferralModalLocators{
        public By requestReferralModal = By.id("requestReferralsBasicDialog");
        public By requestReferralModalCloseBtn = By.id("requestReferralsDialogCloseBtn");
        public By requestReferralModalTitle = By.xpath("//div[@id='requestReferralsBasicDialog']/h4");
        public By requestReferralModalDescription = By.xpath("//div[@id='requestReferralsBasicDialog']/p");
        public By requestReferralModalReferralsLabel = By.id("requestReferralsSearchUsersDropdownLabelTxt");
        public By requestReferralModalNameorEmailInputDropdown = By.id("requestReferralsSearchUsersDropdownInput");
        public By requestReferralModalNameList = By.id("undefinedUserNameTxt");
        public By requestReferralModalMessage = By.id("requestReferralsMessageInput");
        public By requestReferralModalGetReferralBtn = By.id("requestReferralsGetBtn");
        public By requestReferralSuccessfulToast = By.id("requestReferralsToast");
    }

    public EmployerRequestReferralPage(WebDriver driver) {
        super(driver);
        employerRequestReferralModalLocators = new RequestReferralModalLocators();
    }

    /**
     * Closes the Referral Modal
     */
    public void closeRequestRefferalPage(){
        if (elementExists(employerRequestReferralModalLocators.requestReferralModal)){
            driver.findElement(employerRequestReferralModalLocators.requestReferralModalCloseBtn).click();
        }

    }

    /**
     * Gets the Request Referral Modal title
     * @return
     */
    public String getRequestReferralModaltitle(){
        return driver.findElement(employerRequestReferralModalLocators.requestReferralModalTitle).getText();
    }

    /**
     * Gets the Request Referral Modal description
     * @return
     */
    public String getRequestReferralDescription(){
        return driver.findElement(employerRequestReferralModalLocators.requestReferralModalDescription).getText();
    }

    /**
     * Gets the label of referrals input box
     * @return
     */
    public String getRequestReferralModalReferralsInputLabel(){
        return driver.findElement(employerRequestReferralModalLocators.requestReferralModalReferralsLabel).getText();
    }

    /**
     * Gets the placeholder of Message input text area
     * @return
     */
    public String getRequestReferralModalMessagePlaceholder(){
        return driver.findElement(employerRequestReferralModalLocators.requestReferralModalMessage).getAttribute("placeholder");
    }

    /**
     * Enter Rererrer Name
     * @param name
     * @throws InterruptedException
     */
    public void enterRequestReferralModalReferrerName(String name) throws InterruptedException {
        driver.findElement(employerRequestReferralModalLocators.requestReferralModalNameorEmailInputDropdown).click();
        Thread.sleep(3000);
        driver.findElement(employerRequestReferralModalLocators.requestReferralModalNameorEmailInputDropdown).sendKeys(name);

    }

    /**
     * Selects Referrer Name from Dropdown list
     */
    public void selectRequestReferralModalReferrerFromDropdownList(){
        wait.until(elementToBeClickable(employerRequestReferralModalLocators.requestReferralModalNameList));
        driver.findElement(employerRequestReferralModalLocators.requestReferralModalNameList).click();

    }

    /**
     * checks if Get Referrals Button is enabled/disabled
     * @return
     */
    public boolean checkRequestReferralModalGetReferralsBtnEnabled(){
        return driver.findElement(employerRequestReferralModalLocators.requestReferralModalGetReferralBtn).isEnabled();

    }

    /**
     * Click Get Referrals Button
     */
    public void clickRequestReferralModalGetReferralsBtn(){
        driver.findElement(employerRequestReferralModalLocators.requestReferralModalGetReferralBtn).click();

    }

    /**
     * Verify if Get Referrals Successful Toast is displayed or not
     * @return
     */
    public boolean checkReferralsSuccessToastDisplayed(){
        wait.until(visibilityOfElementLocated(employerRequestReferralModalLocators.requestReferralSuccessfulToast));
        return elementExists(employerRequestReferralModalLocators.requestReferralSuccessfulToast);
    }

}
