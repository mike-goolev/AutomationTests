import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SignupPage extends BasePage {

    Locators.SignUpPageLocators signUpPageLocators;
    TestUtils testUtils;

    public SignupPage(WebDriver driver) {
        super(driver);
        signUpPageLocators = new Locators.SignUpPageLocators();
        testUtils = new TestUtils(driver);
    }

     /*---------- Onboarding - Shared elements -----------*/

     /**
     * Selects the 'X' button to exit signup flow and return to previous page
     */
     public void dismissSignup(){
         wait.until(elementToBeClickable(signUpPageLocators.dismissBtn));
         driver.findElement(signUpPageLocators.dismissBtn).click();
     }

    /*---------- Onboarding - Custom Experience -----------*/

    /**
     * Selects the jobs flow
     */
    public void clickJobsExperience(){
        wait.until(elementToBeClickable(signUpPageLocators.jobsBtn));
        driver.findElement(signUpPageLocators.jobsBtn).click();
    }

    /**
     * Selects the grow career flow
     */
    public void clickCareerExperience(){
        wait.until(elementToBeClickable(signUpPageLocators.careerBtn));
        driver.findElement(signUpPageLocators.careerBtn).click();
    }

    /**
     * Selects the network flow
     */
    public void clickNetworkExperience(){
        wait.until(elementToBeClickable(signUpPageLocators.networkBtn));
        driver.findElement(signUpPageLocators.networkBtn).click();
    }

    /**
     * Selects the manager flow
     */
    public void clickHireExperience(){
        wait.until(elementToBeClickable(signUpPageLocators.managerBtn));
        driver.findElement(signUpPageLocators.managerBtn).click();
    }

     /*---------- Onboarding - Location -----------*/

    /**
     * Waits for the user's location to be pulled from IP and populated in location field
     */
    public void waitForLocation() {
        for (int i = 0; i < (driver.findElement(signUpPageLocators.locationField)).getAttribute("value").length(); i++) {
        }
    }

     /**
     * Sets user's location

     * @param location User's location
     */
    public void setUserLocation(String location) {
        wait.until(elementToBeClickable(signUpPageLocators.locationField));
        driver.findElement(signUpPageLocators.locationField).click();
        driver.findElement(signUpPageLocators.locationField).clear();
        driver.findElement(signUpPageLocators.locationField).sendKeys(location);
    }

    /**
     * Get location title text
     * @return The location page's title text
     */
    public String getLocationTitleTxt(){
        return driver.findElement(signUpPageLocators.locationField).getText();
    }

    /**
     * Get suggested location text
     * @return The suggested location
     */
    public String getLocationTxt(){
        return driver.findElement(signUpPageLocators.locationField).getAttribute("value");
    }

    /**
     * Selects a location suggestion by index
     * @param index The index (Starting at 0) of the location suggestion you wish to locate
     */
    public void selectLocationFromList(String index){
        wait.until(elementToBeClickable(signUpPageLocators.locationSuggestionBtn(index)));
    }

    /**
     * Selects the back button on the location screen
     */
    public void clickLocationBackButton(){
        wait.until(elementToBeClickable(signUpPageLocators.locationBackBtn));
        driver.findElement(signUpPageLocators.locationBackBtn).click();
    }

    /**
     * Selects the next button on the location screen
     */
    public void clickLocationNextBtn(){
        wait.until(elementToBeClickable(signUpPageLocators.locationNextBtn));
        driver.findElement(signUpPageLocators.locationNextBtn).click();
    }

    /*---------- Onboarding - Jobs -----------*/

    /**
     * Enter a job type
     * @param job User's job type selection
     */
    public void enterJob(String job) {
        wait.until(elementToBeClickable(signUpPageLocators.jobsField));
        driver.findElement(signUpPageLocators.jobsField).click();
        driver.findElement(signUpPageLocators.jobsField).sendKeys(job);
    }

    /**
     * Selects all jobs
     */
    public void selectAllJobs(){
        wait.until(elementToBeClickable(signUpPageLocators.allJobsBtn));
        driver.findElement(signUpPageLocators.allJobsBtn).click();
    }

    /**
     * Selects popular jobs
     */
    public void selectPopularJobs(){
        wait.until(elementToBeClickable(signUpPageLocators.popularJobsBtn));
        driver.findElement(signUpPageLocators.popularJobsBtn).click();
    }

    /**
     * Select specific jobs from a list
     */
    public void selectJobsFromList() {
        wait.until(elementToBeClickable(signUpPageLocators.selectedJobsBtn));
        driver.findElement(signUpPageLocators.selectedJobsBtn).click();
    }

    /**
     * Selects specific jobs
     * @param index The index (Starting at 0) of the job type you wish to locate
     */
    public void selectSpecificJobsByIndex(String index) {
        wait.until(elementToBeClickable(signUpPageLocators.jobsPositionCheckbox(index)));
        driver.findElement(signUpPageLocators.jobsPositionCheckbox(index)).click();
    }

    /**
     * Selects the back button on the jobs screen
     */
    public void clickJobsBackButton(){
        wait.until(elementToBeClickable(signUpPageLocators.jobsBackBtn));
        driver.findElement(signUpPageLocators.jobsBackBtn).click();
    }

    /**
     * Selects the next button on the jobs screen
     */
    public void clickJobsNextBtn() {
        wait.until(elementToBeClickable(signUpPageLocators.jobsNextBtn));
        driver.findElement(signUpPageLocators.jobsNextBtn).click();
    }

    /*---------- Onboarding - Topics -----------*/

    /**
     * Selects specific topics
     * @param index The index (Starting at 0) of the topic you wish to locate
     */
    public void selectTopicsByIndex(String index){
        wait.until(elementToBeClickable(signUpPageLocators.topicsCheckbox(index)));
        driver.findElement(signUpPageLocators.topicsCheckbox(index)).click();
    }

    /**
     * Selects the back button on the topics screen
     */
    public void clickTopicsBackButton(){
        wait.until(elementToBeClickable(signUpPageLocators.topicsBackBtn));
        driver.findElement(signUpPageLocators.topicsBackBtn).click();
    }

    /**
     * Selects the next button on the topics screen
     */
    public void clickTopicsNextBtn() {
        wait.until(elementToBeClickable(signUpPageLocators.topicsNextBtn));
        driver.findElement(signUpPageLocators.topicsNextBtn).click();
    }

    /*---------- Onboarding - Signup -----------*/

    /**
     * Selects email signup
     */
    public void signupEmail(){
        wait.until(elementToBeClickable(signUpPageLocators.emailSignUpBtn));
        driver.findElement(signUpPageLocators.emailSignUpBtn).click();
    }

    /**
     * Selects Facebook signup
     */
    public void signupFacebook(){
        wait.until(elementToBeClickable(signUpPageLocators.facebookSignUpBtn));
        driver.findElement(signUpPageLocators.facebookSignUpBtn).click();
    }

    /**
     * Register user with an email and password
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email    User's email
     * @param password User's password
     */
    public void registerEmail(String firstName, String lastName, String email, String password) {
        wait.until(elementToBeClickable(signUpPageLocators.firstNameField));
        driver.findElement(signUpPageLocators.firstNameField).click();
        driver.findElement(signUpPageLocators.firstNameField).sendKeys(firstName);
        driver.findElement(signUpPageLocators.lastNameField).sendKeys(lastName);
        driver.findElement(signUpPageLocators.emailField).sendKeys(email);
        driver.findElement(signUpPageLocators.passwordField).sendKeys(password);
        driver.findElement(signUpPageLocators.emailSignupNextBtn).click();
        wait.until(invisibilityOfElementLocated(signUpPageLocators.emailSignUpNextLoadingBtn));
    }

    /**
     * Register user with Facebook credentials

     * @param email    User's Facebook email
     * @param password User's Facebook password
     */
    public void registerFacebook(String email, String password) {
        String parentWindow = driver.getWindowHandle();
        wait.until(elementToBeClickable(signUpPageLocators.facebookSignUpBtn));
        driver.findElement(signUpPageLocators.facebookSignUpBtn).click();
        testUtils.switchToNewWindow(parentWindow);
        wait.until(elementToBeClickable(signUpPageLocators.faceBookEmailField));
        driver.findElement(signUpPageLocators.faceBookEmailField).sendKeys(email);
        driver.findElement(signUpPageLocators.faceBookPasswordField).sendKeys(password);
        driver.findElement(signUpPageLocators.facebookLoginBtn).click();
        testUtils.switchToParentWindow(parentWindow);
    }
}
