package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Job {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("jobName")
    @Expose
    private String jobName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("wage")
    @Expose
    private String wage;


    @SerializedName("minWage")
    @Expose
    private String minWage;

    @SerializedName("maxWage")
    @Expose
    private String maxWage;

    @SerializedName("wageType")
    @Expose
    private String wageType;
    @SerializedName("tinyurl")
    @Expose
    private String tinyurl;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("referralBonus")
    @Expose
    private Object referralBonus;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("postedBy")
    @Expose
    private PostedBy postedBy;
    @SerializedName("jobType")
    @Expose
    private JobType jobType;
    @SerializedName("currentUserIsCandidate")
    @Expose
    private Boolean currentUserIsCandidate;
    @SerializedName("shifts")
    @Expose
    private List<Object> shifts = null;
    @SerializedName("candidates")
    @Expose
    private List<Object> candidates = null;
    @SerializedName("referrals")
    @Expose
    private List<Object> referrals = null;
    @SerializedName("shares")
    @Expose
    private List<Object> shares = null;
    @SerializedName("posted")
    @Expose
    private String posted;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("jobPostingType")
    @Expose
    private String jobPostingType;
    @SerializedName("paymentModelType")
    @Expose
    private String paymentModelType;
    @SerializedName("employeeShareCount")
    @Expose
    private Integer employeeShareCount;
    @SerializedName("metric")
    @Expose
    private Metric metric;
    @SerializedName("budget")
    @Expose
    private Object budget;
    @SerializedName("remainingBudget")
    @Expose
    private Object remainingBudget;
    @SerializedName("quote")
    @Expose
    private Object quote;
    @SerializedName("remainingCandidates")
    @Expose
    private Object remainingCandidates;
    @SerializedName("budgetedCandidates")
    @Expose
    private Object budgetedCandidates;
    @SerializedName("j2cTrackingPixelUrl")
    @Expose
    private Object j2cTrackingPixelUrl;
    @SerializedName("nonce")
    @Expose
    private Object nonce;
    @SerializedName("stripeToken")
    @Expose
    private Object stripeToken;
    @SerializedName("fetchMask")
    @Expose
    private Integer fetchMask;

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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getMinWage() {
        return minWage;
    }

    public void setMinWage(String minWage) {
        this.minWage = minWage;
    }

    public String getMaxWage() {
        return maxWage;
    }

    public void setMaxWage(String maxWage) {
        this.maxWage = maxWage;
    }

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public String getTinyurl() {
        return tinyurl;
    }

    public void setTinyurl(String tinyurl) {
        this.tinyurl = tinyurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getReferralBonus() {
        return referralBonus;
    }

    public void setReferralBonus(Object referralBonus) {
        this.referralBonus = referralBonus;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public PostedBy getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(PostedBy postedBy) {
        this.postedBy = postedBy;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Boolean getCurrentUserIsCandidate() {
        return currentUserIsCandidate;
    }

    public void setCurrentUserIsCandidate(Boolean currentUserIsCandidate) {
        this.currentUserIsCandidate = currentUserIsCandidate;
    }

    public List<Object> getShifts() {
        return shifts;
    }

    public void setShifts(List<Object> shifts) {
        this.shifts = shifts;
    }

    public List<Object> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Object> candidates) {
        this.candidates = candidates;
    }

    public List<Object> getReferrals() {
        return referrals;
    }

    public void setReferrals(List<Object> referrals) {
        this.referrals = referrals;
    }

    public List<Object> getShares() {
        return shares;
    }

    public void setShares(List<Object> shares) {
        this.shares = shares;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getJobPostingType() {
        return jobPostingType;
    }

    public void setJobPostingType(String jobPostingType) {
        this.jobPostingType = jobPostingType;
    }

    public String getPaymentModelType() {
        return paymentModelType;
    }

    public void setPaymentModelType(String paymentModelType) {
        this.paymentModelType = paymentModelType;
    }

    public Integer getEmployeeShareCount() {
        return employeeShareCount;
    }

    public void setEmployeeShareCount(Integer employeeShareCount) {
        this.employeeShareCount = employeeShareCount;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Object getBudget() {
        return budget;
    }

    public void setBudget(Object budget) {
        this.budget = budget;
    }

    public Object getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(Object remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public Object getQuote() {
        return quote;
    }

    public void setQuote(Object quote) {
        this.quote = quote;
    }

    public Object getRemainingCandidates() {
        return remainingCandidates;
    }

    public void setRemainingCandidates(Object remainingCandidates) {
        this.remainingCandidates = remainingCandidates;
    }

    public Object getBudgetedCandidates() {
        return budgetedCandidates;
    }

    public void setBudgetedCandidates(Object budgetedCandidates) {
        this.budgetedCandidates = budgetedCandidates;
    }

    public Object getJ2cTrackingPixelUrl() {
        return j2cTrackingPixelUrl;
    }

    public void setJ2cTrackingPixelUrl(Object j2cTrackingPixelUrl) {
        this.j2cTrackingPixelUrl = j2cTrackingPixelUrl;
    }

    public Object getNonce() {
        return nonce;
    }

    public void setNonce(Object nonce) {
        this.nonce = nonce;
    }

    public Object getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(Object stripeToken) {
        this.stripeToken = stripeToken;
    }

    public Integer getFetchMask() {
        return fetchMask;
    }

    public void setFetchMask(Integer fetchMask) {
        this.fetchMask = fetchMask;
    }

}