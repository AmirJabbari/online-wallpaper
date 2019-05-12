package com.navin.wallpaper.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.navin.wallpaper.Activity.GetWallpaperByCatActivity;
import com.navin.wallpaper.R;

import java.util.ArrayList;

public class slider implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    ArrayList urlPick,names;
    Context context;

    public void slider(Context context, SliderLayout sliderShow){
        this.context=context;
        urlPick = new ArrayList();
        names = new ArrayList();
        names.add("Amine");
        names.add("fantasy");
        urlPick.add("http://androidframework.com/apps/wallpaper/slider/slider1.jpg");
        urlPick.add("http://androidframework.com/apps/wallpaper/slider/fantasy.jpg");

        for (int i =0;i<urlPick.size();i++) {
            TextSliderView textSliderView = new TextSliderView(context);
            textSliderView.image((String) urlPick.get(i)).setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", (String) names.get(i));
            textSliderView.description((String) names.get(i));
            sliderShow.addSlider(textSliderView);

        }

    }



    @Override
    public void onSliderClick(BaseSliderView slider) {
        switch (slider.getBundle().getString("extra")){
            case "Amine":
                Intent intent=new Intent(context, GetWallpaperByCatActivity.class);
                intent.putExtra("category","8");
                context.startActivity(intent);
                break;
            case "fantasy":
                Intent intent_new=new Intent(context, GetWallpaperByCatActivity.class);
                intent_new.putExtra("category","3");
                context.startActivity(intent_new);
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
