import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProfilePage extends BasePage {

    Locators.ProfilePageLocators profilePageLocators = new Locators.ProfilePageLocators();

    public ProfilePage(WebDriver driver) {
        super(driver);
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
     * @param aboutTxt The text you're expecting to be on the page
     * @return Whether or not the text is on the page
     */
    public boolean verifyAboutTxt(String aboutTxt) {
        return aboutTxt.equals(driver.findElement(profilePageLocators.aboutTxtField).getText());
    }

    /**
     * Checks for about text on the user's profile
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
     * @return Whether or not the age question is answered yes
     */
    public boolean basicInfoAgeQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoAgeYesBtn);
    }

    /**
     * Checks to see if the transport question is answered yes on the view profile page
     * @return Whether or not the transport question is answered yes
     */
    public boolean basicInfoTransportQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoTransportYesBtn);
    }

    /**
     * Checks to see if the legal question is answered yes on the view profile page
     * @return Whether or not the legal question is answered yes
     */
    public boolean basicInfoLegalQuestionAnsweredYes() {
        return elementExists(profilePageLocators.basicInfoLegalYesBtn);
    }

    /**
     * Checks to see if all basic info questions are answered yes on the view profile page
     * @return Whether or not all basic info questions are answered yes
     */
    public boolean basicInfoQuestionsAnsweredYes() {
        return basicInfoAgeQuestionAnsweredYes() &&
                basicInfoTransportQuestionAnsweredYes() &&
                basicInfoLegalQuestionAnsweredYes();
    }

    /**
     * Checks to see if the age question is answered yes no the view profile page
     * @return Whether or not the age question is answered no
     */
    public boolean basicInfoAgeQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoAgeNoBtn);
    }

    /**
     * Checks to see if the transport question is answered no on the view profile page
     * @return Whether or not the transport question is answered no
     */
    public boolean basicInfoTransportQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoTransportNoBtn);
    }

    /**
     * Checks to see if the legal question is answered no on the view profile page
     * @return Whether or not the legal question is answered no
     */
    public boolean basicInfoLegalQuestionAnsweredNo() {
        return elementExists(profilePageLocators.basicInfoLegalNoBtn);
    }

    /**
     * Checks to see if all basic info questions are answered yes on the view profile page
     * @return Whether or not all basic info questions are answered yes
     */
    public boolean basicInfoQuestionsAnsweredNo() {
        return basicInfoAgeQuestionAnsweredNo() &&
                basicInfoTransportQuestionAnsweredNo() &&
                basicInfoLegalQuestionAnsweredNo();
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
