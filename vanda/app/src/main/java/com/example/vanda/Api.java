package com.example.vanda;



import com.example.vanda.models.Surname_Model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @GET("list/")
    Call<List<Surname_Model>> get_surnames();

//    @GET()





}
