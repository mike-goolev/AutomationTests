package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataImporter;
import restInterfaces.*;

public class HourlyProfileCertifications extends BaseTest {

    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfileCertificationsPage hourlyProfileCertificationsPage;
    private HourlyProfileEditPage hourlyProfileEditPage;

    private String username;
    private String password;
    private String guid;
    private String id;
    private String token;
    private String certsTitleTooltip;
    private String certsTxtTooltip;

    @BeforeMethod(dependsOnMethods = {"setUpMain"})
    public void setUp() {
        System.out.println("Initializing certifications test...");

        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfileCertificationsPage = new HourlyProfileCertificationsPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);

        username = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("username");
        password = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("password");
        guid = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("guid");
        token = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("token");
        certsTitleTooltip = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("certsTitleTooltip");
        certsTxtTooltip = (String) TestDataImporter.get("HourlyProfileCertifications", "HourlyProfileCertifications").get("certsTxtTooltip");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.clearUserCertifications(guid);
        System.out.println("Starting certifications test!");
    }

    @Test
    public void testHourlyProfileCertifications() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Login via email */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to the profile page */
        navPage.navigateToProfilePage();

        /* Verify certification empty state */
        Assert.assertTrue(hourlyProfileViewPage.isCertificationsHeaderDisplayed());

        /* Navigate to the Certs Page */
        hourlyProfileViewPage.clickAddCertifications();

        /* Verify that there are no certs present */
        Assert.assertTrue(hourlyProfileCertificationsPage.areNoCertsSelected(), "No certs should be selected");

        /* Verify the certifications tooltip is displayed*/
        Assert.assertTrue(hourlyProfileCertificationsPage.isCertsTooltipDisplayed(), "Certifications tooltip should be displayed");

        /* Verify the certifications title tooltip is displayed*/
        Assert.assertEquals(hourlyProfileCertificationsPage.getCertsTitleTooltip(), certsTitleTooltip);

        /* Verify the certifications text tooltip is displayed*/
        Assert.assertEquals(hourlyProfileCertificationsPage.getCertsTxtTooltip(), certsTxtTooltip);

        /* Select all certifications and verify that the upload button appears */
        hourlyProfileCertificationsPage.selectAllCertifications();
        Assert.assertTrue(hourlyProfileCertificationsPage.verifyCertificationSuccessBanner(), "The success toast should appear");
        hourlyProfileCertificationsPage.clickCloseCertificationBannerBtn();
        Assert.assertTrue(hourlyProfileCertificationsPage.areAllCertUploadBtnsDisplayed(), "All certs should have an upload button displayed");

        /* Go back to the profile page and verify all certs are displayed */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Thread.sleep(200);
        Assert.assertTrue(hourlyProfileViewPage.verifyAllCertifications(), "All certifications have been selected");

        /* Go back and remove all certifications */
        hourlyProfileViewPage.clickEditCertifications();
        hourlyProfileCertificationsPage.selectAllCertifications();
        Assert.assertTrue(hourlyProfileCertificationsPage.verifyCertificationSuccessBanner(), "Success toast should appear");
        hourlyProfileCertificationsPage.clickCloseCertificationBannerBtn();
        Assert.assertTrue(hourlyProfileCertificationsPage.areNoCertUploadBtnsDisplayed());

        /* Navigate to the profile page and verify that certs are in an empty state */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertTrue(hourlyProfileViewPage.verifyNoCertifications(), "No certs should be selected");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            screenshot.takeScreenShot(result.getMethod().getMethodName(), driver);
        }
        System.out.println("Logging out and shutting down selenium for the certifications test");
        navPage.attemptLogout();
        driver.quit();
    }

}
