package com.example.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.util.Log;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import java.util.Locale;
import java.util.Objects;


public class MainActivity2 extends AppCompatActivity {

    private TextToSpeech mTTS;
    private SeekBar mSeekBarPitch;
    private SeekBar mSeekBarSpeed;
    private EditText text;
    private Button b1;


    private String selectlang;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        setContentView(R.layout.activity_main2);
        TextView recieveedmsg = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");




        b1 = findViewById(R.id.button);





        recieveedmsg.setText("Welcome, "+ str);


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                int result =  mTTS.setLanguage(Locale.UK);
                if (status == TextToSpeech.SUCCESS) {

                    if(selectlang == "UK"){


                        result = mTTS.setLanguage(Locale.UK);}

                    if(selectlang == "US"){

                        result = mTTS.setLanguage(Locale.US);}


                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        b1.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        text = findViewById(R.id.textfield);
        mSeekBarPitch = findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed = findViewById(R.id.seek_bar_speed);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }

        private void speak() {
            String text1 = text.getText().toString();
            float pitch = (float) mSeekBarPitch.getProgress() / 50;
            if (pitch < 0.1) pitch = 0.1f;
            float speed = (float) mSeekBarSpeed.getProgress() / 50;
            if (speed < 0.1) speed = 0.1f;

            mTTS.setPitch(pitch);
            mTTS.setSpeechRate(speed);
            mTTS.speak(text1, TextToSpeech.QUEUE_FLUSH, null);


        }
        @Override
        protected void onDestroy(){
            if (mTTS != null) {
                mTTS.stop();
                mTTS.shutdown();
            }

            super.onDestroy();
        }
        



}

