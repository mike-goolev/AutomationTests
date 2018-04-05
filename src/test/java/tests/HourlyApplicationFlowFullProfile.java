package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HourlyApplicationFlowModalPage;
import pages.HourlyJobSearchPage;
import pages.HourlyLoginPage;
import restInterfaces.SeasonedRestAPI;
import utils.TestDataImporter;
import utils.TestUtils;

import java.sql.SQLException;
import java.util.List;

public class HourlyApplicationFlowFullProfile extends BaseTest{

    protected HourlyLoginPage hourlyLoginPage;
    protected HourlyJobSearchPage hourlyJobSearchPage;
    protected HourlyApplicationFlowModalPage hourlyApplicationFlowModalPage ;
    protected SeasonedRestAPI api;
    
    String usernametoApply;
    String passwordtoApply;
    String searchPosition;
    String searchLocation;
    String searchResultsCount;
    String jobPosition;
    String employerName;
    String employerDistance;
    String employerLocation;
    String jobDetailsPosition;
    String jobDetailsWage;
    String jobDetailsJobDescription;
    String jobDetailsEmployerName;
    String jobDetailsEmployerDescription;
    String jobDetailsEmployerAddress;
    String jobDetailsEmployerPPA;
    String jobDetailsEmployerType;
    String jobDetailsEmployerDistance;
    String jobGuid;
    String createdBy;
    String updatedBy;
    String jobType;
    String jobWage;
    String jobMinWage;
    String jobMaxWage;
    String jobWageType;
    String jobDescription;
    String jobStatus;
    String employerGuid;
    private List<String> jobGuids;
    String userGuid;
    String token;
    
    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        
        usernametoApply = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("usernametoApply");
        passwordtoApply = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("passwordtoApply");
        searchResultsCount = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("searchResultsCount");
        searchPosition = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("searchPosition");
        searchLocation = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("searchLocation");
        createdBy = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("createdByGuid");
        updatedBy = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("updatedByGuid");
        jobType = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobTypeGuid");
        jobWage = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobWage");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobStatus");
        employerName = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("employerName");
        employerDistance = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("employerDistance");
        employerLocation = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("employerLocation");
        jobDetailsPosition = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsPosition");
        jobDetailsWage = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsWage");
        jobDetailsJobDescription = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsJobDescription");
        jobDetailsEmployerName = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerName");
        jobDetailsEmployerDescription = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerDescription");
        jobDetailsEmployerAddress = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerAddress");
        jobDetailsEmployerPPA = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerPPA");
        jobDetailsEmployerType = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerType");
        jobDetailsEmployerDistance = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobDetailsEmployerDistance");
        jobPosition = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("jobPosition") + " " + TestUtils.getCurrentDate();
        employerGuid = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("employerGuid");
        userGuid = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("userGuid");
        token = (String) TestDataImporter.get("HourlyApplicationFlowFullProfile", "testHourlyApplyNowFullProfile").get("token");

        System.out.println("Starting job search tests...");
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyApplicationFlowModalPage = new HourlyApplicationFlowModalPage(driver);
        api = new SeasonedRestAPI(token);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
            api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        api.unfollowEmployer(employerGuid, userGuid);
        System.out.println("Created job with guid: " + jobGuid);
    }
    
    @Test
    public void testHourlyJobSearchApplyNowAndViewJobDetails() throws Exception {
        /* Start test on the job search page */
        testUtils.loadBeSuccessfulPage();
        testUtils.loadJobSearchPage("austin-tx");

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernametoApply, passwordtoApply);

        /* Commit a search on the job search page */
        hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search result elements on job card at index 0 */
        hourlyJobSearchPage.waitForSearchResults("0");

        //TODO workaround to white form - not working
        /* View job search result at index 0 */
       // hourlyJobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
       // Assert.assertEquals(hourlyJobSearchPage.getJobDetailsPosition(), jobPosition);

        /* Click 'Find Jobs' to return to search results */
       // navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
       // hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 */
       // hourlyJobSearchPage.waitForSearchResults("0");

        /* Apply for Job */
        hourlyJobSearchPage.clickJobPostingApplyBtn("0");

        /* Verify and dismiss success toast*/
        hourlyApplicationFlowModalPage.waitForApplySuccessToast();
        hourlyApplicationFlowModalPage.dismissApplySuccessToast();

        /* Navigate to job details */
        hourlyJobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertFalse(hourlyJobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be disabled");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsPosition(),jobPosition);
//        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsWage(), jobDetailsWage);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsJobDescription(), jobDetailsJobDescription);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerName(), jobDetailsEmployerName);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDescriptionTitle(), "About " + employerName);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDescription(), jobDetailsEmployerDescription);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerAddress(), jobDetailsEmployerAddress);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerType(), jobDetailsEmployerType);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDistance(), jobDetailsEmployerDistance);

        /* Click 'Find Jobs' to return to search results */
        navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
        hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 and job is marked as 'Applied' */
        hourlyJobSearchPage.waitForSearchResults("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertFalse(hourlyJobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the hourly job search test");
        navPage.attemptLogout();
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteJob(jobGuid);
        driver.quit();
    }
}
