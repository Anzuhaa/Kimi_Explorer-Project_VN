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

public class KimiFragment extends Fragment {

    Button btnGive;

    TextView tvCarrot;

    Button Start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kimi, container, false);

        btnGive = view.findViewById(R.id.btnGive);
        tvCarrot = view.findViewById(R.id.tvCarrot);
        btnGive = view.findViewById(R.id.btnGive);

        btnGive.setOnClickListener(new View.OnClickListener() {
            int valueCarrot = Integer.parseInt(tvCarrot.getText().toString());
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
        textView.setText("Hallo ?");
        Button button = popUpView.findViewById(R.id.btnPopCorrect);
        button.setText("Mulai");
        TextView txtDescription = popUpView.findViewById(R.id.tvDescription);
        txtDescription.setText("Maaf, Wortel Anda Kurang Ayo Mulai Cari");
        btnGive.post(new Runnable() {
            @Override
            public void run() {
                popUpWindow.showAtLocation(btnGive, Gravity.CENTER,0,90);
                Start = popUpView.findViewById(R.id.btnPopCorrect);
                Start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, new LevelFragment())
                                                .commit();
                        popUpWindow.dismiss();
                    }
                });
            }
        });
    }
}