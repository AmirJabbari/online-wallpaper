package com.navin.wallpaper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WallpaperList {

    @SerializedName("ONLINE_MP3")
    @Expose
    private ArrayList<Wallpaper> wallpaperList;


    public ArrayList<Wallpaper> getWallpaperList() {
        return wallpaperList;
    }

    public void setWallpaperList(ArrayList<Wallpaper> wallpaperList) {
        this.wallpaperList = wallpaperList;
    }
}
