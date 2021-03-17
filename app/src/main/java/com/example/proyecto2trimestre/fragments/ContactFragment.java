package com.example.proyecto2trimestre.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyecto2trimestre.R;
import com.google.android.material.textfield.TextInputEditText;

public class ContactFragment extends Fragment {
    View view;

    CardView cv_googleMaps;
    CardView cv_correo1;
    CardView cv_correo2;
    CardView cv_telfono;
    CardView cv_whatsapp;
    Button bt_enviar;

    TextInputEditText tiet_nombre;
    TextInputEditText tiet_correo;
    TextInputEditText tiet_telefono;
    TextInputEditText tiet_mensaje;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        cv_googleMaps = (CardView)view.findViewById(R.id.cv_localizacion);
        cv_correo1 = (CardView)view.findViewById(R.id.cv_correo);
        cv_correo2 = (CardView)view.findViewById(R.id.cv_correo2);
        cv_telfono = (CardView)view.findViewById(R.id.cv_telefono);
        cv_whatsapp = (CardView)view.findViewById(R.id.cv_whatsapp);

        bt_enviar = (Button)view.findViewById(R.id.bt_enviar);

        tiet_correo = (TextInputEditText)view.findViewById(R.id.tiet_correo);
        tiet_nombre = (TextInputEditText)view.findViewById(R.id.tiet_nombre);
        tiet_telefono = (TextInputEditText)view.findViewById(R.id.tiet_telefono);
        tiet_mensaje = (TextInputEditText)view.findViewById(R.id.tiet_mensaje);

        cv_googleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //38.09433374051351, -3.631200155821735
                Uri intentUri = Uri.parse("geo:1.382,2.170?z=16&q=38.09433374051351,-3.631200155821735(Escuela Estech)");
                //Uri intentUri = Uri.parse("https://goo.gl/maps/4hx8UETuw1HwU3i56");
                Intent intent = new Intent(Intent.ACTION_VIEW, intentUri);
                startActivity(intent);
            }
        });

        cv_correo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] nombre = {"escuelaestech@gmail.es"};
                Intent emailMensaje = new Intent(Intent.ACTION_SEND);

                emailMensaje.setData(Uri.parse("mailto:"));
                emailMensaje.setType("text/plain");
                emailMensaje.putExtra(Intent.EXTRA_EMAIL, nombre);
                emailMensaje.putExtra(Intent.EXTRA_SUBJECT, "Tu Asunto...");
                emailMensaje.putExtra(Intent.EXTRA_TEXT, ""); //

                try {
                    startActivity(Intent.createChooser(emailMensaje, "Enviar email."));
                    Log.i("EMAIL", "Enviando email...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cv_correo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] nombre = {"escuelaestech@gmail.es"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, nombre);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tu Asunto...");
                emailIntent.putExtra(Intent.EXTRA_TEXT, ""); //

                try {
                    startActivity(Intent.createChooser(emailIntent, "Enviar email."));
                    Log.i("EMAIL", "Enviando email...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cv_telfono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:953636000"));
                startActivity(intent_call);
            }
        });

        cv_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                ¡metodo que es solo para enviar texto!

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
*/
                String telefono = "34697246008";
                String msg = "necesito ayuda";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String uri = "whatsapp://send?phone="+telefono+"&text="+msg;
                sendIntent.setData(Uri.parse(uri));
                startActivity(sendIntent);
            }
        });

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []nombre = {tiet_nombre.getText().toString()};
                String telefono = tiet_telefono.getText().toString();
                String correo = tiet_correo.getText().toString();
                String mensaje = tiet_mensaje.getText().toString();
                String[]correoAyuda={"escuelaestech@gmail.com"};

                if(tiet_correo.getText().toString().isEmpty()){
                    tiet_correo.setError("Introduce correo");
                }else if(tiet_telefono.getText().toString().isEmpty()){
                    tiet_telefono.setError("Introduce telefono");
                }else if(tiet_nombre.getText().toString().isEmpty()){
                    tiet_nombre.setError("Introduce un numbre");
                }else if(tiet_mensaje.getText().toString().isEmpty()){
                    tiet_mensaje.setError("Introduce un mensaje");
                }else {
                    Intent email = new Intent(Intent.ACTION_SEND);

                    email.setData(Uri.parse("mailto:"));
                    email.setType("text/plain");
                    email.putExtra(Intent.EXTRA_EMAIL, correoAyuda);
                    email.putExtra(Intent.EXTRA_SUBJECT, "CONTACTO");
                    email.putExtra(Intent.EXTRA_TEXT, nombre + "\n" + telefono + "\n" + correo + "\n" + mensaje);
                    startActivity(email);
                }
            }
        });
        return view;
    }
}