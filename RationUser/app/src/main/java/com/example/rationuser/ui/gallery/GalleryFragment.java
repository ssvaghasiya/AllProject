package com.example.rationuser.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rationuser.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RatingBar r1,r2,r3,r4;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        r1=root.findViewById(R.id.rating_1);
        r2=root.findViewById(R.id.rating_2);
        r3=root.findViewById(R.id.rating_3);
        r4=root.findViewById(R.id.rating_4);
        Button btn=root.findViewById(R.id.rating_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                float res=r1.getRating()+r2.getRating()+r3.getRating()+r4.getRating();
//                res/=4;
//
//                Call<ResponseBody> call=RetrofitClient.getInstance().getApi().update_rating(1,res);
//                call.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        Toast.makeText(getApplicationContext(),"Jay Baljai",Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
//                    }
//                });

                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG).show();
            }
        });


        return root;
    }
}
