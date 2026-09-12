package com.example.englishgrammarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.button.MaterialButton;

public class LessonsActivity extends AppCompatActivity {

    MaterialCardView[] lessonCards = new MaterialCardView[8]; // Array for 8 lessons
    MaterialButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons); // make sure this matches your XML filename

        backButton = findViewById(R.id.backButton);

        // Lesson Card IDs
        int[] cardIds = {
                R.id.lesson1, R.id.lesson2, R.id.lesson3, R.id.lesson4,
                R.id.lesson5, R.id.lesson6, R.id.lesson7, R.id.lesson8
        };

        // Assign cards and set click listeners
        for (int i = 0; i < cardIds.length; i++) {
            int lessonNumber = i + 1; // Lesson number
            lessonCards[i] = findViewById(cardIds[i]);
            lessonCards[i].setOnClickListener(v -> {
                // Open TopicsActivity for the clicked lesson
                Intent intent = new Intent(LessonsActivity.this, TopicsActivity.class);
                intent.putExtra("lessonNumber", lessonNumber);
                startActivity(intent);
            });
        }

        // Back button returns to MainActivity
        backButton.setOnClickListener(v -> finish());
    }
}

