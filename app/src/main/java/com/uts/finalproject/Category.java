package com.uts.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Category extends AppCompatActivity {

    ImageView backCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backCategory = findViewById(R.id.backCategory);

        Intent getData = getIntent();

    }
}