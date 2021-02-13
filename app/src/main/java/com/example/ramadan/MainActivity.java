package com.example.ramadan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private ActivityMainBinding binding;
    Home homeFragment;
    Toolbar toolbarr;
    TextView toolbarTitle;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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