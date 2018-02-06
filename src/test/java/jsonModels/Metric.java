package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metric {

    @SerializedName("endorsementCount")
    @Expose
    private Integer endorsementCount;
    @SerializedName("chatWithNewMessagesCount")
    @Expose
    private Integer chatWithNewMessagesCount;
    @SerializedName("hsVerifiedCount")
    @Expose
    private Integer hsVerifiedCount;
    @SerializedName("referralsGivenConfirmedCount")
    @Expose
    private Integer referralsGivenConfirmedCount;
    @SerializedName("networkCount")
    @Expose
    private Integer networkCount;

    public Integer getEndorsementCount() {
        return endorsementCount;
    }

    public void setEndorsementCount(Integer endorsementCount) {
        this.endorsementCount = endorsementCount;
    }

    public Integer getChatWithNewMessagesCount() {
        return chatWithNewMessagesCount;
    }

    public void setChatWithNewMessagesCount(Integer chatWithNewMessagesCount) {
        this.chatWithNewMessagesCount = chatWithNewMessagesCount;
    }

    public Integer getHsVerifiedCount() {
        return hsVerifiedCount;
    }

    public void setHsVerifiedCount(Integer hsVerifiedCount) {
        this.hsVerifiedCount = hsVerifiedCount;
    }

    public Integer getReferralsGivenConfirmedCount() {
        return referralsGivenConfirmedCount;
    }

    public void setReferralsGivenConfirmedCount(Integer referralsGivenConfirmedCount) {
        this.referralsGivenConfirmedCount = referralsGivenConfirmedCount;
    }

    public Integer getNetworkCount() {
        return networkCount;
    }

    public void setNetworkCount(Integer networkCount) {
        this.networkCount = networkCount;
    }

}
