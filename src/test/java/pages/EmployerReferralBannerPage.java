package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class EmployerReferralBannerPage extends BasePage {

    protected EmployerReferralBannerLocators employerReferralBannerLocators;

    public class EmployerReferralBannerLocators{
        public By referralBannerCloseBtn = By.id("referralsbannerSMCloseIcon");
    }
    public EmployerReferralBannerPage(WebDriver driver) {
        super(driver);
        employerReferralBannerLocators = new EmployerReferralBannerPage.EmployerReferralBannerLocators();
    }

    public boolean checkReferralBannerCloseBtnExists(){
        return elementExists(employerReferralBannerLocators.referralBannerCloseBtn);
    }

    /**
     * Selects the close referral banner button
     */
    public void selectCloseReferralBannerBtn() {
       if(checkReferralBannerCloseBtnExists()){
           driver.findElement(employerReferralBannerLocators.referralBannerCloseBtn).click();
           wait.until(invisibilityOfElementLocated(employerReferralBannerLocators.referralBannerCloseBtn));}
    }
}
