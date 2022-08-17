package com.welcome.javaquizupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// exception handling
// different modules like java , cpp , python then start quizes each having 10 qestions

public class MainActivity extends AppCompatActivity {
    public Button javaBtn, pythonBtn, cppBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        javaBtn = findViewById(R.id.idBtnJava);
        pythonBtn = findViewById(R.id.idBtnPython);
        cppBtn = findViewById(R.id.idBtnCpp);
        try {
            javaBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //goto another class
                    Intent i = new Intent(MainActivity.this, FirstActivity.class);
                    startActivity(i);
                }
            });
            pythonBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //goto another class
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            });
            cppBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //goto another class

                    Toast.makeText(getApplicationContext(), "NO quiz in this category currently", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
        }
    }

}