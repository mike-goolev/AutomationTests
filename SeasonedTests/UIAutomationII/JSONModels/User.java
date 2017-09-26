import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("dobMillis")
    @Expose
    private Object dob;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("acceptedTerms")
    @Expose
    private Boolean acceptedTerms;
    @SerializedName("termsAcceptedVersion")
    @Expose
    private Integer termsAcceptedVersion;
    @SerializedName("termsCurrentVersion")
    @Expose
    private Integer termsCurrentVersion;
    @SerializedName("termsUrl")
    @Expose
    private String termsUrl;
    @SerializedName("termsAppleUrl")
    @Expose
    private String termsAppleUrl;
    @SerializedName("followedEmployerIds")
    @Expose
    private List<Object> followedEmployerIds = null;
    @SerializedName("endorsedEmployerIds")
    @Expose
    private List<Object> endorsedEmployerIds = null;
    @SerializedName("interestedInEmployerIds")
    @Expose
    private List<Object> interestedInEmployerIds = null;
    @SerializedName("emails")
    @Expose
    private List<Email> emails = null;
    @SerializedName("placesWorkedCount")
    @Expose
    private String placesWorkedCount;
    @SerializedName("yearsOfExperienceCount")
    @Expose
    private Integer yearsOfExperienceCount;
    @SerializedName("returning")
    @Expose
    private Boolean returning;
    @SerializedName("employerIds")
    @Expose
    private Object employerIds;
    @SerializedName("adminEmployers")
    @Expose
    private List<Object> adminEmployers = null;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("primaryWorkHistory")
    @Expose
    private PrimaryWorkHistory primaryWorkHistory;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = null;
    @SerializedName("location")
    @Expose
    private Location_ location;
    @SerializedName("accountState")
    @Expose
    private String accountState;
    @SerializedName("sharedNetworkConnectionCount")
    @Expose
    private Integer sharedNetworkConnectionCount;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    @SerializedName("certifications")
    @Expose
    private List<Certification> certifications = null;
    @SerializedName("preferredLocale")
    @Expose
    private String preferredLocale;
    @SerializedName("connectedToCurrentUser")
    @Expose
    private Boolean connectedToCurrentUser;
    @SerializedName("connectionStatusWithCurrentUser")
    @Expose
    private Integer connectionStatusWithCurrentUser;
    @SerializedName("eligibility")
    @Expose
    private List<Eligibility> eligibility = null;
    @SerializedName("referralsForCurrentEmployerCount")
    @Expose
    private Integer referralsForCurrentEmployerCount;
    @SerializedName("availability")
    @Expose
    private Availability availability;
    @SerializedName("preferences")
    @Expose
    private List<Preference> preferences = null;
    @SerializedName("jobPreferences")
    @Expose
    private Object jobPreferences;
    @SerializedName("firstJobSearch")
    @Expose
    private Boolean firstJobSearch;
    @SerializedName("fetchMask")
    @Expose
    private Integer fetchMask;
    @SerializedName("passwordSetByUser")
    @Expose
    private Boolean passwordSetByUser;
    @SerializedName("registrationMethod")
    @Expose
    private String registrationMethod;
    @SerializedName("hsUser")
    @Expose
    private Boolean hsUser;
    @SerializedName("endorsementCount")
    @Expose
    private Integer endorsementCount;
    @SerializedName("chatWithNewMessagesCount")
    @Expose
    private Integer chatWithNewMessagesCount;
    @SerializedName("hsVerifiedCount")
    @Expose
    private Integer hsVerifiedCount;
    @SerializedName("referralsGivenConfirmedCount")
    @Expose
    private Integer referralsGivenConfirmedCount;
    @SerializedName("networkCount")
    @Expose
    private Integer networkCount;
    @Expose
    private String employmentInterestStatus;
    @Expose
    private String employmentInterestType;
    @Expose
    private String gigInterestStatus;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills;


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(Boolean acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }

    public Integer getTermsAcceptedVersion() {
        return termsAcceptedVersion;
    }

    public void setTermsAcceptedVersion(Integer termsAcceptedVersion) {
        this.termsAcceptedVersion = termsAcceptedVersion;
    }

    public Integer getTermsCurrentVersion() {
        return termsCurrentVersion;
    }

    public void setTermsCurrentVersion(Integer termsCurrentVersion) {
        this.termsCurrentVersion = termsCurrentVersion;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public String getTermsAppleUrl() {
        return termsAppleUrl;
    }

    public void setTermsAppleUrl(String termsAppleUrl) {
        this.termsAppleUrl = termsAppleUrl;
    }

    public List<Object> getFollowedEmployerIds() {
        return followedEmployerIds;
    }

    public void setFollowedEmployerIds(List<Object> followedEmployerIds) {
        this.followedEmployerIds = followedEmployerIds;
    }

    public List<Object> getEndorsedEmployerIds() {
        return endorsedEmployerIds;
    }

    public void setEndorsedEmployerIds(List<Object> endorsedEmployerIds) {
        this.endorsedEmployerIds = endorsedEmployerIds;
    }

    public List<Object> getInterestedInEmployerIds() {
        return interestedInEmployerIds;
    }

    public void setInterestedInEmployerIds(List<Object> interestedInEmployerIds) {
        this.interestedInEmployerIds = interestedInEmployerIds;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getPlacesWorkedCount() {
        return placesWorkedCount;
    }

    public void setPlacesWorkedCount(String placesWorkedCount) {
        this.placesWorkedCount = placesWorkedCount;
    }

    public Integer getYearsOfExperienceCount() {
        return yearsOfExperienceCount;
    }

    public void setYearsOfExperienceCount(Integer yearsOfExperienceCount) {
        this.yearsOfExperienceCount = yearsOfExperienceCount;
    }

    public Boolean getReturning() {
        return returning;
    }

    public void setReturning(Boolean returning) {
        this.returning = returning;
    }

    public Object getEmployerIds() {
        return employerIds;
    }

    public void setEmployerIds(Object employerIds) {
        this.employerIds = employerIds;
    }

    public List<Object> getAdminEmployers() {
        return adminEmployers;
    }

    public void setAdminEmployers(List<Object> adminEmployers) {
        this.adminEmployers = adminEmployers;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public PrimaryWorkHistory getPrimaryWorkHistory() {
        return primaryWorkHistory;
    }

    public void setPrimaryWorkHistory(PrimaryWorkHistory primaryWorkHistory) {
        this.primaryWorkHistory = primaryWorkHistory;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public Integer getSharedNetworkConnectionCount() {
        return sharedNetworkConnectionCount;
    }

    public void setSharedNetworkConnectionCount(Integer sharedNetworkConnectionCount) {
        this.sharedNetworkConnectionCount = sharedNetworkConnectionCount;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public String getPreferredLocale() {
        return preferredLocale;
    }

    public void setPreferredLocale(String preferredLocale) {
        this.preferredLocale = preferredLocale;
    }

    public Boolean getConnectedToCurrentUser() {
        return connectedToCurrentUser;
    }

    public void setConnectedToCurrentUser(Boolean connectedToCurrentUser) {
        this.connectedToCurrentUser = connectedToCurrentUser;
    }

    public Integer getConnectionStatusWithCurrentUser() {
        return connectionStatusWithCurrentUser;
    }

    public void setConnectionStatusWithCurrentUser(Integer connectionStatusWithCurrentUser) {
        this.connectionStatusWithCurrentUser = connectionStatusWithCurrentUser;
    }

    public List<Eligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<Eligibility> eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getReferralsForCurrentEmployerCount() {
        return referralsForCurrentEmployerCount;
    }

    public void setReferralsForCurrentEmployerCount(Integer referralsForCurrentEmployerCount) {
        this.referralsForCurrentEmployerCount = referralsForCurrentEmployerCount;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public Object getJobPreferences() {
        return jobPreferences;
    }

    public void setJobPreferences(Object jobPreferences) {
        this.jobPreferences = jobPreferences;
    }

    public Boolean getFirstJobSearch() {
        return firstJobSearch;
    }

    public void setFirstJobSearch(Boolean firstJobSearch) {
        this.firstJobSearch = firstJobSearch;
    }

    public Integer getFetchMask() {
        return fetchMask;
    }

    public void setFetchMask(Integer fetchMask) {
        this.fetchMask = fetchMask;
    }

    public Boolean getPasswordSetByUser() {
        return passwordSetByUser;
    }

    public void setPasswordSetByUser(Boolean passwordSetByUser) {
        this.passwordSetByUser = passwordSetByUser;
    }

    public String getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(String registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public Boolean getHsUser() {
        return hsUser;
    }

    public void setHsUser(Boolean hsUser) {
        this.hsUser = hsUser;
    }

    public Integer getEndorsementCount() {
        return endorsementCount;
    }

    public void setEndorsementCount(Integer endorsementCount) {
        this.endorsementCount = endorsementCount;
    }

    public Integer getChatWithNewMessagesCount() {
        return chatWithNewMessagesCount;
    }

    public void setChatWithNewMessagesCount(Integer chatWithNewMessagesCount) {
        this.chatWithNewMessagesCount = chatWithNewMessagesCount;
    }

    public Integer getHsVerifiedCount() {
        return hsVerifiedCount;
    }

    public void setHsVerifiedCount(Integer hsVerifiedCount) {
        this.hsVerifiedCount = hsVerifiedCount;
    }

    public Integer getReferralsGivenConfirmedCount() {
        return referralsGivenConfirmedCount;
    }

    public void setReferralsGivenConfirmedCount(Integer referralsGivenConfirmedCount) {
        this.referralsGivenConfirmedCount = referralsGivenConfirmedCount;
    }

    public Integer getNetworkCount() {
        return networkCount;
    }

    public void setNetworkCount(Integer networkCount) {
        this.networkCount = networkCount;
    }

    public String getEmploymentInterestStatus() {
        return getEmploymentInterestStatus();
    }

    public void setEmploymentInterestStatus(String interestStatus) {
        this.employmentInterestStatus = interestStatus;
    }

    public String getEmploymentInterestType() {
        return employmentInterestType;
    }

    public void setEmploymentInterestType(String interestType) {
        this.employmentInterestType = interestType;
    }

    public String getGigInterestStatus() {
        return gigInterestStatus;
    }

    public void setGigInterestStatus(String gigInterest) {
        this.gigInterestStatus = gigInterest;
    }

    public void setSkills(List<Skill> userSkills) {
        this.skills = userSkills;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
