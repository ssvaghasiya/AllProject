package com.example.downloadweb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
         //   Log.i("URL",strings[0]);

            String result = "";
            URL url;
            HttpURLConnection urlConnection;

            try {
                url = new URL(strings[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1)
                {
                    char dda = (char)data;
                    result += dda;
                    data = reader.read();
                }
                return  result;

            }
            catch (Exception e)
            {

            }
            return "Failed";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String res = null;
        try {
             res = task.execute("view-source:https://parivahan.gov.in/parivahan/").get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        Log.i("Result",res);


    }
}
