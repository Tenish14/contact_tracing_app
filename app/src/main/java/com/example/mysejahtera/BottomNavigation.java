package com.example.mysejahtera;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnNavigationItemReselectedListener((BottomNavigationView.OnNavigationItemReselectedListener) bottomNavigation);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    int id = menuItem.getItemId();

                    if (id == R.id.nav_home){
                        DashboardFragment fragment = new DashboardFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,fragment);
                        fragmentTransaction.commit();
                    }

                    if (id == R.id.nav_notification){
                        DashboardFragment fragment = new DashboardFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,fragment);
                        fragmentTransaction.commit();
                    }

                    if (id == R.id.nav_scan_qr){
                        DashboardFragment fragment = new DashboardFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,fragment);
                        fragmentTransaction.commit();
                    }

                    if (id == R.id.nav_statistic){
                        DashboardFragment fragment = new DashboardFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,fragment);
                        fragmentTransaction.commit();
                    }

                    if (id == R.id.nav_profile){
                        DashboardFragment fragment = new DashboardFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container,fragment);
                        fragmentTransaction.commit();
                    }
                    return true;
                }
            };
}
