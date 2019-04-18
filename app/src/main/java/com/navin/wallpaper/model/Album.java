package com.navin.wallpaper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {


    @SerializedName("aid")
    @Expose
    private String aid;
    @SerializedName("album_name")
    @Expose
    private String albumName;
    @SerializedName("album_image")
    @Expose
    private String albumImage;
    @SerializedName("album_image_thumb")
    @Expose
    private String albumImageThumb;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public String getAlbumImageThumb() {
        return albumImageThumb;
    }

    public void setAlbumImageThumb(String albumImageThumb) {
        this.albumImageThumb = albumImageThumb;
    }



}
