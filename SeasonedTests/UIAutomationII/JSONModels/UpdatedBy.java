import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatedBy {

    @SerializedName("guid")
    @Expose
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

}