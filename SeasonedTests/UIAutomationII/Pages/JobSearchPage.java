import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class JobSearchPage extends BasePage {
    Locators.JobSearchPageLocators jobSearchPageLocators = new Locators.JobSearchPageLocators();

    public JobSearchPage(WebDriver driver) {
        super(driver);
    }

    /*--------- Search Field ----------*/

    /**
     * Checks to see if the Search Term field is on the job search page
     * @return Whether or not the Search Term field is on the job search page
     */
    public boolean verifySearchTermField() {
        return elementExists(jobSearchPageLocators.searchJobEmployerField);
    }

    /**
     * Checks to see if the search location field is on the job search page
     * @return Whether or not the location field is on the job search page
     */
    public boolean verifySearchLocationField() { return elementExists(jobSearchPageLocators.searchLocationField); }

    /**
     * Enters search term text into search term field
     *
     * @param searchTerm The search term text to enter in the field
     */
    public void enterSearchTermText(String searchTerm) {
        wait.until(elementToBeClickable(jobSearchPageLocators.searchJobEmployerField));
        driver.findElement(jobSearchPageLocators.searchJobEmployerField).click();
        driver.findElement(jobSearchPageLocators.searchJobEmployerField).clear();
        driver.findElement(jobSearchPageLocators.searchJobEmployerField).sendKeys(searchTerm);
    }

    /**
     * Enter search location text into search location field
     *
     * @param searchLocation The search location text to enter in the field
     */
    public void enterSearchLocationText(String searchLocation) {
        wait.until(elementToBeClickable(jobSearchPageLocators.searchLocationField));
        driver.findElement(jobSearchPageLocators.searchLocationField).click();
        driver.findElement(jobSearchPageLocators.searchLocationField).clear();
        driver.findElement(jobSearchPageLocators.searchLocationField).sendKeys(searchLocation);
    }

    /**
     * Clicks the search button to commit a job search
     */
    public void clickJobSearchBtn() {
        wait.until(elementToBeClickable(jobSearchPageLocators.searchBtn));
        driver.findElement(jobSearchPageLocators.searchBtn).click();
    }

    /**
     * Searches for a job
     *
     * @param term The search term text to enter in the field
     * @param location The location text to enter in the field
     */
    public void searchForJobs(String term, String location) {
        enterSearchTermText(term);
        enterSearchLocationText(location);
        clickJobSearchBtn();
    }

    /*--------- Search Results ----------*/

    /**
     * Waits for search results to be retrieved from CloudSearch
     */
   public void waitForSearchResults() {
       for (int i = 0; i < 5; i++) {
           try {
               if (!elementExists(jobSearchPageLocators.searchResultEmployerNameTxt0))
                   clickJobSearchBtn();
           } catch (NoSuchElementException ex) {
               break;
           }
       }
   }

    /**
     * Checks to see if the empty search results text is on the job search page
     */
    public boolean verifyEmptySearchResultTitle() { return elementExists(jobSearchPageLocators.searchResultsEmptyTitleTxt); }

    /**
     * Checks to see if the empty search results message is on the job search page
     */
    public boolean verifyEmptySearchResultMessage() { return elementExists(jobSearchPageLocators.searchResultsEmptyMessageTxt); }

    /**
     * Checks to see if the empty search results suggestions title is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionTitle() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionsTitleTxt); }

    /**
     * Checks to see if the empty search results bartender button is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionBartender() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionBartenderBtn); }

    /**
     * Checks to see if the empty search results cashier button is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionCashier() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionCashierBtn); }

    /**
     * Checks to see if the empty search results cook button is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionCook() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionCookBtn); }

    /**
     * Checks to see if the empty search results server button is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionServer() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionServerBtn); }

    /**
     * Checks to see if the empty search results team member button is on the job search page
     */
    public boolean verifyEmptySearchResultSuggestionTeamMember() { return elementExists(jobSearchPageLocators.searchResultsEmptySuggestionTeamMemberBtn); }

    /**
     * Checks to see if the empty search result elements are on the job search page
     * @return Whether or not the empty search result elements are on the job search page
     */
    public boolean verifyJobSearchEmptyResultElements() {
        if (verifyEmptySearchResultTitle() &&
                verifyEmptySearchResultMessage() &&
                verifyEmptySearchResultSuggestionTitle() &&
                verifyEmptySearchResultSuggestionBartender() &&
                verifyEmptySearchResultSuggestionCashier() &&
                verifyEmptySearchResultSuggestionCook() &&
                verifyEmptySearchResultSuggestionServer() &&
                verifyEmptySearchResultSuggestionTeamMember()) {
            return true;
        }
        return false;
    }

    /**
     * Clicks the view button for a posted job
     */
    public void clickJobPostingViewBtn() {
        if (elementExists(jobSearchPageLocators.searchResultViewBtn0)) {
            wait.until(elementToBeClickable(jobSearchPageLocators.searchResultViewBtn0));
            driver.findElement(jobSearchPageLocators.searchResultViewBtn0).click();
        }
    }

    /**
     * Clicks the apply button for a posted job
     */
    public void clickJobPostingApplyBtn() {
        wait.until(elementToBeClickable(jobSearchPageLocators.searchResultApplyBtn0));
        driver.findElement(jobSearchPageLocators.searchResultApplyBtn0).click();
        wait.until(presenceOfElementLocated(jobSearchPageLocators.searchResultApplyLoadingBtn0));
        wait.until(invisibilityOfElementLocated(jobSearchPageLocators.searchResultApplyLoadingBtn0));
    }

    /**
     * Checks to see if the job is marked as 'Apply' on the job's card
     * @return Whether or not the job is marked as 'Apply' on the job's card
     */
    public boolean verifyJobPostingApplyButton() { return elementExists(jobSearchPageLocators.searchResultApplyBtn0); }

    /**
     * Checks to see if the job is marked as 'Applied' on the job's card
     * @return Whether or not the job is marked as 'Applied' on the job's card
     */
    public boolean verifyJobPostingAppliedButton() { return elementExists(jobSearchPageLocators.searchResultAppliedBtn0); }

    /**
     * Checks to see if the Employer Logo is on the job's card
     * @return Whether or not the Employer Logo is on the job's card
     */
    public boolean verifyEmployerLogo() {
        return elementExists(jobSearchPageLocators.searchResultEmployerImg0);
    }

    /**
     * Checks to see if the job's position matches what is on the job's card
     *
     * @param position The job's position on the job's card
     * @return Whether or not the text for the job's position is the same as the text parameter
     */
    public boolean verifyJobPosition(String position) {
        return position.equals(driver.findElement(jobSearchPageLocators.searchResultPositionTxt0).getText());
    }

    /**
     * Checks to see if the Employer Name matches what is on the job's card
     *
     * @param employerName The employer's name on the job's card
     * @return Whether or not the text for employer name field is the same as the text parameter
     */
    public boolean verifyEmployerName(String employerName) {
        return employerName.equals(driver.findElement(jobSearchPageLocators.searchResultEmployerNameTxt0).getText());
    }

    /**
     * Checks to see if the Employer Distance matches what is on the job's card
     *
     * @param employerDistance The employer's distance from the logged in user on the job's card
     * @return Whether or not the text for employer distance field is the same as the text parameter
     */
    public boolean verifyEmployerDistance(String employerDistance) {
        return employerDistance.equals(driver.findElement(jobSearchPageLocators.searchResultEmployerDistanceTxt0).getText());
    }

    /**
     * Checks to see if the Employer Zip matches what is on the job's card
     *
     * @param employerZip The employer's zip on the job's card
     * @return Whether or not the text for employer zip field is the same as the text parameter
     */
    public boolean verifyEmployerZip(String employerZip) {
        return employerZip.equals(driver.findElement(jobSearchPageLocators.searchResultEmployerZipTxt0).getText());
    }

    /*--------- Job Details ----------*/

    /**
     * Checks to see if the apply button is on the job details page
     * @return Whether or not the apply button is on the job details page
     */
    public boolean verifyJobDetailsApplyButton() {
        return elementExists(jobSearchPageLocators.jobDetailsApplyBtn);
    }

    /**
     * Checks to see if the job is marked as 'Applied' on the job details page
     * @return Whether or not the job is marked as 'Applied' on the job details page
     */
    public boolean verifyJobDetailsAppliedButton() { return elementExists(jobSearchPageLocators.jobDetailsAppliedBtn); }

    /**
     * Checks to see if the follow button is on the job details page
     * @return Whether or not the follow button is on the job details page
     */
    public boolean verifyJobDetailsFollowButton() { return elementExists(jobSearchPageLocators.jobDetailsEmployerFollowBtn); }

    /**
     * Checks to see if the Job Details Position matches what is on the job details page
     *
     * @param jobDetailsPosition The job posting's position
     * @return Whether or not the text for the job details position is the same as the text parameter
     */
    public boolean verifyJobDetailsPosition(String jobDetailsPosition) {
        return jobDetailsPosition.equals(driver.findElement(jobSearchPageLocators.jobDetailsPosition).getText());
    }

    /**
     * Checks to see if the Job Details Wage matches what is on the job details page
     *
     * @param jobDetailsWage The job posting's wage
     * @return Whether or not the text for the job details wage is the same as the text parameter
     */
    public boolean verifyJobDetailsWage(String jobDetailsWage) {
        return jobDetailsWage.equals(driver.findElement(jobSearchPageLocators.jobDetailsWage).getText());
    }

    /**
     * Checks to see if the Job Details job description matches what is on the job details page
     *
     * @param jobDetailsJobDescription The job's description
     * @return Whether or not the text for the job's description is the same as the text parameter
     */
    public boolean verifyJobDetailsJobDescription(String jobDetailsJobDescription) {
        return jobDetailsJobDescription.equals(driver.findElement(jobSearchPageLocators.jobDetailsJobDescriptionTxt).getText());
    }

    /**
     * Checks to see if the Job Details employer description matches what is on the job details page
     *
     * @param jobDetailsEmployerDescription The employer's description
     * @return Whether or not the text for the employer's description is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerDescription(String jobDetailsEmployerDescription) {
        return jobDetailsEmployerDescription.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerDescriptionTxt).getText());
    }

    /**
     * Checks to see if the Job Details Employer Logo is on the job details page
     * @return Whether or not the Employer Logo is on the job details page
     */
    public boolean verifyJobDetailsEmployerLogo() { return elementExists(jobSearchPageLocators.jobDetailsEmployerLogoImg); }

    /**
     * Checks to see if the Job Details employer name matches what is on the job details page
     *
     * @param jobDetailsEmployerName The employer's name
     * @return Whether or not the text for the employer's description is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerName(String jobDetailsEmployerName) {
        return jobDetailsEmployerName.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerNameTxt).getText());
    }

    /**
     * Checks to see if the Job Details employer address matches what is on the job details page
     *
     * @param jobDetailsEmployerAddress The employer's address
     * @return Whether or not the text for the employer's address is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerAddress(String jobDetailsEmployerAddress) {
        return jobDetailsEmployerAddress.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerAddressTxt).getText());
    }

    /**
     * Checks to see if the Job Details employer ppa matches what is on the job details page
     *
     * @param jobDetailsEmployerPPA The employer's ppa
     * @return Whether or not the text for the employer's ppa is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerPPA(String jobDetailsEmployerPPA) {
        return jobDetailsEmployerPPA.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerPPATxt).getText());
    }

    /**
     * Checks to see if the Job Details employer type matches what is on the job details page
     *
     * @param jobDetailsEmployerType The employer's type
     * @return Whether or not the text for the employer's type is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerType(String jobDetailsEmployerType) {
        return jobDetailsEmployerType.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerTypeTxt).getText());
    }

    /**
     * Checks to see if the Job Details employer distance matches what is on the job details page
     *
     * @param jobDetailsEmployerDistance The employer's distance
     * @return Whether or not the text for the employer's distance is the same as the text parameter
     */
    public boolean verifyJobDetailsEmployerDistance(String jobDetailsEmployerDistance) {
        return jobDetailsEmployerDistance.equals(driver.findElement(jobSearchPageLocators.jobDetailsEmployerDistanceTxt).getText());
    }

    public void clickJobDetailsBackButton () {
        if (elementExists(jobSearchPageLocators.jobDetailsBackBtn)) {
            wait.until(elementToBeClickable(jobSearchPageLocators.jobDetailsBackBtn));
            driver.findElement(jobSearchPageLocators.jobDetailsBackBtn).click();
        }
    }
}