package com.quake.simulasi_webtoon.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.ComicComment;
import com.quake.simulasi_webtoon.model.entity.User;
import com.quake.simulasi_webtoon.model.session.SessionManager;
import com.quake.simulasi_webtoon.view.adapter.CommentRVAdapter;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ListComment extends AppCompatActivity {
    private CommentRVAdapter commentRVAdapter;
    private RecyclerView commentRV;
    private ImageView sendComment;
    private EditText inputComment;


    public ListComment() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);

        final String userId = SessionManager.with(getApplicationContext()).getuserloggedin().getId();

        Intent intent = getIntent();
        final String comic_episode_id = intent.getStringExtra("comic_episode_id");

        ArrayList<ComicComment> tempComment = new ArrayList<>();

        final ArrayList<ComicComment> comicComments = ComicComment.getCommentByEpisode(comic_episode_id);
        for(ComicComment i: comicComments){
            if(i.getParent_id().equals("0")){
                tempComment.add(i);
                for(ComicComment j: comicComments){
                    if(i.getId().equals(j.getParent_id())){
                        tempComment.add(j);
                    }
                }
                tempComment.add(new ComicComment(i.getId()));
            }
        }

        Toolbar t_up = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t_up);
        getSupportActionBar().setTitle("Komentar (" + comicComments.size() + ")");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        commentRVAdapter = new CommentRVAdapter(CommentRVAdapter.MORE_COMMENTS, this, comic_episode_id, userId);
        commentRV = (RecyclerView) findViewById(R.id.list_comment);
        commentRV.setLayoutManager(new LinearLayoutManager(this));
        commentRVAdapter.setComments(tempComment);
        commentRVAdapter.hideAllComment();
        commentRV.setHasFixedSize(true);
        commentRV.setAdapter(commentRVAdapter);


        inputComment = (EditText) findViewById(R.id.input_comment);
        inputComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(inputComment.getText().length() == 0){
                    sendComment.setBackgroundColor(Color.parseColor("#bdbaba"));
                }
                else{
                    sendComment.setBackgroundColor(Color.parseColor("#f0ebeb"));
                }
            }
        });
        sendComment = (ImageView) findViewById(R.id.send_comment);
        sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (inputComment.getText().toString().trim().length() > 0) {
                    ComicComment newComment = new ComicComment("0", comic_episode_id, inputComment.getText().toString() , userId ,new GregorianCalendar(), new ArrayList<String>());
                    ComicComment.InsertCommentToEpisode(newComment);
                    ((ListComment) view.getContext()).commentRVAdapter.addData(newComment);
                }

                inputComment.setText("");
                getSupportActionBar().setTitle("Komentar (" + commentRVAdapter.getItemCountIdNotNull() + ")");
                view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
