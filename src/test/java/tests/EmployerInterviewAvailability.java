package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.*;
import restInterfaces.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.EmployerDashPage;
import pages.EmployerFindTalentPage;
import pages.HourlyLoginPage;
import pages.MessagesPage;
import restInterfaces.SeasonedRestAPI;
import utils.TestDataImporter;

import java.sql.SQLException;
import java.util.List;

public class EmployerInterviewAvailability extends BaseTest {
    private String jobGuid;
    private HourlyLoginPage loginPage;
    private EmployerDashPage employerDashPage;
    private EmployerFindTalentPage findTalentPage;
    private MessagesPage messagesPage;
    private String email;
    private String password;
    private String day6OfWeekTxt;
    private String interviewScheduledHint;
    private String availabilityDialogTitle;
    private String availabilityDialogTxt;
    private String interviewSchedulercurrentMonthTxt;
    private String availabilitySuccessDialogTitle;
    private String availabilitySuccessDialogTxt;
    private String cancelAvailabilityChangesTitleDialog;
    private String cancelAvailabilityChangesTxtDialog;
    private String userId;
    private String userGuid;
    private String token;
    private String employerGuid;
    private String updatedBy;
    private String createdBy;
    private String jobPosition;
    private String jobType;
    private String jobWage;
    private String jobMinWage;
    private String jobMaxWage;
    private String jobWageType;
    private String jobDescription;
    private String jobStatus;
    private List<String> jobGuids;
    private List<String> talentGuids;
    private String cardIndex;
    private String interviewInviteMessageTxt1;
    private String interviewInviteMessageTxt2;
    private String interviewRescheduleMessageTxt;
    private String applicantName;
    private String applicantEmail;
    private String employerName;
    private String interviewStatusMessage;
    private String inviteToInterviewAvailabilityDialogTitle;
    private String availableTimesHintTxt;
    private String notAvailableHintTxt;
    private String scheduledInterviewSuccessDialogTitle;
    private String scheduledInterviewSuccessDialogTxt;
    private String messageThreadInterviewReminderEmployerDialogTitle;
    private String employerCity;
    private String employerState;
    private String employerAddress;
    private String messageThreadWdgMessageInterviewReminderinterviewDialogTitle;
    private String messageThreadInterviewRescheduleAvailabilityDialogTitle;
    private String messageThreadInterviewRescheduleAvailabilityDialogText;
    private String messageThreadRescheduleSuccessDialogTitle;
    private String messageThreadRescheduleSuccessDialogText;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing employer interview availability test...");
        employerDashPage = new EmployerDashPage(driver);
        loginPage = new HourlyLoginPage(driver);
        messagesPage = new MessagesPage(driver);
        findTalentPage = new EmployerFindTalentPage(driver);

