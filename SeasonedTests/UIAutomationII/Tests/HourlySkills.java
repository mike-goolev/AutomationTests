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

    String username;
    String password;

    @BeforeClass
    public void setUp() {
        System.out.println("Starting Tests. HourlySkills test for hourly profile...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        skillsPage = new SkillsPage(driver);
        username = (String) TestDataImporter.get("HourlySkills", "testSkills").get("username");
        password = (String) TestDataImporter.get("HourlySkills", "testSkills").get("password");
        System.out.println("Starting test run!");
    }

    @Test
    public void testSkills() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile */
        navPage.navigateToProfilePage();

        /* Reset the skills to a known (blank) state */
        profilePage.resetSkills();

        /* Navigate to the HourlySkills page */
        profilePage.clickAddSkills();

        /* Verify that no skills have been selected, then select all skills and save. A success toast should appear. */
        Assert.assertTrue(skillsPage.noSkillsSelected(), "The user should have no skills selected");
        skillsPage.selectAllSkills();
        Assert.assertTrue(skillsPage.verifySuccessToast(), "The profile saved successfully toast is displayed");
        Assert.assertTrue(skillsPage.allSkillsSelected(), "The user should have all skills selected");

        /* Go back and verify that the skills show on the view profile page */
        profilePage.clickBackBtn();
        profilePage.verifySelectedSkills();

        /* Go to edit skills and verify that selected skills persists, then remove them */
        profilePage.clickEditSkills();
        Assert.assertTrue(skillsPage.allSkillsSelected(), "The user should have all skills selected)");
        skillsPage.removeAllSkills();
        Assert.assertTrue(skillsPage.verifySuccessToast(), "The profile saved successfully toast is displayed");
        Assert.assertTrue(skillsPage.noSkillsSelected(), "The user should have no skills selected");

        /* Go back to view profile and verify that no skills are selected */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.isEmptySkillsTxtStatePresent(), "The user should NOT have any skills selected");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the skills test");
        navPage.logout();
        driver.quit();
    }
}
