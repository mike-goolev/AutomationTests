import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

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
        return driver.findElement(messagesPageLocators.emptyMsg).getText();
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



    /**
     * Get the recipient first name in the messages list
     *
     * @return The recipient first name in the messages list
     */
    public String getMsgListRecipientNameText() {
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
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadRecipientTxt0);
    }

    /*
     * Verifies that the recipient image is displayed in the messages item
     *
     * @return Whether or not the recipient image is displayed in the messages item
     */
    public boolean verifyMsgThreadRecipientImg() {
        return elementExistsLongTimeout(hourlyMessagePageLocators.messageThreadRecipientImg0);
    }
}
