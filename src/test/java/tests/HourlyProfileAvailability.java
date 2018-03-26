package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;

public class HourlyProfileAvailability extends BaseTest {


    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfileAvailabilityPage hourlyProfileAvailabilityPage;
    private HourlyProfileEditPage hourlyProfileEditPage;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String empInterestStatus;
    private String empInterestType;
    private String gigInterestStatus;
    private String id;
    private String userGuid;
    private String token;
    private String availabilityTitleTooltip;
    private String availabilityTxtTooltip;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        System.out.println("Initializing hourly profile Availability test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileAvailabilityPage = new HourlyProfileAvailabilityPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);
        username = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("username");
        password = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("password");
        firstname = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("firstname");
        lastname = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("lastname");
        empInterestStatus = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("empintereststatus");
        empInterestType = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("empinteresttype");
        gigInterestStatus = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("gigintereststatus");
        id = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("userid");
        userGuid = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("userguid");
        token = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("token");
        availabilityTitleTooltip = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("availabilityTitleTooltip");
        availabilityTxtTooltip = (String) TestDataImporter.get("HourlyProfileAvailability", "HourlyProfileAvailability").get("availabilityTxtTooltip");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.clearAvailabilityForUser(userGuid);
        seasonedRestAPI.setAvailabilityStatus(id, userGuid, firstname, lastname, username, empInterestStatus, empInterestType, gigInterestStatus);
        System.out.println("Starting hourly profile Availability Test!");
    }

    @Test
    public void testHourlyProfileAvailability() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Click the login button from the nav header and login */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the Availability page */
        navPage.navigateToProfilePage();

        /* Verify availability empty state */
        Assert.assertTrue(hourlyProfileViewPage.isAvailabilityHeaderDisplayed());

        /* Navigate to the Availability page */
        hourlyProfileViewPage.clickAddAvailability();

        /* Verify the work availability tooltip is displayed*/
        Assert.assertTrue(hourlyProfileAvailabilityPage.isAvailabilityTooltipDisplayed(), "Work availability tooltip should be displayed");

        /* Verify the work availability title tooltip */
        Assert.assertEquals(hourlyProfileAvailabilityPage.getAvailabilityTitleTooltip(), availabilityTitleTooltip);

        /* Verify the work availability title tooltip */
        Assert.assertEquals(hourlyProfileAvailabilityPage.getAvailabilityTxtTooltip(), availabilityTxtTooltip);

        /* Verify that no availability has been selected, then select all availability and save. A success toast should appear. */
        Assert.assertTrue(hourlyProfileAvailabilityPage.noAvailabilitySelected(), "The user should have no availability selected");
        hourlyProfileAvailabilityPage.clickAllAvailabilityBoxes();
        //hourlyProfileAvailabilityPage.clickGigsCheckbox();
        hourlyProfileAvailabilityPage.selectAvailabilityStatus("LOOKING");
        hourlyProfileAvailabilityPage.clickAvailabilityTypeFullTime();
        hourlyProfileAvailabilityPage.clickSaveButton();
        Assert.assertTrue(hourlyProfileAvailabilityPage.verifyAvailabilitySuccessBanner(), "The profile saved successfully toast is displayed");
        hourlyProfileAvailabilityPage.clickCloseAvailabilityBannerBtn();

        /* Verify that the availability is persisted on the view profile screen */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertTrue(hourlyProfileViewPage.verifyAllAvailabilitySelected(), "All availability should be selected on the view profile page");
        Assert.assertTrue(hourlyProfileViewPage.verifyAvailabilityInterestStatusTxt("I'm looking for a job"), "The interest status text should say: I'm looking for a job");
        Assert.assertTrue(hourlyProfileViewPage.verifyAvailabilityInterestTypeTxt("full-time"),"The interest type text should say: full-time");

        /* Go back to the profile page */
        hourlyProfileViewPage.clickEditAvailability();

        /* Verify that all availability cards are selected then un-select all availability */
        Assert.assertTrue(hourlyProfileAvailabilityPage.allAvailabilitySelected(), "All availability has been been selected");
        hourlyProfileAvailabilityPage.clickAllAvailabilityBoxes();
        hourlyProfileAvailabilityPage.selectAvailabilityStatus("OPEN");
        hourlyProfileAvailabilityPage.clickAvailabilityTypeAnything();
        hourlyProfileAvailabilityPage.clickSaveButton();

        /* Verify that a success toast appears and that all availability has been removed */
        Assert.assertTrue(hourlyProfileAvailabilityPage.verifyAvailabilitySuccessBanner(), "The profile saved successfully toast is displayed");
        hourlyProfileAvailabilityPage.clickCloseAvailabilityBannerBtn();
        Assert.assertTrue(hourlyProfileAvailabilityPage.noAvailabilitySelected(), "No availability is selected");

        /* Verify that the availability card is in an empty state on the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertFalse(hourlyProfileViewPage.verifyAllAvailabilitySelected(), "No availability should be on the view profile page");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting selenium down for Availability test.");
        navPage.attemptLogout();
        driver.quit();
    }
}
