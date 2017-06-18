package com.quake.simulasi_webtoon.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.quake.simulasi_webtoon.model.entity.ComicCategory;
import com.quake.simulasi_webtoon.view.fragment.FragmentCategoryItem;

import java.util.ArrayList;

/**
 * Created by Felix on 5/13/2017.
 */

public class CategoryVPFragmentAdapter extends FragmentPagerAdapter{

    public CategoryVPFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return ComicCategory.category_data.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return FragmentCategoryItem.newInstance(ComicCategory.category_data.get(position).getId());
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return ComicCategory.category_data.get(position).getTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
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
