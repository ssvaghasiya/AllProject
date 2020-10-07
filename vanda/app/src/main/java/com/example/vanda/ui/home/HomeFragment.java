package com.example.vanda.ui.home;

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

import com.example.vanda.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView dataList;
    ArrayList<String> titles;
    ArrayList<Integer> images;

    Adapter adapter;
    TextView mtxt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        dataList = root.findViewById(R.id.dataList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("ગેલેરી");
        titles.add("ગામ ના સભ્યો");
        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");
        titles.add("ગેલેરી");
        titles.add("ગામ ના સભ્યો");
        titles.add("જાહેરાત");
        titles.add("અગત્યના નંબર");


        images.add(R.drawable.gallaryg);
        images.add(R.drawable.gallaryga);
        images.add(R.drawable.jaherat);
        images.add(R.drawable.book);
        images.add(R.drawable.gallaryg);
        images.add(R.drawable.gallaryga);
        images.add(R.drawable.jaherat);
        images.add(R.drawable.book);


        adapter = new Adapter(getContext(),titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
        return root;
    }


}
