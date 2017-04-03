import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("userGuid")
    @Expose
    private String userGuid;
    @SerializedName("role")
    @Expose
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
