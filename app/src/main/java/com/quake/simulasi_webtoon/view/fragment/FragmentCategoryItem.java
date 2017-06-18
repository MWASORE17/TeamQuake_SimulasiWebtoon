package com.quake.simulasi_webtoon.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.view.adapter.ListComicRVAdapter;

import java.util.ArrayList;

/**
 * Created by Felix on 5/13/2017.
 */

public class FragmentCategoryItem extends Fragment {

    private ListComicRVAdapter adapterRV;
    private RecyclerView list;

    private String category_id;

    public FragmentCategoryItem() {
        // Required empty public constructor
    }

    public static FragmentCategoryItem newInstance(String comicCategoryId) {

        Bundle args = new Bundle();
        args.putString("category_id", comicCategoryId);
        FragmentCategoryItem fragment = new FragmentCategoryItem();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category_id = getArguments().getString("category_id");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_category_item, container, false);
        ArrayList<Comic> newdata= new ArrayList<>();

        newdata.addAll(Comic.getComicByCategoryId(category_id));

        adapterRV = new ListComicRVAdapter(newdata, ListComicRVAdapter.COMIC_GRID, getContext(), FragmentCategoryItem.this);
        list = (RecyclerView) _view.findViewById(R.id.comic_list);
        list.setLayoutManager(new GridLayoutManager(getContext(), 3));
        list.setAdapter(adapterRV);

        return _view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapterRV.notifyDataSetChanged();
    }
}
