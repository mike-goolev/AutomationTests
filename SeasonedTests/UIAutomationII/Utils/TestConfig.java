public class TestConfig {

    private static String baseURL = "http://qa-www.seasoned.co/services/webapp/";
    private static String searchRelativeURL = "search";
    private static String contentRelativeURL = "app#/feed/";

    /**
     * Gets path to base URL
     * @return The base URL
     */
    public static String getBaseURL() { return baseURL;}

    /**
     * Gets path to job search page URL
     * @return The job search page URL
     */
    public static String getJobSearchPageURL() { return searchRelativeURL;}

    /**
     * Gets path to content page URL
     * @return The content page URL
     */
    public static String getContentRelativeURL() {return contentRelativeURL;}
}