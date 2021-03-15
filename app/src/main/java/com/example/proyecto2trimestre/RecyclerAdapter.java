package com.example.proyecto2trimestre;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Menu>listaMenu;
    private OnclickRecycler listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Menu menu = listaMenu.get(position);
        holder.bind(menu,listener);

    }

    @Override
    public int getItemCount() {
        return listaMenu.size();
    }


    public interface OnclickRecycler{
        void OnclickItemRecycler(Menu menu);
    }

    public RecyclerAdapter(ArrayList<Menu>listaMenu,OnclickRecycler listener){
        this.listaMenu = listaMenu;
        this.listener = listener;

    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imagenGaleria);
        }

        public void bind(final Menu menu, final OnclickRecycler listener) {

            Glide.with(imageView.getContext()).load(menu);

            imageView.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                        listener.OnclickItemRecycler(menu);
                    }
            });

        }
    }
}
