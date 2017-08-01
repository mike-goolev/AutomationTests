import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HourlyRegistration extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    SignupPage signupPage;
    JobSearchPage jobSearchPage;
    ContentFeedPage contentFeedPage;
    ProfilePage profilePage;

    String ipLocation;
    String userLocation;
    String firstName;
    String lastName;
    String email;
    String password;
    String availabilityStatusOpen;
    String availabilityStatusLooking;
    String availabilityStatusEmployed;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing Hourly Registration test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        signupPage = new SignupPage(driver);
        jobSearchPage = new JobSearchPage(driver);
        profilePage = new ProfilePage(driver);
        contentFeedPage = new ContentFeedPage(driver);

        ipLocation = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("ipLocation");
        userLocation = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("userLocation");
        firstName = ("ssHourlyFirst" + testUtils.generateRandomUUID());
        lastName = ("ssHourlyLast" + testUtils.generateRandomUUID());
        email = (testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("password");
        availabilityStatusOpen = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusOpen");
        availabilityStatusLooking = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusLooking");
        availabilityStatusEmployed = (String) TestDataImporter.get("HourlyRegistration", "testHourlySignUpByEmail").get("availabilityStatusEmployed");
        System.out.println("Starting test run!");
    }

    @Test
    public void testHourlySignUpAllJobsByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickJobsExperience();

        /* Confirm location */
        signupPage.waitForLocation();
        Assert.assertEquals(signupPage.getLocationTxt(), ipLocation);
        signupPage.setUserLocation(userLocation);
        Assert.assertEquals(signupPage.getLocationTxt(), userLocation);
        signupPage.clickLocationNextBtn();

        /* Select job(s) */
        signupPage.selectAllJobs();

        /* Select sign up method */
        signupPage.signupEmail();

        /* Sign up by email */
        signupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        jobSearchPage.verifyPositionDropdown();

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify user's availability status */
        profilePage.isUserProfilePhotoPresent();
        profilePage.verifyAvailabilityTitle();
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt(availabilityStatusLooking));
    }

    @Test
    public void testHourlySignUpPopularJobsByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickJobsExperience();

        /* Confirm location */
        signupPage.waitForLocation();
        Assert.assertEquals(signupPage.getLocationTxt(), ipLocation);
        signupPage.setUserLocation(userLocation);
        Assert.assertEquals(signupPage.getLocationTxt(), userLocation);
        signupPage.clickLocationNextBtn();

        /* Select job(s) */
        signupPage.selectPopularJobs();
        signupPage.clickJobsNextBtn();

        /* Select sign up method */
        signupPage.signupEmail();

        /* Sign up by email */
        signupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        jobSearchPage.verifyPositionDropdown();

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify user's availability status */
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt(availabilityStatusLooking));
    }

    @Test
    public void testHourlySignUpSelectedJobsByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickJobsExperience();

        /* Confirm location */
        signupPage.waitForLocation();
        Assert.assertEquals(signupPage.getLocationTxt(), ipLocation);
        signupPage.setUserLocation(userLocation);
        Assert.assertEquals(signupPage.getLocationTxt(), userLocation);
        signupPage.clickLocationNextBtn();

        /* Select job(s) */
        signupPage.selectJobsFromList();
        signupPage.selectSpecificJobsByIndex("0");
        signupPage.clickJobsNextBtn();

        /* Select sign up method */
        signupPage.signupEmail();

        /* Sign up by email */
        signupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Jobs page */
        jobSearchPage.verifyPositionDropdown();

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify user's availability status */
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt(availabilityStatusOpen));
    }

    @Test
    public void testHourlySignUpCareerByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickCareerExperience();

        /* Confirm location */
        signupPage.waitForLocation();
        Assert.assertEquals(signupPage.getLocationTxt(), ipLocation);
        signupPage.setUserLocation(userLocation);
        Assert.assertEquals(signupPage.getLocationTxt(), userLocation);
        signupPage.clickLocationNextBtn();

        /* Select topics */
        signupPage.selectTopicsByIndex("0");
        signupPage.clickTopicsNextBtn();

        /* Select sign up method */
        signupPage.signupEmail();

        /* Sign up by email */
        signupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Content page */
        /*contentFeedPage.();*/

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify user's availability status */
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt(availabilityStatusOpen));
    }

    @Test
    public void testHourlySignUpNetworkByEmail() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickNetworkExperience();

        /* Confirm location */
        signupPage.waitForLocation();
        Assert.assertEquals(signupPage.getLocationTxt(), ipLocation);
        signupPage.setUserLocation(userLocation);
        Assert.assertEquals(signupPage.getLocationTxt(), userLocation);
        signupPage.clickLocationNextBtn();

        /* Select topics */
        signupPage.selectTopicsByIndex("0");
        signupPage.selectTopicsByIndex("1");
        signupPage.selectTopicsByIndex("2");
        signupPage.selectTopicsByIndex("3");
        signupPage.selectTopicsByIndex("4");
        signupPage.clickTopicsNextBtn();

        /* Select sign up method */
        signupPage.signupEmail();

        /* Sign up by email */
        signupPage.registerEmail(firstName, lastName, email, password);

        /* Verify user lands on Content page */
        /*contentFeedPage.();*/

        /* Navigate to profile page */
        navPage.navigateToProfilePage();

        /* Verify user's availability status */
        Assert.assertTrue(profilePage.verifyAvailabilityInterestStatusTxt(availabilityStatusOpen));
    }

    @Test
    public void testHourlySignUpManagerRedirect() throws Exception {
        /* Start test on the job search page */
        testUtils.loadJobSearchPageNoTerms();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        signupPage.clickHireExperience();

        /* TO DO -- Verify user directed to manager login page */
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Hourly Registration test");
        navPage.attemptLogout();
        driver.quit();
    }
}