package com.navin.wallpaper.Activity;

import android.Manifest;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.navin.wallpaper.R;
import com.navin.wallpaper.model.Wallpaper;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallpaperDetailActivity extends AppCompatActivity {

    Bundle bundle;
    Wallpaper wallpaper;
    String wallpaperr;


    @BindView(R.id.img_wallpaper)
    AppCompatImageView imgWallpaper;
    @BindView(R.id.btn_setWallPaper)
    AppCompatButton btnSetWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_detail);
        ButterKnife.bind(this);
        bundle=getIntent().getExtras();
        wallpaper=bundle.getParcelable("wallpaper");

        if (wallpaper!=null){

            Picasso.with(getApplicationContext()).load(wallpaper.getMp3ThumbnailB()).into(imgWallpaper);
            Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG);
            Log.e("","");

        }
        else if(wallpaperr!=null){
            Picasso.with(getApplicationContext()).load(wallpaperr).into(imgWallpaper);
            Toast.makeText(getApplicationContext(),"ok wallpaper",Toast.LENGTH_LONG);
            Log.e("wallpaperr","wallpaperr");


        }
        else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG);
            Log.e("","");
            Toast.makeText(getApplicationContext(),"sorry",Toast.LENGTH_LONG);


        }
        btnSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dexter.withActivity(WallpaperDetailActivity.this).withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                Log.e("","");
                                
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                Log.e("","");

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                Log.e("","");

                            }
                        }).check();









            }
        });

    }

}
