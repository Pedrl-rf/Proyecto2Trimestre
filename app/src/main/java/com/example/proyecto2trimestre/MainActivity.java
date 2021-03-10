package com.example.proyecto2trimestre;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyecto2trimestre.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mBottomNavigation = findViewById(R.id.bottomMenu);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                navigateToFragment(id);
                return true;
            }

            private void navigateToFragment(int itemId) {

                Fragment fragment;
                //String title = getString(R.string.title_home);
                switch (itemId) {
                    default:
                        fragment = new HomeFragment();
                        break;
                   /* case R.id.blog:
                        title = getString(R.string.title_main);
                        fragment = new MainFragment();
                        break;
                    case R.id.gallery:
                        title = getString(R.string.title_notifications);
                        fragment = new NotifFragment();
                        break;*/
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                //transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.commit();
                //setTitle(title);
            }
        });
    }
}