package com.example.shopkeeper;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopkeeper.ui.home.Model;
import com.example.shopkeeper.ui.models.Array_Transfer;
import com.example.shopkeeper.ui.models.Order_Array;
import com.example.shopkeeper.ui.models.Otp_Model;
import com.example.shopkeeper.ui.models.Transfer_Model;

import java.util.ArrayList;

public class PopUp extends AppCompatActivity {

    Button btn;
    String mob;
    private String otp;
    EditText editText;
    ArrayList<Transfer_Model> al;
    int ration_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        editText=findViewById(R.id.editText);
        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra("bundle");
             al = (ArrayList<Transfer_Model>) bundle.getSerializable("arrayList");
              mob=getIntent().getExtras().getString("mobile_no");
              ration_id=getIntent().getExtras().getInt("ration_id");
            Toast.makeText(getApplicationContext(),al.toString()+" "+mob+" "+String.valueOf(ration_id),Toast.LENGTH_LONG).show();
            Call<Otp_Model> call=RetrofitClient.getInstance().getApi().get_test(new Array_Transfer(al,mob));
            call.enqueue(new Callback<Otp_Model>() {
                @Override
                public void onResponse(Call<Otp_Model> call, Response<Otp_Model> response) {
                    otp=response.body().getOTP();





                    Toast.makeText(getApplicationContext(),"OTP has been sent",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<Otp_Model> call, Throwable t) {

                }
            });


        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
            btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String s1=editText.getText().toString();
                    if(s1.equals(otp))
                    {

                        Call<ResponseBody> call1=RetrofitClient.getInstance().getApi().confirm_order(new Order_Array(al,ration_id,2));
                call1.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        Toast.makeText(getApplicationContext(),"Order placed successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong OTP",Toast.LENGTH_LONG).show();
                    }

            }
        });



//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }
}
