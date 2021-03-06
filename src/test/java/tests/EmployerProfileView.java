package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;

import java.sql.SQLException;
import java.util.List;

public class EmployerProfileView extends BaseTest {

    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;

    private String email;
    private String password;
    private String employerName;
    private String employerAddress;
    private String employerNameAndAddress;
    private String employerCity;
    private String employerState;
    private String employerZip;
    private String employerDistance;
    private String employerCountry;
    private String employerPhone;
    private String employerWebsite;
    private String employerGuid;
    private Long employerId;
    private String employerDescription;
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
    private Long employerTypeId;
    private String employerTypeName;
    private String jobIndex;
    private String staffIndex;
    private String staffName;
    private String staffLabel;
    private String staffDescription;
    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing employer profile view test...");

        employerProfileViewPage = new EmployerProfileViewPage(driver);
        loginPage = new HourlyLoginPage(driver);

        email = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("email");
        password = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("password");
        employerName = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerName");
        employerAddress = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerAddress");
        employerNameAndAddress = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerNameAndAddress");
        employerCity = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerCity");
        employerState = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerState");
        employerZip = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerZip");
        employerCountry = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerCountry");
        employerDistance = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerDistance");
        employerPhone = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerPhone");
        employerWebsite = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerWebsite");
        employerDescription = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerDescription");
        employerGuid = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerGuid");
        employerId = (Long) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerId");
        employerTypeId = (Long) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerTypeId");
        employerTypeName = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("employerTypeName");
        createdBy = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("createdBy");
        updatedBy = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("updatedBy");
        jobPosition = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobPosition");
        jobType = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobType");
        jobWage = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobWage");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobStatus");
        jobAvailability = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobAvailability");
        jobIndex = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("jobIndex");
        staffIndex = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("staffIndex");
        staffName = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("staffName");
        staffLabel = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("staffLabel");
        staffDescription = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("staffDescription");
        token = (String) TestDataImporter.get("EmployerProfileView", "EmployerProfileView").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.updateEmployerInfo(employerId, employerGuid, employerName, employerAddress, employerCity, employerState, employerZip, employerCountry, employerPhone, employerWebsite, employerDescription, employerTypeId, employerTypeName);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
            api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        System.out.println("Starting employer profile view test!");
    }

    @Test
    public void testEmployerProfileView() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify employer's name, address, city, state, zip, phone and website */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), employerName);
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderAddress(), employerAddress + ", " + employerCity + ", " + employerState);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardAddress(), employerAddress + ", " + employerCity + ", " + employerState + " " + employerZip);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardPhone(), employerPhone);

        /* Verify employer about */
        Assert.assertTrue(employerProfileViewPage.isAboutHeaderDisplayed());
        Assert.assertEquals(employerProfileViewPage.getAboutTitleTxt(), "About " + employerName);
        Assert.assertEquals(employerProfileViewPage.getAboutTxt(), employerDescription);

        /* Verify employer staff members */
        Assert.assertTrue(employerProfileViewPage.isManagementHeaderDisplayed());
        Assert.assertTrue(employerProfileViewPage.isManagerPhotoDisplayed(staffIndex));
        Assert.assertEquals(employerProfileViewPage.getManagerName(staffIndex), staffName);
        Assert.assertEquals(employerProfileViewPage.getManagerLabel(staffIndex), staffLabel);
        //Assert.assertEquals(employerProfileViewPage.getManagerDescription(staffIndex), staffDescription);

        /* Verify employer job(s) */
        Assert.assertTrue(employerProfileViewPage.isJobsHeaderDisplayed());
        Assert.assertTrue(employerProfileViewPage.isJobCardEmployerLogoPresent(jobIndex), "The employer logo should be displayed on the job card");
        Assert.assertEquals(employerProfileViewPage.getJobCardEmployerName(jobIndex), employerName);
        Assert.assertEquals(employerProfileViewPage.getJobPosition(jobIndex), jobPosition);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Profile View test");
        navPage.attemptLogout();
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteJob(jobGuid);
        driver.quit();
    }
}