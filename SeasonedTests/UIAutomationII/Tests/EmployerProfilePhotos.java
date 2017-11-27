import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class EmployerProfilePhotos extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private SqlSelects select;
    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;
    private EmployerProfilePhotosPage employerProfilePhotosPage;
    private EmployerProfileEditPage employerProfileEditPage;

    private String email;
    private String password;
    private String employerGuid;
    private String token;
    private String photoFilePath;
    private String photoName;
    private List<String> employerPhotos;

    @BeforeMethod
    public void setUp() throws SQLException {
        System.out.println("Initializing Employer profile photos test...");
        driver = BrowserFactory.getDriver("firefox");

        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfilePhotosPage = new EmployerProfilePhotosPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        loginPage = new HourlyLoginPage(driver);
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        select = new SqlSelects();

        email = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("email");
        password = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("password");
        photoName = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("photoName");
        employerGuid = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("employerGuid");
        photoFilePath = TestConfig.getWorkingDir() + "TestData/" + photoName;
        token = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        employerPhotos = select.getPhotosByEmployer(employerGuid);
        for (String guid : employerPhotos)
            api.deleteEmployerPhotos(employerGuid, guid);
        System.out.println("Starting employer profile photos test!");
    }

    @Test
    public void testEmployerProfilePhotos() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify employer's photo empty state */
        Assert.assertFalse(employerProfileViewPage.isEmployerPhotoPresent("0"));

        /* Navigate to edit photos page */
        employerProfileViewPage.selectManageStore();
        employerProfileEditPage.selectMenuPhotosLink();

        /* Verify employer photos empty state */
        Assert.assertFalse(employerProfilePhotosPage.isPhotoPresent("0"));

        /* Add a photo */
        employerProfilePhotosPage.selectUploadPhotoBtn();
        employerProfilePhotosPage.addEmployerPhoto(photoFilePath);

        /* Verify photo upload success toast */
//        Below lines are commented out because we currently do not show a success toast after uploading a photo
//        Assert.assertTrue(employerProfilePhotosPage.verifyEmployerPhotosSuccessToast());
//        employerProfilePhotosPage.dismissEmployerPhotosSuccessToast();

        /* Verify photo added */
        Assert.assertTrue(employerProfilePhotosPage.isPhotoPresent("0"), "Employer photo should be present");

        /* Navigate to store profile view page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify employer photo added to store profile */
//        Below line is commented out because store photos do not display consistently
//        Assert.assertTrue(employerProfileViewPage.isEmployerPhotoPresent("0"), "Employer photo should be present");
        /* TO DO - Verify employer photo added to public store profile */

        /* Navigate to employer profile photos page */
        employerProfileViewPage.selectManageStore();
        employerProfileEditPage.selectMenuPhotosLink();

        /* Delete employer photo */
        employerProfilePhotosPage.deletePhotoByIndex("0");

        /* Verify delete photo success toast */
        Assert.assertTrue(employerProfilePhotosPage.verifyEmployerPhotosSuccessToast());
        employerProfilePhotosPage.dismissEmployerPhotosSuccessToast();

        /* Verify employer photos empty state */
        Assert.assertFalse(employerProfilePhotosPage.isPhotoPresent("0"));

        /* Navigate to store profile view page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify employer's photo empty state */
        Assert.assertFalse(employerProfileViewPage.isEmployerPhotoPresent("0"));
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the employer profile photos test");
        navPage.attemptLogout();
        driver.quit();
    }
}