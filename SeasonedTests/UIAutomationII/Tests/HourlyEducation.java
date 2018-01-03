import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyEducation extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfileEditPage hourlyProfileEditPage;
    private HourlyProfileEducationPage educationPage;

    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly education test...");
        driver = new BrowserFactory().getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);
        educationPage = new HourlyProfileEducationPage(driver);

        username = (String) TestDataImporter.get("HourlyEducation", "HourlyEducation").get("username");
        password = (String) TestDataImporter.get("HourlyEducation", "HourlyEducation").get("password");
    }

    @Test
    public void testHourlyEducation() {
        /* Start the test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Navigate to the education page */
        hourlyProfileViewPage.clickAddEducationButton();

        /* Add a school, degree, from year and to year for education */
        educationPage.enterSchoolTxt("Texas");
        educationPage.enterDegreeTxt("Badassery");
        educationPage.selectFromYear("2010");
        educationPage.selectToYear("2014");
        educationPage.clickSaveBtn();

        /* Assert that the green banner displays */
        Assert.assertTrue(educationPage.verifyEducationSuccessBanner(), "Success banner should be displayed.");
        educationPage.clickCloseSuccessBannerBtn();

        /* Navigate to the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify that the education shows on the view profile page */
        Assert.assertTrue(hourlyProfileViewPage.verifyProfileEducationSchoolAtIndex("0"));
        Assert.assertTrue(hourlyProfileViewPage.verifyProfileEducationDegreeAtIndex("0"));
        Assert.assertTrue(hourlyProfileViewPage.verifyProfileEducationYearsAtIndex("0"));

        /* Navigate back to the edit education page */
        hourlyProfileViewPage.clickEditEducationButton();
        educationPage.clickEditEducationBtn("0");

        /* Delete the education */
        educationPage.clickDeleteBtn();
        educationPage.clickDeleteModalDeleteBtn();

        /* Assert that the green banner displays */
        Assert.assertTrue(educationPage.verifyEditEducationSuccessBanner(), "Success banner should be displayed.");
        educationPage.clickCloseEditSuccessBannerBtn();

        /* Navigate back to the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify that the education is no longer displayed */
        Assert.assertFalse(hourlyProfileViewPage.verifyProfileEducationSchoolAtIndex("0"));
        Assert.assertFalse(hourlyProfileViewPage.verifyProfileEducationDegreeAtIndex("0"));
        Assert.assertFalse(hourlyProfileViewPage.verifyProfileEducationYearsAtIndex("0"));
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly profile education test");
        navPage.attemptLogout();
        driver.quit();
    }
}
