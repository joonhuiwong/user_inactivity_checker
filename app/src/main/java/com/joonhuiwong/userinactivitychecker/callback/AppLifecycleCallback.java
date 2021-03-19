package com.joonhuiwong.userinactivitychecker.callback;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.joonhuiwong.userinactivitychecker.MainApplication;

public class AppLifecycleCallback implements Application.ActivityLifecycleCallbacks {

    /* My Observations on the lifecycle flow during scenarios.
     *
     *  1. Starting the application
     *  Created -> Started -> Resumed
     *
     *  2. Closing the application
     *  Paused -> Stopped -> Destroyed
     *
     *  3. Go to next activity (A -> B)
     *  Paused(A) -> Created/Started/Resumed(B) -> SaveInstanceState(A) -> Stopped(A)
     *
     *  4. Back to Previous activity (B -> A)
     *  Paused(B) -> Started/Resumed(A) -> Stopped/Destroyed(B)
     *
     *  5. Home Button
     *  Paused -> SaveInstanceState -> Stopped
     *
     *  6. Return
     *  Started -> Resumed
     *
     */
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        MainApplication.getInstance().resetHandler(activity);
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        MainApplication.getInstance().stopHandler();
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
