package com.example.nacjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToEx1(View v) {
        Intent intent = new Intent(this, Ex1.class);
        startActivity(intent);
    }

    public void goToEx2(View v) {
        Intent intent = new Intent(this, Ex2.class);
        startActivity(intent);
    }
}