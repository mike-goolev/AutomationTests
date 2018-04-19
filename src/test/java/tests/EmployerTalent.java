package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import restInterfaces.SeasonedRestAPI;
import utils.TestDataImporter;

import java.sql.SQLException;
import java.util.List;

public class EmployerTalent extends BaseTest {

    private HourlyLoginPage loginPage;
    private EmployerFindTalentPage talentPage;
    private HourlyJobSearchPage jobSearchPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private EmailsPage emailsPage;

    private String email;
    private String password;
    private String emptyStateEmail;
    private String cardIndex;
    private String talentName;
    private String talentFirstName;
    private String talentLastName;
    private String talentLocation;
    private String talentJob;
    private String talentJobLocation;
    private String talentSharedConnections;
    private String talentInvitePosition;
    private String talentEmail;
    private String applicantEmail;
    private String applicantName;
    private String applicantFirstName;
    private String applicantLastName;
    private String applicantPosition;
    private String applicantTime;
    private String applicantSharedConnections;
    private String talentAllEmptyTitleTxt;
    private String talentAllEmptyTxt;
    private String talentGoodEmptyTitleTxt;
    private String talentGoodEmptyTxt;
    private String talentInvitedEmptyTitleTxt;
    private String talentInvitedEmptyTxt;
    private String talentApplicantsEmptyTitleTxt;
    private String talentApplicantsEmptyTxt;
    private String talentBadEmptyTitleTxt;
    private String talentBadEmptyTxt;
    private String talentAllTitle;
    private String talentGoodTitle;
    private String talentInvitedTitle;
    private String talentApplicantsTitle;
    private String talentBadTitle;
    private String invitedModalTitle;
    private String talentGoodStatus;
    private String employerName;
    private String employerCity;
    private String employerGuid;
    private String createdBy;
    private String updatedBy;
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
    String jobGuid;
    private String userId;
    private String userGuid;
    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing employer talent test...");
        talentPage = new EmployerFindTalentPage(driver);
        loginPage = new HourlyLoginPage(driver);
        jobSearchPage = new HourlyJobSearchPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        emailsPage = new EmailsPage(driver);

