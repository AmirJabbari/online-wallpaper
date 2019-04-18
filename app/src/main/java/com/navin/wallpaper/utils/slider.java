package com.navin.wallpaper.utils;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.navin.wallpaper.R;

import java.util.ArrayList;

public class slider implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    ArrayList urlPick,names;
    Context context;

    public void slider(Context context, SliderLayout sliderShow){
        this.context=context;
        urlPick = new ArrayList();
        names = new ArrayList();
        names.add("Boy");
        names.add("Girl");
        names.add("fanteasy");
        names.add("Baby");
        urlPick.add("https://homeandroid.ir/wp-content/uploads/2017/04/Android-Image-Slide.jpg");
        urlPick.add("http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        urlPick.add("https://homeandroid.ir/wp-content/uploads/2017/04/Android-Image-Slide.jpg");
        urlPick.add("https://homeandroid.ir/wp-content/uploads/2019/03/kotlin-android-cover.jpg");
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
        Toast.makeText(context,slider.getBundle().get("extra")+"",Toast.LENGTH_LONG).show();
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
