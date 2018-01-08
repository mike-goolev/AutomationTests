import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Education {

    @SerializedName("guid")
    @Expose
    private String guid;

    @SerializedName("userGuid")
    @Expose
    private String userGuid;

    @SerializedName("institution")
    @Expose
    private String institution;

    @SerializedName("degree")
    @Expose
    private String degree;

    @SerializedName("startDateMillis")
    @Expose
    private Integer startDateMillis;

    @SerializedName("endDateMillis")
    @Expose
    private Integer endDateMillis;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getStartDateMillis() {
        return startDateMillis;
    }

    public void setStartDateMillis(Integer startDateMillis) {
        this.startDateMillis = startDateMillis;
    }

    public Integer getEndDateMillis() {
        return endDateMillis;
    }

    public void setEndDateMillis(Integer endDateMillis) {
        this.endDateMillis = endDateMillis;
    }
}
