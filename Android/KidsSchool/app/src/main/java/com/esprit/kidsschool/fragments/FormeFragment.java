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


public class FormeFragment extends Fragment {

    private ImageButton nextElement,backElement,replay,btnBack;
    private ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    public FormeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_forme, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.circle);
        mp.start();

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_forme);
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
                if(i==7){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new FormeTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.circle);
                        mp = MediaPlayer.create(getActivity(), R.raw.circle);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.square);
                        mp = MediaPlayer.create(getActivity(), R.raw.square);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.triangle);
                        mp = MediaPlayer.create(getActivity(), R.raw.triangle);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.cube);
                        mp = MediaPlayer.create(getActivity(), R.raw.cube);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.heptagone);
                        mp = MediaPlayer.create(getActivity(), R.raw.heptagon);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.pentagone);
                        mp = MediaPlayer.create(getActivity(), R.raw.pentagon);
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
                        imgTableau.setBackgroundResource(R.drawable.circle);
                        mp = MediaPlayer.create(getActivity(), R.raw.circle);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.square);
                        mp = MediaPlayer.create(getActivity(), R.raw.square);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.triangle);
                        mp = MediaPlayer.create(getActivity(), R.raw.triangle);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.cube);
                        mp = MediaPlayer.create(getActivity(), R.raw.cube);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.heptagone);
                        mp = MediaPlayer.create(getActivity(), R.raw.heptagon);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.pentagone);
                        mp = MediaPlayer.create(getActivity(), R.raw.pentagon);
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
                        mp = MediaPlayer.create(getActivity(), R.raw.circle);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.square);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.triangle);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.cube);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.heptagon);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.pentagon);
                        mp.start();
                        break;
                }
            }
        });

        return view;
    }


}
