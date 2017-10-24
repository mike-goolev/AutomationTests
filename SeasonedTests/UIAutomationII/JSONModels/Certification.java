import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Certification {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("certificationType")
    @Expose
    private CertificationType certificationType;
    @SerializedName("photo")
    @Expose
    private Object photo;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public CertificationType getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(CertificationType certificationType) {
        this.certificationType = certificationType;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

}
