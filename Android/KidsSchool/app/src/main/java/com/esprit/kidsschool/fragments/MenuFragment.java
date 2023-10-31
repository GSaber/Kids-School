package com.esprit.kidsschool.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.esprit.kidsschool.R;
import com.facebook.Profile;
import static android.content.Context.MODE_PRIVATE;


public class MenuFragment extends Fragment {

    private  ImageButton btnAlphabet,btnChiffre,btnCouleur,btnAnimaux,btnForme,btnDinausor,btnBack;
    private TextView tvProgress;
    final Profile profile=Profile.getCurrentProfile();

    public MenuFragment() {
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        btnAlphabet = (ImageButton) view.findViewById(R.id.btn_alphabet);
        btnChiffre = (ImageButton) view.findViewById(R.id.btn_chiffre);
        btnCouleur = (ImageButton) view.findViewById(R.id.btn_couleur);
        btnAnimaux = (ImageButton) view.findViewById(R.id.btn_animaux);
        btnForme = (ImageButton) view.findViewById(R.id.btn_forme);
        btnDinausor = (ImageButton) view.findViewById(R.id.btn_dinausor);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back);
        tvProgress = (TextView) view.findViewById(R.id.tv_progress_menu);

        if(profile!=null) {
            SharedPreferences settings = getActivity().getSharedPreferences(SettingFragment.PREF_NAME, MODE_PRIVATE);
            tvProgress.setText(settings.getString("nom", ""));
        }
        else{
            tvProgress.setText("");
        }

        btnAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new AlphabetFragment()).addToBackStack(null).commit();
            }
        });

        btnChiffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new ChiffreFragment()).addToBackStack(null).commit();
            }
        });

        btnCouleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new CouleurFragment()).addToBackStack(null).commit();
            }
        });

        btnAnimaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new AnimauxFragment()).addToBackStack(null).commit();
            }
        });

        btnForme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new FormeFragment()).addToBackStack(null).commit();
            }
        });

        btnDinausor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new DinosaureFragment()).addToBackStack(null).commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();
            }
        });

        return view;
    }




}
