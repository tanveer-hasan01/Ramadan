package com.example.ramadan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.room.Dao;
import androidx.room.Query;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramadan.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private ActivityMainBinding binding;
    Home homeFragment;
    Toolbar toolbarr;
    TextView toolbarTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ApiInterface apiInterface;
    RoomRepository roomRepository;
    ArrayList<Model_Data>data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        data=new ArrayList<>();

        roomRepository = new RoomRepository(MainActivity.this);
        Retrofit instance = ApiClient.instance();
        apiInterface = instance.create(ApiInterface.class);

        toolbarr=findViewById(R.id.toolbar);
        setSupportActionBar(toolbarr);

        toolbarTitle=findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(R.string.app_name);

        setSupportActionBar(binding.include.toolbar);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                binding.drawerLayout,binding.include.toolbar,R.string.open, R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));


        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        binding.navigationView.setNavigationItemSelectedListener(this);

        binding.list.setOnClickListener((View.OnClickListener) this);
        binding.tojbi.setOnClickListener((View.OnClickListener) this);
        binding.complain.setOnClickListener((View.OnClickListener) this);
        binding.app.setOnClickListener((View.OnClickListener) this);
        initFragmentHome();



        //data getFrom Database


        roomRepository.getAllData().observe(this, new Observer<java.util.List<Model_Room>>() {
            @Override
            public void onChanged(java.util.List<Model_Room> modelCartRooms) {




                //Toast.makeText(CartActivity.this, ""+arrayList.get(1).getSize(), Toast.LENGTH_SHORT).show();

                if (modelCartRooms.size()== 0){

                    getOnlineData();

                }


            }
        });











    }


    public void getOnlineData()
    {
        apiInterface.getData().enqueue(new Callback<java.util.List<Model_Data>>() {
            @Override
            public void onResponse(Call<java.util.List<Model_Data>> call, Response<java.util.List<Model_Data>> response) {

                data.addAll(response.body());

                Toast.makeText(MainActivity.this, ""+data.size(), Toast.LENGTH_LONG).show();

                final RoomRepository repository = new RoomRepository(MainActivity.this);


                for(int i=0;i<data.size();i++)
                {
                    String seheri = data.get(i).getSeheri();
                    String iftar = data.get(i).getIftar();
                    String category = data.get(i).getCategory();
                    String ramadan_sl = data.get(i).getRamadan_sl();
                    String date = data.get(i).getDate();
                    repository.insertSingleData(new Model_Room(seheri, iftar, category, ramadan_sl,date));
                }




            }

            @Override
            public void onFailure(Call<java.util.List<Model_Data>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFragmentHome(){
        homeFragment=new Home();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(binding.include.contentMain.fragmentContainer.getId(),homeFragment,"HomeFragment").commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.menu_cart,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }



    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.list:
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent=new Intent(getApplicationContext(), List.class);

                startActivity(intent);

                break;

            case R.id.tojbi:
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                 intent=new Intent(getApplicationContext(), Tojbi.class);

                startActivity(intent);

                break;

            case R.id.complain:
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                  intent=new Intent(getApplicationContext(), List.class);

                startActivity(intent);

                break;

            case R.id.app:
                Toast.makeText(this, "App", Toast.LENGTH_SHORT).show();

                break;

            default:


        }


    }

}