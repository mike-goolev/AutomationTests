import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProfilePage extends BasePage {

    Locators.ProfilePageLocators profilePageLocators;
    SkillsPage skillsPage;

    public ProfilePage(WebDriver driver) {
        super(driver);
        profilePageLocators = new Locators.ProfilePageLocators();
        skillsPage = new SkillsPage(driver);
    }

    /*--------- Personal Info ----------*/

    /**
     * Checks to see if the user's profile photo is on the profile page
     * @return Whether or not the user's profile photo is on the profile page
     */
    public boolean isUserProfilePhotoPresent() {
        return elementExists(profilePageLocators.personInfoUserPhotoImg);
    }

    /**
     * Get user's first and last name from the text field
     * @return User's first and last name
     */
    public String getFirstAndLastName() {
        return driver.findElement(profilePageLocators.personalInfoUserFirstAndLastNameTxt).getText();
    }

    /**
     * Get user's primary job from the text field
     * @return User's primary job text
     */
    public String getSummaryPrimaryJob() {
        return driver.findElement(profilePageLocators.findPrimaryJobTxt).getText();
    }

    /**
     * Get user's skills from the text field
     * @return User's skills
     */
    public String getSummarySkills() {
        return driver.findElement(profilePageLocators.personalInfoSkillsTxt).getText();
    }

    /**
     * Verifies if the disconnect button is present on the personal info section
     * @return Whether or not the disconnect button is present on the personal info section
     */
    public boolean isDisconnectButtonPresent(){
        return elementExists(profilePageLocators.personalInfoActionsMenuBtn);
    }

    /**
     * Clicks on the disconnect button on the personal info section
     */
    public void clickDisconnectFromUser() {
        wait.until(elementToBeClickable(profilePageLocators.personalInfoActionsMenuBtn));
        driver.findElement(profilePageLocators.personalInfoActionsMenuBtn).click();
        wait.until(elementToBeClickable(profilePageLocators.personalInfoDisconnectBtn));
        driver.findElement(profilePageLocators.personalInfoDisconnectBtn).click();
    }

    /*--------- Work History ----------*/

    /**
     * Verifies that the work history title is present on the work history card
     * @return Whether or not the work history title is present on the work history card
     */
    public boolean isExperienceHeaderDisplayed() {
        return elementExists(profilePageLocators.workHistoryTitleTxt);
    }

    /**
     * Gets the empty state text on the work history card
     * @return The empty state text on the work history card
     */
    public String getExperienceEmptyTxt() {
        return driver.findElement(profilePageLocators.workHistoryEmptyTxt).getText();
    }

    /**
     * Clicks the empty state add experience button
     */
    public void clickAddExperience() {
        wait.until(elementToBeClickable(profilePageLocators.workHistoryAddBtn));
        driver.findElement(profilePageLocators.workHistoryAddBtn).click();
    }

    /**
     * Clicks the edit experience button when a user has >= 1 work history
     */
    public void clickEditExperience() {
        wait.until(elementToBeClickable(profilePageLocators.workHistoryEditBtn));
        driver.findElement(profilePageLocators.workHistoryEditBtn).click();
    }

    /**
     * Verifies that the employer logo is present at the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return Whether or not the logo is present at the given index
     */
    public boolean isEmployerLogoPresent(String index) {
        return elementExists(profilePageLocators.findWorkHistoryEmployerLogoByIndex(index));
    }

    /**
     * Gets the job position name at the given index
     * @param employerIndex The index (Starting at 0) of the employer you wish to locate
     * @param positionIndex The index (Starting at 0) of the position name you wish to locate
     * @return The job position text at the given index
     */
    public String getJobPosition(String employerIndex, String positionIndex) {
        return driver.findElement(profilePageLocators.findWorkHistoryJobPositionByIndex(employerIndex, positionIndex)).getText();
    }

    /**
     * Gets the employer name from the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return The employer name text at the given index
     */
    public String getEmployerName(String index) {
        return driver.findElement(profilePageLocators.findWorkHistoryEmployerNameByIndex(index)).getText();
    }

    /**
     * Gets the time period at the given index
     * @param index The index (Starting at 0) of the time period you wish to locate
     * @return The time period text at the given index
     */
    public String getTimePeriod(String index) {
        return driver.findElement(profilePageLocators.findWorkHistoryEmployerTimePeriodByIndex(index)).getText();
    }

    /**
     * Gets the work history duration at the given index
     * @param index The index (Starting at 0) of the work history duration you wish to locate
     * @return The duration text at the given index
     */
    public String getDuration(String index) {
        return driver.findElement(profilePageLocators.findWorkHistoryEmployerDurationByIndex(index)).getText();
    }

    /**
     * Gets the work history description at the given index
     * @param index The index (Starting at 0) of the work history description you wish to locate
     * @return The description text at the given index
     */
    public String getDescription(String index) {
        return driver.findElement(profilePageLocators.findWorkHistoryJobDescriptionByIndex(index)).getText();
    }

    /*--------- Certifications ----------*/

    /**
    * Checks to see if the Certifications header is displayed
     * @return Whether or not the certifications title is displayed
    */
    public Boolean isCertificationsHeaderDisplayed(){
        return elementExists(profilePageLocators.certsTitleTxt);
    }

    /**
     * Gets the empty state text on the certifications card
     * @return The empty state text on the certifications card
     */
    public String getCertificationsEmptyTxt() {
        return driver.findElement(profilePageLocators.certsEmptyTxt).getText();
    }

    /**
     * Clicks the add certifications button when a user has no certifications
     */
    public void clickAddCertifications() {
        wait.until(elementToBeClickable(profilePageLocators.certsAddBtn));
        driver.findElement(profilePageLocators.certsAddBtn).click();
    }

    /**
     * Clicks the edit certifications button when a user has >= 1 certification selected
     */
    public void clickEditCertifications() {
        wait.until(elementToBeClickable(profilePageLocators.certsEditBtn));
        driver.findElement(profilePageLocators.certsEditBtn).click();
    }

    /**
     * Checks to see if the Alcohol Seller Certification is on the certs card
     * @return Whether or not the Alcohol Seller Cert is on the cert card
     */
    public boolean verifyAlcoholCert() {
        return elementExists(profilePageLocators.certsAlcoholImg);
    }

    /**
     * Checks to see if the Food Handler Certification is on the certs card
     * @return Whether or not the Food Handler Seller Cert is on the cert card
     */
    public boolean verifyFoodHandlerCert() {
        return elementExists(profilePageLocators.certsFoodHandlerImg);
    }

    /**
     * Checks to see if the Food Protection Manager Certification is on the certs card
     * @return Whether or not the Food Protection Manager Cert is on the cert card
     */
    public boolean verifyFoodProtectionMangerCert() {
        return elementExists(profilePageLocators.certsFoodProtectionImg);
    }

    /**
     * Checks to see if the HACCP Certification is on the certs card
     * @return Whether or not the HACCP Cert is on the cert card
     */
    public boolean verifyHACCPCert() {
        return elementExists(profilePageLocators.certsHACCPImg);
    }

    /**
     * Checks to see if all certifications are on the certs card
     * @return Whether or not all certifications are on the certs card
     */
    public boolean verifyAllCertifications() {
        return verifyAlcoholCert() &&
                verifyFoodHandlerCert() &&
                verifyFoodProtectionMangerCert() &&
                verifyHACCPCert();
    }

    /**
     * Checks to see if the certs card is in an empty state; No certs are selected
     * @return Whether or not the certs card is in a empty state
     */
    public boolean verifyNoCertifications() {
        return  !verifyAlcoholCert() &&
                !verifyFoodHandlerCert() &&
                !verifyFoodProtectionMangerCert() &&
                !verifyHACCPCert();
    }

    /*--------- Availability ----------*/

    /**
     * Verifies that the availability title is displayed
     * @return Whether or not the availability title is displayed
     */
    public boolean isAvailabilityHeaderDisplayed() {
        return elementExists(profilePageLocators.availabilityTitleTxt);
    }

    /**
     * Gets the empty state text on the availability card
     * @return The empty state text on the availability card
     */
    public String getAvailabilityEmptyTxt() {
        return driver.findElement(profilePageLocators.availabilityEmptyTxt).getText();
    }

    /**
     * Clicks the add availability button when a user has no availability selected
     */
    public void clickAddAvailability() {
        wait.until(elementToBeClickable(profilePageLocators.availabilityAddBtn));
        driver.findElement(profilePageLocators.availabilityAddBtn).click();
    }

    /**
     * Clicks the edit availability button when a user has >= 1 day part selected
     */
    public void clickEditAvailability() {
        wait.until(elementToBeClickable(profilePageLocators.availabilityEditBtn));
        driver.findElement(profilePageLocators.availabilityEditBtn).click();
    }

    /**
     * Verifies that when a user has selected all availability, it shows on the view profile page
     * @return Whether or not the user has selected all availability
     */
    public boolean verifyAllAvailabilitySelected() {
        return elementExists(profilePageLocators.availabilityMorningsCard) &&
                elementExists(profilePageLocators.availabilityAfternoonsCard) &&
                elementExists(profilePageLocators.availabilityEveningsCard) &&
                elementExists(profilePageLocators.availabilityNightsCard);
    }

    /**
     * Verifies that the status text displayed on the profile matches a given string
     * @param status The string to match the interest status text with on the view profile page
     * @return Whether or not the interest text matches the given status string
     */
    public boolean verifyAvailabilityInterestStatusTxt(String status) {
        String statusTxt = driver.findElement(profilePageLocators.availabilityInterestStatusTxt).getText();
        return statusTxt.equals(status);
    }

    /**
     * Verifies that the type text displayed on the profile matches a given string
     * @param type The string to match the interest type text with on the view profile page
     * @return
     */
    public boolean verifyAvailabilityInterestTypeTxt(String type) {
        String typeTxt = driver.findElement(profilePageLocators.availabilityInterestTypeTxt).getText();
        return typeTxt.equals(type);
    }

    /*---------- About -----------*/

    /**
     * Verifies that the about title is displayed
     * @return Whether or not the about title is displayed
     */
    public boolean isAboutHeaderDisplayed() {
        return elementExists(profilePageLocators.aboutTitleTxt);
    }

    /**
     * Gets the empty state text on the about card
     * @return The empty state text on the about card
     */
    public String getAboutEmptyTxt() {
        return driver.findElement(profilePageLocators.aboutEmptyTxt).getText();
    }

    /**
     * Clicks the add about button when a user has no about
     */
    public void clickAddAbout() {
        wait.until(elementToBeClickable(profilePageLocators.aboutAddBtn));
        driver.findElement(profilePageLocators.aboutAddBtn).click();
    }

    /**
     * Verifies that the about section on the view profile page is present
     * @return Whether or not the about section is present on the view profile page
     */
    public boolean isAboutSectionPresent() {
        return elementExists(profilePageLocators.aboutTxtField);
    }

    /**
     * Gets the about text on the view profile screen
     * @return The about text
     */
    public String getAboutTxt() {
        return driver.findElement(profilePageLocators.aboutTxtField).getText();
    }

    /*---------- HourlyProfileSkills -----------*/

    /**
     * Verifies that the skills title is displayed
     * @return Whether or not the skills title is displayed
     */
    public Boolean isSkillsHeaderDisplayed(){
        return elementExists(profilePageLocators.skillsTitleTxt);
    }

    /**
     * Gets the empty state text on the skills card
     * @return The empty state text on the skills card
     */
    public String getSkillsEmptyTxt() {
        return driver.findElement(profilePageLocators.skillsEmptyTxt).getText();
    }

    /**
     * Clicks the add about button when a user has no about
     */
    public void clickAddSkills() {
        wait.until(elementToBeClickable(profilePageLocators.skillsAddBtn));
        driver.findElement(profilePageLocators.skillsAddBtn).click();
    }

    /**
     * Clicks the edit about button when a user has about completed
     */
    public void clickEditSkills() {
        wait.until(elementToBeClickable(profilePageLocators.skillsEditBtn));
        driver.findElement(profilePageLocators.skillsEditBtn).click();
    }

    /**
     * Checks to see if the selected skills match what is on the view profile screen
     * @param index The index (Starting at 0) of the skill you wish to locate
     * @return Whether or not the selected skill is on the page
     */
    public String getSelectedSkill(String index) {
        return driver.findElement(profilePageLocators.findSkillLabelByIndex(index)).getText();
    }

    /*---------- HourlyNetworkMyConnections -----------*/

    /**
     * Clicks the view all connections button when auth'd user has > 0 connections
     */
    public void clickViewAllConnections() {
        wait.until(elementToBeClickable(profilePageLocators.viewAllConnectionsBtn));
        driver.findElement(profilePageLocators.viewAllConnectionsBtn).click();
    }

    /**
     * Verifies that the connections title text is displayed on the view profile page

     * @return Whether or not the connections title text is displayed
     */
    public boolean isConnectionsTitleTxtPresent() {
        return elementExists(profilePageLocators.connectionsTitleTxt);
    }

    /**
     * Get user's connections count

     * @return User's connections count
     */
    public String getConnectionsCount() {
        wait.until(visibilityOfElementLocated(profilePageLocators.connectionsCountTxt));
        return driver.findElement(profilePageLocators.connectionsCountTxt).getText();
    }

    /**
     * Verifies that a connection's photo is at the given index

     * @param index The index (Starting at 0) of the connection you wish to locate
     * @return Whether or not a connection's photo is present at the given index
     */
    public boolean isConnectionsPhotoPresent(String index) {
        return elementExists(profilePageLocators.findConnectionImgByIndex(index));
    }

    /**
     * Get a connection's name

     * @ param index The index of the connection
     * @return Connection's name
     */
    public String getConnectionsName(String index) {
        return driver.findElement(profilePageLocators.findConnectionLinkByIndex(index)).getAttribute("title");
    }

    /**
     * Clicks a connection's view link at the given index

     * @param index The index (Starting at 0) of the connection you wish to locate
     */
    public void clickViewConnection(String index) {
        wait.until(elementToBeClickable(profilePageLocators.findConnectionLinkByIndex(index)));
        driver.findElement(profilePageLocators.findConnectionLinkByIndex(index)).click();
    }

    /*---------- HourlySuggestedConnections -----------*/

    /**
     * Verifies that the suggested connections title text is displayed on the view profile page

     * @return Whether or not the suggested connections title text is displayed
     */
    public boolean isSuggestedConnectionsTitleTxtPresent() {
        return elementExists(profilePageLocators.suggestedConnectionsTitleTxt);
    }

    /**
     * Verifies that the suggested connection's photo is at the given index

     * @return Whether or not the suggested connection's photo is present at the given index
     */
    public boolean isSuggestedConnectionsPhotoPresent() {
        return elementExists(profilePageLocators.suggestedConnectionImg);
    }

    /**
     * Get a suggested connection's name

     * @return Suggested connection's name
     */
    public String getSuggestedConnectionsName() {
        return driver.findElement(profilePageLocators.suggestedConnectionNameTxt).getText();
    }

    /**
     * Clicks a suggested connection's connect button
     */
    public void clickSuggestedConnectionsConnectBtn() {
        wait.until(elementToBeClickable(profilePageLocators.suggestedConnectionConnectBtn));
        driver.findElement(profilePageLocators.suggestedConnectionConnectBtn).click();
    }

    /**
     * Clicks a suggested connection's dismiss button
     */
    public void clickSuggestedConnectionsDismissBtn() {
        wait.until(elementToBeClickable(profilePageLocators.suggestedConnectionDismissBtn));
        driver.findElement(profilePageLocators.suggestedConnectionDismissBtn);
    }

    /*---------- Network Profile ----------*/
    /**
     * Clicks on the edit profile button on the view profile page
     */
    public void clickCancelConnectionRequestBtn() {
        wait.until(elementToBeClickable(profilePageLocators.cancelPendingConnectionRequestBtn));
        driver.findElement(profilePageLocators.cancelPendingConnectionRequestBtn).click();
    }


    /*---------- Utility Methods ----------*/

    /**
     * Clicks on the edit profile button on the view profile page
     */
    public void clickEditProfile() {
        wait.until(elementToBeClickable(profilePageLocators.profileEditBtn));
        driver.findElement(profilePageLocators.profileEditBtn).click();
    }

    /**
     * Verify that the success toast is displayed after saving.
     * @return Whether or not if the success toast has been displayed
     */
    public boolean verifySuccessToast() {
        if(driver.findElement(profilePageLocators.successToastDiv) != null) {
            return true;
        }
        return false;
    }

    /**
     * Click the back button to go to the view profile page
     */
    public void clickBackBtn() {
        driver.findElement(profilePageLocators.profileBackBtn).click();
    }

    /**
     * Click the back button when viewing another user's profile to go to the view profile page
     */
    public void clickPublicProfileViewBackBtn() {
        driver.findElement(profilePageLocators.publicProfileViewBackBtn).click();
    }
}
