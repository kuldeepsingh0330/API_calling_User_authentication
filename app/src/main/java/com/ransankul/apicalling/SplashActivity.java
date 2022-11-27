package com.ransankul.apicalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottie = findViewById(R.id.lottie);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dap = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(dap);
                finish();

            }
        },5000);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.splash));
    }
}