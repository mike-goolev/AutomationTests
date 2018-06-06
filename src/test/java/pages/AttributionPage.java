package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;
import utils.TestUtils;

public class AttributionPage extends BasePage {

    Locators.AttributionModal attributionModal ;
    TestUtils testUtils;

    public AttributionPage(WebDriver driver) {
        super(driver);
        attributionModal = new Locators.AttributionModal();
        testUtils = new TestUtils(driver);
    }

    /**
     * Check if Attribution modal is open
     * @return
     */
    public boolean attributionModalExists(){
        return elementExists(attributionModal.attributionModal);
    }

    /**
     * Select Attribution from dropdown list by providing index
     * @param index
     */
    public void selectAttributionByIndex(String index){
        driver.findElement(attributionModal.attributionDropdown).click();
        driver.findElement(attributionModal.getAttrigutionByIndex(index)).click();
    }

    /**
     * Submit Attribution option
     */
    public void clickDoneBtn(){
        driver.findElement(attributionModal.attributionDoneBtn).click();
    }

    /**
     * Close Attribution Modal using top X button
     */
    public void closeAttributionModal(){
        driver.findElement(attributionModal.attributionCloseBtn).click();
    }

    /**
     * If Attribution modal is displayed, dismiss it by clicking X button
     */
    public void dismissAttributionModal(){
        if(attributionModalExists()){
            closeAttributionModal();
        }
    }
}
