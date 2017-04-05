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
}
