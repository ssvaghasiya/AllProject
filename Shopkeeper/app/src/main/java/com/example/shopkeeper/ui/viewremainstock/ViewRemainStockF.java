package com.example.shopkeeper.ui.viewremainstock;

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
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;

import java.util.ArrayList;

public class ViewRemainStockF extends Fragment {
    RecyclerView dataList;
    ArrayList<ModelForViewRemain> al;
    AdapterForViewRemain adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.viewremainstock_fragment, container, false);

        dataList = root.findViewById(R.id.recyclerforviewremainstock);
        al = new ArrayList<>();
        al.add(new ModelForViewRemain("Rise",1,44.5f));

        adapter = new AdapterForViewRemain(getContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
        return root;

    }
}
