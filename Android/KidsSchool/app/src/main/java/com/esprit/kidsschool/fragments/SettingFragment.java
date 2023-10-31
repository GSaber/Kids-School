package com.esprit.kidsschool.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.esprit.kidsschool.R;
import com.esprit.kidsschool.adapters.childrenAdapter;
import com.esprit.kidsschool.entities.Children;
import com.facebook.Profile;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.facebook.FacebookSdk.getApplicationContext;


public class SettingFragment extends Fragment {

    SwipeMenuListView lvChildrens;
    FloatingActionButton addFab;
    TextView tvProgress;
    ArrayList<Children>childrens;
    final Profile profile=Profile.getCurrentProfile();
    private ImageButton btnBack;
    public static final String PREF_NAME = "SelectedChild";

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        lvChildrens = (SwipeMenuListView) view.findViewById(R.id.lv_childrens);
        tvProgress = (TextView) view.findViewById(R.id.tv_progress);
        addFab = (FloatingActionButton) view.findViewById(R.id.add_fab);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_setting2);

        if(profile!=null){

            SharedPreferences settings = getActivity().getSharedPreferences(SettingFragment.PREF_NAME, MODE_PRIVATE);
            tvProgress.setText(settings.getString("nom",""));

        String whereClause = "idParent = "+profile.getId();
        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause( whereClause );

        Backendless.Persistence.of( Children.class).find(dataQuery,new AsyncCallback<BackendlessCollection<Children>>(){
            @Override
            public void handleResponse( BackendlessCollection<Children> foundContacts )
            {
                System.out.println(foundContacts.getData().size());
                childrens= (ArrayList<Children>) foundContacts.getData();
                for(Children c:childrens)
                {
                    System.out.println("liste charged");
                    c.getNom();
                }
                for(int i=0; i<childrens.size(); i++) {
                    if(childrens.get(i).getPhoto().equals("")){

                    }
                }
                childrenAdapter adapter = new childrenAdapter(getActivity(),R.layout.item_children, childrens);
                lvChildrens.setAdapter(adapter);
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                System.out.println("failed to charge list !!!");
                System.out.println(fault.getMessage());
                Toast.makeText(getActivity(),"Verify your internet connection",Toast.LENGTH_LONG).show();
            }
        });

        } else{
            tvProgress.setText("");
        }

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        lvChildrens.setMenuCreator(creator);

        lvChildrens.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                final Children child = childrens.get(position);
                switch (index) {

                    case 0:
                        // delete
                        Backendless.Persistence.of( Children.class ).remove( child,
                                new AsyncCallback<Long>()
                                {
                                    public void handleResponse( Long response )
                                    {
                                        if(child.getNom().toString().equals(tvProgress.getText().toString())){
                                            SharedPreferences progressPrefs = getActivity().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                                            SharedPreferences.Editor editor = progressPrefs.edit();
                                            editor.remove("nom");
                                            editor.remove("position");
                                            editor.commit();
                                            tvProgress.setText("");
                                        }
                                        Toast.makeText(getActivity(),"Item deleted.",Toast.LENGTH_SHORT).show();
                                        getFragmentManager().beginTransaction().replace(R.id.mainContainer, new SettingFragment()).commit();

                                    }
                                    public void handleFault( BackendlessFault fault )
                                    {
                                        Toast.makeText(getActivity(),"Failed",Toast.LENGTH_SHORT).show();
                                    }
                                } );
                        break;
                }
                return false;
            }
        });

        lvChildrens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("itemClicked");
                final Children children = childrens.get(position);
                //displayChild(children);
                SharedPreferences progressPrefs = getActivity().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor prefEditor = progressPrefs.edit();
                prefEditor.putInt("position", position);
                prefEditor.putString("nom",children.getNom());
                prefEditor.commit();
                tvProgress.setText(children.getNom());
            }
        });


        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new AddChildrenFragment()).addToBackStack(null).commit();
            }

        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("back pressed");
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();
            }
        });

        return view;
    }


    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

}
