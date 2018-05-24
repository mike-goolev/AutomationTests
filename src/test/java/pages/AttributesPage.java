package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;
import utils.TestUtils;

public class AttributesPage extends BasePage {

    Locators.AttributionModal attributionModal ;
    TestUtils testUtils;

    public AttributesPage(WebDriver driver) {
        super(driver);
        attributionModal = new Locators.AttributionModal();
        testUtils = new TestUtils(driver);
    }

    protected boolean attributionModalExists(){
        return elementExists(attributionModal.attributionModal);
    }
    protected void selectAttributionByIndex(String index){
        driver.findElement(attributionModal.attributionDropdown).click();
        driver.findElement(attributionModal.getAttrigutionByIndex(index)).click();
    }
    protected void clickDoneBtn(){
        driver.findElement(attributionModal.attributionDoneBtn).click();
    }

    protected void closeAttribtionModal(){
        driver.findElement(attributionModal.attributionCloseBtn).click();
    }
}
