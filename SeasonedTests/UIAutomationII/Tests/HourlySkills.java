import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlySkills extends BaseTest {

    TestUtils testUtils;
    NavPage navPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    SkillsPage skillsPage;
    EditProfilePage editProfilePage;

    String username;
    String password;
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
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        skillsPage = new SkillsPage(driver);
        editProfilePage = new EditProfilePage(driver);

        username = (String) TestDataImporter.get("HourlySkills", "testSkills").get("username");
        password = (String) TestDataImporter.get("HourlySkills", "testSkills").get("password");
        skill1= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skill1");
        skill2= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skill2");
        skill3= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skill3");
        skill4= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skill4");
        skill5= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skill5");
        skillsTitleTooltip= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skillsTitleTooltip");
        skillsTxtTooltip= (String) TestDataImporter.get("HourlySkills", "testSkills").get("skillsTxtTooltip");
        System.out.println("Starting test run!");
    }

    @Test
    public void testSkills() throws Exception {
        /* Start test on the content feed */
        testUtils.loadJobSearchPageNoTerms();
        navPage.dismissRebrandingModal();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile (view) */
        navPage.navigateToProfilePage();

        /* Verify skills section empty */
        Assert.assertTrue(profilePage.isSkillsHeaderDisplayed(), "Skills section & header should be displayed when the user has no skills added");

        /* Navigate to the edit profile page */
        profilePage.clickEditProfile();

        /* Navigate to the edit skills page */
        editProfilePage.clickSideMenuSkillsLink();

        /* Verify save button initializes in a disabled state */
        Assert.assertFalse(skillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection is made");

        /* Select skills */
        skillsPage.toggleSkill("12");
        skillsPage.toggleSkill("18");
        skillsPage.toggleSkill("19");
        skillsPage.toggleSkill("23");
        skillsPage.toggleSkill("25");

        /* Verify save button is enabled after selecting skills */
        Assert.assertTrue(skillsPage.isSaveButtonEnabled(), "Save button should be enabled after a selection is made");

        /* Save skills */
        skillsPage.clickSaveBtn();

        /* Verify and dismiss success toast */
        Assert.assertTrue(skillsPage.verifySkillsSuccessToast());
        skillsPage.dismissSkillsSuccessToast();

        /* Verify save button is disabled after saving */
        Assert.assertFalse(skillsPage.isSaveButtonEnabled());

        /* Verify selected skills */
        Assert.assertEquals(skillsPage.getSkillTxt("0"), skill1);
        Assert.assertEquals(skillsPage.getSkillTxt("1"), skill2);
        Assert.assertEquals(skillsPage.getSkillTxt("2"), skill3);
        Assert.assertEquals(skillsPage.getSkillTxt("3"), skill4);
        Assert.assertEquals(skillsPage.getSkillTxt("4"), skill5);

        /* Verify a 6th skill cannot be added */
        skillsPage.toggleSkill("10");
        Assert.assertFalse(skillsPage.isSkillSelected("10"), "User should not be able to add more than 5 skills");

        /* Navigate to profile (view) */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify selected skills in the summary section */
        Assert.assertEquals(profilePage.getSummarySkills(), "My top skill are " + skill1 + ", " + skill2 + ", " + skill3 + ", " + skill4 + " and " + skill5 + ".");

        /* Verify selected skills displayed in Skills section */
        Assert.assertEquals(profilePage.getSelectedSkill("0"), skill1);
        Assert.assertEquals(profilePage.getSelectedSkill("1"), skill2);
        Assert.assertEquals(profilePage.getSelectedSkill("2"), skill3);
        Assert.assertEquals(profilePage.getSelectedSkill("3"), skill4);
        Assert.assertEquals(profilePage.getSelectedSkill("4"), skill5);

        /* Navigate to the edit profile page */
        profilePage.clickEditProfile();

        /* Navigate to the edit skills page */
        editProfilePage.clickSideMenuSkillsLink();

        /* Verify the skills tooltip is displayed*/
        Assert.assertTrue(skillsPage.isSkillsTooltipDisplayed(), "Skills tooltip should be displayed");

        /* Verify the skills title tooltip is displayed*/
        Assert.assertEquals(skillsPage.getSkillsTitleTooltip(), skillsTitleTooltip);

        /* Verify the skills text tooltip is displayed*/
        Assert.assertEquals(skillsPage.getSkillsTxtTooltip(), skillsTxtTooltip);

        /* Verify selected skills are toggled on */
        Assert.assertTrue(skillsPage.isSkillSelected("0"), "Skill at index 0 should be selected");
        Assert.assertTrue(skillsPage.isSkillSelected("1"), "Skill at index 1 should be selected");
        Assert.assertTrue(skillsPage.isSkillSelected("2"), "Skill at index 2 should be selected");
        Assert.assertTrue(skillsPage.isSkillSelected("3"), "Skill at index 3 should be selected");
        Assert.assertTrue(skillsPage.isSkillSelected("4"), "Skill at index 4 should be selected");

        /* Verify save button initializes in a disabled state */
        Assert.assertFalse(skillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection is made");

        /* Deselect skills */
        skillsPage.toggleSkill("0");
        skillsPage.toggleSkill("1");
        skillsPage.toggleSkill("2");
        skillsPage.toggleSkill("3");
        skillsPage.toggleSkill("4");

        /* Verify save button is enabled after deselecting skills */
        Assert.assertTrue(skillsPage.isSaveButtonEnabled(), "Save button should be enabled after a selection is made");

        /* Save skills */
        skillsPage.clickSaveBtn();

        /* Verify and dismiss success toast */
        Assert.assertTrue(skillsPage.verifySkillsSuccessToast());
        skillsPage.dismissSkillsSuccessToast();

        /* Verify save button is disabled after saving */
        Assert.assertFalse(skillsPage.isSaveButtonEnabled(), "Save button should be disabled until a selection has been made");

        /* Verify skills are toggled off */
        Assert.assertFalse(skillsPage.isSkillSelected("0"), "Skill at index 25 should be deselected");
        Assert.assertFalse(skillsPage.isSkillSelected("1"), "Skill at index 26 should be deselected");
        Assert.assertFalse(skillsPage.isSkillSelected("2"), "Skill at index 27 should be deselected");
        Assert.assertFalse(skillsPage.isSkillSelected("3"), "Skill at index 28 should be deselected");
        Assert.assertFalse(skillsPage.isSkillSelected("4"), "Skill at index 29 should be deselected");

        /* Navigate to profile (view) */
        editProfilePage.clickSideMenuViewProfileLink();

        /* Verify skills section empty */
        Assert.assertTrue(profilePage.isSkillsHeaderDisplayed(),"Skills section & header should be displayed when the user has no skills added");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the skills test");
        navPage.attemptLogout();
        driver.quit();
    }
}
