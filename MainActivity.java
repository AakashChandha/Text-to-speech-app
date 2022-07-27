package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);
        TextView username = (EditText)findViewById(R.id.username);
        TextView password =(EditText) findViewById(R.id.password);
        ImageView googlelink = (ImageView)findViewById(R.id.imageView14);
        ImageView facebooklink = (ImageView)findViewById(R.id.imageView13);
        ImageView instagramlink = (ImageView) findViewById(R.id.imageView15);



        MaterialButton loginbtn = findViewById(R.id.loginbtn);

        //admin and admin
        googlelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://destinedtobeanauthor.blogspot.com/";
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        facebooklink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://facebook.com";
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }

        });

        instagramlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/aakashchandha/?hl=en";
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);

            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernametext = username.getText().toString();
                String passwordtext = password.getText().toString();
                if(usernametext.equals("admin") && passwordtext.equals("admin")){
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("message_key", usernametext);
                    startActivity(intent);


                }else
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}