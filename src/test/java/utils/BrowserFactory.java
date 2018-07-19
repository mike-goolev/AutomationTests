package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.commons.lang3.SystemUtils.*;

public class BrowserFactory {

    public static WebDriver getDriver(String browser, boolean headless){
        WebDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile ffProfile = new FirefoxProfile();

            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    if (headless) {
                        firefoxOptions
                                .setPageLoadStrategy(PageLoadStrategy.NORMAL)
                                .setHeadless(true)
                                .setBinary(getFirefoxPath());
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    }
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefoxProfile":
                    WebDriverManager.firefoxdriver().setup();
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
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "safari":
                    //WebDriverManager doesn't support auto downloading safari driver
                    driver = new SafariDriver();
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments("--disable-gpu");
                    if (headless) {
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--disable-extensions");
                        chromeOptions.addArguments("--disable-translate");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        chromeOptions.setBinary(getChromePath());
                        chromeOptions.setExperimentalOption("useAutomationExtension", false);
                        chromeOptions.addArguments("--proxy-server='direct://'");
                        chromeOptions.addArguments("--proxy-bypass-list=*");
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--headless");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    }
                    chromeOptions.addArguments("--start-fullscreen");
                    chromeOptions.addArguments("--disable-gpu");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
            }
            return driver;
        }

    private static String getChromePath() {
        if (IS_OS_LINUX && Files.exists(Paths.get("/usr/bin/google-chrome"))) {
            return "/usr/bin/google-chrome";
        }
        if (IS_OS_MAC && Files.exists(Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"))) {
            return "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        }
        if (IS_OS_WINDOWS_10 && Files.exists(Paths.get("/Program Files (x86)/Google/Chrome/Application/chrome.exe"))) {
            return "/Program Files (x86)/Google/Chrome/Application/chrome.exe";
        }
        throw new RuntimeException("OS is not recognizable or couldn't locate binary for Google Chrome");
    }

    private static String getFirefoxPath() {
        if (IS_OS_LINUX && Files.exists(Paths.get("/usr/bin/firefox"))) {
            return "/usr/bin/firefox";
        }
        if (IS_OS_MAC && Files.exists(Paths.get("/Applications/Firefox.app/Contents/MacOS/firefox-bin"))) {
            return "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
        }
        if (IS_OS_WINDOWS_10 && Files.exists(Paths.get("/Program Files/Mozilla Firefox/firefox.exe"))) {
            return "/Program Files/Mozilla Firefox/firefox.exe";
        }
        throw new RuntimeException("OS is not recognizable or couldn't locate binary for Firefox");
    }
}
