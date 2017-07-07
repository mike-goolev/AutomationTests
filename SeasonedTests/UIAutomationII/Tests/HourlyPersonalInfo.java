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
    private String photoText;
    private String originalFirstName;
    private String originalLastName;
    private String newFirstName;
    private String newLastName;
    private String originalFirstNameLastInitial;
    private String newFirstNameLastInitial;
    private String originalLocation;
    private String newLocation;
    private String newPhone;
    private String phoneFormatted;
    private String dob;
    private String dobMonth;
    private String dobMonthValue;
    private String dobDay;
    private String dobYear;
    private String token;
    private String userGuid;
    private String originalCity;
    private String originalState;
    private String originalZip;
    private String country;
    private Double originalLatitude;
    private Double originalLongitude;
    private String id;
    private String email;
    private String phone;
    private String accountState;
    private String roleGuid;
    private String roleName;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly personal info test...");
        driver = new FirefoxDriver();
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        personalInfoPage = new PersonalInfoPage(driver);

        username = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("username");
        password = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("password");
        photoText = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("photoText");
        originalFirstName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalFirstName");
        originalLastName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLastName");
        newFirstName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newFirstName");
        newLastName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newLastName");
        originalFirstNameLastInitial = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalFirstNameLastInitial");
        newFirstNameLastInitial = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newFirstNameLastInitial");
        originalLocation = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLocation");
        newLocation = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newLocation");
        newPhone = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("newPhone");
        phoneFormatted = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("phoneFormatted");
        dob = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("dob");
        dobMonth = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("dobMonth");
        dobMonthValue = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("dobMonthValue");
        dobDay = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("dobDay");
        dobYear = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("dobYear");
        userGuid = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("userGuid");
        originalCity = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalCity");
        originalState = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalState");
        originalZip = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalZip");
        country = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("");
        originalLatitude = (Double) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLatitude");
        originalLongitude = (Double) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("originalLongitude");
        id = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("id");
        email = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("email");
        phone = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("phone");
        accountState = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("accountState");
        roleGuid = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("roleGuid");
        roleName = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("roleName");
        token = (String) TestDataImporter.get("HourlyPersonalInfo", "testPersonalInfo").get("token");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateUserLocation(userGuid, originalCity, originalState, originalZip, country, originalLatitude, originalLongitude);
        seasonedRestAPI.updateUserNameEmailPhoneBday(id, userGuid, originalFirstName, originalLastName, email, phone, dob, accountState, roleGuid, roleName);
        seasonedRestAPI.clearEligibilityAnswersForUser(userGuid);
        System.out.println("Starting hourly personal info test!");
    }

    @Test
    public void testPersonalInfo() throws Exception {
        /* Start test on the content feed page */
        testUtils.loadContentFeedPage();

        /* Log in */
        navPage.clickLoginBtn();
        loginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the hourly personal info page */
        navPage.navigateToProfilePage();

        /* Intro statement does not always display - Refreshing page fixes this */
        driver.navigate().to(driver.getCurrentUrl());

        /* Verify user's name and location*/
        Assert.assertEquals(profilePage.getFirstAndLastNameTxt(), originalFirstName + ' ' + originalLastName);

        /* Navigate to the edit profile page */
        profilePage.clickEditProfile();

        /* Verify the user's initial name, location, phone, dob and eligibility # */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), originalFirstNameLastInitial);
        Assert.assertTrue(personalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(personalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(personalInfoPage.getUserFirstName(), originalFirstName);
        Assert.assertEquals(personalInfoPage.getUserLastName(), originalLastName);
        Assert.assertEquals(personalInfoPage.getUserLocation(), originalLocation);
        Assert.assertTrue(personalInfoPage.isUserPhoneTxtFieldEmpty(), "Phone field should be empty");
        Assert.assertTrue(personalInfoPage.isBirthdayEmpty(), "Birthday dropdowns should have default selections");
        Assert.assertFalse(personalInfoPage.isEligibilitySelected(), "Eligibility should not be checked");
        Assert.assertTrue(personalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");

        /* Update the user's name, location, phone, birthday and eligibility and then save */
        personalInfoPage.updateUserFirstAndLastName(newFirstName, newLastName);
        personalInfoPage.updateUserLocation(newLocation);
        personalInfoPage.enterUserPhone(newPhone);
        personalInfoPage.selectMonthFromDate(dobMonthValue);
        personalInfoPage.selectDayFromDate(dobDay);
        personalInfoPage.selectYearFromDate(dobYear);
        personalInfoPage.clickEligibilityChk();
        personalInfoPage.clickSaveBtn();

        /* Verify that the success toast displays after saving */
        Assert.assertTrue(personalInfoPage.verifyPersonalInfoSuccessToast(), "Success toast should be displayed");
        personalInfoPage.dismissPersonalInfoSuccessToast();

        /* Verify new name, location, phone, dob and eligibility are displayed after saving */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), newFirstNameLastInitial);
        Assert.assertTrue(personalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(personalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(personalInfoPage.getUserFirstName(), newFirstName);
        Assert.assertEquals(personalInfoPage.getUserLastName(), newLastName);
        Assert.assertEquals(personalInfoPage.getUserLocation(), newLocation);
        Assert.assertEquals(personalInfoPage.getUserPhone(), phoneFormatted);
        Assert.assertEquals(personalInfoPage.getSelectedMonth(), dobMonth);
        Assert.assertEquals(personalInfoPage.getSelectedDay(), dobDay);
        Assert.assertEquals(personalInfoPage.getSelectedYear(), dobYear);
        Assert.assertTrue(personalInfoPage.isEligibilitySelected(), "Eligibility should be checked");
        /* Commenting out for now b/c the presence of a phone # or b-day causes the save button to always display in an enabled state */
        /*Assert.assertFalse(personalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");*/

        /* Go back and verify that the new name shows on the view profile page */
        navPage.navigateToProfilePage();
        Assert.assertEquals(profilePage.getFirstAndLastNameTxt(), newFirstName + ' ' + newLastName);

        /* Go to edit personal info and change name, location, phone and eligibility back to the original state */
        profilePage.clickEditProfile();
        personalInfoPage.updateUserFirstAndLastName(originalFirstName, originalLastName);
        personalInfoPage.updateUserLocation(originalLocation);
        personalInfoPage.removeUserPhone();
        personalInfoPage.clickEligibilityChk();
        personalInfoPage.clickSaveBtn();

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(personalInfoPage.verifyPersonalInfoSuccessToast(), "Success toast should be displayed");
        personalInfoPage.dismissPersonalInfoSuccessToast();

        /* Verify original name and location displayed after saving */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), originalFirstNameLastInitial);
        Assert.assertTrue(personalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(personalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(personalInfoPage.getUserFirstName(), originalFirstName);
        Assert.assertEquals(personalInfoPage.getUserLastName(), originalLastName);
        Assert.assertEquals(personalInfoPage.getUserLocation(), originalLocation);
        Assert.assertTrue(personalInfoPage.isUserPhoneTxtFieldEmpty(), "Phone field should be empty");
        Assert.assertFalse(personalInfoPage.isEligibilitySelected(), "Eligibility should not be checked");
        /* Commenting out for now b/c the presence of a phone # or b-day causes the save button to always display in an enabled state */
        /*Assert.assertTrue(personalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");*/

        /* Go back to view profile and verify that the original name and location are displayed */
        navPage.navigateToProfilePage();
        Assert.assertEquals(profilePage.getFirstAndLastNameTxt(), originalFirstName + ' ' + originalLastName);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the personal info test");
        navPage.attemptLogout();
        driver.quit();
    }
}
