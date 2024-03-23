package com.example.kimiexplorerprojectvn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnPlay,btnHTPlay;
    VideoView vVbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPlay = findViewById(R.id.btnPlay);
        btnHTPlay = findViewById(R.id.btnTutorial);
        vVbackground = findViewById(R.id.vVbackground);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.bg_home;
        Uri u = Uri.parse(path);
        vVbackground.setVideoURI(u);

        vVbackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vVbackground.start();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, gameplay_activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btnHTPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HowToPlay.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onPostResume(){
        vVbackground.resume();
        super.onPostResume();
    }

    @Override
    protected void onPause(){
        vVbackground.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        vVbackground.stopPlayback();
        super.onDestroy();
    }

}
