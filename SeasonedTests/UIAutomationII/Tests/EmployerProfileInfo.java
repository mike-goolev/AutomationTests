import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class EmployerProfileInfo extends BaseTest {

    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;
    private EmployerProfileEditPage employerProfileEditPage;
    private EmployerProfileInfoPage employerProfileInfoPage;

    private String email;
    private String password;
    private String employerName;
    private String newEmployerName;
    private String employerAddress;
    private String newEmployerAddress;
    private String employerCity;
    private String newEmployerCity;
    private String employerState;
    private String newEmployerState;
    private String employerCardState;
    private String newEmployerCardState;
    private String employerZip;
    private String newEmployerZip;
    private String employerDistance;
    private String newEmployerDistance;
    private String employerCountry;
    private String employerPhone;
    private String newEmployerPhone;
    private String employerWebsite;
    private String newEmployerWebsite;
    private String employerCardWebsite;
    private String newEmployerCardWebsite;
    private String employerGuid;
    private Long employerId;
    private String employerDescription;
    private Long employerTypeId;
    private String employerTypeName;
    private String token;

    @BeforeMethod
    public void setUp() throws SQLException {
        System.out.println("Initializing Employer Profile Info test...");

        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        employerProfileInfoPage = new EmployerProfileInfoPage(driver);
        loginPage = new HourlyLoginPage(driver);

        email = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("email");
        password = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("password");
        employerName = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerName");
        newEmployerName = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerName");
        employerAddress = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerAddress");
        newEmployerAddress = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerAddress");
        employerCity = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerCity");
        newEmployerCity = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerCity");
        employerState = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerState");
        newEmployerState = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerState");
        employerCardState = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerCardState");
        newEmployerCardState = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerCardState");
        employerZip = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerZip");
        newEmployerZip = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerZip");
        employerCountry = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerCountry");
        employerDistance = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerDistance");
        newEmployerDistance = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerDistance");
        employerPhone = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerPhone");
        newEmployerPhone = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerPhone");
        employerWebsite = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerWebsite");
        newEmployerWebsite = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerWebsite");
        employerCardWebsite = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerCardWebsite");
        newEmployerCardWebsite = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("newEmployerCardWebsite");
        employerDescription = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerDescription");
        employerGuid = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerGuid");
        employerId = (Long) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerId");
        employerTypeId = (Long) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerTypeId");
        employerTypeName = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("employerTypeName");
        token = (String) TestDataImporter.get("EmployerProfileInfo", "EmployerProfileInfo").get("token");

        SeasonedRestAPI api = new SeasonedRestAPI(token);
        api.updateEmployerInfo(employerId, employerGuid, employerName, employerAddress, employerCity, employerCardState, employerZip, employerCountry, employerPhone, employerWebsite, employerDescription, employerTypeId, employerTypeName);
        System.out.println("Starting employer profile info test!");
    }

    @Test
    public void testEmployerProfileInfo() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify employer's name, address, city, state, zip, phone and website */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), employerName);
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderAddress(), employerAddress + ", " + employerCity + ", " + employerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardCity(), employerCity);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardAddress(), employerAddress + ", " + employerCity + ", " + employerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardDistance(), employerDistance);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardWebsite(), employerCardWebsite);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardPhone(), employerPhone);
        Assert.assertEquals(employerProfileViewPage.getAboutTitleTxt(), "About " + employerName);

        /* Navigate to edit employer info */
        employerProfileViewPage.selectEmployerInfoEditBtn();

        /* Verify the employer's initial name, address, city, state, zip, phone and website */
        Assert.assertTrue(employerProfileInfoPage.isEmployerInfoTooltipDisplayed());
        Assert.assertTrue(employerProfileInfoPage.isEmployerLogoDisplayed());
        Assert.assertEquals(employerProfileInfoPage.getEmployerName(), employerName);
        Assert.assertEquals(employerProfileInfoPage.getEmployerAddress(), employerAddress);
        Assert.assertEquals(employerProfileInfoPage.getEmployerCity(), employerCity);
        Assert.assertEquals(employerProfileInfoPage.getEmployerState(), employerState);
        Assert.assertEquals(employerProfileInfoPage.getEmployerZip(), employerZip);
        Assert.assertEquals(employerProfileInfoPage.getEmployerPhone(), employerPhone);
        Assert.assertEquals(employerProfileInfoPage.getEmployerWebsite(), employerWebsite);
        Assert.assertFalse(employerProfileInfoPage.isSaveButtonEnabled());

        /* Update the employer's name, address, city, state, zip, phone and website */
        employerProfileInfoPage.updateEmployerName(newEmployerName);
        employerProfileInfoPage.updateEmployerAddress(newEmployerAddress);
        employerProfileInfoPage.updateEmployerCity(newEmployerCity);
        employerProfileInfoPage.selectState("43");
        employerProfileInfoPage.updateEmployerZip(newEmployerZip);
        employerProfileInfoPage.updateEmployerPhone(newEmployerPhone);
        employerProfileInfoPage.updateEmployerWebsite(newEmployerWebsite);
        employerProfileInfoPage.clickSaveBtn();

        /* Verify success toast */
        employerProfileInfoPage.verifyEmployerInfoSuccessToast();
        employerProfileInfoPage.dismissEmployerInfoSuccessToast();

        /* Verify new name, address, city state, zip, phone and website after saving */
        Assert.assertEquals(employerProfileInfoPage.getEmployerName(), newEmployerName);
        Assert.assertEquals(employerProfileInfoPage.getEmployerAddress(), newEmployerAddress);
        Assert.assertEquals(employerProfileInfoPage.getEmployerCity(), newEmployerCity);
        Assert.assertEquals(employerProfileInfoPage.getEmployerState(), newEmployerState);
        Assert.assertEquals(employerProfileInfoPage.getEmployerZip(), newEmployerZip);
        Assert.assertEquals(employerProfileInfoPage.getEmployerPhone(), newEmployerPhone);
        Assert.assertEquals(employerProfileInfoPage.getEmployerWebsite(), newEmployerWebsite);
        //Bug: Save button is not disabled after saving
        //Assert.assertFalse(employerProfileInfoPage.isSaveButtonEnabled(), "Save button should be disabled after saving");

        /* Navigate to view profile page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify the new name, address, city, state, phone and website on the view profile page */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), newEmployerName);
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderAddress(), newEmployerAddress + ", " + newEmployerCity + ", " + newEmployerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardCity(), newEmployerCity);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardAddress(), newEmployerAddress + ", " + newEmployerCity + ", " + newEmployerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardDistance(), newEmployerDistance);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardWebsite(), newEmployerCardWebsite);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardPhone(), newEmployerPhone);
        Assert.assertEquals(employerProfileViewPage.getAboutTitleTxt(), "About " + newEmployerName);

        /* Navigate to edit employer info */
        employerProfileViewPage.selectEmployerInfoEditBtn();

        /* Set name, address, city, state, zip, phone and website to original state */
        employerProfileInfoPage.updateEmployerName(employerName);
        employerProfileInfoPage.updateEmployerAddress(employerAddress);
        employerProfileInfoPage.updateEmployerCity(employerCity);
        employerProfileInfoPage.selectState("38");
        employerProfileInfoPage.updateEmployerZip(employerZip);
        employerProfileInfoPage.updateEmployerPhone(employerPhone);
        employerProfileInfoPage.updateEmployerWebsite(employerWebsite);
        employerProfileInfoPage.clickSaveBtn();

         /* Verify success toast */
        employerProfileInfoPage.verifyEmployerInfoSuccessToast();
        employerProfileInfoPage.dismissEmployerInfoSuccessToast();

        /* Verify new name, address, city state, zip, phone and website after saving */
        Assert.assertEquals(employerProfileInfoPage.getEmployerName(), employerName);
        Assert.assertEquals(employerProfileInfoPage.getEmployerAddress(), employerAddress);
        Assert.assertEquals(employerProfileInfoPage.getEmployerCity(), employerCity);
        Assert.assertEquals(employerProfileInfoPage.getEmployerState(), employerState);
        Assert.assertEquals(employerProfileInfoPage.getEmployerZip(), employerZip);
        Assert.assertEquals(employerProfileInfoPage.getEmployerPhone(), employerPhone);
        Assert.assertEquals(employerProfileInfoPage.getEmployerWebsite(), employerWebsite);
        //Bug: Save button is not disabled after saving
        //Assert.assertFalse(employerProfileInfoPage.isSaveButtonEnabled());

        /* Navigate to view profile page */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify the new name, address, city, state, zip, phone and website on the view profile page */
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderName(), employerName);
        Assert.assertEquals(employerProfileViewPage.getEmployerHeaderAddress(), employerAddress + ", " + employerCity + ", " + employerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardCity(), employerCity);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardAddress(), employerAddress + ", " + employerCity + ", " + employerCardState);
        //Assert.assertEquals(employerProfileViewPage.getEmployerCardDistance(), employerDistance);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardWebsite(), employerCardWebsite);
        Assert.assertEquals(employerProfileViewPage.getEmployerCardPhone(), employerPhone);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the Employer Profile Info test");
        navPage.attemptLogout();
        driver.quit();
    }
}