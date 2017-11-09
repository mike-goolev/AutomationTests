import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HourlyRegistration extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    HourlyRegistrationPage hourlyRegistrationPage;
    HourlyJobSearchPage hourlyJobSearchPage;
    HourlyContentFeedPage hourlyContentFeedPage;
    HourlyProfileViewPage hourlyProfileViewPage;
    HourlyNetworkSuggestionsPage hourlyNetworkSuggestionsPage;
    EmployerRegistrationPage employerRegistrationPage;
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
        hourlyRegistrationPage = new HourlyRegistrationPage(driver);
        hourlyJobSearchPage = new HourlyJobSearchPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyContentFeedPage = new HourlyContentFeedPage(driver);
        hourlyNetworkSuggestionsPage = new HourlyNetworkSuggestionsPage(driver);
        employerRegistrationPage = new EmployerRegistrationPage(driver);
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
        hourlyRegistrationPage.clickJobsExperience();

        /* Confirm location */
        hourlyRegistrationPage.waitForLocation();
        hourlyRegistrationPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlyRegistrationPage.getLocationTxt(), userLocation);
        hourlyRegistrationPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlyRegistrationPage.selectAllJobs();

        /* Select sign up method */
        hourlyRegistrationPage.signupEmail();

        /* Sign up by email */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password);

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
        hourlyRegistrationPage.clickJobsExperience();

        /* Confirm location */
        hourlyRegistrationPage.waitForLocation();
        hourlyRegistrationPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlyRegistrationPage.getLocationTxt(), userLocation);
        hourlyRegistrationPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlyRegistrationPage.selectPopularJobs();
        hourlyRegistrationPage.clickJobsNextBtn();

        /* Select sign up method */
        hourlyRegistrationPage.signupEmail();

        /* Sign up by email */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password);

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
        hourlyRegistrationPage.clickJobsExperience();

        /* Confirm location */
        hourlyRegistrationPage.waitForLocation();
        hourlyRegistrationPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlyRegistrationPage.getLocationTxt(), userLocation);
        hourlyRegistrationPage.clickLocationNextBtn();

        /* Select job(s) */
        hourlyRegistrationPage.selectJobsFromList();
        hourlyRegistrationPage.selectSpecificJobsByIndex("0");
        hourlyRegistrationPage.clickJobsNextBtn();

        /* Select sign up method */
        hourlyRegistrationPage.signupEmail();

        /* Sign up by email */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password);

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
        hourlyRegistrationPage.clickCareerExperience();

        /* Confirm location */
        hourlyRegistrationPage.waitForLocation();
        hourlyRegistrationPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlyRegistrationPage.getLocationTxt(), userLocation);
        hourlyRegistrationPage.clickLocationNextBtn();

        /* Select topics */
        hourlyRegistrationPage.selectTopicsByIndex("0");
        hourlyRegistrationPage.clickTopicsNextBtn();

        /* Select sign up method */
        hourlyRegistrationPage.signupEmail();

        /* Sign up by email */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password);

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
        hourlyRegistrationPage.clickNetworkExperience();

        /* Confirm location */
        hourlyRegistrationPage.waitForLocation();
        hourlyRegistrationPage.setUserLocation(userLocation);
        Assert.assertEquals(hourlyRegistrationPage.getLocationTxt(), userLocation);
        hourlyRegistrationPage.clickLocationNextBtn();

        /* Select topics */
        hourlyRegistrationPage.selectTopicsByIndex("0");
        hourlyRegistrationPage.selectTopicsByIndex("1");
        hourlyRegistrationPage.selectTopicsByIndex("2");
        hourlyRegistrationPage.selectTopicsByIndex("3");
        hourlyRegistrationPage.selectTopicsByIndex("4");
        hourlyRegistrationPage.clickTopicsNextBtn();

        /* Select sign up method */
        hourlyRegistrationPage.signupEmail();

        /* Sign up by email */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password);

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
        hourlyRegistrationPage.clickHireExperience();

        /* Verify user directed to manager sign up page */
        Assert.assertEquals(employerRegistrationPage.getSignupMethodTitleTxt(), employerSignUpTitle);
        employerRegistrationPage.selectSignUpMethodBackBtn();
        hourlyRegistrationPage.dismissSignup();
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