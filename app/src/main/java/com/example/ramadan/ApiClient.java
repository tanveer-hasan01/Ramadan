package com.example.ramadan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    private ApiClient() {}



    public static synchronized Retrofit instance(){
        if (retrofit==null){

            retrofit = new Retrofit.Builder()

                    .baseUrl("https://developerzone01.000webhostapp.com/ramadan/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
