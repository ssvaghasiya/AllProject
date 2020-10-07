package com.example.shopkeeper.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.order_his.AdapterforOrder;
import com.example.shopkeeper.order_his.ModelForOrder;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView dataList;
    ArrayList<ModelForViewStock> al;
    AdapterForViewStock adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        dataList = root.findViewById(R.id.recyclerforviewstock);
        al = new ArrayList<>();
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));
        al.add(new ModelForViewStock("rise",1,5,77.00f));

        adapter = new AdapterForViewStock(getContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
        return root;
    }
}
