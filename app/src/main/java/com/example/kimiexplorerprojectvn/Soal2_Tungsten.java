package com.example.kimiexplorerprojectvn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Soal2_Tungsten extends Fragment {
    private Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, btnLanjut;

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soal, container, false);

        btnAnswer1 = view.findViewById(R.id.BtnAnswer1);
        btnAnswer2 = view.findViewById(R.id.BtnAnswer2);
        btnAnswer3 = view.findViewById(R.id.BtnAnswer3);
        btnAnswer4 = view.findViewById(R.id.BtnAnswer4);
        imageView = view.findViewById(R.id.ivQuestImage);

        imageView.setImageResource(R.drawable.soal2_tungsten);
        btnAnswer1.setText("Tungsten");
        btnAnswer2.setText("Lawrencium");
        btnAnswer3.setText("Antimon");
        btnAnswer4.setText("Tantalum");

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Benar", Toast.LENGTH_SHORT).show();
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Salah", Toast.LENGTH_SHORT).show();
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
        return view;
    }
}