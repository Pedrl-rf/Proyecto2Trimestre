package com.example.proyecto2trimestre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button bt_login;
    Button bt_call;
    TextInputEditText tiet_usario;
    TextInputEditText tiet_passwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bt_login = findViewById(R.id.bt_login);
        bt_call = findViewById(R.id.bt_llamanos);
        tiet_passwd = findViewById(R.id.tiet_passwd);
        tiet_usario = findViewById(R.id.tiet_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Home.class);
                if (tiet_passwd.getText().toString().isEmpty()) {
                    tiet_passwd.setError("Introduce algo de contraseña");
                if(tiet_usario.getText().toString().isEmpty())
                {
                    tiet_usario.setError("Introduce un usuario");
                }
                }else
                {
                    startActivity(next);
                }
            }
        });
        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:633661477"));
                startActivity(intent_call);
            }
        });
    }
}