package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Friday {

    @SerializedName("AFTERNOONS")
    @Expose
    private Boolean afternoons;
    @SerializedName("EVENINGS")
    @Expose
    private Boolean evenings;
    @SerializedName("LATE_NIGHT")
    @Expose
    private Boolean nights;
    @SerializedName("MORNINGS")
    @Expose
    private Boolean mornings;

    public Boolean getAfternoons() {
        return afternoons;
    }

    public void setAfternoons(Boolean afternoons) {
        this.afternoons = afternoons;
    }

    public Boolean getEvenings() {
        return evenings;
    }

    public void setEvenings(Boolean evenings) {
        this.evenings = evenings;
    }

    public Boolean getNights() {
        return nights;
    }

    public void setNights(Boolean nights) {
        this.nights = nights;
    }

    public Boolean getMornings() {
        return mornings;
    }

    public void setMornings(Boolean mornings) {
        this.mornings = mornings;
    }

}
