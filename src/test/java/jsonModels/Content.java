package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("siteName")
    @Expose
    private String siteName;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("published")
    @Expose
    private Long published;
    @SerializedName("uploadedBy")
    @Expose
    private UploadedBy uploadedBy;
    @SerializedName("likeCount")
    @Expose
    private Integer likeCount;
    @SerializedName("recentViewCount")
    @Expose
    private Integer recentViewCount;
    @SerializedName("totalViewCount")
    @Expose
    private Integer totalViewCount;
    @SerializedName("likedByCurrentUser")
    @Expose
    private Boolean likedByCurrentUser;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Long getPublished() {
        return published;
    }

    public void setPublished(Long published) {
        this.published = published;
    }

    public UploadedBy getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(UploadedBy uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getRecentViewCount() {
        return recentViewCount;
    }

    public void setRecentViewCount(Integer recentViewCount) {
        this.recentViewCount = recentViewCount;
    }

    public Integer getTotalViewCount() {
        return totalViewCount;
    }

    public void setTotalViewCount(Integer totalViewCount) {
        this.totalViewCount = totalViewCount;
    }

    public Boolean getLikedByCurrentUser() {
        return likedByCurrentUser;
    }

    public void setLikedByCurrentUser(Boolean likedByCurrentUser) {
        this.likedByCurrentUser = likedByCurrentUser;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

}
