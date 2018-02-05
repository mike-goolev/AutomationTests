import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class EmployerProfileJobs extends BaseTest {

    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;
    private EmployerProfileEditPage employerProfileEditPage;
    private EmployerProfileJobsPage employerProfileJobsPage;

    private String email;
    private String password;
    private String jobTypeIndex;
    private String jobName;
    private String jobCustomName;
    private String jobDescription;
    private String jobResponsibilities;
    private String jobSkill1;
    private String jobSkill2;
    private String jobSkill3;
    private String jobSkill4;
    private String jobSkill5;
    private String jobCertification1;
    private String jobCertification2;
    private String jobCertification3;
    private String jobCertification4;
    private String jobMinWage;
    private String jobMaxWage;
    private String jobWage;
    private String jobAvailabilityFulltime;
    private String jobIndex;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerState;
    private String employerZip;
    private String employerCountry;
    private String employerPhone;
    private String employerWebsite;
    private String employerGuid;
    private Long employerId;
    private Long employerTypeId;
    private String employerTypeName;
    private String employerDescription;

    private List<String> jobGuids;
    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing employer profile jobs test...");

        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        employerProfileJobsPage = new EmployerProfileJobsPage(driver);
        loginPage = new HourlyLoginPage(driver);

        email = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("email");
        password = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("password");
        jobIndex = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobIndex");
        jobTypeIndex = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobTypeIndex");
        jobName = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobName");
        jobCustomName = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobCustomName");
        jobDescription = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobDescription");
        jobResponsibilities = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobResponsibilities");
        jobSkill1 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobSkill1");
        jobSkill2 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobSkill2");
        jobSkill3 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobSkill3");
        jobSkill4 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobSkill4");
        jobSkill5 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobSkill5");
        jobCertification1 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobCertification1");
        jobCertification2 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobCertification2");
        jobCertification3 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobCertification3");
        jobCertification4 = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobCertification4");
        jobMinWage = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobMinWage");
        jobMaxWage = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobMaxWage");
        jobWage = "$ " + jobMinWage + " - " + jobMaxWage + " / hour";
        jobAvailabilityFulltime = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("jobAvailabilityFulltime");
        employerName = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerName");
        employerAddress = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerAddress");
        employerCity = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerCity");
        employerState = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerState");
        employerZip = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerZip");
        employerCountry = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerCountry");
        employerPhone = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerPhone");
        employerWebsite = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerWebsite");
        employerDescription = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerDescription");
        employerGuid = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerGuid");
        employerId = (Long) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerId");
        employerTypeId = (Long) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerTypeId");
        employerTypeName = (String) TestDataImporter.get("EmployerProfileJobs", "EmployerProfileJobs").get("employerTypeName");
        token = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.updateEmployerInfo(employerId, employerGuid, employerName, employerAddress, employerCity, employerState, employerZip, employerCountry, employerPhone, employerWebsite, employerDescription, employerTypeId, employerTypeName);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
            api.deleteJob(guid);
        System.out.println("Starting employer profile jobs test!");
    }

    @Test
    public void testEmployerProfileJobs() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify employer name */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), employerName);

        /* Navigate to edit store profile */
        employerProfileViewPage.selectManageStore();

        /* Navigate to edit job(s) */
        employerProfileEditPage.selectMenuHiringLink();

        /* Select to add new position */
        employerProfileJobsPage.selectAddNewJob();

        /* Select job type */
        employerProfileJobsPage.setJobPosition(jobTypeIndex);

        /* Select custom job name */
        employerProfileJobsPage.setJobPositionCustomName(jobCustomName);

        /* Set the job's description */
        employerProfileJobsPage.updateJobDescription(jobDescription);

        /* Set the job's responsibilities */
        employerProfileJobsPage.setJobResponsibilities(jobResponsibilities);

        /* Set the job's age requirement  */
        employerProfileJobsPage.selectAgeRequirement();

        /* Verify required skills */
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill1));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill2));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill3));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill4));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill5));

        /* Select required certifications */
        employerProfileJobsPage.setJobCertification(jobCertification1);
        employerProfileJobsPage.setJobCertification(jobCertification2);
        employerProfileJobsPage.setJobCertification(jobCertification3);
        employerProfileJobsPage.setJobCertification(jobCertification4);

        /* Set job's pay range */
