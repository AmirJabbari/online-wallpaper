package com.navin.wallpaper.webService;

import com.navin.wallpaper.model.Album;
import com.navin.wallpaper.model.Category;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.model.WallpaperList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWallpaperHandler {


    @GET("api.php?latest")
    public Call<List<Wallpaper>> getLatestWallpaper();

    @GET("api.php?cat_list")
    public Call<List<Category>> getCategories();


    @GET("api.php?album_list")
    public Call<List<Album>> getAlbum();

    @GET("api.php")
    public Call<List<Wallpaper>> getWallpaperBYCat(@Query("cat_id") String id);

    @GET("api.php")
    public Call<List<Wallpaper>> getWallpaperBYAlbum(@Query("album_id") String id);


}
