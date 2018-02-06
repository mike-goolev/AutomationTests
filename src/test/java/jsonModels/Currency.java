package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("currencyCodeISO")
    @Expose
    private String currencyCodeISO;
    @SerializedName("numericCode")
    @Expose
    private Integer numericCode;
    @SerializedName("defaultFractionDigits")
    @Expose
    private Integer defaultFractionDigits;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCodeISO() {
        return currencyCodeISO;
    }

    public void setCurrencyCodeISO(String currencyCodeISO) {
        this.currencyCodeISO = currencyCodeISO;
    }

    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    public Integer getDefaultFractionDigits() {
        return defaultFractionDigits;
    }

    public void setDefaultFractionDigits(Integer defaultFractionDigits) {
        this.defaultFractionDigits = defaultFractionDigits;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
