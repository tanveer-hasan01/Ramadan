package com.example.ramadan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ramadan.databinding.ActivityListBinding;
import com.example.ramadan.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class List extends AppCompatActivity {

    AdapterData adapterData;
    ArrayList<Model_Data>data;
    private ActivityListBinding binding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data=new ArrayList<>();

        adapterData = new AdapterData(data,List.this);
        binding.list.setLayoutManager(new GridLayoutManager(List.this,1));

        Retrofit instance = ApiClient.instance();
        apiInterface = instance.create(ApiInterface.class);


        apiInterface.getData().enqueue(new Callback<java.util.List<Model_Data>>() {
            @Override
            public void onResponse(Call<java.util.List<Model_Data>> call, Response<java.util.List<Model_Data>> response) {

                data.addAll(response.body());
                binding.list.setAdapter(adapterData);
                adapterData.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<java.util.List<Model_Data>> call, Throwable t) {

                Toast.makeText(List.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });





    }
}