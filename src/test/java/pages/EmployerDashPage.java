package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.interactions.Actions;
import utils.Locators;
import utils.TestUtils;

public class EmployerDashPage extends BasePage {

    Locators.EmployerDashPageLocators dashPageLocators;
    TestUtils testUtils;

    public EmployerDashPage(WebDriver driver) {
        super(driver);
        dashPageLocators = new Locators.EmployerDashPageLocators();
        testUtils = new TestUtils(driver);
    }

    /**
     * Gets the employer Dashboard title text
     * @return The employer Dashboard title text
     */
    public String getEmployerDashTitleTxt(){
        return driver.findElement(dashPageLocators.employerDashTitleTxt).getText();
    }

    /*--------- Applicants ----------*/

    /**
     * Gets the employer Dashboard applicants section title text
     * @return The employer Dashboard applicants section title text
     */
    public String getEmployerDashApplicantsTitleTxt(){
        return driver.findElement(dashPageLocators.employerDashApplicantsTitleTxt).getText();
    }

    /**
     * Gets the employer Dashboard applicants empty title text
     * @return The employer Dashboard applicants empty title text
     */
    public String getEmployerDashApplicantsEmptyTitleTxt(){
        return driver.findElement(dashPageLocators.employerDashApplicantCardEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Dashboard applicants empty text
     * @return The employer Dashboard applicants empty text
     */
    public String getEmployerDashApplicantsEmptyTxt(){
        return driver.findElement(dashPageLocators.employerDashApplicantCardEmptyTxt).getText();
    }


    /**
     * Selects the edit store profile link from empty applicants card
     */
    public void selectEditStoreProfileLink(){
        driver.findElement(dashPageLocators.employerDashApplicantCardEditStoreProfileBtn).click();
    }

    /**
     * Selects the view applicant's link
     */
    public void selectApplicantViewLink(){
        driver.findElement(dashPageLocators.employerDashApplicantsLink).click();
    }

    /**
     * Selects the view more applicants button
     */
    public void selectApplicantNextBtn(){
        driver.findElement(dashPageLocators.employerDashApplicantNextBtn).click();
    }

    /**
     * Checks to see if an Applicant card is displayed
     * @param index The index of the applicant card (starting at 0)
     * @return Whether or not an applicant's card is displayed
     */
    public Boolean isApplicantCardDisplayed(String index){
        return elementExists(dashPageLocators.findEmployerDashApplicantCardByIndex(index));
    }

    /**
     * Checks to see if an Applicant card's photo is displayed
     * @param index The index of the applicant card's photo (starting at 0)
     * @return Whether or not an applicant's card's photo is displayed
     */
    public Boolean isApplicantCardPhotoDisplayed(String index){
        return elementExists(dashPageLocators.findEmployerDashApplicantCardPhotoByIndex(index));
    }

    /**
     * Gets the applicant's name
     *
     * @param index The index of the applicant's name (starting at 0)
     * @return The applicant's name
     */
    public String getApplicantName(String index){
        return driver.findElement(dashPageLocators.findEmployerDashApplicantCardNameByIndex(index)).getText();
    }

    /**
     * Gets the applicant's position
     *
     * @param index The index of the applicant's position (starting at 0)
     * @return The applicant's position
     */
    public String getApplicantPosition(String index){
        return driver.findElement(dashPageLocators.findEmployerDashApplicantCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the applicant's applied time
     *
     * @param index The index of the applicant's applied time (starting at 0)
     * @return The applicant's applied time
     */
    public String getApplicantTime(String index){
        return driver.findElement(dashPageLocators.findEmployerDashApplicantCardTimeByIndex(index)).getText();
    }

    /**
     * Select the applicant's view profile button
     * @param index The index of the applicant's view profile button (starting at 0)
     */
    public void selectApplicantViewProfileBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardViewProfileBtnByIndex(index)).click();
    }

    /**
     * Select the applicant's actions button
     * @param index The index of the applicant's actions button (starting at 0)
     */
    public void selectApplicantActionsBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardActionsBtnByIndex(index)).click();
    }

