package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import utils.TestConfig;
import restInterfaces.*;

import java.sql.SQLException;
import java.util.List;


public class EmployerRegistration extends BaseTest {

    private HourlyRegistrationPage hourlyRegistrationPage;
    private EmployerRegistrationPage employerRegistrationPage;
    private EmployerProfileViewPage employerProfileViewPage;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String employerSignUpTitle;
    private String emailSignUpTitle;
    private String locationTitle;
    private String employerSearchTerm;
    private String employerName;
    private String employerLocation;
    private String employerGuid;
    private String logoTitle;
    private String photosTitle;
    private String photoFilePath;
    private String photoName;
    private String storeTypeTitle;
    private List<String> employerPhotos;
    private String token;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing Employer Registration test...");
        employerRegistrationPage = new EmployerRegistrationPage(driver);
        hourlyRegistrationPage = new HourlyRegistrationPage(driver);
        employerProfileViewPage = new EmployerProfileViewPage(driver);

        firstName = ("ssAdminFirst" + testUtils.generateRandomUUID());
        lastName = ("ssAdminLast" + testUtils.generateRandomUUID());
        email = ("mgr" + testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("password");
        employerSignUpTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerSignUpTitle");
        emailSignUpTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("emailSignUpTitle");
        locationTitle = firstName + ", " + (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("locationTitle");
        employerSearchTerm = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerSearchTerm");
        employerName = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerName");
        employerLocation = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerLocation");
        logoTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("logoTitle");
        photosTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("photosTitle");
        photoName = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("photoName");
        storeTypeTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("storeTypeTitle");
        token = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("token");
        employerGuid = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerGuid");
        photoFilePath = TestConfig.getWorkingDir() + "/src/test/java/testData/"  + photoName;
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.unclaimEmployer(employerGuid);
        seasonedRestAPI.deleteEmployerLogo(employerGuid);
        employerPhotos = sqlSelect.getPhotosByEmployer(employerGuid);
        for (String guid : employerPhotos)
            seasonedRestAPI.deleteEmployerPhotos(employerGuid, guid);
        System.out.println("Starting employer registration test!");
    }

    @Test
    public void testEmployerSignUpByEmail() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickJoinBtn();

        /* Select registration type */
        hourlyRegistrationPage.clickHireExperience();

        /* Verify user directed to manager sign up page */
        Assert.assertEquals(employerRegistrationPage.getSignupMethodTitleTxt(), employerSignUpTitle);

        /* Choose sign up method - email */
        employerRegistrationPage.signupEmail();

        /* Register new user */
        Assert.assertEquals(employerRegistrationPage.getEmailSignupTitleTxt(), emailSignUpTitle);
        employerRegistrationPage.registerEmail(firstName, lastName, email, password);
        employerRegistrationPage.selectSignUpEmailNextBtn();

        /* Search for store location */
        Assert.assertEquals(employerRegistrationPage.getLocationTitleTxt(), locationTitle);
        employerRegistrationPage.setEmployerLocation(employerSearchTerm);

        /* Select a store location from the search results */
        Assert.assertEquals(employerRegistrationPage.getSearchResultEmployerTxt("0"), employerName + "\n" + employerLocation);
        employerRegistrationPage.selectEmployerByIndex("0");
        Assert.assertEquals(employerRegistrationPage.getSelectedEmployerNameTxt(), employerName);
        Assert.assertEquals(employerRegistrationPage.getSelectedEmployerLocationTxt(), employerLocation);
        employerRegistrationPage.selectSignUpLocationNextBtn();

        /* Select a store logo */
        Assert.assertEquals(employerRegistrationPage.getLogoTitleTxt(), logoTitle);
        employerRegistrationPage.setLogo(photoFilePath);
        employerRegistrationPage.selectSignUpLogoNextBtn();

        /* Select store photos */
        Assert.assertEquals(employerRegistrationPage.getPhotosTitleTxt(), photosTitle);
        employerRegistrationPage.selectPhotoByIndex("0");
        employerRegistrationPage.selectSignUpPhotosNextBtn();

        /* Select a store type */
        Assert.assertEquals(employerRegistrationPage.getStoreTypeTitleTxt(), storeTypeTitle);
        employerRegistrationPage.selectStoreTypeByIndex("5");
        employerRegistrationPage.selectSignUpStoreTypeFinishBtn();

        /* Verify manager lands on store profile view */
        Assert.assertEquals(employerProfileViewPage.getEmployerProfileCreatedTxt(), firstName + ", you're 5 minutes away from having the perfect store!");

        /* Verify employer name on store profile view */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), employerName);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Registration test");
        navPage.attemptLogout();
        driver.quit();
    }
}