package com.navin.wallpaper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.wallpaper.R;
import com.navin.wallpaper.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<Category> categoriesList=new ArrayList<>();
    Context context;

    public CategoriesAdapter(Context context, List<Category> categories){
        this.context=context;
        categoriesList=categories;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Category categories=categoriesList.get(i);
        viewHolder.textView.setText(categories.getCategoryName());
        Picasso.with(context).load(categories.getCategoryImage()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        AppCompatImageView imageView;
        AppCompatTextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_category);
            textView=itemView.findViewById(R.id.txt_title);
        }
    }
}
