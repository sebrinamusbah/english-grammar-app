package com.example.englishgrammarapp;  // Must match Word.java

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.graphics.Color;
import androidx.appcompat.widget.Toolbar;


public class VocabularyWordsActivity extends AppCompatActivity {

    LinearLayout wordsContainer;
    TextView topicTitle;
    List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_words);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        // Initialize views
        topicTitle = findViewById(R.id.topicTitle);
        wordsContainer = findViewById(R.id.wordsContainer);

        // Get topic from intent and display it
        String topic = getIntent().getStringExtra("topic");
        topicTitle.setText(topic);

        // Get words and display them
        wordList = getWordsByTopic(topic);
        displayWords();
    }

    private List<Word> getWordsByTopic(String topic) { List<Word> list = new ArrayList<>();
        // -------------------- PHRASES --------------------
        if (topic.equalsIgnoreCase("Phrases")) {
            list.add(new Word("Break the ice", "To do or say something to relieve tension or start a conversation", "He told a funny joke to break the ice at the party."));
            list.add(new Word("Hit the books", "To study hard", "I need to hit the books tonight because the exam is tomorrow."));
            list.add(new Word("Under the weather", "Feeling sick or unwell", "I’m feeling a bit under the weather today, so I’ll stay home."));
            list.add(new Word("Piece of cake", "Something very easy to do", "The math problem was a piece of cake for her."));
            list.add(new Word("Once in a blue moon", "Something that happens very rarely", "I only go to the cinema once in a blue moon."));
            list.add(new Word("Kill two birds with one stone", "To achieve two things with a single action", "By picking up groceries on my way home from work, I killed two birds with one stone."));
            list.add(new Word("Spill the beans", "To reveal a secret", "She accidentally spilled the beans about the surprise party."));
            list.add(new Word("The ball is in your court", "It’s your turn to make a decision or take action", "I’ve done all I can; now the ball is in your court."));
            list.add(new Word("Bite the bullet", "To face a difficult situation bravely", "I decided to bite the bullet and tell him the truth."));
            list.add(new Word("Let the cat out of the bag", "To reveal a secret or surprise by mistake", "She let the cat out of the bag about the promotion."));
            list.add(new Word("Burn the midnight oil", "To work late into the night", "I had to burn the midnight oil to finish the project."));
            list.add(new Word("Call it a day", "To stop working for the day", "After finishing the report, we decided to call it a day."));
            list.add(new Word("Hit the nail on the head", "To describe exactly what is causing a situation or problem", "She hit the nail on the head when she said the team lacked communication."));
            list.add(new Word("Barking up the wrong tree", "To make a wrong assumption or pursue the wrong course", "If you think I stole the book, you’re barking up the wrong tree."));
            list.add(new Word("A blessing in disguise", "Something that seems bad but turns out to be good", "Losing that job was a blessing in disguise because I found a better one."));
            list.add(new Word("On the ball", "To be alert, knowledgeable, or quick to respond", "She is really on the ball during meetings."));
            list.add(new Word("Back to square one", "To start over from the beginning", "The experiment failed, so we are back to square one."));
            list.add(new Word("Cut corners", "To do something in the easiest, quickest, or cheapest way, often poorly", "Don’t cut corners on this project; quality is important."));
            list.add(new Word("Up in the air", "Something is uncertain or undecided", "Our travel plans are still up in the air because of the weather."));
            list.add(new Word("Hit the sack", "To go to bed or sleep", "I’m exhausted; I’m going to hit the sack early tonight."));
        }

        // -------------------- IDIOMS --------------------
        else if (topic.equalsIgnoreCase("Idioms")) {
            list.add(new Word("A dime a dozen", "Very common, not special", "These kinds of souvenirs are a dime a dozen in tourist shops."));
            list.add(new Word("Beat around the bush", "To avoid talking about the main topic", "Stop beating around the bush and tell me what happened."));
            list.add(new Word("Bite off more than you can chew", "Take on more responsibility than you can handle", "I think I bit off more than I could chew by agreeing to both jobs."));
            list.add(new Word("Break a leg", "Good luck (often in performances)", "Break a leg at your dance recital tonight!"));
            list.add(new Word("Costs an arm and a leg", "Very expensive", "That designer bag costs an arm and a leg."));
            list.add(new Word("Cry over spilt milk", "Worry about something that cannot be changed", "Don’t cry over spilt milk; just try to fix the problem."));
            list.add(new Word("Devil’s advocate", "To argue the opposite, usually for debate", "I’ll play devil’s advocate and ask why this plan might fail."));
            list.add(new Word("Don’t count your chickens before they hatch", "Don’t assume success before it happens", "Don’t count your chickens before they hatch; the deal isn’t finalized yet."));
            list.add(new Word("Every cloud has a silver lining", "There is something good in every bad situation", "Losing the job was hard, but every cloud has a silver lining; I found a better one."));
            list.add(new Word("Hit the sack", "To go to bed or sleep", "I’m tired, so I’m going to hit the sack."));
            list.add(new Word("In hot water", "In trouble", "He’s in hot water for missing the deadline."));
            list.add(new Word("Let sleeping dogs lie", "Avoid restarting old conflicts", "Don’t bring up the argument again; just let sleeping dogs lie."));
            list.add(new Word("Miss the boat", "Miss an opportunity", "I didn’t apply for the scholarship on time, and now I missed the boat."));
            list.add(new Word("Once in a blue moon", "Very rarely", "I eat fast food once in a blue moon."));
            list.add(new Word("Piece of cake", "Very easy", "The test was a piece of cake."));
            list.add(new Word("Pull someone’s leg", "To joke or tease someone", "Don’t worry; I’m just pulling your leg."));
            list.add(new Word("Spill the beans", "Reveal a secret", "He spilled the beans about the surprise party."));
            list.add(new Word("The ball is in your court", "It’s your turn to act or decide", "I’ve done all I can; now the ball is in your court."));
            list.add(new Word("Throw in the towel", "To give up", "After hours of trying, he finally threw in the towel."));
            list.add(new Word("Under the weather", "Feeling ill or unwell", "I’m feeling under the weather today, so I won’t go to school."));
        }

        // -------------------- SYNONYMS --------------------
        else if (topic.equalsIgnoreCase("Synonyms")) {

            list.add(new Word(
                    "Happy",
                    "Synonyms: Joyful, cheerful, delighted\nAntonyms: Sad, unhappy, miserable\nMeaning: Feeling or showing pleasure or contentment.",
                    "Example: She felt joyful when she received the gift."
            ));

            list.add(new Word(
                    "Big",
                    "Synonyms: Large, huge, enormous\nAntonyms: Small, tiny, little\nMeaning: Something of great size.",
                    "Example: They live in a huge house near the park."
            ));

            list.add(new Word(
                    "Fast",
                    "Synonyms: Quick, rapid, speedy\nAntonyms: Slow, sluggish, unhurried\nMeaning: Moving or capable of moving quickly.",
                    "Example: The cheetah is a fast animal."
            ));

            list.add(new Word(
                    "Smart",
                    "Synonyms: Intelligent, clever, bright\nAntonyms: Stupid, foolish, dull\nMeaning: Having or showing quick thinking.",
                    "Example: He is very clever at solving puzzles."
            ));

            list.add(new Word(
                    "Beautiful",
                    "Synonyms: Lovely, attractive, gorgeous\nAntonyms: Ugly, unattractive, plain\nMeaning: Pleasing to the senses or mind.",
                    "Example: The sunset looked gorgeous over the mountains."
            ));

            list.add(new Word(
                    "Strong",
                    "Synonyms: Powerful, sturdy, robust\nAntonyms: Weak, fragile, feeble\nMeaning: Having great physical power.",
                    "Example: The bridge is sturdy and safe for heavy vehicles."
            ));

            list.add(new Word(
                    "Angry",
                    "Synonyms: Furious, mad, upset\nAntonyms: Calm, peaceful, relaxed\nMeaning: Feeling or showing anger.",
                    "Example: She was furious when she lost her wallet."
            ));

            list.add(new Word(
                    "Small",
                    "Synonyms: Tiny, little, miniature\nAntonyms: Big, large, huge\nMeaning: Of a size that is less than normal.",
                    "Example: The kitten is tiny and cute."
            ));
        }


        // -------------------- HOMOPHONES --------------------
        else if (topic.equalsIgnoreCase("Homophones")) {

            list.add(new Word(
                    "To / Too / Two",
                    "To: Shows direction.\nToo: Means also or excessively.\nTwo: Number 2.",
                    "To: I am going to school.\nToo: I want to come too.\nTwo: I have two books."
            ));

            list.add(new Word(
                    "There / Their / They’re",
                    "There: A place.\nTheir: Belonging to them.\nThey’re: They are.",
                    "There: The book is over there.\nTheir: This is their house.\nThey’re: They’re going to the park."
            ));

            list.add(new Word(
                    "Your / You’re",
                    "Your: Belonging to you.\nYou’re: You are.",
                    "Your: Is this your pen?\nYou’re: You’re very kind today."
            ));

            list.add(new Word(
                    "Hear / Here",
                    "Hear: To listen.\nHere: A place.",
                    "Hear: Can you hear the birds?\nHere: Please sit here."
            ));

            list.add(new Word(
                    "Right / Write",
                    "Right: Correct or a direction.\nWrite: To put words on paper.",
                    "Right: Turn right at the corner.\nWrite: Please write your name."
            ));

            list.add(new Word(
                    "Sea / See",
                    "Sea: Large body of water.\nSee: To look with your eyes.",
                    "Sea: We swam in the sea.\nSee: I can see the mountains."
            ));

            list.add(new Word(
                    "Flower / Flour",
                    "Flower: Part of a plant.\nFlour: Powder used in baking.",
                    "Flower: The garden has many flowers.\nFlour: I need flour to bake a cake."
            ));

            list.add(new Word(
                    "Break / Brake",
                    "Break: To split or stop.\nBrake: Device to stop a vehicle.",
                    "Break: Don’t break the glass.\nBrake: Press the brake slowly."
            ));

            list.add(new Word(
                    "Pair / Pear",
                    "Pair: Two of something.\nPear: A fruit.",
                    "Pair: I bought a pair of shoes.\nPear: I ate a pear for breakfast."
            ));

            list.add(new Word(
                    "Knight / Night",
                    "Knight: Medieval soldier.\nNight: Time after sunset.",
                    "Knight: The knight fought bravely.\nNight: I slept early last night."
            ));

            list.add(new Word(
                    "Weak / Week",
                    "Weak: Lacking strength.\nWeek: Seven days.",
                    "Weak: He felt weak.\nWeek: There are seven days in a week."
            ));

            list.add(new Word(
                    "Wear / Where",
                    "Wear: To put on clothes.\nWhere: Asking about place.",
                    "Wear: I will wear my new dress.\nWhere: Where is my bag?"
            ));

            list.add(new Word(
                    "Right / Rite / Write",
                    "Right: Correct or direction.\nRite: Ceremony.\nWrite: To form words.",
                    "Right: Take the right turn.\nRite: They performed a rite.\nWrite: Please write a letter."
            ));

            list.add(new Word(
                    "Buy / By / Bye",
                    "Buy: To purchase.\nBy: Near or through.\nBye: Short for goodbye.",
                    "Buy: I will buy a notebook.\nBy: The book is by the window.\nBye: She waved bye."
            ));

            list.add(new Word(
                    "Allowed / Aloud",
                    "Allowed: Permitted.\nAloud: Spoken out loud.",
                    "Allowed: You are allowed to enter.\nAloud: Please read aloud."
            ));

            list.add(new Word(
                    "Bare / Bear",
                    "Bare: Uncovered.\nBear: Animal or tolerate.",
                    "Bare: The tree was bare.\nBear: I saw a bear."
            ));

            list.add(new Word(
                    "Principal / Principle",
                    "Principal: Head of school.\nPrinciple: Basic rule.",
                    "Principal: The principal spoke.\nPrinciple: Honesty is a principle."
            ));

            list.add(new Word(
                    "Mail / Male",
                    "Mail: Letters or packages.\nMale: A boy or man.",
                    "Mail: I received mail.\nMale: The male lion is larger."
            ));

            list.add(new Word(
                    "Stationary / Stationery",
                    "Stationary: Not moving.\nStationery: Writing materials.",
                    "Stationary: The car was stationary.\nStationery: I bought stationery."
            ));

            list.add(new Word(
                    "Right / Write / Rite / Wright",
                    "Right: Correct or direction.\nWrite: To form words.\nRite: Ceremony.\nWright: A builder.",
                    "Right: Take the right turn.\nWrite: Write your homework.\nRite: The rite was impressive.\nWright: A playwright writes plays."
            ));
        }

        return list;
    }

    private void displayWords() {

        wordsContainer.removeAllViews();
        int number = 1;

        for (Word word : wordList) {

            LinearLayout wordLayout = new LinearLayout(this);
            wordLayout.setOrientation(LinearLayout.VERTICAL);
            wordLayout.setPadding(16, 16, 16, 16);

            // Number + Term
            TextView term = new TextView(this);
            term.setText(number + ". " + word.getTerm());
            term.setTextSize(20);
            term.setTextColor(getResources().getColor(android.R.color.black));
            term.setPadding(0, 0, 0, 12);
            term.setTypeface(null, android.graphics.Typeface.BOLD);

            // Meaning Label (orange)
            TextView meaningLabel = new TextView(this);
            meaningLabel.setText("Meaning:");
            meaningLabel.setTextSize(16);
            meaningLabel.setTextColor(Color.parseColor("#FF9800")); // orange
            meaningLabel.setPadding(0, 0, 0, 4);

            // Meaning text
            TextView meaning = new TextView(this);
            meaning.setText(word.getMeaning());
            meaning.setTextSize(16);
            meaning.setTextColor(getResources().getColor(android.R.color.black));
            meaning.setPadding(0, 0, 0, 12);

            wordLayout.addView(term);
            wordLayout.addView(meaningLabel);
            wordLayout.addView(meaning);

            // Sentence (Example)
            if (word.getExample() != null && !word.getExample().isEmpty()) {

                TextView exampleLabel = new TextView(this);
                exampleLabel.setText("Sentence:");
                exampleLabel.setTextSize(16);
                exampleLabel.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
                exampleLabel.setPadding(0, 0, 0, 4);

                TextView example = new TextView(this);
                example.setText(word.getExample());
                example.setTextSize(16);
                example.setTextColor(getResources().getColor(android.R.color.black));
                example.setPadding(0, 0, 0, 12);

                wordLayout.addView(exampleLabel);
                wordLayout.addView(example);
            }

            // Add to container
            wordsContainer.addView(wordLayout);

            // Divider
            View divider = new View(this);
            divider.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2
            ));
            divider.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            wordsContainer.addView(divider);

            number++;
        } } }
