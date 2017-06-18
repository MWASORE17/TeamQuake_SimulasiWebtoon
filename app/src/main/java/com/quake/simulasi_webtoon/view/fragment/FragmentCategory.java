package com.quake.simulasi_webtoon.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.entity.ComicCategory;
import com.quake.simulasi_webtoon.view.adapter.CategoryVPFragmentAdapter;

/**
 * Created by Felix on 3/26/2017.
 */

public class FragmentCategory extends Fragment {
    CategoryVPFragmentAdapter adapterVP;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_category, container, false);

        ViewPager vpPager = (ViewPager) _view.findViewById(R.id.vpPager);
        adapterVP = new CategoryVPFragmentAdapter(getChildFragmentManager());
        TabLayout tabLayout = (TabLayout) _view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vpPager);
        vpPager.setAdapter(adapterVP);

        return _view;
    }
}
