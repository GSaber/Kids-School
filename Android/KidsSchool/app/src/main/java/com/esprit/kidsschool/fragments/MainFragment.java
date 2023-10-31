package com.esprit.kidsschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.esprit.kidsschool.R;

import static com.facebook.FacebookSdk.getApplicationContext;


public class MainFragment extends Fragment {

    private ImageButton btnSetting,btnStart,btnExtra;
    private MediaPlayer mp;

    public MainFragment() {
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        getFragmentManager().beginTransaction().add(R.id.facebookContainer, new MainFacebookFragment()).commit();

        mp = MediaPlayer.create(getActivity(), R.raw.accueil);
        mp.start();

        btnStart = (ImageButton) view.findViewById(R.id.btn_start);
        btnExtra = (ImageButton) view.findViewById(R.id.btn_extra);
        btnSetting = (ImageButton) view.findViewById(R.id.btn_setting);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MenuFragment()).addToBackStack(null).commit();
            }
        });

        btnExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new ExamenBisFragment()).addToBackStack(null).commit();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new SettingFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mp.stop();
    }

}
