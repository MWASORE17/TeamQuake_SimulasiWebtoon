package com.quake.simulasi_webtoon.model.entity;

import android.util.Log;

import com.quake.simulasi_webtoon.R;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Felix on 5/9/2017.
 */

public class ComicEpisode implements Serializable{
    public static ArrayList<ComicEpisode> comic_episode_data;

    private String id;
    private String comic_id;
    private String icon;
    private String title;
    private String[] image_list;
    private GregorianCalendar date;
    private String web_url;

    public static int _id = 1;

    public ComicEpisode(){
        super();
    }

    public ComicEpisode(String comic_id, String icon, String title, String[] image_list, GregorianCalendar date, String web_url) {
        super();
        this.comic_id = comic_id;
        this.icon = icon;
        this.title = title;
        this.image_list = image_list;
        this.date = date;
        this.web_url = web_url;

        this.id = "EPS" + _id;
        _id++;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImage_list() {
        return image_list;
    }

    public void setImage_list(String[] image_list) {
        this.image_list = image_list;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComic_id() {
        return comic_id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public static ComicEpisode getEpisodeById(String id){
        for(ComicEpisode i: comic_episode_data){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public static ArrayList<ComicEpisode> getEpisodeByComicId(String comic_id){
        ArrayList<ComicEpisode> temp = new ArrayList<>();
        for(ComicEpisode i: comic_episode_data){
            if(i.getComic_id().equals(comic_id)){
                temp.add(i);
            }
        }
        return temp;
    }

    public static String[] getImageListById(String id){
        for(ComicEpisode i: comic_episode_data){
            if(i.getId().equals(id)){
                return i.getImage_list();
            }
        }
        return null;
    }

    public ComicLike getLikeByEpisode(){
        for(ComicLike i: ComicLike.like_data){
            if(i.getComic_episode_id().equals(this.id)){
                return i;
            }
        }
        return null;
    }

    public int getLikeCount(){
        int hasil = 0;
        for(ComicLike i: ComicLike.like_data){
            if(i.getComic_episode_id().equals(this.id)){
                hasil++;
            }
        }
        return hasil;
    }

    public void removeLike(){
        ComicLike.like_data.remove(getLikeByEpisode());
    }

}
