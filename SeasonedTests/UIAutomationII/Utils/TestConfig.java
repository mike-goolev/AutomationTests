public class TestConfig {

    private static String baseURL = "https://qa-www.seasoned.co/services/webapp/";
    private static String baseAPIUrl = "http://qa-brushfire.seasoned.co/services/";
    private static String searchRelativeUrl = "jobs";
    private static String networkSuggestedRelativeUrl = "community/suggested";
    private static String beSuccessfulRelativeUrl = "besuccessful";
    private static String firefoxProfile = "/Users/kkotyk/Library/Application\\ Support/Firefox/Profiles/7jzcee9i.web_automation";
    private static String chromedriverBinary = "/usr/local/bin/chromedriver";

    /**
     * Gets path to base URL
     * @return The base URL
     */
    public static String getBaseURL() {
        return baseURL;
    }

    /**
     * Gets the path to the base API URL
     * @return The base API URL
     */
    public static String getBaseAPIURL() {
        return baseAPIUrl;
    }

    /**
     * Gets path to job search page URL
     * @return The job search page URL
     */
    public static String getJobSearchRelativeURL() {
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
}