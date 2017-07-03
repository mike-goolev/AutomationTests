public class TestConfig {

    private static String baseURL = "http://qa-www.seasoned.co/services/webapp/";
    private static String baseAPIUrl = "http://qa-brushfire.seasoned.co/services/";
    private static String searchRelativeURL = "search";
    private static String contentRelativeURL = "app#/feed/";

    /**
     * Gets path to base URL
     *
     * @return The base URL
     */
    public static String getBaseURL() { return baseURL;}

    /**
     * Gets the path to the base API URL
     *
     * @return The base API URL
     */
    public static String getBaseAPIURL() {
        return baseAPIUrl;
    }

    /**
     * Gets path to job search page URL
     *
     * @return The job search page URL
     */
    public static String getJobSearchRelativeURL() { return searchRelativeURL;}

    /**
     * Gets path to content page URL
     *
     * @return The content page URL
     */
    public static String getContentRelativeURL() {return contentRelativeURL;}
}