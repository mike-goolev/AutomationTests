
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Calendar;
import org.openqa.selenium.JavascriptExecutor;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TestUtils {

    protected WebDriver driver;
    NavPage navPage;
    Locators.MailinatorLocators mailinatorLocators;
    Actions actions;


    private String parentWindow;

    public TestUtils(WebDriver d) {
        driver = d;
        navPage = new NavPage(driver);
        mailinatorLocators = new Locators.MailinatorLocators();
        actions = new Actions(driver);
    }

    /**
     * Navigate to the search page with no terms
     */
    public void loadJobSearchPageNoTerms() {
        driver.get(TestConfig.getBaseUrl() + TestConfig.getJobSearchRelativeUrl());
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the job search page as a starting point for tests
     *
     * @param searchPosition The search term to enter in the search term field
     * @param searchLocation The search location to enter in the search location field
     */
    public void loadJobSearchPage(String searchLocation, String searchPosition) {
        driver.get(TestConfig.getBaseUrl() + TestConfig.getJobSearchRelativeUrl() + "/" + searchLocation + "/" + searchPosition);
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the network page
     */
    public void loadConnectionsPage() {
        driver.get(TestConfig.getBaseUrl() + TestConfig.getNetworkRelativeUrl());
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the be successful page
     */
    public void loadBeSuccessfulPage() {
        driver.get(TestConfig.getBaseUrl() + TestConfig.getSuccessRelativeUrl());
        navPage.dismissRebrandingModal();
    }

    /**
     * Switches webdriver focus from current window to a new open window ie Facebook Login
     *
     * @param parentWindow The original window as returned in driver.getWindowHandle()
     */
    public void switchToNewWindow(String parentWindow) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }

    /**
     * Switches webdriver focus from new window to the original window
     *
     * @param parentWindow The original window as returned in driver.getWindowHandle()
     */
    public void switchToParentWindow(String parentWindow) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().window(parentWindow);
    }

    /**
     * Returns a randomly generated UUID of 9 alphanumeric characters
     * @return A randomly generated UUID
     */
    public String generateRandomUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9);
        return uuid;
    }

    /**
     * Returns a date object in format MMM yyyy
     *
     * @param yearsAgo The number of years ago the date object returns
     * @return The date in the requested format
     */
    public String getFormattedMonthYear(int yearsAgo) {
        // Create a date formatter using your format string
        SimpleDateFormat format = new SimpleDateFormat("MMM yyyy");

        // Use the Calendar class to subtract @param years from current day
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, yearsAgo);
        String shortDate = format.format(now.getTime());

        return shortDate;
    }

    /**
     * Navigate to the horarios calientes login page
     */
    public void loadHorariosCalientesLogin() {
        driver.get(TestConfig.getHsLoginUrl());
    }

    /**
     * Navigate to the mailinator homepage
     */
    public void loadMailinatorHomePage() {
        driver.get(TestConfig.getMailinatorHomepageUrl());
    }

    /**
     * Navigate to the horarios calientes login page
     * @param email The user's email
     */
    public void openHSAutoProvisionRegisterAction(String email) throws Exception {
        loadMailinatorHomePage();
        driver.findElement(mailinatorLocators.inboxField).sendKeys(email);
        driver.findElement(mailinatorLocators.checkEmailBtn).click();
        driver.findElement(mailinatorLocators.emailSubjectLink).click();
        Thread.sleep(2000);
        parentWindow = driver.getWindowHandle();
        WebElement iframe = driver.findElement(mailinatorLocators.iFrame);
        driver.switchTo().frame(iframe);
        driver.findElement(mailinatorLocators.activationActionLink).click();
        driver.switchTo().defaultContent();
        switchToNewWindow(parentWindow);
    }

    /**
     * Executes a js statement for given web element
     * @param script The javascript to execute
     * @param element The web element where the javascript will be executed against
     */
    public void jsExecutorElement (String script, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    /**
     * Convert a JSON string to pretty print version
     * @param jsonString
     * @return
     */
    public static String toPrettyFormat(String jsonString){
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    /**
     * Executes a js statement for given web element
     * @param element The webelement to drag and drop
     * @param xOffset The # of pixels to move horizontally
     * @param yOffset The # of pixels to move vertically
     */
    public void dragAndDropElement (WebElement element, int xOffset, int yOffset){
        actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
    }
}
