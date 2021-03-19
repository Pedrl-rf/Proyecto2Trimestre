package com.example.proyecto2trimestre;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button bt_login;
    Button bt_call;
    TextInputEditText tiet_usario;
    TextInputEditText tiet_passwd;
    TextView tv_rememberPasswd;
    TextView tv_helpText;
    int contador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        contador = 0;

        bt_login = findViewById(R.id.bt_login);
        bt_call = findViewById(R.id.bt_llamanos);
        tiet_passwd = findViewById(R.id.tiet_passwd);
        tiet_usario = findViewById(R.id.tiet_login);
        tv_rememberPasswd = findViewById(R.id.rememberPasswd);
        tv_helpText = findViewById(R.id.helpText);

        String usaurio = tiet_usario.getText().toString();
        String passwd = tiet_passwd.getText().toString();






        SharedPreferences namePreferences = getSharedPreferences
                ("usuario", MODE_PRIVATE);
        SharedPreferences passwdPreferences = getSharedPreferences("passwd,", MODE_PRIVATE);
        SharedPreferences.Editor nameEditor = namePreferences.edit();
        SharedPreferences.Editor passwdEditor = passwdPreferences.edit();
        nameEditor.putString("usuario", usaurio);
        passwdEditor.putString("passwd", passwd);
        nameEditor.apply();
        passwdEditor.apply();


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Home.class);
                if (tiet_usario.getText().toString().isEmpty() || tiet_passwd.getText().toString().isEmpty()) {
                    tiet_usario.setError("Introduce un usuario");
                    tiet_passwd.setError("Introduce una contraseña");
                } else {
                    if ((tiet_usario.getText().toString().equals("alumno") && tiet_passwd.getText().toString().equals("alumno1234")) || (tiet_usario.getText().toString().equals("profesor") && tiet_passwd.getText().toString().equals("profesor1234"))
                            || (tiet_usario.getText().toString().equals("invitado") && tiet_passwd.getText().toString().equals("estech1234"))) {

                        guardarPreferencias();
                        startActivity(next);
                    } else {
                        tiet_usario.setError("Has introducido un usuario equivocado");
                        tiet_passwd.setError("Has introducido una contraseña erronea");
                    }
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

        tv_rememberPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preferencias;
                //preferencias = getSharedPreferences().getString(,"");
                Toast.makeText(getApplication(), "pulsado", Toast.LENGTH_SHORT).show();
                final CharSequence[] opciones = {"salir"};
                final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(MainActivity.this);
                alertOpciones.setTitle("Contraseña guardadas");
                // alertOpciones.setMessage("cargar preferencias");
                alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cargarPreferencias();
                    }
                });
                alertOpciones.show();
            }
        });
    }



    @Override
    //captura el boton de atras para preguntar si quieres salir de la aplicacion
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
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

    public void guardarPreferencias() {
        SharedPreferences namePreferences = getSharedPreferences
                ("usuario", MODE_PRIVATE);
        SharedPreferences passwdPreferences = getSharedPreferences("passwd,", MODE_PRIVATE);
        String usaurio = tiet_usario.getText().toString();
        String passwd = tiet_passwd.getText().toString();

        SharedPreferences.Editor nameEditor = namePreferences.edit();
        SharedPreferences.Editor passwdEditor = passwdPreferences.edit();
        nameEditor.putString("usuario", usaurio);
        passwdEditor.putString("passwd", passwd);

        tiet_usario.setText(usaurio);
        tiet_passwd.setText(passwd);

        nameEditor.apply();
        passwdEditor.apply();
    }

    public void cargarPreferencias() {
        SharedPreferences namePreferences = getSharedPreferences
                ("usuario", MODE_PRIVATE);
        SharedPreferences passwdPreferences = getSharedPreferences("passwd,", MODE_PRIVATE);

        String usuario = namePreferences.getString("usuario", "No hay usuarios guardados");
        String passwd = passwdPreferences.getString("passwd", "No hay contraseñas guardadas");

        tiet_usario.setText(usuario);
        tiet_passwd.setText(passwd);
    }



}


