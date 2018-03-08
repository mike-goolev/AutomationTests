package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;
import java.sql.SQLException;
import java.util.List;

public class HourlyJobSearch extends BaseTest {

    HourlyLoginPage hourlyLoginPage;
    HourlyJobSearchPage hourlyJobSearchPage;
    SeasonedRestAPI api;

    String usernameEmail;
    String passwordEmail;
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

    @BeforeClass
    public void intializeTestDataAndCreateJob() {
        System.out.println("Initializing Hourly Job Search test...");
        usernameEmail = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("password");
        searchResultsCount = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("searchResultsCount");
        searchPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("searchPosition");
        searchLocation = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("searchLocation");
        createdBy = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("createdByGuid");
        updatedBy = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("updatedByGuid");
        jobType = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobTypeGuid");
        jobWage = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobWage");
        jobMinWage = jobWage;
        jobMaxWage = jobWage;
        jobWageType = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobWageType");
        jobDescription = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDescription");
        jobStatus = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobStatus");
        employerName = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerName");
        employerDistance = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerDistance");
        employerLocation = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerLocation");
        jobDetailsPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsPosition");
        jobDetailsWage = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsWage");
        jobDetailsJobDescription = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsJobDescription");
        jobDetailsEmployerName = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerName");
        jobDetailsEmployerDescription = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerDescription");
        jobDetailsEmployerAddress = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerAddress");
        jobDetailsEmployerPPA = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerPPA");
        jobDetailsEmployerType = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerType");
        jobDetailsEmployerDistance = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerDistance");
        jobPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobPosition");
        employerGuid = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerGuid");
        userGuid = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("userGuid");
        token = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("token");
        System.out.println("Finished initializing test data...");
    }

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException{
        System.out.println("Starting job search tests...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        api = new SeasonedRestAPI(token);
        jobGuids = sqlSelect.getJobsByEmployer(employerGuid);
        for (String guid : jobGuids)
            api.deleteJob(guid);
        jobGuid = api.postJob(updatedBy, createdBy, jobType, employerGuid, jobPosition, jobWage, jobMinWage, jobMaxWage, jobWageType, jobDescription, jobStatus);
        api.unfollowEmployer(employerGuid, userGuid);
        System.out.println("Created job with guid: " + jobGuid);
    }

    @Test
    public void testHourlyJobSearchCommitSearchAndViewJobDetails() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search result elements on job card at index 0 */
        hourlyJobSearchPage.waitForSearchResults("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(hourlyJobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");

        /* View job search result at index 0 */
        hourlyJobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertTrue(hourlyJobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be enabled");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
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

        /* Verify search results match original search query on job card at index 0 */
        hourlyJobSearchPage.waitForSearchResults("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(hourlyJobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");

        /* View job search result at index 0 */
        hourlyJobSearchPage.clickJobPostingApplyBtn("0");

        /* Verify and dismiss success toast*/
        hourlyJobSearchPage.waitForApplySuccessToast();
        hourlyJobSearchPage.dismissApplySuccessToast();

        /* Navigate to job details */
        hourlyJobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertFalse(hourlyJobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be disabled");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
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

    @Test
    public void testHourlyJobSearchFollowStore() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search result elements on job card at index 0 */
        hourlyJobSearchPage.waitForSearchResults("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(hourlyJobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");

        /* Click job search result at index 0 */
        hourlyJobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertTrue(hourlyJobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be enabled");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
//        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsWage(), jobDetailsWage);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsJobDescription(), jobDetailsJobDescription);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerName(), jobDetailsEmployerName);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDescriptionTitle(), "About " + employerName);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDescription(), jobDetailsEmployerDescription);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerAddress(), jobDetailsEmployerAddress);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerType(), jobDetailsEmployerType);
        Assert.assertEquals(hourlyJobSearchPage.getJobDetailsEmployerDistance(), jobDetailsEmployerDistance);

        /* Click the follow button for a given employer */
        hourlyJobSearchPage.clickJobDetailsFollowButton();
        hourlyJobSearchPage.verifyFollowSuccessToast();
        hourlyJobSearchPage.dismissFollowSuccessToast();
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowingButton());

        /* Click 'Back' to return to search results */
        navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
        hourlyJobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 */
        hourlyJobSearchPage.waitForSearchResults("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(hourlyJobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(hourlyJobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(hourlyJobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");

         /* Click job search result at index 0 */
        hourlyJobSearchPage.clickJobPostingViewBtn("0");
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowingButton());

        /* Click the following button to unfollow a given employer */
        hourlyJobSearchPage.clickJobDetailsFollowingButton();
        hourlyJobSearchPage.verifyFollowSuccessToast();
        hourlyJobSearchPage.dismissFollowSuccessToast();
        Assert.assertTrue(hourlyJobSearchPage.verifyJobDetailsFollowButton());
    }

    @Test
    public void testHourlyJobSearchEmptyResults() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        hourlyJobSearchPage.searchForJobs("15", "Attu");

        /* Verify empty job search title and text  */
        hourlyJobSearchPage.verifyJobSearchEmptyResultElements();
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

    @AfterClass
    public void classTearDown() {
        driver.quit();
    }
}