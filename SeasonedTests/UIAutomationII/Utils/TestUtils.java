import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Calendar;

public class TestUtils {

    WebDriver driver;
    NavPage navPage;

    public TestUtils(WebDriver d) {
        driver = d;
        navPage = new NavPage(driver);
    }

    /**
     * Navigate to the search page with no terms
     */
    public void loadJobSearchPageNoTerms() {
        driver.get(TestConfig.getBaseURL() + TestConfig.getJobSearchRelativeURL());
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the job search page as a starting point for tests
     *
     * @param searchPosition The search term to enter in the search term field
     * @param searchLocation The search location to enter in the search location field
     */
    public void loadJobSearchPage(String searchLocation, String searchPosition) {
        driver.get(TestConfig.getBaseURL() + TestConfig.getJobSearchRelativeURL() + "/" + searchLocation + "/" + searchPosition);
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the network page
     */
    public void loadConnectionsPage() {
        driver.get(TestConfig.getBaseURL() + TestConfig.getNetworkRelativeUrl());
        navPage.dismissRebrandingModal();
    }

    /**
     * Navigate to the be successful page
     */
    public void loadBeSuccessfulPage() {
        driver.get(TestConfig.getBaseURL() + TestConfig.getSuccessRelativeUrl());
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
}
