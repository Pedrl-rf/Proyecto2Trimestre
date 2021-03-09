package com.example.proyecto2trimestre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button bt_login;
    Button bt_call;
    TextInputEditText tiet_usario;
    TextInputEditText tiet_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        bt_login = findViewById(R.id.bt_login);
        bt_call = findViewById(R.id.bt_llamanos);
        tiet_passwd = findViewById(R.id.tiet_passwd);
        tiet_usario = findViewById(R.id.tiet_login);

//        bt_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent next = new Intent(MainActivity.this, menu.class);
//                if (tiet_passwd.toString().isEmpty()) {
//                    Toast toast = Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG);
//                    startActivity(next);
//                }
//            }
//        });
        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:633661477"));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    startActivity(intent_call);
                    return;
                }
            }
        });
    }
}