package com.example.kimiexplorerprojectvn.FragmentSoal2;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.kimiexplorerprojectvn.R;

public class Soal9_D extends Fragment {
    private Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4, btnLanjut;

    private TextView tvQuestion;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soal_no_image, container, false);

        btnAnswer1 = view.findViewById(R.id.BtnAnswer1);
        btnAnswer2 = view.findViewById(R.id.BtnAnswer2);
        btnAnswer3 = view.findViewById(R.id.BtnAnswer3);
        btnAnswer4 = view.findViewById(R.id.BtnAnswer4);
        tvQuestion = view.findViewById(R.id.tvQuestion);

        tvQuestion.setText("Dalam sistem periodik unsur modern, golongan menyatakan...");
        btnAnswer1.setText("Jumlah subkulit atom");
        btnAnswer2.setText("Jumlah elektron pada subkulit");
        btnAnswer3.setText("Jumlah elektron valensi");
        btnAnswer4.setText("jumlah elektron kulit terluar");

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowWrong();
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatepopupwindowWrong();
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
                CreatepopupwindowCorrect();
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
        tvQuestion.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(tvQuestion, Gravity.CENTER,0,0);
                btnLanjut = popUpView.findViewById(R.id.btnPopCorrect);
                ImageView ivQuestion = popUpView.findViewById(R.id.ivPopCorrect);
                ivQuestion.setImageResource(R.drawable.popup_correct);
                btnLanjut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new Soal10_C())
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
        TextView txtDescription = popUpView.findViewById(R.id.tvDescription);
        txtDescription.setText("Aduh, Anda Salah Silahkan Coba Lagi");
        ImageView ivQuestion = popUpView.findViewById(R.id.ivPopCorrect);
        ivQuestion.setImageResource(R.drawable.popup_wrong);
        tvQuestion.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(tvQuestion, Gravity.CENTER,0,0);
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