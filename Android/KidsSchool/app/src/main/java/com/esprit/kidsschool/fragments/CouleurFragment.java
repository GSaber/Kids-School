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


public class CouleurFragment extends Fragment {

    ImageButton nextElement,backElement,replay,btnBack;
    ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    public CouleurFragment() {
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
        View view = inflater.inflate(R.layout.fragment_couleur, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.red);
        mp.start();

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_couleur);
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
                if(i==9){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new CouleurTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.red);
                        mp = MediaPlayer.create(getActivity(), R.raw.red);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.blue);
                        mp = MediaPlayer.create(getActivity(), R.raw.blue);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.green);
                        mp = MediaPlayer.create(getActivity(), R.raw.green);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.yellow);
                        mp = MediaPlayer.create(getActivity(), R.raw.yellow);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.orange);
                        mp = MediaPlayer.create(getActivity(), R.raw.orange);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.pink);
                        mp = MediaPlayer.create(getActivity(), R.raw.pink);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.purple);
                        mp = MediaPlayer.create(getActivity(), R.raw.purple);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.grey);
                        mp = MediaPlayer.create(getActivity(), R.raw.grey);
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

                switch (i) {
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.red);
                        mp = MediaPlayer.create(getActivity(), R.raw.red);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.blue);
                        mp = MediaPlayer.create(getActivity(), R.raw.blue);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.green);
                        mp = MediaPlayer.create(getActivity(), R.raw.green);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.yellow);
                        mp = MediaPlayer.create(getActivity(), R.raw.yellow);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.orange);
                        mp = MediaPlayer.create(getActivity(), R.raw.orange);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.pink);
                        mp = MediaPlayer.create(getActivity(), R.raw.pink);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.purple);
                        mp = MediaPlayer.create(getActivity(), R.raw.purple);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.grey);
                        mp = MediaPlayer.create(getActivity(), R.raw.grey);
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
                        mp = MediaPlayer.create(getActivity(), R.raw.red);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.blue);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.green);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.yellow);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.orange);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.pink);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(getActivity(), R.raw.purple);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(getActivity(), R.raw.grey);
                        mp.start();
                        break;
                }
            }
        });

        return view;
    }

}
