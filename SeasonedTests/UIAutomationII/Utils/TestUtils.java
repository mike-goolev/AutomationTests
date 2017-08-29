import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.UUID;

public class TestUtils {

    WebDriver driver;

    public TestUtils(WebDriver d) {
        driver = d;
    }

    /**
     * Navigate to the search page with no terms
     */
    public void loadJobSearchPageNoTerms() {
        driver.get(TestConfig.getBaseURL() + TestConfig.getJobSearchRelativeURL());
    }

    /**
     * Navigate to the job search page as a starting point for tests
     * @param searchPosition The search term to enter in the search term field
     * @param searchLocation The search location to enter in the search location field
     */

    public void loadJobSearchPage(String searchLocation, String searchPosition) {
        driver.get(TestConfig.getBaseURL() + TestConfig.getJobSearchRelativeURL() + "/" + searchLocation + "/" + searchPosition);
    }

    /**
     * Switches webdriver focus from current window to a new open window ie Facebook Login
     *
     * @param parentWindow The original window as returned in driver.getWindowHandle()
     */
    public void switchToNewWindow(String parentWindow) {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
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
     */
    public String generateRandomUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0,9);
        return uuid;
    }

    /**
     * Scrolls user to the top of the current page
     */
    public void scrollToTop(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}
