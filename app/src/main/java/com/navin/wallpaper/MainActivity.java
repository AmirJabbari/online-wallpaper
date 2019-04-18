package com.navin.wallpaper;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.navin.wallpaper.fragment.CategoryFragment;
import com.navin.wallpaper.fragment.FavoriteFragment;
import com.navin.wallpaper.fragment.HomeFragment;
import com.navin.wallpaper.fragment.WallpaperFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
   // @BindView(R.id.sliderLayout)
   // SliderLayout sliderLayout;
    @BindView(R.id.bottom_menu)
    BottomNavigationView bottomNavigationView;

//    slider slider = new slider();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
     //   slider.slider(this,sliderLayout);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mnu_home:
                        toolbar.setTitle(getResources().getString(R.string.home));
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                        break;
                    case R.id.mnu_category:
                        toolbar.setTitle(getResources().getString(R.string.category));
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CategoryFragment()).commit();
                        break;
                    case R.id.mnu_favorites:
                        toolbar.setTitle(getResources().getString(R.string.favorites));
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FavoriteFragment()).commit();
                        break;
                    case R.id.mnu_wallpaper:
                        toolbar.setTitle(getResources().getString(R.string.wallpaper));

                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new WallpaperFragment()).commit();
                        break;

                }


                return true;
            }
        });

    }
}
