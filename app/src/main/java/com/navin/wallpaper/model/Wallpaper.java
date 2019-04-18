package com.navin.wallpaper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpaper {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("mp3_type")
    @Expose
    private String mp3Type;
    @SerializedName("mp3_title")
    @Expose
    private String mp3Title;
    @SerializedName("mp3_url")
    @Expose
    private String mp3Url;
    @SerializedName("mp3_thumbnail_b")
    @Expose
    private String mp3ThumbnailB;
    @SerializedName("mp3_thumbnail_s")
    @Expose
    private String mp3ThumbnailS;
    @SerializedName("mp3_duration")
    @Expose
    private String mp3Duration;
    @SerializedName("mp3_artist")
    @Expose
    private String mp3Artist;
    @SerializedName("mp3_description")
    @Expose
    private String mp3Description;
    @SerializedName("total_rate")
    @Expose
    private String totalRate;
    @SerializedName("rate_avg")
    @Expose
    private String rateAvg;
    @SerializedName("total_views")
    @Expose
    private String totalViews;
    @SerializedName("total_download")
    @Expose
    private String totalDownload;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_image_thumb")
    @Expose
    private String categoryImageThumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getMp3Type() {
        return mp3Type;
    }

    public void setMp3Type(String mp3Type) {
        this.mp3Type = mp3Type;
    }

    public String getMp3Title() {
        return mp3Title;
    }

    public void setMp3Title(String mp3Title) {
        this.mp3Title = mp3Title;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public String getMp3ThumbnailB() {
        return mp3ThumbnailB;
    }

    public void setMp3ThumbnailB(String mp3ThumbnailB) {
        this.mp3ThumbnailB = mp3ThumbnailB;
    }

    public String getMp3ThumbnailS() {
        return mp3ThumbnailS;
    }

    public void setMp3ThumbnailS(String mp3ThumbnailS) {
        this.mp3ThumbnailS = mp3ThumbnailS;
    }

    public String getMp3Duration() {
        return mp3Duration;
    }

    public void setMp3Duration(String mp3Duration) {
        this.mp3Duration = mp3Duration;
    }

    public String getMp3Artist() {
        return mp3Artist;
    }

    public void setMp3Artist(String mp3Artist) {
        this.mp3Artist = mp3Artist;
    }

    public String getMp3Description() {
        return mp3Description;
    }

    public void setMp3Description(String mp3Description) {
        this.mp3Description = mp3Description;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(String totalDownload) {
        this.totalDownload = totalDownload;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryImageThumb() {
        return categoryImageThumb;
    }

    public void setCategoryImageThumb(String categoryImageThumb) {
        this.categoryImageThumb = categoryImageThumb;
    }

}
