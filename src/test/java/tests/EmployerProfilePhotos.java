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

public class EmployerProfilePhotos extends BaseTest {

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
    private String photoIndex;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() throws SQLException {
        System.out.println("Initializing Employer profile photos test...");

        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfilePhotosPage = new EmployerProfilePhotosPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        loginPage = new HourlyLoginPage(driver);

        email = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("email");
        password = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("password");
        photoName = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("photoName");
        employerGuid = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("employerGuid");
        photoFilePath = TestConfig.getWorkingDir() +  "/src/test/java/testData/"  + photoName;
        photoIndex = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("photoIndex");
        token = (String) TestDataImporter.get("EmployerProfilePhotos", "EmployerProfilePhotos").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        employerPhotos = sqlSelect.getPhotosByEmployer(employerGuid);
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
        Assert.assertFalse(employerProfileViewPage.isEmployerPhotoPresent(photoIndex), "Employer photo section should be empty");

        /* Navigate to edit photos page */
        employerProfileViewPage.selectManageStore();
        employerProfileEditPage.selectMenuPhotosLink();

        /* Verify employer photos empty state */
        Assert.assertFalse(employerProfilePhotosPage.isPhotoPresent(photoIndex), "Employer photos should be empty");

        /* Add a photo */
        employerProfilePhotosPage.addEmployerPhoto(photoFilePath);

        /* Verify photo upload success toast */
//        Below lines are commented out because we currently do not show a success toast after uploading a photo
//        Assert.assertTrue(employerProfilePhotosPage.verifyEmployerPhotosSuccessToast());
//        employerProfilePhotosPage.dismissEmployerPhotosSuccessToast();

        /* Verify photo added */
        Assert.assertTrue(employerProfilePhotosPage.isPhotoPresent(photoIndex), "Employer photo should be present");

        /* Navigate to store profile view page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify employer photo added to store profile */
        Assert.assertTrue(employerProfileViewPage.isEmployerPhotoPresent(photoIndex), "Employer photo should be present");

        /* Navigate to employer profile photos page */
        employerProfileViewPage.selectManageStore();
        employerProfileEditPage.selectMenuPhotosLink();

        /* Delete employer photo */
        employerProfilePhotosPage.deletePhotoByIndex(photoIndex);

        /* Verify delete photo success toast */
        Assert.assertTrue(employerProfilePhotosPage.verifyEmployerPhotosSuccessToast(), "Success toast should be displayed");
        employerProfilePhotosPage.dismissEmployerPhotosSuccessToast();

        /* Verify employer photos empty state */
        Assert.assertFalse(employerProfilePhotosPage.isPhotoPresent(photoIndex), "Employer photos should be empty");

        /* Navigate to store profile view page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify employer's photo empty state */
        Assert.assertFalse(employerProfileViewPage.isEmployerPhotoPresent(photoIndex), "Employer photo section should be empty");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the employer profile photos test");
        navPage.attemptLogout();
        driver.quit();
    }
}