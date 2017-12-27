import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class EmployerProfileViewPage extends BasePage {

    Locators.EmployerProfileViewPageLocators profilePageLocators;
    TestUtils testUtils;

    public EmployerProfileViewPage(WebDriver driver) {
        super(driver);
        profilePageLocators = new Locators.EmployerProfileViewPageLocators();
        testUtils = new TestUtils(driver);
    }

    /*--------- Store Photos ----------*/

    /**
     * Checks to see if an employer photos is on the profile page
     *
     * @param index The index of the store photo (starting at 0)
     * @return Whether or not an employer photo is on the profile page
     */
    public boolean isEmployerPhotoPresent(String index) {
        return elementExists(profilePageLocators.findEmployerPhotoByIndex(index));
    }

    /*--------- Employer Info ----------*/

    /**
     * Checks to see if the employer's logo is on the profile page
     * @return Whether or not the employer's logo is on the profile page
     */
    public boolean isEmployerLogoPresent() {
        return elementExists(profilePageLocators.employerHeaderLogoImg);
    }

    /**
     * Get employer's name
     * @return Employer's name
     */
    public String getEmployerHeaderName() {
        return driver.findElement(profilePageLocators.employerHeaderNameTxt).getText();
    }

    /**
     * Get employer's address
     * @return Employer's address
     */
    public String getEmployerHeaderAddress() {
        return driver.findElement(profilePageLocators.employerHeaderAddressTxt).getText();
    }

    /**
     * Selects employer profile info edit button
     */
    public void selectEmployerInfoEditBtn() {
        driver.findElement(profilePageLocators.employerHeaderEditProfileBtn).click();
    }

    /**
     * Selects employer profile info edit button
     */
    public void selectEmployerInfoMapLink() {
        driver.findElement(profilePageLocators.employerMapLink).click();
    }

    /**
     * Get employer card city
     * @return Employer's city
     */
    public String getEmployerCardCity() {
        return driver.findElement(profilePageLocators.employerCityTxt).getText();
    }

    /**
     * Get employer card distance
     * @return Employer's distance from auth'd user
     */
    public String getEmployerCardDistance() {
        return driver.findElement(profilePageLocators.employerDistanceTxt).getText();
    }

    /**
     * Get employer card distance
     * @return Employer's distance from auth'd user
     */
    public String getEmployerCardAddress() {
        return driver.findElement(profilePageLocators.employerAddressTxt).getText();
    }

    /**
     * Get employer card website
     * @return Employer's website url
     */
    public String getEmployerCardWebsite() {
        return driver.findElement(profilePageLocators.employerWebsiteLink).getText();
    }

    /**
     * Get employer card phone #
     * @return Employer's phone #
     */
    public String getEmployerCardPhone() {
        return driver.findElement(profilePageLocators.employerPhoneLink).getText();
    }


    /*--------- About ----------*/

    /**
     * Verifies that the about title is displayed
     * @return Whether or not the about title is displayed
     */
    public boolean isAboutHeaderDisplayed() {
        return elementExists(profilePageLocators.employerAboutTitleTxt);
    }

    /**
     * Gets the about title text on the employer view profile screen
     * @return The about title text
     */
    public String getAboutTitleTxt() {
        return driver.findElement(profilePageLocators.employerAboutTitleTxt).getText();
    }

    /**
     * Clicks the edit about button
     */
    public void selectEditAboutBtn() {
        wait.until(elementToBeClickable(profilePageLocators.employerAboutEditBtn));
        driver.findElement(profilePageLocators.employerAboutEditBtn).click();
    }

    /**
     * Gets the about text on the employer view profile screen
     * @return The about text
     */
    public String getAboutTxt() {
        return driver.findElement(profilePageLocators.employerAboutTxt).getText();
    }

    /*--------- Store Management ----------*/

    /**
    * Checks to see if the Store Management section header is displayed
     * @return Whether or not the Store Management section header is displayed
    */
    public Boolean isManagementHeaderDisplayed(){
        return elementExists(profilePageLocators.employerManagementTitleTxt);
    }

    /**
     * Checks to see if the manager's photo is displayed
     *
     * @param index The index of the store manager's photo (starting at 0)
     * @return Whether or not the manager's photo is displayed
     */
    public Boolean isManagerPhotoDisplayed(String index){
        return elementExists(profilePageLocators.findEmployerManagerPhotoByIndex(index));
    }

    /**
     * Gets the store manager's name
     *
     * @param index The index of the store manager's name (starting at 0)
     * @return The manager's first and last name
     */
    public String getManagerName(String index){
        return driver.findElement(profilePageLocators.findEmployerManagerNameByIndex(index)).getText();
    }

    /**
     * Gets the store manager's label
     *
     * @param index The index of the store manager's label (starting at 0)
     * @return The manager's label
     */
    public String getManagerLabel(String index){
        return driver.findElement(profilePageLocators.findEmployerManagerLabelByIndex(index)).getText();
    }

    /**
     * Gets the store manager's description
     *
     * @param index The index of the store manager's description (starting at 0)
     * @return The manager's description
     */
    public String getManagerDescription(String index){
        return driver.findElement(profilePageLocators.findEmployerManagerDescriptionByIndex(index)).getText();
    }

    /**
     * Clicks the edit store management button
     */
    public void selectEditManagementBtn() {
        driver.findElement(profilePageLocators.employerManagementEditBtn).click();
    }

    /*--------- Open Jobs ----------*/

    /**
     * Checks to see if the Open Jobs section header is displayed
     * @return Whether or not the Open Jobs section header is displayed
     */
    public Boolean isJobsHeaderDisplayed(){
        return elementExists(profilePageLocators.employerJobTitleTxt);
    }

    /**
     * Gets the job position
     *
     * @param index The index of the job card's position (starting at 0)
     * @return The job position
     */
    public String getJobPosition(String index){
        return driver.findElement(profilePageLocators.findEmployerJobCardPositionByIndex(index)).getText();
    }

    /**
     * Gets the job wage
     *
     * @param index The index of the job card's wage (starting at 0)
     * @return The job wage
     */
    public String getJobWage(String index){
        return driver.findElement(profilePageLocators.findEmployerJobCardWageByIndex(index)).getText();
    }

    /**
     * Gets the job availability
     *
     * @param index The index of the job card's availability (starting at 0)
     * @return The job availability
     */
    public String getJobAvailability(String index){
        return driver.findElement(profilePageLocators.findEmployerJobCardAvailabilityByIndex(index)).getText();
    }

    /**
     * Scroll to job cards
     * @param index the index of the job card to scroll to
     */
    public void scrollToJobCard(String index){
        WebElement jobCard = driver.findElement(profilePageLocators.findEmployerJobCardLogoByIndex(index));
        testUtils.jsExecutorElement("arguments[0].scrollIntoView(true);", jobCard);
    }


    /**
     * Select the job's view button
     * @param index The index of the job card's view button (starting at 0)
     */
    public void selectJobViewBtn(String index){
        driver.findElement(profilePageLocators.findEmployerJobCardViewBtnByIndex(index)).click();
    }

    /**
     * Select the job's edit button
     * @param index The index of the job card's edit button (starting at 0)
     */
    public void selectJobEditBtn(String index){
        driver.findElement(profilePageLocators.findEmployerJobCardEditBtnByIndex(index)).click();
    }

    /**
     * Select the job's apply button
     * @param index The index of the job card's apply button (starting at 0)
     */
    public void selectJobApplyBtn(String index){
        driver.findElement(profilePageLocators.findEmployerJobCardApplyBtnByIndex(index)).click();
    }

    /**
     * Checks to see if the employer's logo is on the job card
     * @return Whether or not the employer's logo is on the job card
     */
    public boolean isJobCardEmployerLogoPresent() {
        return elementExists(profilePageLocators.employerHeaderLogoImg);
    }

    /**
     * Gets the job card employer name
     * @param index The index of the job card's employer name (starting at 0)
     * @return The job card's employer name
     */
    public String getJobCardEmployerName(String index){
        return driver.findElement(profilePageLocators.findEmployerJobCardNameByIndex(index)).getText();
    }

    /**
     * Gets the job card employer address
     * @param index The index of the job card's employer address (starting at 0)
     * @return The job card's employer address
     */
    public String getJobCardEmployerAddress(String index){
        return driver.findElement(profilePageLocators.findEmployerJobCardAddressByIndex(index)).getText();
    }

    /*---------- Utility Methods ----------*/

    /**
     * Clicks on the manage store button on the view profile page
     */
    public void selectManageStore() {
        driver.findElement(profilePageLocators.employerEditProfileBtn).click();
    }

    /**
     * Waits for the loading indicator on the view profile page
     */
    public void waitForLoadingIndicator() {
        try {
            if (driver.findElement(profilePageLocators.employerProfileLoadingIndicator).isDisplayed()) {
                wait.until(invisibilityOfElementLocated(profilePageLocators.employerProfileLoadingIndicator));
            }
        } catch (NoSuchElementException e) {
            System.out.println("***\n" + "Loading indicator not displayed due to NoSuchElementException..." + "\n***");
        } catch (StaleElementReferenceException se) {
            System.out.println("***\n" +"Loading indicator not displayed due to StaleElementReferenceException..." + "\n***");
        }
    }
}
