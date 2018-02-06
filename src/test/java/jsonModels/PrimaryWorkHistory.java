package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

public class PrimaryWorkHistory {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("userGuid")
    @Expose
    private Object userGuid;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("startDateMillis")
    @Expose
    private BigInteger startDateMillis;
    @SerializedName("endDateMillis")
    @Expose
    private BigInteger endDateMillis;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("jobs")
    @Expose
    private List<Job> jobs = null;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("type")
    @Expose
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Object getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(Object userGuid) {
        this.userGuid = userGuid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigInteger getStartDateMillis() {
        return startDateMillis;
    }

    public void setStartDateMillis(BigInteger startDateMillis) {
        this.startDateMillis = startDateMillis;
    }

    public BigInteger getEndDateMillis() {
        return endDateMillis;
    }

    public void setEndDateMillis(BigInteger endDateMillis) {
        this.endDateMillis = endDateMillis;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
