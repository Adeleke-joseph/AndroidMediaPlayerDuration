package com.axionteq.androidmediaplayerduration;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tvAudioTimer;
    MediaPlayer mediaPlayer;
    String strUrl;
    Toolbar toolbar;
    EditText etMediaUrl;
    Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        tvAudioTimer = findViewById( R.id.tv_media_duration );
        etMediaUrl = findViewById( R.id.et_media );
        btnDisplay = findViewById( R.id.btn_display );
        toolbar = findViewById( R.id.toolbar );

        setSupportActionBar( toolbar );
        mediaPlayer = new MediaPlayer();

        btnDisplay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strUrl = String.valueOf( etMediaUrl );
                try {
                    mediaPlayer.setDataSource( strUrl );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String v = String.valueOf( mediaPlayer.getDuration() );
                tvAudioTimer.setText( v );
            }
        } );
    }
}