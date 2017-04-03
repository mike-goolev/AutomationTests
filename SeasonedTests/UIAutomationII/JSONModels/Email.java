import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("guid")
    @Expose
    private Object guid;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("primary")
    @Expose
    private Boolean primary;

    public Object getGuid() {
        return guid;
    }

    public void setGuid(Object guid) {
        this.guid = guid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

}
