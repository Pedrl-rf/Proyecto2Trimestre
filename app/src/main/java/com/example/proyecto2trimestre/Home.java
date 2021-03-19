package com.example.proyecto2trimestre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    BottomNavigationView mBottomNavigation = findViewById(R.id.bottomMenu);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                navigateToFragment(id);
                return true;
            }
        });

        mBottomNavigation.setSelectedItemId(R.id.menu_home);
    }



    private void navigateToFragment(int itemId) {

        Fragment fragment;
        //String title = getString(R.string.title_home);
        switch (itemId) {
            default:
                fragment = new HomeFragment();
                getSupportActionBar().setTitle("Home");
                break;
            case R.id.blog:
                fragment = new BlogFragment();
                getSupportActionBar().setTitle("Blog");
                break;
            case R.id.contact:
                //title = getString(R.string.title_main);
                getSupportActionBar().setTitle("Contacto");
                fragment = new ContactFragment();
                break;
            case R.id.gallery:
                        //title = getString(R.string.title_notifications);
                getSupportActionBar().setTitle("Galeria");
                fragment = new GalleryFragment();
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        //setTitle(title);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Deseas salir de la aplicacion?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            })
                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        }
        return super.onKeyDown(keyCode, event);
    }
}