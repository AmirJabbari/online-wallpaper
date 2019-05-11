package com.navin.wallpaper.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.navin.wallpaper.R;
import com.navin.wallpaper.adapter.AllWallpaperAdapter;
import com.navin.wallpaper.model.IMessageListener;
import com.navin.wallpaper.model.Wallpaper;
import com.navin.wallpaper.webService.WebServiceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WallpaperFragment extends Fragment {


    public WallpaperFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.recycler_allwallpaper)
    RecyclerView recyclerViewAllWallpaper;
    WebServiceCaller webServiceCaller;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallpaper, container, false);
        ButterKnife.bind(this,view);
        webServiceCaller=new WebServiceCaller(getContext());
        getAllWallpaper();
        return view;
    }

    public void getAllWallpaper(){

        try {
            webServiceCaller.getAllWallpaper(new IMessageListener() {
                @Override
                public void onSuccess(List<Wallpaper> response) {
                    progressBar.setVisibility(View.GONE);

                    AllWallpaperAdapter allWallpaperAdapter=new AllWallpaperAdapter(getActivity(),response);
                    recyclerViewAllWallpaper.setAdapter(allWallpaperAdapter);
                    RecyclerView.LayoutManager manager=new GridLayoutManager(getActivity(),2);
                    recyclerViewAllWallpaper.setLayoutManager(manager);


                }

                @Override
                public void onError(String errorResponse) {
                    progressBar.setVisibility(View.VISIBLE);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
