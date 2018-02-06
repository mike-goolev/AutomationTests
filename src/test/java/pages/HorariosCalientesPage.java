package pages;

import org.openqa.selenium.WebDriver;
import utils.Locators;
import utils.TestUtils;
import sql.SqlSelects;

import java.sql.SQLException;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HorariosCalientesPage extends BasePage {
    Locators.HorariosCalientesLocators horariosCalientesLocators;
    NavPage navPage;
    TestUtils testUtils;
    SqlSelects postreSQLSelects;


    public HorariosCalientesPage(WebDriver driver) {
        super(driver);
        horariosCalientesLocators = new Locators.HorariosCalientesLocators();
        navPage = new NavPage(driver);
        testUtils = new TestUtils(driver);
        postreSQLSelects = new SqlSelects();
    }

    /**
     * Logs the user in with the standard username/password format
     *
     * @param username User's email their account is associated with
     * @param password User's password for their account
     */
    public void loginWithUsername(String username, String password) {
        wait.until(elementToBeClickable(horariosCalientesLocators.loginUsernameField));
        driver.findElement(horariosCalientesLocators.loginUsernameField).sendKeys(username);
        wait.until(elementToBeClickable(horariosCalientesLocators.loginPasswordField));
        driver.findElement(horariosCalientesLocators.loginPasswordField).sendKeys(password);
        driver.findElement(horariosCalientesLocators.loginBtn).click();
        waitForLoadingSpinnerIndicator();
    }

    /**
     * Clicks the pending tasks cancel button
     */
    public void clickPendingTasksCancelBtn() {
        if (elementExists(horariosCalientesLocators.pendingTasksCancelBtn)) {
            wait.until(elementToBeClickable(horariosCalientesLocators.pendingTasksCancelBtn));
            driver.findElement(horariosCalientesLocators.pendingTasksCancelBtn).click();
        }
    }

    /**
     * Clicks the SSO dropdown
     */
    public void clickSsoDropdown() {
        wait.until(elementToBeClickable(horariosCalientesLocators.appDropdownBtn));
        driver.findElement(horariosCalientesLocators.appDropdownBtn).click();
    }

    /**
     * Clicks the BF SSO link
     */
    public void clickBfSsoBtn() {
        wait.until(elementToBeClickable(horariosCalientesLocators.bfSsoBtn));
        driver.findElement(horariosCalientesLocators.bfSsoBtn).click();
    }

    /**
     * Select BF SSO
     */
    public void selectBfSso() {
        clickSsoDropdown();
        clickBfSsoBtn();
    }

    /**
     * Clicks the staff tab
     */
    public void clickStaffTab() {
        wait.until(elementToBeClickable(horariosCalientesLocators.staffTabBtn));
        driver.findElement(horariosCalientesLocators.staffTabBtn).click();
        waitForLoadingSpinnerIndicator();
    }

    /**
     * Clicks the add new employee tab
     */
    public void clickAddEmployee() {
        wait.until(elementToBeClickable(horariosCalientesLocators.staffTabAddEmployeeBtn));
        driver.findElement(horariosCalientesLocators.staffTabAddEmployeeBtn).click();
        wait.until(elementToBeClickable(horariosCalientesLocators.addEmployeeFirstNameField));
    }

    /**
     * Enter text into the first name text field
     *
     * @param firstName The first and last name of the user
     */
    public void enterUserFirstName(String firstName) {
        driver.findElement(horariosCalientesLocators.addEmployeeFirstNameField).sendKeys(firstName);
    }

    /**
     * Enter text into the last name text field
     *
     * @param lastName The first and last name of the user
     */
    public void enterUserLastName(String lastName) {
        driver.findElement(horariosCalientesLocators.addEmployeeLastNameField).sendKeys(lastName);
    }

    /**
     * Enter text into the email text field
     *
     * @param email The first and last name of the user
     */
    public void enterUserEmail(String email) {
        driver.findElement(horariosCalientesLocators.addEmployeeEmailField).sendKeys(email);
    }

    /**
     * Clicks the add new employee save button
     */
    public void clickAddEmployeeSaveBtn() {
        wait.until(elementToBeClickable(horariosCalientesLocators.addEmployeeSaveBtn));
        driver.findElement(horariosCalientesLocators.addEmployeeSaveBtn).click();
        waitForProcessingBarIndicator();
    }

    /**
     * Gets the user's employeeId
     *
     * @param supportUsername The support user's username
     * @param supportPassword The support user's password
     * @param employer        The HS employer name
     * @param username        The HD user's username
     * @return The user's employeeId
     */
    public String getEmployeeId(String supportUsername, String supportPassword, String employer, String username) throws Exception {
        testUtils.loadHorariosCalientesLogin();
        loginWithUsername(supportUsername, supportPassword);
        waitForLoadingSpinnerIndicator();
        driver.findElement(horariosCalientesLocators.supportInfoSearchBtn).click();
        driver.findElement(horariosCalientesLocators.supportSearchField).click();
        driver.findElement(horariosCalientesLocators.supportSearchField).sendKeys(employer);
        Thread.sleep(2000);
        driver.findElement(horariosCalientesLocators.supportEmployerResultBtn).click();
        waitForProcessingBarIndicator();
        driver.findElement(horariosCalientesLocators.supportUsernameFilterField).sendKeys(username);
        driver.findElement(horariosCalientesLocators.supportApplyFilterBtn).click();
        waitForProcessingBarIndicator();
        return driver.findElement(horariosCalientesLocators.employeeIdTxt).getText();
    }

    /**
     * Gets the user's username
     *
     * @return The user's username
     */
    public String getUsername() {
        return driver.findElement(horariosCalientesLocators.addEmployeeUsernameField).getAttribute("value");
    }

    /**
     * Gets the user's password
     *
     * @return The user's password
     */
    public String getPassword() {
        return driver.findElement(horariosCalientesLocators.addEmployeePasswordField).getAttribute("value");
    }

    public boolean isHsUserInSqsQueue() throws SQLException, InterruptedException, NullPointerException {
        do {
            System.out.println("Waiting for HS user to be added to the deferred sqs queue. Retrying in 30 seconds...");
            Thread.sleep(30000);
        } while
                (postreSQLSelects.getDeferredUser().isEmpty());
        return true;
    }

    public boolean hasHsUserBeenProcessed(String email) throws SQLException, InterruptedException, NullPointerException {
        do {
            System.out.println("Waiting for HS user to be created. Retrying in 30 seconds...");
            Thread.sleep(30000);
        } while
                (postreSQLSelects.getUserByEmail(email).isEmpty());
        return true;
    }

    /**
     * Waits for loading indicator
     */
    public void waitForLoadingSpinnerIndicator() {
        if (elementExists(horariosCalientesLocators.loadingSpinnerIndicator)) {
            wait.until(invisibilityOfElementLocated(horariosCalientesLocators.loadingSpinnerIndicator));
        }
    }

    /**
     * Waits for add employee loading indicator
     */
    public void waitForProcessingBarIndicator() {
        if (elementExists(horariosCalientesLocators.loadingBarIndicator)) {
            wait.until(invisibilityOfElementLocated(horariosCalientesLocators.loadingBarIndicator));
        }
    }
}
