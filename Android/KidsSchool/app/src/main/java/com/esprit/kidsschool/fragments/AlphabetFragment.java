package com.esprit.kidsschool.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.esprit.kidsschool.R;

import java.util.ArrayList;

public class AlphabetFragment extends Fragment {


    private ImageButton nextElement,backElement,replay,btnBack;
    private ImageView imgTableau;
    MediaPlayer mp;
    private int i=1;

    DrawingView dv ;
    private Paint mPaint;

    public AlphabetFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alphabet, container, false);
        mp = MediaPlayer.create(getActivity(), R.raw.a);
        mp.start();

        //FrameLayout mtile2 = (FrameLayout) view.findViewById(R.id.mtile);
        RelativeLayout mtile = (RelativeLayout) view.findViewById(R.id.tableau_alphabet);
       // dv = new DrawingView(view.getContext());
        //mtile.addView(dv);
        //FrameLayout rvtrans=new FrameLayout(view.getContext());
        //rvtrans.setBackgroundResource(R.drawable.a);
        //mtile.addView(rvtrans);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);

        nextElement = (ImageButton) view.findViewById(R.id.btn_next_element);
        backElement = (ImageButton) view.findViewById(R.id.btn_back_element);
        replay = (ImageButton) view.findViewById(R.id.btn_replay);
        btnBack = (ImageButton) view.findViewById(R.id.btn_back_alphabet);
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
                if(i==27){
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, new AlphabetTestFragment()).addToBackStack(null).commit();
                }

                switch (i){
                    case 1:
                        imgTableau.setBackgroundResource(R.drawable.a);
                        mp = MediaPlayer.create(getActivity(), R.raw.a);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.b);
                        mp = MediaPlayer.create(getActivity(), R.raw.b);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.c);
                        mp = MediaPlayer.create(getActivity(), R.raw.c);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.d);
                        mp = MediaPlayer.create(getActivity(), R.raw.d);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.e);
                        mp = MediaPlayer.create(getActivity(), R.raw.e);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.f);
                        mp = MediaPlayer.create(getActivity(), R.raw.f);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.g);
                        mp = MediaPlayer.create(getActivity(), R.raw.g);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.h);
                        mp = MediaPlayer.create(getActivity(), R.raw.h);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.i);
                        mp = MediaPlayer.create(getActivity(), R.raw.i);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.j);
                        mp = MediaPlayer.create(getActivity(), R.raw.j);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.k);
                        mp = MediaPlayer.create(getActivity(), R.raw.k);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.l);
                        mp = MediaPlayer.create(getActivity(), R.raw.l);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.m);
                        mp = MediaPlayer.create(getActivity(), R.raw.m);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.n);
                        mp = MediaPlayer.create(getActivity(), R.raw.n);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.o);
                        mp = MediaPlayer.create(getActivity(), R.raw.o);
                        mp.start();
                        break;
                    case 16:
                        imgTableau.setBackgroundResource(R.drawable.p);
                        mp = MediaPlayer.create(getActivity(), R.raw.p);
                        mp.start();
                        break;
                    case 17:
                        imgTableau.setBackgroundResource(R.drawable.q);
                        mp = MediaPlayer.create(getActivity(), R.raw.q);
                        mp.start();
                        break;
                    case 18:
                        imgTableau.setBackgroundResource(R.drawable.r);
                        mp = MediaPlayer.create(getActivity(), R.raw.r);
                        mp.start();
                        break;
                    case 19:
                        imgTableau.setBackgroundResource(R.drawable.s);
                        mp = MediaPlayer.create(getActivity(), R.raw.s);
                        mp.start();
                        break;
                    case 20:
                        imgTableau.setBackgroundResource(R.drawable.t);
                        mp = MediaPlayer.create(getActivity(), R.raw.t);
                        mp.start();
                        break;
                    case 21:
                        imgTableau.setBackgroundResource(R.drawable.u);
                        mp = MediaPlayer.create(getActivity(), R.raw.u);
                        mp.start();
                        break;
                    case 22:
                        imgTableau.setBackgroundResource(R.drawable.v);
                        mp = MediaPlayer.create(getActivity(), R.raw.v);
                        mp.start();
                        break;
                    case 23:
                        imgTableau.setBackgroundResource(R.drawable.w);
                        mp = MediaPlayer.create(getActivity(), R.raw.w);
                        mp.start();
                        break;
                    case 24:
                        imgTableau.setBackgroundResource(R.drawable.x);
                        mp = MediaPlayer.create(getActivity(), R.raw.x);
                        mp.start();
                        break;
                    case 25:
                        imgTableau.setBackgroundResource(R.drawable.y);
                        mp = MediaPlayer.create(getActivity(), R.raw.y);
                        mp.start();
                        break;
                    case 26:
                        imgTableau.setBackgroundResource(R.drawable.z);
                        mp = MediaPlayer.create(getActivity(), R.raw.z);
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
                        imgTableau.setBackgroundResource(R.drawable.a);
                        mp = MediaPlayer.create(getActivity(), R.raw.a);
                        mp.start();
                        break;
                    case 2:
                        imgTableau.setBackgroundResource(R.drawable.b);
                        mp = MediaPlayer.create(getActivity(), R.raw.b);
                        mp.start();
                        break;
                    case 3:
                        imgTableau.setBackgroundResource(R.drawable.c);
                        mp = MediaPlayer.create(getActivity(), R.raw.c);
                        mp.start();
                        break;
                    case 4:
                        imgTableau.setBackgroundResource(R.drawable.d);
                        mp = MediaPlayer.create(getActivity(), R.raw.d);
                        mp.start();
                        break;
                    case 5:
                        imgTableau.setBackgroundResource(R.drawable.e);
                        mp = MediaPlayer.create(getActivity(), R.raw.e);
                        mp.start();
                        break;
                    case 6:
                        imgTableau.setBackgroundResource(R.drawable.f);
                        mp = MediaPlayer.create(getActivity(), R.raw.f);
                        mp.start();
                        break;
                    case 7:
                        imgTableau.setBackgroundResource(R.drawable.g);
                        mp = MediaPlayer.create(getActivity(), R.raw.g);
                        mp.start();
                        break;
                    case 8:
                        imgTableau.setBackgroundResource(R.drawable.h);
                        mp = MediaPlayer.create(getActivity(), R.raw.h);
                        mp.start();
                        break;
                    case 9:
                        imgTableau.setBackgroundResource(R.drawable.i);
                        mp = MediaPlayer.create(getActivity(), R.raw.i);
                        mp.start();
                        break;
                    case 10:
                        imgTableau.setBackgroundResource(R.drawable.j);
                        mp = MediaPlayer.create(getActivity(), R.raw.j);
                        mp.start();
                        break;
                    case 11:
                        imgTableau.setBackgroundResource(R.drawable.k);
                        mp = MediaPlayer.create(getActivity(), R.raw.k);
                        mp.start();
                        break;
                    case 12:
                        imgTableau.setBackgroundResource(R.drawable.l);
                        mp = MediaPlayer.create(getActivity(), R.raw.l);
                        mp.start();
                        break;
                    case 13:
                        imgTableau.setBackgroundResource(R.drawable.m);
                        mp = MediaPlayer.create(getActivity(), R.raw.m);
                        mp.start();
                        break;
                    case 14:
                        imgTableau.setBackgroundResource(R.drawable.n);
                        mp = MediaPlayer.create(getActivity(), R.raw.n);
                        mp.start();
                        break;
                    case 15:
                        imgTableau.setBackgroundResource(R.drawable.o);
                        mp = MediaPlayer.create(getActivity(), R.raw.o);
                        mp.start();
                        break;
                    case 16:
                        imgTableau.setBackgroundResource(R.drawable.p);
                        mp = MediaPlayer.create(getActivity(), R.raw.p);
                        mp.start();
                        break;
                    case 17:
                        imgTableau.setBackgroundResource(R.drawable.q);
                        mp = MediaPlayer.create(getActivity(), R.raw.q);
                        mp.start();
                        break;
                    case 18:
                        imgTableau.setBackgroundResource(R.drawable.r);
                        mp = MediaPlayer.create(getActivity(), R.raw.r);
                        mp.start();
                        break;
                    case 19:
                        imgTableau.setBackgroundResource(R.drawable.s);
                        mp = MediaPlayer.create(getActivity(), R.raw.s);
                        mp.start();
                        break;
                    case 20:
                        imgTableau.setBackgroundResource(R.drawable.t);
                        mp = MediaPlayer.create(getActivity(), R.raw.t);
                        mp.start();
                        break;
                    case 21:
                        imgTableau.setBackgroundResource(R.drawable.u);
                        mp = MediaPlayer.create(getActivity(), R.raw.u);
                        mp.start();
                        break;
                    case 22:
                        imgTableau.setBackgroundResource(R.drawable.v);
                        mp = MediaPlayer.create(getActivity(), R.raw.v);
                        mp.start();
                        break;
                    case 23:
                        imgTableau.setBackgroundResource(R.drawable.w);
                        mp = MediaPlayer.create(getActivity(), R.raw.w);
                        mp.start();
                        break;
                    case 24:
                        imgTableau.setBackgroundResource(R.drawable.x);
                        mp = MediaPlayer.create(getActivity(), R.raw.x);
                        mp.start();
                        break;
                    case 25:
                        imgTableau.setBackgroundResource(R.drawable.y);
                        mp = MediaPlayer.create(getActivity(), R.raw.y);
                        mp.start();
                        break;
                    case 26:
                        imgTableau.setBackgroundResource(R.drawable.z);
                        mp = MediaPlayer.create(getActivity(), R.raw.z);
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
                        mp = MediaPlayer.create(getActivity(), R.raw.a);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(getActivity(), R.raw.b);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(getActivity(), R.raw.c);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(getActivity(), R.raw.d);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(getActivity(), R.raw.e);
                        mp.start();
                        break;
                    case 6:
                        mp = MediaPlayer.create(getActivity(), R.raw.f);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(getActivity(), R.raw.g);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(getActivity(), R.raw.h);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(getActivity(), R.raw.i);
                        mp.start();
                        break;
                    case 10:
                        mp = MediaPlayer.create(getActivity(), R.raw.j);
                        mp.start();
                        break;
                    case 11:
                        mp = MediaPlayer.create(getActivity(), R.raw.k);
                        mp.start();
                        break;
                    case 12:
                        mp = MediaPlayer.create(getActivity(), R.raw.l);
                        mp.start();
                        break;
                    case 13:
                        mp = MediaPlayer.create(getActivity(), R.raw.m);
                        mp.start();
                        break;
                    case 14:
                        mp = MediaPlayer.create(getActivity(), R.raw.n);
                        mp.start();
                        break;
                    case 15:
                        mp = MediaPlayer.create(getActivity(), R.raw.o);
                        mp.start();
                        break;
                    case 16:
                        mp = MediaPlayer.create(getActivity(), R.raw.p);
                        mp.start();
                        break;
                    case 17:
                        mp = MediaPlayer.create(getActivity(), R.raw.q);
                        mp.start();
                        break;
                    case 18:
                        mp = MediaPlayer.create(getActivity(), R.raw.r);
                        mp.start();
                        break;
                    case 19:
                        mp = MediaPlayer.create(getActivity(), R.raw.s);
                        mp.start();
                        break;
                    case 20:
                        mp = MediaPlayer.create(getActivity(), R.raw.t);
                        mp.start();
                        break;
                    case 21:
                        mp = MediaPlayer.create(getActivity(), R.raw.u);
                        mp.start();
                        break;
                    case 22:
                        mp = MediaPlayer.create(getActivity(), R.raw.v);
                        mp.start();
                        break;
                    case 23:
                        mp = MediaPlayer.create(getActivity(), R.raw.w);
                        mp.start();
                        break;
                    case 24:
                        mp = MediaPlayer.create(getActivity(), R.raw.x);
                        mp.start();
                        break;
                    case 25:
                        mp = MediaPlayer.create(getActivity(), R.raw.y);
                        mp.start();
                        break;
                    case 26:
                        mp = MediaPlayer.create(getActivity(), R.raw.z);
                        mp.start();
                        break;
                }
            }
        });
        return view;
    }


    public class DrawingView extends View {

        public int width;
        public  int height;
        private Bitmap mBitmap;
        private Canvas mCanvas;
        private Path mPath;
        private Paint   mBitmapPaint;
        Context context;
        private Paint circlePaint;
        private Path circlePath;

        public DrawingView(Context c) {
            super(c);
            context=c;
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            circlePaint = new Paint();
            circlePath = new Path();
            circlePaint.setAntiAlias(true);
            circlePaint.setColor(Color.BLUE);
            circlePaint.setStyle(Paint.Style.STROKE);
            circlePaint.setStrokeJoin(Paint.Join.MITER);
            circlePaint.setStrokeWidth(4f);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);

        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
            canvas.drawPath( mPath,  mPaint);
            canvas.drawPath( circlePath,  circlePaint);
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y) {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
            Log.d("start xy==>", x+","+y);
        }
        private void touch_move(float x, float y) {
            Log.d("move xy==>", x+","+y);
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if ((dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)) {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
            /*  circlePath.reset();
                circlePath.addCircle(mX, mY, 30, Path.Direction.CW);*/
            }
        }
        private void touch_up() {
            mPath.lineTo(mX, mY);
            Log.d("end xy", mX+","+mY);
            circlePath.reset();
            // commit the path to our offscreen
            mCanvas.drawPath(mPath,  mPaint);
            // kill this so we don't double draw
            mPath.reset();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;
        }
    }
}
