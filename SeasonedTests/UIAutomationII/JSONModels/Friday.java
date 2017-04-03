import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Friday {

    @SerializedName("AFTERNOONS")
    @Expose
    private Boolean aFTERNOONS;
    @SerializedName("EVENINGS")
    @Expose
    private Boolean eVENINGS;
    @SerializedName("LATE_NIGHT")
    @Expose
    private Boolean lATENIGHT;
    @SerializedName("MORNINGS")
    @Expose
    private Boolean mORNINGS;

    public Boolean getAFTERNOONS() {
        return aFTERNOONS;
    }

    public void setAFTERNOONS(Boolean aFTERNOONS) {
        this.aFTERNOONS = aFTERNOONS;
    }

    public Boolean getEVENINGS() {
        return eVENINGS;
    }

    public void setEVENINGS(Boolean eVENINGS) {
        this.eVENINGS = eVENINGS;
    }

    public Boolean getLATENIGHT() {
        return lATENIGHT;
    }

    public void setLATENIGHT(Boolean lATENIGHT) {
        this.lATENIGHT = lATENIGHT;
    }

    public Boolean getMORNINGS() {
        return mORNINGS;
    }

    public void setMORNINGS(Boolean mORNINGS) {
        this.mORNINGS = mORNINGS;
    }

}
