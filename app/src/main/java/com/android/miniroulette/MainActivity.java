package com.android.miniroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_REQUEST_CODE = 0;
    private static final String ONE_WINDOW_RANDOM_NUMBERS_KEY = "random numbers";

    private TextView oneWindow = null;
    private TextView twoWindow = null;
    private TextView threeWindow = null;
    private TextView resultText = null;
    private Button startButton = null;

    private int inputValueOneWindow = 0;
    private int inputValueTwoWindow = 0;
    private int inputValueThreeWindow = 0;
    private int result = 0;

    private String textWindow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();

        Intent intent = getIntent();
    }

    private void initViews() {
        oneWindow = findViewById(R.id.one_text_view);
        twoWindow = findViewById(R.id.two_text_view);
        threeWindow = findViewById(R.id.three_text_view);
        resultText = findViewById(R.id.result_text_view);
        startButton = findViewById(R.id.start_button);
    }

    private void setListeners() {
        getResultRandomNumbers();
        startButton.setOnClickListener(v -> openResultScreen(inputValueOneWindow));
        startButton.setOnClickListener(v -> openResultScreen(inputValueTwoWindow));
        startButton.setOnClickListener(v -> openResultScreen(inputValueThreeWindow));
    }

    private void openResultScreen(int value) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.ONE_WINDOW_RANDOM_NUMBERS_KEY, value);
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }

    private void getResultRandomNumbers() {
        int max = 3;

        Random random = new Random();

        oneWindow.setText(String.valueOf(random.nextInt(max)));
        twoWindow.setText(String.valueOf(random.nextInt(max)));
        threeWindow.setText(String.valueOf(random.nextInt(max)));
        setResultText();
    }

    private void setResultText() {
        textWindow = "Ура, Вы победили!";

        inputValueOneWindow = Integer.parseInt(oneWindow.getText().toString());
        inputValueTwoWindow = Integer.parseInt(twoWindow.getText().toString());
        inputValueThreeWindow = Integer.parseInt(threeWindow.getText().toString());

        if (inputValueOneWindow == inputValueTwoWindow
                && inputValueOneWindow == inputValueThreeWindow
        ) {
            resultText.setText(textWindow);
            Intent dataIntent = new Intent();
            dataIntent.putExtra(ONE_WINDOW_RANDOM_NUMBERS_KEY, result);
            setResult(Activity.RESULT_OK, dataIntent);
//            finish();
        } else
            resultText.setText("Попробуйте еще!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RESULT_REQUEST_CODE && requestCode == Activity.RESULT_OK) {
            result = data.getIntExtra(MainActivity.ONE_WINDOW_RANDOM_NUMBERS_KEY, -1);
            resultText.setText(result);
        } else super.onActivityResult(requestCode, resultCode, data);
    }
}