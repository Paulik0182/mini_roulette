package com.android.miniroulette;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_REQUEST_CODE = 0;

    private TextView oneWindow = null;
    private TextView twoWindow = null;
    private TextView threeWindow = null;
    private TextView resultText = null;
    private Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
    }

    private void initViews() {
        oneWindow = findViewById(R.id.one_text_view);
        twoWindow = findViewById(R.id.two_text_view);
        threeWindow = findViewById(R.id.three_text_view);
        resultText = findViewById(R.id.result_text_view);
        startButton = findViewById(R.id.start_button);
    }

    private void setListeners() {
        startButton.setOnClickListener(v -> getResultRandomNumbers());
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
        String result = "Ура, Вы победили!";

        String inputStrOneWindow = oneWindow.getText().toString();
        String inputStrTwoWindow = twoWindow.getText().toString();
        String inputStrThreeWindow = threeWindow.getText().toString();

        int inputValueOneWindow = Integer.parseInt(inputStrOneWindow);
        int inputValueTwoWindow = Integer.parseInt(inputStrTwoWindow);
        int inputValueThreeWindow = Integer.parseInt(inputStrThreeWindow);

        if (inputValueOneWindow == inputValueTwoWindow
                && inputValueOneWindow == inputValueThreeWindow
        ) {
            resultText.setText(result);
        } else
            resultText.setText("Попробуйте еще!");
    }
}