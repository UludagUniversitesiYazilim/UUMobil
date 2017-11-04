package com.example.berkay.uumobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img = (ImageView) findViewById(R.id.splash_image);
    }

    public void stopThis(View view){
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);;
        startActivity(intent);
        this.finish();
    }
}
