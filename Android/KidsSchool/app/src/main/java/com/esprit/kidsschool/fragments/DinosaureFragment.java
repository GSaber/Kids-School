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


public class DinosaureFragment extends Fragment {

    ImageButton nextElement,backElement,replay,btnBack;
    ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    public DinosaureFragment() {
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
        View view = inflater.inflate(R.layout.fragment_dinosaure, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.albertosaurus);
        mp.start();

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_dinosaure);
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
                if(i==16){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new DinosaureTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.albertosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.albertosaurus);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.ankylosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.ankylosaurus);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.baraposaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.baraposaurus);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.dimetrodon);
                        mp = MediaPlayer.create(getActivity(), R.raw.dimetrodon);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.gallimimus);
                        mp = MediaPlayer.create(getActivity(), R.raw.gallimimus);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.homalocephale);
                        mp = MediaPlayer.create(getActivity(), R.raw.homalocephale);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.kentrosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.kentrosaurus);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.mesosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.mesosaurus);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.pteranodon);
                        mp = MediaPlayer.create(getActivity(), R.raw.pteranodon);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.saurolophus);
                        mp = MediaPlayer.create(getActivity(), R.raw.saurolophus);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.spinosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.spinosaurus);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.tyrannosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.tyrannosaurus);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.stegosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.stegosaurus);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.triceratops);
                        mp = MediaPlayer.create(getActivity(), R.raw.triceratops);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.velociraptor);
                        mp = MediaPlayer.create(getActivity(), R.raw.velociraptor);
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
                        imgTableau.setBackgroundResource(R.drawable.albertosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.albertosaurus);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.ankylosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.ankylosaurus);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.baraposaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.baraposaurus);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.dimetrodon);
                        mp = MediaPlayer.create(getActivity(), R.raw.dimetrodon);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.gallimimus);
                        mp = MediaPlayer.create(getActivity(), R.raw.gallimimus);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.homalocephale);
                        mp = MediaPlayer.create(getActivity(), R.raw.homalocephale);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.kentrosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.kentrosaurus);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.mesosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.mesosaurus);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.pteranodon);
                        mp = MediaPlayer.create(getActivity(), R.raw.pteranodon);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.saurolophus);
                        mp = MediaPlayer.create(getActivity(), R.raw.saurolophus);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.spinosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.spinosaurus);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.tyrannosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.tyrannosaurus);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.stegosaurus);
                        mp = MediaPlayer.create(getActivity(), R.raw.stegosaurus);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.triceratops);
                        mp = MediaPlayer.create(getActivity(), R.raw.triceratops);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.velociraptor);
                        mp = MediaPlayer.create(getActivity(), R.raw.velociraptor);
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
                        mp = MediaPlayer.create(getActivity(), R.raw.albertosaurus);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.ankylosaurus);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.baraposaurus);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.dimetrodon);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.gallimimus);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.homalocephale);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(getActivity(), R.raw.kentrosaurus);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(getActivity(), R.raw.mesosaurus);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(getActivity(), R.raw.pteranodon);
                        mp.start();
                        break;
                    case 10:
                        mp = MediaPlayer.create(getActivity(), R.raw.saurolophus);
                        mp.start();
                        break;
                    case 11:
                        mp = MediaPlayer.create(getActivity(), R.raw.spinosaurus);
                        mp.start();
                        break;
                    case 12:
                        mp = MediaPlayer.create(getActivity(), R.raw.tyrannosaurus);
                        mp.start();
                        break;
                    case 13:
                        mp = MediaPlayer.create(getActivity(), R.raw.stegosaurus);
                        mp.start();
                        break;
                    case 14:
                        mp = MediaPlayer.create(getActivity(), R.raw.triceratops);
                        mp.start();
                        break;
                    case 15:
                        mp = MediaPlayer.create(getActivity(), R.raw.velociraptor);
                        mp.start();
                        break;
                }
            }
        });

        return view;
    }

}
