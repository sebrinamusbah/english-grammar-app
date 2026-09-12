package com.example.englishgrammarapp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

public class VocabularyTopicsActivity extends AppCompatActivity {

    LinearLayout btnPhrases, btnIdioms, btnSynonyms, btnHomophones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_topics);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back arrow
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish()); // handle back click

        // Buttons
        btnPhrases = findViewById(R.id.btnPhrases);
        btnIdioms = findViewById(R.id.btnIdioms);
        btnSynonyms = findViewById(R.id.btnSynonyms);
        btnHomophones = findViewById(R.id.btnHomophones);

        View.OnClickListener topicClick = v -> {
            String topic = "";
            if (v.getId() == R.id.btnPhrases) topic = "Phrases";
            else if (v.getId() == R.id.btnIdioms) topic = "Idioms";
            else if (v.getId() == R.id.btnSynonyms) topic = "Synonyms";
            else if (v.getId() == R.id.btnHomophones) topic = "Homophones";

            Intent intent = new Intent(VocabularyTopicsActivity.this, VocabularyWordsActivity.class);
            intent.putExtra("topic", topic);
            startActivity(intent);
        };

        btnPhrases.setOnClickListener(topicClick);
        btnIdioms.setOnClickListener(topicClick);
        btnSynonyms.setOnClickListener(topicClick);
        btnHomophones.setOnClickListener(topicClick);
    }
}
