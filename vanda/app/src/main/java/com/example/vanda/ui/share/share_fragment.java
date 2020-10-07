package com.example.vanda.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.R;
import com.example.vanda.ui.home.Adapter;

import java.util.ArrayList;
import java.util.List;

public class share_fragment extends Fragment {

    Button sharebtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.share_fragment, container, false);
        sharebtn = root.findViewById(R.id.sharebtn);

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Hello Dosto";
                String Subject = "Hello";
                intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share"));
            }
        });
        return root;
    }


}
