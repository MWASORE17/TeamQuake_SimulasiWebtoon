package com.quake.simulasi_webtoon.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by edwin on 21/05/17.
 */

public class Daily implements Serializable {

    public static int _id = 1;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String day;
    private int id;

    public static ArrayList<Daily> getRelease_day() {
        return release_day;
    }

    public static void setRelease_day(ArrayList<Daily> release_day) {
        Daily.release_day = release_day;
    }

    public static ArrayList<Daily> release_day;

    public Daily () { }

    public Daily(String day) {
        this.day = day;
        this.id = _id++;

    }

    public static int get_id() {
        return _id;
    }

    public static void set_id(int _id) {
        Daily._id = _id;
    }
}
