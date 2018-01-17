import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.sql.SQLException;

public class HourlyAutoProvision extends BaseTest {

    private HorariosCalientesPage horariosCalientesPage;
    private HourlyAutoprovisionSignupPage hourlyAutoprovisionSignupPage;
    private HourlyProfileViewPage hourlyProfileViewPage;

    private String loginUsername;
    private String loginPassword;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean termsAccepted;
    private String statusActive;
    private String statusTerminated;
    private String employeeUsername;
    private String employeePassword;
    private String processSQSQueueTask;
    private String autoRegisterUsersTask;
    private String token;
    private String supportUsername;
    private String supportPassword;
    private String employer;
    private String employeeId;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setup() throws SQLException, InterruptedException, NullPointerException {
        System.out.println("Initializing horarios calientes auto provision test...");
        horariosCalientesPage = new HorariosCalientesPage(driver);
        hourlyAutoprovisionSignupPage = new HourlyAutoprovisionSignupPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);

        loginUsername = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("loginUsername");
        loginPassword = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("loginPassword");
        firstName = TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("firstName") + testUtils.generateRandomUUID();
        lastName = TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("lastName") + testUtils.generateRandomUUID();
        termsAccepted = (Boolean) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("termsAccepted");
        statusActive = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("statusActive");
        statusTerminated = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("statusTerminated");
        processSQSQueueTask = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("ProcessSQSQueueTask");
        autoRegisterUsersTask = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("AutoRegisterUsersTask");
        employer = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("employer");
        token = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("token");
        email = testUtils.generateRandomUUID() + "@mailtothis.com";
        supportUsername = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("supportUsername");
        supportPassword = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("supportPassword");
        password = (String) TestDataImporter.get("HourlyAutoProvision", "testHSAutoProvision").get("password");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postRunTask(processSQSQueueTask);
        Thread.sleep(10000);
        seasonedRestAPI.postRunTask(autoRegisterUsersTask);
    }

    @Test(enabled = false)
    public void testHSAutoProvisionActiveEmployee() throws Exception {
        System.out.println("Starting active users horarios calientes test!");

        /* Start test on the be login page */
        testUtils.loadHorariosCalientesLogin();

        /* Log in */
        horariosCalientesPage.loginWithUsername(loginUsername, loginPassword);
        horariosCalientesPage.clickPendingTasksCancelBtn();

        /* Navigate to Staff tab and add new employee */
        horariosCalientesPage.clickStaffTab();
        horariosCalientesPage.clickAddEmployee();
        horariosCalientesPage.enterUserFirstName(firstName);
        horariosCalientesPage.enterUserLastName(lastName);
        employeeUsername = horariosCalientesPage.getUsername();
        employeePassword = horariosCalientesPage.getPassword();
        horariosCalientesPage.enterUserEmail(email);
        System.out.println("Email: " + email);
        horariosCalientesPage.clickAddEmployeeSaveBtn();
        Thread.sleep(1000);

        /* Get HS employeeId from support site */
        employeeId = horariosCalientesPage.getEmployeeId(supportUsername, supportPassword, employer, employeeUsername);

        /* Send HS user to SQS queue */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postSendUserToSqs(email, employeePassword, firstName, lastName, employeeId, termsAccepted, statusActive);

        /* Run ProcessSQSQueueTask */
        seasonedRestAPI.postRunTask(processSQSQueueTask);
        Assert.assertTrue(horariosCalientesPage.isHsUserInSqsQueue());

        /* Run AutoRegisterUsersTask */
        seasonedRestAPI.postRunTask(autoRegisterUsersTask);
        Assert.assertTrue(horariosCalientesPage.hasHsUserBeenProcessed(email));

        /* Verify the user has been created and the email has been sent */
        Assert.assertEquals(sqlSelect.getUserAccountState(email), "5");

        /* Open welcome email and register */
        testUtils.openHSAutoProvisionRegisterAction(email);

        /* Verify user lands on 1-time update email/password form */
        navPage.dismissRebrandingModal();
        System.out.println(driver.getCurrentUrl() + driver.getTitle());
        hourlyAutoprovisionSignupPage.registerEmail(password);
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), firstName + " " + lastName);
        navPage.attemptLogout();
    }

    @Test(enabled = false)
    public void testHSAutoProvisionTerminatedEmployee() throws Exception {
        System.out.println("Starting terminated users horarios calientes test!");

        /* Start test on the be login page */
        testUtils.loadHorariosCalientesLogin();

        /* Log in */
        horariosCalientesPage.loginWithUsername(loginUsername, loginPassword);
        horariosCalientesPage.clickPendingTasksCancelBtn();

        /* Navigate to Staff tab and add new employee */
        horariosCalientesPage.clickStaffTab();
        horariosCalientesPage.clickAddEmployee();
        horariosCalientesPage.enterUserFirstName(firstName);
        horariosCalientesPage.enterUserLastName(lastName);
        employeeUsername = horariosCalientesPage.getUsername();
        employeePassword = horariosCalientesPage.getPassword();
        horariosCalientesPage.enterUserEmail(email);
        System.out.println("Email: " + email);
        horariosCalientesPage.clickAddEmployeeSaveBtn();
        Thread.sleep(1000);

        /* Get HS employeeId from support site */
        employeeId = horariosCalientesPage.getEmployeeId(supportUsername, supportPassword, employer, employeeUsername);

        /* Send HS user to SQS queue */
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.postSendUserToSqs(email, employeePassword, firstName, lastName, employeeId, termsAccepted, statusTerminated);

        /* Run ProcessSQSQueueTask */
        seasonedRestAPI.postRunTask(processSQSQueueTask);
        Assert.assertTrue(horariosCalientesPage.isHsUserInSqsQueue());

        /* Run AutoRegisterUsersTask */
        seasonedRestAPI.postRunTask(autoRegisterUsersTask);
        Assert.assertTrue(horariosCalientesPage.hasHsUserBeenProcessed(email));

        /* Verify the user has been created and the email has been sent */
        Assert.assertEquals(sqlSelect.getUserAccountState(email), "5");

        /* Open welcome email and register */
        testUtils.openHSAutoProvisionRegisterAction(email);

        /* Verify user lands on 1-time update email/password form */
        navPage.dismissRebrandingModal();
        System.out.println(driver.getCurrentUrl() + driver.getTitle());
        hourlyAutoprovisionSignupPage.registerEmail(password);
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), firstName + " " + lastName);
        navPage.attemptLogout();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Shutting down selenium for the horarios calientes auto provision test");
        driver.quit();
    }
}
