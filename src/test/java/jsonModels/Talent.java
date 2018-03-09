package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Talent {

    @SerializedName("admin")
    @Expose
    private AdminEmployer admin;

    @SerializedName("userGuid")
    @Expose
    private String userGuid;

    @SerializedName("status")
    @Expose
    private String status;

    public AdminEmployer getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEmployer admin) {
        this.admin = admin;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
