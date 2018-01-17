import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class HourlyMessages extends BaseTest {

    HourlyLoginPage loginPage;
    MessagesPage messagesPage;

    String username;
    String password;
    private String emptyMsg;
    String usernameReceiver;
    String passwordReceiver;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        System.out.println("Initializing hourly messages test...");
        messagesPage = new MessagesPage(driver);
        loginPage = new HourlyLoginPage(driver);

        username = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("username");
        password = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("password");
        emptyMsg = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("emptyMsg");
        usernameReceiver = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("usernameReceiver");
        passwordReceiver = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("passwordReceiver");
    }

    @Test
    public void testMessages() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Click Messages link */
        navPage.clickMessagesLink();

        /* Verify messages list modal is displayed */
        Assert.assertTrue(messagesPage.verifyMsgListModal(),"Messages list modal should be displayed when click Messages link in the nav header");

        /* Verify messages list modal title is Messages */
        Assert.assertEquals(messagesPage.getMsgListModalTitle(), "Messages");

        /* Verify the new message button is displayed */
        Assert.assertTrue(messagesPage.verifyMsgMenuHeaderNewMsgBtn(),"The new message button should be displayed in the menu header");

        /* Verify empty message text when no message in the list */
        Assert.assertEquals(messagesPage.getEmptyMsgTxt(), emptyMsg);

        /* Click the new message button */
        messagesPage.clickNewMsgbtn();

        /* Verify message compose modal is displayed */
        Assert.assertTrue(messagesPage.verifyMsgComposeModal(),"Message compose modal should be displayed when click on new message button");

        /* Verify my connections list is displayed in the message compose modal */
        Assert.assertTrue(messagesPage.verifyMsgComposeConnectionsList(),"My connections list should be displayed in the message compose modal");

        /* Verify the connection can be selected to compose message */
        Assert.assertTrue(messagesPage.verifyMsgComposeConnectionSellection(),"Message Thread should be displayed when select some connection");

        /* Verify the recipient first name is displayed in the header of the message compose modal */
        Assert.assertTrue(messagesPage.verifyRecipientNameText(),"The recipient first name should be displayed in the header of of the message compose modal");

        /* Verify receiver nameText in the header of the message compose modal */
        Assert.assertEquals(messagesPage.getMessageThreadRecipientNameText(), "A");

        messagesPage.enterMsgTxt("Hello test");

        testUtils.loadBeSuccessfulPage();

        /* Click Messages link */
        navPage.clickMessagesLink();

        /* Verify correct receiver nameText is dispayed in the messages list*/
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), "A Connection");

        /* Verify the recipient image is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientImg(),"The recipient image should be displayed in the message item");

        /* Verify the message date is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientDate(),"The message date should be displayed in the message item");

        /* Verify the message text is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListMsgText(),"The message text should be displayed in the message item");

        messagesPage.clickMsgItem();

        /* Verify the message date is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadSentDate(),"The message sent date should be displayed in the message thread");

        /* Verify the message text is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadMsgText(),"The message text should be displayed in the message thread");

        /* Verify that message thread is deleted from the messages list */
        messagesPage.deleteMsgThread();
        navPage.clickMessagesLink();
        Assert.assertEquals(messagesPage.getEmptyMsgTxt(), emptyMsg);

        navPage.logout();

        /* Login under another user and verify new mesage */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameReceiver, passwordReceiver);
        Thread.sleep(1000);
        Assert.assertTrue(messagesPage.verifyRedBadgeNewMsg(),"Red Badge should be displayed");

        /* Verify correct sender nameText is dispayed in the messages list*/
        navPage.clickMessagesLink();
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), "Auto Profile");

        /* Verify the recipient image is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientImg(),"The sender image should be displayed in the message item");

        /* Verify the message date is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientDate(),"The message date should be displayed in the message item");

        /* Verify the message text is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListMsgText(),"The message text should be displayed in the message item");

        messagesPage.clickMsgItem();
        Thread.sleep(1000);
        Assert.assertTrue(messagesPage.verifySeenNewMsg(),"Red Badge should not be displayed");

        /* Verify the message date is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadSentDate(),"The message sent date should be displayed in the message thread");

        /* Verify the message text is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadMsgText(),"The message text should be displayed in the message thread");

        /* Verify the sender avatar is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadRecipientImg(),"The sender avatar should be displayed in the message thread");

        messagesPage.deleteMsgThread();

        navPage.clickMessagesLink();

        /* Verify that message thread is deleted from the messages list */
        Assert.assertEquals(messagesPage.getEmptyMsgTxt(), emptyMsg);

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the messages test");
        navPage.attemptLogout();
        driver.quit();
    }
}
