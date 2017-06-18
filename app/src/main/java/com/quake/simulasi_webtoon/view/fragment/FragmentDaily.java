package com.quake.simulasi_webtoon.view.fragment;

import android.animation.Animator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;

import com.quake.simulasi_webtoon.view.adapter.DailyVPFragmentAdapter;
import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;
import com.willowtreeapps.spruce.sort.LinearSort;

/**
 * Created by Felix on 3/26/2017.
 */

public class FragmentDaily extends Fragment {

    private ViewPager mViewPager;
    private DailyVPFragmentAdapter adapterVP;
    private TabLayout tabLayout;
//    private RecyclerView mRecyclerView;
//    private SchRVAdapter adapterRV;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_daily, container, false);

//        Animator spruceAnimator = new Spruce
//                .SpruceBuilder(container)
//                .sortWith(new DefaultSort(50L))
//                .animateWith(new Animator[] {DefaultAnimations.spinAnimator(container, 800)})
//                .start();

        mViewPager = (ViewPager) _view.findViewById(R.id.daily_viewPager);
        adapterVP = new DailyVPFragmentAdapter(getChildFragmentManager());
//        adapterVP.addfragment(new FragmentDailyGrid(), "SEN");
//        adapterVP.addfragment(new FragmentDailyGrid(), "SEL");
//        adapterVP.addfragment(new FragmentDailyGrid(), "RAB");
//        adapterVP.addfragment(new FragmentDailyGrid(), "KAM");
//        adapterVP.addfragment(new FragmentDailyGrid(), "JUM");
//        adapterVP.addfragment(new FragmentDailyGrid(), "SAB");
//        adapterVP.addfragment(new FragmentDailyGrid(), "MIN");

        tabLayout = (TabLayout) _view.findViewById(R.id.daily_tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapterVP);

        return _view;
    }

}
