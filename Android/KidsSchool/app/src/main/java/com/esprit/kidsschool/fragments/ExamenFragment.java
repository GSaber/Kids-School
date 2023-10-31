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

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.esprit.kidsschool.MainActivity;
import com.esprit.kidsschool.R;
import com.esprit.kidsschool.adapters.childrenAdapter;
import com.esprit.kidsschool.entities.Children;
import com.facebook.Profile;

import java.util.ArrayList;
import java.util.Collections;

import static android.R.attr.defaultValue;
import static android.content.Context.MODE_PRIVATE;

public class ExamenFragment extends Fragment {


    private int i=0;
    private int count=1;
    private int count2=1;
    private int mark=0;
    private int position;
    ArrayList<Integer> list = new ArrayList<Integer>();
    final Profile profile=Profile.getCurrentProfile();
    private ArrayList<Children>childrens;
    private ImageView rep1,rep2,rep3;
    private static final String IMAGEVIEW_TAG = "incorrect";
    private static final String IMAGEVIEW_TAG1 = "correct";
    private FrameLayout testLayout;
    private View dragView;
    public static final String PREF_Result = "FinalMark";
    private ImageButton btnBack;
    private TextView tvName;
    private String stName;

    public ExamenFragment() {
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
        View view = inflater.inflate(R.layout.fragment_examen, container, false);

        SharedPreferences settings = getActivity().getSharedPreferences(ExamenBisFragment.PREF_NAME, MODE_PRIVATE);
        mark = settings.getInt("mark",defaultValue);

        SharedPreferences settings2 = getActivity().getSharedPreferences(SettingFragment.PREF_NAME, MODE_PRIVATE);
        position = settings2.getInt("position",defaultValue);

        System.out.println(mark);
        System.out.println(position);

        for (int i=2; i<11; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        tvName = (TextView) view.findViewById(R.id.tv_name_exam);

        if(profile!=null){

            SharedPreferences settings3 = getActivity().getSharedPreferences(SettingFragment.PREF_NAME, MODE_PRIVATE);
            stName=settings3.getString("nom", "");
            tvName.setText(settings3.getString("nom", ""));

            String whereClause = "idParent = "+profile.getId();
            BackendlessDataQuery dataQuery = new BackendlessDataQuery();
            dataQuery.setWhereClause( whereClause );

            Backendless.Persistence.of( Children.class).find(dataQuery,new AsyncCallback<BackendlessCollection<Children>>(){
                @Override
                public void handleResponse( BackendlessCollection<Children> foundContacts )
                {
                    System.out.println(foundContacts.getData().size());
                    childrens= (ArrayList<Children>) foundContacts.getData();

                }
                @Override
                public void handleFault( BackendlessFault fault )
                {
                    System.out.println("connection failed !!!");
                    System.out.println(fault.getMessage());
                    // an error has occurred, the error code can be retrieved with fault.getCode()
                }
            });

        }else{
            stName="";
            tvName.setText("");
        }

        rep1 = (ImageView)view.findViewById(R.id.examen_rep1);
        rep2 = (ImageView)view.findViewById(R.id.examen_rep2);
        rep3 = (ImageView)view.findViewById(R.id.examen_rep3);

        // Sets the tag
        rep1.setTag(IMAGEVIEW_TAG1);
        rep2.setTag(IMAGEVIEW_TAG);
        rep3.setTag(IMAGEVIEW_TAG);

        testLayout = (FrameLayout) view.findViewById(R.id.examen_layout);
        // set the listener to the dragging data
        rep1.setOnLongClickListener(new ExamenFragment.MyClickListener());
        rep2.setOnLongClickListener(new ExamenFragment.MyClickListener());
        rep3.setOnLongClickListener(new ExamenFragment.MyClickListener());
        view.findViewById(R.id.examen_rep_layout).setOnDragListener(new ExamenFragment.MyDragListener());
        view.findViewById(R.id.examen_drop_layout).setOnDragListener(new ExamenFragment.MyDragListener());
        view.findViewById(R.id.examen_layout).setOnDragListener(new ExamenFragment.MyDragListener());

        btnBack = (ImageButton) view.findViewById(R.id.btn_back_exam);
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
                    if ((v == v.findViewById(R.id.examen_drop_layout)) && i == 1) {
                        mark++;
                        count++;
                        System.out.println("count="+count);

                    } else if ((v == v.findViewById(R.id.examen_layout))) {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), "You can't drop the image here", Toast.LENGTH_LONG).show();

                    } else if ((v == v.findViewById(R.id.examen_drop_layout)) && i == 0) {
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
                    if(count-2 >= 0) {
                    if(list.size()>count-2){
                        count2=list.get(count-2);
                    }
                    else if(list.size()==count-2){
                        count2=11;
                    }}
                    System.out.println("count2="+count2);
                    dragView = (View) event.getLocalState();
                    if(count2==2) {
                        testLayout.setBackgroundResource(R.drawable.ankylosaurustest);
                        rep1.setImageResource(R.drawable.repvelociraptor);
                        rep2.setImageResource(R.drawable.repkentrosaurus);
                        rep3.setImageResource(R.drawable.repankylosaurus);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==3) {
                        testLayout.setBackgroundResource(R.drawable.stegosaurustest);
                        rep1.setImageResource(R.drawable.repmesosaurus);
                        rep2.setImageResource(R.drawable.repstegosaurus);
                        rep3.setImageResource(R.drawable.reptriceratops);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==4) {
                        testLayout.setBackgroundResource(R.drawable.pteranodontest);
                        rep1.setImageResource(R.drawable.reptyrannosaurus);
                        rep2.setImageResource(R.drawable.repsaurolophus);
                        rep3.setImageResource(R.drawable.reppteranodon);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==5) {
                        testLayout.setBackgroundResource(R.drawable.mesosaurustest);
                        rep1.setImageResource(R.drawable.repmesosaurus);
                        rep2.setImageResource(R.drawable.repvelociraptor);
                        rep3.setImageResource(R.drawable.repsaurolophus);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==6) {
                        testLayout.setBackgroundResource(R.drawable.twotest);
                        rep1.setImageResource(R.drawable.repone);
                        rep2.setImageResource(R.drawable.reptwo);
                        rep3.setImageResource(R.drawable.repthree);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG1);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==7) {
                        testLayout.setBackgroundResource(R.drawable.threetest);
                        rep1.setImageResource(R.drawable.repthree);
                        rep2.setImageResource(R.drawable.repnine);
                        rep3.setImageResource(R.drawable.repfour);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==8) {
                        testLayout.setBackgroundResource(R.drawable.fourtest);
                        rep1.setImageResource(R.drawable.repthree);
                        rep2.setImageResource(R.drawable.repfive);
                        rep3.setImageResource(R.drawable.repfour);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==9) {
                        testLayout.setBackgroundResource(R.drawable.fivetest);
                        rep1.setImageResource(R.drawable.repfive);
                        rep2.setImageResource(R.drawable.repsix);
                        rep3.setImageResource(R.drawable.repeight);
                        rep1.setTag(IMAGEVIEW_TAG1);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==10) {
                        testLayout.setBackgroundResource(R.drawable.seventest);
                        rep1.setImageResource(R.drawable.repnine);
                        rep2.setImageResource(R.drawable.repsix);
                        rep3.setImageResource(R.drawable.repseven);
                        rep1.setTag(IMAGEVIEW_TAG);
                        rep2.setTag(IMAGEVIEW_TAG);
                        rep3.setTag(IMAGEVIEW_TAG1);
                        dragView.setVisibility(View.VISIBLE);

                    } else if(count2==11) {
                        System.out.println("mark="+mark);

                        if(profile!=null && !stName.equals("")) {
                            final Children child = childrens.get(position);
                            child.setNote(Integer.toString(mark));
                            Backendless.Persistence.save(child, new AsyncCallback<Children>() {

                                public void handleResponse(Children response) {

                                }

                                public void handleFault(BackendlessFault fault) {
                                    Toast.makeText(getActivity(), "Connection Failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        SharedPreferences emailPrefs = getActivity().getSharedPreferences(PREF_Result, MODE_PRIVATE);
                        SharedPreferences.Editor prefEditor = emailPrefs.edit();
                        prefEditor.putInt("fmark", mark);
                        prefEditor.commit();
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer, new ResultExamFragment()).commit();
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
