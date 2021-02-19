package com.example.ramadan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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
    ArrayList<Model_Room>data;
    private ActivityListBinding binding;
    ApiInterface apiInterface;
    RoomRepository roomRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        roomRepository = new RoomRepository(List.this);
        data=new ArrayList<>();

        adapterData = new AdapterData(data,List.this);
        binding.list.setLayoutManager(new GridLayoutManager(List.this,1));

        Retrofit instance = ApiClient.instance();
        apiInterface = instance.create(ApiInterface.class);


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        //api call in backgriund
     /*   new MyTask().execute(String.valueOf(1));*/

      /*  apiInterface.getData().enqueue(new Callback<java.util.List<Model_Data>>() {
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
        });*/

        roomRepository.getAllData().observe(this, new Observer<java.util.List<Model_Room>>() {
            @Override
            public void onChanged(java.util.List<Model_Room> modelCartRooms) {

                data.clear();
                data.addAll(modelCartRooms);
                binding.list.setAdapter(adapterData);
                adapterData.notifyDataSetChanged();



                if (modelCartRooms.size() == 0){

                    Toast.makeText(List.this, "Room Database is Empty !", Toast.LENGTH_LONG).show();

                }


            }
        });



    }

     class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            apiInterface.getData().enqueue(new Callback<java.util.List<Model_Data>>() {
                @Override
                public void onResponse(Call<java.util.List<Model_Data>> call, Response<java.util.List<Model_Data>> response) {



                }

                @Override
                public void onFailure(Call<java.util.List<Model_Data>> call, Throwable t) {

                    Toast.makeText(List.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });

            return null;
        }
    }

}
