import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HourlyNetworkPage extends BasePage {

    Locators.HourlyNetworkPageLocators hourlyNetworkPageLocators;

    public HourlyNetworkPage(WebDriver driver) {
        super(driver);
        hourlyNetworkPageLocators = new Locators.HourlyNetworkPageLocators();
    }

    /**
     * Verifies that the user search field is displayed

     * @return Whether or not the user search field is displayed
     */
    public boolean isUserSearchFieldPresent() {
        return elementExists(hourlyNetworkPageLocators.userSearchTextField);
    }

    /**
     * Submits a user search by name
     * @param name The name to be used in the search query
     */
    public void submitUserSearchByName(String name) throws Exception {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.userSearchTextField));
        driver.findElement(hourlyNetworkPageLocators.userSearchTextField).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(hourlyNetworkPageLocators.userSearchListResultTxt).sendKeys(Keys.ENTER);
    }

    /**
     * Clicks My Connections tab
     */
    public void clickNetworkMyConnections(){
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.connectionsMyConnectionsBtn));
        driver.findElement(hourlyNetworkPageLocators.connectionsMyConnectionsBtn).click();
    }

    /**
     * Clicks Suggested Connections tab
     */
    public void clickNetworkSuggestions(){
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.connectionsGetConnectedBtn));
        driver.findElement(hourlyNetworkPageLocators.connectionsGetConnectedBtn).click();
    }

    /**
     * Clicks Connection Invitations tab
     */
    public void clickNetworkInvitations(){
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.connectionsGetConnectedBtn));
        driver.findElement(hourlyNetworkPageLocators.connectionsInvitationsBtn).click();
    }

    /**
     * Get invitation title

     * @return The invitation section's title
     */
    public String getInvitationTitle() {
        return driver.findElement(hourlyNetworkPageLocators.invitationsTitleTxt).getText();
    }

    /**
     * Get invitation count

     * @return The invitation count
     */
    public String getInvitationCount() {
        return driver.findElement(hourlyNetworkPageLocators.invitationsCountTxt).getText();
    }

    /**
     * Verifies that the invitation's photo is displayed

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return Whether or not the invitation's photo is displayed
     */
    public boolean isInvitationPhotoDisplayed(String index) {
        return elementExists(hourlyNetworkPageLocators.findInvitationImgByIndex(index));
    }

    /**
     * Get invitation's name

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return The invitation's name
     */
    public String getInvitationName(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationNameTxtByIndex(index)).getText();
    }

    /**
     * Get connection's work history (job @ employer)

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's primary job
     */
    public String getInvitationJob(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationJobTxtByIndex(index)).getText();
    }

    /**
     * Clicks a connection's ignore button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickInvitationIgnoreBtn(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationIgnoreBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationIgnoreBtnByIndex(index)).click();
    }

    /**
     * Clicks a connection's connect button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickInvitationConnectBtn(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationConnectBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationConnectBtnByIndex(index)).click();
    }
}
