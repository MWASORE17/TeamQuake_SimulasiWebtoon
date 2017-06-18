package com.quake.simulasi_webtoon.view.fragment;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.entity.Daily;
import com.quake.simulasi_webtoon.view.activity.ListEpisode;
import com.quake.simulasi_webtoon.view.adapter.DailyRVAdapter;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by edwin on 14/05/17.
 */

public class FragmentDailyGrid extends Fragment {
    private RecyclerView mRecyclerView;
    private DailyRVAdapter adapterRV;
//    private int comic_release_day;
//    private String fragment_title;
    private Daily fragment_title;

    public FragmentDailyGrid() {

    }

    public static FragmentDailyGrid newInstance(Daily daily) {

        Bundle args = new Bundle();
        args.putSerializable("fragment_title", daily);

        FragmentDailyGrid fragmentDailyGrid = new FragmentDailyGrid();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
        fragmentDailyGrid.setArguments(args);

        return fragmentDailyGrid;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragment_title = (Daily) getArguments().getSerializable("fragment_title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_daily_grid, container, false);
//        fragment_title = getArguments().getString("someTitle");

//        Animator spruceAnimator = new Spruce
//                .SpruceBuilder(container)
//                .sortWith(new DefaultSort(50L))
//                .animateWith(new Animator[] {DefaultAnimations.spinAnimator(container, 800)})
//                .start();

        ArrayList<Comic> tempComics = new ArrayList<Comic>();
        for(int i = 0 ; i < Comic.comic_data.size(); i++){

            if (Comic.comic_data.get(i).getComic_release_day().equals(fragment_title)) {
                tempComics.add(Comic.comic_data.get(i));
            }

//            if((Comic.comic_data.get(i).getComic_release_day() == 1 ) && (fragment_title.equals("SEN"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 2 ) && (fragment_title.equals("SEL"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 3 ) && (fragment_title.equals("RAB"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 4 ) && (fragment_title.equals("KAM"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 5 ) && (fragment_title.equals("JUM"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 6 ) && (fragment_title.equals("SAB"))){
//                tempComics.add(Comic.comic_data.get(i));
//            } else if((Comic.comic_data.get(i).getComic_release_day() == 7 ) && (fragment_title.equals("MIN"))){
//                tempComics.add(Comic.comic_data.get(i));
//            }
        }

        adapterRV = new DailyRVAdapter(tempComics, getContext());
        mRecyclerView = (RecyclerView) _view.findViewById(R.id.daily_rv);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

//        adapterRV.setComics(Comic.comic_data);
        mRecyclerView.setAdapter(adapterRV);

        // set click listener below
//        mRecyclerView.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Intent i = new Intent(getActivity(), ListEpisode.class);
//                i.putExtra("comic_title", Comic.comic_data.get(position).getTitle());
//                startActivity(i);
//            }
//        });

        return _view;
    }
}
