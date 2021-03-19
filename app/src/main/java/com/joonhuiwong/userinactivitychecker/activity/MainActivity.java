package com.joonhuiwong.userinactivitychecker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.joonhuiwong.userinactivitychecker.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginMenuButton);

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }

}