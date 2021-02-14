package com.example.ramadan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("get_data.php")
    Call<List<Model_Data>> getData();

}
