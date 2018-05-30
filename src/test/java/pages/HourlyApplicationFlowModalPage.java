package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Locators;
import utils.TestUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HourlyApplicationFlowModalPage extends BasePage{
    Locators.JobSearchPageLocators jobSearchPageLocators;
    Locators.ApplicationFlowModal applicationFlowModal ;
    TestUtils testUtils;

    public HourlyApplicationFlowModalPage(WebDriver driver) {
        super(driver);
        jobSearchPageLocators = new Locators.JobSearchPageLocators();
        applicationFlowModal = new Locators.ApplicationFlowModal();
        testUtils = new TestUtils(driver);
    }

    /* Click Join using Email button */
    public void clickJoinUsingEmailBtn(){
        driver.findElement(applicationFlowModal.joinUsingEmailBtn).click();
    }

    /* Enter First Name */
    public void enterFirstName(String firstName){
        ((JavascriptExecutor)driver).executeScript("window.focus();");
        new Actions(driver).moveToElement(driver.findElement(applicationFlowModal.firstNameTxt)).click().perform();
        driver.findElement(applicationFlowModal.firstNameTxt).sendKeys(firstName);
    }

    /* Enter Last Name */
    public void enterLastName(String lastName){
        driver.findElement(applicationFlowModal.firstNameTxt).sendKeys(Keys.TAB);
        driver.findElement(applicationFlowModal.lastNameTxt).click();
       //
        //driver.findElement(applicationFlowModal.lastNameLabel).click();
        driver.findElement(applicationFlowModal.lastNameTxt).sendKeys(lastName);
    }

    /* Enter Email */
    public void enterEmail(String email){
        driver.findElement(applicationFlowModal.emailTxt).click();
        driver.findElement(applicationFlowModal.emailTxt).sendKeys(email);
    }

    /* Enter Password */
    public void enterPassword(String password){
        driver.findElement(applicationFlowModal.passwordTxt).click();
        driver.findElement(applicationFlowModal.passwordTxt).sendKeys(password);
    }

    /* Click Continue Button in the Sign Up modal */
    public void clickContinueBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.continueSignUpBtn));
        driver.findElement(applicationFlowModal.continueSignUpBtn).click();
    }

    /**
     * Waits for the apply success toast to be visible
     */
    public void waitForApplySuccessToast(){
        wait.until(presenceOfElementLocated(applicationFlowModal.successDoneBtn));
    }

    /**
     * Clicks the 'X' to dismiss the apply success toast
     */
    public void dismissApplySuccessToast(){
        wait.until(elementToBeClickable(applicationFlowModal.successDoneBtn));
        driver.findElement(applicationFlowModal.successDoneBtn).click();
        wait.until(invisibilityOfElementLocated(applicationFlowModal.successDoneBtn));
    }

    /**
     * Click the Continue button to access the forms to enter Profile Info: Experience, Availability, Skills
     */
    public void clickContinueToAddProfileInfo(){
        wait.until(elementToBeClickable(applicationFlowModal.continueToApplicationFlowBtn));
        driver.findElement(applicationFlowModal.continueToApplicationFlowBtn).click();
    }

    /**
     * Enter Restaurant or Company for Work Experience
     * @param experience
     * @throws Exception
     */
    public void enterExperience(String experience) throws Exception{
        driver.findElement(applicationFlowModal.restaurantInputDropdown).click();
        wait.until(elementToBeClickable(applicationFlowModal.restaurantInputDropdown));
        driver.findElement(applicationFlowModal.restaurantInputDropdown).sendKeys(experience);
        Thread.sleep(500);
        driver.findElement(applicationFlowModal.restaurantInputDropdown).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(applicationFlowModal.restaurantInputDropdown).sendKeys(Keys.ENTER);
    }

    /**
     * Selects a job position from the position drop down
     * @param index The index (Starting at 0) of the position you wish to locate
     */
    public void selectJobPosition(String index) {
        wait.until(elementToBeClickable(applicationFlowModal.jobtitleInputDropdown));
        driver.findElement(applicationFlowModal.jobtitleInputDropdown).click();
        wait.until(elementToBeClickable(applicationFlowModal.getJobByIndex(index)));
        driver.findElement(applicationFlowModal.getJobByIndex(index)).click();
    }

    /**
     * Select Month for From dropdown
     * @param month
     */
    public void selectFromMonth(String month) {
        wait.until(elementToBeClickable(applicationFlowModal.fromMonthSelectBox));
        Select selectFromMonth = new Select(driver.findElement(applicationFlowModal.fromMonthSelectBox));
        selectFromMonth.selectByVisibleText(month);
    }

    /**
     * Select Year for From dropdown
     * @param year
     */
    public void selectFromYear(String year) {
        wait.until(elementToBeClickable(applicationFlowModal.fromYearSelectBox));
        Select selectFromYear = new Select(driver.findElement(applicationFlowModal.fromYearSelectBox));
        selectFromYear.selectByValue(year);
    }

    /**
     * Select Month for To dropdown
     * @param month
     */
    public void selectToMonth(String month) {
        wait.until(elementToBeClickable(applicationFlowModal.toMonthSelectBox));
        Select selectToMonth = new Select(driver.findElement(applicationFlowModal.toMonthSelectBox));
        selectToMonth.selectByVisibleText(month);
    }

    /**
     * Select Year for To dropdown
     * @param year
     */
    public void selectToYear(String year) {
        wait.until(elementToBeClickable(applicationFlowModal.toYearSelectBox));
        Select selectToYear = new Select(driver.findElement(applicationFlowModal.toYearSelectBox));
        selectToYear.selectByValue(year);
    }

    /**
     * Click the Continue button to access the next form with Profile Info: from Experience to either Availability or Skills
     */
    public void clickContinueOnExperienceForm(){
        wait.until(elementToBeClickable(applicationFlowModal.continueExperienceBtn));
        driver.findElement(applicationFlowModal.continueExperienceBtn).click();
    }

    /**
     * Click Full-Time Card button
     */
    public void clickFullTimeCardBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.fullTimeCardBtn));
        driver.findElement(applicationFlowModal.fullTimeCardBtn).click();
    }

    /**
     * Click Mornings Card button
     */
    public void clickMorningsCardBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.morningsCardBtn));
        driver.findElement(applicationFlowModal.morningsCardBtn).click();
    }

    /**
     * Click Afternoons Card button
     */
    public void clickAfternoonsCardBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.afternoonsCardBtn));
        driver.findElement(applicationFlowModal.afternoonsCardBtn).click();
    }

    /**
     * Click Evenings Card button
     */
    public void clickEveningsCardBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.eveningsCardBtn));
        driver.findElement(applicationFlowModal.eveningsCardBtn).click();
    }

    /**
     * Click Nights Card button
     */
    public void clickNightsCardBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.nightsCardBtn));
        driver.findElement(applicationFlowModal.nightsCardBtn).click();
    }

    /**
     * Click Continue button from Availability Form
     */
    public void clickContinuefromAvailabilityFormBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.continueAvailabilityBtn));
        driver.findElement(applicationFlowModal.continueAvailabilityBtn).click();
    }

    /**
     * Click Skill by Index
     */
    public void clickSkillByIndex(String index){
        wait.until(elementToBeClickable(applicationFlowModal.getSkillsbyIndex(index)));
        driver.findElement(applicationFlowModal.getSkillsbyIndex(index)).click();
    }

    /**
     * Click Submit Button from Skills Form
     */
    public void clickSubmitfromSkillsForm(){
        wait.until(elementToBeClickable(applicationFlowModal.skillsSubmitBtn));
        driver.findElement(applicationFlowModal.skillsSubmitBtn).click();
    }

    /**
     * Click Submit Button from Skills Form
     */
    public void clickViewMyProfileBtn(){
        wait.until(elementToBeClickable(applicationFlowModal.successViewProfileBtn));
        driver.findElement(applicationFlowModal.successViewProfileBtn).click();
    }

}
