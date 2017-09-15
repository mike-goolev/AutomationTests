import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HourlyConnectionsPage extends BasePage {

    Locators.HourlyConnectionPageLocators hourlyConnectionPageLocators;
    NavPage navPage;

    public HourlyConnectionsPage(WebDriver driver) {
        super(driver);
        hourlyConnectionPageLocators = new Locators.HourlyConnectionPageLocators();
        navPage = new NavPage(driver);
    }

    /**
     * Verifies that the user search field is displayed
     * @return Whether or not the user search field is displayed
     */
    public boolean isUserSearchFieldPresent() {
        return elementExists(hourlyConnectionPageLocators.userSearchTextField);
    }


    /**
     * Clicks My Connections tab
     */
    public void clickMyConnections(){
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.connectionsMyConnectionsBtn));
        driver.findElement(hourlyConnectionPageLocators.connectionsMyConnectionsBtn).click();
    }

    /**
     * Clicks Suggested Connections tab
     */
    public void clickSuggestedConnections(){
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.connectionsGetConnectedBtn));
        driver.findElement(hourlyConnectionPageLocators.connectionsGetConnectedBtn).click();
    }

    /**
     * Clicks Connection Invitations tab
     */
    public void clickConnectionInvitations(){
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.connectionsGetConnectedBtn));
        driver.findElement(hourlyConnectionPageLocators.connectionsInvitationsBtn).click();
    }

    /**
     * Verifies that the connection's photo is displayed
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not the connection's photo is displayed
     */
    public boolean isConnectionPhotoPresent(String index) {
        return elementExists(hourlyConnectionPageLocators.findConnectionCardImgByIndex(index));
    }

    /**
     * Get connection's name
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's name
     */
    public String getConnectionName(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get connection's work history (job @ employer)
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's primary job
     */
    public String getConnectionJob(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardWorkTxtByIndex(index)).getText();
    }

    /**
     * Get connection's location
     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's location
     */
    public String getConnectionLocation(String index) {
        return driver.findElement(hourlyConnectionPageLocators.findConnectionCardLocationTxtByIndex(index)).getText();
    }

    /**
     * Clicks a connection's view button
     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickConnectionViewButton(String index) {
        wait.until(elementToBeClickable(hourlyConnectionPageLocators.findConnectionCardViewBtnByIndex(index)));
        driver.findElement(hourlyConnectionPageLocators.findConnectionCardViewBtnByIndex(index)).click();
    }
}
