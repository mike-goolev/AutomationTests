package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.*;
import restInterfaces.*;

import java.sql.SQLException;
import java.util.List;

public class EmployerDash extends BaseTest {

    private HourlyLoginPage loginPage;
    private EmployerDashPage employerDashPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyJobSearchPage jobSearchPage;
    private EmployerProfileJobsPage employerProfileJobsPage;

    private String email;
    private String password;
    private String emptyStateEmail;
    private String cardIndex;
    private String dashTitle;
    private String firstName;
    private String applicantsTitle;
    private String applicantName;
    private String applicantPosition;
    private String applicantTime;
    private String applicantSharedConnections;
    private String applicantEmptyTitleTxt;
    private String applicantEmptyTxt;
    private String talentTitle;
    private String talentEmptyTitleTxt;
    private String talentEmptyTxt;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerState;
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
    private String jobAvailability;
    private List<String> jobGuids;
    String jobGuid;
    private String jobIndex;
    private String jobsEmptyTitleTxt;
    private String jobsEmptyTxt;
    private String userId;
    private String userGuid;


    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing employer dashboard test...");

        employerDashPage = new EmployerDashPage(driver);
        loginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        jobSearchPage = new HourlyJobSearchPage(driver);
        employerProfileJobsPage = new EmployerProfileJobsPage(driver);

        email = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("email");
        password = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("password");
        emptyStateEmail = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("emptyStateEmail");
        cardIndex = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("cardIndex");
        firstName = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("firstName");
        dashTitle = "Hi, " + firstName + ". Here is your daily dish";
        applicantsTitle = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantsTitle");
        applicantName = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantName");
        applicantPosition = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantPosition");
        applicantTime = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantTime");
        applicantSharedConnections = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantSharedConnections");
        applicantEmptyTitleTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantEmptyTitleTxt");
        applicantEmptyTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("applicantEmptyTxt");
        talentEmptyTitleTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("talentEmptyTitleTxt");
        talentEmptyTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("talentEmptyTxt");
        talentTitle = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("talentTitle");
        updatedBy = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("updatedBy");
        createdBy = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("createdBy");
        employerGuid = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("employerGuid");
        employerName = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("employerName");
        employerAddress = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("employerAddress");
        employerCity = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("employerCity");
        employerState = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("employerState");
        jobPosition = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobPosition");
        jobType = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobType");
        jobWage = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobWage");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobStatus");
        jobAvailability = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobAvailability");
        jobIndex = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobIndex");
        jobsEmptyTitleTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobsEmptyTitleTxt");
        jobsEmptyTxt = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("jobsEmptyTxt");
        userId = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("userId");
        userGuid = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("userGuid");
        token = (String) TestDataImporter.get("EmployerDash", "EmployerDash").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
                api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        api.postApplication(userId, userGuid, jobGuid);
        System.out.println("Starting employer dashboard test!");
    }

    @Test
    public void testEmployerDashViewCards() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify Dash title */
        Assert.assertEquals(employerDashPage.getEmployerDashTitleTxt(), dashTitle);

        /* Verify applicant */
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsTitleTxt(), applicantsTitle);
        Assert.assertTrue(employerDashPage.isApplicantCardDisplayed(cardIndex), "Applicant card should be displayed");
        Assert.assertTrue(employerDashPage.isApplicantCardPhotoDisplayed(cardIndex), "Applicant's photo should be displayed");
        Assert.assertEquals(employerDashPage.getApplicantName(cardIndex), applicantName);
        Assert.assertEquals(employerDashPage.getApplicantPosition(cardIndex), applicantPosition);
        Assert.assertEquals(employerDashPage.getApplicantTime(cardIndex), applicantTime);
        Assert.assertEquals(employerDashPage.getApplicantSharedConnections(cardIndex), applicantSharedConnections);

        /* View applicant profile */
        employerDashPage.selectApplicantViewProfileBtn(cardIndex);
