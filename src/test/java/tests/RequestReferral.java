package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import restInterfaces.SeasonedRestAPI;
import utils.TestDataImporter;

import java.sql.SQLException;

public class RequestReferral extends BaseTest{

    protected EmployerDashPage employerDashPage;
    protected HourlyLoginPage loginPage;
    protected EmployerRequestReferralPage employerRequestReferralPage;
    protected HourlyRefferedToApplyToJobPage hourlyRefferedToApplyToJobPage;
    protected HourlyJobSearchPage hourlyJobSearchPage;
    protected HourlyApplicationFlowModalPage hourlyApplicationFlowModalPage ;
    protected EmployerFindTalentPage talentPage;

    protected String email;
    protected String password;
    protected String title;
    protected String jobNameReferralModal;
    protected String jobName;
    protected String firstNameReferrer;
    protected String lastNameReferrer;
    protected String emailReferrer;
    protected String token;
    protected MessagesPage messagesPage ;
    protected String expPlaceholder;
    protected String tinyURL;
    protected String firstNameReferred;
    protected String lastNameReferred;
    protected String emailReferred;
    protected String experience;
    protected String employerName;
    protected String jobIndex;
    protected String fromMonth;
    protected String fromYear;
    protected String toMonth;
    protected String toYear;
    protected String timeInterval;
    protected String skillAbilityToWorkFast;
    protected String skillCleanliness;
    protected String skillCreativity;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        employerDashPage = new EmployerDashPage(driver);
        loginPage = new HourlyLoginPage(driver);
        employerRequestReferralPage = new EmployerRequestReferralPage(driver);
        email = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("email");
        password = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("password");

    }

    @Test
    public void testEmployerRequestReferralModal() throws InterruptedException {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Get Job Name */
        jobName = employerDashPage.getJobCardJobName("0");
        title = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalTitlepart1") + jobName + (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalTitlepart2");

        /* Click Get Refferals button from Job Card with index 0 */
        employerDashPage.selectGetReferralsBtn("0");

        /* Get Request Refferal title and assert to contain the job Name in it's Title same as of the Job Card selected */
        jobNameReferralModal = employerRequestReferralPage.getRequestReferralModaltitle();
        Assert.assertEquals(jobNameReferralModal, title);

        /* Get Request Referral Modal description and assert it with expected one */
        String expDescription = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalDescription");
        String description = employerRequestReferralPage.getRequestReferralDescription();
        Assert.assertEquals(description, expDescription);

        /* Get Request Referral Modal Referrals Input box's Label and compare with expected one */
        String expLabel= (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalReferralsInputboxLabel");
        String label = employerRequestReferralPage.getRequestReferralModalReferralsInputLabel();
        Assert.assertEquals(label, expLabel);

        /* Get Message placeholder and compare with expected one */
        String expPlaceholder = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalMessagePlaceholderpart1") + jobName + (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("referralModalMessagePlaceholderpart2");
        String placeholder = employerRequestReferralPage.getRequestReferralModalMessagePlaceholder();
        Assert.assertEquals(placeholder, expPlaceholder);

        /* Enter at least one referrer to check Get Regerrals button being enabled */
        Assert.assertEquals(employerRequestReferralPage.checkRequestReferralModalGetReferralsBtnEnabled(), false);
        employerRequestReferralPage.enterRequestReferralModalReferrerName("SeasReferral");
        employerRequestReferralPage.selectRequestReferralModalReferrerFromDropdownList();
        Assert.assertEquals(employerRequestReferralPage.checkRequestReferralModalGetReferralsBtnEnabled(), true);

        /* Close Referrals modal */
        employerRequestReferralPage.closeRequestRefferalPage();
    }

    @Test
    public void testEmployerRequestReferralAdminSide() throws InterruptedException {

        firstNameReferrer = ("referrerF" + testUtils.generateRandomUUID());
        lastNameReferrer = ("referrerL" + testUtils.generateRandomUUID());
        emailReferrer = (firstNameReferrer.toLowerCase() + "@seasoned.pizza");

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();
        /* Sign Up new member through API */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.signUpMember(firstNameReferrer, lastNameReferrer, emailReferrer, "password");

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store dashboard page */
        navPage.switchToEmployerView();
        navPage.navigateToDashPage();
        employerDashPage.waitForLoadingIndicator();

        /* Click Get Refferals button from Job Card with index 0 */
        employerDashPage.selectGetReferralsBtn("0");

        /* Select Referrer */
        expPlaceholder = employerRequestReferralPage.getRequestReferralModalMessagePlaceholder();
        employerRequestReferralPage.enterRequestReferralModalReferrerName(firstNameReferrer);
        employerRequestReferralPage.selectRequestReferralModalReferrerFromDropdownList();

        /* Send referrals by clicking Get Referrals Button */
        Thread.sleep(3000 );
        employerRequestReferralPage.clickRequestReferralModalGetReferralsBtn();
        employerRequestReferralPage.checkReferralsSuccessToastDisplayed();

    }

    @Test(dependsOnMethods = {"testEmployerRequestReferralAdminSide"})
    public void testReferralsReferrerSide(){

        messagesPage = new MessagesPage(driver);

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        System.out.println("Credentials used for referrer: " + emailReferrer + ", " + firstNameReferrer);
        loginPage.loginWithEmail(emailReferrer, "password");

        /* Open Messages Top Modal and check a message received from admin who asked for referrals */
        navPage.clickMessagesLink();

        Assert.assertEquals(messagesPage.getMsgListRecipientNameText(), "Love & War in Texas");

        messagesPage.clickMsgItem();

        //Verify text area and tiny URL in Message Thread
        Assert.assertEquals(messagesPage.getReferralMessageText("0"), expPlaceholder);
        tinyURL = messagesPage.getReferralTinyURL("0");
        System.out.println(tinyURL);

    }

    @Test(dependsOnMethods = {"testReferralsReferrerSide"})
    public void testReferralsApplyJobUsingTinyURL() throws Exception {

        hourlyRefferedToApplyToJobPage = new HourlyRefferedToApplyToJobPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyApplicationFlowModalPage =new HourlyApplicationFlowModalPage(driver);
        firstNameReferred = ("referredF" + testUtils.generateRandomUUID());
        lastNameReferred = ("referredL" + testUtils.generateRandomUUID());
        emailReferred = (firstNameReferred.toLowerCase() + "@seasoned.pizza");
        experience = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("experienceRestaurant");
        employerName = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("experienceSelected");
        jobIndex = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("experienceJobIndex");
        //jobNameHire = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("experienceJobName");
        fromMonth = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("fromMonthExperienceIndex");
        fromYear = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("fromYearExperience");
        toMonth = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("toMonthExperienceIndex");
        toYear = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("toYearExperience");
        timeInterval = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("timeInterval");
        skillAbilityToWorkFast = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("skillAbilityToWorkFast");
        skillCleanliness = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("skillCleanliness");
        skillCreativity = (String) TestDataImporter.get("RequestReferral", "testRequestReferral").get("skillCreativity");


        /* Sign Up new member through API */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.signUpMember(firstNameReferred, lastNameReferred, emailReferred, "password");

        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        System.out.println("Credentials used for referred: " + emailReferred + ", " + firstNameReferred);
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(emailReferred, "password");
        Thread.sleep(3000);

        /* Load the tinyURL */
        driver.get(tinyURL);

        //TODO: check title and description

        /* Click Let's See it button to move to Job Details page */
        if(hourlyRefferedToApplyToJobPage.checkReferredWelcomeDialogExists()){
            hourlyRefferedToApplyToJobPage.clickReferredWelcomeDialogLetsSeeItBtn();
        }

        /* Check Apply Now button to be enabled and click it to Apply to this job */
        Assert.assertEquals(hourlyJobSearchPage.isJobDetailsApplyButtonEnabled(), true);
        hourlyJobSearchPage.clickJobDetailsApplyNowBtn();

        /* Confirm to continue to add more profile info */
        hourlyApplicationFlowModalPage.clickContinueToAddProfileInfo();

        /* Add Experience */
        hourlyApplicationFlowModalPage.enterExperience(experience);
        hourlyApplicationFlowModalPage.selectJobPosition(jobIndex);
        hourlyApplicationFlowModalPage.selectFromMonth(fromMonth);
        hourlyApplicationFlowModalPage.selectFromYear(fromYear);
        hourlyApplicationFlowModalPage.selectToMonth(toMonth);
        hourlyApplicationFlowModalPage.selectToYear(toYear);

        hourlyApplicationFlowModalPage.clickContinueOnExperienceForm();

        /* Add Availability */
        hourlyApplicationFlowModalPage.clickFullTimeCardBtn();
        hourlyApplicationFlowModalPage.clickMorningsCardBtn();
        hourlyApplicationFlowModalPage.clickAfternoonsCardBtn();
        hourlyApplicationFlowModalPage.clickEveningsCardBtn();
        hourlyApplicationFlowModalPage.clickNightsCardBtn();

        hourlyApplicationFlowModalPage.clickContinuefromAvailabilityFormBtn();

        /* Add skills */
        hourlyApplicationFlowModalPage.clickSkillByIndex(skillAbilityToWorkFast);
        hourlyApplicationFlowModalPage.clickSkillByIndex(skillCleanliness);
        hourlyApplicationFlowModalPage.clickSkillByIndex(skillCreativity);

        /* Submit and press View Profile */
        hourlyApplicationFlowModalPage.clickSubmitfromSkillsForm();
        Thread.sleep(5000);
        hourlyJobSearchPage.clickViewMyProfileBtnFromJobPage();
    }


    public void testReferredApplicantOnAdminSide(){

        talentPage = new EmployerFindTalentPage(driver);
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

    }

public void test() throws InterruptedException {
    hourlyRefferedToApplyToJobPage = new HourlyRefferedToApplyToJobPage(driver);
    testUtils.loadBeSuccessfulPage();

    navPage.clickLoginBtn();
    loginPage.loginWithEmail("referredfee04e1daf@seasoned.pizza", "password");
    Thread.sleep(3000);
        driver.get("http://tinyurl.com/y7utnp5s");

    if(hourlyRefferedToApplyToJobPage.checkReferredWelcomeDialogExists()){
        hourlyRefferedToApplyToJobPage.clickReferredWelcomeDialogLetsSeeItBtn();
    }
}

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Request Referral test");
        navPage.attemptLogout();
        driver.quit();
    }
}
