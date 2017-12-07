import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class EmployerProfileJobsPage extends BasePage {

    Locators.EmployerProfileEditJobsPageLocators employerProfileEditJobsPageLocators;
    TestUtils testUtils;

    public EmployerProfileJobsPage(WebDriver driver) {
        super(driver);
        employerProfileEditJobsPageLocators = new Locators.EmployerProfileEditJobsPageLocators();
        testUtils = new TestUtils(driver);
    }

    /**
     * Select add new position button
     */
    public void selectAddNewJob() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAddNewJobBtn).click();
    }

    /**
     * Get job position text
     *
     * @return The job position text
     */
    public String getJobPositionTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobTypeInput).getAttribute("value");
    }

    /**
     * Select the job's type
     *
     * @param index The index of the job type to select
     */
    public void setJobPosition(String index) {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobTypeInput).click();
        driver.findElement(employerProfileEditJobsPageLocators.findEmployerJobTypeByIndex(index)).click();
    }

    /**
     * Get job custom position text
     *
     * @return The job custom position text
     */
    public String getJobCustomNameTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringCustomJobNameField).getAttribute("value");
    }

    /**
     * Specify a custom job position name
     */
    public void setJobPositionCustomName(String name) {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringCustomJobNameField).sendKeys(name);
    }

    /**
     * Get job description text
     *
     * @return The job description text
     */
    public String getJobDescriptionTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobDescriptionField).getText();
    }

    /**
     * Add employer job description
     *
     * @param description the employer's job description
     */
    public void setJobDescription(String description) {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobDescriptionField).sendKeys(description);
    }

    /**
     * Delete employer job description
     */
    public void deleteJobDescription() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobDescriptionField).clear();
    }

    /**
     * Update employer job description
     *
     * @param description the employer's job description
     */
    public void updateJobDescription(String description) {
        deleteJobDescription();
        setJobDescription(description);
    }

    /**
     * Get job responsibilities text
     *
     * @return The job responsibilities text
     */
    public String getJobResponsibilitiesTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobResponsibilitiesField).getText();
    }

    /**
     * Add employer job responsibilities
     *
     * @param responsibilities the employer's job responsibilities
     */
    public void setJobResponsibilities(String responsibilities) {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobResponsibilitiesField).sendKeys(responsibilities);
    }

    /**
     * Delete employer job responsibilities
     */
    public void deleteJobResponsibilities() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobResponsibilitiesField).clear();
    }

    /**
     * Update employer job responsibilities
     *
     * @param responsibilities the employer's job responsibilities
     */
    public void updateJobResponsibilities(String responsibilities) {
        deleteJobResponsibilities();
        setJobResponsibilities(responsibilities);
    }

    /**
     * Select age requirement
     */
    public void selectAgeRequirement() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobAgeRequirementChk).click();
    }

    /**
     * Checks to see if a job's age requirement checkbox is selected
     *
     * @return Whether or not a job's age requirement checkbox is selected
     */
    public boolean isAgeRequirementSelected() {
        return isCheckboxSelected(driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringJobAgeRequirementChk));
    }

    /**
     * Select the job's required skill by index
     *
     * @param index The index of the job's skill to select
     */
    public void setJobSkill(String index) {
        driver.findElement(employerProfileEditJobsPageLocators.findSkillByIndex(index)).click();
    }

    /**
     * Checks to see if a job's skill is selected
     *
     * @param index The index of the job's skill
     * @return Whether or not a job's skill is selected
     */
    public boolean isSkillSelected(String index) {
        return elementExists(employerProfileEditJobsPageLocators.findSelectedSkillByIndex(index));
    }

    /**
     * Select the job's required certification by index
     *
     * @param index The index of the job's certification to select
     */
    public void setJobCertification(String index) {
        driver.findElement(employerProfileEditJobsPageLocators.findCertificationByIndex(index)).click();
    }

    /**
     * Checks to see if a job's certification checkbox is selected
     *
     * @param index the index of the certification
     * @return Whether or not a job's certification checkbox is selected
     */
    public boolean isCertificationSelected(String index) {
        return isCheckboxSelected(driver.findElement(employerProfileEditJobsPageLocators.findCertificationByIndex(index)));
    }

    /**
     * Set the job's minimum wage
     *
     * @param xOffset The # of pixels to move horizontally
     * @param yOffset The # of pixels to move vertically
     */
    public void setJobMinWage(int xOffset, int yOffset) {
        WebElement minWage = driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringMinimumWageSlider);
        testUtils.dragAndDropElement(minWage, xOffset, yOffset);
    }

    /**
     * Get job minimum wage text
     *
     * @return The minimum wage text
     */
    public String getJobMinWageTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringMinimumWageTxt).getText();
    }

    /**
     * Set the job's maximum wage
     *
     * @param xOffset The # of pixels to move horizontally
     * @param yOffset The # of pixels to move vertically
     */
    public void setJobMaxWage(int xOffset, int yOffset) {
        WebElement maxWage = driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringMaximumWageSlider);
        testUtils.dragAndDropElement(maxWage, xOffset, yOffset);
    }

    /**
     * Get job maximum wage text
     *
     * @return The maximum wage text
     */
    public String getJobMaxWageTxt() {
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringMaximumWageTxt).getText();
    }

    /**
     * Select the job's availability full-time
     */
    public void setJobAvailabilityFullTime() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityFTBtn).click();
    }

    /**
     * Checks to see if a job's full-time availability is selected
     *
     * @return Whether or not full-time availability is selected
     */
    public boolean isJobAvailabilityFullTimeSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityFTBtn);
    }

    /**
     * Select the job's availability part-time
     */
    public void setJobAvailabilityPartTime() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityPTBtn).click();
    }

    /**
     * Checks to see if a job's part-time availability is selected
     *
     * @return Whether or not part-time availability is selected
     */
    public boolean isJobAvailabilityPartTimeSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityPTBtn);
    }

    /**
     * Select the job's availability Seasonal
     */
    public void setJobAvailabilitySeasonal() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilitySeasonalBtn).click();
    }

    /**
     * Checks to see if a job's seasonal availability is selected
     *
     * @return Whether or not seasonal availability is selected
     */
    public boolean isJovAvailabilitySeasonalSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilitySeasonalBtn);
    }

    /**
     * Select the job's availability Anything
     */
    public void setJobAvailabilityAnything() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityAnythingBtn).click();
    }

    /**
     * Checks to see if a job's anything availability is selected
     *
     * @return Whether or not anything availability is selected
     */
    public boolean isJobAvailabilityAnythingSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringAvailabilityAnythingBtn);
    }

    /**
     * Select the job's morning shift
     */
    public void setJobShiftMorning() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleMorningsBtn).click();
    }

    /**
     * Checks to see if a job's morning shift is selected
     *
     * @return Whether or not the job's morning shift is selected
     */
    public boolean isJobShiftMorningSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleMorningsSelectedBtn);
    }

    /**
     * Select the job's afternoon shift
     */
    public void setJobShiftAfternoon() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleAfternoonsBtn).click();
    }

    /**
     * Checks to see if a job's afternoon shift is selected
     *
     * @return Whether or not the job's morning shift is selected
     */
    public boolean isJobShiftAfternoonSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleAfternoonsSelectedBtn);
    }

    /**
     * Select the job's evening shift
     */
    public void setJobShiftEvening() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleEveningsBtn).click();
    }

    /**
     * Checks to see if a job's evening shift is selected
     *
     * @return Whether or not the job's evening shift is selected
     */
    public boolean isJobShiftEveningSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleEveningsSelectedBtn);
    }

    /**
     * Select the job's night shift
     */
    public void setJobShiftNight() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleNightsBtn).click();
    }

    /**
     * Checks to see if a job's night shift is selected
     *
     * @return Whether or not the job's night shift is selected
     */
    public boolean isJobShiftNightSelected() {
        return elementExists(employerProfileEditJobsPageLocators.employerProfileEditHiringShiftScheduleNightsSelectedBtn);
    }

    /**
     * Checks to see if the save button is enabled
     *
     * @return Whether or not the save button is enabled
     */
    public boolean isSaveButtonEnabled() {
        return (driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringSaveBtn).isEnabled());
    }

    /**
     * Selects the save button
     */
    public void selectSaveBtn() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringSaveBtn).click();
    }

    /**
     * Selects the delete button
     */
    public void selectDeleteBtn() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringDeleteBtn).click();
    }

    /**
     * Selects the delete confirmation button
     */
    public void selectDeleteConfirmationBtn() {
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringDeleteConfirmBtn).click();
    }

    /**
     * Delete job
     */
    public void deleteJob() {
        selectDeleteBtn();
        selectDeleteConfirmationBtn();
    }

    /**
     * Checks to see if the employer job success toast is visible
     *
     * @return Whether or not the employer job success toast is visible
     */
    public boolean verifyEmployerJobSuccessToast() {
        wait.until(presenceOfElementLocated(employerProfileEditJobsPageLocators.employerProfileEditHiringAddJobConfirmationToast));
        return driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAddJobConfirmationToast).isDisplayed();
    }

    /**
     * Clicks the 'X' to dismiss the employer job success toast
     */
    public void dismissEmployerJobSuccessToast() {
        wait.until(elementToBeClickable(employerProfileEditJobsPageLocators.employerProfileEditHiringAddJobConfirmationToastDismissBtn));
        driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringAddJobConfirmationToastDismissBtn).click();
        wait.until(invisibilityOfElementLocated(employerProfileEditJobsPageLocators.employerProfileEditHiringAddJobConfirmationToast));
    }

    /**
     * Waits for the loading indicator
     */
    public void waitForLoadingIndicator() {
        if (driver.findElement(employerProfileEditJobsPageLocators.employerProfileEditHiringLoadingIndicator).isDisplayed()) {
            wait.until(invisibilityOfElementLocated(employerProfileEditJobsPageLocators.employerProfileEditHiringLoadingIndicator));
        }
    }
}
