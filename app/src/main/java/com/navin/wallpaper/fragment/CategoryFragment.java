package com.navin.wallpaper.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.wallpaper.Activity.GetWallpaperByCatActivity;
import com.navin.wallpaper.R;
import com.navin.wallpaper.adapter.CategoriesAdapter;
import com.navin.wallpaper.model.Category;
import com.navin.wallpaper.model.IMessageCategoryListener;
import com.navin.wallpaper.webService.WebServiceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.recycler_category)
    RecyclerView recyclerViewCategory;
    WebServiceCaller webServiceCaller=new WebServiceCaller(getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        getCategories();

        return view;    }


        public void getCategories(){
            try {
                webServiceCaller.getCategories(new IMessageCategoryListener() {
                    @Override
                    public void onSuccess(List<Category> responseCategory) {
                        CategoriesAdapter categoriesAdapter=new CategoriesAdapter(getActivity(),responseCategory);
                        recyclerViewCategory.setAdapter(categoriesAdapter);
                        recyclerViewCategory.setLayoutManager(new GridLayoutManager(getActivity(),2));



                    }

                    @Override
                    public void onError(String Error) {

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}
