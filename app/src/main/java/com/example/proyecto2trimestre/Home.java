package com.example.proyecto2trimestre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyecto2trimestre.fragments.BlankFragment;
import com.example.proyecto2trimestre.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);



    BottomNavigationView mBottomNavigation = findViewById(R.id.bottomMenu);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                navigateToFragment(id);
                return true;
            }
        });
    }

    private void navigateToFragment(int itemId) {

        Fragment fragment;
        //String title = getString(R.string.title_home);
        switch (itemId) {
            default:
                fragment = new HomeFragment();
                break;
            case R.id.blog:
                fragment = new HomeFragment();
                break;
            case R.id.contact:
                //title = getString(R.string.title_main);
                fragment = new BlankFragment();
                break;
            case R.id.gallery:
                        //title = getString(R.string.title_notifications);
                fragment = new BlankFragment();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        //setTitle(title);
    }
}