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
import com.navin.wallpaper.model.Wallpaper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllWallpaperAdapter extends RecyclerView.Adapter<AllWallpaperAdapter.ViewHolder> {

    Context context;
    List<Wallpaper> wallpaperList=new ArrayList<>();


    public AllWallpaperAdapter(Context context, List<Wallpaper> wallpapers){
        this.context = context;
        wallpaperList=wallpapers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_wallpaper,null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Wallpaper wallpaper =wallpaperList.get(i);
           viewHolder.textView.setText(wallpaper.getCategoryName());
        Picasso.with(context).load(wallpaper.getMp3ThumbnailB()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        AppCompatTextView textView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.img_wallpaper);
            textView=itemView.findViewById(R.id.txt_category);
        }
    }
}
