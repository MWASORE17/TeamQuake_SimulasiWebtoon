package com.quake.simulasi_webtoon.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.quake.simulasi_webtoon.R;
import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.view.adapter.ListComicRVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 3/26/2017.
 */

public class FragmentSearch extends Fragment implements SearchView.OnQueryTextListener{

    // Declare Variables
    RecyclerView list;
    ListComicRVAdapter adapter;
    SearchView editsearch;
    View includeNotFound;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_search, container, false);
        includeNotFound = (View) _view.findViewById(R.id.search_not_found);


        list = (RecyclerView) _view.findViewById(R.id.comic_search_result);


        // Pass results to ListViewAdapter Class
        adapter = new ListComicRVAdapter(Comic.comic_data, getContext(), FragmentSearch.this);
        list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        list.setHasFixedSize(true);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) _view.findViewById(R.id.comic_search);
        editsearch.setOnQueryTextListener(this);

        return _view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    public void showNotFound(){
        includeNotFound.setVisibility(View.VISIBLE);
    }

    public void hideNotFound(){
        includeNotFound.setVisibility(View.GONE);
    }
}
