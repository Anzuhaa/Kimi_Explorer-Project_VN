package com.example.kimiexplorerprojectvn;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Soal5_Emas extends Fragment {
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

        imageView.setImageResource(R.drawable.soal5_emas);
        btnAnswer1.setText("Actinium");
        btnAnswer2.setText("Emas");
        btnAnswer3.setText("Belerang");
        btnAnswer4.setText("Besi");

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowWrong();
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowCorrect();
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowWrong();
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowWrong();
            }
        });
        return view;
    }
    private void CreatepopupwindowCorrect(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_main,null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popUpWindow = new PopupWindow(popUpView,width,height,focusable);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(imageView, Gravity.CENTER,0,0);
                btnLanjut = popUpView.findViewById(R.id.btnPopCorrect);
                btnLanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new KimiEatFragment())
                                .commit();
                        popUpWindow.dismiss();
                    }
                });
            }
        });
    }
    private void CreatepopupwindowWrong(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_main,null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popUpWindow = new PopupWindow(popUpView,width,height,focusable);

        TextView textView = popUpView.findViewById(R.id.tvPopCorrect);
        textView.setText("Salah !");
        Button button = popUpView.findViewById(R.id.btnPopCorrect);
        button.setText("Ulang");
        imageView.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(imageView, Gravity.CENTER,0,0);
                btnLanjut = popUpView.findViewById(R.id.btnPopCorrect);
                btnLanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpWindow.dismiss();
                    }
                });
            }
        });
    }
}