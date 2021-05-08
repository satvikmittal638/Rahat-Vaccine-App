package com.example.rahatapppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import java.text.Normalizer;

public class SplashScreen extends AppCompatActivity {
TextView tv_head1,tv_subhead1;
ImageView img_logo1;
    private static final String TAG = "SplashScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_head1 = findViewById(R.id.head1);
        tv_subhead1 = findViewById(R.id.subhead1);
        img_logo1 = findViewById(R.id.logo1);
//        animateHeadTxt();

        Runnable r = () -> {
            Intent intent = new Intent(SplashScreen.this, Form_Request.class);
            startActivity(intent);
        };

        Thread thread = new Thread(r);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        thread.start();
        Log.d(TAG, "onCreate: Sign in screen started");

    }

    private void animateHeadTxt(){
        tv_head1.animate().translationYBy(400f).setDuration(2000);
        tv_subhead1.animate().translationYBy(400f).setDuration(2000);
    }
}
