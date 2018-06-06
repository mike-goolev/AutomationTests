package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AttributionPage;
import pages.HourlyLoginPage;
import pages.HourlyRegistrationPage;
import pages.MessagesPage;
import sql.SqlSelects;
import utils.TestDataImporter;

public class HourlyAttribution extends BaseTest {

    private HourlyLoginPage loginPage;
    private HourlyRegistrationPage hourlyRegistrationPage;
    private AttributionPage attributionPage;

    private String userLocation;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        attributionPage = new AttributionPage(driver);
        loginPage = new HourlyLoginPage(driver);
        hourlyRegistrationPage = new HourlyRegistrationPage(driver);
        userLocation = (String) TestDataImporter.get("HourlyAttribution", "HourlyAttribution").get("userLocation");
        firstName = ("ssHourlyFirst" + testUtils.generateRandomUUID());
        lastName = ("ssHourlyLast" + testUtils.generateRandomUUID());
        email = (testUtils.generateRandomUUID() + "@mailinator.com");
        password = (String) TestDataImporter.get("HourlyAttribution", "HourlyAttribution").get("password");
        System.out.println("Credentials used: " + firstName + ", " + lastName + ", " + email);
    }

    @Test
    public void testAttributionSelected() throws Exception {

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

        /* Sign up by email and select attribution option */
        hourlyRegistrationPage.registerEmail(firstName, lastName, email, password, "0");

        //verify selected attribution is saved in posgres Db
        SqlSelects sqlNew = new SqlSelects();
        String attribution = sqlNew.getUserAttributionValueByEmail(email);
        Assert.assertEquals(attribution, (String) TestDataImporter.get("HourlyAttribution", "HourlyAttribution").get("attribution"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the messages test");
        navPage.attemptLogout();
        driver.quit();
    }

    }
