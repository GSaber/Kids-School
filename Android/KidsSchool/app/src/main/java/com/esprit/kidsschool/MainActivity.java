package com.esprit.kidsschool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;

import com.backendless.Backendless;
import com.esprit.kidsschool.fragments.MainFragment;
import com.esprit.kidsschool.utils.MyExceptionHandler;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String appVersion = "v1";
        Backendless.initApp(this, "2A27DFB3-9C11-933E-FF45-9E70B3049700","484B7AF0-F587-2811-FFDE-DA81F8F5F100", appVersion );

        setContentView(R.layout.activity_main);

        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this, MainActivity.class));



        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.mainContainer, new MainFragment()).commit();
        }

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        System.exit(0);
                    }
                }).create().show();
    }
}