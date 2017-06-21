import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BasicInfoPage extends BasePage {

    Locators.BasicInfoPageLocators basicInfoPageLocators;
    Locators.ProfilePageLocators profilePageLocators;

    public BasicInfoPage(WebDriver driver) {
        super(driver);
        basicInfoPageLocators = new Locators.BasicInfoPageLocators();
        profilePageLocators = new Locators.ProfilePageLocators();
    }

    /**
     * Clicks on the yes button for age if the question hasn't been answered or if the no button is selected
     */
    public void clickYesBtnForAge() {
        wait.until(elementToBeClickable(basicInfoPageLocators.ageYesBtn));
        driver.findElement(basicInfoPageLocators.ageYesBtn).click();
    }

    /**
     * Clicks on the no button for age if the question hasn't been answered or if the yes button is selected
     */
    public void clickNoBtnForAge() {
        wait.until(elementToBeClickable(basicInfoPageLocators.ageNoBtn));
        driver.findElement(basicInfoPageLocators.ageNoBtn).click();
    }

    /**
     * Clicks on the yes button for the reliable transportation question if it hasn't been answered or if the no button is selected
     */
    public void clickYesBtnForTransport() {
        wait.until(elementToBeClickable(basicInfoPageLocators.transportYesBtn));
        driver.findElement(basicInfoPageLocators.transportYesBtn).click();
    }

    /**
     * Clicks on the no button for the reliable transportation question if it hasn't been answered or if the yes button is selected
     */
    public void clickNoBtnForTransport() {
        wait.until(elementToBeClickable(basicInfoPageLocators.transportNoBtn));
        driver.findElement(basicInfoPageLocators.transportNoBtn).click();
    }

    /**
     * Clicks on the yes button for the legal to work in us question if it hasn't been answered or no is selected
     */
    public void clickYesBtnForLegal() {
        wait.until(elementToBeClickable(basicInfoPageLocators.legalYesBtn));
        driver.findElement(basicInfoPageLocators.legalYesBtn).click();
    }

    /**
     * Clicks on the no button for the legal to work in us question if it hasn't been answered or no is selected
     */
    public void clickNoBtnForLegal() {
        wait.until(elementToBeClickable(basicInfoPageLocators.legalNoBtn));
        driver.findElement(basicInfoPageLocators.legalNoBtn).click();
    }

    /**
     * Clicks the save button on the basic info page.
     */
    public void clickSaveBtn() {
        wait.until(elementToBeClickable(basicInfoPageLocators.saveBtn));
        driver.findElement(basicInfoPageLocators.saveBtn).click();
    }

    /**
     * Clicks the back button to take the user to the view profile page
     */
    public void clickBackBtn() {
        wait.until(elementToBeClickable(profilePageLocators.profileBackBtn));
        driver.findElement(profilePageLocators.profileBackBtn).click();
    }

    /**
     * Checks to see if the age question has been answered by checking to see if the yes and no buttons are in the selected state
     *
     * @return Whether or not the age question has been answered
     */
    public boolean isAgeQuestionAnswered() {
        return isAgeQuestionAnsweredYes() || isAgeQuestionAnsweredNo();
    }

    /**
     * Checks to see if the reliable transportation question has been answered by checking to see if the yes and no buttons are in the selected state
     *
     * @return Whether or not the reliable transportation question has been answered
     */
    public boolean isTransportQuestionAnswered() {
        return isTransportQuestionAnsweredYes() || isTransportQuestionAnsweredNo();
    }

    /**
     * Checks to see if the legal to work in the us question has been answered by checking to see if the yes and no buttons are in the selected state
     *
     * @return Whether or not the legal to work in the us question has been answered
     */
    public boolean isLegalQuestionAnswered() {
        return isLegalQuestionAnsweredYes() || isLegalQuestionAnsweredNo();
    }

    /**
     * Checks to see if the age question has been answered with a yes
     *
     * @return Whether or not the age question has been answered yes
     */
    public boolean isAgeQuestionAnsweredYes() {
        return elementExists(basicInfoPageLocators.ageYesBtnSelected);
    }

    /**
     * Checks to see if the transport question has been answered with a yes
     *
     * @return Whether or not the transport question has been answered yes
     */
    public boolean isTransportQuestionAnsweredYes() {
        return elementExists(basicInfoPageLocators.transportYesBtnSelected);
    }

    /**
     * Checks to see if the legal question has been answered with a yes
     *
     * @return Whether or not the legal question has been answered yes
     */
    public boolean isLegalQuestionAnsweredYes() {
        return elementExists(basicInfoPageLocators.legalYesBtnSelected);
    }

    /**
     * Checks to see if the age question has been answered with a no
     *
     * @return Whether or not the age question has been answered no
     */
    public boolean isAgeQuestionAnsweredNo() {
        return elementExists(basicInfoPageLocators.ageNoBtnSelected);
    }

    /**
     * Checks to see if the transport question has been answered with a no
     *
     * @return Whether or not the transport question has been answered no
     */
    public boolean isTransportQuestionAnsweredNo() {
        return elementExists(basicInfoPageLocators.transportNoBtnSelected);
    }

    /**
     * Checks to see if the legal question has been answered with a no
     *
     * @return Whether or not the legal question has been answered no
     */
    public boolean isLegalQuestionAnsweredNo() {
        return elementExists(basicInfoPageLocators.legalNoBtnSelected);
    }

    /**
     * Checks to see if all questions haven't been answered by checking to see if the yes and no buttons are in a selected state
     *
     * @return Whether or not all questions are unanswered
     */
    public boolean areAllQuestionsNotAnswered() {
        if(isAgeQuestionAnswered() && isTransportQuestionAnswered() && isLegalQuestionAnswered()) {
            return false;
        }

        return true;
    }

    /**
     * Checks to see if all questions have been answered by checking to see if the yes and no buttons are in a selected state
     *
     * @return Whether or not all questions are answered
     */
    public boolean areAllQuestionsAnswered() {
        if(isAgeQuestionAnswered() && isTransportQuestionAnswered() && isLegalQuestionAnswered()) {
            return true;
        }

        return false;
    }

    /**
     * Checks to see if all questions have been answered with yes by checked to see if the buttons are in a selected yes state
     *
     * @return Whether or not all questions have been answered with yes
     */
    public boolean areAllQuestionsAnsweredYes() {
        if(isAgeQuestionAnsweredYes() && isTransportQuestionAnsweredYes() && isLegalQuestionAnsweredYes()) {
            return true;
        }

        return false;
    }

    /**
     * Checks to see if all questions have been answered with no by checked to see if the buttons are in a selected no state
     *
     * @return Whether or not all questions have been answered with no
     */
    public boolean areAllQuestionsAnsweredNo() {
        if(isAgeQuestionAnsweredNo() && isTransportQuestionAnsweredNo() && isLegalQuestionAnsweredNo()) {
            return true;
        }

        return false;
    }
}
