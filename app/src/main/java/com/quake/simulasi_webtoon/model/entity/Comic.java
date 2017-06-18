package com.quake.simulasi_webtoon.model.entity;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Felix on 5/9/2017.
 */

public class Comic implements Serializable {
    public static ArrayList<Comic> comic_data;

    private String id;
    private String icon;
    private String author;
    private String title;
    private String description;
    private String comic_category_id;
    private String web_url;
    private String background;

    private Daily comic_release_day; // comic_release_day isinya integer dari 1-7 menandakan hari rilis eps barunya dari Senin-Minggu

    public static int _id = 1;


    public Comic(){

    }

    public Comic(String icon, String author, String title , String description, String category_id, Daily comic_release_day, String web_url, String background) {
        super();

        this.icon = icon;
        this.author = author;
        this.title = title;
        this.description = description;
        this.comic_category_id = category_id;
        this.comic_release_day = comic_release_day;
        this.web_url = web_url;
        this.background = background;
        this.id = "CMC" + _id;

        _id++;
    }

    public String getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComic_category_id() {
        return comic_category_id;
    }

    public Daily getComic_release_day() {
        return comic_release_day;
    }

    public void setComic_release_day(Daily comic_release_day) {
        this.comic_release_day = comic_release_day;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public static Comic getComicById(String id){
        for(Comic i: comic_data){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public int getLike(){
        int hasil = 0;
        for(ComicLike i: ComicLike.like_data){
            if(i.getComic_id().equals(this.id)){
                hasil++;
            }
        }
        return hasil;
    }

    public ComicCategory getCategoryById(){
        for(ComicCategory i: ComicCategory.category_data){
            if(i.getId().equals(this.comic_category_id)){
                return i;
            }
        }
        return null;
    }

    public static ArrayList<Comic> getComicByCategoryId(String comic_category_id){
        ArrayList<Comic> temp = new ArrayList<>();
        for(Comic i: comic_data){
            if(i.getComic_category_id().equals(comic_category_id)){
                temp.add(i);
            }
        }
        return temp;
    }

    public static int getLikeByComic(String comic_id){
        int hasil = 0;
        for(ComicEpisode i: ComicEpisode.comic_episode_data){
            if(i.getComic_id().equals(comic_id)){
                hasil += i.getLikeCount();
            }
        }
        return hasil;
    }

    @Override
    public String toString() {
        return "Ini Comic : " + title;
    }


}
