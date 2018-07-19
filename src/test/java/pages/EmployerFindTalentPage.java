package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import utils.Locators;
import utils.TestUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
     *
     * @return The employer All talent section title text
     */
    public String getEmployerTalentAllTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentAllTitleTxt).getText();
    }

    /**
     * Gets the employer Good talent section title text
     *
     * @return The employer Good talent section title text
     */
    public String getEmployerTalentGoodTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentGoodTitleTxt).getText();
    }

    /**
     * Gets the employer Invited talent section title text
     *
     * @return The employer Invited talent section title text
     */
    public String getEmployerTalentInvitedTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentInvitedTitleTxt).getText();
    }

    /**
     * Gets the employer Applicant talent section title text
     *
     * @return The employer Applicant talent section title text
     */
    public String getEmployerTalentApplicantsTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsTitleTxt).getText();
    }

    /**
     * Gets the employer Bad talent section title text
     *
     * @return The employer Bad talent section title text
     */
    public String getEmployerTalentBadTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentBadTitleTxt).getText();
    }

    /**
     * Gets the employer All talent empty title text
     *
     * @return The employer All talent empty title text
     */
    public String getEmployerTalentAllEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentAllEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer All talent empty text
     *
     * @return The employer All talent empty text
     */
    public String getEmployerTalentAllEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentAllEmptyTxt).getText();
    }

    /**
     * Gets the employer Good talent empty title text
     *
     * @return The employer Good talent empty title text
     */
    public String getEmployerTalentGoodEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentGoodEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Good talent empty text
     *
     * @return The employer Good talent empty text
     */
    public String getEmployerTalentGoodlEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentGoodEmptyTxt).getText();
    }

    /**
     * Gets the employer Invited talent empty title text
     *
     * @return The employer Invited talent empty title text
     */
    public String getEmployerTalentInvitedEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentInvitedEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Invited talent empty text
     *
     * @return The employer Invited talent empty text
     */
    public String getEmployerTalentInvitedlEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentInvitedEmptyTxt).getText();
    }

    /**
     * Gets the employer Applicants talent empty title text
     *
     * @return The employer Applicants talent empty title text
     */
    public String getEmployerTalentApplicantsEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Applicants talent empty text
     *
     * @return The employer Applicants talent empty text
     */
    public String getEmployerTalentApplicantsEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTxt).getText();
    }

    /**
     * Gets the employer Bad talent empty title text
     *
     * @return The employer Bad talent empty title text
     */
    public String getEmployerTalentBadEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentBadEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer Bad talent empty text
     *
     * @return The employer Bad talent empty text
     */
    public String getEmployerTalentBadEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentBadEmptyTxt).getText();
    }

    /**
     * Checks to see if a talent card is displayed
     *
     * @param index The index of the talent card (starting at 0)
     * @return Whether or not a talent card is displayed
     */
    public Boolean isTalentCardDisplayed(String index) {
        return elementExists(talentPageLocators.findEmployerTalentCardByIndex(index));
    }

    /**
     * Checks to see if an talent card's photo is displayed
     *
     * @param index The index of the talent card's photo (starting at 0)
     * @return Whether or not a talent card's photo is displayed
     */
    public Boolean isTalentCardPhotoDisplayed(String index) {
        return elementExists(talentPageLocators.findEmployerTalentCardPhotoByIndex(index));
    }

    /**
     * Gets the talent name
     *
     * @param index The index of the talent's name (starting at 0)
     * @return The talent's name
     */
    public String getTalentName(String index) {
        wait.until(elementToBeClickable(talentPageLocators.findEmployerTalentCardNameByIndex(index)));
        return driver.findElement(talentPageLocators.findEmployerTalentCardNameByIndex(index)).getText();
    }

    /**
     * Gets the talent's location
     *
     * @param index The index of the talent's location (starting at 0)
     * @return The talent's location
     */
    public String getTalentLocation(String index) {
        return driver.findElement(talentPageLocators.findEmployerTalentCardLocationByIndex(index)).getText();
    }

    /**
     * Gets the talent's position
     *
     * @param index The index of the talent's position (starting at 0)
     * @return The talent's position
     */
    public String getTalentPosition(String index) {
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
     *
     * @param index The index of the talent's view profile button (starting at 0)
     */
    public void selectTalentViewProfileBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerTalentCardViewProfileByIndex(index)).click();
    }

    /**
     * Select the talent's actions button
     *
     * @param index The index of the talent's actions button (starting at 0)
     */
    public void selectTalentActionsBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsByIndex(index)).click();
    }

    /**
     * Select the talent's invite button
     *
     * @param index The index of the talent's invite button (starting at 0)
     */
    public void selectTalentActionsInviteBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsInviteByIndex(index)).click();
    }

    /**
     * Gets the talent invite modal title text
     *
     * @return The talent invite modal title text
     */
    public String getTalentInviteModalTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentInviteTitleTxt).getText();
    }

    /**
     * Select the talent invite to position dropdown button
     */
    public void selectTalentInviteToPositionDropdown() {
        driver.findElement(talentPageLocators.employerTalentInviteSelectPositionBtn).click();
    }

    /**
     * Select the talent invite to position job
     *
     * @param index The index of the job (starting at 0) to select from the dropdown
     */
    public void selectTalentInviteToPositionBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerTalentInvitePositionByIndex(index)).click();
    }

    /**
     * Selects the dropdown and selects a position from the dropdown to invite
     *
     * @param index The index of the job (starting at 0) to select from the dropdown
     */
    public void selectTalentInviteToPosition(String index) {
        selectTalentInviteToPositionDropdown();
        selectTalentInviteToPositionBtn(index);
    }

    /**
     * Gets the talent invite to position job name text
     *
     * @return The talent invite to position job name text
     */
    public String getTalentInviteToPositionJobNameTxt() {
        return driver.findElement(talentPageLocators.employerTalentInviteModalPositionTxt).getText();
    }

    /**
     * Gets the talent invite modal message text
     *
     * @return The talent invite modal message text
     */
    public String getTalentInviteModalMessageTxt() {
        return driver.findElement(talentPageLocators.employerTalentInviteModalMessageTxt).getText();
    }

    /**
     * Select the talent invite send invitation button
     */
    public void selectTalentInviteSendInvitationBtn() {
        driver.findElement(talentPageLocators.employerTalentInviteModalSendBtn).click();
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
            System.out.println("\n" + "Loading indicator not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }

    /**
     * Gets the talent invited modal title text
     *
     * @return The talent invited modal title text
     */
    public String getTalentInvitedModalTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentInvitedModalTitleTxt).getText();
    }

    /**
     * Gets the talent invited modal text
     *
     * @return The talent invited modal text
     */
    public String getTalentInvitedModalTxt() {
        return driver.findElement(talentPageLocators.employerTalentInvitedModalTxt).getText();
    }

    /**
     * Select the talent invited done button
     */
    public void selectTalentInvitedDoneBtn() {
        driver.findElement(talentPageLocators.employerTalentInvitedModalDoneBtn).click();
    }

    /**
     * Select the talent's good fit button
     *
     * @param index The index of the talent's good fit button (starting at 0)
     */
    public void selectTalentActionsGoodFitBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerTalentCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the talent's bad fit button
     *
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
    public boolean verifyTalentSuccessToast(String index) {
        wait.until(visibilityOfElementLocated(talentPageLocators.findEmployerTalentSuccessToastByIndex(index)));
        return elementExists(talentPageLocators.findEmployerTalentSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the talent success toast
     *
     * @param index the index (starting at 0) of the talent card
     */
    public void dismissTalentSuccessToast(String index) {
        wait.until(elementToBeClickable(talentPageLocators.findEmployerTalentSuccessToastCloseBtnByIndex(index)));
        driver.findElement(talentPageLocators.findEmployerTalentSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.findEmployerTalentSuccessToastByIndex(index)));
    }

    /*--------- Applicants ----------*/

    /**
     * Gets the employer applicants section title text
     *
     * @return The employer applicants section title text
     */
    public String getEmployerApplicantsTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsTitleTxt).getText();
    }

    /**
     * Gets the employer applicants empty title text
     *
     * @return The employer applicants empty title text
     */
    public String getEmployerApplicantsEmptyTitleTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTitleTxt).getText();
    }

    /**
     * Gets the employer applicants empty text
     *
     * @return The employer applicants empty text
     */
    public String getEmployerApplicantsEmptyTxt() {
        return driver.findElement(talentPageLocators.employerTalentApplicantsEmptyTxt).getText();
    }

    /**
     * Checks to see if an Applicant card is displayed
     *
     * @param index The index of the applicant card (starting at 0)
     * @return Whether or not an applicant's card is displayed
     */
    public Boolean isApplicantCardDisplayed(String index) {
        return elementExists(talentPageLocators.findEmployerApplicantCardByIndex(index));
    }

    /**
     * Checks to see if an Applicant card's photo is displayed
     *
     * @param index The index of the applicant card's photo (starting at 0)
     * @return Whether or not an applicant's card's photo is displayed
     */
    public Boolean isApplicantCardPhotoDisplayed(String index) {
        return elementExists(talentPageLocators.findEmployerApplicantCardPhotoByIndex(index));
    }

    /**
     * Gets the applicant's name
     *
     * @param index The index of the applicant's name (starting at 0)
     * @return The applicant's name
     */
    public String getApplicantName(String index) {
        return driver.findElement(talentPageLocators.findEmployerApplicantCardNameByIndex(index)).getText();
    }

    /**
     * Gets the applicant's applied position
     *
     * @param index The index of the applicant's applied position (starting at 0)
     * @return The applicant's applied position
     */
    public String getApplicantPosition(String index) {
        return driver.findElement(talentPageLocators.findEmployerApplicantCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the applicant's applied time
     *
     * @param index The index of the applicant's applied time (starting at 0)
     * @return The applicant's applied time
     */
    public String getApplicantTime(String index) {
        return driver.findElement(talentPageLocators.findEmployerApplicantCardAppliedTimeAgoByIndex(index)).getText();
    }

    /**
     * Select the applicant's view profile button
     *
     * @param index The index of the applicant's view profile button (starting at 0)
     */
    public void selectApplicantViewProfileBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardViewProfileByIndex(index)).click();
    }

    /**
     * Select the applicant's actions button
     *
     * @param index The index of the applicant's actions button (starting at 0)
     */
    public void selectApplicantActionsBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsByIndex(index)).click();
    }

    /**
     * Select the applicant's good fit button
     *
     * @param index The index of the applicant's good fit button (starting at 0)
     */
    public void selectApplicantGoodFitBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsGoodFitByIndex(index)).click();
    }

    /**
     * Select the applicant's bad fit button
     *
     * @param index The index of the applicant's bad fit button (starting at 0)
     */
    public void selectApplicantBadFitBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsBadFitByIndex(index)).click();
    }

    /**
     * Select the applicant's message button
     *
     * @param index The index of the applicant's message button (starting at 0)
     */
    public void selectApplicantMessageBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsMessageByIndex(index)).click();
    }

    /**
     * Gets the applicant's shared connections count
     *
     * @param index The index of the applicant's shared connection count (starting at 0)
     * @return The applicant's name shared connection count
     */
    public String getApplicantSharedConnections(String index) {
        return driver.findElement(talentPageLocators.findEmployerApplicantCardSharedConnectionsByIndex(index)).getText();
    }

    /**
     * Checks to see if the applicant success toast is visible
     *
     * @param index the index (starting at 0) of the applicant card
     * @return Whether or not the applicant success toast is visible
     */
    public boolean verifyApplicantSuccessToast(String index) {
        wait.until(visibilityOfElementLocated(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index)));
        return elementExists(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index));
    }

    /**
     * Clicks the 'X' to dismiss the applicant success toast
     *
     * @param index the index (starting at 0) of the applicant card
     */
    public void dismissApplicantSuccessToast(String index) {
        wait.until(elementToBeClickable(talentPageLocators.findEmployerApplicantSuccessToastCloseBtnByIndex(index)));
        driver.findElement(talentPageLocators.findEmployerApplicantSuccessToastCloseBtnByIndex(index)).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.findEmployerApplicantSuccessToastByIndex(index)));
    }

    /*---------- Utility Methods ----------*/

    /**
     * Selects the 'All talent' tab
     */
    public void selectTalentAllTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentAllBtn));
        driver.findElement(talentPageLocators.employerTalentAllBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Good fit talent' tab
     */
    public void selectTalentGoodTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentGoodBtn));
        driver.findElement(talentPageLocators.employerTalentGoodBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Invited to Apply' tab
     */
    public void selectTalentInvitedTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentInviteBtn));
        driver.findElement(talentPageLocators.employerTalentInviteBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Applicants' tab
     */
    public void selectTalentApplicantsTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentAppliantsBtn));
        driver.findElement(talentPageLocators.employerTalentAppliantsBtn).click();
        // waitForLoadingIndicator();
    }

    /**
     * Selects the 'Not a fit' tab
     */
    public void selectTalentBadTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentBadBtn));
        driver.findElement(talentPageLocators.employerTalentBadBtn).click();
        waitForLoadingIndicator();
    }

    /**
     * Selects the 'Interviews' tab
     */
    public void selectTalentInterviewsTab() {
        wait.until(elementToBeClickable(talentPageLocators.employerTalentInterrviewsBtn));
        driver.findElement(talentPageLocators.employerTalentInterrviewsBtn).click();
    }

    /**
     * Checks if the today button is displayed in the calendar view header
     *
     * @return Whether or not the today button is displayed
     */
    public boolean isTodayBtnDisplayed() {
        return elementExists(talentPageLocators.calendarTodayBtn);
    }

    /**
     * Checks to see if today button is enabled
     *
     * @return Whether or not the today button is enabled
     */
    public boolean isTodayBtnEnabled() {
        return (driver.findElement(talentPageLocators.calendarTodayBtn).isEnabled());
    }

    /**
     * Selects the calendar today button in the calendar header
     */
    public void selectCalendarTodayBtn() {
        driver.findElement(talentPageLocators.calendarTodayBtn).click();
    }


    /**
     * Checks if the add availability button is displayed in the calendar view header
     *
     * @return Whether or not the add availability button is displayed
     */
    public boolean isAddAvailabilityBtnDisplayed() {
        return elementExists(talentPageLocators.employerAddAvailabilityBtn);
    }

    /**
     * Checks if the back and next buttons are displayed in the calendar view header
     *
     * @return Whether or not back and next buttons buttons are displayed
     */
    public boolean isBackNextBtnsDisplayed() {
        return elementExists(talentPageLocators.calendarNextBtn) &&
                elementExists(talentPageLocators.calendarBackBtn);
    }

    /**
     * Checks if week range text is displayed in the calendar view header
     *
     * @return Whether or not week range text button is displayed
     */
    public boolean isWeekRangeTxtDisplayed() {
        return elementExists(talentPageLocators.calendarWeekRangeTxt);
    }

    /**
     * Checks if days of month text is displayed in the calendar view header
     *
     * @return Whether or not days of month text button is displayed
     */
    public boolean isDayOfMonthTxtDisplayed() {
        return elementExists(talentPageLocators.dayOfMonthTxt);
    }

    /**
     * Selects the add availability button
     */
    public void selectAddAvailabilityBtn() {
        wait.until(presenceOfElementLocated(talentPageLocators.employerAddAvailabilityBtn));
        driver.findElement(talentPageLocators.employerAddAvailabilityBtn).click();
        wait.until(presenceOfElementLocated(talentPageLocators.employerAddAvailabilityModal));
    }

    /**
     * Switch between weeks via back/next buttons in the calendar header
     */
    public void clickNextWeekButton() {
        driver.findElement(talentPageLocators.calendarNextBtn).click();
    }

    /**
     * Checks to see if the empty search result elements are on the job search page
     *
     * @return Whether or not the empty search result elements are on the job search page
     */
    public boolean verifyDaysOfWeekPresent() {
        return getDay0OfWeekTxt().equals("Sunday") &&
                getDay1OfWeekTxt().equals("Monday") &&
                getDay2OfWeekTxt().equals("Tuesday") &&
                getDay3OfWeekTxt().equals("Wednesday") &&
                getDay4OfWeekTxt().equals("Thursday") &&
                getDay5OfWeekTxt().equals("Friday") &&
                getDay6OfWeekTxt().equals("Saturday");
    }

    /**
     * Gets the Sunday text on the add availability dialog
     *
     * @return The Sunday text
     */
    public String getDay0OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day0OfWeekTxt));
        return driver.findElement(talentPageLocators.day0OfWeekTxt).getText();
    }

    /**
     * Gets the Monday text on the add availability dialog
     *
     * @return The Monday text
     */
    public String getDay1OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day1OfWeekTxt));
        return driver.findElement(talentPageLocators.day1OfWeekTxt).getText();
    }

    /**
     * Gets the Tuesday text on the add availability dialog
     *
     * @return The Tuesday text
     */
    public String getDay2OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day2OfWeekTxt));
        return driver.findElement(talentPageLocators.day2OfWeekTxt).getText();
    }

    /**
     * Gets the Wednesday text on the add availability dialog
     *
     * @return The Wednesday text
     */
    public String getDay3OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day3OfWeekTxt));
        return driver.findElement(talentPageLocators.day3OfWeekTxt).getText();
    }

    /**
     * Gets the Thursday text on the add availability dialog
     *
     * @return The Thursday text
     */
    public String getDay4OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day4OfWeekTxt));
        return driver.findElement(talentPageLocators.day4OfWeekTxt).getText();
    }

    /**
     * Gets the Friday text on the add availability dialog
     *
     * @return The Friday text
     */
    public String getDay5OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day5OfWeekTxt));
        return driver.findElement(talentPageLocators.day5OfWeekTxt).getText();
    }

    /**
     * Gets the Saturday text on the add availability dialog
     *
     * @return The Saturday text
     */
    public String getDay6OfWeekTxt() {
        wait.until(presenceOfElementLocated(talentPageLocators.day6OfWeekTxt));
        return driver.findElement(talentPageLocators.day6OfWeekTxt).getText();
    }

    /**
     * Gets the interview scheduled hint text on the add availability dialog
     *
     * @return The interview scheduled hint text
     */
    public String getInterviewScheduledHintTxt() {
        return driver.findElement(talentPageLocators.interviewScheduledHint).getText();
    }

    /**
     * Gets the availability dialog title on the add availability dialog
     *
     * @return The availability dialog title
     */
    public String getAvailabilityDialogTitle() {
        return driver.findElement(talentPageLocators.availabilityDialogTitle).getText();
    }

    /**
     * Gets the availability dialog text on the add availability dialog
     *
     * @return The availability dialog text
     */
    public String getAvailabilityDialogTxt() {
        return driver.findElement(talentPageLocators.availabilityDialogTxt).getText();
    }


    /**
     * Checks if the save schedule button is displayed
     *
     * @return Whether or not the save schedule button is displayed
     */

    public boolean isSaveScheduleBtnDisplayed() {
        return elementExists(talentPageLocators.saveScheduleBtn);
    }

    /**
     * Checks if the cancel schedule button is displayed
     *
     * @return Whether or not the cancel schedule button is displayed
     */
    public boolean isCancelScheduleBtnDisplayed() {
        return elementExists(talentPageLocators.cancelScheduleBtn);
    }

    /**
     * Checks to see if save schedule button is enabled
     *
     * @return Whether or not the save schedule button is enabled
     */
    public boolean isSaveScheduleBtnEnabled() {
        return (driver.findElement(talentPageLocators.saveScheduleBtn).isEnabled());
    }

    /**
     * Select another day(Saturday) for adding availability on the availability modal
     */
    public void selectDayOfWeek() {
        wait.until(elementToBeClickable(talentPageLocators.day6OfWeekTxt));
        driver.findElement(talentPageLocators.day6OfWeekTxt).click();
    }

    /**
     * Select available time slot (16.00) on the  availability modal
     */
    public void selectAvailableTimeSlot() {
        wait.until(elementToBeClickable(talentPageLocators.availabilityDialogTimeSlot1));
        driver.findElement(talentPageLocators.availabilityDialogTimeSlot1).click();
        wait.until(elementToBeClickable(talentPageLocators.saveScheduleBtn));
    }

    /**
     * Delete availability, unselect time slot on the  availability modal
     */
    public void deleteAvailableTimeSlot() {
        wait.until(elementToBeClickable(talentPageLocators.availabilityDialogTimeSlot1));
        driver.findElement(talentPageLocators.availabilityDialogTimeSlot1).click();
        wait.until(elementToBeClickable(talentPageLocators.saveScheduleBtn));
    }

    /**
     * Selects the save schedule button
     */
    public void selectSaveScheduleBtn() {
        driver.findElement(talentPageLocators.saveScheduleBtn).click();
    }

    /**
     * Verifies that the success dialog is displayed when save schedule
     *
     * @return Whether or not the success dialog is displayed
     */
    public boolean isUpdatedAvailabilitySuccessDialogDisplayed() {
        return elementExists(talentPageLocators.updatedAvailabilitySuccessDialog);
    }

    /**
     * Gets the availability success dialog title on the add availability dialog
     *
     * @return The availability success dialog title
     */
    public String getSuccessDialogTitle() {
        return driver.findElement(talentPageLocators.successDialogTitle).getText();
    }

    /**
     * Gets the availability success dialog text on the add availability dialog
     *
     * @return The availability success dialog text
     */
    public String getSuccessDialogTxt() {
        return driver.findElement(talentPageLocators.successDialogTxt).getText();
    }

    /**
     * Checks if the successDialogSuccessIcon is displayed
     *
     * @return Whether or not the successDialogSuccessIcon is displayed
     */

    public boolean isSuccessDialogSuccessIconDisplayed() {
        return elementExists(talentPageLocators.successDialogSuccessIcon);
    }

    /**
     * Checks if the got it button is displayed
     *
     * @return Whether or not the Got it button is displayed
     */
    public boolean isGotItBtnDisplayed() {
        return elementExists(talentPageLocators.dismissAvailabilitySuccessDialogBtn);
    }

    /**
     * Checks if the close button is displayed on success dialog
     *
     * @return Whether or not the close button is displayed
     */
    public boolean isSuccessDialogCloseBtnDisplayed() {
        return elementExists(talentPageLocators.successDialogCloseBtn);
    }

    /**
     * Selects the got it button
     */
    public void selectGotItBtn() {
        driver.findElement(talentPageLocators.dismissAvailabilitySuccessDialogBtn).click();
    }

    /**
     * Checks if the empty time slot is displayed on calendar view
     *
     * @return Whether or not the empty time slot is displayed on calendar view
     */
    public boolean isCalendarCellEmptyTimeSlotDisplayed() {
        return elementExists(talentPageLocators.calendarCellEmptyTimeSlot);
    }

    /**
     * Checks if the filled time slot is displayed on calendar view
     *
     * @return Whether or not the filled time slot is displayed on calendar view
     */
    public boolean isCalendarCellFilledTimeSlotDisplayed() {
        return elementExists(talentPageLocators.calendarCellFilledTimeSlot);
    }

    /**
     * Checks if the updated availability time slot is filled on calendar view
     *
     * @return Whether or not the updated availability time slot is filled on calendar view
     */
    public boolean isCalendarCellFilledUpdatedTimeSlotDisplayed() {
        return elementExists(talentPageLocators.calendarCellUpdatedFilledTimeSlot);
    }

    /**
     * Selects the filled time slot to edit
     */
    public void selectFilledTimeSlot() {
        driver.findElement(talentPageLocators.calendarCellFilledTimeSlot).click();
        wait.until(presenceOfElementLocated(talentPageLocators.employerAddAvailabilityModal));
    }

    /* Select the cancel button on the add availability dialog */
    public void selectCancelScheduleBtn() {
        wait.until(elementToBeClickable(talentPageLocators.availabilityDialogTimeSlot2));
        driver.findElement(talentPageLocators.availabilityDialogTimeSlot2).click();
        driver.findElement(talentPageLocators.cancelScheduleBtn).click();
    }

    /**
     * Checks if the cancel availability changes dialog is displayed
     *
     * @return Whether or not the cancel availability changes dialog is displayed
     */
    public boolean isCancelAvailabilityChangesDialogDisplayed() {
        return elementExists(talentPageLocators.cancelAvailabilityChangesDialog);
    }

    /**
     * Gets the cancel availability dialog title
     */
    public String getCancelAvailabilityDialogTitle() {
        return driver.findElement(talentPageLocators.cancelAvailabilityChangesTitleDialog).getText();
    }

    /**
     * Gets the cancel availability dialog text
     */
    public String getCancelAvailabilityDialogTxt() {
        return driver.findElement(talentPageLocators.cancelAvailabilityChangesTxtDialog).getText();
    }

    /**
     * Checks if the discard changes button is displayed on cancel availability changes dialog
     *
     * @return Whether or not the discard changes button is displayed
     */
    public boolean isCancelAvailabilityDiscardBtnDisplayed() {
        return elementExists(talentPageLocators.cancelAvailabilityChangesDiscardBtn);
    }

    /**
     * Checks if the back button is displayed on cancel availability changes dialog
     *
     * @return Whether or not the back button is displayed
     */
    public boolean isCancelAvailabilityBackBtnDisplayed() {
        return elementExists(talentPageLocators.cancelAvailabilityChangesBackBtn);
    }

    /* Select the back to schedule button on the cancel availability changes dialog */
    public void selectBacktoScheduleBtn() {
        driver.findElement(talentPageLocators.cancelAvailabilityChangesBackBtn).click();
    }

    /* Select the discard changes button on the cancel availability changes dialog */
    public void selectDiscardChangesBtn() {
        driver.findElement(talentPageLocators.cancelAvailabilityChangesDiscardBtn).click();
    }

    /**
     * Checks if the unsaved changes are displayed on add availability dialog
     *
     * @return Whether or not the unsaved changes are displayed on add availability dialog
     */
    public boolean isUnsavedChngesAvailabilityDialogDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.employerAddAvailabilityModal));
        return
                elementExists(talentPageLocators.employerAddAvailabilityModal) &&
                        elementExists(talentPageLocators.availabilityDialogTimeSlot1) &&
                        elementExists(talentPageLocators.availabilityDialogTimeSlot2);
    }

    /**
     * Checks if the unsaved changes are discarded
     *
     * @return Whether or not the unsaved changes are discarded
     */
    public boolean isUnsavedChangesDiscarded() {
        return
                elementExists(talentPageLocators.calendarCellFilledTimeSlot) &&
                        elementExists(talentPageLocators.calendarCellEmptyTimeSlot);
    }

    /**
     * Select the applicant's schedule interview button
     *
     * @param index The index of the applicant's schedule interview button (starting at 0)
     */
    public void selectApplicantScheduleInterviewBtn(String index) {
        driver.findElement(talentPageLocators.findEmployerApplicantCardActionsScheduleInterviewByIndex(index)).click();
    }

    /**
     * Checks if the send button is displayed
     *
     * @return Whether or not the send button is displayed
     */

    public boolean isSendInviteToInterviewBtnDisplayed() {
        return elementExists(talentPageLocators.sendInviteToInterviewBtn);
    }

    /**
     * Checks if the cancel invite to interview button is displayed
     *
     * @return Whether or not the cancel invite to interview button is displayed
     */
    public boolean isInviteToInterviewBtnDisplayed() {
        return elementExists(talentPageLocators.cancelScheduleBtn);
    }

    /**
     * Checks to see if send button is enabled
     *
     * @return Whether or not the send button is enabled
     */
    public boolean isSendInviteToInterviewBtnEnabled() {
        return (driver.findElement(talentPageLocators.sendInviteToInterviewBtn).isEnabled());
    }

    /**
     * Gets the send invite to interview button text
     *
     * @return The send invite to interview button text
     */
    public String getSendInviteToInterviewBtnTxt() {
        return driver.findElement(talentPageLocators.sendInviteToInterviewBtn).getText();
    }

    /* Select the send invite to interview button */
    public void selectSendInviteToInterviewBtn() {
        driver.findElement(talentPageLocators.sendInviteToInterviewBtn).click();
    }

    /**
     * Enter text in to the message field  when invite to interview
     *
     * @param text
     */
    public void enterMessageTxtInviteToInterview(String text) {
        driver.findElement(talentPageLocators.inviteToInterviewMessageTextArea).sendKeys(text);
    }

    /**
     * Enter text in to the message field  when reschedule interview
     *
     * @param text
     */
    public void enterMessageTxtRescheduleInterview(String text) {
        driver.findElement(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogMessageText).sendKeys(text);
    }

    /**
     * Verifies that the success dialog is displayed when send the invite to the interview
     *
     * @return Whether or not the success dialog is displayed
     */
    public boolean isInviteToInterviewSuccessDialogDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.inviteToInterviewSuccessDialog));
        return elementExists(talentPageLocators.inviteToInterviewSuccessDialog);
    }

    /**
     * Selects the got it button on invite to the interview success dialog
     */
    public void selectGotItInviteToInterviewBtn() {
        driver.findElement(talentPageLocators.dismissInviteToInterviewSuccessDialogBtn).click();
    }

    /**
     * Gets the interview message text
     *
     * @return The interview message text
     */
    public String getInviteToInterviewMessageTxt() {
        return driver.findElement(talentPageLocators.employerTalentInviteModalMessageTxt).getText();
    }

    /**
     * Gets the last interview message status
     *
     * @return The last interview message status
     */

    public String getLastInterviewStatusMessage() {
        List<WebElement> interviewStatusMessages = driver.findElements(talentPageLocators.messageScheduleInterviewStatus);
        int numElements = interviewStatusMessages.size();
        return interviewStatusMessages.get(numElements - 1).getText();
    }

    /**
     * Gets the last interview message in the message thread
     *
     * @return The last interview message in the message thread
     */

    public String getLastInterviewMessage() {
        List<WebElement> scheduleInterviewMessages = driver.findElements(talentPageLocators.messageScheduleInterviewMesssageThread);
        int numElements = scheduleInterviewMessages.size();
        return scheduleInterviewMessages.get(numElements - 1).getText();
    }

    /**
     * Gets the last interview message content in the message thread
     *
     * @return The last interview message in the message thread
     */

    public String getLastInterviewMessageContent() {
        List<WebElement> scheduleInterviewMessages = driver.findElements(talentPageLocators.messageThreadScheduleInterviewContentMsg);
        int numElements = scheduleInterviewMessages.size();
        return scheduleInterviewMessages.get(numElements - 1).getText();
    }

    /**
     * Verifies that the last interview card is displayed in the message thread
     *
     * @return Whether or not the last interview card is displayed in the message thread
     */
    public Boolean isLastMessageThreadScheduleInterviewCardDisplayed() {
        List<WebElement> scheduleInterviewCards = driver.findElements(talentPageLocators.messageThreadScheduleInterviewCard);
        int numElements = scheduleInterviewCards.size();
        return scheduleInterviewCards.get(numElements - 1).isDisplayed();
    }

    /**
     * Select the last schedule interview button
     */
    public void selectLastEnabledScheduleInterviewBtn() {
        List<WebElement> messageThreadScheduleInterviewBtns = driver.findElements(talentPageLocators.messageThreadScheduleInterviewBtn);
        int numElements = messageThreadScheduleInterviewBtns.size();
        messageThreadScheduleInterviewBtns.get(numElements - 1).click();
    }

    /**
     * Select the last interview reminder card in the message thread
     */
    public void selectLastInterviewReminderCard() {
        List<WebElement> messageThreadWdgMessageInterviewReminderCards = driver.findElements(talentPageLocators.messageThreadWdgMessageInterviewReminder);
        int numElements = messageThreadWdgMessageInterviewReminderCards.size();
        messageThreadWdgMessageInterviewReminderCards.get(numElements - 1).click();
    }

    /**
     * Select the last choose new time  button
     */
    public void selectLastEnabledChooseNewTimeBtn() {
        List<WebElement> messageThreadChooseNewTimeBtns = driver.findElements(talentPageLocators.messageThreadChooseNewTimeBtn);
        int numElements = messageThreadChooseNewTimeBtns.size();
        messageThreadChooseNewTimeBtns.get(numElements - 1).click();
    }

    /**
     * Gets the invite interview dialog title
     *
     * @return The invite interview dialog title
     */
    public String getInviteInterviewDialogTitle() {
        return driver.findElement(talentPageLocators.inviteToInterviewAvailabilityDialogTitle).getText();
    }

    /**
     * Checks if the back and next buttons are displayed in the calendar view header
     *
     * @return Whether or not back and next buttons buttons are displayed
     */
    public boolean isBackNextBtnsDisplayedInviteInterviewDialog() {
        return elementExists(talentPageLocators.availabilityModalToolbarToolbarPrevBtn) &&
                elementExists(talentPageLocators.availabilityModalToolbarToolbarNextBtn);
    }

    /**
     * Gets the selected day on the invite interview dialog
     *
     * @return The selected day on the invite to interview dialog
     */
    public String getInviteInterviewDialogSelectedDayTxt() {
        wait.until(elementToBeClickable(talentPageLocators.inviteToInterviewAvailabilityDialogSelectedDay));
        return driver.findElement(talentPageLocators.inviteToInterviewAvailabilityDialogSelectedDay).getText();
    }

    /**
     * Gets the available time slot on the invite interview dialog
     *
     * @return The available time slot on the invite to interview dialog
     */
    public String getInviteInterviewDialogAvailableTimeSlot() {
        wait.until(presenceOfElementLocated(talentPageLocators.availabilityDialogTimeSlot1));
        return driver.findElement(talentPageLocators.availabilityDialogTimeSlot1).getText();
    }

    /**
     * Gets the available times hint text on the invite to interview dialog
     *
     * @return The available times hint text on the invite to interview dialog
     */
    public String getAvailableTimesSlotHintTxt() {
        return driver.findElement(talentPageLocators.availableTimesHintTxt).getText();
    }

    /**
     * Gets the not available times hint text on the invite to interview dialog
     *
     * @return The not available times hint text on the invite to interview dialog
     */
    public String getNotAvailableTimesSlotHintTxt() {
        return driver.findElement(talentPageLocators.notAvailableHintTxt).getText();
    }

    /**
     * Checks if the confirm interview button is displayed
     *
     * @return Whether or not the confirm interview button is displayed
     */

    public boolean isConfirmInterviewBtnDisplayed() {
        return elementExists(talentPageLocators.confirmInterviewBtn);
    }

    /**
     * Checks if the request new times button is displayed
     *
     * @return Whether or not the request new times button is displayed
     */
    public boolean isRequestNewTimesBtnDisplayed() {
        return elementExists(talentPageLocators.confirmInterviewBtn);
    }

    /**
     * Checks to see if confirm interview button is enabled
     *
     * @return Whether or not the confirm interview button is enabled
     */
    public boolean isConfirmInterviewBtnEnabled() {
        return (driver.findElement(talentPageLocators.confirmInterviewBtn).isEnabled());
    }

    /**
     * Gets the confirm interview button text
     *
     * @return The confirm interview button text
     */
    public String getConfirmInterviewBtnTxt() {
        return driver.findElement(talentPageLocators.confirmInterviewBtn).getText();
    }

    /**
     * Gets the request new times button text
     *
     * @return The request new times button text
     */
    public String getRequestNewTimesBtnTxt() {
        return driver.findElement(talentPageLocators.requestNewTimesBtn).getText();
    }

    /* Select the confirm interview button */
    public void selectConfirmInterviewBtn() {
        wait.until(elementToBeClickable(talentPageLocators.confirmInterviewBtn));
        driver.findElement(talentPageLocators.confirmInterviewBtn).click();
    }

    /**
     * Verifies that the success dialog is displayed when confirm interview
     *
     * @return Whether or not the success dialog is displayed
     */
    public boolean isInviteToInterviewInviteSuccessDialogDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.inviteToInterviewInviteSuccessDialogBasicDialog));
        return elementExists(talentPageLocators.inviteToInterviewInviteSuccessDialogBasicDialog);
    }

    /**
     * Gets the invite to interview success dialog title
     *
     * @return The invite to interview  success dialog title
     */
    public String getInviteToInterviewSuccessDialogTitle() {
        return driver.findElement(talentPageLocators.inviteToInterviewInviteSuccessDialogTitle).getText();
    }

    /**
     * Gets the invite to interview success dialog text
     *
     * @return The invite to interview  success dialog text
     */
    public String getInviteToInterviewSuccessDialogTxt() {
        return driver.findElement(talentPageLocators.inviteToInterviewInviteSuccessDialogText).getText();
    }

    /**
     * Checks if the successDialogSuccessIcon is displayed
     *
     * @return Whether or not the successDialogSuccessIcon is displayed
     */

    public boolean isInviteToInterviewSuccessDialogSuccessIconDisplayed() {
        return elementExists(talentPageLocators.inviteToInterviewInviteSuccessDialogSuccessIcon);
    }

    /**
     * Checks if the view details button is displayed
     *
     * @return Whether or not the view details button is displayed
     */
    public boolean isViewDetailsBtnDisplayed() {
        return elementExists(talentPageLocators.viewDetailsBtn);
    }

    /**
     * Select the view details button
     */
    public void selectViewDetailsBtn() {
        driver.findElement(talentPageLocators.viewDetailsBtn).click();
    }

    /**
     * Verifies that the interview reminder dialog is displayed in the message thread
     *
     * @return Whether or not the interview reminder dialog is displayed
     */
    public boolean isInterviewDetailsReminderEmployerDialogDisplayed() {
        return elementExists(talentPageLocators.inviteToInterviewDetailsDialog);
    }

    /**
     * Gets the interview reminder dialog title in the message thread
     *
     * @return The interview reminder title
     */
    public String getInterviewDetailsReminderDialogTitle() {
        return driver.findElement(talentPageLocators.inviteToInterviewDetailsDialogTitle).getText();
    }

    /**
     * Gets the store name on interview reminder dialog in the message thread
     *
     * @return The store name on interview reminder dialog
     */
    public String getInterviewDetailsReminderEmployerName() {
        return driver.findElement(talentPageLocators.inviteToInterviewDetailsEmployerNameTxt).getText();
    }

    /**
     * Checks to see if the employer logo is on the interview reminder dialog
     *
     * @return Whether or not the employer logo is on the interview reminder dialog
     */
    public boolean verifyInterviewDetailsReminderEmployerLogo() {
        return elementExists(talentPageLocators.inviteToInterviewDetailsLogo);
    }

    /**
     * Gets the employer type on interview reminder dialog in the message thread
     *
     * @return The employer type on interview reminder dialog
     */
    public String getInterviewDetailsReminderEmployerTypeTxt() {
        return driver.findElement(talentPageLocators.inviteToInterviewDetailsEmployerTypeTxt).getText();
    }

    /**
     * Gets the employer location on interview reminder dialog in the message thread
     *
     * @return The employer location on interview reminder dialog
     */
    public String getInterviewDetailsReminderLocationTxt() {
        return driver.findElement(talentPageLocators.inviteToInterviewDetailsLocationTxt).getText();
    }

    /**
     * Gets the interview date on the interview reminder dialog
     *
     * @return The interview date
     */
    public String getInterviewDetailsReminderDateTxt() {
        return driver.findElement(talentPageLocators.inviteToInterviewDetailsDateTxt).getText();
    }

    /**
     * Checks if the location pin icon is displayed
     *
     * @return Whether or not the location pin icon is displayed
     */
    public boolean isInterviewDetailsReminderLocationPinIconDisplayed() {
        return elementExists(talentPageLocators.inviteToInterviewDetailsLocationPin);
    }

    /**
     * Select the location pin button
     */
    public void selectLocationPinBtn() {
        driver.findElement(talentPageLocators.inviteToInterviewDetailsLocationPin).click();
    }

    /**!!!!!!!!
     * Checks if the store address is opened in the new tab
     *
     * @return Whether or not the store address is opened in the new tab
     */
   /* public void isStoreLocatinGoogleMapsLinkOpened() {
        driver.findElement(talentPageLocators.locationPin).click();
    }*/

    /**
     * Checks if the reschedule interview button is displayed
     *
     * @return Whether or not the reschedule interview button is displayed
     */
    public boolean isRescheduleBtnDisplayed() {
        return elementExists(talentPageLocators.rescheduleInterviewBtn);
    }

    /**
     * Checks if the cancel interview button is displayed
     *
     * @return Whether or not the cancel interview button is displayed
     */

    public boolean isCancelInterviewBtnDisplayed() {
        return elementExists(talentPageLocators.cancelInterviewBtn);
    }

    /**
     * Checks to see if reschedule interview button is enabled
     *
     * @return Whether or not the reschedule interview button is enabled
     */
    public boolean isRescheduleInterviewBtnEnabled() {
        return (driver.findElement(talentPageLocators.rescheduleInterviewBtn).isEnabled());
    }

    /**
     * Checks to see if cancel interview button is enabled
     *
     * @return Whether or not the cancel interview button is enabled
     */
    public boolean isCancelInterviewBtnEnabled() {
        return (driver.findElement(talentPageLocators.cancelInterviewBtn).isEnabled());
    }

    /**
     * Checks to see if an interview card is displayed on store calendar
     *
     * @return Whether or not an interview card is displayed
     */
    public Boolean isInterviewCardOnCalendarDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.calendarInterviewCard));
        return elementExists(talentPageLocators.calendarInterviewCard);
    }

    /**
     * Checks to see if an pending interview is displayed on store calendar
     *
     * @return Whether or not an interview card is displayed
     */
    public Boolean isPendingInterviwOnCalendarDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.calendarPendingInterviewCard));
        return elementExists(talentPageLocators.calendarPendingInterviewCard);
    }

    /**
     * Checks to see if an applicant name is displayed on the interview card on store calendar
     *
     * @return Whether or not an applicant name is displayed
     */
    public Boolean isApplicantNameTxtOnCalendarDisplayed() {
        return elementExists(talentPageLocators.applicantNameTxt);
    }

    /**
     * Checks to see if an applicant position is displayed on the interview card on store calendar
     *
     * @return Whether or not applicant position is displayed
     */
    public Boolean isApplicantPositionTxtOnCalendarDisplayed() {
        return elementExists(talentPageLocators.applicantPositionTxt);
    }

    /**
     * Checks to see if an applicant logo is displayed on the interview card on store calendar
     *
     * @return Whether or not applicant logo is displayed
     */
    public Boolean isApplicantLogoOnCalendarDisplayed() {
        return elementExists(talentPageLocators.applicantImg);
    }

    /* Select the interview card on the calendar */
    public void selectInterviewCardOnCalendar() {
        driver.findElement(talentPageLocators.calendarInterviewCard).click();
    }

    /**
     * Clicks the 'X' to close interview details dialog
     */
    public void closeInviteToInterviewDetailsDialog() {
        wait.until(elementToBeClickable(talentPageLocators.inviteToInterviewDetailsCloseBtnDialog));
        driver.findElement(talentPageLocators.inviteToInterviewDetailsCloseBtnDialog).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.inviteToInterviewDetailsDialog));
    }

    /**
     * Clicks the 'X' to close interview details dialog
     */
    public void closeRescheduleInterviewSuccessDialog() {
        wait.until(elementToBeClickable(talentPageLocators.messageThreadRescheduleSuccessDialogCloseBtn));
        driver.findElement(talentPageLocators.messageThreadRescheduleSuccessDialogCloseBtn).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.inviteToInterviewInviteSuccessDialogBasicDialog));
    }

    /**
     * Verifies that the interview reminder dialog is displayed in the message thread
     *
     * @return Whether or not the interview reminder dialog is displayed
     */
    public boolean isMessageThreadInterviewReminderEmployerDialogDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderEmployerDialog);
    }

    /**
     * Gets the interview reminder dialog title in the message thread
     *
     * @return The interview reminder title
     */
    public String getMessageThreadInterviewReminderEmployerDialogTitle() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderEmployerDialogTitle).getText();
    }

    /**
     * Gets the store name on interview reminder dialog in the message thread
     *
     * @return The store name on interview reminder dialog
     */
    public String getMessageThreadInterviewReminderEmployerName() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderEmployerNameTxt).getText();
    }

    /**
     * Checks to see if the employer logo is on the interview reminder dialog
     *
     * @return Whether or not the employer logo is on the interview reminder dialog
     */
    public boolean verifyMessageThreadInterviewReminderEmployerLogo() {
        return elementExists(talentPageLocators.messageThreadWdgInterviewReminderLogo);
    }

    /**
     * Gets the employer type on interview reminder dialog in the message thread
     *
     * @return The employer type on interview reminder dialog
     */
    public String getMessageThreadInterviewReminderEmployerTypeTxt() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderEmployerTypeTxt).getText();
    }

    /**
     * Gets the employer location on interview reminder dialog in the message thread
     *
     * @return The employer location on interview reminder dialog
     */
    public String getMessageThreadInterviewReminderLocationTxt() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderLocationTxt).getText();
    }

    /**
     * Gets the interview date on the interview reminder dialog
     *
     * @return The interview date
     */
    public String getMessageThreadInterviewReminderDateTxt() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderDateTxt).getText();
    }

    /**
     * Checks if the location pin icon is displayed
     *
     * @return Whether or not the location pin icon is displayed
     */
    public boolean isMessageThreadInterviewReminderLocationPinIconDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderLocationPin);
    }

    /**
     * Clicks the 'X' to close interview details dialog
     */
    public void closeMessageThreadInterviewReminderDialog() {
        wait.until(elementToBeClickable(talentPageLocators.messageThreadInterviewReminderDialogCloseBtn));
        driver.findElement(talentPageLocators.messageThreadInterviewReminderDialogCloseBtn).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.messageThreadInterviewReminderEmployerDialog));
    }

    /**
     * Clicks the 'X' to close interview details dialog
     */
    public void closeMessageThreadInterviewReminderEmployerDialog() {
        wait.until(elementToBeClickable(talentPageLocators.messageThreadWdgInterviewReminderDialogCloseBtn));
        driver.findElement(talentPageLocators.messageThreadWdgInterviewReminderDialogCloseBtn).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.messageThreadInterviewReminderEmployerInterviewDialog));
    }

    /**
     * Verifies that the interview reminder dialog is displayed from the calendar
     *
     * @return Whether or not the interview reminder dialog is displayed
     */
    public boolean isInterviewSchedulerinterviewDialogOnCalendarDisplayed() {
        return elementExists(talentPageLocators.interviewSchedulerinterviewDialogBasicDialog);
    }

    /**
     * Gets the interview reminder dialog title from the calendar
     *
     * @return The interview reminder title
     */
    public String getInterviewSchedulerinterviewDialogOnCalendarTitle() {
        return driver.findElement(talentPageLocators.interviewSchedulerCalendariInterviewDialogTitle).getText();
    }

    /**
     * Gets the applicant name on interview reminder dialog from the calendar
     *
     * @return The applicant name on interview reminder dialog
     */
    public String getInterviewSchedulerinterviewDialogOnCalendarApplicantName() {
        return driver.findElement(talentPageLocators.interviewSchedulerCalendarApplicantTxt).getText();
    }

    /**
     * Gets the applicant position on interview reminder dialog from the calendar
     *
     * @return The applicant position on interview reminder dialog
     */
    public String getInterviewSchedulerinterviewDialogOnCalendarApplicantPosition() {
        return driver.findElement(talentPageLocators.interviewSchedulerCalendarApplicantPosition).getText();
    }

    /**
     * Checks to see if the applicant logo is on the interview reminder dialog from the calendar
     *
     * @return Whether or not the applicant logo is on the interview reminder dialog
     */
    public boolean verifyInterviewSchedulerinterviewDialogOnCalendarApplicantLogo() {
        return elementExists(talentPageLocators.interviewSchedulerCalendarAvatar);
    }

    /**
     * Gets the interview date on the interview reminder dialog from the calendar
     *
     * @return The interview date
     */
    public String getInterviewSchedulerinterviewDialogOnCalendarDateTxt() {
        return driver.findElement(talentPageLocators.interviewSchedulerCalendarDateTxt).getText();
    }

    /**
     * Checks if the view profile button is displayed on messageThreadInterviewReminderEmployerInterviewDialog
     *
     * @return Whether or not the view profile button is displayed
     */
    public boolean isInterviewSchedulerinterviewDialogOnCalendarViewProfileBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderViewProfileBtn);
    }

    /**
     * Checks if the action button is displayed on messageThreadInterviewReminderEmployerInterviewDialog
     *
     * @return Whether or not the view profile button is displayed
     */
    public boolean isInterviewSchedulerinterviewDialogOnCalendarActionBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderActionBtn);
    }

    /**
     * Select view button button
     */
    public void selectInterviewSchedulerInterviewDialogOnCalendarViewProfileBtn() {
        driver.findElement(talentPageLocators.interviewSchedulerCalendarViewProfileBtn).click();
    }

    /**
     * Select the message button on applicant's profile
     */
    public void selectInterviewSchedulerApplicantProfileMessageBtn() {
        wait.until(elementToBeClickable(talentPageLocators.interviewSchedulerApplicantProfileMessageBtn));
        driver.findElement(talentPageLocators.interviewSchedulerApplicantProfileMessageBtn).click();
    }

    /**
     * Select the actions button on applicant's profile
     */
    public void selectInterviewSchedulerInterviewDialogActionsBtn() {
        driver.findElement(talentPageLocators.interviewSchedulerCalendarActionBtn).click();
    }

    /**
     * Verifies that the actions buttons list is displayed
     *
     * @return Whether or not the actions buttons list is displayed
     */
    public boolean isMessageThreadInterviewReminderEmployerActionsBtnsDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderRescheduleBtn) &&
                elementExists(talentPageLocators.messageThreadInterviewReminderMessageBtn) &&
                elementExists(talentPageLocators.messageThreadInterviewReminderCancelInterviewBtn);

    }

    /**
     * Select the reschedule button on the interview reminder dialog from the message thread
     */
    public void selectMessageInterviewReminderEmployerDialogRescheduleBtn() {
        wait.until(elementToBeClickable(talentPageLocators.messageThreadInterviewReminderRescheduleBtn));
        driver.findElement(talentPageLocators.messageThreadInterviewReminderRescheduleBtn).click();
    }


    /**
     * Verifies that the interview reminder dialog is displayed in the message thread
     *
     * @return Whether or not the interview reminder dialog is displayed
     */
    public boolean isMessageThreadInterviewReminderEmployerInterviewDialogDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderEmployerInterviewDialog);
    }

    /**
     * Gets the interview reminder dialog title in the message thread
     *
     * @return The interview reminder title
     */
    public String getMessageThreadInterviewReminderEmployerInterviewDialogTitle() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderEmployerInterviewDialogTitle).getText();
    }

    /**
     * Gets the applicant name on interview reminder dialog in the message thread
     *
     * @return The applicant name on interview reminder dialog
     */
    public String getMessageThreadInterviewReminderEmployerInterviewDialogApplicantName() {
        return driver.findElement(talentPageLocators.messageThreadWdgMessageInterviewReminderApplicantTxt).getText();
    }

    /**
     * Gets the applicant position on interview reminder dialog in the message thread
     *
     * @return The applicant position on interview reminder dialog
     */
    public String getMessageThreadInterviewReminderEmployerInterviewDialogApplicantPosition() {
        return driver.findElement(talentPageLocators.messageThreadWdgMessageInterviewReminderApplicantPosition).getText();
    }

    /**
     * Checks to see if the applicant logo is on the interview reminder dialog
     *
     * @return Whether or not the applicant logo is on the interview reminder dialog
     */
    public boolean verifyMessageThreadWdgMessageInterviewReminderApplicantLogo() {
        return elementExists(talentPageLocators.messageThreadWdgMessageInterviewReminderavatarIcon);
    }

    /**
     * Gets the interview date on the interview reminder dialog
     *
     * @return The interview date
     */
    public String getMessageThreadWdgMessageInterviewReminderdateTxt() {
        return driver.findElement(talentPageLocators.messageThreadInterviewReminderDateTxt).getText();
    }

    /**
     * Checks if the view profile button is displayed on messageThreadInterviewReminderEmployerInterviewDialog
     *
     * @return Whether or not the view profile button is displayed
     */
    public boolean isMessageThreadInterviewReminderViewProfileBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderViewProfileBtn);
    }

    /**
     * Checks if the action button is displayed on messageThreadInterviewReminderEmployerInterviewDialog
     *
     * @return Whether or not the view profile button is displayed
     */
    public boolean isMessageThreadInterviewReminderEmployerActionBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewReminderActionBtn);
    }

    /**
     * Verifies that the reschedule interview availability dialog is displayed
     *
     * @return Whether or not the reschedule interview availability dialog is displayed
     */
    public boolean isMessageThreadInterviewRescheduleAvailabilityDialogDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialog));
        return elementExists(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialog);
    }

    /**
     * Gets the reschedule interview availability dialog title
     *
     * @return The reschedule interview availability dialog title
     */
    public String getMessageThreadInterviewRescheduleAvailabilityDialogTitle() {
        return driver.findElement(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogTitle).getText();
    }

    /**
     * Gets the reschedule interview availability dialog text
     *
     * @return The reschedule interview availability dialog text
     */
    public String getMessageThreadInterviewRescheduleAvailabilityDialogText() {
        return driver.findElement(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogText).getText();
    }

    /**
     * Verifies that the message input is displayed on the reschedule interview availability dialog
     *
     * @return Whether or not the message input is displayed on the reschedule interview availability dialog
     */
    public boolean isMessageThreadInterviewRescheduleMessageInputDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogMessageText);
    }

    /**
     * Checks if reschedule button is displayed on the reschedule interview availability dialog
     *
     * @return Whether or not the  reschedule button is displayed
     */
    public boolean isMessageThreadInterviewRescheduleEmployerRescheduleBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogRescheduleBtn);
    }

    /**
     * Select the reschedule button on the update interview availability reschedule dialog
     */
    public void selectInterviewAvailabilityDialogRescheduleBtn() {
        wait.until(elementToBeClickable(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogRescheduleBtn));
        driver.findElement(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogRescheduleBtn).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialog));
    }

    /**
     * Checks if cancel button is displayed on the reschedule interview availability dialog
     *
     * @return Whether or not the cancel button is displayed
     */
    public boolean isMessageThreadInterviewRescheduleEmployerCancelBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadInterviewRescheduleAvailabilityDialogCanceleBtn);
    }

    /**
     * Checks to see if time slot with scheduled interview is disabled
     *
     * @return Whether or not the time slot with scheduled interview is enabled
     */
    public boolean isScheduledInterviewTimeSlotEnabled() {
        return (driver.findElement(talentPageLocators.availabilityDialogTimeSlot2).isEnabled());
    }

    /* Update interview availability to reschedule interview */
    public void updateInterviewAvailabilityReschedule() {
        wait.until(elementToBeClickable(talentPageLocators.availabilityDialogTimeSlot2));
        driver.findElement(talentPageLocators.availabilityDialogTimeSlot2).click();
    }

    /**
     * Verifies that the reschedule interview availability dialog is displayed
     *
     * @return Whether or not reschedule interview availability dialog is displayed
     */
    public boolean isInterviewRescheduleAvailabilityDialogDisplayed() {
        return elementExists(talentPageLocators.interviewRescheduleAvailabilityDialog);
    }

    /**
     * Checks if the confirm interview button is displayed
     *
     * @return Whether or not the confirm interview button is displayed
     */
    public boolean isConfirmInterviewRescheduleBtnDisplayed() {
        return elementExists(talentPageLocators.interviewRescheduleAvailabilityDialogConfirmInterviewBtn);
    }

    /**
     * Checks if the request new times button is displayed
     *
     * @return Whether or not the request new times button is displayed
     */
    public boolean isRequestNewTimesRescheduleBtnDisplayed() {
        return elementExists(talentPageLocators.interviewRescheduleAvailabilityDialogRequestNewTimesBtn);
    }

    /**
     * Select the confirm interview button on the update interview availability reschedule dialog
     */
    public void selectConfirmInterviewRescheduleBtn() {
        wait.until(elementToBeClickable(talentPageLocators.interviewRescheduleAvailabilityDialogConfirmInterviewBtn));
        driver.findElement(talentPageLocators.interviewRescheduleAvailabilityDialogConfirmInterviewBtn).click();
    }

    /**
     * Verifies that the success dialog is displayed when confirm reschedule interview
     *
     * @return Whether or not the success dialog is displayed
     */
    public boolean isRescheduleInterviewSuccessDialogDisplayed() {
        wait.until(presenceOfElementLocated(talentPageLocators.messageThreadRescheduleSuccessDialog));
        return elementExists(talentPageLocators.messageThreadRescheduleSuccessDialog);
    }

    /**
     * Gets the reschedule interview success dialog title
     *
     * @return The reschedule interview success dialog title
     */
    public String getRescheduleInterviewSuccessDialogTitle() {
        return driver.findElement(talentPageLocators.messageThreadRescheduleSuccessDialogTitle).getText();
    }

    /**
     * Gets the reschedule interview success dialog text
     *
     * @return The reschedule interview success dialog text
     */
    public String getRescheduleInterviewSuccessDialogTxt() {
        return driver.findElement(talentPageLocators.messageThreadRescheduleSuccessDialogText).getText();
    }

    /**
     * Checks if the got it button is displayed on the reschedule interview success dialog
     *
     * @return Whether or not the Got it button is displayed
     */
    public boolean isGotItRescheduleSucessBtnDisplayed() {
        return elementExists(talentPageLocators.messageThreadRescheduleSuccessDialogDismissBtn);
    }

    /**
     * Selects the got it button
     */
    public void selectGotItRescheduleSuccessBtn() {
        driver.findElement(talentPageLocators.messageThreadRescheduleSuccessDialogDismissBtn).click();
    }

    /**
     * Selects the close referral banner button
     */
    public void selectCloseReferralBannerBtn() {
        wait.until(presenceOfElementLocated(talentPageLocators.referralsBannerCloseBtn));
        driver.findElement(talentPageLocators.referralsBannerCloseBtn).click();
        wait.until(invisibilityOfElementLocated(talentPageLocators.referralsBannerCloseBtn));
    }

    /**
     * Scroll to applicants cards
     *
     * @param index the index of the applicants card to scroll to
     */
    public void scrollToApplicantsCard(String index) {
        WebElement applicantsCard = driver.findElement(talentPageLocators.findEmployerApplicantCardByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", applicantsCard);
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
            System.out.println("\n" + "Loading indicator not displayed due to StaleElementReferenceException..." + "\n");
        }
    }
}
