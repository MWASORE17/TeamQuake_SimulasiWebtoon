package com.quake.simulasi_webtoon.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Felix on 5/12/2017.
 */

public class ComicCategory implements Serializable{
    public static ArrayList<ComicCategory> category_data;

    private String id;
    private String title;

    public static int _id = 1;

    public ComicCategory(){

    }

    public ComicCategory(String title){
        this.title = title;

        this.id = "CTG" + _id;
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

    public ComicCategory getCategoryById(String id){
        for(ComicCategory i: category_data){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

}
