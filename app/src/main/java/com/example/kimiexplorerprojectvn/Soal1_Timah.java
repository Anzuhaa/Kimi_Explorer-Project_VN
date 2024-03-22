package com.example.kimiexplorerprojectvn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Soal1_Timah extends Fragment {
    private Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, btnKembali, btnLanjut;

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soal, container, false);

        btnAnswer1 = view.findViewById(R.id.BtnAnswer1);
        btnAnswer2 = view.findViewById(R.id.BtnAnswer2);
        btnAnswer3 = view.findViewById(R.id.BtnAnswer3);
        btnAnswer4 = view.findViewById(R.id.BtnAnswer4);
        btnKembali = view.findViewById(R.id.btnKembali);
        btnLanjut = view.findViewById(R.id.btnLanjut);
        imageView = view.findViewById(R.id.ivQuestImage);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Salah", Toast.LENGTH_SHORT).show();
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Benar", Toast.LENGTH_SHORT).show();
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Salah", Toast.LENGTH_SHORT).show();
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Salah", Toast.LENGTH_SHORT).show();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kembali  = getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new LevelFragment())
                        .commit();
            }
        });
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lanjut  = getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new Soal2_Tungsten())
                        .commit();

            }
        });
        return view;
    }
}