//        employerProfileJobsPage.setJobMinWage(-50, 0);
//        employerProfileJobsPage.setJobMaxWage(-25, 0);

        /* Select position availability */
        employerProfileJobsPage.setJobAvailabilityFullTime();

        /* Select job shifts */
        employerProfileJobsPage.setJobShiftMorning();
        employerProfileJobsPage.setJobShiftAfternoon();
        employerProfileJobsPage.setJobShiftEvening();
        employerProfileJobsPage.setJobShiftNight();

        /* Save job */
        employerProfileJobsPage.selectSaveBtn();

        /* Verify toast */
        employerProfileJobsPage.verifyEmployerJobSuccessToast();
        employerProfileJobsPage.dismissEmployerJobSuccessToast();

        /* Verify job on the edit list */


        /* Navigate to store profile view */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify job card */
        employerProfileViewPage.scrollToJobCard(jobIndex);
        Assert.assertTrue(employerProfileViewPage.isJobCardEmployerLogoPresent(), "The employer logo should be displayed on the job card");
        Assert.assertEquals(employerProfileViewPage.getJobCardEmployerName(jobIndex), employerName);
        Assert.assertEquals(employerProfileViewPage.getJobCardEmployerAddress(jobIndex), employerAddress + ", " + employerCity + ", " + employerState);
        Assert.assertEquals(employerProfileViewPage.getJobPosition(jobIndex), jobCustomName);
        Assert.assertEquals(employerProfileViewPage.getJobAvailability(jobIndex), jobAvailabilityFulltime);
//        Assert.assertEquals(employerProfileViewPage.getJobWage(jobIndex), jobWage);

        /* Select to edit job */
        employerProfileViewPage.selectJobEditBtn(jobIndex);

        /* Verify job attributes */
        Assert.assertEquals(employerProfileJobsPage.getJobPositionTxt(), jobName);
        Assert.assertEquals(employerProfileJobsPage.getJobCustomNameTxt(), jobCustomName);
        Assert.assertEquals(employerProfileJobsPage.getJobDescriptionTxt(), jobDescription);
        Assert.assertEquals(employerProfileJobsPage.getJobResponsibilitiesTxt(), jobResponsibilities);
        Assert.assertTrue(employerProfileJobsPage.isAgeRequirementSelected(), "The '18 or older' check should be selected");
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill1));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill2));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill3));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill4));
        Assert.assertTrue(employerProfileJobsPage.isSkillSelected(jobSkill5));
        Assert.assertTrue(employerProfileJobsPage.isCertificationSelected(jobCertification1), "Alcohol cert should be displayed");
        Assert.assertTrue(employerProfileJobsPage.isCertificationSelected(jobCertification2), "Food handler cert should be displayed");
        Assert.assertTrue(employerProfileJobsPage.isCertificationSelected(jobCertification3), "Food protection cert should be displayed");
        Assert.assertTrue(employerProfileJobsPage.isCertificationSelected(jobCertification4), "HACCP cert should be displayed");
//        Assert.assertEquals(employerProfileJobsPage.getJobMinWageTxt(), jobMinWage);
//        Assert.assertEquals(employerProfileJobsPage.getJobMaxWageTxt(), jobMaxWage);
        Assert.assertTrue(employerProfileJobsPage.isJobAvailabilityFullTimeSelected(), "The 'full-time' availability option should be selected");
        Assert.assertTrue(employerProfileJobsPage.isJobShiftMorningSelected(), "The 'morning' shift should be selected");
        Assert.assertTrue(employerProfileJobsPage.isJobShiftAfternoonSelected(), "The 'afternoon' shift should be selected");
        Assert.assertTrue(employerProfileJobsPage.isJobShiftEveningSelected(), "The 'evening' shift should be selected");
        Assert.assertTrue(employerProfileJobsPage.isJobShiftNightSelected(), "The 'night' shift should be selected");

        /* Delete job */
        employerProfileJobsPage.deleteJob();

        /* Verify toast */
        employerProfileJobsPage.verifyEmployerJobSuccessToast();
        employerProfileJobsPage.dismissEmployerJobSuccessToast();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Profile Jobs test");
        navPage.attemptLogout();
        driver.quit();
    }
}