package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Locators;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

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
     * @param index The index of the member search result to select
     */
    public void submitUserSearchByName(String name, String index) throws Exception {
       // wait.until(elementToBeClickable(hourlyNetworkPageLocators.userSearchTextField));
        List<WebElement> x = driver.findElements(By.id("communitySearchInput"));
        System.out.println(x.size());
        Actions action = new Actions(driver);
        action.moveToElement( x.get(1)).doubleClick().build().perform();
        Thread.sleep(3000);
        x.get(1).sendKeys(name);
        //driver.findElement(hourlyNetworkPageLocators.userSearchTextField).sendKeys(name);
    }

    /**
     * Selects a member search result by index
     * @param index the index (starting at 0) of the member search result to select
     */
    public void selectMemberSearchResult(String index){
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findMemberSearchResultByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findMemberSearchResultByIndex(index)).click();
//        driver.findElement(hourlyNetworkPageLocators.findMemberSearchResultByIndex(index)).sendKeys(Keys.ENTER);
    }


    /**
     * Clicks My Connections tab
     */
    public void clickNetworkMyConnections(){
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.connectionsMyConnectionsBtn));
       //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hourlyNetworkPageLocators.connectionsMyConnectionsBtn));
        driver.findElement(hourlyNetworkPageLocators.connectionsMyConnectionsBtn).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
     *
     * @return
     */
    public Boolean getNoInvitations() {
        return elementExists(hourlyNetworkPageLocators.invitationNoList);

    }

    /**
     * Get invitations count

     * @return The invitations count
     */
    public String getInvitationsCount() {
              List<WebElement> elements =  driver.findElement(hourlyNetworkPageLocators.invitationList).findElements(hourlyNetworkPageLocators.invitationListElement);
        return Integer.toString(elements.size());

    }

    /**
     * Verifies that the invitation's photo is displayed

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return Whether or not the invitation's photo is displayed
     */
    public boolean isInvitationPhotoDisplayed(String index) {
        return elementExists(hourlyNetworkPageLocators.findInvitationCardImgByIndex(index));
    }

    /**
     * Get invitation's name

     * @param index The index (Starting at 0) of the invitation you wish to locate
     * @return The invitation's name
     */
    public String getInvitationName(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationCardNameTxtByIndex(index)).getText();
    }

    /**
     * Get connection's work history (job @ employer)

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return The connection's primary job
     */
    public String getInvitationJob(String index) {
        return driver.findElement(hourlyNetworkPageLocators.findInvitationCardJobTxtByIndex(index)).getText();
    }

    /**
     * Clicks a connection's ignore button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickInvitationIgnoreBtn(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationCardIgnoreBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationCardIgnoreBtnByIndex(index)).click();
    }

    /**
     * Clicks a connection's connect button

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickInvitationConnectBtn(String index) {
        wait.until(elementToBeClickable(hourlyNetworkPageLocators.findInvitationCardConnectBtnByIndex(index)));
        driver.findElement(hourlyNetworkPageLocators.findInvitationCardConnectBtnByIndex(index)).click();
    }


}
