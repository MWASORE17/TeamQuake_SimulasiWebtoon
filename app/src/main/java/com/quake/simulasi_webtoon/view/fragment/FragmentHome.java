package com.quake.simulasi_webtoon.view.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.view.adapter.ListComicRVAdapter;

import java.io.Serializable;

/**
 * Created by Felix on 3/26/2017.
 */

public class FragmentHome extends Fragment{
    private ListComicRVAdapter adapterComic;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_home, container, false);

        adapterComic = new ListComicRVAdapter(Comic.comic_data, ListComicRVAdapter.COMIC_LINEAR, getContext());
        recyclerView = (RecyclerView) _view.findViewById(R.id.comic_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterComic);

        return _view;
    }
}
