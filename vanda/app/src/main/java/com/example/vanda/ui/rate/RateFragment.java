package com.example.vanda.ui.rate;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.vanda.R;
import com.example.vanda.ui.home.Adapter;

import java.util.List;

public class RateFragment extends Fragment {
    Button btn;
    RatingBar ratingBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rate, container, false);
        btn = root.findViewById(R.id.button);
        ratingBar = root.findViewById(R.id.idratingbar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Thanks For Your Submission",Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}
