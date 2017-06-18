package com.quake.simulasi_webtoon.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.entity.ComicEpisode;
import com.quake.simulasi_webtoon.view.adapter.ListComicRVAdapter;

import java.util.ArrayList;

public class ListEpisode extends AppCompatActivity {
    private LinearLayout comicContainer;
    private Toolbar toolbar;
    private String shareUrl;
    private RecyclerView list;
    private ListComicRVAdapter adapter;
    private Comic comic;

    private TextView title;
    private TextView category;
    private TextView description;
    private TextView author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_episode);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final String comicId = intent.getStringExtra("comic_id");

        comic = Comic.getComicById(comicId);
        shareUrl = comic.getWeb_url();

        init();
        event();

        comicContainer = (LinearLayout) findViewById(R.id.comic_container);
        Glide.with(this).load(comic.getBackground()).asBitmap().into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    comicContainer.setBackground(drawable);
                }
            }
        });


        final ArrayList<ComicEpisode> list_episode = ComicEpisode.getEpisodeByComicId(comicId);
        adapter = new ListComicRVAdapter(ListComicRVAdapter.COMIC_EPISODE_LINEAR, this, list_episode);
        list = (RecyclerView) findViewById(R.id.comic_list_episode);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setHasFixedSize(true);
        list.setAdapter(adapter);
    }

    public void init(){
        title = (TextView) findViewById(R.id.comic_title);
        category = (TextView) findViewById(R.id.comic_category);
        description = (TextView) findViewById(R.id.comic_description);
        author = (TextView) findViewById(R.id.comic_author);
    }

    public void event(){
        title.setText(comic.getTitle());
        category.setText(comic.getCategoryById().getTitle());
        description.setText(comic.getDescription());
        author.setText(comic.getAuthor());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_episode, menu);

        changeMenuColor(menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_comic:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Baca Sekarang!! Dijamin !! LINE WEBTOON\n" + shareUrl);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String comic_episode_id = data.getStringExtra("comic_episode_id");
                adapter.updateEpsideAdapter(comic_episode_id);
            }
        }
    }

    public void changeMenuColor(Menu menu){
        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

}

