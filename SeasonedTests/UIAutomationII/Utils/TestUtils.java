import org.openqa.selenium.WebDriver;

public class TestUtils {

    WebDriver driver;

    public TestUtils(WebDriver d) {
        driver = d;
    }

    /* Navigate to the content feed as a starting point for tests */
    public void loadContentFeedPage() {
        driver.get("http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/app#/feed");
    }

    /**
     * Navigate to the job search page as a starting point for tests
    *
    * @param searchTerm The search term to enter in the search term field
     * @param searchLocation The search location to enter in the search location field
    */
    public void loadJobSearchPage(String searchTerm, String searchLocation) {
        driver.get("http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/search?term=" + searchTerm + "&location=" + searchLocation + "&start=0&rows=25#/");
    }

    /*
    * Switches webdriver focus from current window to a new open window ie Facebook Login
    * @param parentWindow    The original window as returned in driver.getWindowHandle()
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

    /*
    * Switches webdriver focus from new window to the original window
    * @param parentWindow    The original window as returned in driver.getWindowHandle()
    */
    public void switchToParentWindow(String parentWindow) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().window(parentWindow);
    }
}