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


public class AnimauxFragment extends Fragment {

    private ImageButton nextElement,backElement,replay,btnBack;
    private ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    public AnimauxFragment() {
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
        View view = inflater.inflate(R.layout.fragment_animaux, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.dog);
        mp.start();

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_animaux);
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
                if(i==17){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new AnimauxTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.dog);
                        mp = MediaPlayer.create(getActivity(), R.raw.dog);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.cat);
                        mp = MediaPlayer.create(getActivity(), R.raw.cat);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.bear);
                        mp = MediaPlayer.create(getActivity(), R.raw.bear);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.camel);
                        mp = MediaPlayer.create(getActivity(), R.raw.camel);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.chicken);
                        mp = MediaPlayer.create(getActivity(), R.raw.chicken);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.donkey);
                        mp = MediaPlayer.create(getActivity(), R.raw.donkey);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.duck);
                        mp = MediaPlayer.create(getActivity(), R.raw.duck);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.frog);
                        mp = MediaPlayer.create(getActivity(), R.raw.frog);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.horse);
                        mp = MediaPlayer.create(getActivity(), R.raw.horse);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.lion);
                        mp = MediaPlayer.create(getActivity(), R.raw.lion);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.monkey);
                        mp = MediaPlayer.create(getActivity(), R.raw.monkey);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.owl);
                        mp = MediaPlayer.create(getActivity(), R.raw.owl);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.pig);
                        mp = MediaPlayer.create(getActivity(), R.raw.pig);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.sheep);
                        mp = MediaPlayer.create(getActivity(), R.raw.sheep);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.snake);
                        mp = MediaPlayer.create(getActivity(), R.raw.snake);
                         mp.start();
                        break;
                    case 16:
                        imgTableau.setBackgroundResource(R.drawable.wolf);
                        mp = MediaPlayer.create(getActivity(), R.raw.wolf);
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
                        imgTableau.setBackgroundResource(R.drawable.dog);
                        mp = MediaPlayer.create(getActivity(), R.raw.dog);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.cat);
                        mp = MediaPlayer.create(getActivity(), R.raw.cat);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.bear);
                        mp = MediaPlayer.create(getActivity(), R.raw.bear);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.camel);
                        mp = MediaPlayer.create(getActivity(), R.raw.camel);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.chicken);
                        mp = MediaPlayer.create(getActivity(), R.raw.chicken);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.donkey);
                        mp = MediaPlayer.create(getActivity(), R.raw.donkey);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.duck);
                        mp = MediaPlayer.create(getActivity(), R.raw.duck);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.frog);
                        mp = MediaPlayer.create(getActivity(), R.raw.frog);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.horse);
                        mp = MediaPlayer.create(getActivity(), R.raw.horse);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.lion);
                        mp = MediaPlayer.create(getActivity(), R.raw.lion);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.monkey);
                        mp = MediaPlayer.create(getActivity(), R.raw.monkey);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.owl);
                        mp = MediaPlayer.create(getActivity(), R.raw.owl);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.pig);
                        mp = MediaPlayer.create(getActivity(), R.raw.pig);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.sheep);
                        mp = MediaPlayer.create(getActivity(), R.raw.sheep);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.snake);
                        mp = MediaPlayer.create(getActivity(), R.raw.snake);
                        mp.start();
                        break;
                    case 16:
                        imgTableau.setBackgroundResource(R.drawable.wolf);
                        mp = MediaPlayer.create(getActivity(), R.raw.wolf);
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
                        mp = MediaPlayer.create(getActivity(), R.raw.dog);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.cat);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.bear);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.camel);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.chicken);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.donkey);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(getActivity(), R.raw.duck);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(getActivity(), R.raw.frog);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(getActivity(), R.raw.horse);
                        mp.start();
                        break;
                    case 10:
                        mp = MediaPlayer.create(getActivity(), R.raw.lion);
                        mp.start();
                        break;
                    case 11:
                        mp = MediaPlayer.create(getActivity(), R.raw.monkey);
                        mp.start();
                        break;
                    case 12:
                        mp = MediaPlayer.create(getActivity(), R.raw.owl);
                        mp.start();
                        break;
                    case 13:
                        mp = MediaPlayer.create(getActivity(), R.raw.pig);
                        mp.start();
                        break;
                    case 14:
                        mp = MediaPlayer.create(getActivity(), R.raw.sheep);
                        mp.start();
                        break;
                    case 15:
                        mp = MediaPlayer.create(getActivity(), R.raw.snake);
                        mp.start();
                        break;
                    case 16:
                        mp = MediaPlayer.create(getActivity(), R.raw.wolf);
                        mp.start();
                        break;
                }
            }
        });

        return view;
    }

}
