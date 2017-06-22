public class TestConfig {
    String baseURL = "http://hsp-load-balancer-851875221.us-west-2.elb.amazonaws.com/services/";
    String searchRelativeURL = "search";
    String contentRelativeURL = "app#feed";

    /**
     * Gets path to base URL
     * @return The base URL
     */
    public String getBaseURL() { return baseURL;}

    /**
     * Gets path to job search page URL
     * @return The job search page URL
     */
    public String getJobSearchRelativeURL() { return searchRelativeURL;}

    /**
     * Gets path to content page URL
     * @return The content page URL
     */
    public String getContentRelativeURL() {return contentRelativeURL;}
}