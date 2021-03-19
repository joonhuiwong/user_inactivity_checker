package com.joonhuiwong.userinactivitychecker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.joonhuiwong.userinactivitychecker.BuildConfig;
import com.joonhuiwong.userinactivitychecker.MainApplication;
import com.joonhuiwong.userinactivitychecker.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        MainApplication.getInstance().resetHandler(this);
    }



}
