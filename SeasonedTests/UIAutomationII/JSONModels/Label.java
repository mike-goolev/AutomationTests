import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Label {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("name")
    @Expose
    private String name;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
