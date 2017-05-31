import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyJobSearch extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    JobSearchPage jobSearchPage;

    String usernameEmail;
    String passwordEmail;
    String searchTerm;
    String searchLocation;
    String jobPosition;
    String employerName;
    String employerDistance;
    String employerZip;
    String jobDetailsPosition;
    String jobDetailsWage;
    String jobDetailsJobDescription;
    String jobDetailsEmployerDescription;
    String jobDetailsEmployerName;
    String jobDetailsEmployerAddress;
    String jobDetailsEmployerPPA;
    String jobDetailsEmployerType;
    String jobDetailsEmployerDistance;
    String jobGuid;
    String employerGuid;
    String userGuid;
    String token;


    @BeforeClass
    public void setUp() {
        System.out.println("Initializing Hourly Job Search test...");
        /*driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        jobSearchPage = new JobSearchPage(driver);
        usernameEmail = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("username");
        passwordEmail = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("password");
        searchTerm = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("searchTerm");
        searchLocation = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("searchLocation");
        jobPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobPosition");
        employerName = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerName");
        employerDistance = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerDistance");
        employerZip = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("employerZip");
        jobDetailsPosition = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsPosition");
        jobDetailsWage = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsWage");
        jobDetailsJobDescription = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsJobDescription");
        jobDetailsEmployerDescription = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerDescription");
        jobDetailsEmployerName = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("jobDetailsEmployerName");
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
        System.out.println("Starting test run!");
    }

    @Test
    public void testHourlyJobSearchCommitSearchAndViewJobDetails() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPage(searchTerm, searchLocation);

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);
        navPage.waitForActivtyIndicator();

        /* Commit a search on the job search page */
        Assert.assertTrue(jobSearchPage.verifySearchTermField(), "Search term field is present");
        Assert.assertTrue(jobSearchPage.verifySearchLocationField(), "Search location field is present");
        jobSearchPage.searchForJobs(searchTerm, searchLocation);

        /* Verify search result elements on job card at index 0 */
        jobSearchPage.waitForSearchResults();
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobPosition(jobPosition), "Job position matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerName(employerName), "Employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerDistance(employerDistance), "Employer distance matches text param"); //Bug: Locator returns distance + zip
        Assert.assertTrue(jobSearchPage.verifyEmployerZip(employerZip), "Employer zip matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobPostingApplyButton(), "Apply button is present");

        /* View job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn();

        /* Verify job details of selected job */
        Assert.assertTrue(jobSearchPage.verifyJobDetailsApplyButton(), "Apply button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsPosition(jobDetailsPosition), "Job details position matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsWage(jobDetailsWage), "Job details wage matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsJobDescription(jobDetailsJobDescription), "Job details description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDescription(jobDetailsEmployerDescription), "Job details employer description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerName(jobDetailsEmployerName), "Job details employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerAddress(jobDetailsEmployerAddress), "Job details employer address matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerPPA(jobDetailsEmployerPPA), "Job details employer ppa matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerType(jobDetailsEmployerType), "Job details employer type matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDistance(jobDetailsEmployerDistance), "Job details employer distance matches text param");

        /* Click 'Back' to return to search results */
        jobSearchPage.clickJobDetailsBackButton();
        navPage.waitForActivtyIndicator();

        /* Verify search results match original search query on job card at index 0 */
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobPosition(jobPosition), "Job position matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerName(employerName), "Employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerDistance(employerDistance), "Employer distance matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerZip(employerZip), "Employer zip matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobPostingApplyButton(), "Apply button is present");

        /* View job search result at index 0 */
        jobSearchPage.clickJobPostingApplyBtn();

        /* Verify job details of selected job */
        Assert.assertTrue(jobSearchPage.verifyJobDetailsAppliedButton(), "Applied button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsPosition(jobDetailsPosition), "Job details position matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsWage(jobDetailsWage), "Job details wage matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsJobDescription(jobDetailsJobDescription), "Job details description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDescription(jobDetailsEmployerDescription), "Job details employer description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerName(jobDetailsEmployerName), "Job details employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerAddress(jobDetailsEmployerAddress), "Job details employer address matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerPPA(jobDetailsEmployerPPA), "Job details employer ppa matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerType(jobDetailsEmployerType), "Job details employer type matches text param");
        /*Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDistance(jobDetailsEmployerDistance), "Job details employer distance matches text param");*/ //Bug: Employer distance returns 0.00 miles away

        /* Click 'Back' to return to search results */
        jobSearchPage.clickJobDetailsBackButton();
        navPage.waitForActivtyIndicator();

        /* Verify search results match original search query on job card at index 0 and job is marked as 'Applied' */
        Assert.assertTrue(jobSearchPage.verifyJobPostingAppliedButton(), "Applied button is present");
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobPosition(jobPosition), "Job position matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerName(employerName), "Employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerDistance(employerDistance), "Employer distance matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerZip(employerZip), "Employer zip matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobPostingAppliedButton(), "Applied button is present");
    }

    @Test
    public void testHourlyJobSearchFollowStore() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPage(searchTerm, searchLocation);

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(usernameEmail, passwordEmail);
        navPage.waitForActivtyIndicator();

        /* Commit a search on the job search page */
        Assert.assertTrue(jobSearchPage.verifySearchTermField(), "Search term field is present");
        Assert.assertTrue(jobSearchPage.verifySearchLocationField(), "Search location field is present");
        jobSearchPage.searchForJobs(searchTerm, searchLocation);

        /* Verify search result elements on job card at index 0 */
        jobSearchPage.waitForSearchResults();
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobPosition(jobPosition), "Job position matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerName(employerName), "Employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerDistance(employerDistance), "Employer distance matches text param"); //Bug: Locator returns distance + zip
        Assert.assertTrue(jobSearchPage.verifyEmployerZip(employerZip), "Employer zip matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobPostingApplyButton(), "Apply button is present");

        /* Click job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn();

        /* Verify job details of selected job */
        Assert.assertTrue(jobSearchPage.verifyJobDetailsApplyButton(), "Apply button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton(), "Follow button is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsPosition(jobDetailsPosition), "Job details position matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsWage(jobDetailsWage), "Job details wage matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsJobDescription(jobDetailsJobDescription), "Job details description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDescription(jobDetailsEmployerDescription), "Job details employer description matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerName(jobDetailsEmployerName), "Job details employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerAddress(jobDetailsEmployerAddress), "Job details employer address matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerPPA(jobDetailsEmployerPPA), "Job details employer ppa matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerType(jobDetailsEmployerType), "Job details employer type matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobDetailsEmployerDistance(jobDetailsEmployerDistance), "Job details employer distance matches text param");

        /* Click the follow button for a given employer*/
        jobSearchPage.clickJobDetailsFollowButton();
        navPage.waitForActivtyIndicator();
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowingButton());

        /* Click 'Back' to return to search results */
        jobSearchPage.clickJobDetailsBackButton();
        navPage.waitForActivtyIndicator();

        /* Verify search results match original search query on job card at index 0 */
        Assert.assertTrue(jobSearchPage.verifyEmployerLogo(), "Employer logo is present");
        Assert.assertTrue(jobSearchPage.verifyJobPosition(jobPosition), "Job position matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerName(employerName), "Employer name matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerDistance(employerDistance), "Employer distance matches text param");
        Assert.assertTrue(jobSearchPage.verifyEmployerZip(employerZip), "Employer zip matches text param");
        Assert.assertTrue(jobSearchPage.verifyJobPostingApplyButton(), "Apply button is present");

         /* Click job search result at index 0 */
        jobSearchPage.clickJobPostingViewBtn();
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowingButton());
        jobSearchPage.clickJobDetailsFollowingButton();
        Assert.assertTrue(jobSearchPage.verifyJobDetailsFollowButton());
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Job Search test");
        navPage.logout();
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.deleteJob(jobGuid);
        driver.quit();
    }
}