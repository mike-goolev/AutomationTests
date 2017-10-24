public class TestConfig {

    private static String baseUrl = "https://qa-www.seasoned.co/services/webapp/";
    private static String baseAPIUrl = "http://qa-brushfire.seasoned.co/services/";
    private static String searchRelativeUrl = "jobs";
    private static String networkSuggestedRelativeUrl = "community/suggested";
    private static String beSuccessfulRelativeUrl = "besuccessful";
    private static String firefoxProfile = "/Users/kkotyk/Library/Application\\ Support/Firefox/Profiles/7jzcee9i.web_automation";
    private static String chromedriverBinary = "/usr/local/bin/chromedriver";
    private static String horariosCalientesLoginUrl = "http://216.166.0.49/hs/login.jsp";
    private static String mailinatorHomepageUrl = "http://www.mailinator.com";

    /**
     * Gets path to base URL
     * @return The base URL
     */
    public static String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Gets the path to the base API URL
     * @return The base API URL
     */
    public static String getBaseApiUrl() {
        return baseAPIUrl;
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
     * Gets path to horarios calientes login URL
     * @return The horarios calientes login URL
     */
    public static String getHorariosCalientesLoginUrl() {
        return horariosCalientesLoginUrl;
    }

    /**
     * Gets path to mailinator homepage URL
     * @return The mailinator homepage URL
     */
    public static String getMailinatorHomepageUrl() {
        return mailinatorHomepageUrl;
    }
}