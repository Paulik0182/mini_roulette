package com.android.miniroulette;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        oneWindow = findViewById(R.id.one_edit_text);
        twoWindow = findViewById(R.id.two_edit_text);
        threeWindow = findViewById(R.id.three_edit_text);
        resultText = findViewById(R.id.result_text_view);
        startButton = findViewById(R.id.start_button);
    }

    private void setListeners() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResultRandomNumbers();
            }
        });
    }

    private void getResultRandomNumbers() {

    }
}