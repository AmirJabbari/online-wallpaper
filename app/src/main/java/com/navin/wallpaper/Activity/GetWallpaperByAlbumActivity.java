package com.navin.wallpaper.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.navin.wallpaper.R;
import com.navin.wallpaper.adapter.WallpaperByAlbumAdapter;
import com.navin.wallpaper.model.IMessageListener;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.webService.WebServiceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetWallpaperByAlbumActivity extends AppCompatActivity {

    Bundle bundle;
    String album;
    WebServiceCaller webServiceCaller;
    @BindView(R.id.recycler_wallpaper)
    RecyclerView recyclerView;
    WallpaperByAlbumAdapter wallpaperByAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wallpaper_by_album);
        ButterKnife.bind(this);
        webServiceCaller=new WebServiceCaller(getApplicationContext());
        bundle=getIntent().getExtras();
        album=bundle.getString("album");
        if (album!=null){

            getAllWallpaper();
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
        }

    }


    public void getAllWallpaper(){
        try {
            webServiceCaller.getWallpaperBYAlbum(new IMessageListener() {
                @Override
                public void onSuccess(List<Wallpaper> wallpaperList) {
                    wallpaperByAlbumAdapter=new WallpaperByAlbumAdapter(getApplicationContext(),wallpaperList);
                    recyclerView.setAdapter(wallpaperByAlbumAdapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                }

                @Override
                public void onError(String errorResponse) {

                }
            },album);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
