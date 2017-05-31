import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Network {

    @SerializedName("fromUserGuid")
    @Expose
    private String fromUserGuid;

    @SerializedName("toUserGuid")
    @Expose
    private String toUserGuid;

    public String getFromUserGuid() {
        return fromUserGuid;
    }

    public void setFromUserGuid(String fromUserGuid) {
        this.fromUserGuid = fromUserGuid;
    }

    public String getToUserGuid() {
        return toUserGuid;
    }

    public void setToUserGuid(String toUserGuid) {
        this.toUserGuid = toUserGuid;
    }

}
