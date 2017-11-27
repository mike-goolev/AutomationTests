import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HourlyProfilePersonal extends BaseTest {

    private TestUtils testUtils;
    private NavPage navPage;
    private HourlyLoginPage hourlyLoginPage;
    private HourlyProfileViewPage hourlyProfileViewPage;
    private HourlyProfilePersonalInfoPage hourlyProfilePersonalInfoPage;
    private HourlyProfileEditPage hourlyProfileEditPage;

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
    private String locationTxtTooltip;
    private String phoneTxtTooltip;
    private String birthdateTxtTooltip;

    @BeforeClass
    public void setUp() {
        System.out.println("Initializing hourly personal info test...");
        driver = BrowserFactory.getDriver("firefox");
        testUtils = new TestUtils(driver);
        navPage = new NavPage(driver);
        hourlyLoginPage = new HourlyLoginPage(driver);
        hourlyProfileViewPage = new HourlyProfileViewPage(driver);
        hourlyProfilePersonalInfoPage = new HourlyProfilePersonalInfoPage(driver);
        hourlyProfileEditPage = new HourlyProfileEditPage(driver);

        username = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("username");
        password = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("password");
        photoText = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("photoText");
        originalFirstName = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalFirstName");
        originalLastName = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalLastName");
        newFirstName = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("newFirstName");
        newLastName = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("newLastName");
        originalFirstNameLastInitial = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalFirstNameLastInitial");
        newFirstNameLastInitial = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("newFirstNameLastInitial");
        originalLocation = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalLocation");
        newLocation = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("newLocation");
        newPhone = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("newPhone");
        phoneFormatted = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("phoneFormatted");
        dob = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("dob");
        dobMonth = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("dobMonth");
        dobMonthValue = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("dobMonthValue");
        dobDay = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("dobDay");
        dobYear = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("dobYear");
        userGuid = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("userGuid");
        originalCity = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalCity");
        originalState = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalState");
        originalZip = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalZip");
        country = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("");
        originalLatitude = (Double) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalLatitude");
        originalLongitude = (Double) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("originalLongitude");
        id = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("id");
        email = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("email");
        phone = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("phone");
        accountState = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("accountState");
        roleGuid = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("roleGuid");
        roleName = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("roleName");
        token = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("token");
        locationTxtTooltip = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("locationTxtTooltip");
        phoneTxtTooltip = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("phoneTxtTooltip");
        birthdateTxtTooltip = (String) TestDataImporter.get("HourlyProfilePersonal", "HourlyProfilePersonal").get("birthdateTxtTooltip");

        SeasonedRestAPI seasonedRestAPI = new SeasonedRestAPI(token);
        seasonedRestAPI.updateUserLocation(userGuid, originalCity, originalState, originalZip, country, originalLatitude, originalLongitude);
        seasonedRestAPI.updateUserNameEmailPhoneBday(id, userGuid, originalFirstName, originalLastName, email, phone, dob, accountState, roleGuid, roleName);
        System.out.println("Starting hourly personal info test!");
    }

    @Test
    public void testPersonalInfo() throws Exception {
        /* Start test on the be successful page */
        testUtils.loadBeSuccessfulPage();

        /* Log in */
        navPage.clickLoginBtn();
        hourlyLoginPage.loginWithEmail(username, password);

        /* Navigate to profile -> Navigate to the hourly personal info page */
        navPage.navigateToProfilePage();

        /* Verify user's name and location*/
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), originalFirstName + ' ' + originalLastName);

        /* Navigate to the edit profile page */
        hourlyProfileViewPage.clickEditProfile();

        /* Navigate to the personal info page */
        hourlyProfileEditPage.clickSideMenuPersonalInfoLink();

        /* Verify the personal info tooltip is displayed*/
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isPersonalInfoTooltipDisplayed(), "Personal info tooltip should be displayed");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getLocationTitleTooltip(), "Location");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getLocationTxtTooltip(), locationTxtTooltip);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getPhoneTitleTooltip(), "Phone");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getPhoneTxtTooltip(), phoneTxtTooltip);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getBirthdateTitleTooltip(), "Birth date");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getBirthdateTxtTooltip(), birthdateTxtTooltip);

        /* Verify the user's initial name, location, phone and dob # */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), originalFirstNameLastInitial);
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserFirstName(), originalFirstName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLastName(), originalLastName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLocation(), originalLocation);
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isUserPhoneTxtFieldEmpty(), "Phone field should be empty");
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isBirthdayEmpty(), "Birthday dropdowns should have default selections");
        Assert.assertFalse(hourlyProfilePersonalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");

        /* Update the user's name, location, phone and birthday and then save */
        hourlyProfilePersonalInfoPage.updateUserFirstAndLastName(newFirstName, newLastName);
        hourlyProfilePersonalInfoPage.updateUserLocation(newLocation);
        hourlyProfilePersonalInfoPage.enterUserPhone(newPhone);
        hourlyProfilePersonalInfoPage.selectMonthFromDate(dobMonthValue);
        hourlyProfilePersonalInfoPage.selectDayFromDate(dobDay);
        hourlyProfilePersonalInfoPage.selectYearFromDate(dobYear);
        hourlyProfilePersonalInfoPage.clickSaveBtn();

        /* Verify that the success toast displays after saving */
        Assert.assertTrue(hourlyProfilePersonalInfoPage.verifyPersonalInfoSuccessToast(), "Success toast should be displayed");
        hourlyProfilePersonalInfoPage.dismissPersonalInfoSuccessToast();

        /* Verify new name, location, phone and dob are displayed after saving */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), newFirstNameLastInitial);
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserFirstName(), newFirstName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLastName(), newLastName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLocation(), newLocation);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserPhone(), phoneFormatted);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getSelectedMonth(), dobMonth);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getSelectedDay(), dobDay);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getSelectedYear(), dobYear);
        Assert.assertFalse(hourlyProfilePersonalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");

        /* Go back and verify that the new name shows on the view profile page */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), newFirstName + ' ' + newLastName);

        /* Go to edit personal info and change name, location and phone back to the original state */
        hourlyProfileViewPage.clickEditProfile();
        hourlyProfileEditPage.clickSideMenuPersonalInfoLink();
        hourlyProfilePersonalInfoPage.updateUserFirstAndLastName(originalFirstName, originalLastName);
        hourlyProfilePersonalInfoPage.updateUserLocation(originalLocation);
        hourlyProfilePersonalInfoPage.removeUserPhone();
        hourlyProfilePersonalInfoPage.clickSaveBtn();

        /* Verify that the green banner displays after saving */
        Assert.assertTrue(hourlyProfilePersonalInfoPage.verifyPersonalInfoSuccessToast(), "Success toast should be displayed");
        hourlyProfilePersonalInfoPage.dismissPersonalInfoSuccessToast();

        /* Verify original name and location displayed after saving */
        Assert.assertTrue(navPage.isNavMenuAvatarDisplayed(), "User avatar should be displayed in the menu");
        Assert.assertEquals(navPage.getUserFirstNameLastInitial(), originalFirstNameLastInitial);
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isUserAvatarDisplayed(), "User avatar should be displayed on the personal info page");
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getPhotoText(), photoText);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserFirstName(), originalFirstName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLastName(), originalLastName);
        Assert.assertEquals(hourlyProfilePersonalInfoPage.getUserLocation(), originalLocation);
        Assert.assertTrue(hourlyProfilePersonalInfoPage.isUserPhoneTxtFieldEmpty(), "Phone field should be empty");
        Assert.assertFalse(hourlyProfilePersonalInfoPage.isSaveButtonEnabled(), "Save button should be disabled");

        /* Go back to view profile and verify that the original name and location are displayed */
        hourlyProfileEditPage.clickSideMenuViewProfileLink();
        Assert.assertEquals(hourlyProfileViewPage.getFirstAndLastName(), originalFirstName + ' ' + originalLastName);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Logging out and shutting down selenium for the personal info test");
        navPage.attemptLogout();
        driver.quit();
    }
}
