import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.List;
import java.sql.SQLException;


public class EmployerRegistration extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyRegistrationPage hourlyRegistrationPage;
    private EmployerRegistrationPage employerRegistrationPage;
    private SqlSelects sqlSelect;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String employerSignUpTitle;
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

    @BeforeMethod
    public void setUp() throws SQLException {
        System.out.println("Initializing Employer Registration test...");
        driver = BrowserFactory.getDriver("firefox");
        employerRegistrationPage = new EmployerRegistrationPage(driver);
        hourlyRegistrationPage = new HourlyRegistrationPage(driver);
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        sqlSelect = new SqlSelects();

        firstName = ("ssAdminFirst" + testUtils.generateRandomUUID());
        lastName = ("ssAdminLast" + testUtils.generateRandomUUID());
        email = ("mgr" + testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("password");
        employerSignUpTitle = (String) TestDataImporter.get("EmployerRegistration", "testEmployerSignUpByEmail").get("employerSignUpTitle");
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
        photoFilePath = TestConfig.getWorkingDir() + "/" + photoName;
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.unclaimEmployer(employerGuid);
        seasonedRestAPI.deleteEmployerLogo(employerGuid);
        employerPhotos = sqlSelect.getPhotosByEmployer(employerGuid);
        for (String guid : employerPhotos)
            seasonedRestAPI.deleteEmployerPhotos(employerGuid, guid);
        System.out.println("Starting employer registration test!");
    }

    @Test
    public void testEmployerSignUpByEmail() throws Exception {
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
        employerRegistrationPage.getEmailSignupTitleTxt();
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

        /* Verify store creation modal */
        employerRegistrationPage.selectStoreCreatedViewProfileButton();

        /* TO DO - Verify employer name on store profile view */

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Registration test");
        navPage.attemptLogout();
        driver.quit();
    }
}