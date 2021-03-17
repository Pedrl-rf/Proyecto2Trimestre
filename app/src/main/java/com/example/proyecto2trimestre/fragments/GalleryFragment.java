package com.example.proyecto2trimestre.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto2trimestre.R;
import com.example.proyecto2trimestre.SliderAdapter;
import com.example.proyecto2trimestre.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    View view;

    private ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_gallery, container, false);

        viewPager2 = (ViewPager2)view.findViewById(R.id.viewPagerImageSlider);
        //Array para almacenar las imagenes de la carpeta drawable
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.escuela_1));
        sliderItems.add(new SliderItem(R.drawable.escuela_2));
        sliderItems.add(new SliderItem(R.drawable.escuela_3));
        sliderItems.add(new SliderItem(R.drawable.escuela_4));
        sliderItems.add(new SliderItem(R.drawable.escuela_6));
        sliderItems.add(new SliderItem(R.drawable.escuela_7));
        sliderItems.add(new SliderItem(R.drawable.escuela_8));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));




        return view;
    }
}