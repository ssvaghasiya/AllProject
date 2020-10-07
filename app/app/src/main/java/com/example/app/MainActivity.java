package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    ImageButton imageButton;
    public void fade(View view)
    {
        ImageView jery;
        ImageView imageView = (ImageView)findViewById(R.id.imageView4);

        // image = (ImageView)findViewById(R.id.imageView5);

        //imageView.animate().alpha(0f).setDuration(2000);
       // image.animate().alpha(1f).setDuration(2000);
         jery = (ImageView)findViewById(R.id.imageView6);
           jery.animate().rotation(1800f).setDuration(2000);

        imageView.animate().translationXBy(1500f).setDuration(2000);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView)findViewById(R.id.imageView4);
        imageView.setTranslationX(-1500f);

        imageButton = (ImageButton)findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.animate().rotation(1800f).setDuration(2000);
            }
        });
    }
}
