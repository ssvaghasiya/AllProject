package com.example.qrscanner;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.widget.Toast;
import android.view.ActionMode;
import android.view.ActionMode.Callback;


import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView ;
    //  private static int cam_id = Camera.CameraInfo.CAMERA_FACING_BACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(checkpermission())
            {
                Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }else
            {
                requestPermission();
            }
        }
    }

    private boolean checkpermission()
    {
        return (ContextCompat.checkSelfPermission(MainActivity.this,CAMERA)== PackageManager.PERMISSION_GRANTED);
    }
    private void requestPermission()
    {
        ActivityCompat.requestPermissions(this,new String[]{CAMERA},REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_CAMERA:
                if(grantResults.length>0){
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    {
                        Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                            if(shouldShowRequestPermissionRationale(CAMERA)){
                                displayAlertMessage("You need to allow access for both permission", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)

                                        {
                                            requestPermissions(new String[]{CAMERA},REQUEST_CAMERA);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }



    @Override
    public void handleResult(Result result) {
        final String scanresult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                scannerView.resumeCameraPreview(MainActivity.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanresult));
                startActivity(intent);
            }
        });
        builder.setMessage(scanresult);
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener)
    {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK",listener)
                .setNegativeButton("CANCLE",null)
                .create().show();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(checkpermission())
            {
                if(scannerView==null)
                {
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
            else {
                requestPermission();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scannerView.stopCamera();
    }

}



