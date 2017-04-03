import org.openqa.selenium.WebDriver;

/**
 * Created by alex.esparza on 2/17/17.
 */
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
