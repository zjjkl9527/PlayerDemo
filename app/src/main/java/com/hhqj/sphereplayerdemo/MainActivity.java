package com.hhqj.sphereplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import com.hhqj.player.SpherePlayer;
import com.hhqj.player.SphereSurfaceView;


public class MainActivity extends AppCompatActivity {
    private SphereSurfaceView mSphereSurfaceView;
    private SpherePlayer mSpherePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mSphereSurfaceView = findViewById(R.id.ssv);
        mSpherePlayer = new SpherePlayer(mSphereSurfaceView);
        mSpherePlayer.setEventListener(new SpherePlayer.EventListener() {
            @Override
            public void onError(int type, String message) {
                Log.d("MainActivity", message);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mSpherePlayer.play("rtmp://8.131.75.62/live");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSpherePlayer.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSpherePlayer.setGyroEnable(true,this);

    }
}