package com.quake.simulasi_webtoon.view.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.session.SessionManager;
import com.quake.simulasi_webtoon.view.fragment.FragmentCategory;
import com.quake.simulasi_webtoon.view.fragment.FragmentDaily;
import com.quake.simulasi_webtoon.view.fragment.FragmentHome;
import com.quake.simulasi_webtoon.view.fragment.FragmentMore;
import com.quake.simulasi_webtoon.view.fragment.FragmentSearch;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainWebtoon extends ParentActivity {
    private BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(item.getItemId() != getSelectedItem(navigation)){
                        getSupportActionBar().setTitle("Home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentHome()).commit();
                    }
                    return true;
                case R.id.navigation_schedule:
                    if(item.getItemId() != getSelectedItem(navigation)){
                        getSupportActionBar().setTitle("Schedule");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentDaily()).commit();

                    }
                    return true;
                case R.id.navigation_search:
                    if(item.getItemId() != getSelectedItem(navigation)){
                        getSupportActionBar().setTitle("Search");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentSearch()).commit();

                    }
                    return true;
                case R.id.navigation_catg:
                    if(item.getItemId() != getSelectedItem(navigation)){
                        getSupportActionBar().setTitle("Category");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentCategory()).commit();

                    }
                    return true;
                case R.id.navigation_opt:
                    if(item.getItemId() != getSelectedItem(navigation)){
                        getSupportActionBar().setTitle("Account");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentMore()).commit();

                    }
                    return true;

            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_webtoon);

        isiDaily();
        isiUser();
        isiComicCategory();
        isiComic();
        isiComicEpisode();
        isiComicComment();
        isiLike();

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper helper = new BottomNavigationViewHelper();
        helper.disableShiftMode(navigation);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);

        /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), AuthActivity.class);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_index_container, new FragmentHome()).commit();
    }

    public class BottomNavigationViewHelper {
        public void disableShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //noinspection RestrictedApi
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    //noinspection RestrictedApi
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e);
            }
        }
    }

    private int getSelectedItem(BottomNavigationView bottomNavigationView){
        Menu menu = bottomNavigationView.getMenu();
        for (int i=0;i<bottomNavigationView.getMenu().size();i++){
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.isChecked()){
                return menuItem.getItemId();
            }
        }
        return 0;
    }
}

