import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyProfileSkills extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    HourlyLoginPage hourlyLoginPage;
    HourlyProfileViewPage hourlyProfileViewPage;
    HourlyProfileSkillsPage hourlyProfileSkillsPage;
    HourlyProfileEditPage hourlyProfileEditPage;

    String username;
    String password;
    String firstname;
    String lastname;
    String guid;
    String id;
    String token;
    String skill1;
    String skill2;
    String skill3;
    String skill4;
    String skill5;
    String skillsTitleTooltip;
    String skillsTxtTooltip;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly skills test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileSkillsPage = new HourlyProfileSkillsPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);

        username = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("username");
        password = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("password");
        firstname = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("firstname");
        lastname = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("lastname");
        guid = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("guid");
        id = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("id");
        token = (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("token");
        skill1= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skill1");
        skill2= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skill2");
        skill3= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skill3");
        skill4= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skill4");
        skill5= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skill5");
        skillsTitleTooltip= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skillsTitleTooltip");
        skillsTxtTooltip= (String) TestDataImporter.get("HourlyProfileSkills", "HourlyProfileSkills").get("skillsTxtTooltip");
        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.clearUserSkills(id, guid, firstname, lastname, username);
        System.out.println("Starting hourly skills test!");
    }

    @Test
    public void testSkills() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile (view) */
        navPage.navigateToProfilePage();

        /* Verify skills section empty */
        Assert.assertTrue(hourlyProfileViewPage.isSkillsHeaderDisplayed(), "Skills header should be displayed");

        /* Navigate to the edit skills page */
        hourlyProfileViewPage.clickAddSkills();

        /* Verify save button initializes in a disabled state */
        Assert.assertFalse(hourlyProfileSkillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection is made");

        /* Select skills */
        hourlyProfileSkillsPage.toggleSkill("12");
        hourlyProfileSkillsPage.toggleSkill("18");
        hourlyProfileSkillsPage.toggleSkill("19");
        hourlyProfileSkillsPage.toggleSkill("23");
        hourlyProfileSkillsPage.toggleSkill("25");

        /* Verify save button is enabled after selecting skills */
        Assert.assertTrue(hourlyProfileSkillsPage.isSaveButtonEnabled(), "Save button should be enabled after a selection is made");

        /* Save skills */
        hourlyProfileSkillsPage.clickSaveBtn();

        /* Verify and dismiss success toast */
        Assert.assertTrue(hourlyProfileSkillsPage.verifySkillsSuccessToast());
        hourlyProfileSkillsPage.dismissSkillsSuccessToast();

        /* Verify save button is disabled after saving */
        Assert.assertFalse(hourlyProfileSkillsPage.isSaveButtonEnabled());

        /* Verify selected skills */
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillTxt("0"), skill1);
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillTxt("1"), skill2);
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillTxt("2"), skill3);
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillTxt("3"), skill4);
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillTxt("4"), skill5);

        /* Verify a 6th skill cannot be added */
        hourlyProfileSkillsPage.toggleSkill("10");
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("10"), "User should not be able to add more than 5 skills");

        /* Navigate to profile (view) */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify selected skills in the summary section */
        Assert.assertEquals(hourlyProfileViewPage.getSummarySkills(), "My top skills are " + skill1 + ", " + skill2 + ", " + skill3 + ", " + skill4 + " and " + skill5 + ".");

        /* Verify selected skills displayed in Skills section */
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("0"), skill1);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("1"), skill2);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("2"), skill3);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("3"), skill4);
        Assert.assertEquals(hourlyProfileViewPage.getSelectedSkill("4"), skill5);

        /* Navigate to the edit skills page */
        hourlyProfileViewPage.clickEditSkills();

        /* Verify the skills tooltip is displayed*/
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillsTooltipDisplayed(), "Skills tooltip should be displayed");

        /* Verify the skills title tooltip is displayed*/
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillsTitleTooltip(), skillsTitleTooltip);

        /* Verify the skills text tooltip is displayed*/
        Assert.assertEquals(hourlyProfileSkillsPage.getSkillsTxtTooltip(), skillsTxtTooltip);

        /* Verify selected skills are toggled on */
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillSelected("0"), "Skill at index 0 should be selected");
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillSelected("1"), "Skill at index 1 should be selected");
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillSelected("2"), "Skill at index 2 should be selected");
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillSelected("3"), "Skill at index 3 should be selected");
        Assert.assertTrue(hourlyProfileSkillsPage.isSkillSelected("4"), "Skill at index 4 should be selected");

        /* Verify save button initializes in a disabled state */
        Assert.assertFalse(hourlyProfileSkillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection is made");

        /* Deselect skills */
        hourlyProfileSkillsPage.toggleSkill("0");
        hourlyProfileSkillsPage.toggleSkill("1");
        hourlyProfileSkillsPage.toggleSkill("2");
        hourlyProfileSkillsPage.toggleSkill("3");
        hourlyProfileSkillsPage.toggleSkill("4");

        /* Verify save button is enabled after deselecting skills */
        Assert.assertTrue(hourlyProfileSkillsPage.isSaveButtonEnabled(), "Save button should be enabled after a selection is made");

        /* Save skills */
        hourlyProfileSkillsPage.clickSaveBtn();

        /* Verify and dismiss success toast */
        Assert.assertTrue(hourlyProfileSkillsPage.verifySkillsSuccessToast());
        hourlyProfileSkillsPage.dismissSkillsSuccessToast();

        /* Verify save button is disabled after saving */
        Assert.assertFalse(hourlyProfileSkillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection has been made");

        /* Verify skills are toggled off */
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("0"), "Skill at index 25 should be deselected");
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("1"), "Skill at index 26 should be deselected");
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("2"), "Skill at index 27 should be deselected");
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("3"), "Skill at index 28 should be deselected");
        Assert.assertFalse(hourlyProfileSkillsPage.isSkillSelected("4"), "Skill at index 29 should be deselected");

        /* Navigate to profile (view) */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();

        /* Verify skills section empty */
        Assert.assertTrue(hourlyProfileViewPage.isSkillsHeaderDisplayed(),"Skills section & header should be displayed when the user has no skills added");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        screenshot = new Screenshot(driver);
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the skills test");
        navPage.attemptLogout();
        driver.quit();
    }
}
