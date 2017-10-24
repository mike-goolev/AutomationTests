import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("ppa")
    @Expose
    private Integer ppa;
    @SerializedName("storeHours")
    @Expose
    private Object storeHours;
    @SerializedName("preferences")
    @Expose
    private Object preferences;
    @SerializedName("admins")
    @Expose
    private Object admins;
    @SerializedName("externalIds")
    @Expose
    private Object externalIds;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("logo")
    @Expose
    private Object logo;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("claimed")
    @Expose
    private Boolean claimed;
    @SerializedName("claimedByUser")
    @Expose
    private Object claimedByUser;
    @SerializedName("claimedDate")
    @Expose
    private String claimedDate;
    @SerializedName("metric")
    @Expose
    private Object metric;
    @SerializedName("certificationType")
    @Expose
    private CertificationType certificationType;
    @SerializedName("premium")
    @Expose
    private Boolean premium;
    @SerializedName("accountUpgradable")
    @Expose
    private Boolean accountUpgradable;
    @SerializedName("paymentEnabled")
    @Expose
    private Boolean paymentEnabled;
    @SerializedName("hsEmployer")
    @Expose
    private Boolean hsEmployer;
    @SerializedName("accountLevel")
    @Expose
    private String accountLevel;
    @SerializedName("photos")
    @Expose
    private Object photos;
    @SerializedName("paymentInfoIFrameUrl")
    @Expose
    private Object paymentInfoIFrameUrl;
    @SerializedName("fetchMask")
    @Expose
    private Integer fetchMask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Integer getPpa() {
        return ppa;
    }

    public void setPpa(Integer ppa) {
        this.ppa = ppa;
    }

    public Object getStoreHours() {
        return storeHours;
    }

    public void setStoreHours(Object storeHours) {
        this.storeHours = storeHours;
    }

    public Object getPreferences() {
        return preferences;
    }

    public void setPreferences(Object preferences) {
        this.preferences = preferences;
    }

    public Object getAdmins() {
        return admins;
    }

    public void setAdmins(Object admins) {
        this.admins = admins;
    }

    public Object getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(Object externalIds) {
        this.externalIds = externalIds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Object getLogo() {
        return logo;
    }

    public void setLogo(Object logo) {
        this.logo = logo;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getClaimed() {
        return claimed;
    }

    public void setClaimed(Boolean claimed) {
        this.claimed = claimed;
    }

    public Object getClaimedByUser() {
        return claimedByUser;
    }

    public void setClaimedByUser(Object claimedByUser) {
        this.claimedByUser = claimedByUser;
    }

    public String getClaimedDate() {
        return claimedDate;
    }

    public void setClaimedDate(String claimedDate) {
        this.claimedDate = claimedDate;
    }

    public Object getMetric() {
        return metric;
    }

    public void setMetric(Object metric) {
        this.metric = metric;
    }

    public CertificationType getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(CertificationType certificationType) {
        this.certificationType = certificationType;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public Boolean getAccountUpgradable() {
        return accountUpgradable;
    }

    public void setAccountUpgradable(Boolean accountUpgradable) {
        this.accountUpgradable = accountUpgradable;
    }

    public Boolean getPaymentEnabled() {
        return paymentEnabled;
    }

    public void setPaymentEnabled(Boolean paymentEnabled) {
        this.paymentEnabled = paymentEnabled;
    }

    public Boolean getHsEmployer() {
        return hsEmployer;
    }

    public void setHsEmployer(Boolean hsEmployer) {
        this.hsEmployer = hsEmployer;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Object getPhotos() {
        return photos;
    }

    public void setPhotos(Object photos) {
        this.photos = photos;
    }

    public Object getPaymentInfoIFrameUrl() {
        return paymentInfoIFrameUrl;
    }

    public void setPaymentInfoIFrameUrl(Object paymentInfoIFrameUrl) {
        this.paymentInfoIFrameUrl = paymentInfoIFrameUrl;
    }

    public Integer getFetchMask() {
        return fetchMask;
    }

    public void setFetchMask(Integer fetchMask) {
        this.fetchMask = fetchMask;
    }

}
