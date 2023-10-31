package com.esprit.kidsschool.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.esprit.kidsschool.R;

import static android.R.attr.defaultValue;
import static android.content.Context.MODE_PRIVATE;


public class ResultExamFragment extends Fragment {

    private ImageButton btnBack;
    private TextView tvResult;

    public ResultExamFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result_exam, container, false);

        btnBack = (ImageButton) view.findViewById(R.id.btn_back_result);
        tvResult = (TextView) view.findViewById(R.id.tv_result);

        SharedPreferences settings = getActivity().getSharedPreferences(ExamenFragment.PREF_Result, MODE_PRIVATE);
        tvResult.setText("You got "+settings.getInt("fmark",defaultValue)+"/30") ;


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();
            }
        });


        return view;
    }


}
