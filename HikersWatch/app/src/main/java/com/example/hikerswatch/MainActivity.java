package com.example.hikerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener listener;
    TextView lat;
    TextView lon;
    TextView Acc;
    TextView Attitude;
    TextView Address;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            startListing();
        }
    }

    public void startListing()
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    public void updateLocationInfo(Location location) {
        Log.i("placeinfo", location.toString());

        lat = (TextView) findViewById(R.id.textView);
        lon = (TextView) findViewById(R.id.textView2);
        Acc = (TextView) findViewById(R.id.textView3);
        Attitude = (TextView) findViewById(R.id.textView4);
        Address = (TextView) findViewById(R.id.textView5);

        lat.setText("Latitude : " + location.getLatitude());

        lon.setText("Longitude : " + location.getLongitude());

        Acc.setText("Accuracy : " + location.getAccuracy());

        Attitude.setText("Altitude : " + location.getAltitude());

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        try{
            String address = "Could not find Address";
            List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

            if(list != null && list.size()>0)
            {
                address = "Address : \n";

                if(list.get(0).getSubThoroughfare() != null)
                {
                    address +=list.get(0).getSubThoroughfare()+" ";
                }
                if(list.get(0).getThoroughfare() != null)
                {
                    address +=list.get(0).getThoroughfare()+"\n";
                }
                if(list.get(0).getLocality() != null)
                {
                    address +=list.get(0).getLocality()+"\n";
                }
                if(list.get(0).getPostalCode() != null)
                {
                    address +=list.get(0).getPostalCode()+"\n";
                }
                if(list.get(0).getCountryName() != null)
                {
                    address +=list.get(0).getCountryName()+"\n";
                }

            }
           Address.setText(address);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager =(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("location",location.toString());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

//        if(Build.VERSION.SDK_INT<23)
//        {
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,listener);
//        }
//        else {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,listener);

                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if(location!=null)
                {
                    updateLocationInfo(location);
                }
            }
       // }
    }
}