        email = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("email");
        password = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("password");
        day6OfWeekTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("day6OfWeekTxt");
        interviewScheduledHint = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewScheduledHint");
        availabilityDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("availabilityDialogTitle");
        availabilityDialogTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("availabilityDialogTxt");
        interviewSchedulercurrentMonthTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewSchedulercurrentMonthTxt");
        availabilitySuccessDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("availabilitySuccessDialogTitle");
        availabilitySuccessDialogTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("availabilitySuccessDialogTxt");
        cancelAvailabilityChangesTitleDialog = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("cancelAvailabilityChangesTitleDialog");
        cancelAvailabilityChangesTxtDialog = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("cancelAvailabilityChangesTxtDialog");
        userId = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("userId");
        userGuid = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("userGuid");
        token = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("token");
        updatedBy = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("updatedBy");
        createdBy = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("createdBy");
        employerGuid = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("employerGuid");
        jobPosition = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobPosition");
        jobType = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobType");
        jobWage = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobWage");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("jobStatus");
        cardIndex = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("cardIndex");
        interviewInviteMessageTxt1 = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewInviteMessageTxt1");
        interviewInviteMessageTxt2 = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewInviteMessageTxt2");
        interviewRescheduleMessageTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewRescheduleMessageTxt");
        applicantName = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("applicantName");
        applicantEmail = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("applicantEmail");
        employerName = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("employerName");
        interviewStatusMessage = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("interviewStatusMessage");
        inviteToInterviewAvailabilityDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("inviteToInterviewAvailabilityDialogTitle");
        availableTimesHintTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("availableTimesHintTxt");
        notAvailableHintTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("notAvailableHintTxt");
        scheduledInterviewSuccessDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("scheduledInterviewSuccessDialogTitle");
        scheduledInterviewSuccessDialogTxt = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("scheduledInterviewSuccessDialogTxt");
        messageThreadInterviewReminderEmployerDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadInterviewReminderEmployerDialogTitle");
        employerCity = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("employerCity");
        employerState = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("employerState");
        employerAddress = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("employerAddress");
        messageThreadWdgMessageInterviewReminderinterviewDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadWdgMessageInterviewReminderinterviewDialogTitle");
        messageThreadInterviewRescheduleAvailabilityDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadInterviewRescheduleAvailabilityDialogTitle");
        messageThreadInterviewRescheduleAvailabilityDialogText = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadInterviewRescheduleAvailabilityDialogText");
        messageThreadRescheduleSuccessDialogTitle = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadRescheduleSuccessDialogTitle");
        messageThreadRescheduleSuccessDialogText = (String) TestDataImporter.get("InterviewAvailability", "InterviewAvailability").get("messageThreadRescheduleSuccessDialogText");
    }

    @Test
    public void testEmployerInterviewAvailability() throws Exception {
        SeasonedRestAPI api = new SeasonedRestAPI(token);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
            api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        System.out.println("Starting employer interview availability test...");

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to employer mode */
        navPage.switchToEmployerView();

        /* Navigate to employer mode */
        navPage.navigateToTalentPage();

        /* Select Interview tab */
        findTalentPage.selectTalentInterviewsTab();

        /* Verify calendar header view */
        Assert.assertTrue(findTalentPage.isAddAvailabilityBtnDisplayed(), "The add availability button should be displayed in the calendar view header");
        Assert.assertTrue(findTalentPage.isBackNextBtnsDisplayed(), "The back and next calendar buttons should be displayed in the calendar view header");
        Assert.assertTrue(findTalentPage.isTodayBtnDisplayed(), "The today button should be displayed in the calendar view header");
        Assert.assertTrue(findTalentPage.isWeekRangeTxtDisplayed(), "The week range text should be displayed in the calendar view header");
        Assert.assertTrue(findTalentPage.isDayOfMonthTxtDisplayed(), "The days of month text should be displayed in the calendar view header");
        Assert.assertFalse(findTalentPage.isTodayBtnEnabled(), "Today button should be disabled by default when current day is selected");

        /* Switch to next week */
        findTalentPage.clickNextWeekButton();

        Assert.assertTrue(findTalentPage.isTodayBtnEnabled(), "Today button should be enabled in the calendar header when not current day is selected");

        /* Select the today button on calendar header */
        findTalentPage.selectCalendarTodayBtn();

        Assert.assertFalse(findTalentPage.isTodayBtnEnabled(), "Today button should be disabled when current day is selected");

        /* Selects the employer add availability button */
        findTalentPage.selectAddAvailabilityBtn();

        /* Verify availability dialog title */
        Assert.assertEquals(findTalentPage.getAvailabilityDialogTitle(), availabilityDialogTitle);

        /* Verify availability dialog text */
        Assert.assertEquals(findTalentPage.getAvailabilityDialogTxt(), availabilityDialogTxt);

        /* Verify days of week on the Add availability modal */
        Assert.assertTrue(findTalentPage.verifyDaysOfWeekPresent(),"The all days of week should be present on the Add availability  modal");

        /* Verify interview scheduled hint text */
        Assert.assertEquals(findTalentPage.getInterviewScheduledHintTxt(), interviewScheduledHint);

        /* Verify save schedule and cancel schedule buttons on the Add availability modal */
        Assert.assertTrue(findTalentPage.isSaveScheduleBtnDisplayed(), "The save schedule button should be displayed");
        Assert.assertTrue(findTalentPage.isCancelScheduleBtnDisplayed(), "The cancel schedule button should be displayed");

        Assert.assertFalse(findTalentPage.isSaveScheduleBtnEnabled(), "Save schedule button should be disabled until availability updated");

        findTalentPage.selectDayOfWeek();
        findTalentPage.selectAvailableTimeSlot();

        Assert.assertTrue(findTalentPage.isSaveScheduleBtnEnabled(), "Save schedule button should be enabled if availability updated");

        findTalentPage.selectSaveScheduleBtn();

        /* Verify the updated availability success dialog is displayed */
        Assert.assertTrue(findTalentPage.isUpdatedAvailabilitySuccessDialogDisplayed(), "The updated availability success dialog should be displayed in the calendar view header");

        /* Verify the updated availability success dialog title */
        Assert.assertEquals(findTalentPage.getSuccessDialogTitle(), availabilitySuccessDialogTitle);

        /* Verify the updated availability success dialog text */
        Assert.assertEquals(findTalentPage.getSuccessDialogTxt(), availabilitySuccessDialogTxt);

        /* Verify the success icon is displayed on success dialog */
        Assert.assertTrue(findTalentPage.isSuccessDialogSuccessIconDisplayed(), "The success icon should be displayed on success dialog");

       /* Verify the got it and cancel buttons are displayed on success dialog */
        Assert.assertTrue(findTalentPage.isGotItBtnDisplayed(), "The got it button should be displayed");
        Assert.assertTrue(findTalentPage.isSuccessDialogCloseBtnDisplayed(), "The close button should be displayed");

        /* Selects the got it button on successful dialog*/
        findTalentPage.selectGotItBtn();

        /* Verify the updated availability success dialog is closed */
        Assert.assertFalse(findTalentPage.isUpdatedAvailabilitySuccessDialogDisplayed(), "The updated availability success dialog should be closed after selecting got it button");

        findTalentPage.selectCloseReferralBannerBtn();

        /*Verify if the filled time slot is displayed on calendar view */
        Assert.assertTrue(findTalentPage.isCalendarCellFilledTimeSlotDisplayed(), "The filled time slot should be displayed on calendar view");

        findTalentPage.selectFilledTimeSlot();

        /* Select the cancel schedule button on the Add availability modal */
        findTalentPage.selectCancelScheduleBtn();

        /*Verify if the cancel availability changes dialog is displayed */
        Assert.assertTrue(findTalentPage.isCancelAvailabilityChangesDialogDisplayed(), "The cancel availability changes dialog should be displayed");

         /* Verify the cancel availability changes dialog title */
        Assert.assertEquals(findTalentPage.getCancelAvailabilityDialogTitle(), cancelAvailabilityChangesTitleDialog);

        /* Verify the cancel availability changes dialog text */
        Assert.assertEquals(findTalentPage.getCancelAvailabilityDialogTxt(), cancelAvailabilityChangesTxtDialog);

        /* Verify the discard changes and back to schedule buttons are displayed on the cancel availability changes dialog */
        Assert.assertTrue(findTalentPage.isCancelAvailabilityDiscardBtnDisplayed(), "The discard changes button should be displayed");
        Assert.assertTrue(findTalentPage.isCancelAvailabilityBackBtnDisplayed(), "The back to schedule button should be displayed");

        /* Select the back to schedule button on the cancel availability changes dialog */
        findTalentPage.selectBacktoScheduleBtn();

        /* Verify that all unsaved changes are displayed on availability modal after selecting the back to schedule button */
        Assert.assertTrue(findTalentPage.isUnsavedChngesAvailabilityDialogDisplayed(), "The unsaved changes should be displayed after selecting the back to schedule button");

        /* Select the cancel schedule button on the Add availability modal */
        findTalentPage.selectCancelScheduleBtn();

        /* Select the discard changes button on the Add availability modal */
        findTalentPage.isCancelAvailabilityDiscardBtnDisplayed();

        /* Verify that all unsaved changes are discarded */
        Assert.assertTrue(findTalentPage.isUnsavedChangesDiscarded(), "The unsaved changes should be discarded");

        findTalentPage.selectAddAvailabilityBtn();
        findTalentPage.selectDayOfWeek();
        findTalentPage.deleteAvailableTimeSlot();
        findTalentPage.selectSaveScheduleBtn();

    }

    @Test(priority = 1)
    public void scheduleInterviewForApplicantTest() throws Exception {
        /* Create applicant */
        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.postApplication(userId, userGuid, jobGuid);
        testUtils.loadBeSuccessfulPage();
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to employer mode */
        navPage.switchToEmployerView();

        /* Navigate to talent page */
        navPage.navigateToTalentPage();

        /* Navigate to Applicants tab */
        findTalentPage.selectTalentApplicantsTab();
        findTalentPage.scrollToApplicantsCard("0");

        /* Invite the applicant to interview */
        findTalentPage.selectTalentActionsBtn(cardIndex);
        findTalentPage.selectApplicantScheduleInterviewBtn(cardIndex);

        findTalentPage.selectDayOfWeek();
        findTalentPage.selectAvailableTimeSlot();

        /* Verify the send invite to the interview button text */
        Assert.assertEquals(findTalentPage.getSendInviteToInterviewBtnTxt(), "Send");

        Assert.assertTrue(findTalentPage.isSendInviteToInterviewBtnDisplayed(), "Send invite to the interview button should be enabled");
        /*Type message to the candidate*/

        findTalentPage.enterMessageTxtInviteToInterview(interviewInviteMessageTxt2);
        findTalentPage.selectSendInviteToInterviewBtn();


        /* Verify the sent interview invite success dialog is displayed */
        Assert.assertTrue(findTalentPage.isInviteToInterviewSuccessDialogDisplayed(), "The sent interview invite success dialog should be displayed");

        findTalentPage.selectGotItInviteToInterviewBtn();

        testUtils.loadBeSuccessfulPage();
        navPage.clickMessagesLink();

        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), applicantName);
        Assert.assertEquals(messagesPage.getMsgListText(), interviewInviteMessageTxt2);
        messagesPage.clickMsgItem();
        Assert.assertEquals(findTalentPage.getLastInterviewStatusMessage(), interviewStatusMessage);
        Assert.assertEquals(findTalentPage.getLastInterviewMessage(), interviewInviteMessageTxt2);
        driver.findElement(By.id("messageThreadWdgCloseBtn")).click();

        navPage.logout();
        driver.navigate().refresh();


        /* Log in as applicant */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(applicantEmail, password);
        navPage.clickMessagesLink();
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), employerName);
        Assert.assertEquals(messagesPage.getMsgListText(), interviewInviteMessageTxt2);
        messagesPage.clickMsgItem();

        Assert.assertEquals(findTalentPage.getLastInterviewMessage(), interviewInviteMessageTxt2);
        findTalentPage.isLastMessageThreadScheduleInterviewCardDisplayed();
        findTalentPage.selectLastEnabledScheduleInterviewBtn();

        /* Verify the invite to interview dialog title */
        Assert.assertEquals(findTalentPage.getInviteInterviewDialogTitle(), inviteToInterviewAvailabilityDialogTitle);

        /* Verify the selected day on the invite to interview dialog */
        Assert.assertTrue(findTalentPage.getInviteInterviewDialogSelectedDayTxt().contains(day6OfWeekTxt));

        Assert.assertTrue(findTalentPage.isBackNextBtnsDisplayedInviteInterviewDialog(), "The back and next buttons should be displayed on the date picker");

        /* Verify days of week on the Schedule interview modal */
        Assert.assertTrue(findTalentPage.verifyDaysOfWeekPresent(),"The all days of week should be present on the Schedule interview modal");

        /* Verify time slots hits */
        Assert.assertEquals(findTalentPage.getAvailableTimesSlotHintTxt(), availableTimesHintTxt);
        Assert.assertEquals(findTalentPage.getNotAvailableTimesSlotHintTxt(), notAvailableHintTxt);

        Assert.assertTrue(findTalentPage.isConfirmInterviewBtnDisplayed(), "The confirm interview button should be displayed");
        Assert.assertTrue(findTalentPage.isRequestNewTimesBtnDisplayed(), "The request new times button should be displayed");

        Assert.assertFalse(findTalentPage.isConfirmInterviewBtnEnabled(), "Confirm interview button should be disabled by default when no time is selected");

        /* Verify the confirm interview button text */
        Assert.assertEquals(findTalentPage.getConfirmInterviewBtnTxt(), "Confirm interview");

        /* Verify the request new times button text */
        Assert.assertEquals(findTalentPage.getRequestNewTimesBtnTxt(), "Request new times");

        findTalentPage.selectAvailableTimeSlot();

        Assert.assertTrue(findTalentPage.isConfirmInterviewBtnEnabled(), "Save schedule button should be enabled if availability selected");
        findTalentPage.selectConfirmInterviewBtn();

        /* Verify the invite to interview success dialog is displayed */
        Assert.assertTrue(findTalentPage.isInviteToInterviewInviteSuccessDialogDisplayed(), "The invite to interview success dialog should be displayed");

        /* Verify the invite to interview success dialog title */
        Assert.assertEquals(findTalentPage.getInviteToInterviewSuccessDialogTitle(), scheduledInterviewSuccessDialogTitle);

        /* Verify the invite to interview success dialog text */
        Assert.assertEquals(findTalentPage.getInviteToInterviewSuccessDialogTxt(), scheduledInterviewSuccessDialogTxt);

        /* Verify the success icon is displayed on invite to interview success dialog */
        Assert.assertTrue(findTalentPage.isInviteToInterviewSuccessDialogSuccessIconDisplayed(), "The success icon should be displayed on success dialog");

        /* Verify the view details button is displayed on invite to interview success dialog */
        Assert.assertTrue(findTalentPage.isViewDetailsBtnDisplayed(), "The view details button should be displayed");

        /* Selects the view details button on successful dialog */
        findTalentPage.selectViewDetailsBtn();

        /* Verify if the interview details dialog is displayed */
        Assert.assertTrue(findTalentPage.isInterviewDetailsReminderEmployerDialogDisplayed(), "The remind interview dialog should be displayed");

        /* Verify the remind interview details dialog title */
        Assert.assertEquals(findTalentPage.getInterviewDetailsReminderDialogTitle(), messageThreadInterviewReminderEmployerDialogTitle);

        /* Verify the employer logo is displayed on the interview details dialog */
        Assert.assertTrue(findTalentPage.verifyInterviewDetailsReminderEmployerLogo(), "The employer logo should be displayed on the interview reminder dialog");

        /* Verify the store name is displayed on the interview details dialog */
        Assert.assertEquals(findTalentPage.getInterviewDetailsReminderEmployerName(), employerName);

        /* Verify the store type is displayed on the interview details dialog */
        Assert.assertEquals(findTalentPage.getInterviewDetailsReminderEmployerTypeTxt(), employerCity + "," + " " + employerState);

        /* Verify the store location is displayed on the interview details dialog */
        Assert.assertTrue(findTalentPage.getInterviewDetailsReminderLocationTxt().contains(employerAddress));

        /* Verify the location pin icon is displayed on the interview details dialog */
        Assert.assertTrue(findTalentPage.isInterviewDetailsReminderLocationPinIconDisplayed(), "The location pin icon should be displayed on the interview reminder dialog");

        /* Verify the reschedule interview button is displayed on the interview details dialog */
        Assert.assertTrue(findTalentPage.isRescheduleBtnDisplayed(), "The reschedule interview button should be displayed on the interview reminder dialog");

        /* Verify the cancel interview button is displayed on the interview details dialog */
        Assert.assertTrue(findTalentPage.isCancelInterviewBtnDisplayed(), "The employer logo should be displayed on the interview reminder dialog");

        Assert.assertTrue(findTalentPage.isRescheduleInterviewBtnEnabled(), "The reschedule interview button should be enabled");
        Assert.assertTrue(findTalentPage.isCancelInterviewBtnEnabled(), "The cancel interview button should be enabled");

        findTalentPage.closeInviteToInterviewDetailsDialog();

         /* Selects the interview reminder card in the message thread */
        findTalentPage.selectLastInterviewReminderCard();

        /* Verify if the remind interview dialog is displayed for applicant from the message thread  */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderEmployerDialogDisplayed(), "The remind interview dialog should be displayed");

        /* Verify the remind interview dialog title */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewReminderEmployerDialogTitle(), messageThreadInterviewReminderEmployerDialogTitle);

        /* Verify the employer logo is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.verifyMessageThreadInterviewReminderEmployerLogo(), "The employer logo should be displayed on the interview reminder dialog");

        /* Verify the store name is displayed on the interview reminder dialog */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewReminderEmployerName(), employerName);

        /* Verify the store type is displayed on the interview reminder dialog */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewReminderEmployerTypeTxt(), employerCity + "," + " " + employerState);

        /* Verify the store location is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.getMessageThreadInterviewReminderLocationTxt().contains(employerAddress));

        /* Verify the location pin icon is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderLocationPinIconDisplayed(), "The location pin icon should be displayed on the interview reminder dialog");

        /* Verify the reschedule interview button is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.isRescheduleBtnDisplayed(), "The reschedule interview button should be displayed on the interview reminder dialog");

        /* Verify the cancel interview button is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.isCancelInterviewBtnDisplayed(), "The employer logo should be displayed on the interview reminder dialog");

        Assert.assertTrue(findTalentPage.isRescheduleInterviewBtnEnabled(), "The reschedule interview button should be enabled");
        Assert.assertTrue(findTalentPage.isCancelInterviewBtnEnabled(), "The cancel interview button should be enabled");

        findTalentPage.closeMessageThreadInterviewReminderDialog();

        messagesPage.clickMsgThreadCloseBtn();
    }

    @Test(priority = 2)
    public void rescheduleInterviewForApplicantTest() throws Exception {

        /* Log in as store manager */
        testUtils.loadBeSuccessfulPage();
        navPage.clickLoginBtn();

        loginPage.loginWithEmail(email, password);
        navPage.switchToEmployerView();
        navPage.clickMessagesLink();
        messagesPage.clickMsgItem();
        findTalentPage.selectLastInterviewReminderCard();

        /* Verify if the remind interview dialog is displayed for store manager from the message thread */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderEmployerInterviewDialogDisplayed(), "The remind interview dialog should be displayed");

        /* Verify the remind interview dialog title  */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewReminderEmployerInterviewDialogTitle(), messageThreadWdgMessageInterviewReminderinterviewDialogTitle);

        /* Verify the applicant logo is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.verifyMessageThreadWdgMessageInterviewReminderApplicantLogo(), "The applicant logo should be displayed on the interview reminder dialog");

        /* Verify the applicant name is displayed on the interview reminder dialog */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewReminderEmployerInterviewDialogApplicantName(), applicantName);

        /* Verify the applicant position is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.getMessageThreadInterviewReminderEmployerInterviewDialogApplicantPosition().contains(jobPosition));

        /* Verify the interview reminder date is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.getMessageThreadWdgMessageInterviewReminderdateTxt().contains(day6OfWeekTxt));


        /* Verify the view profile button is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderViewProfileBtnDisplayed(), "The view profile interview button should be displayed on the interview reminder dialog");

        /* Verify the action button is displayed on the interview reminder dialog */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderEmployerActionBtnDisplayed(), "The action button should be displayed on the interview reminder dialog");

        findTalentPage.closeMessageThreadInterviewReminderEmployerDialog();

        messagesPage.clickMsgThreadCloseBtn();
        navPage.navigateToTalentPage();


        /* Select Interview tab */
        findTalentPage.selectTalentInterviewsTab();

        /* Verify the interview card is displayed on the store calendar */
        Assert.assertTrue(findTalentPage.isInterviewCardOnCalendarDisplayed(), "The  interview card should be displayed on the store calendar");

        /* Verify the applicant name is displayed on the interview card on store calendar */
        Assert.assertTrue(findTalentPage.isApplicantNameTxtOnCalendarDisplayed(), "The applicant name should be displayed on the interview card on store calendar");

        /* Verify the applicant position is displayed on the interview card on store calendar */
        Assert.assertTrue(findTalentPage.isApplicantPositionTxtOnCalendarDisplayed(), "The applicant position should be  displayed on the interview card on store calendar");

        /* Verify the applicant logo is displayed on the interview card on store calendar */
        Assert.assertTrue(findTalentPage.isApplicantLogoOnCalendarDisplayed(), "The applicant logo should be  displayed on the interview card on store calendar");

        /* Select the interview card on the calendar */
        findTalentPage.selectInterviewCardOnCalendar();

         /* Verify if the remind interview dialog is displayed for store manager from the store calendar */
        Assert.assertTrue(findTalentPage.isInterviewSchedulerinterviewDialogOnCalendarDisplayed(), "The remind interview dialog should be displayed from the store calendar");

        /* Verify the remind interview dialog title from the store calendar */
        Assert.assertEquals(findTalentPage.getInterviewSchedulerinterviewDialogOnCalendarTitle(), messageThreadWdgMessageInterviewReminderinterviewDialogTitle);

        /* Verify the applicant logo is displayed on the interview reminder dialog from the store calendar*/
        Assert.assertTrue(findTalentPage.verifyInterviewSchedulerinterviewDialogOnCalendarApplicantLogo(), "The applicant logo should be displayed on the interview reminder dialog");

        /* Verify the applicant name is displayed on the interview reminder dialog */
        Assert.assertEquals(findTalentPage.getInterviewSchedulerinterviewDialogOnCalendarApplicantName(), applicantName);

        /* Verify the applicant position is displayed on the interview reminder dialog from the store calendar */
        Assert.assertTrue(findTalentPage.getInterviewSchedulerinterviewDialogOnCalendarApplicantPosition().contains(jobPosition));

        /* Verify the interview reminder date is displayed on the interview reminder dialog from the store calendar */
        Assert.assertTrue(findTalentPage.getInterviewSchedulerinterviewDialogOnCalendarDateTxt().contains(day6OfWeekTxt));

        /* Verify the view profile button is displayed on the interview reminder dialog from the store calendar */
        Assert.assertTrue(findTalentPage.isInterviewSchedulerinterviewDialogOnCalendarViewProfileBtnDisplayed(), "The view profile interview button should be displayed on the interview reminder dialog from the store calendar");

        /* Verify the action button is displayed on the interview reminder dialog from the store calendar */
        Assert.assertTrue(findTalentPage.isInterviewSchedulerinterviewDialogOnCalendarActionBtnDisplayed(), "The action button should be displayed on the interview reminder dialog from the store calendar");

        /* Select the view profile button on the interview reminder dialog from the store calendar */
        findTalentPage.selectInterviewSchedulerInterviewDialogOnCalendarViewProfileBtn();

        /* Select the message button on applicant's profile */
        findTalentPage.selectInterviewSchedulerApplicantProfileMessageBtn();

        findTalentPage.selectLastInterviewReminderCard();

        /* Select the actions button from the message thread */
        findTalentPage.selectInterviewSchedulerInterviewDialogActionsBtn();

        /* Verify the actions buttons list is displayed on the interview reminder dialog from the message thread */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewReminderEmployerActionsBtnsDisplayed(), "The actions buttons list is displayed on the interview reminder dialog from the message thread");

       /* Select the reschedule button from the actions button list*/
        findTalentPage.selectMessageInterviewReminderEmployerDialogRescheduleBtn();

        /* Verify if the reschedule interview availability dialog is displayed */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewRescheduleAvailabilityDialogDisplayed(), "The reschedule interview availability dialog should be displayed from the store calendar");

        /* Verify the reschedule interview availability dialog title */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewRescheduleAvailabilityDialogTitle(), messageThreadInterviewRescheduleAvailabilityDialogTitle);

        /* Verify the reschedule interview availability dialog text */
        Assert.assertEquals(findTalentPage.getMessageThreadInterviewRescheduleAvailabilityDialogText(), messageThreadInterviewRescheduleAvailabilityDialogText);

        /* Verify if the reschedule interview message input is displayed */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewRescheduleMessageInputDisplayed(), "The reschedule interview message input should be displayed");

        /* Verify if the reschedule button is displayed on the reschedule interview availability dialog */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewRescheduleEmployerRescheduleBtnDisplayed(), "The reschedule button should be displayed on the interview reschedule availability dialog");

        /* Verify if the cancel button is displayed on the reschedule interview availability dialog */
        Assert.assertTrue(findTalentPage.isMessageThreadInterviewRescheduleEmployerCancelBtnDisplayed(), "The cancel button should be displayed on the interview reschedule availability dialog");

        /* Verify if see if time slot with scheduled interview is disabled */
        Assert.assertTrue(findTalentPage.isScheduledInterviewTimeSlotEnabled(), "Time slot with scheduled interviewn should be disabled on interview availability dialog");

        /* Update interview availability to reschedule interview */
        findTalentPage.updateInterviewAvailabilityReschedule();
        findTalentPage.enterMessageTxtRescheduleInterview(interviewRescheduleMessageTxt);
        findTalentPage.selectInterviewAvailabilityDialogRescheduleBtn();

        findTalentPage.selectGotItInviteToInterviewBtn();
        navPage.navigateToTalentPage();
        /* Select Interview tab */
        findTalentPage.selectTalentInterviewsTab();

        /* Verify the interview card is displayed on the store calendar */
        Assert.assertTrue(findTalentPage.isPendingInterviwOnCalendarDisplayed(), "The pending interview  should be displayed on the store calendar as yellow");

        /* Verify the updated availability time slot is filled on calendar view */
        Assert.assertTrue(findTalentPage.isCalendarCellFilledUpdatedTimeSlotDisplayed(), "The updated availability time slot is filled on calendar view");

        navPage.logout();
        driver.navigate().refresh();


        /* Log in as applicant */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(applicantEmail, password);
        navPage.clickMessagesLink();
        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), employerName);
        Assert.assertEquals(messagesPage.getMsgListText(), interviewRescheduleMessageTxt);
        messagesPage.clickMsgItem();

        Assert.assertEquals(findTalentPage.getLastInterviewMessage(), interviewRescheduleMessageTxt);
        findTalentPage.isLastMessageThreadScheduleInterviewCardDisplayed();
        findTalentPage.selectLastEnabledChooseNewTimeBtn();

        /* Verify the reschedule interview availability dialog is displayed */
        Assert.assertTrue(findTalentPage.isInterviewRescheduleAvailabilityDialogDisplayed(), "The reschedule interview availability dialog should be displayed");

        /* Verify the reschedule interview availability dialog title */
        Assert.assertEquals(findTalentPage.getInviteInterviewDialogTitle(), inviteToInterviewAvailabilityDialogTitle);

        /* Verify the confirm interview button is displayed on the reschedule interview availability dialog */
        Assert.assertTrue(findTalentPage.isConfirmInterviewRescheduleBtnDisplayed(), "The confirm interview button is displayed on the reschedule interview availability dialog");

        /* Verify the request new times button is displayed on the reschedule interview availability dialog */
        Assert.assertTrue(findTalentPage.isRequestNewTimesRescheduleBtnDisplayed(), "The request new times button is displayed on the reschedule interview availability dialog");

        /* Select time slot to reschedule interview */
        findTalentPage.updateInterviewAvailabilityReschedule();

        /* Select time slot to reschedule interview */
        findTalentPage.selectConfirmInterviewRescheduleBtn();

         /* Verify the invite to interview success dialog is displayed */
        Assert.assertTrue(findTalentPage.isInviteToInterviewInviteSuccessDialogDisplayed(), "The invite to interview success dialog should be displayed");

        findTalentPage.closeRescheduleInterviewSuccessDialog();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Interview Availability test");
        navPage.attemptLogout();
        driver.quit();

    }
}

