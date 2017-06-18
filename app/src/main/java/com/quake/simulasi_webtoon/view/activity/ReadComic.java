package com.quake.simulasi_webtoon.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.ComicComment;
import com.quake.simulasi_webtoon.model.entity.ComicEpisode;
import com.quake.simulasi_webtoon.model.entity.ComicLike;
import com.quake.simulasi_webtoon.model.session.SessionManager;
import com.quake.simulasi_webtoon.view.adapter.CommentRVAdapter;
import com.quake.simulasi_webtoon.view.adapter.ListComicRVAdapter;

import java.util.ArrayList;

public class ReadComic extends AppCompatActivity {
    private RecyclerView rv;
    private CommentRVAdapter commentRVAdapter;
    private RecyclerView commentRV;
    private ListComicRVAdapter adapterRV;
    private String comicEpisodeId;

    private Menu menuEdit;

    private TextView komentar;
    private String shareUrl;
    private boolean like;
    private boolean ubah_like;
    private String user_id;
    private String comic_id;
    private String comic_episode_id;
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_comic);



        Intent intent = getIntent();
        comicEpisodeId = intent.getStringExtra("comic_episode_id");
        ComicEpisode comicEpisode = ComicEpisode.getEpisodeById(comicEpisodeId);
        comic_id = comicEpisode.getComic_id();
        comic_episode_id = comicEpisode.getId();

        user_id = SessionManager.with(this).getuserloggedin().getId();
        shareUrl = comicEpisode.getWeb_url();
        like = ComicLike.getComicEpisodeLikeByUser(user_id, comicEpisodeId);
        ubah_like = like;


        final String namaEpisode;
        if(comicEpisode.getTitle().length() > 14){
            namaEpisode = comicEpisode.getTitle().substring(0,13) + "...";
        }
        else{
            namaEpisode = comicEpisode.getTitle();
        }

        Toolbar t_up = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t_up);
        getSupportActionBar().setTitle(namaEpisode);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        komentar = (TextView) findViewById(R.id.komentar);
        komentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadComic.this, ListComment.class);
                intent.putExtra("comic_episode_id", comicEpisodeId);
                startActivityForResult(intent, 1);
            }
        });

        adapterRV = new ListComicRVAdapter(ComicEpisode.getImageListById(comicEpisodeId), this, ListComicRVAdapter.COMIC_CONTENT);
        rv = (RecyclerView) findViewById(R.id.list_comic_image);

        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapterRV);

        ArrayList<ComicComment> temp_comment = new ArrayList<>();
        for(ComicComment i: ComicComment.getCommentByEpisode(comicEpisodeId)){
            if(i.getParent_id().equals("0")){
                temp_comment.add(i);
            }
        }

        commentRVAdapter = new CommentRVAdapter(CommentRVAdapter.COMMENTS, this, comicEpisodeId);
        commentRV = (RecyclerView) findViewById(R.id.list_comment);
        commentRV.setLayoutManager(new LinearLayoutManager(this));
        commentRVAdapter.setComments(temp_comment);
        commentRV.setAdapter(commentRVAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_read_comic, menu);
        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                if(like && menu.getItem(i).getItemId() == R.id.like_comic){
                    menu.getItem(i).setIcon(R.drawable.ic_favorite_black_24dp);
                }
            }
        }
        menuEdit = menu;
        changeMenuColor(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.like_comic:
                if(like == true){
                    item.setIcon(R.drawable.ic_favorite_border_black_24dp);
                    like = false;
                    ComicLike.InsertLike(user_id, comic_id, comic_episode_id);
                }
                else{
                    item.setIcon(R.drawable.ic_favorite_black_24dp);
                    like = true;
                    ComicLike.InsertLike(user_id, comic_id, comic_episode_id);
                }
                changeMenuColor(menuEdit);
                return true;
            case R.id.share_comic:
                Intent sendIntent = new Intent();
                sendIntent.setClassName(PACKAGE_NAME, CLASS_NAME);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Baca Sekarang!! Dijamin !! LINE WEBTOON\n" + shareUrl);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(ubah_like != like){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("comic_episode_id", comic_episode_id);
            setResult(Activity.RESULT_OK,returnIntent);
        }
        else{
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED ,returnIntent);
        }
        this.finish();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ArrayList<ComicComment> temp_comment = new ArrayList<>();
        for(ComicComment i: ComicComment.getCommentByEpisode(comicEpisodeId)){
            if(i.getParent_id().equals("0")){
                temp_comment.add(i);
            }
        }

        commentRVAdapter.setComments(temp_comment);

        commentRVAdapter.notifyDataSetChanged();
    }

}
