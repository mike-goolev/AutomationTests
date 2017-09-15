import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        FirefoxProfile ffProfile = new FirefoxProfile();

            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefoxProfile":
                    ffProfile.setAcceptUntrustedCertificates(true);
                    ffProfile.setAssumeUntrustedCertificateIssuer(true);
                    caps = new FirefoxOptions().setProfile(ffProfile).addTo(caps);
                    caps.setCapability(FirefoxDriver.PROFILE, TestConfig.getFirefoxProfile());
                    driver = new FirefoxDriver(caps);
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", TestConfig.getChromedriverPath());
                    chromeOptions.addArguments("--start-fullscreen");
                    chromeOptions.addArguments("--disable-gpu");
                    caps.setJavascriptEnabled(true);
                    caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    driver = new ChromeDriver(caps);
                    break;
                case "chromeHeadless":
                    System.setProperty("webdriver.chrome.driver", TestConfig.getChromedriverPath());
                    chromeOptions.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
                    chromeOptions.addArguments("--headless");
                    caps.setJavascriptEnabled(true);
                    caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    driver = new ChromeDriver(caps);
                    break;
                default:
                    driver = new FirefoxDriver();
            }
            return driver;
        }
    }
