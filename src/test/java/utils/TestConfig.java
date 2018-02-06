package utils;

import pages.HorariosCalientesPage;

public class TestConfig {

    private static String workingDir = System.getProperty("user.dir");
   // private static String baseUrl = "https://qa-www.seasoned.co/services/webapp/";
   private static String baseUrl;
    //private static String baseAPIUrl = "http://qa-brushfire.seasoned.co/services/";
    private static String baseAPIUrl;
    private static String searchRelativeUrl = "jobs";
    private static String networkSuggestedRelativeUrl = "community/suggested";
    private static String beSuccessfulRelativeUrl = "besuccessful";
    private static String firefoxProfile = getWorkingDir() + "/Library/Application\\ Support/Firefox/Profiles/7jzcee9i.web_automation";
    private static String chromedriverBinary = "/usr/local/bin/chromedriver";
    private static String horariosCalientesUrl;
    private static String mailinatorHomepageUrl;
    //private static String qaDatabaseUrl = "jdbc:postgresql://qa-db.seasoned.co/bf_qa";
    private static String qaDatabaseUrl;
    private static String qaDatabaseUser = "brushfire";
    private static String qaDatabasePassword = "brushfire";


    /**
     * Gets path to app working dir
     * @return The working dir
     */
    public static String getWorkingDir() {
        return workingDir;
    }

    /**
     * Gets path to base URL
     * @return The base URL
     */

    public static String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets main url string
     */
    public static void setBaseUrl(String baseURL) {

        baseUrl = baseURL;
    }

    /**
     * Gets the path to the base API URL
     * @return The base API URL
     */
    public static String getBaseApiUrl() {
        return baseAPIUrl;
    }

    /**
     * Sets API url string
     */
    public static void setBaseApiUrl(String baseAPIURL) {

        baseAPIUrl = baseAPIURL;
    }

    /**
     * Gets url for qa-db
     * @return The qa-db url
     */
    public static String getQaDatabaseUrl() {
        return qaDatabaseUrl;
    }

    /**
     * Sets DB connection string
     */
    public static void setDbUrl(String dbURL) {

        qaDatabaseUrl = dbURL;
    }

    /**
     * Gets username for qa-db connection
     * @return The username for qa-db connection
     */
    public static String getQaDatabaseUsername() {
        return qaDatabaseUser;
    }

    /**
     * Gets password for qa-db connection
     * @return The password for qa-db connection
     */
    public static String getQaDatabasePassword() {
        return qaDatabasePassword;
    }

    /**
     * Gets path to job search page URL
     * @return The job search page URL
     */
    public static String getJobSearchRelativeUrl() {
        return searchRelativeUrl;
    }

    /**
     * Gets path to network suggested connections page URL
     * @return The network suggested connections page URL
     */
    public static String getNetworkRelativeUrl() {
        return networkSuggestedRelativeUrl;
    }

    /**
     * Gets path to success page URL
     * @return The success page URL
     */
    public static String getSuccessRelativeUrl() {
        return beSuccessfulRelativeUrl;
    }

    /**
     * Gets path to firefox profile
     * @return The success page URL
     */
    public static String getFirefoxProfile() {
        return firefoxProfile;
    }

    /**
     * Gets path to success page URL
     * @return The success page URL
     */
    public static String getChromedriverPath() {
        return chromedriverBinary;
    }

    /**
     * Gets path to horarios calientes URL
     * @return The horarios calientes URL
     */
    public static String getHsUrl() {
        return horariosCalientesUrl;
    }

    /**
     * Gets path to horarios calientes URL
     */
    public static void setHsUrl(String hsUrl) {
        horariosCalientesUrl = hsUrl;
    }

    /**
     * Gets path to horarios calientes login URL
     * @return The horarios calientes login URL
     */
    public static String getHsLoginUrl() {
                return horariosCalientesUrl + "login.jsp";
    }

    /**
     * Gets path to mailinator homepage URL
     * @return The mailinator homepage URL
     */
    public static String getMailinatorHomepageUrl() {
        return mailinatorHomepageUrl;
    }

    /**
     * Sets path to mailinator homepage URL
     */
    public static void setMailinatorHomepageUrl(String mailinatorUrl) {
        mailinatorHomepageUrl = mailinatorUrl;
    }

}