package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnstartnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstartnow = findViewById(R.id.startnow);

        btnstartnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(MainActivity.this, Login.class);
                startActivity(Login);
            }
        });
    }
}