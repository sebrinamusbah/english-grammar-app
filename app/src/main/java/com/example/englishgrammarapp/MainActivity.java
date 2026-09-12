package com.example.englishgrammarapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    LinearLayout notesLayout, vocabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.mainToolbar); // match the toolbar ID in XML
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back arrow
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish()); // back arrow closes activity/app

        // Find views
        notesLayout = findViewById(R.id.notesLayout);
        vocabLayout = findViewById(R.id.vocabLayout);

        // Click listeners
        notesLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LessonsActivity.class);
            startActivity(intent);
        });

        vocabLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VocabularyTopicsActivity.class);
            startActivity(intent);
        });
    }
}

