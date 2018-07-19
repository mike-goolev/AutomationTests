package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import org.openqa.selenium.interactions.Actions;

public class MessagesPage extends BasePage {

    Locators.HourlyMessagePageLocators messagesPageLocators;
    Locators.NavPageLocators navPageLocators;
    Locators.HourlyMessagePageLocators hourlyMessagePageLocators;

    public MessagesPage(WebDriver driver) {
        super(driver);
        messagesPageLocators = new Locators.HourlyMessagePageLocators();
        hourlyMessagePageLocators = new Locators.HourlyMessagePageLocators();
    }

    /**
     * Verifies that the message list modal is displayed
     * @return Whether or not the message list modal is displayed
     */
    public boolean verifyMsgListModal() {
        return elementExistsLongTimeout(messagesPageLocators.msgListModal);
    }

    /**
     * Verifies that the message list modal title is displayed
     *
     * @return Whether or not the message list modal title is displayed
     */
    public boolean verifyMsgListModalTitle() {
        return elementExistsLongTimeout(messagesPageLocators.msgListModalTitle);
    }

     /**
     * Get the message list modal title
     *
     * @return The message list modal title
     */
    public String getMsgListModalTitle() {
        return driver.findElement(messagesPageLocators.msgListModalTitle).getText();
    }

    /**
     * Verifies that the new message button is displayed
     *
     * @return Whether or not the new message button is displayed
     */
    public boolean verifyMsgMenuHeaderNewMsgBtn() {
        return elementExistsLongTimeout(messagesPageLocators.msgMenuHeaderNewMsgBtn);
    }

    /**
     * Get the empty message text
     *
     * @return The empty message text
     */
    public String getEmptyMsgTxt() {
        elementExistsLongTimeout(messagesPageLocators.emptyMsgH4);
        return driver.findElement(messagesPageLocators.emptyMsgH4).getText();
    }

    /**
     * Get the message text in the message list
     *
     * @return The message text in the message list
     */
    public String getMsgListText() {
        return driver.findElement(hourlyMessagePageLocators.messageListMsgTxt).getText();
    }

    /**
     * Click the new message button
     */
    public void clickNewMsgbtn() {
        driver.findElement(messagesPageLocators.msgMenuHeaderNewMsgBtn).click();
    }

    /**
     * Verifies that the message compose modal is displayed
     *
     * @return Whether or not the message compose modal is displayed
     */
    public boolean verifyMsgComposeModal() {
        return elementExistsLongTimeout(messagesPageLocators.msgComposeModalTitle);
    }

    /**
     * Get Placeholder Value
     *
     * @return Placeholder Value
     */
    public String getPlaceholderSearchInputBox(){
        return driver.findElement(messagesPageLocators.textboxMsgComposeModalSearchConnections).getAttribute("placeholder");

    }

    /**
     *  Get No Connections Label
     * @return No Connections label
     */
    public String getNoConnectionsLabel(){
        return driver.findElement(messagesPageLocators.labelMsgComposeModalNoConnection).getText();

    }

    /**
     * Clicks Get Connected Button
     */
    public void clickGetConnectedBtn(){
        driver.findElement(messagesPageLocators.buttonGetConnected).click();
    }

    /**
     * Verifies that the my connections list is displayed in the message compose modal
     *
     * @return Whether or not my connections list is displayed in the message compose modal
     */
    public boolean verifyMsgComposeConnectionsList() {
        return elementExistsLongTimeout(messagesPageLocators.msgComposeConnectionsList);
    }

    /**
     * Verifies that the connection can be selected from the my connections list
     *
     * @return Whether or not the connection can be selected from the my connections list
     */

    public boolean verifyMsgComposeConnectionSellection() {
        wait.until(elementToBeClickable(messagesPageLocators.msgComposeConnection0));
        driver.findElement(messagesPageLocators.msgComposeConnection0).click();
        return elementExistsLongTimeout(messagesPageLocators.msgThreadWdg);
    }

    /**
     * Verifies that the recipient first name is displayed in the header of the message compose modal
     *
     * @return Whether or not the recipient first name in the header of the message compose modal
     */

