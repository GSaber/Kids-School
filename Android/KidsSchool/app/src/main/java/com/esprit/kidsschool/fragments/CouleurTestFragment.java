package com.esprit.kidsschool.fragments;


import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
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
import android.widget.Toast;

import com.esprit.kidsschool.R;

import static com.facebook.FacebookSdk.getApplicationContext;

public class CouleurTestFragment extends Fragment {

    private int i=0;
    private int count=1;
    private ImageView rep1,rep2,rep3;
    private static final String IMAGEVIEW_TAG = "incorrect";
    private static final String IMAGEVIEW_TAG1 = "correct";
    private FrameLayout testLayout;
    private View dragView;
    private ImageButton btnBack;

    public CouleurTestFragment() {
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
        View view = inflater.inflate(R.layout.fragment_couleur_test, container, false);

        rep1 = (ImageView)view.findViewById(R.id.couleur_rep1);
        rep2 = (ImageView)view.findViewById(R.id.couleur_rep2);
        rep3 = (ImageView)view.findViewById(R.id.couleur_rep3);

        // Sets the tag
        rep1.setTag(IMAGEVIEW_TAG);
        rep2.setTag(IMAGEVIEW_TAG1);
        rep3.setTag(IMAGEVIEW_TAG);

        testLayout = (FrameLayout) view.findViewById(R.id.couleur_test_layout);
        // set the listener to the dragging data
        rep1.setOnLongClickListener(new MyClickListener());
        rep2.setOnLongClickListener(new MyClickListener());
        rep3.setOnLongClickListener(new MyClickListener());
        view.findViewById(R.id.couleur_rep_layout).setOnDragListener(new MyDragListener());
        view.findViewById(R.id.couleur_drop_layout).setOnDragListener(new MyDragListener());
        view.findViewById(R.id.couleur_test_layout).setOnDragListener(new MyDragListener());

        btnBack = (ImageButton) view.findViewById(R.id.btn_back_couleurtest);
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
                    // if the view is the drop_layout, we accept the drag item
                    if ((v == v.findViewById(R.id.couleur_drop_layout)) && i == 1) {
                        System.out.println("1");

                        dragView = (View) event.getLocalState();
                        if(count==1) {
                            testLayout.setBackgroundResource(R.drawable.redcorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            // Execute some code after 2 seconds have passed
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.orangetest);
                                    rep1.setImageResource(R.drawable.reporange);
                                    rep2.setImageResource(R.drawable.repyellow);
                                    rep3.setImageResource(R.drawable.reppink);
                                    rep1.setTag(IMAGEVIEW_TAG1);
                                    rep2.setTag(IMAGEVIEW_TAG);
                                    rep3.setTag(IMAGEVIEW_TAG);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==2) {
                            testLayout.setBackgroundResource(R.drawable.orangecorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.bluetest);
                                    rep1.setImageResource(R.drawable.repyellow);
                                    rep2.setImageResource(R.drawable.repblue);
                                    rep3.setImageResource(R.drawable.repblack);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG1);
                                    rep3.setTag(IMAGEVIEW_TAG);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==3) {
                            testLayout.setBackgroundResource(R.drawable.bluecorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.pinktest);
                                    rep1.setImageResource(R.drawable.repwhite);
                                    rep2.setImageResource(R.drawable.repred);
                                    rep3.setImageResource(R.drawable.reppink);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG);
                                    rep3.setTag(IMAGEVIEW_TAG1);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==4) {
                            testLayout.setBackgroundResource(R.drawable.pinkcorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.yellowtest);
                                    rep1.setImageResource(R.drawable.repgreen);
                                    rep2.setImageResource(R.drawable.reporange);
                                    rep3.setImageResource(R.drawable.repyellow);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG);
                                    rep3.setTag(IMAGEVIEW_TAG1);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==5) {
                            testLayout.setBackgroundResource(R.drawable.yellowcorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new MenuFragment()).commit();
                                }
                            }, 3000);
                        }
                        count++;

                    } else if ((v == v.findViewById(R.id.couleur_test_layout))) {
                        System.out.println("2");
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "You can't drop the image here", Toast.LENGTH_LONG).show();

                    } else if ((v == v.findViewById(R.id.couleur_drop_layout)) && i == 0) {
                        System.out.println("3");
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Bad answer", Toast.LENGTH_LONG).show();

                    } else {
                        System.out.println("4");
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "You can't drop the image here", Toast.LENGTH_LONG).show();

                    }
                    break;

                //the drag and drop operation has concluded.
                case DragEvent.ACTION_DRAG_ENDED:
                    i=0;
                    break;

                default:
                    break;
            }
            return true;
        }
    }

}
