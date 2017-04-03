import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Certification {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("photo")
    @Expose
    private Object photo;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

}
