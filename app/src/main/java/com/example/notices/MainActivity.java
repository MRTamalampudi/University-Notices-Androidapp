package com.example.notices;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView rgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgu= findViewById(R.id.imageView);

        int SPLASH_SCREEN = 1500;
        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                if (connection()) {
                    Intent intent=new Intent(MainActivity.this,home.class);
                    ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,rgu,"rgu");
                    startActivity(intent,options.toBundle());
                }
                else {
                    Intent intent=new Intent(MainActivity.this,nointernet.class);
                    startActivity(intent);
                }
            }
        },SPLASH_SCREEN);
    }
    public boolean connection(){
        ConnectivityManager connectivityManager= (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!= null && networkInfo.isConnectedOrConnecting()){
            return true;
        }
        else {
            return false;
        }
    }
}