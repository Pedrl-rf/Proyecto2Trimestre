package com.example.proyecto2trimestre.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyecto2trimestre.Menu;
import com.example.proyecto2trimestre.R;
import com.example.proyecto2trimestre.RecyclerAdapter;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    View view;
    TextView titulo;
    RecyclerView rv_galeria;
    ImageView imagen;
    ArrayList<android.view.Menu> listaMenu;
    RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_galery, container, false);
        titulo=(TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.fotoGaleria);
        rv_galeria = (RecyclerView)view.findViewById(R.id.rv_galeria);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rv_galeria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        listaMenu = new Menu().listaMenu();



        return view;
    }
}