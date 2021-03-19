package com.joonhuiwong.userinactivitychecker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.joonhuiwong.userinactivitychecker.BuildConfig;
import com.joonhuiwong.userinactivitychecker.R;

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "BaseActivity";
    public static final String HOME_ACTIVITY_NAME = "MainActivity";

    private Handler handler;
    private Runnable r;
    private boolean inactive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inactive = false;
        handler = new Handler(Looper.getMainLooper());
        r = new Runnable() {

            @Override
            public void run() {
                inactive = true;

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "Logged out due to inactivity.");
                }

                finish();
            }
        };

        String className = this.getClass().getSimpleName();
        if (!className.equals(HOME_ACTIVITY_NAME)) {
            startHandler();
        }
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        // Reset the Handler
        stopHandler();
        String className = this.getClass().getSimpleName();
        if (!inactive && !className.equals(HOME_ACTIVITY_NAME)) {
            startHandler();
        }
    }

    public void stopHandler() {
        handler.removeCallbacks(r);
    }

    public void startHandler() {
        //handler.postDelayed(r, (5 * 1000 * 60)); // 5 Min - Change this for testing/trying it out.
        handler.postDelayed(r, (5 * 1000)); // 5 Sec
    }

}
