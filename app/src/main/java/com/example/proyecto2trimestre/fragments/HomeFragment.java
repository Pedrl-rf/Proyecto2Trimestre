package com.example.proyecto2trimestre.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyecto2trimestre.R;
import com.google.android.material.textfield.TextInputEditText;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    TextView tv_bienvenido;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);
        tv_bienvenido = (TextView)view.findViewById(R.id.tv_bienvenido);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //preferencias guardadas
        SharedPreferences namePreferences = getActivity().getSharedPreferences("usuario",MODE_PRIVATE);
        String bienvenido = namePreferences.getString("usuario","no hay nada");
        tv_bienvenido.setText(bienvenido);
    }
}