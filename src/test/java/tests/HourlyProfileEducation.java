package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;
import utils.TestUtils;
import sql.SqlSelects;
import utils.BrowserFactory;

import java.sql.SQLException;
import java.util.List;

public class HourlyProfileEducation extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfileEducationPage hourlyProfileEducationPage;
    private HourlyProfileEditPage hourlyProfileEditPage;
    private SqlSelects sqlSelects;
    private SeasonedRestAPI api;

    private String username;
    private String password;
    private String emptyTxt;
    private String school;
    private String degree;
    private String duration;
    private String fromYear;
    private String toYear;
    private String index;
    private String userGuid;
    private String token;
    private List<String> educationGuids;

    @BeforeClass
    public void setUp() throws SQLException {
        System.out.println("Initializing hourly profile Education test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileEducationPage = new HourlyProfileEducationPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);
        sqlSelects = new SqlSelects();
        username = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("username");
        password = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("password");
        school = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("school");
        degree = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("degree");
        duration = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("duration");
        fromYear = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("fromYear");
        toYear = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("toYear");
        emptyTxt = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("emptyTxt");
        index = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("index");
        userGuid = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("userguid");
        token = (String) TestDataImporter.get("HourlyProfileEducation", "HourlyProfileEducation").get("token");
        educationGuids = sqlSelects.getUserEducationByGuid(userGuid);
        api = new SeasonedRestAPI(token);
        for (String guid : educationGuids)
            api.deleteEducationByGuid(userGuid, guid);
        System.out.println("Starting hourly profile Education test!");
    }

    @Test
    public void testAddEducation() {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile */
        navPage.navigateToProfilePage();
        Assert.assertEquals(hourlyProfileViewPage.getEducationEmptyTxt(), emptyTxt);

        /* Navigate to add education */
        hourlyProfileViewPage.clickAddEducation();

        /* Add a new education record */
        hourlyProfileEducationPage.setAddEducationSchoolTxt(school);
        hourlyProfileEducationPage.setAddEducationDegreeTxt(degree);
        hourlyProfileEducationPage.selectAddEducationYearFromDate(fromYear);
        hourlyProfileEducationPage.selectAddEducationYearToDate(toYear);
        hourlyProfileEducationPage.clickAddEducationSaveBtn();

        /* Go back and verify that the text shows on the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertEquals(hourlyProfileViewPage.getEducationSchoolTxtByIndex(index), school);
        Assert.assertEquals(hourlyProfileViewPage.getEducationDegreeTxtByIndex(index), degree);
        Assert.assertEquals(hourlyProfileViewPage.getEducationDurationTxtByIndex(index), duration);


        /* Go to edit education and verify the education record */
        hourlyProfileViewPage.clickEditProfile();
        hourlyProfileEditPage.clickSideMenuEducationLink();
        Assert.assertEquals(hourlyProfileEducationPage.getEducationSchoolTxtByIndex(index), school);
        Assert.assertEquals(hourlyProfileEducationPage.getEducationDegreeTxtByIndex(index), degree);
        Assert.assertEquals(hourlyProfileEducationPage.getEducationDurationTxtByIndex(index), duration);

        /* Remove education record */
        hourlyProfileEducationPage.deleteEducationByIndex(index);

        /* Go back to view profile and verify empty state */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertEquals(hourlyProfileViewPage.getEducationEmptyTxt(), emptyTxt);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the hourly profile education test");
        navPage.attemptLogout();
        driver.quit();
    }
}