    public boolean verifyRecipientNameText() {
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadRecipientTitle);
    }

    /**
     * Get the recipient first name in the header of the message compose modal
     *
     * @return The recipient first name in the header of the message compose modal
     */
    public String getMessageThreadRecipientNameText() {
            return driver.findElement(hourlyMessagePageLocators.messageThreadRecipientTitle).getText();
    }

    /**
     * Enter text in message input field and send message
     *
     * @param text
     */
    public void enterMsgTxt(String text) {
        driver.findElement(hourlyMessagePageLocators.messageThreadWdgInput).sendKeys(text);
        driver.findElement(hourlyMessagePageLocators.messageThreadWdgSendBtn).click();
    }

    public void hoverOverMessageItem(String index){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hourlyMessagePageLocators.messagesListItemByIndex(index))).build().perform();
    }
    /**
     * Get the number of messages displayed in Top Message modal
     * @return number of messages threads
     */
    public int getItemlist(){
        return driver.findElements(hourlyMessagePageLocators.messageListItem).size();
    }

    /**
     * Click delete message from Top Messages Modal
     * @param index
     */
    public void clickMessageDeleteTrachIcon(String index){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hourlyMessagePageLocators.messagesListItemByIndex(index))).build().perform();
        driver.findElement(hourlyMessagePageLocators.messagesListItemByIndex(index)).findElement(hourlyMessagePageLocators.messageDeleteTrashIcon).click();
    }
    /**
     * Get the recipient first name in the messages list
     *
     * @return The recipient first name in the messages list
     */
    public String getMsgListRecipientNameText() {
        wait.until(elementToBeClickable(messagesPageLocators.messageListRecipientName));
        return driver.findElement(hourlyMessagePageLocators.messageListRecipientName).getText();
    }

    /**
     * Verifies that the recipient first name is displayed in the messages item
     *
     * @return Whether or not the recipient first name is displayed in the messages item
     */

    public boolean verifyMsgListRecipientNameText() {

        return elementExistsLongTimeout(hourlyMessagePageLocators.messageListRecipientName);
    }

    /**
     * Verifies that the message is displayed in the messages list
     *
     * @return Whether or not the message is displayed in the messages list
     */
    public boolean verifyMsgListMsgText() {

        return elementExistsLongTimeout(hourlyMessagePageLocators.messageListMsgTxt);
    }

    /**
     * Verifies that the recipient image is displayed in the messages item
     *
     * @return Whether or not the recipient image is displayed in the messages item
     */
    public boolean verifyMsgListRecipientImg() {

        return elementExistsLongTimeout(hourlyMessagePageLocators.messageListRecipientImg);
    }

    /**
     * Verifies that the date is displayed in the messages item
     *
     * @return Whether or not the date is displayed in the messages item
     */
    public boolean verifyMsgListRecipientDate() {

        return elementExistsLongTimeout(hourlyMessagePageLocators.messageListRecipientDate);
    }

    /**
     * Select the message item from the message list
     */
    public void clickMsgItem() {
        wait.until(elementToBeClickable(hourlyMessagePageLocators.messageListRecipientName));
        driver.findElement(hourlyMessagePageLocators.messageListRecipientName).click();
    }

    /**
     * Delete the message thread
     */
    public void deleteMsgThread() {
        driver.findElement(hourlyMessagePageLocators.messageThreadWdgSettingsBtn).click();
        wait.until(elementToBeClickable(hourlyMessagePageLocators.messageThreadWdgDeleteMenu));
        driver.findElement(hourlyMessagePageLocators.messageThreadWdgDeleteMenu).click();
    }

    /**
     * Verifies that red dot is displayed when new message
     *
     * @return Whether or not the red dot is displayed when new message
     */
    public boolean verifyRedBadgeNewMsg() {
        return elementExists(messagesPageLocators.msgRedBadge);
    }

    /**
     * Gets the numeric value from the red dot
     *
     * @return Whether or not the red dot is displayed when new message
     */
    public String getRedBadgeNewMsgCount() {
        return driver.findElement(messagesPageLocators.msgRedBadge).getAttribute("data-msg-count");
    }
    /**
     * Verifies that red dot is not displayed when new message seen
     *
     * @return Whether or not the red dot is displayed when new message seen
     */
    public boolean verifySeenNewMsg() {
        return elementExistsLongTimeout(messagesPageLocators.msgNoRedBadge);
    }

    /**
     * Verifies that the message sent date is displayed in the message thread
     *
     * @return Whether or not the the message sent date is displayed in the message thread
     */
    public boolean verifyMsgThreadSentDate() {
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadSenderTimeTxt0);
    }

    /*
     * Verifies that the message text is displayed in the messages thread
     *
     * @return Whether or not the message text is displayed in the messages thread
     */
    public boolean verifyMsgThreadMsgText() {
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadTxt0);
    }

    /*
     * Verifies that the recipient image is displayed in the messages item
     *
     * @return Whether or not the recipient image is displayed in the messages item
     */
    public boolean verifyMsgThreadRecipientImg() {
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadRecipientImg0);
    }

    /**
     * Select the message thread close button
     */
    public void clickMsgThreadCloseBtn() {
        wait.until(elementToBeClickable(hourlyMessagePageLocators.messageThreadWdgCloseBtn));
        driver.findElement(hourlyMessagePageLocators.messageThreadWdgCloseBtn).click();
    }
}

