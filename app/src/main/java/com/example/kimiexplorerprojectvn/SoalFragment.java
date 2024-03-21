package com.example.kimiexplorerprojectvn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SoalFragment extends Fragment {


    Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4;
    TextView txtQuestion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soal, container, false);

    }

}