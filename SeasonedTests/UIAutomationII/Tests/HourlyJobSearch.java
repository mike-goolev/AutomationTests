import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HourlyJobSearch extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    JobSearchPage jobSearchPage;

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
    String employerGuid;
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
        jobPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobPosition");
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
        employerGuid = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerGuid");
        userGuid = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("userGuid");
        token = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("token");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        jobGuid = seasonedRestAPI.postJob();
        seasonedRestAPI.unfollowEmployer(employerGuid, userGuid);
        System.out.println("Created job with guid: " + jobGuid);
        System.out.println("Finished initializing test data...");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Starting job search tests...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);
    }

    @Test
    public void testHourlyJobSearchCommitSearchAndViewJobDetails() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        Assert.assertTrue(jobSearchPage.verifySearchLocationField(), "Search location field is present");
        jobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search result elements on job card at index 0 */
        jobSearchPage.waitForSearchResults("0");
        Assert.assertEquals(jobSearchPage.getSearchResultsCount(), searchResultsCount);
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(jobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(jobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(jobSearchPage.isApplyButtonEnabled("0"), "Apply button is enabled");

        /* View job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertTrue(jobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be enabled");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
        Assert.assertEquals(jobSearchPage.getJobDetailsWage(), jobDetailsWage);
        Assert.assertEquals(jobSearchPage.getJobDetailsJobDescription(), jobDetailsJobDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerName(), jobDetailsEmployerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescriptionTitle(), "About " + employerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescription(), jobDetailsEmployerDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerAddress(), jobDetailsEmployerAddress);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerPPA(), jobDetailsEmployerPPA);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerType(), jobDetailsEmployerType);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDistance(), jobDetailsEmployerDistance);

        /* Click 'Find Jobs' to return to search results */
        navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
        jobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 */
        Assert.assertEquals(jobSearchPage.getSearchResultsCount(), searchResultsCount);
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(jobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(jobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertTrue(jobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");

        /* View job search result at index 0 */
        jobSearchPage.clickJobPostingApplyBtn("0");

        /* Verify and dismiss success toast*/
        Assert.assertTrue(jobSearchPage.verifyApplySuccessToast());
        jobSearchPage.dismissApplySuccessToast();

        /* Navigate to job details */
        jobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertFalse(jobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be disabled");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
        Assert.assertEquals(jobSearchPage.getJobDetailsWage(), jobDetailsWage);
        Assert.assertEquals(jobSearchPage.getJobDetailsJobDescription(), jobDetailsJobDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerName(), jobDetailsEmployerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescriptionTitle(), "About " + employerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescription(), jobDetailsEmployerDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerAddress(), jobDetailsEmployerAddress);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerPPA(), jobDetailsEmployerPPA);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerType(), jobDetailsEmployerType);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDistance(), jobDetailsEmployerDistance);

        /* Click 'Find Jobs' to return to search results */
        navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
        jobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 and job is marked as 'Applied' */
        Assert.assertEquals(jobSearchPage.getSearchResultsCount(), searchResultsCount);
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(jobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(jobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertFalse(jobSearchPage.isApplyButtonEnabled("0"), "Apply button should be enabled");
    }

    @Test
    public void testHourlyJobSearchFollowStore() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        Assert.assertTrue(jobSearchPage.verifySearchLocationField(), "Search location field is present");
        jobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search result elements on job card at index 0 */
        jobSearchPage.waitForSearchResults("0");
        Assert.assertEquals(jobSearchPage.getSearchResultsCount(), searchResultsCount);
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(jobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(jobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertFalse(jobSearchPage.isApplyButtonEnabled("0"), "Apply button is disabled");

        /* Click job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn("0");

        /* Verify job details of selected job */
        Assert.assertFalse(jobSearchPage.isJobDetailsApplyButtonEnabled(), "Apply button should be disabled");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobDetailsPosition(),jobDetailsPosition);
        Assert.assertEquals(jobSearchPage.getJobDetailsWage(), jobDetailsWage);
        Assert.assertEquals(jobSearchPage.getJobDetailsJobDescription(), jobDetailsJobDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerName(), jobDetailsEmployerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescriptionTitle(), "About " + employerName);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDescription(), jobDetailsEmployerDescription);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerAddress(), jobDetailsEmployerAddress);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerPPA(), jobDetailsEmployerPPA);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerType(), jobDetailsEmployerType);
        Assert.assertEquals(jobSearchPage.getJobDetailsEmployerDistance(), jobDetailsEmployerDistance);

        /* Click the follow button for a given employer */
        jobSearchPage.clickJobDetailsFollowButton();
        jobSearchPage.verifyFollowSuccessToast();
        jobSearchPage.dismissFollowSuccessToast();
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowingButton());

        /* Click 'Back' to return to search results */
        navPage.navigateToJobsPage();
        /* Have to commit a new search here because we are not preserving the user's previous search query when navigating back to search results */
        jobSearchPage.searchForJobs("15", searchLocation);

        /* Verify search results match original search query on job card at index 0 */
        Assert.assertEquals(jobSearchPage.getSearchResultsCount(), searchResultsCount);
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo("0"), "Employer logo is present");
        Assert.assertEquals(jobSearchPage.getJobPosition("0"), jobPosition);
        Assert.assertEquals(jobSearchPage.getEmployerName("0"), employerName);
        Assert.assertEquals(jobSearchPage.getEmployerLocation( "0"), employerLocation); //Bug: Locator returns distance + zip
        Assert.assertFalse(jobSearchPage.isApplyButtonEnabled("0"), "Apply button is disabled");

         /* Click job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn("0");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowingButton());

        /* Click the following button to unfollow a given employer */
        jobSearchPage.clickJobDetailsFollowingButton();
        jobSearchPage.verifyFollowSuccessToast();
        jobSearchPage.dismissFollowSuccessToast();
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton());
    }

    @Test
    public void testHourlyJobSearchEmptyResults() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);

        /* Commit a search on the job search page */
        Assert.assertTrue(jobSearchPage.verifySearchLocationField(), "Search location field is present");
        jobSearchPage.searchForJobs("15", "Attu");

        /* Verify empty job search title and text  */
        jobSearchPage.verifyJobSearchEmptyResultElements();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly job search test");
        navPage.attemptLogout();
        driver.quit();
    }

    @AfterClass
    public void removeJob() {
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteJob(jobGuid);
    }
}