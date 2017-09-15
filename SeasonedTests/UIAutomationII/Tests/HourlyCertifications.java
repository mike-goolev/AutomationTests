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
    private EditProfilePage editProfilePage;

    private String username;
    private String password;
    private String certsTitletooltip;
    private String certsTxttooltip;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing certifications test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        certificationsPage = new CertificationsPage(driver);
        editProfilePage = new EditProfilePage(driver);
        username = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("username");
        password = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("password");
        certsTitletooltip = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("certsTitletooltip");
        certsTxttooltip = (String) TestDataImporter.get("HourlyCertifications", "Hourly Certifications").get("certsTxttooltip");
    }

    @Test
    public void testCerts() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Login via email */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify certification empty state */
        Assert.assertTrue(profilePage.isCertificationsHeaderDisplayed());

        /* Navigate to the Certs Page */
        profilePage.clickAddCertifications();

        /* Verify that there are no certs present */
        Assert.assertTrue(certificationsPage.areNoCertsSelected(), "No certs should be selected");

        /* Verify the certifications tooltip is displayed*/
        Assert.assertTrue(certificationsPage.isCertsTooltipDisplayed(), "Certifications tooltip should be displayed");

        /* Verify the certifications title tooltip is displayed*/
        Assert.assertEquals(certificationsPage.getCertsTitleTooltip(), certsTitletooltip);

        /* Verify the certifications text tooltip is displayed*/
        Assert.assertEquals(certificationsPage.getCertsTxtTooltip(), certsTxttooltip);

        /* Select all certifications and verify that the upload button appears */
        certificationsPage.selectAllCertifications();
        Assert.assertTrue(certificationsPage.verifyCertificationSuccessBanner(), "The success toast should appear");
        certificationsPage.clickCloseCertificationBannerBtn();
        Assert.assertTrue(certificationsPage.areAllCertUploadBtnsDisplayed(), "All certs should have an upload button displayed");

        /* Go back to the profile page and verify all certs are displayed */
        editProfilePage.clickSideMenuViewProfileLink();
        Thread.sleep(200);
        Assert.assertTrue(profilePage.verifyAllCertifications(), "All certifications have been selected");

        /* Go back and remove all certifications */
        profilePage.clickEditCertifications();
        certificationsPage.selectAllCertifications();
        Assert.assertTrue(certificationsPage.verifyCertificationSuccessBanner(), "Success toast should appear");
        certificationsPage.clickCloseCertificationBannerBtn();
        Assert.assertTrue(certificationsPage.areNoCertUploadBtnsDisplayed());

        /* Navigate to the profile page and verify that certs are in an empty state */
        editProfilePage.clickSideMenuViewProfileLink();
        Assert.assertTrue(profilePage.verifyNoCertifications(), "No certs should be selected");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the certifications test");
        navPage.attemptLogout();
        driver.quit();
    }

}
