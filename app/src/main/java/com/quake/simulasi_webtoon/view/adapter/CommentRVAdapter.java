package com.quake.simulasi_webtoon.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.entity.ComicComment;
import com.quake.simulasi_webtoon.model.entity.User;
import com.quake.simulasi_webtoon.model.session.SessionManager;
import com.quake.simulasi_webtoon.view.activity.ListComment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.quake.simulasi_webtoon.R.id.comment;

/**
 * Created by Felix on 5/16/2017.
 */

public class CommentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int COMMENTS = 1;
    public static final int MORE_COMMENTS = 2;

    public static final int COMMENT_PARENT = 3;
    public static final int COMMENT_CHILD = 4;

    public static final int REPLY_PARENT = 5;
    public static final int REPLY_CHILD = 6;


    private ArrayList<ComicComment> hideComment;
    private ArrayList<ComicComment> commentData;
    private int commentSize;
    private Context context;
    private String comicEpisodeId;
    private String userId;


    public int option;

    public ArrayList<ComicComment> getComments() {
        return commentData;
    }

    public void setComments(ArrayList<ComicComment> comments) {
        this.commentData = comments;
    }

    public CommentRVAdapter(int option, Context context, String comic_episode_id) {
        this.commentData = new ArrayList<>();
        this.option = option;
        this.hideComment = new ArrayList<>();
        this.context = context;
        this.comicEpisodeId = comic_episode_id;
    }

    public CommentRVAdapter(int option, Context context, String comic_episode_id, String userId) {
        this.commentData = new ArrayList<>();
        this.option = option;
        this.hideComment = new ArrayList<>();
        this.context = context;
        this.comicEpisodeId = comic_episode_id;
        this.userId = userId;
        this.commentSize = 0;
    }

    public void hideAllComment(){
        for(ComicComment i : commentData){
            if(i.getParent_id() == null || !i.getParent_id().equals("0")){
                hideComment.add(i);
            }
        }
        commentData.removeAll(hideComment);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view;
        if(this.option == COMMENTS){
            _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment, parent, false);
            ItemUserViewHolder vh = new ItemUserViewHolder(_view, viewType);
            return vh;
        }
        else{
            if (viewType == COMMENT_PARENT) {
                _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment, parent, false);
                ItemUserViewHolder vh = new ItemUserViewHolder(_view, viewType);
                return vh;
            }
            else if(viewType == COMMENT_CHILD){
                _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comment_reply, parent, false);
                ItemUserViewHolder vh = new ItemUserViewHolder(_view, viewType);
                return vh;
            }
            else if(viewType == REPLY_PARENT){
                _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.input_reply, parent, false);
                CommentReplyViewHolder vh = new CommentReplyViewHolder(_view, viewType);
                return vh;
            }
            else{
                _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.input_reply, parent, false);
                CommentReplyViewHolder vh = new CommentReplyViewHolder(_view, viewType);
                return vh;
            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ComicComment _cmt = this.commentData.get(position);

        if(getItemViewType(position) == REPLY_PARENT || getItemViewType(position) == REPLY_CHILD){
            final CommentReplyViewHolder _holder1 = (CommentReplyViewHolder) holder;
            _holder1.bind(_cmt, getItemViewType(position), position);

        }
        else{
            final ItemUserViewHolder _holder = (ItemUserViewHolder) holder;
            _holder.bind(_cmt, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemCount() {
        if(this.option == COMMENTS){
            if(commentData.size() > 3){
                return 3;
            }
            else{
                return commentData.size();
            }
        }
        return commentData.size();
    }

    public void addData(ComicComment comicComment){
        commentData.add(comicComment);
        hideComment.add(new ComicComment(comicComment.getId()));
        notifyDataSetChanged();
    }

    public int getItemCountIdNotNull(){
        commentSize = 0;
        for(ComicComment i: commentData){
            if(i.getId() != null){
                commentSize++;
            }
        }
        if(hideComment != null){
            for(ComicComment i: hideComment){
                if(i.getId() != null){
                    commentSize++;
                }
            }
        }
        return commentSize;
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name, content, date, reply;
        private LinearLayout linearLayout;
        public ItemUserViewHolder(View itemView, int tipe) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.reply_container);
            name = (TextView) itemView.findViewById(R.id.comment_name);
            date = (TextView) itemView.findViewById(R.id.comment_date);
            content = (TextView) itemView.findViewById(comment);
            reply = (TextView) itemView.findViewById(R.id.reply);

            if(option == MORE_COMMENTS && tipe == COMMENT_PARENT){
                reply.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {
            ComicComment _cmt = commentData.get(getAdapterPosition());
            boolean flag = false;
            ArrayList<ComicComment> tempData = new ArrayList<>();
            for(ComicComment i: hideComment){
                if(_cmt.getId().equals(i.getParent_id())){
                    tempData.add(i);
                    flag = true;
                }
            }
            //Show Comment
            if(flag == true){
                hideComment.removeAll(tempData);
                commentData.addAll(getAdapterPosition()+1, tempData);
                notifyDataSetChanged();
            }
            //Hide Comment
            else{
                for(int i = getAdapterPosition()+1 ; i<commentData.size();i++){
                    if(commentData.get(i).getParent_id().equals(_cmt.getId())){
                        tempData.add(commentData.get(i));
                    }
                }
                hideComment.addAll(tempData);
                commentData.removeAll(tempData);
                notifyDataSetChanged();
            }


        }

        public void bind(final ComicComment comicComment,final int posisi,final int tipe){
            name.setText(comicComment.getUserByUserId(comicComment.getUser_id()).getName());
            content.setText(comicComment.getContent());
            date.setText(ComicComment.time_diff(comicComment.getDate()));

            if(option == MORE_COMMENTS){
                if(tipe == COMMENT_PARENT){
                    if(comicComment.getChilds().size() > 0){
                        reply.setText("Balasan(" + comicComment.getChilds().size() + ")");
                    }
                    else{
                        reply.setText("Membalas");
                    }
                }
                else{
                }
            }
            else{
                reply.setVisibility(View.GONE);
            }
        }
    }

    private class CommentReplyViewHolder extends RecyclerView.ViewHolder {
        private EditText inputComment;
        private ImageView sendComment;
        private LinearLayout linearLayout;
        public CommentReplyViewHolder(View itemView, int tipe) {
            super(itemView);
            inputComment = (EditText) itemView.findViewById(R.id.input_comment);
            sendComment = (ImageView) itemView.findViewById(R.id.send_comment);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.reply_container);
        }

        public void bind(final ComicComment comicComment,final int tipe,final int posisi){
            if(option == MORE_COMMENTS){
                if(tipe == REPLY_CHILD || tipe == REPLY_PARENT){
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
                    sendComment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int pos_data = getAdapterPosition();
                            if (inputComment.getText().toString().trim().length() > 0) {
                                ComicComment newComment = new ComicComment(comicComment.getParent_id(), comicEpisodeId, inputComment.getText().toString(), userId, new GregorianCalendar(), new ArrayList<String>());
                                for (ComicComment i : commentData) {
                                    if (i.getId().equals(comicComment.getParent_id())) {
                                        ArrayList<String> temp = new ArrayList<String>();
                                        temp.addAll(i.getChilds());
                                        i.setChilds(temp);
                                        break;
                                    }
                                }
                                commentData.add(pos_data, newComment);
                                ComicComment.InsertChildById(newComment.getParent_id(), newComment.getId());
                                ComicComment.InsertCommentToEpisode(newComment);



                                view = ((ListComment) view.getContext()).getCurrentFocus();
                                if (view != null) {
                                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                }
                                notifyDataSetChanged();
                                ((ListComment) context).getSupportActionBar().setTitle("Komentar (" + getItemCountIdNotNull() + ")");
                            }
                            inputComment.setText("");
                        }
                    });
                }
            }
        }
    }

    @Override
    public int getItemViewType(final int position) {
        if(commentData.get(position).getId() == null){
            if(commentData.get(position).getParent_id().equals("0")){
                return REPLY_PARENT;
            }
            else{
                return REPLY_CHILD;
            }
        }
        else{
            if(commentData.get(position).getParent_id().equals("0")){
                return COMMENT_PARENT;
            }
            else{
                return COMMENT_CHILD;
            }
        }
    }



}