//      Profile page does not have a loading indicator and doesn't render consistently, so the below assertion will fail without the sleep
        Thread.sleep(2000);
        hourlyProfileViewPage.isUserProfilePhotoPresent();
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), applicantName);

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify talent card */
        Assert.assertTrue(employerDashPage.isTalentTitleDisplayed());
        Assert.assertTrue(employerDashPage.isTalentCardDisplayed(cardIndex), "The talent card should be displayed");
        Assert.assertTrue(employerDashPage.isTalentCardPhotoDisplayed(cardIndex), "The talent card's photo should be displayed");

        /* View talent's profile */
        employerDashPage.selectTalentViewProfileBtn(cardIndex);
//      Profile page does not have a loading indicator and doesn't render consistently, so the below assertion will fail without the sleep
        Thread.sleep(2000);
        Assert.assertTrue(hourlyProfileViewPage.isUserProfilePhotoPresent());

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify active job postings */
        Assert.assertTrue(employerDashPage.isJobsTitleTextDisplayed(), "The jobs section title text should be displayed");
        Assert.assertTrue(employerDashPage.isJobCardEmployerLogoPresent(cardIndex), "The employer logo should be displayed on the job card");
        Assert.assertEquals(employerDashPage.getJobCardEmployerName(cardIndex), employerName);
        Assert.assertEquals(employerDashPage.getJobCardEmployerAddress(cardIndex), employerAddress + ", " + employerCity + ", " + employerState);
        Assert.assertEquals(employerDashPage.getJobPosition(cardIndex), jobPosition);
        Assert.assertEquals(employerDashPage.getJobAvailability(cardIndex), jobAvailability);
        Assert.assertEquals(employerDashPage.getJobWage(cardIndex), "$ " + jobWage + " / hour");

        /* View job details */
        employerDashPage.selectJobViewBtn(cardIndex);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerName(), employerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsPosition(), jobPosition);

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Edit job details */
        employerDashPage.selectJobEditBtn(cardIndex);
        Assert.assertEquals(employerProfileJobsPage.getJobPositionTxt(), jobPosition);

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

    }

    @Test
    public void testEmployerDashEmptyState() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(emptyStateEmail, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify empty applicant card */
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsEmptyTitleTxt(), applicantEmptyTitleTxt);
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsEmptyTxt(), applicantEmptyTxt);

        /* Select empty applicant CTA */
        employerDashPage.selectEditStoreProfileLink();

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify empty talent card */
        Assert.assertEquals(employerDashPage.getEmployerDashTalentEmptyTitleTxt(), talentEmptyTitleTxt);
        Assert.assertEquals(employerDashPage.getEmployerDashTalentEmptyTxt(), talentEmptyTxt);

        /* Select empty talent CTA */
        employerDashPage.selectPostJobLink();

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify empty job card */
        Assert.assertEquals(employerDashPage.getEmployerDashJobsEmptyTitleTxt(), jobsEmptyTitleTxt);
        Assert.assertEquals(employerDashPage.getEmployerDashJobsEmptyTxt(), jobsEmptyTxt);

        /* Select empty jobs CTA */
        employerDashPage.selectCreateJobLink();

        /* Return to Dash */
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();
    }

    @Test
    public void testEmployerDashGoodFit() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify Dash title */
        Assert.assertEquals(employerDashPage.getEmployerDashTitleTxt(), dashTitle);

        /* Verify applicant */
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsTitleTxt(), applicantsTitle);
        Assert.assertTrue(employerDashPage.isApplicantCardDisplayed(cardIndex), "Applicant card should be displayed");
        Assert.assertTrue(employerDashPage.isApplicantCardPhotoDisplayed(cardIndex), "Applicant's photo should be displayed");
        Assert.assertEquals(employerDashPage.getApplicantName(cardIndex), applicantName);
        Assert.assertEquals(employerDashPage.getApplicantPosition(cardIndex), applicantPosition);
        Assert.assertEquals(employerDashPage.getApplicantTime(cardIndex), applicantTime);
        Assert.assertEquals(employerDashPage.getApplicantSharedConnections(cardIndex), applicantSharedConnections);

        /* Set applicant as a 'Good fit' */
        employerDashPage.selectApplicantActionsBtn(cardIndex);
        employerDashPage.selectApplicantGoodFitBtn(cardIndex);
        Assert.assertTrue(employerDashPage.verifyApplicantSuccessToast(cardIndex), "The applicant success toast should be displayed");
        employerDashPage.dismissApplicantSuccessToast(cardIndex);

        /* Verify talent card */
        Assert.assertTrue(employerDashPage.isTalentTitleDisplayed());
        Assert.assertTrue(employerDashPage.isTalentCardDisplayed(cardIndex), "The talent card should be displayed");
        Assert.assertTrue(employerDashPage.isTalentCardPhotoDisplayed(cardIndex), "The talent card's photo should be displayed");

        /* Set talent as a 'Good fit' */
        employerDashPage.selectTalentActionsBtn(cardIndex);
        employerDashPage.selectTalentGoodFitBtn(cardIndex);
        Assert.assertTrue(employerDashPage.verifyTalentSuccessToast(cardIndex), "The talent success toast should be displayed");
        employerDashPage.dismissTalentSuccessToast(cardIndex);
    }

    @Test(enabled = false)
    public void testEmployerDashBadFit() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Verify Dash title */
        Assert.assertEquals(employerDashPage.getEmployerDashTitleTxt(), dashTitle);

        /* Verify applicant */
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsTitleTxt(), applicantsTitle);
        Assert.assertTrue(employerDashPage.isApplicantCardDisplayed(cardIndex), "Applicant card should be displayed");
        Assert.assertTrue(employerDashPage.isApplicantCardPhotoDisplayed(cardIndex), "Applicant's photo should be displayed");
        Assert.assertEquals(employerDashPage.getApplicantName(cardIndex), applicantName);
        Assert.assertEquals(employerDashPage.getApplicantPosition(cardIndex), applicantPosition);
        Assert.assertEquals(employerDashPage.getApplicantTime(cardIndex), applicantTime);
        Assert.assertEquals(employerDashPage.getApplicantSharedConnections(cardIndex), applicantSharedConnections);

        /* Set applicant as 'Not a good fit' */
        employerDashPage.selectApplicantActionsBtn(cardIndex);
        employerDashPage.selectApplicantBadFitBtn(cardIndex);
        Assert.assertTrue(employerDashPage.verifyApplicantSuccessToast(cardIndex), "The applicant success toast should be displayed");
        employerDashPage.dismissApplicantSuccessToast(cardIndex);

        /* Verify applicant empty state */
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsEmptyTitleTxt(), applicantEmptyTitleTxt);
        Assert.assertEquals(employerDashPage.getEmployerDashApplicantsEmptyTxt(), applicantEmptyTxt);

        /* Verify talent card */
        Assert.assertTrue(employerDashPage.isTalentTitleDisplayed());
        Assert.assertTrue(employerDashPage.isTalentCardDisplayed(cardIndex), "The talent card should be displayed");
        Assert.assertTrue(employerDashPage.isTalentCardPhotoDisplayed(cardIndex), "The talent card's photo should be displayed");

        /* Set talent as 'Not a good fit' */
        employerDashPage.selectTalentActionsBtn(cardIndex);
        employerDashPage.selectTalentBadFitBtn(cardIndex);
        Assert.assertTrue(employerDashPage.verifyTalentSuccessToast(cardIndex), "The talent success toast should be displayed");
        employerDashPage.dismissTalentSuccessToast(cardIndex);

        /* Reset applicant to 'Good fit' status */
        //Implmenent status reset on find talent page
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Dash test");
        navPage.attemptLogout();
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteJob(jobGuid);
        driver.quit();
    }
}