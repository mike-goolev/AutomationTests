import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyPersonalInfo extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private PersonalInfoPage personalInfoPage;

    private String username;
    private String password;
    private String originalName;
    private String newName;
    private String originalLocation;
    private String newLocation;
    private String newPhone;
    private String phoneFormatted;
    private String token;
    private String userGuid;
    private String originalCity;
    private String originalState;
    private String originalZip;
    private String country;
    private Double originalLatitude;
    private Double originalLongitude;
    private String originalAddress;
    private String newAddress;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String accountState;
    private String roleGuid;
    private String roleName;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly profile test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        personalInfoPage = new PersonalInfoPage(driver);

        username = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("username");
        password = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("password");
        originalName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalName");
        newName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newName");
        originalLocation = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLocation");
        newLocation = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newLocation");
        newPhone = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newPhone");
        phoneFormatted = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("phoneFormatted");
        userGuid = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("userGuid");
        originalCity = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalCity");
        originalState = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalState");
        originalZip = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalZip");
        country = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("");
        originalLatitude = (Double) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLatitude");
        originalLongitude = (Double) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLongitude");
        originalAddress = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalAddress");
        newAddress = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newAddress");
        id = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("id");
        firstName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("firstName");
        lastName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("lastName");
        email = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("email");
        phone = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("phone");
        accountState = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("accountState");
        roleGuid = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("roleGuid");
        roleName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("roleName");
        token = (String) TestDataImporter.get("HourlyJobSearch", "testHourlyJobSearchCommitSearchAndViewJobDetails").get("token");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateUserLocation(userGuid, originalCity, originalState, originalZip, country, originalLatitude, originalLongitude);
        seasonedRestAPI.updateUserNameEmailPhone(id, userGuid, firstName, lastName, email, phone, accountState, roleGuid, roleName);
        System.out.println("Starting hourly profile test!");
    }

    @Test
    public void testPersonalInfo() throws Exception {
        /* Start test on the content feed */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the HourlyAbout page */
        navPage.navigateToProfilePage();
        profilePage.clickEditPersonalInfo();

        /* Verify the user's initial name, location and phone # */
        Assert.assertTrue(personalInfoPage.verifyUserFirstAndLastNameTxt(originalName),
                "\nExpected name: " + originalName +
                         "\nReturned name: " + personalInfoPage.getUserFirstAndLastNameTxt() + "\n");
        Assert.assertTrue(personalInfoPage.verifyUserLocationTxt(originalLocation),
                "\nExpected location: " + originalLocation +
                         "\nReturned location: " + personalInfoPage.getUserLocation() + "\n");
        Assert.assertTrue(personalInfoPage.isUserPhoneTxtFieldEmpty());

        /* Update the user's name, location and phone and then save */
        personalInfoPage.updateUserFirstAndLastNameTxt(newName);
        personalInfoPage.updateUserLocationTxt(newLocation);
        personalInfoPage.enterUserPhone(newPhone);
        personalInfoPage.clickSaveBtn();

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed");

        /* Verify new name, location and phone are displayed after saving */
        Assert.assertTrue(personalInfoPage.verifyUserFirstAndLastNameTxt(newName),
                "\nExpected name: " + newName +
                         "\nReturned name: " + personalInfoPage.getUserFirstAndLastNameTxt() + "\n");
        Assert.assertTrue(personalInfoPage.verifyUserLocationTxt(newAddress),
                "\nExpected location: " + newLocation +
                         "\nReturned location: " + personalInfoPage.getUserLocation() + "\n");
        Assert.assertTrue(personalInfoPage.verifyUserPhoneTxt(phoneFormatted),
                "\nExpected phone: " + newPhone +
                         "\nReturned phone: " + personalInfoPage.getUserPhone() + "\n");

        /* Go back and verify that the new name shows on the view profile page */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.verifyUserFirstAndLastName(newName),
                "\nExpected name: " + newName +
                         "\nReturned name: " + profilePage.getFirstAndLastNameTxt() + "\n");
        Assert.assertTrue(profilePage.verifyUserLocation(newLocation),
                "\nExpected location: " + newLocation +
                         "\nReturned location: " + profilePage.getLocationTxt() + "\n");

        /* Go to edit personal info and change name, location and phone back to the original state */
        profilePage.clickEditPersonalInfo();
        personalInfoPage.updateUserFirstAndLastNameTxt(originalName);
        personalInfoPage.updateUserLocationTxt(originalLocation);
        personalInfoPage.removeUserPhoneTxt();
        personalInfoPage.clickSaveBtn();

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(profilePage.verifySuccessToast(), "Success toast should be displayed");

        /* Verify original name and location displayed after saving */
        Assert.assertTrue(personalInfoPage.verifyUserFirstAndLastNameTxt(originalName),
                "\nExpected name: " + originalName +
                         "\nReturned name: " + personalInfoPage.getUserFirstAndLastNameTxt() + "\n");
        Assert.assertTrue(personalInfoPage.verifyUserLocationTxt(originalAddress),
                "\nExpected location: " + originalLocation +
                         "\nReturned location: " + personalInfoPage.getUserLocation() + "\n");
        Assert.assertTrue(personalInfoPage.isUserPhoneTxtFieldEmpty());

        /* Go back to view profile and verify that the original name and location are displayed */
        profilePage.clickBackBtn();
        Assert.assertTrue(profilePage.verifyUserFirstAndLastName(originalName),
                "\nExpected name: " + originalName +
                         "\nReturned name: " + profilePage.getFirstAndLastNameTxt() + "\n");
        Assert.assertTrue(profilePage.verifyUserLocation(originalLocation),
                "\nExpected location: " + originalLocation +
                         "\nReturned location: " + profilePage.getLocationTxt() + "\n");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the personal info test");
        navPage.logout();
        driver.quit();
    }
}
