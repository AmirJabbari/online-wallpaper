package com.navin.wallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.wallpaper.Activity.WallpaperDetailActivity;
import com.navin.wallpaper.R;
import com.navin.wallpaper.model.Wallpaper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WallpaperByCatAdapter extends RecyclerView.Adapter<WallpaperByCatAdapter.ViewHolder> {


    List<Wallpaper> wallpaperList=new ArrayList<>();
    Context context;

    public WallpaperByCatAdapter(Context context,List<Wallpaper> wallpapers){
        this.context=context;
        wallpaperList=wallpapers;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_all_wallpaper,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Wallpaper wallpaper =wallpaperList.get(i);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentt = new Intent(context, WallpaperDetailActivity.class);
                intentt.putExtra("wallpaper",wallpaper);
                intentt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intentt);
            }
        });


        Picasso.with(context).load(wallpaper.getMp3ThumbnailB()).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
      //  AppCompatTextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_wallpaper);
      //      textView=itemView.findViewById(R.id.txt_category);
            cardView=itemView.findViewById(R.id.card);
        }
    }


}
