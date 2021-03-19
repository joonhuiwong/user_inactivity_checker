package com.joonhuiwong.userinactivitychecker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.joonhuiwong.userinactivitychecker.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginAccountButton);

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
            startActivity(intent);
        });
    }
}