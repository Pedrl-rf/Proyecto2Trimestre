package com.example.proyecto2trimestre;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bt_login = findViewById(R.id.bt_login);
        bt_call = findViewById(R.id.bt_llamanos);
        tiet_passwd = findViewById(R.id.tiet_passwd);
        tiet_usario = findViewById(R.id.tiet_login);
        tv_rememberPasswd = findViewById(R.id.rememberPasswd);
        tv_helpText = findViewById(R.id.helpText);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Home.class);
                    if(tiet_usario.getText().toString().isEmpty() || tiet_passwd.getText().toString().isEmpty())
                    {
                        tiet_usario.setError("Introduce un usuario");
                        tiet_passwd.setError("Introduce una contraseña");
                    }if (tiet_usario.getText().toString() != "alumno" || tiet_usario.getText().toString() != "invitado" || tiet_usario.getText().toString() != "profesor")
                    {
                        tiet_usario.setError("No has introducido un usuario correcto");
                    }if (tiet_passwd.getText().toString() != "alumno1234" || tiet_passwd.getText().toString() != "alumno1234" || tiet_passwd.getText().toString() != "profesor1234")
                    {
                        tiet_passwd.setError("No has introducido una contraseña valida");
                    }else
                    {
                        guardarPreferencias();
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

        tv_rememberPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preferencias;
                //preferencias = getSharedPreferences().getString(,"");
                Toast.makeText(getApplication(),"pulsado",Toast.LENGTH_SHORT).show();
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

    public void guardarPreferencias(){
        SharedPreferences namePreferences = getSharedPreferences
                ("usuario",MODE_PRIVATE);
        SharedPreferences passwdPreferences = getSharedPreferences("passwd,",MODE_PRIVATE);
        String usaurio = tiet_usario.getText().toString();
        String passwd = tiet_passwd.getText().toString();

        SharedPreferences.Editor nameEditor = namePreferences.edit();
        SharedPreferences.Editor passwdEditor = passwdPreferences.edit();
        nameEditor.putString("usuario",usaurio);
        passwdEditor.putString("passwd",passwd);

        tiet_usario.setText(usaurio);
        tiet_passwd.setText(passwd);

        nameEditor.commit();
        passwdEditor.commit();

    }

    public void cargarPreferencias(){
        SharedPreferences namePreferences = getSharedPreferences
                ("usuario",MODE_PRIVATE);
        SharedPreferences passwdPreferences = getSharedPreferences("passwd,",MODE_PRIVATE);

        String usuario = namePreferences.getString("usuario","No hay usuarios guardados");
        String passwd = passwdPreferences.getString("passwd","No hay contraseñas guardadas");

        tiet_usario.setText(usuario);
        tiet_passwd.setText(passwd);
    }
}