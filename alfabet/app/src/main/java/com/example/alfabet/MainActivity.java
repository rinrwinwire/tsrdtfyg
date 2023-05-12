package com.example.alfabet;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private Button russianButton;
    private Button englishButton;
    private ListView alphabetListView;
    private ArrayAdapter<String> alphabetAdapter;

    private String[] russianAlphabet = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};
    private String[] englishAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
        russianButton = new Button(this);
        russianButton.setText("Русский алфавит");
        russianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlphabet(russianAlphabet);
            }
        });
        englishButton = new Button(this);
        englishButton.setText("Английский алфавит");
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlphabet(englishAlphabet);
            }
        });

        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        buttonLayout.addView(russianButton, layoutParams);
        buttonLayout.addView(englishButton, layoutParams);

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        buttonLayoutParams.gravity = Gravity.CENTER;
        mainLayout.addView(buttonLayout, buttonLayoutParams);

        alphabetListView = new ListView(this);
        alphabetAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        alphabetListView.setAdapter(alphabetAdapter);

        LinearLayout.LayoutParams listLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        listLayoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        mainLayout.addView(alphabetListView, listLayoutParams);
    }

    private void showAlphabet(String[] alphabet) {
        alphabetAdapter.clear();
        alphabetAdapter.addAll(alphabet);
        alphabetListView.setVisibility(View.VISIBLE);
    }
}
