package com.example.englishgrammarapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class TopicsActivity extends AppCompatActivity {

    private GridLayout topicsLayout;
    private TextView titleTopicTextView;
    private MaterialButton backButton;

    // Topics data for each lesson
    private String[][] lessonTopics = {
            { "Nouns", "Pronouns", "Verbs", "Adjectives", "Adverbs" },
            { "Simple Sentences", "Compound Sentences", "Complex Sentences", "Subject and Predicate", "Questions and Negatives" },
            { "Present Simple and Continuous", "Past Simple and Continuous", "Future Simple Tense", "Present Perfect" },
            { "Indefinite Articles", "Definite Article", "Demonstratives", "Quantifiers" },
            { "Modals", "Using 'Do/Does/Did'", "Expressing Ability"},
            { "Active Voice", "Passive Voice","Active Voice and Passive Voice"},
            { "Zero Conditional", "First Conditional", "Second Conditional", "Reported Speech", "Indirect Speech" },
            { "Punctuation Marks", "Capitalization Rules", "Writing Short Paragraphs", "Simple Dialogue Practice" }
    };

    private String[] lessonTitles = {
            "Parts of Speech",
            "Sentence Structure",
            "Tenses",
            "Articles & Determiners",
            "Modals & Auxiliary Verbs",
            "Voice",
            "Conditionals & Reported Speech",
            "Punctuation & Writing Skills"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        topicsLayout = findViewById(R.id.topicsLayout);
        titleTopicTextView = findViewById(R.id.title_topic);
        backButton = findViewById(R.id.backButton);

        int lessonNumber = getIntent().getIntExtra("lessonNumber", 1);
        titleTopicTextView.setText(lessonTitles[lessonNumber - 1]);

        String[] topics = lessonTopics[lessonNumber - 1];

        for (String topic : topics) {
            // Container for icon + text
            // Container for icon + text
            LinearLayout topicContainer = new LinearLayout(this);
            topicContainer.setOrientation(LinearLayout.VERTICAL);
            topicContainer.setGravity(Gravity.CENTER);

// GridLayout params
            GridLayout.LayoutParams containerParams = new GridLayout.LayoutParams();
            containerParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
            containerParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
            containerParams.setMargins(16, 16, 16, 16);
            topicContainer.setLayoutParams(containerParams);

// ImageButton (fixed size)
            ImageButton topicButton = new ImageButton(this);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(250, 250);
            buttonParams.gravity = Gravity.CENTER;
            topicButton.setLayoutParams(buttonParams);
            topicButton.setImageResource(R.drawable.ic_topic);
            topicButton.setBackgroundColor(Color.TRANSPARENT);
            topicButton.setScaleType(ImageButton.ScaleType.CENTER_CROP);

// Text below icon (wraps text without cutting image)
            TextView topicText = new TextView(this);
            topicText.setText(topic);
            topicText.setTextSize(16f);
            topicText.setTextColor(Color.BLACK);
            topicText.setGravity(Gravity.CENTER);
            topicText.setPadding(0, 8, 0, 0);

// THIS IS IMPORTANT: allow multi-line text
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    250,  // same width as ImageButton
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            textParams.gravity = Gravity.CENTER;
            topicText.setLayoutParams(textParams);
            topicText.setSingleLine(false);
            topicText.setEllipsize(null);
            topicText.setMaxLines(Integer.MAX_VALUE);

// Add views
            topicContainer.addView(topicButton);
            topicContainer.addView(topicText);

// Click listener
            topicButton.setOnClickListener(v -> {
                Intent intent = new Intent(TopicsActivity.this, DetailActivity.class);
                intent.putExtra("lessonNumber", lessonNumber);
                intent.putExtra("topicName", topic);
                startActivity(intent);
            });

// Add container to GridLayout
            topicsLayout.addView(topicContainer);

        }

        // Back button
        backButton.setOnClickListener(v -> finish());
    }
}
