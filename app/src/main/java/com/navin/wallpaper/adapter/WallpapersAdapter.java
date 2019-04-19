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

public class WallpapersAdapter extends RecyclerView.Adapter<WallpapersAdapter.ViewHolder> {

    List<Wallpaper> wallpaperList = new ArrayList<>();
    Context context;
    public WallpapersAdapter(Context context, List<Wallpaper> wallpapers){
        wallpaperList=wallpapers;
        this.context=context;



    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_wallpaper,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Wallpaper wallpaper =wallpaperList.get(i);
     //   viewHolder.textView.setText(wallpaper.getMp3Title());
        Picasso.with(context).load(wallpaper.getMp3ThumbnailB()).into(viewHolder.imageView);
        viewHolder.textView.setText((wallpaper.getCategoryName()));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wallpaper wallpaper =wallpaperList.get(i);
                Intent intent = new Intent(context, WallpaperDetailActivity.class);
                intent.putExtra("wallpaper",wallpaper);
                context.startActivity(intent);



            }
        });



    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatImageView imageView;
        AppCompatTextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_wallpaper);
            textView=itemView.findViewById(R.id.txt_category);
            cardView=itemView.findViewById(R.id.card);
        }
    }
}
