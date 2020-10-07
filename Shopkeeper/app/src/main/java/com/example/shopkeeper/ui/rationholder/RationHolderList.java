package com.example.shopkeeper.ui.rationholder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.ui.viewremainstock.AdapterForViewRemain;
import com.example.shopkeeper.ui.viewremainstock.ModelForViewRemain;

import java.security.KeyStore;
import java.util.ArrayList;

public class RationHolderList extends Fragment {
    RecyclerView dataList;
    ArrayList<ModelForRationHolder> al;
    AdapterForRationHolder adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ration_hold_list, container, false);

        dataList = root.findViewById(R.id.recyclerforrationholder);
        al = new ArrayList<>();
        al.add(new ModelForRationHolder(11, "Available"));
        al.add(new ModelForRationHolder(12, "Not Available"));
        al.add(new ModelForRationHolder(13, "Available"));
        al.add(new ModelForRationHolder(14, "Not Available"));

        adapter = new AdapterForRationHolder(getContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
        return root;
    }
}
