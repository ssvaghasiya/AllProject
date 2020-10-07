package com.example.example.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView dataList;
    List<String> titles;
    Adapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        dataList = root.findViewById(R.id.savan);
        titles = new ArrayList<>();

        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");
        titles.add("ગેલેરી");
        titles.add("ગામ ના સભ્યો");
        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");

        adapter = new Adapter(getContext(),titles);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        return root;
    }
}
