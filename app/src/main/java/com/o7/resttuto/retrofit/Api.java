package com.o7.resttuto.retrofit;

import com.o7.resttuto.pojomodel.LoginResponse;
import com.o7.resttuto.pojomodel.RegResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<RegResponse> register(@FieldMap HashMap<String,String> map);

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@FieldMap HashMap<String,String> map);
}
