package com.example.mysejahtera;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.nav_notification:
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.nav_scan_qr:
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.nav_statistic:
                    selectedFragment = new DashboardFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();

            return true;
        }
    };
//    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
//            BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                    int id = menuItem.getItemId();
//
//                    if (id == R.id.nav_home){
//                        DashboardFragment fragment = new DashboardFragment();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container,fragment);
//                        fragmentTransaction.commit();
//                    }
//
//                    if (id == R.id.nav_notification){
//                        DashboardFragment fragment = new DashboardFragment();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container,fragment);
//                        fragmentTransaction.commit();
//                    }
//
//                    if (id == R.id.nav_scan_qr){
//                        DashboardFragment fragment = new DashboardFragment();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container,fragment);
//                        fragmentTransaction.commit();
//                    }
//
//                    if (id == R.id.nav_statistic){
//                        DashboardFragment fragment = new DashboardFragment();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container,fragment);
//                        fragmentTransaction.commit();
//                    }
//
//                    if (id == R.id.nav_profile){
//                        DashboardFragment fragment = new DashboardFragment();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container,fragment);
//                        fragmentTransaction.commit();
//                    }
//                    return true;
//                }
//            };
}
