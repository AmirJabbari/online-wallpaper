package com.navin.wallpaper.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.navin.wallpaper.R;
import com.navin.wallpaper.adapter.WallpaperByCatAdapter;
import com.navin.wallpaper.model.Category;
import com.navin.wallpaper.model.IMessageListener;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.webService.WebServiceCaller;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetWallpaperByCatActivity extends AppCompatActivity {

    Bundle bundle;
    Wallpaper wallpaper;
    String category;
    WebServiceCaller webServiceCaller;
    @BindView(R.id.recycler_wallpaper)
    RecyclerView recyclerView;
    WallpaperByCatAdapter wallpaperByCatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wallpaper_by_cat);
        ButterKnife.bind(this);
        webServiceCaller=new WebServiceCaller(getApplicationContext());
      //  wallpaper=bundle.getParcelable("wallpaper");
        bundle=getIntent().getExtras();
        category=bundle.getString("category");
        if (category!=null){

          getAllWallpaper();
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();


    }




    public void getAllWallpaper(){

        try {
            webServiceCaller.getWallpaperBYCat(new IMessageListener() {
                @Override
                public void onSuccess(List<Wallpaper> wallpaperList) {
                 //   Toast.makeText(getApplicationContext(),category,Toast.LENGTH_LONG).show();
                    wallpaperByCatAdapter=new WallpaperByCatAdapter(getApplicationContext(),wallpaperList);
                    recyclerView.setAdapter(wallpaperByCatAdapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    Log.e("","");
                }

                @Override
                public void onError(String errorResponse) {
                    Log.e("","");

                }
            },category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
