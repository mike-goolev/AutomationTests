package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UploadedBy {

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
    private Object about;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("dobMillis")
    @Expose
    private Object dobMillis;
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
    private Object termsUrl;
    @SerializedName("termsAppleUrl")
    @Expose
    private Object termsAppleUrl;
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
    private Object emails;
    @SerializedName("placesWorkedCount")
    @Expose
    private Object placesWorkedCount;
    @SerializedName("yearsOfExperienceCount")
    @Expose
    private Integer yearsOfExperienceCount;
    @SerializedName("returning")
    @Expose
    private Boolean returning;
    @SerializedName("employerIds")
    @Expose
    private List<String> employerIds = null;
    @SerializedName("adminEmployers")
    @Expose
    private List<AdminEmployer> adminEmployers = null;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("primaryWorkHistory")
    @Expose
    private Object primaryWorkHistory;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = null;
    @SerializedName("location")
    @Expose
    private Location location;
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
    private List<Object> certifications = null;
    @SerializedName("preferredLocale")
    @Expose
    private Object preferredLocale;
    @SerializedName("connectedToCurrentUser")
    @Expose
    private Boolean connectedToCurrentUser;
    @SerializedName("connectionStatusWithCurrentUser")
    @Expose
    private Integer connectionStatusWithCurrentUser;
    @SerializedName("eligibility")
    @Expose
    private List<Object> eligibility = null;
    @SerializedName("referralsForCurrentEmployerCount")
    @Expose
    private Integer referralsForCurrentEmployerCount;
    @SerializedName("availability")
    @Expose
    private Object availability;
    @SerializedName("availabilityString")
    @Expose
    private Object availabilityString;
    @SerializedName("preferences")
    @Expose
    private Object preferences;
    @SerializedName("jobPreferences")
    @Expose
    private Object jobPreferences;
    @SerializedName("skills")
    @Expose
    private Object skills;
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
    private Object registrationMethod;
    @SerializedName("employmentInterestStatus")
    @Expose
    private String employmentInterestStatus;
    @SerializedName("employmentInterestType")
    @Expose
    private String employmentInterestType;
    @SerializedName("gigInterestStatus")
    @Expose
    private String gigInterestStatus;
    @SerializedName("savedJobPostings")
    @Expose
    private List<Object> savedJobPostings = null;
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
    @SerializedName("hsUser")
    @Expose
    private Boolean hsUser;
    @SerializedName("employed")
    @Expose
    private Boolean employed;
    @SerializedName("admin")
    @Expose
    private Boolean admin;

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

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getDobMillis() {
        return dobMillis;
    }

    public void setDobMillis(Object dobMillis) {
        this.dobMillis = dobMillis;
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

    public Object getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(Object termsUrl) {
        this.termsUrl = termsUrl;
    }

    public Object getTermsAppleUrl() {
        return termsAppleUrl;
    }

    public void setTermsAppleUrl(Object termsAppleUrl) {
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

    public Object getEmails() {
        return emails;
    }

    public void setEmails(Object emails) {
        this.emails = emails;
    }

    public Object getPlacesWorkedCount() {
        return placesWorkedCount;
    }

    public void setPlacesWorkedCount(Object placesWorkedCount) {
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

    public List<String> getEmployerIds() {
        return employerIds;
    }

    public void setEmployerIds(List<String> employerIds) {
        this.employerIds = employerIds;
    }

    public List<AdminEmployer> getAdminEmployers() {
        return adminEmployers;
    }

    public void setAdminEmployers(List<AdminEmployer> adminEmployers) {
        this.adminEmployers = adminEmployers;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Object getPrimaryWorkHistory() {
        return primaryWorkHistory;
    }

    public void setPrimaryWorkHistory(Object primaryWorkHistory) {
        this.primaryWorkHistory = primaryWorkHistory;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public List<Object> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Object> certifications) {
        this.certifications = certifications;
    }

    public Object getPreferredLocale() {
        return preferredLocale;
    }

    public void setPreferredLocale(Object preferredLocale) {
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

    public List<Object> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<Object> eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getReferralsForCurrentEmployerCount() {
        return referralsForCurrentEmployerCount;
    }

    public void setReferralsForCurrentEmployerCount(Integer referralsForCurrentEmployerCount) {
        this.referralsForCurrentEmployerCount = referralsForCurrentEmployerCount;
    }

    public Object getAvailability() {
        return availability;
    }

    public void setAvailability(Object availability) {
        this.availability = availability;
    }

    public Object getAvailabilityString() {
        return availabilityString;
    }

    public void setAvailabilityString(Object availabilityString) {
        this.availabilityString = availabilityString;
    }

    public Object getPreferences() {
        return preferences;
    }

    public void setPreferences(Object preferences) {
        this.preferences = preferences;
    }

    public Object getJobPreferences() {
        return jobPreferences;
    }

    public void setJobPreferences(Object jobPreferences) {
        this.jobPreferences = jobPreferences;
    }

    public Object getSkills() {
        return skills;
    }

    public void setSkills(Object skills) {
        this.skills = skills;
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

    public Object getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(Object registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public String getEmploymentInterestStatus() {
        return employmentInterestStatus;
    }

    public void setEmploymentInterestStatus(String employmentInterestStatus) {
        this.employmentInterestStatus = employmentInterestStatus;
    }

    public String getEmploymentInterestType() {
        return employmentInterestType;
    }

    public void setEmploymentInterestType(String employmentInterestType) {
        this.employmentInterestType = employmentInterestType;
    }

    public String getGigInterestStatus() {
        return gigInterestStatus;
    }

    public void setGigInterestStatus(String gigInterestStatus) {
        this.gigInterestStatus = gigInterestStatus;
    }

    public List<Object> getSavedJobPostings() {
        return savedJobPostings;
    }

    public void setSavedJobPostings(List<Object> savedJobPostings) {
        this.savedJobPostings = savedJobPostings;
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

    public Boolean getHsUser() {
        return hsUser;
    }

    public void setHsUser(Boolean hsUser) {
        this.hsUser = hsUser;
    }

    public Boolean getEmployed() {
        return employed;
    }

    public void setEmployed(Boolean employed) {
        this.employed = employed;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}