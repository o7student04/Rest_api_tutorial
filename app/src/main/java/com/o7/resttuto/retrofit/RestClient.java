package com.o7.resttuto.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static Api api;

    public static Api getApi() {
        if(api==null)
        {
            Gson gson=new GsonBuilder().setLenient().create();

            OkHttpClient client=new OkHttpClient();

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(Config.getCONN())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client.newBuilder().build())
                    .build();
            api=retrofit.create(Api.class);
        }
        return api;
    }
}
