package com.joonhuiwong.userinactivitychecker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.joonhuiwong.userinactivitychecker.activity.BaseActivity;
import com.joonhuiwong.userinactivitychecker.activity.MainActivity;
import com.joonhuiwong.userinactivitychecker.callback.AppLifecycleCallback;

public class MainApplication extends Application {

    public static final String MAIN_ACTIVITY = "MainActivity";

    private static MainApplication instance;

    private Handler handler;
    private Runnable r;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        registerActivityLifecycleCallbacks(new AppLifecycleCallback());

        handler = new Handler(Looper.getMainLooper());
        r = new Runnable() {

            @Override
            public void run() {
                stopHandler();

                if (BuildConfig.DEBUG) {
                    Log.d("TAG", "Logged out due to inactivity.");
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public void stopHandler() {
        handler.removeCallbacks(r);
    }

    public void startHandler() {
        //handler.postDelayed(r, (5 * 1000 * 60)); // 5 Min - Change this for testing/trying it out.
        handler.postDelayed(r, (5 * 1000)); // 5 Sec
    }

    public void resetHandler(Context context) {
        stopHandler();

        String className = context.getClass().getSimpleName();
        if (!className.equals(MAIN_ACTIVITY)) {
            startHandler();
        }
    }
}
