package com.example.shopkeeper;


import com.example.shopkeeper.ui.models.Allocated;
import com.example.shopkeeper.ui.models.Array_Transfer;
import com.example.shopkeeper.ui.models.Order_Array;
import com.example.shopkeeper.ui.models.Order_Model;
import com.example.shopkeeper.ui.models.Otp_Model;
import com.example.shopkeeper.ui.models.user_Stock;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("user-allocated/")
    Call<Allocated> get_allocated(@Query("r_id")int id);

    @GET("get-curr-stock-user/")
    Call<List<user_Stock>> get_user_stock(@Query("shop_id")int id,@Query("ration_id")int ration_id);



//    @FormUrlEncoded
    @POST("test/")
    Call<Otp_Model> get_test(@Body Array_Transfer at);


    @POST("add-stock-user/")
    Call<ResponseBody> confirm_order(@Body Order_Array array);


    @GET("show-family-members/")
    Call<List<ModelForFamilyMem>> get_family(@Query("ration_id") int r_id);

    @GET("get-orders/")
    Call<List<Order_Model>> get_orders(@Query("ration_id") int r_id);



}
