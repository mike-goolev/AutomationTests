import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyCertifications extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private CertificationsPage certificationsPage;

    private String username;
    private String password;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing certifications test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        certificationsPage = new CertificationsPage(driver);
        username = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("username");
        password = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("password");
    }

    @Test
    public void testCerts() throws Exception {
        /* Start test from the content feed */
        testUtils.loadContentFeedPage();

        /* Login via email */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Navigate to the Certs Page and verify that there are no certs present */
        profilePage.clickAddCertifications();
        Assert.assertTrue(certificationsPage.areNoCertsSelected(), "No certs should be selected");

        /* Select all certifications and verify that the upload button appears */
        certificationsPage.selectAllCertifications();
        Assert.assertTrue(profilePage.verifySuccessToast(), "The success toast should appear");
        Assert.assertTrue(certificationsPage.areAllCertUploadBtnsDisplayed(), "All certs should have an upload button displayed");

        /* Go back to the profile page and verify all certs are displayed */
        profilePage.clickBackBtn();
        Thread.sleep(200);
        Assert.assertTrue(profilePage.verifyAllCertifications(), "All certifications have been selected");

        /* Go back and remove all certifications */
        profilePage.clickEditCertifications();
        certificationsPage.selectAllCertifications();
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should appear");
        Assert.assertTrue(certificationsPage.areNoCertUploadBtnsDisplayed());

        /* Navigate to the profile page and verify that certs are in an empty state */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.verifyNoCertifications(), "No certs should be selected");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the certifications test");
        navPage.logout();
        driver.quit();
    }

}
