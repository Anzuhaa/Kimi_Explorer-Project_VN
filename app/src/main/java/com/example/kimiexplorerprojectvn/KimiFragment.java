package com.example.kimiexplorerprojectvn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KimiFragment extends Fragment {

    Button btnGive;

    TextView tvCarrot;

    Integer total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kimi, container, false);

        btnGive = view.findViewById(R.id.btnGive);
        tvCarrot = view.findViewById(R.id.tvCarrot);

        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {
                    Toast.makeText(getActivity(), "Sorry Your Carrot Is Not Enough", Toast.LENGTH_SHORT).show();
                }
        });

        return view;
    }
}