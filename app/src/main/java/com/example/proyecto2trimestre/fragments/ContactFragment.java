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
import android.widget.Toast;

import com.example.proyecto2trimestre.R;

public class ContactFragment extends Fragment {
    View view;

    CardView cv_googleMaps;
    CardView cv_correo1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        cv_googleMaps = (CardView)view.findViewById(R.id.cv_localizacion);
        cv_correo1 = (CardView)view.findViewById(R.id.cv_correo);


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


        return view;
    }
}