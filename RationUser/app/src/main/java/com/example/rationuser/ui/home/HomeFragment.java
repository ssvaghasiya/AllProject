package com.example.rationuser.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rationuser.R;
import com.example.rationuser.check.CheckOut;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView dataList;
    LinearLayout linearLayout,linearLayout1;
    ArrayList<Model> al;
    AdapterForHome adapter;
    Button checkOut;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        checkOut = root.findViewById(R.id.checkout);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(), CheckOut.class);
                startActivity(i);
            }
        });

        dataList = root.findViewById(R.id.recyclerforhome);
        al = new ArrayList<>();
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));
        al.add(new Model("rice",33,20,3.5f));



        adapter = new AdapterForHome(getContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);


        return root;
    }
}
