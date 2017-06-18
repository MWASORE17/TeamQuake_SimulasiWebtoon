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
import com.quake.simulasi_webtoon.model.entity.ComicEpisode;
import com.quake.simulasi_webtoon.view.activity.ListEpisode;
import com.quake.simulasi_webtoon.view.activity.MainWebtoon;
import com.quake.simulasi_webtoon.view.activity.ReadComic;
import com.quake.simulasi_webtoon.view.fragment.FragmentCategoryItem;
import com.quake.simulasi_webtoon.view.fragment.FragmentSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static android.R.attr.fragment;

/**
 * Created by Felix on 5/16/2017.
 */

public class ListComicRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int COMIC_LINEAR = 1;
    public static final int COMIC_GRID = 2;
    public static final int COMIC_EPISODE_LINEAR = 3;
    public static final int COMIC_CONTENT = 4;
    public static final int COMIC_SEARCH = 5;

    public int change = 0;
    public ArrayList<Comic> tempComicData;
    public FragmentSearch fragmentSearch;

    public FragmentCategoryItem fragmentCategoryItem;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");


    private int option;
    private Context context;
    private ArrayList<Comic> comicData;
    private ArrayList<ComicEpisode> comicEpisodeData;
    private String[] comicContent;

    //COMIC
    public ListComicRVAdapter(ArrayList<Comic> comicData, int option, Context context){
        this.option = option;
        this.context = context;
        this.comicData = new ArrayList<>();
        this.comicData.addAll(comicData);
    }

    public ListComicRVAdapter(ArrayList<Comic> comicData, int option, Context context, FragmentCategoryItem fragmentCategoryItem){
        this.option = option;
        this.context = context;
        this.comicData = new ArrayList<>();
        this.comicData.addAll(comicData);
        this.fragmentCategoryItem = fragmentCategoryItem;
    }

    //COMIC EPISODE
    public ListComicRVAdapter(int option, Context context, ArrayList<ComicEpisode> comicEpisodeData){
        this.option = option;
        this.context = context;
        this.comicEpisodeData = new ArrayList<>();
        this.comicEpisodeData.addAll(comicEpisodeData);

    }

    //COMIC CONTENT
    public ListComicRVAdapter(String[] imageId, Context context, int option) {
        this.option = option;
        this.context = context;
        this.comicContent = imageId;
    }

    //COMIC SEARCH
    public ListComicRVAdapter(ArrayList<Comic> comicData, Context context, FragmentSearch fragmentSearch){
        this.option = COMIC_SEARCH;
        this.context = context;
        this.comicData = new ArrayList<>();
        this.comicData.addAll(comicData);
        this.tempComicData = new ArrayList<>();
        this.tempComicData.addAll(comicData);
        this.fragmentSearch = fragmentSearch;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view;
        if(this.option == COMIC_LINEAR || this.option == COMIC_SEARCH){
            _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comic_linear, parent, false);
            ComicLinearViewHolder vh = new ComicLinearViewHolder(_view);
            return vh;
        }
        else if(this.option == COMIC_GRID){
            _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comic_grid, parent, false);
            ComicGridViewHolder vh = new ComicGridViewHolder(_view);
            return vh;
        }
        else if(this.option == COMIC_EPISODE_LINEAR){
            _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comic_episode_linear, parent, false);
            ComicEpisodeLinearViewHolder vh = new ComicEpisodeLinearViewHolder(_view);
            return vh;
        }
        else{
            _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comic_content, parent, false);
            ComicContentViewHolder vh = new ComicContentViewHolder(_view);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(this.option == COMIC_LINEAR || this.option == COMIC_SEARCH){
            final ComicLinearViewHolder vh = (ComicLinearViewHolder) holder;
            final Comic comic = comicData.get(position);
            vh.title.setText(comic.getTitle());
            vh.category.setText(comic.getCategoryById().getTitle());
            Glide
                    .with(this.context)
                    .load(comic.getIcon()).placeholder(R.drawable.placeholderloading)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).dontAnimate()
                    .into(vh.cover);
        }
        else if(this.option == COMIC_GRID){
            final ComicGridViewHolder vh = (ComicGridViewHolder) holder;
            final Comic comic = comicData.get(position);
            vh.title.setText(comic.getTitle());
            vh.category.setText(comic.getCategoryById().getTitle());
            vh.like.setText(String.valueOf(comic.getLike()));
            Glide
                    .with(this.context)
                    .load(comic.getIcon())
                    .into(vh.cover);
        }
        else if(this.option == COMIC_EPISODE_LINEAR){
            final ComicEpisodeLinearViewHolder vh = (ComicEpisodeLinearViewHolder) holder;
            final ComicEpisode episode = comicEpisodeData.get(position);
            vh.title.setText(episode.getTitle());
            vh.date.setText(String.valueOf(sdf.format(episode.getDate().getTime())));
            vh.like.setText(String.valueOf(episode.getLikeCount()));
            Glide
                    .with(this.context)
                    .load(episode.getIcon()).placeholder(R.drawable.placeholderloading)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).dontAnimate()
                    .into(vh.cover);
        }
        else{
            final ComicContentViewHolder vh = (ComicContentViewHolder) holder;
            final String comicContent = this.comicContent[position];
            Glide
                .with(this.context)
                .load(comicContent).placeholder(R.drawable.placeholderloading)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).dontAnimate()
                .into(vh.image);
        }



    }

    @Override
    public int getItemCount() {
        if(this.option == COMIC_LINEAR){
            return comicData.size();
        }
        else if(this.option == COMIC_GRID){
            return comicData.size();
        }
        else if(this.option == COMIC_EPISODE_LINEAR){
            return comicEpisodeData.size();
        }
        else if(this.option == COMIC_CONTENT){
            return comicContent.length;
        }
        else{
            if(change == 0){
                return 0;
            }
            else if(comicData.size() == 0){
                fragmentSearch.showNotFound();
                return 0;
            }
            fragmentSearch.hideNotFound();
            return comicData.size();
        }
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        comicData.clear();
        if (charText.length() == 0) {
            change = 0;
        } else {
            change = 1;
            for (Comic wp : tempComicData) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    comicData.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ComicLinearViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title, category;
        private ImageView cover;

        public ComicLinearViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.comic_title);
            category = (TextView) itemView.findViewById(R.id.comic_category);
            cover = (ImageView) itemView.findViewById(R.id.comic_cover);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent( view.getContext().getApplicationContext(), ListEpisode.class);
            i.putExtra("comic_id", comicData.get(getAdapterPosition()).getId());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            view.getContext().getApplicationContext().startActivity(i);
        }
    }

    private class ComicGridViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title, category, like;
        private ImageView cover;

        public ComicGridViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.comic_title);
            category = (TextView) itemView.findViewById(R.id.comic_category);
            cover = (ImageView) itemView.findViewById(R.id.comic_cover);
            like = (TextView) itemView.findViewById(R.id.comic_like);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent( view.getContext().getApplicationContext(), ListEpisode.class);
            i.putExtra("comic_id", comicData.get(getAdapterPosition()).getId());
            i.putExtra("tipe_result", "comic_grid");
            /*i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );*/
            fragmentCategoryItem.startActivityForResult(i, 1);
        }
    }

    private class ComicEpisodeLinearViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title, date, like;
        private ImageView cover;

        public ComicEpisodeLinearViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.comic_title);
            date = (TextView) itemView.findViewById(R.id.comic_date);
            cover = (ImageView) itemView.findViewById(R.id.comic_cover);
            like = (TextView) itemView.findViewById(R.id.comic_like);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext() , ReadComic.class);
            i.putExtra("comic_episode_id" , comicEpisodeData.get(getAdapterPosition()).getId());
            i.putExtra("posisi", getAdapterPosition());
            ((ListEpisode) view.getContext()).startActivityForResult(i, 1);
        }
    }

    public void updateEpsideAdapter(String comic_episode_id){
        for(int i = 0; i< comicEpisodeData.size(); i++){
            if(comicEpisodeData.get(i).getId().equals(comic_episode_id)){
                notifyItemChanged(i);
                return;
            }
        }
    }

    private class ComicContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ComicContentViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.comic_content);

        }

    }


}