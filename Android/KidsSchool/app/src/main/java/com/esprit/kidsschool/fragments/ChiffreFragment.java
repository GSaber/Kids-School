package com.esprit.kidsschool.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.esprit.kidsschool.R;


public class ChiffreFragment extends Fragment {

    private ImageButton nextElement,backElement,replay,btnBack;
    private ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    public ChiffreFragment() {
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
        View view = inflater.inflate(R.layout.fragment_chiffre, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.one);
        mp.start();

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_chiffre);
        imgTableau = (ImageView) view.findViewById(R.id.tableau);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MenuFragment()).commit();
            }
        });

        nextElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i==10){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new ChiffreTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.one);
                        mp = MediaPlayer.create(getActivity(), R.raw.one);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.two);
                        mp = MediaPlayer.create(getActivity(), R.raw.two);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.three);
                        mp = MediaPlayer.create(getActivity(), R.raw.three);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.four);
                        mp = MediaPlayer.create(getActivity(), R.raw.four);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.five);
                        mp = MediaPlayer.create(getActivity(), R.raw.five);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.six);
                        mp = MediaPlayer.create(getActivity(), R.raw.six);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.seven);
                        mp = MediaPlayer.create(getActivity(), R.raw.seven);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.eight);
                        mp = MediaPlayer.create(getActivity(), R.raw.eight);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.nine);
                        mp = MediaPlayer.create(getActivity(), R.raw.nine);
                        mp.start();
                        break;
                }
            }
        });

        backElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;

                if(i==0){i=1;}

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.one);
                        mp = MediaPlayer.create(getActivity(), R.raw.one);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.two);
                        mp = MediaPlayer.create(getActivity(), R.raw.two);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.three);
                        mp = MediaPlayer.create(getActivity(), R.raw.three);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.four);
                        mp = MediaPlayer.create(getActivity(), R.raw.four);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.five);
                        mp = MediaPlayer.create(getActivity(), R.raw.five);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.six);
                        mp = MediaPlayer.create(getActivity(), R.raw.six);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.seven);
                        mp = MediaPlayer.create(getActivity(), R.raw.seven);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.eight);
                        mp = MediaPlayer.create(getActivity(), R.raw.eight);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.nine);
                        mp = MediaPlayer.create(getActivity(), R.raw.nine);
                        mp.start();
                        break;
                }
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i){
                    case 1:
                        mp = MediaPlayer.create(getActivity(), R.raw.one);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.two);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.three);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.four);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.five);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.six);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(getActivity(), R.raw.seven);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(getActivity(), R.raw.eight);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(getActivity(), R.raw.nine);
                        mp.start();
                        break;
                }
            }
        });

        return view;
    }

}
