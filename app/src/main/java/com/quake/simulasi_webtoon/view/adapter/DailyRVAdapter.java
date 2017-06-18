package com.quake.simulasi_webtoon.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.view.activity.ListEpisode;

import java.util.ArrayList;

/**
 * Created by edwin on 09/05/17.
 */

public class DailyRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    int layoutResourceId;
    private ArrayList<Comic> comics;
//    private final AdapterView.OnItemClickListener listener;

//    public List<Comic> getComics() { return comics; }
//    public void setComics(List<Comic> comics) { this.comics = comics; }

//    public DailyRVAdapter() {}
    public DailyRVAdapter(ArrayList<Comic> comics, Context context) {
        this.comics = comics;
        this.context = context;
//        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view;
        _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comic_grid, parent, false);

        return new ItemComicViewHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemComicViewHolder _holder = (ItemComicViewHolder) holder;
        final Comic _comic = this.comics.get(position);

        _holder.name.setText(_comic.getTitle());
        Glide
                .with(this.context)
                .load(_comic.getIcon()).placeholder(R.drawable.placeholderloading)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).dontAnimate()
                .into(_holder.image);
        //_holder.image.setImageResource(_comic.getIcon());
        _holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext().getApplicationContext(), ListEpisode.class);
                i.putExtra("comic_id", comics.get(_holder.getAdapterPosition()).getId());
//                i.putExtra("comic_title", Comic.comic_data.get(_holder.getAdapterPosition()).getTitle());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().getApplicationContext().startActivity(i);
            }
        });
        _holder.like.setText(String.valueOf(_comic.getLike()));
        _holder.category.setText(_comic.getCategoryById().getTitle());
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    private class ItemComicViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView category, name, like;
//        private int views;

        public ItemComicViewHolder(View itemView) {
            super(itemView);
            View mView;
            mView = itemView;
            image = (ImageView) itemView.findViewById(R.id.comic_cover);
            name = (TextView) itemView.findViewById(R.id.comic_title);
            like = (TextView) itemView.findViewById(R.id.comic_like);
            category = (TextView) itemView.findViewById(R.id.comic_category);
            /*
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener) {
                        final int position = getAdapterPosition();
                        listener.onItemClick(comics.get(position));
                    }
                }
            });
            */
//            itemView.setOnClickListener();
        }
    }
}
