package com.quake.simulasi_webtoon.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.quake.simulasi_webtoon.model.entity.Daily;
import com.quake.simulasi_webtoon.view.fragment.FragmentDailyGrid;

import java.util.ArrayList;


/**
 * Created by edwin on 08/05/17.
 */

public class DailyVPFragmentAdapter extends FragmentPagerAdapter {

//    private ArrayList<Fragment> fragments = new ArrayList<>();
//    private ArrayList<String> titles = new ArrayList<>();

    public DailyVPFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return Daily.release_day.size();
    }

    @Override
    public Fragment getItem(int position) {
//        if(position >= fragments.size()){
//            return null;
//        }
//        else{
//            return fragments.get(position);
//        }
        return FragmentDailyGrid.newInstance(Daily.release_day.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Daily.release_day.get(position).getDay();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    public void addfragment(Fragment fragment, String title){
//        fragments.add(fragment);
//        titles.add(title);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }
}
