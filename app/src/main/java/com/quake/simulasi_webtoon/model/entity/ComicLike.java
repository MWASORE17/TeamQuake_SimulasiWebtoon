package com.quake.simulasi_webtoon.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import static android.R.attr.y;

/**
 * Created by Felix on 5/26/2017.
 */

public class ComicLike implements Serializable {
    public static ArrayList<ComicLike> like_data;
    public static int _id = 1;

    private String id;
    private String comic_id;
    private String comic_episode_id;
    private String user_id;

    public ComicLike(){

    }

    public ComicLike(String user_id, String comic_id, String comic_episode_id){
        this.comic_id = comic_id;
        this.comic_episode_id = comic_episode_id;
        this.user_id = user_id;
        this.id = "LK" + _id;
        _id++;
    }

    public String getId() {
        return id;
    }

    public String getComic_id() {
        return comic_id;
    }

    public void setComic_id(String comic_id) {
        this.comic_id = comic_id;
    }

    public String getComic_episode_id() {
        return comic_episode_id;
    }

    public void setComic_episode_id(String comic_episode_id) {
        this.comic_episode_id = comic_episode_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public static void InsertLike(String user_id, String comic_id, String comic_episode_id){
        boolean flag = false;
        for(ComicLike i: like_data){
            if(i.comic_episode_id.equals(comic_episode_id) && i.user_id.equals(user_id)){
                flag = true;
                like_data.remove(i);
                break;
            }
        }
        if(flag == false){
            like_data.add(new ComicLike(user_id, comic_id, comic_episode_id));
        }
    }

    public static int getNumberofLikeByComic(String comic_id){
        int hasil = 0;
        for(ComicLike i: like_data){
            if(i.comic_id.equals(comic_id)){
                hasil++;
            }
        }
        return hasil;
    }

    public static int getNumberofLikeByComicEpisode(String comic_episode_id){
        int hasil = 0;
        for(ComicLike i: like_data){
            if(i.comic_episode_id.equals(comic_episode_id)){
                hasil++;
            }
        }
        return hasil;
    }

    public static boolean getComicEpisodeLikeByUser(String user_id, String comic_episode_id){
        for(ComicLike i: like_data){
            if(i.user_id.equals(user_id) && i.comic_episode_id.equals(comic_episode_id)){
                return true;
            }
        }
        return false;
    }


}
