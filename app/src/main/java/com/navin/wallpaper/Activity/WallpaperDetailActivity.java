package com.navin.wallpaper.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
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
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallpaperDetailActivity extends AppCompatActivity {

    Bundle bundle;
    Wallpaper wallpaper;
    String wallpaperr;

    private InterstitialAd mInterstitialAd;


    @BindView(R.id.img_wallpaper)
    AppCompatImageView imgWallpaper;
    @BindView(R.id.btn_setWallPaper)
    AppCompatButton btnSetWallpaper;
    @BindView(R.id.btn_download)
    AppCompatButton btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_detail);
        ButterKnife.bind(this);
        bundle=getIntent().getExtras();
        wallpaper=bundle.getParcelable("wallpaper");
        MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        if (wallpaper!=null){

            Picasso.with(getApplicationContext()).load(wallpaper.getMp3ThumbnailB()).into(imgWallpaper);
            Log.e("","");
         //   Snackbar.make(findViewById(android.R.id.content),"a",Snackbar.LENGTH_LONG).show();

         /*   Picasso.with(getApplicationContext()).load(new File
                    ("/storage/emulated/0/Download/17499_2.jpg")).into(imgWallpaper)*/;
            Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG);

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

                Dexter.withActivity(WallpaperDetailActivity.this).withPermission(Manifest.permission.SET_WALLPAPER)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                Log.e("","");
                                if (mInterstitialAd.isLoaded()) {
                                    mInterstitialAd.show();
                                } else {
                                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                                }
                                setWalpaper();
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
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(WallpaperDetailActivity.this).withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                startDownload();
                                Snackbar.make(findViewById(android.R.id.content),
                                        getResources().getString(R.string.download),Snackbar.LENGTH_LONG).show();
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                Snackbar.make(findViewById(android.R.id.content),
                                        getResources().getString(R.string.denied),Snackbar.LENGTH_LONG).show();

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                            }
                        }).check();
            }
        });

    }

    private void startDownload(){

        String url= wallpaper.getMp3ThumbnailB();
        Uri uri = Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI |
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download Wallpaper");
        request.setDescription("Downloading Wallpaper please wait ....");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,uri.getLastPathSegment());
        DownloadManager downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);


    }

    private void setWalpaper(){

        File file = new File("/storage/emulated/0/Download/"+wallpaper.getMp3Title());

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());


        try {
            if (file.exists()){
                Bitmap myBitmap =  BitmapFactory.decodeFile(file.getAbsolutePath());
                wallpaperManager.setBitmap(myBitmap);
               // Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }
            else {
              //  Toast.makeText(getApplicationContext(), "failed set wallpaper", Toast.LENGTH_LONG).show();
                Snackbar.make(findViewById(android.R.id.content),getResources().getString(R.string.failed_set_wallpaper),Snackbar.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            e.printStackTrace();


        }




    }
}






