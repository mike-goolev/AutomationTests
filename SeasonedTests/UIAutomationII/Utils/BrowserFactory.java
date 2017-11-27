import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    public static WebDriver getDriver(String browser){
        WebDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile ffProfile = new FirefoxProfile();

            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefoxProfile":
                    /* Setup Firefox profile */
                    ffProfile.setPreference("webdriver_accept_untrusted_certs", true);
                    ffProfile.setPreference("webdriver_assume_untrusted_issuer", true);
                    ffProfile.setPreference("webdriver.log.driver", "ERROR");
                    firefoxOptions.setProfile(ffProfile);

                    /* Setup Firefox options */
                    firefoxOptions
                            .setLogLevel(FirefoxDriverLogLevel.ERROR)
                            .setPageLoadStrategy(PageLoadStrategy.NORMAL);

                    /* Create firefox driver instance */
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "chrome":
                    chromeOptions.addArguments("--start-fullscreen");
                    chromeOptions.addArguments("--disable-gpu");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "chromeHeadless":
                    System.setProperty("webdriver.chrome.driver", TestConfig.getChromedriverPath());
                    chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    driver = new FirefoxDriver();
            }
            return driver;
        }
    }
