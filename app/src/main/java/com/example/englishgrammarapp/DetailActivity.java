package com.example.englishgrammarapp;

import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.view.Gravity;
import android.graphics.drawable.GradientDrawable;





import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import org.xmlpull.v1.XmlPullParser;

public class DetailActivity extends AppCompatActivity {

    LinearLayout topicsLayout;
    TextView topicTitleTextView;
    Button backButton;
    int lessonNumber;
    String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        topicsLayout = findViewById(R.id.topicsLayout);
        topicTitleTextView = findViewById(R.id.topicTitleTextView);
        backButton = findViewById(R.id.backButton);

        lessonNumber = getIntent().getIntExtra("lessonNumber", 1);
        topicName = getIntent().getStringExtra("topicName");

        topicTitleTextView.setText(topicName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        displayNoteFromXml(lessonNumber, topicName);
    }

    private void displayNoteFromXml(int lessonNum, String topicName) {
        XmlResourceParser parser = getResources().getXml(R.xml.notes);

        try {
            int eventType = parser.getEventType();
            boolean insideLesson = false;
            boolean insideTopic = false;

            String noteDescription = "";
            String noteTypes = "";
            String noteRules = "";
            String noteExamples = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                if (eventType == XmlPullParser.START_TAG) {
                    if (tagName.equals("lesson") &&
                            parser.getAttributeValue(null, "number").equals(String.valueOf(lessonNum))) {
                        insideLesson = true;
                    } else if (insideLesson && tagName.equals("topic") &&
                            parser.getAttributeValue(null, "name").equals(topicName)) {
                        insideTopic = true;
                    } else if (insideTopic) {
                        switch (tagName) {
                            case "description":
                                noteDescription = parser.nextText().trim().replaceAll("\\r?\\n", "\n");
                                break;
                            case "types":
                                // get the raw text, remove leading/trailing whitespace
                                String rawTypes = parser.nextText();
                                // split by any line breaks or multiple spaces
                                String[] typeLines = rawTypes.split("\\r?\\n|\\r");
                                StringBuilder typesBuilder = new StringBuilder();
                                for (String line : typeLines) {
                                    line = line.trim();
                                    if (!line.isEmpty()) {
                                        typesBuilder.append(line).append("\n");
                                    }
                                }
                                noteTypes = typesBuilder.toString().trim();
                                break;

                            case "rules":
                                noteRules = parser.nextText().trim().replaceAll("\\r?\\n", "\n");
                                break;
                            case "examples":
                                noteExamples = parser.nextText().trim().replaceAll("\\r?\\n", "\n");
                                break;
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (tagName.equals("topic") && insideTopic) {

                        // ---------------- DESCRIPTION ----------------
                        TextView desc = new TextView(this);
                        String formattedDescription = noteDescription
                                .replaceAll("\\s*\n\\s*", " ")
                                .replaceAll("\\.\\s*", ".\n")
                                .trim();
                        desc.setText(formattedDescription);
                        desc.setTextSize(16f);
                        desc.setTextColor(Color.DKGRAY);
                        desc.setLineSpacing(8f, 1.2f);
                        desc.setTypeface(Typeface.SANS_SERIF);
                        desc.setPadding(16, 12, 16, 12);
                        desc.setGravity(Gravity.START);
                        desc.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

                        GradientDrawable descBg = new GradientDrawable();
                        descBg.setColor(Color.parseColor("#FFFFFF"));
                        descBg.setCornerRadius(12);
                        descBg.setStroke(1, Color.LTGRAY);
                        desc.setBackground(descBg);
                        desc.setElevation(4f);

                        LinearLayout.LayoutParams descParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        descParams.setMargins(0, 8, 0, 16);
                        desc.setLayoutParams(descParams);

                        topicsLayout.addView(desc);

                        // ---------------- TYPES ----------------
                        if (!noteTypes.isEmpty()) {
                            TextView typesHeader = new TextView(this);
                            typesHeader.setText("Types:");
                            typesHeader.setTextSize(17f);
                            typesHeader.setTypeface(null, Typeface.BOLD);
                            typesHeader.setTextColor(Color.parseColor("#6D4C41"));
                            typesHeader.setPadding(0, 12, 0, 6);
                            topicsLayout.addView(typesHeader);

                            String[] typesArr = noteTypes.split("\\r?\\n");
                            StringBuilder typesBuilder = new StringBuilder();
                            for (String t : typesArr) {
                                t = t.trim();
                                if (!t.isEmpty()) {
                                    typesBuilder.append("• ").append(t).append("\n");
                                }
                            }

                            TextView typesCard = new TextView(this);
                            typesCard.setText(typesBuilder.toString().trim());
                            typesCard.setTextSize(16f);
                            typesCard.setTextColor(Color.parseColor("#FF9800"));
                            typesCard.setPadding(30, 20, 30, 20);

                            GradientDrawable typesBg = new GradientDrawable();
                            typesBg.setColor(Color.parseColor("#FFFFFF"));
                            typesBg.setCornerRadius(12);
                            typesBg.setStroke(1, Color.LTGRAY);
                            typesCard.setBackground(typesBg);

                            LinearLayout.LayoutParams typesParams = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                            );
                            typesParams.setMargins(0, 8, 0, 16);
                            typesCard.setLayoutParams(typesParams);

                            topicsLayout.addView(typesCard);
                        }

                        // ---------------- RULES ----------------
                        if (!noteRules.isEmpty()) {
                            TextView rulesHeader = new TextView(this);
                            rulesHeader.setText("Rules:");
                            rulesHeader.setTextSize(17f);
                            rulesHeader.setTypeface(null, Typeface.BOLD);
                            rulesHeader.setTextColor(Color.parseColor("#6D4C41"));
                            rulesHeader.setPadding(0, 20, 0, 6);
                            topicsLayout.addView(rulesHeader);

                            String[] rulesArr = noteRules.split("\\r?\\n");
                            StringBuilder rulesBuilder = new StringBuilder();
                            for (String r : rulesArr) {
                                r = r.trim();
                                if (!r.isEmpty()) {
                                    rulesBuilder.append("• ").append(r.replace("-", "").trim()).append("\n");
                                }
                            }

                            TextView rulesCard = new TextView(this);
                            rulesCard.setText(rulesBuilder.toString().trim());
                            rulesCard.setTextSize(16f);
                            rulesCard.setTextColor(Color.BLACK);
                            rulesCard.setPadding(30, 20, 30, 20);
                            rulesCard.setLineSpacing(6f, 1f);

                            GradientDrawable rulesBg = new GradientDrawable();
                            rulesBg.setColor(Color.parseColor("#FFFFFF"));
                            rulesBg.setCornerRadius(12);
                            rulesBg.setStroke(1, Color.LTGRAY);
                            rulesCard.setBackground(rulesBg);

                            LinearLayout.LayoutParams rulesParams = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                            );
                            rulesParams.setMargins(0, 0, 0, 16);
                            rulesCard.setLayoutParams(rulesParams);

                            topicsLayout.addView(rulesCard);
                        }

                        // ---------------- EXAMPLES ----------------
                        if (!noteExamples.isEmpty()) {
                            TextView examplesHeader = new TextView(this);
                            examplesHeader.setText("Examples:");
                            examplesHeader.setTextSize(17f);
                            examplesHeader.setTypeface(null, Typeface.BOLD);
                            examplesHeader.setTextColor(Color.parseColor("#1565C0"));
                            examplesHeader.setPadding(0, 20, 0, 6);
                            topicsLayout.addView(examplesHeader);

                            String[] examplesArr = noteExamples.split("\\r?\\n");
                            for (String ex : examplesArr) {
                                ex = ex.trim();
                                if (!ex.isEmpty()) {
                                    TextView exampleItem = new TextView(this);
                                    exampleItem.setText("• " + ex);
                                    exampleItem.setTextSize(16f);
                                    exampleItem.setTextColor(Color.parseColor("#2196F3"));
                                    exampleItem.setPadding(30, 0, 0, 6);
                                    topicsLayout.addView(exampleItem);
                                }
                            }
                        }

                        insideTopic = false;
                    }
                }

                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