    /**
     * Select the applicant's interview button
     * @param index The index of the applicant's interview button (starting at 0)
     */
    public void selectApplicantInterviewBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardActionsInterviewByIndex(index)).click();
    }

    /**
     * Select the applicant's good fit button
     * @param index The index of the applicant's good fit button (starting at 0)
     */
    public void selectApplicantGoodFitBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the applicant's bad fit button
     * @param index The index of the applicant's bad fit button (starting at 0)
     */
    public void selectApplicantBadFitBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardActionsBadFitByIndex(index)).click();
    }

    /**
     * Select the applicant's message button
     * @param index The index of the applicant's message button (starting at 0)
     */
    public void selectApplicantMessageBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashApplicantCardActionsMessageByIndex(index)).click();
    }

    /**
     * Gets the applicant's shared connections count
     *
     * @param index The index of the applicant's shared connection count (starting at 0)
     * @return The applicant's name shared connection count
     */
    public String getApplicantSharedConnections(String index){
        return driver.findElement(dashPageLocators.findEmployerDashApplicantCardSharedConnectionsByIndex(index)).getText();
    }

    /**
     * Checks to see if the applicant success toast is visible
     *
     * @param index the index (starting at 0) of the applicant card
     * @return Whether or not the applicant success toast is visible
     */
    public boolean verifyApplicantSuccessToast(String index){
        wait.until(visibilityOfElementLocated(dashPageLocators.findEmployerDashApplicantSuccessToastByIndex(index)));
        return elementExists(dashPageLocators.findEmployerDashApplicantSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the applicant success toast
     * @param index the index (starting at 0) of the applicant card
     */
    public void dismissApplicantSuccessToast(String index){
        wait.until(elementToBeClickable(dashPageLocators.findEmployerDashApplicantSuccessToastCloseBtnByIndex(index)));
        driver.findElement(dashPageLocators.findEmployerDashApplicantSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(dashPageLocators.findEmployerDashApplicantSuccessToastByIndex(index)));
    }

    /*--------- Talent ----------*/

    /**
     * Gets the employer Dashboard talent section title text
     * @return The employer Dashboard talent section title text
     */
    public String getEmployerDashTalentTitleTxt(){
        WebElement talentSection = driver.findElement(dashPageLocators.employerDashTalentTitleTxt);
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", talentSection);
        return driver.findElement(dashPageLocators.employerDashTalentTitleTxt).getText();
    }

    /**
     * Checks to see if a talent title is displayed
     * @return Whether or not the talent title is displayed
     */
    public Boolean isTalentTitleDisplayed(){
        WebElement talentSection = driver.findElement(dashPageLocators.employerDashTalentTitleTxt);
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", talentSection);
        return elementExists(dashPageLocators.employerDashTalentTitleTxt);
    }



    /**
     * Gets the employer Dashboard talent empty title text
     * @return The employer Dashboard talent empty title text
     */
    public String getEmployerDashTalentEmptyTitleTxt(){
        WebElement talentSection = driver.findElement(dashPageLocators.employerDashApplicantCardEmptyTitleTxt);
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", talentSection);
        return driver.findElement(dashPageLocators.employerDashTalentCardEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Dashboard talent empty text
     * @return The employer Dashboard talent empty text
     */
    public String getEmployerDashTalentEmptyTxt(){
        return driver.findElement(dashPageLocators.employerDashTalentCardEmptyTxt).getText();
    }

    /**
     * Selects the post job link from empty talent card
     */
    public void selectPostJobLink(){

        driver.findElement(dashPageLocators.employerDashTalentCardPostJobBtn).click();
    }

    /**
     * Selects the view talent link
     */
    public void selectTalentViewLink(){

        driver.findElement(dashPageLocators.employerDashTalentLink).click();
    }

    /**
     * Selects the view more talent button
     */
    public void selectTalentNextBtn(){

        driver.findElement(dashPageLocators.employerDashTalentNextBtn).click();
    }

    /**
     * Checks to see if a talent card is displayed
     * @param index The index of the talent card (starting at 0)
     * @return Whether or not a talent card is displayed
     */
    public Boolean isTalentCardDisplayed(String index){
        return elementExists(dashPageLocators.findEmployerDashTalentCardByIndex(index));
    }

    /**
     * Checks to see if an talent card's photo is displayed
     * @param index The index of the talent card's photo (starting at 0)
     * @return Whether or not a talent card's photo is displayed
     */
    public Boolean isTalentCardPhotoDisplayed(String index){
        return elementExists(dashPageLocators.findEmployerDashTalentCardPhotoByIndex(index));
    }

    /**
     * Gets the talent name
     *
     * @param index The index of the talent's name (starting at 0)
     * @return The talent's name
     */
    public String getTalentName(String index){
        return driver.findElement(dashPageLocators.findEmployerDashTalentCardNameByIndex(index)).getText();
    }

    /**
     * Gets the talent's position
     *
     * @param index The index of the talent's position (starting at 0)
     * @return The talent's position
     */
    public String getTalentPosition(String index){
        return driver.findElement(dashPageLocators.findEmployerDashTalentCardPositionByIndex(index)).getText();
    }

    /**
     * Select the talent's view profile button
     * @param index The index of the talent's view profile button (starting at 0)
     */
    public void selectTalentViewProfileBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashTalentCardViewProfileByIndex(index)).click();
    }

    /**
     * Select the talent's actions button
     * @param index The index of the talent's actions button (starting at 0)
     */
    public void selectTalentActionsBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashTalentCardActionsByIndex(index)).click();
    }

    /**
     * Select the talent's invite button
     * @param index The index of the talent's invite button (starting at 0)
     */
    public void selectTalentInviteBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashTalentCardActionsInviteByIndex(index)).click();
    }

    /**
     * Select the talent's good fit button
     * @param index The index of the talent's good fit button (starting at 0)
     */
    public void selectTalentGoodFitBtn(String index){
        driver.findElement(dashPageLocators.findEmployerDashTalentCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the talent's bad fit button
     * @param index The index of the talent's bad fit button (starting at 0)
     */
    public void selectTalentBadFitBtn(String index) {
        driver.findElement(dashPageLocators.findEmployerDashTalentCardActionsBadFitByIndex(index)).click();
    }

    /**
     * Gets the employer Dashboard jobs empty title text
     * @return The employer Dashboard jobs empty title text
     */
    public String getEmployerDashJobsEmptyTitleTxt(){
        WebElement jobsSection = driver.findElement(dashPageLocators.employerDashJobsCardEmptyTitleTxt);
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", jobsSection);
        return driver.findElement(dashPageLocators.employerDashJobsCardEmptyTitleTxt).getText();
    }


    /**
     * Selects the create job link from empty jobs card
     */
    public void selectCreateJobLink(){
        driver.findElement(dashPageLocators.employerDashJobsCardPostJobBtn).click();
    }

    /**
     * Checks to see if the talent success toast is visible
     *
     * @param index the index (starting at 0) of the talent card
     * @return Whether or not the talent success toast is visible
     */
    public boolean verifyTalentSuccessToast(String index){
        wait.until(visibilityOfElementLocated(dashPageLocators.findEmployerDashTalentSuccessToastByIndex(index)));
        return elementExists(dashPageLocators.findEmployerDashTalentSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the talent success toast
     * @param index the index (starting at 0) of the talent card
     */
    public void dismissTalentSuccessToast(String index){
        wait.until(elementToBeClickable(dashPageLocators.findEmployerDashTalentSuccessToastCloseBtnByIndex(index)));
        driver.findElement(dashPageLocators.findEmployerDashTalentSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(dashPageLocators.findEmployerDashTalentSuccessToastByIndex(index)));
    }

    /*--------- Open Jobs ----------*/

    /**
     * Checks to see if the Open Jobs section header is displayed
     * @return Whether or not the Open Jobs section header is displayed
     */
    public Boolean isJobsTitleTextDisplayed(){
        WebElement jobsSection = driver.findElement(dashPageLocators.employerJobsTitleTxt);
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", jobsSection);
        return elementExists(dashPageLocators.employerJobsTitleTxt);
    }

    /**
     * Select the view jobs link
     */
    public void selectViewJobsLink(){
        driver.findElement(dashPageLocators.employerDashJobsViewLink).click();
    }

    /**
     * Gets the job position
     *
     * @param index The index of the job card's position (starting at 0)
     * @return The job position
     */
    public String getJobPosition(String index){
        return driver.findElement(dashPageLocators.findEmployerJobCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the job wage
     *
     * @param index The index of the job card's wage (starting at 0)
     * @return The job wage
     */
    public String getJobWage(String index){
        return driver.findElement(dashPageLocators.findEmployerJobCardWageByIndex(index)).getText();
    }

    /**
     * Gets the job availability
     *
     * @param index The index of the job card's availability (starting at 0)
     * @return The job availability
     */
    public String getJobAvailability(String index){
        return driver.findElement(dashPageLocators.findEmployerJobCardAvailabilityByIndex(index)).getText();
    }

    /**
     * Scroll to job cards
     * @param index the index of the job card to scroll to
     */
    public void scrollToJobCard(String index){
        WebElement jobCard = driver.findElement(dashPageLocators.findEmployerJobCardLogoByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", jobCard);
    }

    /**
     * Select the job's view button
     * @param index The index of the job card's view button (starting at 0)
     */
    public void selectJobViewBtn(String index){
        hoverOverJobAtPosition(index);
        driver.findElement(dashPageLocators.findEmployerJobCardPositionByIndex(index)).click();
    }

    /**
     * Select the job's edit button
     * @param index The index of the job card's edit button (starting at 0)
     */
    public void selectJobEditBtn(String index){
        hoverOverJobAtPosition(index);
        driver.findElement(dashPageLocators.findEmployerJobCardEditBtnByIndex(index)).click();
    }

    /**
     * Checks to see if the employer's logo is on the job card
     * @param index The index of the job card's logo (starting at 0)
     * @return Whether or not the employer's logo is on the job card
     */
    public boolean isJobCardEmployerLogoPresent(String index) {
        return elementExists(dashPageLocators.findEmployerJobCardLogoByIndex(index));
    }

    /**
     * Gets the job card employer name
     * @param index The index of the job card's employer name (starting at 0)
     * @return The job card's employer name
     */
    public String getJobCardEmployerNameAndAddress(String index){
        return driver.findElement(dashPageLocators.findEmployerJobCardNameAndAddressByIndex(index)).getText();
    }

    /*---------- Utility Methods ----------*/

    /**
     * Hover over Job Box at given position
     * @param index
     */
    public void hoverOverJobAtPosition(String index){
        WebElement jobsCard = driver.findElement(dashPageLocators.findEmployerJobCardLogoByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", jobsCard);
        Actions action = new Actions(driver);
        WebElement logo = driver.findElement(dashPageLocators.findEmployerJobCardLogoByIndex(index));
        action.moveToElement(logo).build().perform();
    }

    /**
     * Waits for the loading indicator on the Dash page
     */
    public void waitForLoadingIndicator() {
        try {
            if (driver.findElement(dashPageLocators.employerDashLoader).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(dashPageLocators.employerDashLoader));
            }
        } catch (NoSuchElementException e) {
            System.out.println("\n" + "Loading indicator not displayed due to NoSuchElementException..." + "\n");
        } catch (StaleElementReferenceException se) {
            System.out.println("\n" +"Loading indicator not displayed due to StaleElementReferenceException..." + "\n");
        }
    }
}
