package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;
import restInterfaces.SeasonedRestAPI;
import sql.SqlSelects;
import utils.TestDataImporter;


public class HourlyMessages extends BaseTest {

    private HourlyLoginPage loginPage;
    private HourlyRegistrationPage hourlyRegistrationPage;
    private MessagesPage messagesPage;

    private String userLocation;
    private String firstName;
    private String lastName;
    private String email;
    private String placeholder;
    private String labelNoConnections;
    private String username;
    private String password;
    private String emptyMsg;
    private String usernameReceiver;
    private String passwordReceiver;
    private String fromUserGuid;
    private String toUserGuid;
    private String token;
    private String tokenFrom;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        messagesPage = new MessagesPage(driver);
        loginPage = new HourlyLoginPage(driver);
        usernameReceiver = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("usernameReceiver");
        passwordReceiver = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("passwordReceiver");
    }

    @Test
    public void testMemberMessagesEmptyStatus() throws Exception {

        hourlyRegistrationPage = new HourlyRegistrationPage(driver);

        userLocation = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("userLocation");
        firstName = ("ssHourlyFirst" + testUtils.generateRandomUUID());
        lastName = ("ssHourlyLast" + testUtils.generateRandomUUID());
        email = (testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("password");
        emptyMsg = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("emptyMsg");

        System.out.println("Credentials used: " + firstName + ", " + lastName + ", " + email);

        /* Sign Up new member through API */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(tokenFrom);
        seasonedRestAPI.signUpMember(firstName, lastName, email, password);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

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

    }

    @Test(dependsOnMethods = {"testMemberMessagesEmptyStatus"})
    public void testMemberMessageModalNoConnections() throws InterruptedException {
        placeholder = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("searchPlaceholder");
        labelNoConnections = (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("labelNoConnections");

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Click Messages link */
        navPage.clickMessagesLink();

        /* Click the new message button */
        messagesPage.clickNewMsgbtn();

        /* Verify message compose modal is displayed */
        Assert.assertTrue(messagesPage.verifyMsgComposeModal(),"Message compose modal - New Message - should be displayed when click on new message button");

        /* Verify Placeholder Value */
        Assert.assertEquals(messagesPage.getPlaceholderSearchInputBox(), placeholder);

        /* Verify No Connections label */
        Assert.assertEquals(messagesPage.getNoConnectionsLabel(), labelNoConnections);

        /* Click Get Connected Button*/
        messagesPage.clickGetConnectedBtn();

        /* Verify user is redirected to Get Connected page */
        //Thread.sleep(5000);
        //Assert.assertEquals(navPage.getPageTitleSelected(), "Get Connected - Foodservice & Restaurant Career Community | Seasoned");

    }

    @Test(dependsOnMethods = {"testMemberMessagesEmptyStatus"})
    public void testMemberMessageswithConnection() throws Exception {
        System.out.println(email);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        //Prerequisite: Make a connection
        SqlSelects sqlNew = new SqlSelects();
        fromUserGuid = sqlNew.getUserGUIDByEmail((String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("usernameReceiver"));
        toUserGuid = sqlNew.getUserGUIDByEmail(email);

        SeasonedRestAPI seasonedRestAPIforToken = new SeasonedRestAPI();
        token = "Bearer " + seasonedRestAPIforToken.getToken(email, password);
        tokenFrom = "Bearer " + seasonedRestAPIforToken.getToken((String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("usernameReceiver"), (String) TestDataImporter.get("HourlyMessages", "HourlyMessages").get("passwordReceiver"));

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(tokenFrom);
        seasonedRestAPI.postConnectionRequest(fromUserGuid, toUserGuid);
        Thread.sleep(2000);
        seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateConnectionRequest(fromUserGuid, toUserGuid);


        /* Click Messages link */
        navPage.clickMessagesLink();

        /* Click the new message button */
        messagesPage.clickNewMsgbtn();

        /* Verify message compose modal is displayed */
        Assert.assertTrue(messagesPage.verifyMsgComposeModal(), "Message compose modal should be displayed when click on new message button");

        /* Verify my connections list is displayed in the message compose modal */
        Assert.assertTrue(messagesPage.verifyMsgComposeConnectionsList(), "My connections list should be displayed in the message compose modal");

        /* Verify the connection can be selected to compose message */
        Assert.assertTrue(messagesPage.verifyMsgComposeConnectionSellection(), "Message Thread should be displayed when select some connection");

        /* Verify the recipient first name is displayed in the header of the message compose modal */
        Assert.assertTrue(messagesPage.verifyRecipientNameText(), "The recipient first name should be displayed in the header of of the message compose modal");

        /* Verify receiver nameText in the header of the message compose modal */
        Assert.assertEquals(messagesPage.getMessageThreadRecipientNameText(), "Messages Connection");

        messagesPage.enterMsgTxt("Hello World!");

        testUtils.loadBeSuccessfulPage();

        /* Click Messages link */
        navPage.clickMessagesLink();

        /* Verify correct receiver nameText is dispayed in the messages list*/
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), "Messages Connection");

        /* Verify the recipient image is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientImg(), "The recipient image should be displayed in the message item");

        /* Verify the message date is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListRecipientDate(), "The message date should be displayed in the message item");

        /* Verify the message text is displayed in the message item */
        Assert.assertTrue(messagesPage.verifyMsgListMsgText(), "The message text should be displayed in the message item");

        messagesPage.clickMsgItem();

        /* Verify the message date is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadSentDate(), "The message sent date should be displayed in the message thread");

        /* Verify the message text is displayed in the message thread */
        Assert.assertTrue(messagesPage.verifyMsgThreadMsgText(), "The message text should be displayed in the message thread");
    }

    @Test(dependsOnMethods = {"testMemberMessageswithConnection"})
    public void testMemberDeleteMessagefromOpenedThread() throws Exception {
        System.out.println(email);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
       // loginPage.loginWithEmail(email, password);
        loginPage.loginWithEmail(email, password);

        navPage.clickMessagesLink();
        messagesPage.clickMsgItem();

        /* Verify that message thread is deleted from the messages list */
        messagesPage.deleteMsgThread();
        testUtils.loadBeSuccessfulPage();
        navPage.clickMessagesLink();
        Assert.assertEquals(messagesPage.getEmptyMsgTxt(), emptyMsg);

    }

    @Test(dependsOnMethods = {"testMemberMessageswithConnection"})
    public void testMemberSecondParticipantView() throws Exception {

        System.out.println(email);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Login under the other user and verify new mesage */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameReceiver, passwordReceiver);
        Thread.sleep(1000);
        Assert.assertTrue(messagesPage.verifyRedBadgeNewMsg(),"Red Badge should be displayed");

        /* Verify correct sender nameText is dispayed in the messages list*/
        navPage.clickMessagesLink();
        int messageCount = messagesPage.getItemlist()/4;
        if(messagesPage.getItemlist()/4 == 1)
        {
            Assert.assertEquals(messagesPage.getRedBadgeNewMsgCount(), "1");
        }
        else
            {
                int i=0;
                for(i = 1; i< messageCount; i++)
                {
                    messagesPage.hoverOverMessageItem("1");
                    messagesPage.clickMessageDeleteTrashIcon("1");
                }
                Assert.assertEquals(messagesPage.getRedBadgeNewMsgCount(), "1");
            }
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), firstName + " " + lastName);

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
