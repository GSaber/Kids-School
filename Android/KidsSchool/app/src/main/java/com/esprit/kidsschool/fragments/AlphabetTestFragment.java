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

public class AlphabetTestFragment extends Fragment {

    private int i=0;
    private int count=1;
    private ImageView rep1,rep2,rep3;
    private static final String IMAGEVIEW_TAG = "incorrect";
    private static final String IMAGEVIEW_TAG1 = "correct";
    private FrameLayout testLayout;
    private View dragView;
    private ImageButton btnBack;

    public AlphabetTestFragment() {
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
        View view = inflater.inflate(R.layout.fragment_alphabet_test, container, false);

        rep1 = (ImageView)view.findViewById(R.id.img_rep1);
        rep2 = (ImageView)view.findViewById(R.id.img_rep2);
        rep3 = (ImageView)view.findViewById(R.id.img_rep3);

            // Sets the tag
        rep1.setTag(IMAGEVIEW_TAG);
        rep2.setTag(IMAGEVIEW_TAG);
        rep3.setTag(IMAGEVIEW_TAG1);

        testLayout = (FrameLayout) view.findViewById(R.id.alphabet_test_layout);
        // set the listener to the dragging data
        rep1.setOnLongClickListener(new MyClickListener());
        rep2.setOnLongClickListener(new MyClickListener());
        rep3.setOnLongClickListener(new MyClickListener());
        view.findViewById(R.id.toplinear).setOnDragListener(new MyDragListener());
        view.findViewById(R.id.bottomlinear).setOnDragListener(new MyDragListener());
        view.findViewById(R.id.test).setOnDragListener(new MyDragListener());
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_alphabettest);
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
                    if ((v == v.findViewById(R.id.bottomlinear)) && i == 1) {

                        dragView = (View) event.getLocalState();
                        if(count==1) {
                            testLayout.setBackgroundResource(R.drawable.ccorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            // Execute some code after 2 seconds have passed
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.atest);
                                    rep1.setImageResource(R.drawable.repd);
                                    rep2.setImageResource(R.drawable.repa);
                                    rep3.setImageResource(R.drawable.repg);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG1);
                                    rep3.setTag(IMAGEVIEW_TAG);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==2) {
                            testLayout.setBackgroundResource(R.drawable.acorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.rtest);
                                    rep1.setImageResource(R.drawable.repc);
                                    rep2.setImageResource(R.drawable.repf);
                                    rep3.setImageResource(R.drawable.repr);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG);
                                    rep3.setTag(IMAGEVIEW_TAG1);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==3) {
                            testLayout.setBackgroundResource(R.drawable.rcorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.btest);
                                    rep1.setImageResource(R.drawable.repb);
                                    rep2.setImageResource(R.drawable.repw);
                                    rep3.setImageResource(R.drawable.repa);
                                    rep1.setTag(IMAGEVIEW_TAG1);
                                    rep2.setTag(IMAGEVIEW_TAG);
                                    rep3.setTag(IMAGEVIEW_TAG);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==4) {
                            testLayout.setBackgroundResource(R.drawable.bcorrect);
                            Context context = getApplicationContext();
                            Toast.makeText(context, "Good answer", Toast.LENGTH_LONG).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    testLayout.setBackgroundResource(R.drawable.wtest);
                                    rep1.setImageResource(R.drawable.repv);
                                    rep2.setImageResource(R.drawable.repw);
                                    rep3.setImageResource(R.drawable.reph);
                                    rep1.setTag(IMAGEVIEW_TAG);
                                    rep2.setTag(IMAGEVIEW_TAG1);
                                    rep3.setTag(IMAGEVIEW_TAG);
                                    dragView.setVisibility(View.VISIBLE);
                                }
                            }, 3000);

                        } else if(count==5) {
                            testLayout.setBackgroundResource(R.drawable.wcorrect);
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

                    } else if ((v == v.findViewById(R.id.test))) {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "You can't drop the image here", Toast.LENGTH_LONG).show();

                    } else if ((v == v.findViewById(R.id.bottomlinear)) && i == 0) {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Bad answer", Toast.LENGTH_LONG).show();

                    } else {
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
