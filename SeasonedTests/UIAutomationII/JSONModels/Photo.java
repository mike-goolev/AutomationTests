import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;
    @SerializedName("url_medium")
    @Expose
    private String urlMedium;
    @SerializedName("url_uncropped")
    @Expose
    private String urlUncropped;
    @SerializedName("flagged")
    @Expose
    private Boolean flagged;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attributions")
    @Expose
    private List<Object> attributions = null;
    @SerializedName("userId")
    @Expose
    private String userId;

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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public String getUrlUncropped() {
        return urlUncropped;
    }

    public void setUrlUncropped(String urlUncropped) {
        this.urlUncropped = urlUncropped;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getAttributions() {
        return attributions;
    }

    public void setAttributions(List<Object> attributions) {
        this.attributions = attributions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
