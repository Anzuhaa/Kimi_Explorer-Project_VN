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

public class KimiEatFragment extends Fragment {

    Button btnGive;

    TextView tvCarrot;

    Integer total;

    int i;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kimi, container, false);

        btnGive = view.findViewById(R.id.btnGive);
        tvCarrot = view.findViewById(R.id.tvCarrot);
        tvCarrot.setText("5");
        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {

                if(valueCarrot < 0) {
                    Toast.makeText(getActivity(), "Sorry Your Carrot Is Not Enough", Toast.LENGTH_SHORT).show();
                }
                else if(valueCarrot > 4){
                    total = valueCarrot -1;
                        tvCarrot.setText(total + "");
                        Toast.makeText(getActivity(), "Thank You!", Toast.LENGTH_SHORT).show();
                        KimiEat1();

                }
            }
        });
        return view;
    }
    public void KimiEat1(){
        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {
                total = valueCarrot -1;
                tvCarrot.setText(total + "");
                Toast.makeText(getActivity(), "Thank You!", Toast.LENGTH_SHORT).show();
                KimiEat2();
            }
        });
    }
    public void KimiEat2(){
        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {
                total = valueCarrot -1;
                tvCarrot.setText(total + "");
                Toast.makeText(getActivity(), "Thank You!", Toast.LENGTH_SHORT).show();
                KimiEat3();
            }
        });
    }
    public void KimiEat3(){
        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {
                total = valueCarrot -1;
                tvCarrot.setText(total + "");
                Toast.makeText(getActivity(), "Thank You!", Toast.LENGTH_SHORT).show();
                KimiEat4();
            }
        });
    }
    public void KimiEat4(){
        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
            @Override
            public void onClick(View v) {
                total = valueCarrot -1;
                tvCarrot.setText(total + "");
                Toast.makeText(getActivity(), "Thank You!", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new KimiFragment())
                        .commit();
            }
        });
    }
}