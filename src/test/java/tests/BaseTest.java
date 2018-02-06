package tests;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.*;
import pages.NavPage;
import sql.SqlSelects;

public class BaseTest extends TestNG {

    public WebDriver driver;
    public Screenshot screenshot = new Screenshot();
    public NavPage navPage ;
    public TestUtils testUtils ;
    public SqlSelects sqlSelect = new SqlSelects();


    @Parameters({  "browser" , "url", "urlAPI", "dbURL", "hsUrl", "mailinatorUrl"})
    @BeforeMethod
    public void setUpMain(@Optional String browser, @Optional String url, @Optional String urlAPI, @Optional String dbURL, @Optional String hsUrl, @Optional String mailinatorUrl) throws Exception {
        /**
         * Introducing browser, baseURL, APIUrl and dbURL as parameter in TesnNG config file,
         * which will diversify the type of browsers the tests can run
         */
    if(browser== null){
    browser = "firefox";
    }
    if(url == null)
    {
        url = "https://qa-www.seasoned.co/services/webapp/";
    }
        if(urlAPI == null)
        {
            urlAPI = "http://qa-brushfire.seasoned.co/services/services/rest/";
        }
        if(dbURL == null)
        {
            dbURL = "jdbc:postgresql://qa-db.seasoned.co/bf_qa";
        }
        if(hsUrl == null)
        {
            hsUrl = "http://qamaster.eng.hotschedules.com/hs/";
        }
        if(mailinatorUrl == null)
        {
            mailinatorUrl = "http://www.mailinator.com";
        }

        driver = BrowserFactory.getDriver(browser);
        navPage = new NavPage(driver);
        testUtils = new TestUtils(driver);
        TestConfig.setBaseUrl(url);
        TestConfig.setBaseApiUrl(urlAPI);
        TestConfig.setDbUrl(dbURL);
        TestConfig.setHsUrl(hsUrl);
        TestConfig.setMailinatorHomepageUrl(mailinatorUrl);
    }


}
