import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.SQLException;


public class EmployerProfileAbout extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;
    private EmployerProfileAboutPage employerProfileAboutPage;
    private EmployerProfileEditPage employerProfileEditPage;


    private String email;
    private String password;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerCardState;
    private String employerZip;
    private String employerCountry;
    private String employerPhone;
    private String employerWebsite;
    private String employerGuid;
    private Long employerId;
    private Long employerTypeId;
    private String employerTypeName;
    private String employerDescription;
    private String newEmployerDescription;
    private String token;

    @BeforeMethod
    public void setUp() throws SQLException {
        System.out.println("Initializing employer profile About test...");
        driver = BrowserFactory.getDriver("firefox");

        testUtils = new TestUtils(driver);
        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfileAboutPage = new EmployerProfileAboutPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        loginPage = new HourlyLoginPage(driver);
        navPage = new NavPage(driver);


        email = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("email");
        password = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("password");
        employerName = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerName");
        employerAddress = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerAddress");
        employerCity = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerCity");
        employerCardState = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerCardState");
        employerZip = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerZip");
        employerCountry = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerCountry");
        employerPhone = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerPhone");
        employerWebsite = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerWebsite");
        employerDescription = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerDescription");
        newEmployerDescription = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("newEmployerDescription");
        employerGuid = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerGuid");
        employerId = (Long) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerId");
        employerTypeId = (Long) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerTypeId");
        employerTypeName = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("employerTypeName");
        token = (String) TestDataImporter.get("EmployerProfileAbout", "EmployerProfileAbout").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.updateEmployerInfo(employerId, employerGuid, employerName, employerAddress, employerCity, employerCardState, employerZip, employerCountry, employerPhone, employerWebsite, employerDescription, employerTypeId, employerTypeName);
        System.out.println("Starting employer profile About test!");
    }

    @Test
    public void testEmployerProfileAbout() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify employer's About description */
        Assert.assertTrue(employerProfileViewPage.isAboutHeaderDisplayed(), "About header should be displayed");
        Assert.assertEquals(employerProfileViewPage.getAboutTxt(), employerDescription);

        /* Navigate to edit employer about */
        employerProfileViewPage.selectEditAboutBtn();

        /* Verify employer description */
        Assert.assertFalse(employerProfileAboutPage.isSaveButtonEnabled(), "Save button should be disabled until description updated");
        Assert.assertEquals(employerProfileAboutPage.getAboutTxt(), employerDescription);

        /* Update employer description */
        employerProfileAboutPage.updateAboutDescription(newEmployerDescription);
        employerProfileAboutPage.selectSaveBtn();

        /* Verify success toast */
        Assert.assertTrue(employerProfileAboutPage.verifyEmployerAboutSuccessToast(), "Success toast should display");
        employerProfileAboutPage.dismissEmployerAboutSuccessToast();
        Assert.assertFalse(employerProfileAboutPage.isSaveButtonEnabled(), "Save button should be disabled after description updated");

        /* Navigate to view profile page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify updated about description on profile view page */
        Assert.assertEquals(employerProfileViewPage.getAboutTxt(), newEmployerDescription);

        /* Navigate to edit employer about */
        employerProfileViewPage.selectEditAboutBtn();

        /* Update employer description */
        employerProfileAboutPage.updateAboutDescription(employerDescription);
        employerProfileAboutPage.selectSaveBtn();

        /* Verify success toast */
        Assert.assertTrue(employerProfileAboutPage.verifyEmployerAboutSuccessToast(), "Success toast should display");
        employerProfileAboutPage.dismissEmployerAboutSuccessToast();
        Assert.assertFalse(employerProfileAboutPage.isSaveButtonEnabled(), "Save button should be disabled after description updated");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Profile About test");
        navPage.attemptLogout();
        driver.quit();
    }


}
