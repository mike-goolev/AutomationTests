import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProfilePage extends BasePage {

    Locators.ProfilePageLocators profilePageLocators = new Locators.ProfilePageLocators();
    SkillsPage skillsPage;

    public ProfilePage(WebDriver driver) {
        super(driver);
        skillsPage = new SkillsPage(driver);
    }

    /*--------- Availability ----------*/

    /**
     * Clicks the add availability button when a user does NOT have availability
     */
    public void clickAddAvailability() {
        wait.until(elementToBeClickable(profilePageLocators.addAvailabilityBtn));
        driver.findElement(profilePageLocators.addAvailabilityBtn).click();
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
        return elementExists(profilePageLocators.skill0);
    }

    /**
     * Checks to see if the Bar-back skill is selected
     */
    public boolean skillBarbackSelectedYes() {
        return elementExists(profilePageLocators.skill1);
    }

    /**
     * Checks to see if the Barista skill is selected
     */
    public boolean skillBaristaSelectedYes() {
        return elementExists(profilePageLocators.skill2);
    }

    /**
     * Checks to see if the bartender skill is selected
     */
    public boolean skillBartenderSelectedYes() {
        return elementExists(profilePageLocators.skill3);
    }

    /**
     * Checks to see if the Busser skill is selected
     */
    public boolean skillBusserSelectedYes() {
        return elementExists(profilePageLocators.skill4);
    }

    /**
     * Checks to see if the Cashier skill is selected
     */
    public boolean skillCashierSelectedYes() {
        return elementExists(profilePageLocators.skill5);
    }

    /**
     * Checks to see if the Chef skill is selected
     */
    public boolean skillChefSelectedYes() {
        return elementExists(profilePageLocators.skill6);
    }

    /**
     * Checks to see if the Cook skill is selected
     */
    public boolean skillCookSelectedYes() {
        return elementExists(profilePageLocators.skill7);
    }

    /**
     * Checks to see if the Crew skill is selected
     */
    public boolean skillCrewSelectedYes() {
        return elementExists(profilePageLocators.skill8);
    }

    /**
     * Checks to see if the Dishhwasher skill is selected
     */
    public boolean skillDishwasherSelectedYes() {
        return elementExists(profilePageLocators.skill9);
    }

    /**
     * Checks to see if the Driver skill is selected
     */
    public boolean skillDriverSelectedYes() {
        return elementExists(profilePageLocators.skill10);
    }

    /**
     * Checks to see if the Drive-thru skill is selected
     */
    public boolean skillDrivethruSelectedYes() {
        return elementExists(profilePageLocators.skill11);
    }

    /**
     * Checks to see if the Host skill is selected
     */
    public boolean skillHostSelectedYes() {
        return elementExists(profilePageLocators.skill12);
    }

    /**
     * Checks to see if the Manager skill is selected
     */
    public boolean skillManagerSelectedYes() {
        return elementExists(profilePageLocators.skill13);
    }

    /**
     * Checks to see if the Prep Cook skill is selected
     */
    public boolean skillPrepCookSelectedYes() {
        return elementExists(profilePageLocators.skill14);
    }

    /**
     * Checks to see if the Runner skill is selected
     */
    public boolean skillRunnerSelectedYes() {
        return elementExists(profilePageLocators.skill15);
    }

    /**
     * Checks to see if the Server skill is selected
     */
    public boolean skillServerSelectedYes() {
        return elementExists(profilePageLocators.skill16);
    }

    /**
     * Checks to see if the Sommelier skill is selected
     */
    public boolean skillSommelierSelectedYes() {
        return elementExists(profilePageLocators.skill17);
    }

    /**
     * Checks to see if the Sous Chef skill is selected
     */
    public boolean skillSousChefSelectedYes() {
        return elementExists(profilePageLocators.skill18);
    }

    /**
     * Checks to see if the TeamMember skill is selected
     */
    public boolean skillTeamMemberSelectedYes() {
        return elementExists(profilePageLocators.skill19);
    }

    /**
     * Checks to see if the Trainer skill is selected
     */
    public boolean skillTrainerSelectedYes() {
        return elementExists(profilePageLocators.skill20);
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
