package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import utils.Locators;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class EmployerFindTalentPage extends BasePage {

    Locators.EmployerTalentPageLocators talentPageLocators;
    TestUtils testUtils;

    public EmployerFindTalentPage(WebDriver driver) {
        super(driver);
        talentPageLocators = new Locators.EmployerTalentPageLocators();
        testUtils = new TestUtils(driver);
    }

    /*--------- Talent (All, Invited, Good, Bad) ----------*/

    /**
     * Gets the employer All talent section title text
     * @return The employer All talent section title text
     */
    public String getEmployerTalentAllTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentAllTitleTxt).getText();
    }

    /**
     * Gets the employer Good talent section title text
     * @return The employer Good talent section title text
     */
    public String getEmployerTalentGoodTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentGoodTitleTxt).getText();
    }

    /**
     * Gets the employer Invited talent section title text
     * @return The employer Invited talent section title text
     */
    public String getEmployerTalentInvitedTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentInvitedTitleTxt).getText();
    }

    /**
     * Gets the employer Applicant talent section title text
     * @return The employer Applicant talent section title text
     */
    public String getEmployerTalentApplicantsTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsTitleTxt).getText();
    }

    /**
     * Gets the employer Bad talent section title text
     * @return The employer Bad talent section title text
     */
    public String getEmployerTalentBadTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentBadTitleTxt).getText();
    }

    /**
     * Gets the employer All talent empty title text
     * @return The employer All talent empty title text
     */
    public String getEmployerTalentAllEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentAllEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer All talent empty text
     * @return The employer All talent empty text
     */
    public String getEmployerTalentAllEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentAllEmptyTxt).getText();
    }

    /**
     * Gets the employer Good talent empty title text
     * @return The employer Good talent empty title text
     */
    public String getEmployerTalentGoodEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentGoodEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Good talent empty text
     * @return The employer Good talent empty text
     */
    public String getEmployerTalentGoodlEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentGoodEmptyTxt).getText();
    }

    /**
     * Gets the employer Invited talent empty title text
     * @return The employer Invited talent empty title text
     */
    public String getEmployerTalentInvitedEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentInvitedEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Invited talent empty text
     * @return The employer Invited talent empty text
     */
    public String getEmployerTalentInvitedlEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentInvitedEmptyTxt).getText();
    }

    /**
     * Gets the employer Applicants talent empty title text
     * @return The employer Applicants talent empty title text
     */
    public String getEmployerTalentApplicantsEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Applicants talent empty text
     * @return The employer Applicants talent empty text
     */
    public String getEmployerTalentApplicantsEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTxt).getText();
    }

    /**
     * Gets the employer Bad talent empty title text
     * @return The employer Bad talent empty title text
     */
    public String getEmployerTalentBadEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentBadEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Bad talent empty text
     * @return The employer Bad talent empty text
     */
    public String getEmployerTalentBadEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentBadEmptyTxt).getText();
    }

    /**
     * Checks to see if a talent card is displayed
     * @param index The index of the talent card (starting at 0)
     * @return Whether or not a talent card is displayed
     */
    public Boolean isTalentCardDisplayed(String index){
        return elementExists(talentPageLocators.findEmployerTalentCardByIndex(index));
    }

    /**
     * Checks to see if an talent card's photo is displayed
     * @param index The index of the talent card's photo (starting at 0)
     * @return Whether or not a talent card's photo is displayed
     */
    public Boolean isTalentCardPhotoDisplayed(String index){
        return elementExists(talentPageLocators.findEmployerTalentCardPhotoByIndex(index));
    }

    /**
     * Gets the talent name
     *
     * @param index The index of the talent's name (starting at 0)
     * @return The talent's name
     */
    public String getTalentName(String index){
        return driver.findElement(talentPageLocators.findEmployerTalentCardNameByIndex(index)).getText();
    }

    /**
     * Gets the talent's location
     *
     * @param index The index of the talent's location (starting at 0)
     * @return The talent's location
     */
    public String getTalentLocation(String index){
        return driver.findElement(talentPageLocators.findEmployerTalentCardLocationByIndex(index)).getText();
    }

    /**
     * Gets the talent's position
     *
     * @param index The index of the talent's position (starting at 0)
     * @return The talent's position
     */
    public String getTalentPosition(String index){
        return driver.findElement(talentPageLocators.findEmployerTalentCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the talent's shared connections
     *
     * @param index The index of the talent's shared connections (starting at 0)
     * @return The talent's shared connections
     */
    public String getTalentSharedConnections(String index) {
        try {
            if (driver.findElement(talentPageLocators.findEmployerTalentCardSharedConnectionsByIndex(index)).isDisplayed()) {
                return driver.findElement(talentPageLocators.findEmployerTalentCardSharedConnectionsByIndex(index)).getText();
            }
        } catch (NoSuchElementException e) {
            System.out.println("\n" + "User has no shared connections..." + "\n");
        }
        return null;
    }

    /**
     * Select the talent's view profile button
     * @param index The index of the talent's view profile button (starting at 0)
     */
    public void selectTalentViewProfileBtn(String index){
        driver.findElement(talentPageLocators.findEmployerTalentCardViewProfileByIndex(index)).click();
    }

    /**
     * Select the talent's actions button
     * @param index The index of the talent's actions button (starting at 0)
     */
    public void selectTalentActionsBtn(String index){
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsByIndex(index)).click();
    }

    /**
     * Select the talent's invite button
     * @param index The index of the talent's invite button (starting at 0)
     */
    public void selectTalentActionsInviteBtn(String index){
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsInviteByIndex(index)).click();
    }

    /**
     * Gets the talent invite modal title text
     * @return The talent invite modal title text
     */
    public String getTalentInviteModalTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentInviteTitleTxt).getText();
    }

    /**
     * Select the talent invite to position dropdown button
     */
    public void selectTalentInviteToPositionDropdown(){
        driver.findElement(talentPageLocators.employerTalentInviteSelectPositionBtn).click();
    }

    /**
     * Select the talent invite to position job
     * @param index The index of the job (starting at 0) to select from the dropdown
     */
    public void selectTalentInviteToPositionBtn(String index){
        driver.findElement(talentPageLocators.findEmployerTalentInvitePositionByIndex(index)).click();
    }

    /**
     * Selects the dropdown and selects a position from the dropdown to invite
     * @param index The index of the job (starting at 0) to select from the dropdown
     */
    public void selectTalentInviteToPosition(String index){
        selectTalentInviteToPositionDropdown();
        selectTalentInviteToPositionBtn(index);
    }

    /**
     * Gets the talent invite to position job name text
     * @return The talent invite to position job name text
     */
    public String getTalentInviteToPositionJobNameTxt(){
        return driver.findElement(talentPageLocators.employerTalentInviteModalPositionTxt).getText();
    }

    /**
     * Gets the talent invite modal message text
     * @return The talent invite modal message text
     */
    public String getTalentInviteModalMessageTxt(){
        return driver.findElement(talentPageLocators.employerTalentInviteModalMessageTxt).getText();
    }

    /**
     * Select the talent invite send invitation button
     */
    public void selectTalentInviteSendInvitationBtn(){
        driver.findElement(talentPageLocators.employerTalentInviteModalSendBtn).click();
        waitForInviteLoadingIndicator();
    }

    /**
     * Waits for the invite to apply loading indicator
     */
    public void waitForInviteLoadingIndicator() {
        try {
            if (driver.findElement(talentPageLocators.employerTalentInviteLoader).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(talentPageLocators.employerTalentInviteLoader));
            }
        } catch (NoSuchElementException e) {
            System.out.println("\n" + "Loading indicator not displayed due to NoSuchElementException..." + "\n***");
        } catch (StaleElementReferenceException se) {
            System.out.println("\n" +"Loading indicator not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }

    /**
     * Gets the talent invited modal title text
     * @return The talent invited modal title text
     */
    public String getTalentInvitedModalTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentInvitedModalTitleTxt).getText();
    }

    /**
     * Gets the talent invited modal text
     * @return The talent invited modal text
     */
    public String getTalentInvitedModalTxt(){
        return driver.findElement(talentPageLocators.employerTalentInvitedModalTxt).getText();
    }

    /**
     * Select the talent invited done button
     */
    public void selectTalentInvitedDoneBtn(){
        driver.findElement(talentPageLocators.employerTalentInvitedModalDoneBtn).click();
    }

    /**
     * Select the talent's good fit button
     * @param index The index of the talent's good fit button (starting at 0)
     */
    public void selectTalentActionsGoodFitBtn(String index){
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the talent's bad fit button
     * @param index The index of the talent's bad fit button (starting at 0)
     */
    public void selectTalentActionsBadFitBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsBadFitByIndex(index)).click();
    }

    /**
     * Checks to see if the talent success toast is visible
     *
     * @param index the index (starting at 0) of the talent card
     * @return Whether or not the talent success toast is visible
     */
    public boolean verifyTalentSuccessToast(String index){
        wait.until(visibilityOfElementLocated(talentPageLocators.findEmployerTalentSuccessToastByIndex(index)));
        return elementExists(talentPageLocators.findEmployerTalentSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the talent success toast
     * @param index the index (starting at 0) of the talent card
     */
    public void dismissTalentSuccessToast(String index){
        wait.until(elementToBeClickable(talentPageLocators.findEmployerTalentSuccessToastCloseBtnByIndex(index)));
        driver.findElement(talentPageLocators.findEmployerTalentSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.findEmployerTalentSuccessToastByIndex(index)));
    }

    /*--------- Applicants ----------*/

    /**
     * Gets the employer applicants section title text
     * @return The employer applicants section title text
     */
    public String getEmployerApplicantsTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsTitleTxt).getText();
    }

    /**
     * Gets the employer applicants empty title text
     * @return The employer applicants empty title text
     */
    public String getEmployerApplicantsEmptyTitleTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer applicants empty text
     * @return The employer applicants empty text
     */
    public String getEmployerApplicantsEmptyTxt(){
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTxt).getText();
    }

    /**
     * Checks to see if an Applicant card is displayed
     * @param index The index of the applicant card (starting at 0)
     * @return Whether or not an applicant's card is displayed
     */
    public Boolean isApplicantCardDisplayed(String index){
        return elementExists(talentPageLocators.findEmployerApplicantCardByIndex(index));
    }

    /**
     * Checks to see if an Applicant card's photo is displayed
     * @param index The index of the applicant card's photo (starting at 0)
     * @return Whether or not an applicant's card's photo is displayed
     */
    public Boolean isApplicantCardPhotoDisplayed(String index){
        return elementExists(talentPageLocators.findEmployerApplicantCardPhotoByIndex(index));
    }

    /**
     * Gets the applicant's name
     *
     * @param index The index of the applicant's name (starting at 0)
     * @return The applicant's name
     */
    public String getApplicantName(String index){
        return driver.findElement(talentPageLocators.findEmployerApplicantCardNameByIndex(index)).getText();
    }

    /**
     * Gets the applicant's applied position
     *
     * @param index The index of the applicant's applied position (starting at 0)
     * @return The applicant's applied position
     */
    public String getApplicantPosition(String index){
        return driver.findElement(talentPageLocators.findEmployerApplicantCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the applicant's applied time
     *
     * @param index The index of the applicant's applied time (starting at 0)
     * @return The applicant's applied time
     */
    public String getApplicantTime(String index){
        return driver.findElement(talentPageLocators.findEmployerApplicantCardAppliedTimeAgoByIndex(index)).getText();
    }

    /**
     * Select the applicant's view profile button
     * @param index The index of the applicant's view profile button (starting at 0)
     */
    public void selectApplicantViewProfileBtn(String index){
        driver.findElement(talentPageLocators.findEmployerApplicantCardViewProfileByIndex(index)).click();
    }

    /**
     * Select the applicant's actions button
     * @param index The index of the applicant's actions button (starting at 0)
     */
    public void selectApplicantActionsBtn(String index){
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsByIndex(index)).click();
    }

    /**
     * Select the applicant's good fit button
     * @param index The index of the applicant's good fit button (starting at 0)
     */
    public void selectApplicantGoodFitBtn(String index){
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the applicant's bad fit button
     * @param index The index of the applicant's bad fit button (starting at 0)
     */
    public void selectApplicantBadFitBtn(String index){
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsBadFitByIndex(index)).click();
    }

    /**
     * Select the applicant's message button
     * @param index The index of the applicant's message button (starting at 0)
     */
    public void selectApplicantMessageBtn(String index){
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsMessageByIndex(index)).click();
    }

    /**
     * Gets the applicant's shared connections count
     *
     * @param index The index of the applicant's shared connection count (starting at 0)
     * @return The applicant's name shared connection count
     */
    public String getApplicantSharedConnections(String index){
        return driver.findElement(talentPageLocators.findEmployerApplicantCardSharedConnectionsByIndex(index)).getText();
    }

    /**
     * Checks to see if the applicant success toast is visible
     *
     * @param index the index (starting at 0) of the applicant card
     * @return Whether or not the applicant success toast is visible
     */
    public boolean verifyApplicantSuccessToast(String index){
        wait.until(visibilityOfElementLocated(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index)));
        return elementExists(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the applicant success toast
     * @param index the index (starting at 0) of the applicant card
     */
    public void dismissApplicantSuccessToast(String index){
        wait.until(elementToBeClickable(talentPageLocators.findEmployerApplicantSuccessToastCloseBtnByIndex(index)));
        driver.findElement(talentPageLocators.findEmployerApplicantSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index)));
    }

    /*---------- Utility Methods ----------*/

    /**
     * Selects the 'All talent' tab
     */
    public void selectTalentAllTab(){
        wait.until(elementToBeClickable(talentPageLocators.employerTalentAllBtn));
        driver.findElement(talentPageLocators.employerTalentAllBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Good fit talent' tab
     */
    public void selectTalentGoodTab(){
        wait.until(elementToBeClickable(talentPageLocators.employerTalentGoodBtn));
        driver.findElement(talentPageLocators.employerTalentGoodBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Invited to Apply' tab
     */
    public void selectTalentInvitedTab(){
        wait.until(elementToBeClickable(talentPageLocators.employerTalentInviteBtn));
        driver.findElement(talentPageLocators.employerTalentInviteBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Applicants' tab
     */
    public void selectTalentApplicantsTab(){
        wait.until(elementToBeClickable(talentPageLocators.employerTalentAppliantsBtn));
        driver.findElement(talentPageLocators.employerTalentAppliantsBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Not a fit' tab
     */
    public void selectTalentBadTab(){
        wait.until(elementToBeClickable(talentPageLocators.employerTalentBadBtn));
        driver.findElement(talentPageLocators.employerTalentBadBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Waits for the loading indicator on the Find Talent page
     */
    public void waitForLoadingIndicator() {
        try {
            if (driver.findElement(talentPageLocators.employerTalentLoader).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(talentPageLocators.employerTalentLoader));
            }
        } catch (NoSuchElementException e) {
            System.out.println("\n" + "Loading indicator not displayed due to NoSuchElementException..." + "\n");
        } catch (StaleElementReferenceException se) {
            System.out.println("\n" +"Loading indicator not displayed due to StaleElementReferenceException..." + "\n");
        }
    }
}
