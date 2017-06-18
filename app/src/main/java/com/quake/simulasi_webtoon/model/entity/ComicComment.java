package com.quake.simulasi_webtoon.model.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.R.attr.data;
import static android.R.attr.switchMinWidth;

/**
 * Created by Felix on 5/12/2017.
 */

public class ComicComment implements Serializable{
    public static ArrayList<ComicComment> comment_data;
    public static int _id = 1;

    private String id;
    private String comic_episode_id;
    private String user_id;
    private String parent_id;
    private String content;
    private GregorianCalendar date;
    private ArrayList<String> childs;

    public ComicComment(){

    }

    //Masukkan Layout input_reply
    public ComicComment(String parent_id){
        this.parent_id = parent_id;
    }

    public ComicComment(String parent_id, String comic_episode_id,String content, String user_id, GregorianCalendar date, ArrayList<String> childs) {
        this.id = "CMT" + _id;
        this.parent_id = parent_id;
        this.comic_episode_id = comic_episode_id;
        this.content = content;
        this.user_id = user_id;
        this.date = date;
        this.childs = new ArrayList<>();
        if(childs.size() > 0 ){
            this.childs.addAll(childs);
        }

        _id++;
    }

    public String getId() {
        return id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public ArrayList<String> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<String> childs) {
        this.childs.removeAll(this.childs); 
        this.childs.addAll(childs);
    }

    public String getComic_episode_id() {
        return comic_episode_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public static ArrayList<ComicComment> getCommentByEpisode(String episode_id){
        ArrayList<ComicComment> temp = new ArrayList<>();
        for(ComicComment i: comment_data){
            if(i.getComic_episode_id().equals(episode_id)){
                temp.add(i);
            }
        }

            return temp;

    }

    public User getUserByUserId(String user_id){
        for(User i: User.users){
            if(i.getId().equals(user_id)){
                return i;
            }
        }
        return null;
    }

    public static void InsertCommentToEpisodeById(String comic_episode_id, ComicComment comicComment){
        ComicComment.comment_data.add(comicComment);
    }

    public static void InsertCommentToEpisode(ComicComment comicComment){
        ComicComment.comment_data.add(comicComment);
    }

    public static void InsertChildById(String parent_id, String child_id){
        for(ComicComment i: comment_data){
            if(i.getId().equals(parent_id)){
                i.childs.add(child_id);
                break;
            }
        }
    }

    public static String time_diff(GregorianCalendar date) {
        GregorianCalendar now = new GregorianCalendar();
        long diffInSecs = (now.getTimeInMillis() - date.getTimeInMillis()) / 1000;

        String res;
        if (diffInSecs < 60) {
            res = Long.toString(diffInSecs) + " detik yang lalu";
        } else if (diffInSecs < 3600) {
            res = Long.toString(diffInSecs/60).toString() + " menit yang lalu";
        } else if (diffInSecs < 86400) {
            res = Long.toString(diffInSecs/3600).toString() + " jam yang lalu";
        } else if (diffInSecs < 2592000) {
            res = Long.toString(diffInSecs/86400).toString() + " hari yang lalu";
        } else if (diffInSecs < 31104000) {
            res = Long.toString(diffInSecs/2592000).toString() + " bulan yang lalu";
        } else {
            res = Long.toString(diffInSecs/31104000).toString() + " tahun yang lalu";
        }

        return res;
    }
}
