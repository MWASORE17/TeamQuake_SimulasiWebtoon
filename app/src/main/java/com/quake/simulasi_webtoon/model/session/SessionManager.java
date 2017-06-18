package com.quake.simulasi_webtoon.model.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.quake.simulasi_webtoon.model.entity.User;

/**
 * Created by edwin on 08/05/17.
 */

public class SessionManager {
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    private ImageView profilPic;
    private final int PRIVATEMODE = 0;
    private static Bitmap BMP;
    private Context context;

    /*
    * TO-DO
    * define the static shared preferences object
    * the object will be used to save data
    * also the id to call the data
    */
    public static final String USER_SESSION = "usersession";
    public static final String IS_USER_LOGIN = "isuserlogin";
    public static final String USER_DATA = "userdata";

    private SessionManager(Context context) {
        this.context = context;
        this.sharedpreferences = context.getSharedPreferences(USER_SESSION, this.PRIVATEMODE);
        this.editor = this.sharedpreferences.edit();
    }

    public static SessionManager with(Context context) {
        return new SessionManager(context);
    }

    /*
    * TO-DO
    * save the user data to let the system recognize the logged-in user
    * @param: User
    */
    public void createsession(User user) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(USER_DATA, new Gson().toJson(user));
        editor.commit();
    }

    /*
    * @return: boolean
    * checking if user logged-in
    */
    public boolean isuserlogin() {
        return sharedpreferences.getBoolean(IS_USER_LOGIN, false);
    }

    /*
    * @return: User
    * return the object of User
    */
    public User getuserloggedin() {
        return new Gson().fromJson(sharedpreferences.getString(USER_DATA, ""), User.class);
    }

    /*
    * TO-DO
    * clear the shared preferences from the user data
    */
    public void clearsession() {
        editor.clear();
        editor.commit();
    }

    public static Bitmap setPic(Bitmap BM){
        BMP = BM;
        return BMP;
    }
    public static Bitmap getPic(){
        return BMP;
    }
    public static void clearPic(){
        BMP = null;
    }

}
