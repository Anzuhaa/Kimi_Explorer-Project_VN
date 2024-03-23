package com.example.kimiexplorerprojectvn;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class KimiEatFragment extends Fragment {

    Button btnGive;

    TextView tvCarrot;

    Integer total;

    Button Start;

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
                if(valueCarrot > 4){
                    total = valueCarrot -1;
                        tvCarrot.setText(total + "");
                        PopupConfirm();
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
                PopupConfirm();
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
                PopupConfirm();
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
                PopupConfirm();
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
                PopupConfirm();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new KimiFragment())
                        .commit();
            }
        });
    }
    private void PopupConfirm(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_main,null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popUpWindow = new PopupWindow(popUpView,width,height,focusable);

        TextView textView = popUpView.findViewById(R.id.tvPopCorrect);
        textView.setText("Waaw !");
        Button button = popUpView.findViewById(R.id.btnPopCorrect);
        button.setText("Lagi");
        TextView txtDescription = popUpView.findViewById(R.id.tvDescription);
        txtDescription.setText("Wahh Enak, Berikan Lagi ! Aku Mau !");
        btnGive.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(btnGive, Gravity.CENTER,0,90);
                Start = popUpView.findViewById(R.id.btnPopCorrect);
                Start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpWindow.dismiss();
                    }
                });
            }
        });
    }
}