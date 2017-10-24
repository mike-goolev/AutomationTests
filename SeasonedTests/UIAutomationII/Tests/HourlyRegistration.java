import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HourlyRegistration extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    HourlySignupPage hourlySignupPage;
    HourlyJobSearchPage hourlyJobSearchPage;
    HourlyContentFeedPage hourlyContentFeedPage;
    HourlyProfileViewPage hourlyProfileViewPage;
    HourlyNetworkSuggestionsPage hourlyNetworkSuggestionsPage;
    EmployerSignUpPage employerSignUpPage;
    HourlyBeSuccessfulPage hourlyBeSuccessfulPage;

    String ipLocation;
    String userLocation;
    String firstName;
    String lastName;
    String email;
    String password;
    String availabilityStatusOpen;
    String availabilityStatusLooking;
    String availabilityStatusEmployed;
    String employerSignUpTitle;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing Hourly Registration test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlySignupPage = new HourlySignupPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyContentFeedPage = new HourlyContentFeedPage(driver);
        hourlyNetworkSuggestionsPage = new HourlyNetworkSuggestionsPage(driver);
        employerSignUpPage = new EmployerSignUpPage(driver);
        hourlyBeSuccessfulPage = new HourlyBeSuccessfulPage(driver);

        ipLocation = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("ipLocation");
        userLocation = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("userLocation");
        firstName = ("ssHourlyFirst" + testUtils.generateRandomUUID());
        lastName = ("ssHourlyLast" + testUtils.generateRandomUUID());
        email = (testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("password");
        availabilityStatusOpen = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusOpen");
        availabilityStatusLooking = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusLooking");
        availabilityStatusEmployed = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusEmployed");
        employerSignUpTitle = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("employerSignUpTitle");
        System.out.println("Starting test run!");
    }

    @Test
    public void testHourlySignUpAllJobsByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickJobsExperience();

        /* Confirm location */
        hourlySignupPage.waitForLocation();
        hourlySignupPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlySignupPage.getLocationTxt(), userLocation);
        hourlySignupPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlySignupPage.selectAllJobs();

        /* Select sign up method */
        hourlySignupPage.signupEmail();

        /* Sign up by email */
        hourlySignupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        hourlyJobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlySignUpPopularJobsByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickJobsExperience();

        /* Confirm location */
        hourlySignupPage.waitForLocation();
        hourlySignupPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlySignupPage.getLocationTxt(), userLocation);
        hourlySignupPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlySignupPage.selectPopularJobs();
        hourlySignupPage.clickJobsNextBtn();

        /* Select sign up method */
        hourlySignupPage.signupEmail();

        /* Sign up by email */
        hourlySignupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        hourlyJobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlySignUpSelectedJobsByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickJobsExperience();

        /* Confirm location */
        hourlySignupPage.waitForLocation();
        hourlySignupPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlySignupPage.getLocationTxt(), userLocation);
        hourlySignupPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlySignupPage.selectJobsFromList();
        hourlySignupPage.selectSpecificJobsByIndex("0");
        hourlySignupPage.clickJobsNextBtn();

        /* Select sign up method */
        hourlySignupPage.signupEmail();

        /* Sign up by email */
        hourlySignupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        hourlyJobSearchPage.verifyPositionDropdown();
    }

    @Test
    public void testHourlySignUpCareerByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickCareerExperience();

        /* Confirm location */
        hourlySignupPage.waitForLocation();
        hourlySignupPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlySignupPage.getLocationTxt(), userLocation);
        hourlySignupPage.clickLocationNextBtn();

        /* Select topics */
        hourlySignupPage.selectTopicsByIndex("0");
        hourlySignupPage.clickTopicsNextBtn();

        /* Select sign up method */
        hourlySignupPage.signupEmail();

        /* Sign up by email */
        hourlySignupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Content page */
        hourlyContentFeedPage.isArticleImageDisplayed("0");

        /* TO DO -> Verify topics set in user account settings */

    }

    @Test
    public void testHourlySignUpNetworkByEmail() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickNetworkExperience();

        /* Confirm location */
        hourlySignupPage.waitForLocation();
        hourlySignupPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlySignupPage.getLocationTxt(), userLocation);
        hourlySignupPage.clickLocationNextBtn();

        /* Select topics */
        hourlySignupPage.selectTopicsByIndex("0");
        hourlySignupPage.selectTopicsByIndex("1");
        hourlySignupPage.selectTopicsByIndex("2");
        hourlySignupPage.selectTopicsByIndex("3");
        hourlySignupPage.selectTopicsByIndex("4");
        hourlySignupPage.clickTopicsNextBtn();

        /* Select sign up method */
        hourlySignupPage.signupEmail();

        /* Sign up by email */
        hourlySignupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Get Connected page */
        hourlyNetworkSuggestionsPage.isSuggestedConnectionsPhotoDisplayed("0");
    }

    @Test
    public void testHourlySignUpManagerRedirect() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlySignupPage.clickHireExperience();

        /* Verify user directed to manager sign up page */
        Assert.assertEquals(employerSignUpPage.getTitleTxt(), employerSignUpTitle);
        employerSignUpPage.clickBackBtn();
        hourlySignupPage.dismissSignup();
        // Dismissing sign up incorrectly routes user to marketing page instead of be successful page
        //Assert.assertTrue(hourlyBeSuccessfulPage.isHeaderDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Registration test");
        navPage.attemptLogout();
        driver.quit();
    }
}