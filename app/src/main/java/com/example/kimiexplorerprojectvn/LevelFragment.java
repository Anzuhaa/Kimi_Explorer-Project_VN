package com.example.kimiexplorerprojectvn;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.kimiexplorerprojectvn.FragmentSoal1.Soal1_Timah;
import com.example.kimiexplorerprojectvn.FragmentSoal2.Soal6_B;
import com.example.kimiexplorerprojectvn.FragmentSoal3.Soal11_A;

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
                        .replace(R.id.container, new Soal11_A())
                        .commit();
            }
        });

        btnCoomingSoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupConfirm();
            }
        });
        return view;
   }
    private void PopupConfirm(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_main,null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popUpWindow = new PopupWindow(popUpView,width,height,focusable);

        TextView textView = popUpView.findViewById(R.id.tvPopCorrect);
        textView.setText("Maaf !");
        Button button = popUpView.findViewById(R.id.btnPopCorrect);
        button.setText("Ok");
        TextView txtDescription = popUpView.findViewById(R.id.tvDescription);
        txtDescription.setText("Level Ini Belum Di Rilis !");
        btnCoomingSoon.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(btnCoomingSoon, Gravity.CENTER,0,0);
                btnCoomingSoon = popUpView.findViewById(R.id.btnPopCorrect);
                btnCoomingSoon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpWindow.dismiss();
                    }
                });
            }
        });
    }
}