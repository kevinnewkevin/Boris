package com.example.mrmishka.lukoile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        Thread thread = new Thread() {
            @Override
            public void run() {

                try {

                    sleep(1000);
                    Intent intent = new Intent(FullscreenActivity.this, Category.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }

}



