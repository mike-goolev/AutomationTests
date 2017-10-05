import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HourlyNetworkMyConnectionsPage extends BasePage {

    Locators.HourlyNetworkPageLocators hourlyNetworkPageLocators;
    NavPage navPage;

    public HourlyNetworkMyConnectionsPage(WebDriver driver) {
        super(driver);
        hourlyNetworkPageLocators = new Locators.HourlyNetworkPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the empty connection state title is displayed

     * @return Whether or not the empty connection state title is displayed
     */
    public boolean isEmptyConnectionTitleTxtDisplayed() {
        return elementExists(hourlyNetworkPageLocators.emptyConnectionsTitleTxt);
    }

    /**
     * Verifies that the connection's photo is displayed

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not the connection's photo is displayed
     */
    public boolean isConnectionPhotoDisplayed(String index) {
        return elementExists(hourlyNetworkPageLocators.findConnectionCardImgByIndex(index));
    }

    /**
     * Get connection's name

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's name
     */
    public String getConnectionName(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findConnectionCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get connection's work history (job @ employer)

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's primary job
     */
    public String getConnectionJob(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findConnectionCardWorkTxtByIndex(index)).getText();
    }

    /**
     * Clicks a connection's view button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickConnectionViewButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findConnectionCardViewBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findConnectionCardViewBtnByIndex(index)).click();
    }

    /**
     * Clicks a connection's message button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickConnectionMessageButton(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findConnectionCardMessageBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findConnectionCardMessageBtnByIndex(index)).click();
    }
}
