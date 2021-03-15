package com.example.proyecto2trimestre;

import java.util.ArrayList;

public class Menu {
    public int idImagen;
    public String titulo;

    public Menu(){
        idImagen = 0;
        titulo = "";
    }

    public Menu(int idImagen, String titulo){
        this.idImagen = idImagen;
        this.titulo = titulo;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<android.view.Menu> listaMenu(){
     android.view.Menu menu;
     ArrayList<android.view.Menu> lista = new ArrayList<android.view.Menu>();


     Integer[] IdImagenes = new Integer[]{R.drawable.escuela_1,R.drawable.escuela_2,R.drawable.escuela_4,R.drawable.escuela_3,R.drawable.escuela_6,R.drawable.escuela_7,R.drawable.escuela_8};
     String[]titulos=new String[]{"escuela_1","escuela_2","escuela_4","escuela_3","escuela_6","escuela_7","escuela_8"};

     for (int i = 0; i<titulos.length;i++) {
         menu = (android.view.Menu) new Menu(IdImagenes[i],titulos[i]);
         lista.add(menu);
     }

     return lista;
    }

}
