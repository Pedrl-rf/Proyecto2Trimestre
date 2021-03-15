package com.example.proyecto2trimestre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyecto2trimestre.fragments.BlogFragment;
import com.example.proyecto2trimestre.fragments.ContactFragment;
import com.example.proyecto2trimestre.fragments.GalleryFragment;
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
                fragment = new BlogFragment();
                break;
            case R.id.contact:
                //title = getString(R.string.title_main);
                fragment = new ContactFragment();
                break;
            case R.id.gallery:
                        //title = getString(R.string.title_notifications);
                fragment = new GalleryFragment();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        //setTitle(title);
    }
}