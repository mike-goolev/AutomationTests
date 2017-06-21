import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ConnectionsPage extends BasePage {

    Locators.HourlyConnectionPageLocators hourlyConnectionPageLocators;
    NavPage navPage;

    public ConnectionsPage(WebDriver driver) {
        super(driver);
        hourlyConnectionPageLocators = new Locators.HourlyConnectionPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the connection's photo is displayed
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not the connection's photo is displayed
     */
    public boolean isConnectionPhotoPresent(String index) {
        return elementExists(hourlyConnectionPageLocators.findConnectionCardImgByIndex(index));
    }

    /**
     * Get connection's name
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's name
     */
    public String getConnectionName(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get connection's work history (job @ employer)
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's primary job
     */
    public String getConnectionJob(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardWorkTxtByIndex(index)).getText();
    }

    /**
     * Get connection's location
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's location
     */
    public String getConnectionLocation(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardLocationTxtByIndex(index)).getText();
    }

    /**
     * Clicks a connection's view button
     *
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickConnectionViewButton(String index) {
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.findConnectionCardViewBtnByIndex(index)));
        driver.findElement(hourlyConnectionPageLocators.findConnectionCardViewBtnByIndex(index)).click();
    }

    /**
     * Clicks back button to return to logged in user profile
     */
    public void clickConnectionsBackButton() {
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.connectionBackBtn));
        driver.findElement(hourlyConnectionPageLocators.connectionBackBtn).click();
    }
}
