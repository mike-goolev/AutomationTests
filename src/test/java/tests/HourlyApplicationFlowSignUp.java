package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Locators;
import utils.TestDataImporter;

public class HourlyApplicationFlowSignUp extends BaseTest{

    protected HourlyRegistrationPage hourlyRegistrationPage;
    protected HourlyJobSearchPage hourlyJobSearchPage;
    protected HourlyApplicationFlowModalPage hourlyApplicationFlowModalPage ;
    protected HourlyBeSuccessfulPage hourlyBeSuccessfulPage;
    protected HourlyProfileWorkHistoryPage hourlyProfileWorkHistoryPage;
    protected HourlyProfileViewPage hourlyProfileViewPage;
    protected Locators.NavPageLocators navPageLocators;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password = "password";
    protected String experience;
    protected String employerName;
    protected String jobIndex;
    protected String jobName;
    protected String fromMonth;
    protected String fromYear;
    protected String toMonth;
    protected String toYear;
    protected String timeInterval;
    protected String skillAbilityToWorkFast;
    protected String skillCleanliness;
    protected String skillCreativity;
    protected String skillAbilityToWorkFastTxt;
    protected String skillCleanlinessTxt;
    protected String skillCreativityTxt;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUpTest(){
        hourlyRegistrationPage = new HourlyRegistrationPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyBeSuccessfulPage = new HourlyBeSuccessfulPage(driver);
        hourlyApplicationFlowModalPage = new HourlyApplicationFlowModalPage(driver);
        hourlyProfileWorkHistoryPage = new HourlyProfileWorkHistoryPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        navPageLocators = new Locators.NavPageLocators();

        firstName = "SeasFirst" + testUtils.generateRandomUUID();
        lastName = "SeasLast" + testUtils.generateRandomUUID();
        email = "seas" + testUtils.generateRandomUUID() + "@mailinator.com";
        experience = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("experienceRestaurant");
        employerName = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("experienceSelected");
        jobIndex = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("experienceJobIndex");
        jobName = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("experienceJobName");
        fromMonth = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("fromMonthExperienceIndex");
        fromYear = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("fromYearExperience");
        toMonth = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("toMonthExperienceIndex");
        toYear = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("toYearExperience");
        timeInterval = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("timeInterval");
        skillAbilityToWorkFast = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillAbilityToWorkFast");
        skillCleanliness = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillCleanliness");
        skillCreativity = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillCreativity");
        skillAbilityToWorkFastTxt = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillAbilityToWorkFastText");
        skillCleanlinessTxt = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillCleanlinessText");
        skillCreativityTxt = (String) TestDataImporter.get("HourlyApplicationFlowSignUp", "testHourlyApplyNowSignUp").get("skillCreativityText");


    }

    @Test
    public void testApplicationFlowOnSignUp() throws Exception {

        testUtils.loadBeSuccessfulPage();
        testUtils.loadJobSearchPage("austin-tx");

        /* Pick the job 0 */
        hourlyJobSearchPage.waitForSearchResults("0");

        /* Click Apply Now */
        hourlyJobSearchPage.clickJobPostingApplyBtn("0");

        /* Choose to Sign Up */
        hourlyApplicationFlowModalPage.clickJoinUsingEmailBtn();

        /* Create new Account */
        hourlyApplicationFlowModalPage.enterFirstName(firstName);
        hourlyApplicationFlowModalPage.enterLastName(lastName);
        hourlyApplicationFlowModalPage.enterEmail(email);

        hourlyApplicationFlowModalPage.enterPassword(password);
        hourlyApplicationFlowModalPage.clickContinueBtn();

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
        hourlyApplicationFlowModalPage.clickViewMyProfileBtn();


        /* Verify Profile added is Saved */
        /* Experience */
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getJobPosition("0", "0"), jobName);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyProfileWorkHistoryPage.getTimePeriod("0").trim(), timeInterval);

        /* Availability */
        Assert.assertTrue(hourlyProfileViewPage.verifyAvailabilityInterestTypeTxt("full-time"),"Work availability: full-time");
        Assert.assertTrue(hourlyProfileViewPage.verifyAllAvailabilitySelected(), "All availability has been selected");

        /* Skills */
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("0"), skillAbilityToWorkFastTxt);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("1"), skillCleanlinessTxt);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("2"), skillCreativityTxt);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the skills test");
        navPage.attemptLogout();
        driver.quit();
    }
}
