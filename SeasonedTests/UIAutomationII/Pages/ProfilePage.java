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

    /*--------- Work History ----------*/

    /**
     * Clicks on the add work history button when a user has no work history
     */
    public void clickAddWorkHistory() {
        wait.until(elementToBeClickable(profilePageLocators.workHistoryAddBtn));
        driver.findElement(profilePageLocators.workHistoryAddBtn).click();
    }

    /**
     * Clicks on the edit work history button when a user has work history on their profile
     */
    public void clickEditWorkHistory() {
        wait.until(elementToBeClickable(profilePageLocators.workHistoryEditBtn));
        driver.findElement(profilePageLocators.workHistoryEditBtn).click();
    }

    /**
     * Verifies that the empty state text is present on the work history card
     * @return Whether or not the empty state text is present on the work history card
     */
    public boolean isWorkHistoryEmptyCardTextPresent() {
        return elementExists(profilePageLocators.workHistoryEmptyCardTxt);
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
     * Verifies that the job position name is present at the given index
     * @param employerIndex The index (Starting at 0) of the employer you wish to locate
     * @param jobIndex The index (Starting at 0) of the job name you wish to locate
     * @return Whether or not the job name is present at the given index
     */
    public boolean isJobPositionPresent(String employerIndex, String jobIndex) {
        return elementExists(profilePageLocators.findWorkHistoryJobPositionByIndex(employerIndex, jobIndex));
    }

    /**
     * Verifies that the employer name is present at the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return Whether or not the employer name is present at the given index
     */
    public boolean isEmployerNamePresent(String index) {
        return elementExists(profilePageLocators.findWorkHistoryEmployerNameByIndex(index));
    }

    /**
     * Verifies that the employer location is present at the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return Whether or not the employer location is present at the given index
     */
    public boolean isEmployerLocationPresent(String index) {
        return elementExists(profilePageLocators.findWorkHistoryEmployerLocationByIndex(index));
    }

    /**
     * Verifies that the time period is present at the given index
     * @param index The index (Starting at 0) of the employer you wish to locate
     * @return Whether or not the time period is present at the given index
     */
    public boolean isTimePeriodPresent(String index) {
        return elementExists(profilePageLocators.findWorkHistoryEmployerTimePeriodByIndex(index));
    }

    /**
     * Waits for the edit work history button to be clickable
     */
    public void waitForEditWorkHistoryBtn() {
        wait.until(elementToBeClickable(profilePageLocators.workHistoryEditBtn));
    }

    /*--------- Certifications ----------*/

    /**
     * Clicks the add certifications button when a user has no certifications
     */
    public void clickAddCertifications() {
        wait.until(elementToBeClickable(profilePageLocators.certsAddButton));
        driver.findElement(profilePageLocators.certsAddButton).click();
    }

    /**
     * Clicks the edit certifications button when a user has certifications selected
     */
    public void clickEditCertifications() {
        wait.until(elementToBeClickable(profilePageLocators.certsEditButton));
        driver.findElement(profilePageLocators.certsEditButton).click();
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
        return elementExists(profilePageLocators.certsEmptyCardTxt);
    }

    /*--------- Availability ----------*/

    /**
     * Clicks the add availability button when a user does NOT have availability
     */
    public void clickAddAvailability() {
        wait.until(elementToBeClickable(profilePageLocators.addAvailabilityBtn));
        driver.findElement(profilePageLocators.addAvailabilityBtn).click();
    }

    /**
     * Clicks the edit availability button when a user has availability entered on their profile
     */
    public void clickEditAvailability() {
        wait.until(elementToBeClickable(profilePageLocators.editAvailabilityBtn));
        driver.findElement(profilePageLocators.editAvailabilityBtn).click();
    }

    /**
     * Verifies that when a user has selected all availability, it shows on the view profile page
     * @return Whether or not the user has selected all availability
     */
    public boolean verifyAllAvailabilitySelected() {
        return elementExists(profilePageLocators.availabilityMorningsSelectedImg) &&
                elementExists(profilePageLocators.availabilityAfternoonsSelectedImg) &&
                elementExists(profilePageLocators.availabilityEveningsSelectedImg) &&
                elementExists(profilePageLocators.availabilityNightsSelectedImg);
    }

    /*---------- HourlyAbout -----------*/

    /**
     * Clicks the add about button when a user DOESN'T have about text on their profile
     */
    public void clickAddAbout() {
        wait.until(elementToBeClickable(profilePageLocators.addAboutBtn));
        driver.findElement(profilePageLocators.addAboutBtn).click();
    }

    /**
     * Clicks the edit about button when a user has about txt on their profile
     */
    public void clickEditAbout() {
        wait.until(elementToBeClickable(profilePageLocators.editAboutBtn));
        driver.findElement(profilePageLocators.editAboutBtn).click();
    }

    /**
     * Checks to see if the about text matches what is on the view profile screen
     *
     * @param aboutTxt The text you're expecting to be on the page
     * @return Whether or not the text is on the page
     */
    public boolean verifyAboutTxt(String aboutTxt) {
        return aboutTxt.equals(driver.findElement(profilePageLocators.aboutTxtField).getText());
    }

    /**
     * Checks for about text on the user's profile
     *
     * @return Whether or not a user has about text on their profile
     */
    public boolean isAboutTxtEmptyStatePresent() {
        return driver.findElement(profilePageLocators.emptyAboutTxtField).isDisplayed();
    }

    /*---------- Basic Info ---------*/

    /**
     * Clicks on the add basic info button when a user does NOT have basic info
     */
    public void clickAddBasicInfo() {
        wait.until(elementToBeClickable(profilePageLocators.addBasicInfoBtn));
        driver.findElement(profilePageLocators.addBasicInfoBtn).click();
    }

    /**
     * Clicks on the edit basic info button when a user has basic info filled out
     */
    public void clickEditBasicInfo() {
        wait.until(elementToBeClickable(profilePageLocators.editBasicInfoBtn));
        driver.findElement(profilePageLocators.editBasicInfoBtn).click();
    }

    /**
     * Checks to see if the age question is answered yes on the view profile page
     *
     * @return Whether or not the age question is answered yes
     */
    public boolean basicInfoAgeQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoAgeYesBtn);
    }

    /**
     * Checks to see if the transport question is answered yes on the view profile page
     *
     * @return Whether or not the transport question is answered yes
     */
    public boolean basicInfoTransportQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoTransportYesBtn);
    }

    /**
     * Checks to see if the legal question is answered yes on the view profile page
     *
     * @return Whether or not the legal question is answered yes
     */
    public boolean basicInfoLegalQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoLegalYesBtn);
    }

    /**
     * Checks to see if all basic info questions are answered yes on the view profile page
     *
     * @return Whether or not all basic info questions are answered yes
     */
    public boolean basicInfoQuestionsAnsweredYes() {
        return basicInfoAgeQuestionAnsweredYes() &&
                basicInfoTransportQuestionAnsweredYes() &&
                basicInfoLegalQuestionAnsweredYes();
    }

    /**
     * Checks to see if the age question is answered yes no the view profile page
     *
     * @return Whether or not the age question is answered no
     */
    public boolean basicInfoAgeQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoAgeNoBtn);
    }

    /**
     * Checks to see if the transport question is answered no on the view profile page
     *
     * @return Whether or not the transport question is answered no
     */
    public boolean basicInfoTransportQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoTransportNoBtn);
    }

    /**
     * Checks to see if the legal question is answered no on the view profile page
     *
     * @return Whether or not the legal question is answered no
     */
    public boolean basicInfoLegalQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoLegalNoBtn);
    }

    /**
     * Checks to see if all basic info questions are answered yes on the view profile page
     *
     * @return Whether or not all basic info questions are answered yes
     */
    public boolean basicInfoQuestionsAnsweredNo() {
        return basicInfoAgeQuestionAnsweredNo() &&
                basicInfoTransportQuestionAnsweredNo() &&
                basicInfoLegalQuestionAnsweredNo();
    }

        /*---------- HourlySkills -----------*/

    /**
     * Clicks the add skills button when a user DOESN'T have skills on their profile
     */
    public void clickAddSkills() {
        wait.until(elementToBeClickable(profilePageLocators.addSkillsBtn));
        driver.findElement(profilePageLocators.addSkillsBtn).click();
    }

    /**
     * Clicks the edit skills button when a user has >= 1 skill selected on their profile
     */
    public void clickEditSkills() {
        wait.until(elementToBeClickable(profilePageLocators.editSkillsBtn));
        driver.findElement(profilePageLocators.editSkillsBtn).click();
    }

    /**
     * Checks to see if the Baker skill is selected
     */
    public boolean skillBakerSelectedYes() {
        return elementExists(profilePageLocators.skillsBakerTxt);
    }

    /**
     * Checks to see if the Bar-back skill is selected
     */
    public boolean skillBarbackSelectedYes() {
        return elementExists(profilePageLocators.skillsBarBackTxt);
    }

    /**
     * Checks to see if the Barista skill is selected
     */
    public boolean skillBaristaSelectedYes() {
        return elementExists(profilePageLocators.skillsBaristaTxt);
    }

    /**
     * Checks to see if the bartender skill is selected
     */
    public boolean skillBartenderSelectedYes() {
        return elementExists(profilePageLocators.skillsBartenderTxt);
    }

    /**
     * Checks to see if the Busser skill is selected
     */
    public boolean skillBusserSelectedYes() {
        return elementExists(profilePageLocators.skillsBusserTxt);
    }

    /**
     * Checks to see if the Cashier skill is selected
     */
    public boolean skillCashierSelectedYes() {
        return elementExists(profilePageLocators.skillsCashierTxt);
    }

    /**
     * Checks to see if the Chef skill is selected
     */
    public boolean skillChefSelectedYes() {
        return elementExists(profilePageLocators.skillsChefTxt);
    }

    /**
     * Checks to see if the Cook skill is selected
     */
    public boolean skillCookSelectedYes() {
        return elementExists(profilePageLocators.skillsCookTxt);
    }

    /**
     * Checks to see if the Crew skill is selected
     */
    public boolean skillCrewSelectedYes() {
        return elementExists(profilePageLocators.skillsCrewTxt);
    }

    /**
     * Checks to see if the Dishhwasher skill is selected
     */
    public boolean skillDishwasherSelectedYes() {
        return elementExists(profilePageLocators.skillsDishwasherTxt);
    }

    /**
     * Checks to see if the Driver skill is selected
     */
    public boolean skillDriverSelectedYes() {
        return elementExists(profilePageLocators.skillsDriverTxt);
    }

    /**
     * Checks to see if the Drive-thru skill is selected
     */
    public boolean skillDrivethruSelectedYes() {
        return elementExists(profilePageLocators.skillsDriveThruTxt);
    }

    /**
     * Checks to see if the Host skill is selected
     */
    public boolean skillHostSelectedYes() {
        return elementExists(profilePageLocators.skillsHostTxt);
    }

    /**
     * Checks to see if the Manager skill is selected
     */
    public boolean skillManagerSelectedYes() {
        return elementExists(profilePageLocators.skillsManagerTxt);
    }

    /**
     * Checks to see if the Prep Cook skill is selected
     */
    public boolean skillPrepCookSelectedYes() {
        return elementExists(profilePageLocators.skillsPrepCookTxt);
    }

    /**
     * Checks to see if the Runner skill is selected
     */
    public boolean skillRunnerSelectedYes() {
        return elementExists(profilePageLocators.skillsRunnerTxt);
    }

    /**
     * Checks to see if the Server skill is selected
     */
    public boolean skillServerSelectedYes() {
        return elementExists(profilePageLocators.skillsServerTxt);
    }

    /**
     * Checks to see if the Sommelier skill is selected
     */
    public boolean skillSommelierSelectedYes() {
        return elementExists(profilePageLocators.skillsSommelierTxt);
    }

    /**
     * Checks to see if the Sous Chef skill is selected
     */
    public boolean skillSousChefSelectedYes() {
        return elementExists(profilePageLocators.skillsSousChefTxt);
	}

    /**
     * Checks to see if the TeamMember skill is selected
     */
    public boolean skillTeamMemberSelectedYes() {
        return elementExists(profilePageLocators.skillsTeamMemberTxt);
    }

    /**
     * Checks to see if the Trainer skill is selected
     */
    public boolean skillTrainerSelectedYes() {
        return elementExists(profilePageLocators.skillsTrainerTxt);
    }

    /**
     * Checks to see if the selected skills match what is on the view profile screen
     * @return Whether or not the selected skills are on the page
     */
    public boolean verifySelectedSkills( ) {
        return skillBakerSelectedYes() &&
                skillBarbackSelectedYes() &&
                skillBaristaSelectedYes() &&
                skillBartenderSelectedYes() &&
                skillBusserSelectedYes() &&
                skillCashierSelectedYes() &&
                skillChefSelectedYes() &&
                skillCookSelectedYes() &&
                skillCrewSelectedYes() &&
                skillDishwasherSelectedYes() &&
                skillDriverSelectedYes() &&
                skillDrivethruSelectedYes() &&
                skillHostSelectedYes() &&
                skillManagerSelectedYes() &&
                skillPrepCookSelectedYes() &&
                skillRunnerSelectedYes() &&
                skillServerSelectedYes() &&
                skillSommelierSelectedYes() &&
                skillSousChefSelectedYes() &&
                skillTeamMemberSelectedYes() &&
                skillTrainerSelectedYes();
    }

    /**
     * Checks for empty skills text on the user's profile
     * @return Whether or not a user has empty skills text on their profile
     */
    public boolean isEmptySkillsTxtStatePresent() {
        driver.findElement(profilePageLocators.emptySkillsTxt);
        return driver.findElement(profilePageLocators.emptySkillsTxt).isDisplayed();
    }

    /**
     * Resets skills to a known (blank) state
     */
    public void resetSkills() {
        if (elementExists(profilePageLocators.editSkillsBtn)) {
            clickEditSkills();
            skillsPage.removeAllSkills();
            clickBackBtn();
        }
    }

    /*---------- Utility Methods ----------*/

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

}
