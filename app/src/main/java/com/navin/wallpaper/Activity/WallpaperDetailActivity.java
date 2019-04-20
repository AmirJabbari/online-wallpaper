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
        }
        btnSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {









            }
        });

    }

}
