package com.navin.wallpaper.webService;

import android.content.Context;

import com.navin.wallpaper.model.Album;
import com.navin.wallpaper.model.Category;
import com.navin.wallpaper.model.IMessageAlbumListener;
import com.navin.wallpaper.model.IMessageCategoryListener;
import com.navin.wallpaper.model.IMessageListener;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.model.WallpaperList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class WebServiceCaller {

    Context context;
    IWallpaperHandler apiInterface;
    WallpaperList wallpaperList=new WallpaperList();

    public WebServiceCaller(Context context){

        this.context=context;
        apiInterface=ApiClinet.getClinet().create(IWallpaperHandler.class);

    }

    public void getLatestWallpaper(final IMessageListener iMessageListener)throws Exception{

//        Call<List<WallpaperList>> getLatestWallpaper=apiInterface.getLatestWallpaper();
            Call<List<Wallpaper>> getLatestWallpaper=apiInterface.getLatestWallpaper();
        getLatestWallpaper.enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                iMessageListener.onError(t.getMessage().toString());
            }
        });


    }

    public void getAllWallpaper(final IMessageListener iMessageListener) throws Exception{

        Call<List<Wallpaper>> getAllWallpaper=apiInterface.getLatestWallpaper();
        getAllWallpaper.enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                iMessageListener.onError(t.getMessage());
            }
        });

    }
    public void getAlbum(final IMessageAlbumListener iMessageAlbumListener) throws Exception{

        Call<List<Album>> getAlbum=apiInterface.getAlbum();
        getAlbum.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                iMessageAlbumListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                iMessageAlbumListener.onError(t.getMessage());
            }
        });

    }
    public void getCategories(final IMessageCategoryListener iMessageCategoryListener) throws Exception{


        Call<List<Category>> getCategories=apiInterface.getCategories();
        getCategories.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                iMessageCategoryListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                iMessageCategoryListener.onError((t.getMessage()));
            }
        });


    }

    public void getWallpaperBYCat(final IMessageListener iMessageListener,String id) throws Exception{

        Call<List<Wallpaper>> getWallpaperBYCat=apiInterface.getWallpaperBYCat(id);
        getWallpaperBYCat.enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                iMessageListener.onError((t.getMessage()));
            }
        });




    }

    public void getWallpaperBYAlbum(final IMessageListener iMessageListener,String id) throws Exception{

        Call<List<Wallpaper>> getWallpaperBYAlbum=apiInterface.getWallpaperBYAlbum(id);
        getWallpaperBYAlbum.enqueue(new Callback<List<Wallpaper>>() {
            @Override
            public void onResponse(Call<List<Wallpaper>> call, Response<List<Wallpaper>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Wallpaper>> call, Throwable t) {
                iMessageListener.onError((t.getMessage()));
            }
        });




    }


}
