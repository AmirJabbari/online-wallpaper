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
import com.navin.wallpaper.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    Context context;
    List<Album> albumList=new ArrayList<>();

    public AlbumsAdapter(Context context,List<Album> albums){
        this.context=context;
        albumList=albums;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_album,null);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Album album=albumList.get(i);
        viewHolder.textView.setText(album.getAlbumName());
        Picasso.with(context).load(album.getAlbumImage())
                .into(viewHolder.imageView);



    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView imageView;
        AppCompatTextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_album);
            textView=itemView.findViewById(R.id.txt_title);
        }
    }
}
