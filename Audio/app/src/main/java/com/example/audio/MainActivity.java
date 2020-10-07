package com.example.audio;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start,pause,stop;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.button6);
        pause = (Button)findViewById(R.id.button4);
        stop = (Button)findViewById(R.id.button5);

  //      mediaPlayer = MediaPlayer.create(this,R.raw.mahi);

//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    mediaPlayer.start();
//
//            }
//        });
//
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    mediaPlayer.pause();
//
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    mediaPlayer.stop();
//
//
//            }
//        });
    }
    void playSong(View v)
    {
        if(mediaPlayer == null)
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.mahi);

        }
        mediaPlayer.start();
    }

    void pauseSong(View v)
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.pause();
        }
    }

    void stopSong(View v)
    {
        if(mediaPlayer!= null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
