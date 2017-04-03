import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Job {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("empId")
    @Expose
    private Integer empId;
    @SerializedName("empEmail")
    @Expose
    private Object empEmail;
    @SerializedName("clientId")
    @Expose
    private Integer clientId;
    @SerializedName("jobName")
    @Expose
    private String jobName;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("startDate")
    @Expose
    private Object startDate;
    @SerializedName("endDate")
    @Expose
    private Object endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Object getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(Object empEmail) {
        this.empEmail = empEmail;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

}