        email = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("email");
        password = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("password");
        emptyStateEmail = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("emptyStateEmail");
        cardIndex = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("cardIndex");
        applicantName = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("applicantName");
        applicantPosition = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("applicantPosition");
        applicantTime = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("applicantTime");
        applicantSharedConnections = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("applicantSharedConnections");
        talentAllEmptyTitleTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentAllEmptyTitleTxt");
        talentAllEmptyTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentAllEmptyTxt");
        talentGoodEmptyTitleTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentGoodEmptyTitleTxt");
        talentGoodEmptyTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentGoodEmptyTxt");
        talentInvitedEmptyTitleTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentInvitedEmptyTitleTxt");
        talentInvitedEmptyTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentInvitedEmptyTxt");
        talentApplicantsEmptyTitleTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentApplicantsEmptyTitleTxt");
        talentApplicantsEmptyTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentApplicantsEmptyTxt");
        talentBadEmptyTitleTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentBadEmptyTitleTxt");
        talentBadEmptyTxt = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentBadEmptyTxt");
        talentAllTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentAllTitle");
        talentGoodTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentGoodTitle");
        talentInvitedTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentInvitedTitle");
        talentApplicantsTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentApplicantsTitle");
        talentBadTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentBadTitle");
        invitedModalTitle = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("invitedModalTitle");
        talentGoodStatus = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentGoodStatus");
        updatedBy = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("updatedBy");
        createdBy = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("createdBy");
        employerGuid = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("employerGuid");
        employerName = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("employerName");
        employerCity = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("employerCity");
        jobPosition = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobPosition");
        jobType = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobType");
        jobWage = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobWage");
        talentJobLocation = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("talentJobLocation");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("jobStatus");
        userId = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("userId");
        userGuid = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("userGuid");
        token = (String) TestDataImporter.get("EmployerTalent", "EmployerTalent").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
                api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        talentGuids = sqlSelect.getTalentByEmployer(employerGuid);
        for (String guid : talentGuids)
            api.updateTalentStatus(createdBy, employerGuid, guid, talentGoodStatus);
        System.out.println("Starting employer talent test!");
    }

    @Test
    public void testEmployerTalentInvite() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store talent page */
        navPage.switchToEmployerView();
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Verify All talent title */
        Assert.assertEquals(talentPage.getEmployerTalentAllTitleTxt(), talentAllTitle);

        /* Verify talent card displayed at given index */
        Assert.assertTrue(talentPage.isTalentCardDisplayed(cardIndex), "Talent card should be displayed at specified index");
        Assert.assertTrue(talentPage.isTalentCardPhotoDisplayed(cardIndex), "Talent card photo should be displayed at specified index");

        /* Get the details from the talent card at the specified index */
        talentName = talentPage.getTalentName(cardIndex);
        talentFirstName = testUtils.getStringFirstWord(talentName);
        talentLastName = testUtils.getStringLastWord(talentName);
        talentLocation = talentPage.getTalentLocation(cardIndex);
        talentJob = talentPage.getTalentPosition(cardIndex);
        talentSharedConnections = talentPage.getTalentSharedConnections(cardIndex);

        /* Invite talent to apply */
        talentPage.selectTalentActionsBtn(cardIndex);
        talentPage.selectTalentActionsInviteBtn(cardIndex);
        Assert.assertEquals(talentPage.getTalentInviteModalTitleTxt(), "Invite " + talentFirstName + " to apply");
        talentPage.selectTalentInviteToPosition(cardIndex);
        talentInvitePosition = talentPage.getTalentInviteToPositionJobNameTxt();
        Assert.assertEquals(talentPage.getTalentInviteModalMessageTxt(), talentFirstName + ", I’d love for you to apply to our " + talentInvitePosition + " position. I like your profile and think you’d be a great fit for the team here in " + employerCity + ".");
        talentPage.selectTalentInviteSendInvitationBtn();
        Assert.assertEquals(talentPage.getTalentInvitedModalTitleTxt(), invitedModalTitle);
        Assert.assertEquals(talentPage.getTalentInvitedModalTxt(), "You have successfully invited " + talentFirstName +  " to apply for " + talentInvitePosition + ". " +  "The applicant will appear on your dashboard once the application process has been completed.");
        talentPage.selectTalentInvitedDoneBtn();

        /* Verify user moved to 'Invited' tab */
        talentPage.selectTalentInvitedTab();
        talentPage.waitForLoadingIndicator();

        /* Verify Invited talent title */
        Assert.assertEquals(talentPage.getEmployerTalentInvitedTitleTxt(), talentInvitedTitle);

        /* Verify talent card on 'Invited' tab */
        Assert.assertEquals(talentPage.getTalentName(cardIndex), talentName, "Applicant's name should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentLocation(cardIndex), talentLocation, "Applicant's location should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentPosition(cardIndex), talentJob + talentJobLocation, "Card should have the job position and address");
        Assert.assertEquals(talentPage.getTalentSharedConnections(cardIndex), talentSharedConnections, "Card should have the number of mutual connections");

        /* Log out */
        navPage.attemptLogout();

        /* Check receipt of email */
        talentEmail = sqlSelect.getEmailByName(talentFirstName, talentLastName);
        emailsPage.openInboxMessageByEmailAddress(talentEmail);
        emailsPage.selectEmailViewJobAction();

        /* Verify user auth'd and directed to job details page of selected job */
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerName(), employerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsPosition(), jobPosition);
    }

    @Test
    public void testEmployerTalentApplicants() throws Exception {
        /* Create applicant */
        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.postApplication(userId, userGuid, jobGuid);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store talent page */
        navPage.switchToEmployerView();
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Navigate to Applicants tab */
        talentPage.selectTalentApplicantsTab();
        talentPage.waitForLoadingIndicator();

        /* Verify Applicant talent title */
        Assert.assertEquals(talentPage.getEmployerApplicantsTitleTxt(), talentApplicantsTitle);

        /* Get applicant info */
        applicantFirstName = testUtils.getStringFirstWord(applicantName);
        applicantLastName = testUtils.getStringLastWord(applicantName);

        /* Verify applicant card */
        Assert.assertEquals(talentPage.getApplicantName(cardIndex), applicantName);
        Assert.assertEquals(talentPage.getApplicantPosition(cardIndex), applicantPosition);
//        Assert.assertEquals(talentPage.getApplicantTime(cardIndex), applicantTime);
        Assert.assertEquals(talentPage.getApplicantSharedConnections(cardIndex), applicantSharedConnections);

        /* View applicant's profile */
        talentPage.selectApplicantViewProfileBtn(cardIndex);
        // Profile page does not have a loading indicator and doesn't render consistently, so the below assertion will fail without the sleep
        Thread.sleep(2000);
        Assert.assertTrue(hourlyProfileViewPage.isUserProfilePhotoPresent(), "User's photo should be displayed on profile view");

        /* Return to Find Talent */
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Log out */
        navPage.attemptLogout();

        /* Check receipt of applicant email */
        emailsPage.openInboxMessageByEmailAddress(email);
        emailsPage.selectEmailViewApplicantAction();

        /* Verify manager auth'd and routed to applicant's profile */
        // Wait for applicant profile to load
        Thread.sleep(3000);
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), applicantName);
        navPage.attemptLogout();
    }

    @Test
    public void testEmployerTalentGoodFit() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store talent page */
        navPage.switchToEmployerView();
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Get the details from the talent card at the specified index */
        talentName = talentPage.getTalentName(cardIndex);
        talentFirstName = testUtils.getStringFirstWord(talentName);
        talentLastName = testUtils.getStringLastWord(talentName);
        talentLocation = talentPage.getTalentLocation(cardIndex);
        talentJob = talentPage.getTalentPosition(cardIndex);
        talentSharedConnections = talentPage.getTalentSharedConnections(cardIndex);

        /* Mark talent as a "Good fit" */
        talentPage.selectTalentActionsBtn(cardIndex);
        talentPage.selectTalentActionsGoodFitBtn(cardIndex);

        /* Verify success toast */
        Assert.assertTrue(talentPage.verifyTalentSuccessToast(cardIndex), "Talent success toast should be displayed");
        talentPage.dismissTalentSuccessToast(cardIndex);

        /* Navigate to "Good fit" tab */
        talentPage.selectTalentGoodTab();
        talentPage.waitForLoadingIndicator();

        /* Verify Good fit talent title */
        Assert.assertEquals(talentPage.getEmployerTalentGoodTitleTxt(), talentGoodTitle);

        /* Verify talent card on 'Good fit' tab */
        Assert.assertEquals(talentPage.getTalentName(cardIndex), talentName, "Applicant's name should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentLocation(cardIndex), talentLocation, "Applicant's location should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentPosition(cardIndex), talentJob + talentJobLocation, "Card should have the job position and address");
        Assert.assertEquals(talentPage.getTalentSharedConnections(cardIndex), talentSharedConnections, "Card should have the number of mutual connections");
    }

    @Test
    public void testEmployerTalentBadFit() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store talent page */
        navPage.switchToEmployerView();
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Get the details from the talent card at the specified index */
        talentName = talentPage.getTalentName(cardIndex);
        talentFirstName = testUtils.getStringFirstWord(talentName);
        talentLastName = testUtils.getStringLastWord(talentName);
        talentLocation = talentPage.getTalentLocation(cardIndex);
        talentJob = talentPage.getTalentPosition(cardIndex);
        talentSharedConnections = talentPage.getTalentSharedConnections(cardIndex);

        /* Mark talent as "Not a fit" */
        talentPage.selectTalentActionsBtn(cardIndex);
        talentPage.selectTalentActionsBadFitBtn(cardIndex);

        /* Verify success toast */
        Assert.assertTrue(talentPage.verifyTalentSuccessToast(cardIndex), "Talent success toast should be displayed");
        talentPage.dismissTalentSuccessToast(cardIndex);

        /* Navigate to "Not a fit" tab */
        talentPage.selectTalentBadTab();
        talentPage.waitForLoadingIndicator();

        /* Verify Not a fit talent title */
        Assert.assertEquals(talentPage.getEmployerTalentBadTitleTxt(), talentBadTitle);

        /* Verify talent card on 'Not a fit' tab */
        Assert.assertEquals(talentPage.getTalentName(cardIndex), talentName, "Applicant's name should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentLocation(cardIndex), talentLocation, "Applicant's location should be displayed on the card");
        Assert.assertEquals(talentPage.getTalentPosition(cardIndex), talentJob + talentJobLocation, "Card should have the job position and address");
        Assert.assertEquals(talentPage.getTalentSharedConnections(cardIndex), talentSharedConnections, "Card should have the number of mutual connections");

        /* Reset applicant to 'Good fit' status */
        talentPage.selectTalentActionsBtn(cardIndex);
        talentPage.selectTalentActionsGoodFitBtn(cardIndex);
    }

    @Test
    public void testEmployerFindTalentEmptyState() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(emptyStateEmail, password);

        /* Navigate to store talent page */
        navPage.switchToEmployerView();
        navPage.navigateToTalentPage();
        talentPage.waitForLoadingIndicator();

        /* Verify "All talent" empty state */
        Assert.assertEquals(talentPage.getEmployerTalentAllEmptyTitleTxt(), talentAllEmptyTitleTxt);
        Assert.assertEquals(talentPage.getEmployerTalentAllEmptyTxt(), talentAllEmptyTxt);

        /* Navigate to "Good fit" tab */
        talentPage.selectTalentGoodTab();

        /* Verify "Good fit" empty state */
        Assert.assertEquals(talentPage.getEmployerTalentGoodEmptyTitleTxt(), talentGoodEmptyTitleTxt);
        Assert.assertEquals(talentPage.getEmployerTalentGoodlEmptyTxt(), talentGoodEmptyTxt);

        /* Navigate to "Invited to Apply " tab */
        talentPage.selectTalentInvitedTab();

        /* Verify "Invited to Apply" empty state */
        Assert.assertEquals(talentPage.getEmployerTalentInvitedEmptyTitleTxt(), talentInvitedEmptyTitleTxt);
        Assert.assertEquals(talentPage.getEmployerTalentInvitedlEmptyTxt(), talentInvitedEmptyTxt);

        /* Navigate to "Applicants" tab */
        talentPage.selectTalentApplicantsTab();

        /* Verify "Applicants" empty state */
        Assert.assertEquals(talentPage.getEmployerTalentApplicantsEmptyTitleTxt(), talentApplicantsEmptyTitleTxt);
        Assert.assertEquals(talentPage.getEmployerTalentApplicantsEmptyTxt(), talentApplicantsEmptyTxt);

        /* Navigate to "Not a fit" tab */
        talentPage.selectTalentBadTab();

        /* Verify "Not a fit" empty state */
        Assert.assertEquals(talentPage.getEmployerTalentBadEmptyTitleTxt(), talentBadEmptyTitleTxt);
        Assert.assertEquals(talentPage.getEmployerTalentBadEmptyTxt(), talentBadEmptyTxt);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws SQLException {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Find Talent test");
        navPage.attemptLogout();
        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.deleteJob(jobGuid);
        driver.quit();
    }
}