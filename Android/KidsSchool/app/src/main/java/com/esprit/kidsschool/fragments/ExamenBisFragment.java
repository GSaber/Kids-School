package com.esprit.kidsschool.fragments;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.kidsschool.R;
import com.facebook.Profile;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.Context.MODE_PRIVATE;

public class ExamenBisFragment extends Fragment {


    private int i=0;
    private int count=1;
    private int count2=1;
    private int mark=0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    private ImageView rep1,rep2,rep3;
    private static final String IMAGEVIEW_TAG = "incorrect";
    private static final String IMAGEVIEW_TAG1 = "correct";
    private FrameLayout testLayout;
    private View dragView;
    public static final String PREF_NAME = "ChildMark";
    private ImageButton btnBack;
    private TextView tvName;
    private final Profile profile=Profile.getCurrentProfile();

    public ExamenBisFragment() {
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
        View view = inflater.inflate(R.layout.fragment_examen_bis, container, false);

        for (int i=2; i<21; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        rep1 = (ImageView)view.findViewById(R.id.examen2_rep1);
        rep2 = (ImageView)view.findViewById(R.id.examen2_rep2);
        rep3 = (ImageView)view.findViewById(R.id.examen2_rep3);

        // Sets the tag
        rep1.setTag(IMAGEVIEW_TAG);
        rep2.setTag(IMAGEVIEW_TAG);
        rep3.setTag(IMAGEVIEW_TAG1);

        btnBack = (ImageButton) view.findViewById(R.id.btn_back_exambis);
        tvName = (TextView) view.findViewById(R.id.tv_name_exambis);

        if(profile!=null) {
            SharedPreferences settings = getActivity().getSharedPreferences(SettingFragment.PREF_NAME, MODE_PRIVATE);
            tvName.setText(settings.getString("nom", ""));
        }
        else{
            tvName.setText("");
        }

        testLayout = (FrameLayout) view.findViewById(R.id.examen2_layout);
        // set the listener to the dragging data
        rep1.setOnLongClickListener(new ExamenBisFragment.MyClickListener());
        rep2.setOnLongClickListener(new ExamenBisFragment.MyClickListener());
        rep3.setOnLongClickListener(new ExamenBisFragment.MyClickListener());
        view.findViewById(R.id.examen2_rep_layout).setOnDragListener(new ExamenBisFragment.MyDragListener());
        view.findViewById(R.id.examen2_drop_layout).setOnDragListener(new ExamenBisFragment.MyDragListener());
        view.findViewById(R.id.examen2_layout).setOnDragListener(new ExamenBisFragment.MyDragListener());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();
            }
        });

        return view;
    }

    private final class MyClickListener implements View.OnLongClickListener {

        // called when the item is long-clicked
        @Override
        public boolean onLongClick(View view) {
            // TODO Auto-generated method stub

            // create it from the object's tag
            ClipData.Item item = new ClipData.Item((CharSequence)view.getTag());

            if(view.getTag()==IMAGEVIEW_TAG1){
                i=1;
            }
            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag( data, //data to be dragged
                    shadowBuilder, //drag shadow
                    view, //local data about the drag and drop operation
                    0   //no needed flags
            );


            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class MyDragListener implements View.OnDragListener {


        @Override
        public boolean onDrag(View v, DragEvent event) {

            // Handles each of the expected events
            switch (event.getAction()) {

                //signal for the start of a drag and drop operation.
                case DragEvent.ACTION_DRAG_STARTED:
                    break;

                case DragEvent.ACTION_DROP:
                    // if the view is the bottomlinear, we accept the drag item
                    if ((v == v.findViewById(R.id.examen2_drop_layout)) && i == 1) {

                        mark++;
                        count++;
                        System.out.println("count="+count);


                    } else if ((v == v.findViewById(R.id.examen2_layout))) {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), "You can't drop the image here", Toast.LENGTH_LONG).show();

                    } else if ((v == v.findViewById(R.id.examen2_drop_layout)) && i == 0) {
                        count++;

                    } else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), "You can't drop the image here", Toast.LENGTH_LONG).show();
                    }
                    break;

                //the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:
                    System.out.println("ok");
                    System.out.println("mark="+mark);
                    System.out.println("okok");
                    System.out.println("size="+list.size());
                    System.out.println("count="+count);
                    if(count-2 >= 0) {
                        if (list.size() > count - 2) {
                            count2 = list.get(count - 2);
                        } else if (list.size() == count - 2) {
                            count2 = 21;
                        }
                    }
                    System.out.println("count2="+count2);
                    dragView = (View) event.getLocalState();
                    if(count2==2) {
                        testLayout.setBackgroundResource(R.drawable.donkeytest);
                        rep1.setImageResource(R.drawable.repdonkey);
                        rep2.setImageResource(R.drawable.rephorse);
                        rep3.setImageResource(R.drawable.repcow);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==3) {
                        testLayout.setBackgroundResource(R.drawable.pigtest);
                        rep1.setImageResource(R.drawable.repfrog);
                        rep2.setImageResource(R.drawable.repcat);
                        rep3.setImageResource(R.drawable.reppig);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);
                    } else if(count2==4) {
                        testLayout.setBackgroundResource(R.drawable.monkeytest);
                        rep1.setImageResource(R.drawable.repwolf);
                        rep2.setImageResource(R.drawable.repmonkey);
                        rep3.setImageResource(R.drawable.repsheep);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==5) {
                        testLayout.setBackgroundResource(R.drawable.ducktest);
                        rep1.setImageResource(R.drawable.repduck);
                        rep2.setImageResource(R.drawable.repcat);
                        rep3.setImageResource(R.drawable.repfrog);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==6) {
                        testLayout.setBackgroundResource(R.drawable.atest);
                        rep1.setImageResource(R.drawable.repd);
                        rep2.setImageResource(R.drawable.repa);
                        rep3.setImageResource(R.drawable.repg);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==7) {
                        testLayout.setBackgroundResource(R.drawable.btest);
                        rep1.setImageResource(R.drawable.repb);
                        rep2.setImageResource(R.drawable.repw);
                        rep3.setImageResource(R.drawable.repa);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==8) {
                        testLayout.setBackgroundResource(R.drawable.ctest);
                        rep1.setImageResource(R.drawable.reph);
                        rep2.setImageResource(R.drawable.repf);
                        rep3.setImageResource(R.drawable.repc);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==9) {
                        testLayout.setBackgroundResource(R.drawable.wtest);
                        rep1.setImageResource(R.drawable.repv);
                        rep2.setImageResource(R.drawable.repw);
                        rep3.setImageResource(R.drawable.reph);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==10) {
                        testLayout.setBackgroundResource(R.drawable.rtest);
                        rep1.setImageResource(R.drawable.repc);
                        rep2.setImageResource(R.drawable.repf);
                        rep3.setImageResource(R.drawable.repr);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==11) {
                        testLayout.setBackgroundResource(R.drawable.bluetest);
                        rep1.setImageResource(R.drawable.repyellow);
                        rep2.setImageResource(R.drawable.repblue);
                        rep3.setImageResource(R.drawable.repblack);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==12) {
                        testLayout.setBackgroundResource(R.drawable.redtest);
                        rep1.setImageResource(R.drawable.repblue);
                        rep2.setImageResource(R.drawable.repred);
                        rep3.setImageResource(R.drawable.repgreen);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==13) {
                        testLayout.setBackgroundResource(R.drawable.yellowtest);
                        rep1.setImageResource(R.drawable.repgreen);
                        rep2.setImageResource(R.drawable.reporange);
                        rep3.setImageResource(R.drawable.repyellow);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==14) {
                        testLayout.setBackgroundResource(R.drawable.pinktest);
                        rep1.setImageResource(R.drawable.repwhite);
                        rep2.setImageResource(R.drawable.repred);
                        rep3.setImageResource(R.drawable.reppink);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==15) {
                        testLayout.setBackgroundResource(R.drawable.orangetest);
                        rep1.setImageResource(R.drawable.reporange);
                        rep2.setImageResource(R.drawable.repyellow);
                        rep3.setImageResource(R.drawable.reppink);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==16) {
                        testLayout.setBackgroundResource(R.drawable.circletest);
                        rep1.setImageResource(R.drawable.reppie);
                        rep2.setImageResource(R.drawable.repcirlce);
                        rep3.setImageResource(R.drawable.reppentagon);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==17) {
                        testLayout.setBackgroundResource(R.drawable.squaretest);
                        rep1.setImageResource(R.drawable.repsquare);
                        rep2.setImageResource(R.drawable.reprectangle);
                        rep3.setImageResource(R.drawable.repstar);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==18) {
                        testLayout.setBackgroundResource(R.drawable.triangletest);
                        rep1.setImageResource(R.drawable.reppentagon);
                        rep2.setImageResource(R.drawable.repcube);
                        rep3.setImageResource(R.drawable.reptriangle);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==19) {
                        testLayout.setBackgroundResource(R.drawable.pentagontest);
                        rep1.setImageResource(R.drawable.reppentagon);
                        rep2.setImageResource(R.drawable.reprectangle);
                        rep3.setImageResource(R.drawable.repstar);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==20) {
                        testLayout.setBackgroundResource(R.drawable.cubetest);
                        rep1.setImageResource(R.drawable.repellispe);
                        rep2.setImageResource(R.drawable.repcube);
                        rep3.setImageResource(R.drawable.repstar);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==21) {
                        SharedPreferences emailPrefs = getActivity().getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor prefEditor = emailPrefs.edit();
                        prefEditor.putInt("mark", mark);
                        prefEditor.commit();
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer, new ExamenFragment()).commit();
                    }
                    i=0;
                    break;

                default:
                    break;
            }
            return true;
        }
    }

}
