package com.example.myselfapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.myselfapp.ui.profile.ProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
public class Drawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void buka_map(View view) {
        Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.id/maps/place/Jl.+Dago+Barat+No.11e,+Dago,+Kecamatan+Coblong,+Kota+Bandung,+Jawa+Barat+40135/@-6.8756607,107.6155543,17z/data=!3m1!4b1!4m5!3m4!1s0x2e68e6e33add8e31:0xc07df9c7ab475ba1!8m2!3d-6.875666!4d107.617743"));
        startActivity(map);
    }

    public void buka_ig(View view) {
        Intent instagram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ramaalhalik/"));
        startActivity(instagram);
    }

    public void buka_fb(View view) {
        Intent blog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ramaalhalik.halik"));
        startActivity(blog);
    }

    public void buka_email(View view) {
        Intent blog = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:rama.10118007@mahasiswa.unikom.ac.id"));
        startActivity(blog);
    }

    public void buka_dialog(View view) {
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "DialogFragment");
    }

    public void buka_call(View view) {
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:081221440748"));
        if (ContextCompat.checkSelfPermission(Drawer.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Drawer.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intentCall);
        }
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.drawer, menu);
            return true;
        }

        @Override
        public boolean onSupportNavigateUp () {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    }
