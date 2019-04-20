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
import android.widget.Toast;

import com.navin.wallpaper.Activity.GetWallpaperByCatActivity;
import com.navin.wallpaper.Activity.WallpaperDetailActivity;
import com.navin.wallpaper.R;
import com.navin.wallpaper.model.Category;
import com.navin.wallpaper.model.Wallpaper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<Category> categoriesList=new ArrayList<>();
    Context context;
    List<Wallpaper> wallpaperList=new ArrayList<>();

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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final Category categories=categoriesList.get(i);
        viewHolder.textView.setText(categories.getCategoryName());
        Picasso.with(context).load(categories.getCategoryImage()).into(viewHolder.imageView);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category=categoriesList.get(i);
                Intent intent=new Intent(context, GetWallpaperByCatActivity.class);
                intent.putExtra("category",category.getCid());
                //Toast.makeText(context,category.getCid().toString(),Toast.LENGTH_LONG).show();
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        AppCompatImageView imageView;
        AppCompatTextView textView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_category);
            textView=itemView.findViewById(R.id.txt_title);
            cardView=itemView.findViewById(R.id.card);
        }
    }
}
