package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OAuthToken {

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("token_type")
    @Expose
    private String token_type;

    @SerializedName("expires_in")
    @Expose
    private String expires_in;

    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    @SerializedName("hs_user")
    @Expose
    private String hs_user;

    @SerializedName("brushfire_user_guid")
    @Expose
    private String brushfire_user_guid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getHs_user() {
        return hs_user;
    }

    public void setHs_user(String hs_user) {
        this.hs_user = hs_user;
    }

    public String getBrushfire_user_guid() {
        return brushfire_user_guid;
    }

    public void setBrushfire_user_guid(String brushfire_user_guid) {
        this.brushfire_user_guid = brushfire_user_guid;
    }
}
