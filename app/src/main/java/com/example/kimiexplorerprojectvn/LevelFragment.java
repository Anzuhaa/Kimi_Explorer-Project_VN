package com.example.kimiexplorerprojectvn;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LevelFragment extends Fragment {

    private Button btnLevel1,btnLevel2,btnLevel3,btnCoomingSoon;
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        btnLevel1= view.findViewById(R.id.BtnLevel1);
        btnLevel2= view.findViewById(R.id.BtnLevel2);
        btnLevel3= view.findViewById(R.id.BtnLevel3);
        btnCoomingSoon= view.findViewById(R.id.BtnCoomingSoon);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Soal1_Timah())
                        .commit();
            }
        });
        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Soal6_B())
                        .commit();
            }
        });

        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Soal1_Timah())
                        .commit();
            }
        });

        btnCoomingSoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Soal1_Timah())
                        .commit();
            }
        });
        return view;
   }
}