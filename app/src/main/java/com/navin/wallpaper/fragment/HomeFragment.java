package com.navin.wallpaper.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.navin.wallpaper.adapter.AlbumsAdapter;
import com.navin.wallpaper.adapter.WallpapersAdapter;
import com.navin.wallpaper.model.Album;
import com.navin.wallpaper.model.IMessageAlbumListener;
import com.navin.wallpaper.model.IMessageListener;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.utils.slider;
import com.daimajia.slider.library.SliderLayout;
import com.navin.wallpaper.R;
import com.navin.wallpaper.webService.WebServiceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.sliderLayout)
    SliderLayout sliderLayout;
    @BindView(R.id.recycler_latest)
    RecyclerView recyclerViewLatest;
    @BindView(R.id.lin_more)
    LinearLayout lin_more;
    @BindView(R.id.recycler_album)
    RecyclerView recyclerViewAlbum;
    @BindView(R.id.frm)
    FrameLayout frm;
    @BindView(R.id.rel_none)
    RelativeLayout relativeLayout;

    com.navin.wallpaper.utils.slider slider = new slider();
    WebServiceCaller webServiceCaller;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        slider.slider(getActivity(),sliderLayout);
        webServiceCaller= new WebServiceCaller(getContext());
        getLatestWallpaper();
        getAlbums();
        lin_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.frm,new WallpaperFragment()).commit();
                //frm.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.GONE);
                getActivity().setTitle(getResources().getString(R.string.wallpaper));

            }
        });
        return view;
    }

    public void getLatestWallpaper(){

        try {
            webServiceCaller.getLatestWallpaper(new IMessageListener() {
                @Override
                public void onSuccess(List<Wallpaper> response) {
                    WallpapersAdapter wallpapersAdapter = new WallpapersAdapter(getActivity(),response);

                    recyclerViewLatest.setAdapter(wallpapersAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL
                    ,false);
                    recyclerViewLatest.setLayoutManager(layoutManager);
                    Log.e("","");
                }

                @Override
                public void onError(String errorResponse) {
                    Log.e("","");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getAlbums(){

        try {
            webServiceCaller.getAlbum(new IMessageAlbumListener() {
                @Override
                public void onSuccess(List<Album> responseAlbum) {
                    AlbumsAdapter albumsAdapter=new AlbumsAdapter(getActivity(),responseAlbum);
                    recyclerViewAlbum.setAdapter(albumsAdapter);
                    LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),
                            LinearLayoutManager.HORIZONTAL,false);
                    recyclerViewAlbum.setLayoutManager(layoutManager);
                    Log.e("","");
                }

                @Override
                public void onError(String Error) {
                    Log.e("","");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
