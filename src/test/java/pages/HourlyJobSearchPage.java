package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Locators;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HourlyJobSearchPage extends BasePage {
    Locators.JobSearchPageLocators jobSearchPageLocators;

    public HourlyJobSearchPage(WebDriver driver) {
        super(driver);
        jobSearchPageLocators = new Locators.JobSearchPageLocators();
    }

    /*--------- Search Field ----------*/

    /**
     * Checks to see if the job type dropdown is on the job search page
     * @return Whether or not the job type dropdown is on the job search page
     */
    public boolean verifyPositionDropdown() {
        wait.until(visibilityOfElementLocated(jobSearchPageLocators.searchPositionDropdown));
        return elementExists(jobSearchPageLocators.searchPositionDropdown);
    }

    /**
     * Opens the position drop down and selects a position from the list
     * @param index The index (starting at 0) of the position you'd like to select
     */
    public void clickJobPositionToSearch(String index){
        wait.until(elementToBeClickable(jobSearchPageLocators.searchPositionDropdown));
        driver.findElement(jobSearchPageLocators.searchPositionDropdown).click();
        wait.until(elementToBeClickable(jobSearchPageLocators.findJobSearchPositionByIndex(index)));
        driver.findElement(jobSearchPageLocators.findJobSearchPositionByIndex(index)).click();
    }

    /**
     * Checks to see if the search location field is on the job search page
     * @return Whether or not the location field is on the job search page
     */
    public boolean verifySearchLocationField() {
        return elementExists(jobSearchPageLocators.searchLocationField);
    }

    /**
     * Enter search location text into search location field
     * @param searchLocation The search location text to enter in the field
     */
    public void enterSearchLocationText(String searchLocation) throws Exception {
        wait.until(elementToBeClickable(jobSearchPageLocators.searchLocationField));
        driver.findElement(jobSearchPageLocators.searchLocationField).click();
        Thread.sleep(500);
        driver.findElement(jobSearchPageLocators.searchLocationField).clear();
        Thread.sleep(500);
        driver.findElement(jobSearchPageLocators.searchLocationField).sendKeys(searchLocation);
        Thread.sleep(1500);
        driver.findElement(jobSearchPageLocators.searchLocationField).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1500);
        driver.findElement(jobSearchPageLocators.searchLocationField).sendKeys(Keys.ENTER);
        Thread.sleep(1500);
    }

    /**
     * Searches for a job
     * @param index The index (starting at 0) of the position you'd like to search for
     * @param location The location text to enter in the field
     */
    public void searchForJobs(String index, String location) throws Exception {
        //clickJobPositionToSearch(index);
        enterSearchLocationText(location);
    }

    /*--------- Search Results ----------*/

    /**
     * Waits for search results to be retrieved from CloudSearch
     * @param index The index (Starting at 0) of the search result you wish to locate
     */
   public void waitForSearchResults(String index) {
       for (int i = 0; i < 10; i++) {
           try {
               if (elementExists(jobSearchPageLocators.emptySearchTextTitle))
                   driver.navigate().to(driver.getCurrentUrl());
           } catch (NoSuchElementException ex) {
               break;
           }
       }
   }

    /**
     * Gets the search results count text
     * @return The search results count text
     */
    public String getSearchResultsCount() {
        return driver.findElement(jobSearchPageLocators.searchResultsCountTxt).getText();
    }

    /**
     * Checks to see if the empty search results text is on the job search page
     */
    public boolean verifyEmptySearchResultTitle() {
        return elementExists(jobSearchPageLocators.emptySearchTextTitle);
    }

    /**
     * Checks to see if the empty search results message is on the job search page
     */
    public boolean verifyEmptySearchResultMessage() {
        return elementExists(jobSearchPageLocators.searchResultsEmptyMessageTxt);
    }

    /**
     * Checks to see if the empty search result elements are on the job search page
     * @return Whether or not the empty search result elements are on the job search page
     */
    public boolean verifyJobSearchEmptyResultElements() {
        if (verifyEmptySearchResultTitle() &&
                verifyEmptySearchResultMessage()){
            return true;
        }
        return false;
    }

    /**
     * Hover over Job Box at given position
     * @param index
     */
    public void hoverOverJobAtPosition(String index){
        Actions action = new Actions(driver);
        WebElement logo = driver.findElement(jobSearchPageLocators.findSearchResultEmployerImgByIndex(index));
        action.moveToElement(logo).build().perform();
    }
    /**
     * Clicks the view button for a posted job
     * @param index The index (Starting at 0) of the search result view button you wish to locate
     */
    public void clickJobPostingViewBtn(String index) {
            hoverOverJobAtPosition(index);
            driver.findElement(jobSearchPageLocators.findSearchResultViewBtnByIndex(index)).click();
            wait.until(visibilityOfElementLocated(jobSearchPageLocators.jobDetailsApplyBtn));
        }

    /**
     * Clicks the apply button for a posted job
     * @param index The index (Starting at 0) of the search result apply button you wish to locate
     */
    public void clickJobPostingApplyBtn(String index) {
        driver.findElement(jobSearchPageLocators.findSearchResultApplyBtnByIndex(index)).click();
    }

    /**
     * Checks to see if the job search apply button is enabled at a given index
     * @param index The index (starting at 0) of the job's apply button you wish to locate
     * @return Whether or not the apply button is enabled
     */
    public boolean isApplyButtonEnabled(String index){
        hoverOverJobAtPosition(index);
        return (driver.findElement(jobSearchPageLocators.findSearchResultApplyBtnByIndex(index)).isEnabled());
    }

    /**
     * Checks to see if the Employer Logo is on the job's card
     * @param index The index (Starting at 0) of the search result image you wish to locate
     * @return Whether or not the Employer Logo is on the job's card
     */
    public boolean verifyEmployerLogo(String index) {
        return elementExistsLongTimeout(jobSearchPageLocators.findSearchResultEmployerImgByIndex(index));
    }

    /**
     * Gets the job position text on the job card at a given index
     * @param index The index (Starting at 0) of the search result position you wish to locate
     * @return The job position text
     */
    public String getJobPosition(String index) {
        return driver.findElement(jobSearchPageLocators.findSearchResultPositionTxtByIndex(index)).getText();
    }

    /**
     * Gets the employer name text on the job card at a given index
     * @param index The index (Starting at 0) of the search result employer name you wish to locate
     * @return The employer name text
     */
    public String getEmployerName(String index) {
        return driver.findElement(jobSearchPageLocators.findSearchResultEmployerNameTxtByIndex(index)).getText();
    }

    /**
     * Gets the employer's location at a given index
     * @param index The index (Starting at 0) of the search result employer location you wish to locate
     * @return The employer location text
     */
    public String getEmployerLocation(String index) {
        return driver.findElement(jobSearchPageLocators.findSearchResultEmployerLocationTxtByIndex(index)).getText();
    }


    /*--------- Job Details ----------*/

    /**
     * Checks to see if the job search apply button is enabled at a given index
     * @return Whether or not the apply button is enabled
     */
    public boolean isJobDetailsApplyButtonEnabled(){
        return (driver.findElement(jobSearchPageLocators.jobDetailsApplyBtn).isEnabled());
    }

    /**
     * Checks to see if the follow button is on the job details page
     * @return Whether or not the follow button is on the job details page
     */
    public boolean verifyJobDetailsFollowButton() {
        return elementExists(jobSearchPageLocators.jobDetailsEmployerFollowBtn);
    }

    /**
     * Checks to see if the following button is on the job details page
     * @return Whether or not the following button is on the job details page
     */
    public boolean verifyJobDetailsFollowingButton() {
        return elementExists(jobSearchPageLocators.jobDetailsEmployerFollowingBtn);
    }

    /**
     * Gets the Job Details Position
     * @return The job details position text
     */
    public String getJobDetailsPosition() {
        return driver.findElement(jobSearchPageLocators.jobDetailsPositionTxt).getText();
    }

    /**
     * Gets the Job Details Wage
     * @return The job details wage text
     */
    public String getJobDetailsWage() {
        return driver.findElement(jobSearchPageLocators.jobDetailsWageTxt).getText();
    }

    /**
     * Gets the Job Details job description
     * @return The job details description text
     */
    public String getJobDetailsJobDescription() {
        return driver.findElement(jobSearchPageLocators.jobDetailsJobDescriptionTxt).getText();
    }

    /**
     * Checks to see if the Job Details Employer Logo is on the job details page
     * @return Whether or not the Employer Logo is on the job details page
     */
    public boolean verifyJobDetailsEmployerLogo() {
        return elementExists(jobSearchPageLocators.jobDetailsEmployerLogoImg); }

    /**
     * Gets the Job Details employer name
     * @return The job details employer name text
     */
    public String getJobDetailsEmployerName() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerNameTxt).getText();
    }

    /**
     * Gets the Job Details employer address
     * @return The job details employer address text
     */
    public String getJobDetailsEmployerAddress() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerAddressTxt).getText();
    }

    /**
     * Gets the Job Details employer ppa
     * @return The job details employer ppa text
     */
    public String getJobDetailsEmployerPPA() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerPPATxt).getText();
    }

    /**
     * Gets the Job Details employer type
     * @return The Job Details employer type text
     */
    public String getJobDetailsEmployerType() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerTypeTxt).getText();
    }

    /**
     * Gets the Job Details employer distance
     * @return The Job Details employer distance text
     */
    public String getJobDetailsEmployerDistance() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerDistanceTxt).getText();
    }

    /**
     * Gets the Job Details employer description title
     * @return The Job Details employer description title
     */
    public String getJobDetailsEmployerDescriptionTitle() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerDescriptionTitleTxt).getText();
    }

    /**
     * Gets the Job Details employer description
     * @return The Job Details employer description text
     */
    public String getJobDetailsEmployerDescription() {
        return driver.findElement(jobSearchPageLocators.jobDetailsEmployerDescriptionTxt).getText();
    }

    /**
     * Clicks the follow button on the job details to follow the selected employer
     */
    public void clickJobDetailsFollowButton() {
        if (elementExists(jobSearchPageLocators.jobDetailsEmployerFollowBtn)) {
            wait.until(elementToBeClickable(jobSearchPageLocators.jobDetailsEmployerFollowBtn));
            driver.findElement(jobSearchPageLocators.jobDetailsEmployerFollowBtn).click();
        }
    }

    /**
     * Clicks the following button on the job details to unfollow the selected employer
     */
    public void clickJobDetailsFollowingButton() {
        if (elementExists(jobSearchPageLocators.jobDetailsEmployerFollowingBtn)) {
            wait.until(elementToBeClickable(jobSearchPageLocators.jobDetailsEmployerFollowingBtn));
            driver.findElement(jobSearchPageLocators.jobDetailsEmployerFollowingBtn).click();
        }
    }

    /**
     * Checks to see if the apply success toast is visible
     * @return Whether or not the apply success toast is visible
     */
    public boolean verifyJobDetailsApplySuccessToast(){
        wait.until(visibilityOfElementLocated(jobSearchPageLocators.jobDetailsApplySuccessToastTxt));
        return elementExists(jobSearchPageLocators.jobDetailsApplySuccessToastTxt);
    }

    /**
     * Clicks the 'X' to dismiss the job details apply success toast
     */
    public void dismissJobDetailsApplySuccessToast(){
        wait.until(elementToBeClickable(jobSearchPageLocators.jobDetailsApplySuccessToastDismissBtn));
        driver.findElement(jobSearchPageLocators.jobDetailsApplySuccessToastDismissBtn).click();
        wait.until(invisibilityOfElementLocated(jobSearchPageLocators.jobDetailsApplySuccessToastTxt));
    }

    /**
     * Checks to see if the follow success toast is visible
     * @return Whether or not the follow success toast is visible
     */
    public boolean verifyFollowSuccessToast(){
        wait.until(visibilityOfElementLocated(jobSearchPageLocators.jobDetailsEmployerFollowToastTxt));
        return elementExists(jobSearchPageLocators.jobDetailsEmployerFollowToastTxt);
    }

    /**
     * Clicks the 'X' to dismiss the follow success toast
     */
    public void dismissFollowSuccessToast(){
        wait.until(elementToBeClickable(jobSearchPageLocators.jobDetailsEmployerFollowToastDismissBtn));
        driver.findElement(jobSearchPageLocators.jobDetailsEmployerFollowToastDismissBtn).click();
        wait.until(invisibilityOfElementLocated(jobSearchPageLocators.jobDetailsEmployerFollowToastTxt));
    }
}