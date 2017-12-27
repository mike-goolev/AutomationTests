import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployerProfileStaff extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage loginPage;
    private EmployerProfileViewPage employerProfileViewPage;
    private EmployerProfileStaffPage employerProfileStaffPage;
    private EmployerProfileEditPage employerProfileEditPage;
    private SqlSelects sqlSelect;

    private String email;
    private String password;
    private String employerGuid;
    private String staffIndex;
    private String staffName;
    private String staffLabel;
    private String staffDescription;
    private String staffAddedDate;
    private String token;
    private List<String> staffGuids;

    @BeforeMethod
    public void setUp() throws SQLException {
        System.out.println("Initializing employer profile Staff test...");
        driver = BrowserFactory.getDriver("firefox");

        testUtils = new TestUtils(driver);
        employerProfileViewPage = new EmployerProfileViewPage(driver);
        employerProfileStaffPage = new EmployerProfileStaffPage(driver);
        employerProfileEditPage = new EmployerProfileEditPage(driver);
        loginPage = new HourlyLoginPage(driver);
        navPage = new NavPage(driver);
        sqlSelect = new SqlSelects();

        email = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("email");
        password = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("password");
        employerGuid = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("employerGuid");
        staffIndex = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("staffIndex");
        staffName = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("staffName");
        staffLabel = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("staffLabel");
        staffDescription = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("staffDescription");
        staffAddedDate = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("staffAddedDate");
        token = (String) TestDataImporter.get("EmployerProfileStaff", "EmployerProfileStaff").get("token");
        SeasonedRestAPI api = new SeasonedRestAPI(token);
        sqlSelect = new SqlSelects();
        staffGuids = sqlSelect.getEmployerStaffMembers(employerGuid);
        for (String guid : staffGuids)
            api.deleteStaffMember(employerGuid, guid);

        System.out.println("Starting employer profile Staff test!");
    }

    @Test
    public void testEmployerProfileStaff() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(email, password);

        /* Navigate to store profile page */
        navPage.switchToEmployerView();
        navPage.navigateToStoreProfilePage();

        /* Verify staff section is not displayed */
        Assert.assertFalse(employerProfileViewPage.isManagementHeaderDisplayed());

        /* Navigate to edit staff page */
        employerProfileViewPage.selectEmployerInfoEditBtn();
        employerProfileEditPage.selectMenuManagementLink();

        /* Add new staff member */
        employerProfileStaffPage.addStaffMember(staffName, staffIndex, 1);

        /* Verify staff member added to edit list */
        Assert.assertTrue(employerProfileStaffPage.isStaffMemberAvatarDisplayed(staffIndex));
        Assert.assertEquals(employerProfileStaffPage.getStaffMemberName(staffIndex), staffName);
        Assert.assertEquals(employerProfileStaffPage.getStaffMemberAddedDate(staffIndex), staffAddedDate);
        Assert.assertTrue(employerProfileStaffPage.isEmployerStaffTooltipDisplayed());

        /* Add a description for the staff member */
        employerProfileStaffPage.selectStaffMemberEditButton(staffIndex);
        employerProfileStaffPage.addStaffMemberDescription(staffDescription);
        employerProfileStaffPage.selectEditStaffMemberSaveButton();
        Assert.assertTrue(employerProfileStaffPage.verifyStaffMemberSuccessToast());
        employerProfileStaffPage.dismissStaffMemberSuccessToast();

        /* Navigate to store profile */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify staff member on store profile */
        Assert.assertTrue(employerProfileViewPage.isManagementHeaderDisplayed());
        Assert.assertEquals(employerProfileViewPage.getManagerName(staffIndex), staffName);
        Assert.assertEquals(employerProfileViewPage.getManagerLabel(staffIndex), staffLabel);
        Assert.assertEquals(employerProfileViewPage.getManagerDescription(staffIndex), staffDescription);

        /* Navigate to edit staff page */
        employerProfileViewPage.selectEmployerInfoEditBtn();
        employerProfileEditPage.selectMenuManagementLink();

        /* Uncheck the display on profile option */
        employerProfileStaffPage.selectStaffMemberEditButton(staffIndex);
        employerProfileStaffPage.setStaffMemberProfileVisibility();
        employerProfileStaffPage.selectEditStaffMemberSaveButton();
        Assert.assertTrue(employerProfileStaffPage.verifyStaffMemberSuccessToast());
        employerProfileStaffPage.dismissStaffMemberSuccessToast();

        /* Navigate to store profile */
        employerProfileEditPage.selectMenuViewProfileLink();

        /* Verify staff member on store profile */
        Assert.assertFalse(employerProfileViewPage.isManagementHeaderDisplayed());

        /* Navigate to edit staff page */
        employerProfileViewPage.selectEmployerInfoEditBtn();
        employerProfileEditPage.selectMenuManagementLink();

        /* Remove staff member */
        employerProfileStaffPage.selectStaffMemberEditButton(staffIndex);
        employerProfileStaffPage.deleteStaffMember();
        Assert.assertTrue(employerProfileStaffPage.verifyStaffMemberSuccessToast());
        employerProfileStaffPage.dismissStaffMemberSuccessToast();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the Employer Profile Staff test");
        navPage.attemptLogout();
        driver.quit();
    }
}
