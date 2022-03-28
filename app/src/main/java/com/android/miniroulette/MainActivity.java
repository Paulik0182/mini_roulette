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

    private static final int ROULETTE_MAX_VALUE = 3;
    private static final String IS_NOT_FIRST_KEY = "IS_NOT_FIRST_KEY";

    private TextView oneWindowTv = null;
    private TextView twoWindowTv = null;
    private TextView threeWindowTv = null;
    private TextView resultTextView = null;
    private Button startButton = null;

    private int firstWindowValue = 0;
    private int secondWindowValue = 0;
    private int thirstWindowValue = 0;

    private String informationText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        fillWindowsByNumbers(
                //передали сразу три случайных числа
                getRandomRouletteValue(),
                getRandomRouletteValue(),
                getRandomRouletteValue()
        );
    }

    private void initViews() {
        oneWindowTv = findViewById(R.id.one_text_view);
        twoWindowTv = findViewById(R.id.two_text_view);
        threeWindowTv = findViewById(R.id.three_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        startButton = findViewById(R.id.start_button);
    }

    private void setListeners() {
        //используется отлько один setOnClickListener, поэтому первые две записи ненужны так как последняя запись нерезапишет предыдущии
        startButton.setOnClickListener(v -> openNextScreen());
    }

    private void openNextScreen() {
        if (isWin(firstWindowValue, secondWindowValue, thirstWindowValue)) {
            finish();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(IS_NOT_FIRST_KEY, true);
            startActivityForResult(intent, RESULT_REQUEST_CODE);

            //вариант написания (сокращения) верхних двух строчер
//        startActivityForResult(new Intent(this, MainActivity.class), RESULT_REQUEST_CODE);
        }
    }

    private int getRandomRouletteValue() {
        Random random = new Random();//
        return random.nextInt(ROULETTE_MAX_VALUE);//генерируем случайные числа, от 0 до 3
        //return new Random().nextInt(ROULETTE_MAX_VALUE); //вариант записи верхних строчек
    }

    //заполняем поля случайными цифрами
    private void fillWindowsByNumbers(int first, int second, int third) {

        firstWindowValue = first;
        secondWindowValue = second;
        thirstWindowValue = third;

        oneWindowTv.setText(String.valueOf(first));
        twoWindowTv.setText(String.valueOf(second));
        threeWindowTv.setText(String.valueOf(third));
        setResultText();
    }

    // метод сравнения (да, нет). Если все значения равны
    private boolean isWin(int first, int second, int third) {
        return first == second && second == third;
    }

    private void setResultText() {
        //условие проверки, если все равно то победа, передача данных
        if (isWin(firstWindowValue, secondWindowValue, thirstWindowValue)) {
            informationText = "Ура, Вы победили!";
            Intent dataIntent = new Intent();
//            dataIntent.putExtra(ONE_WINDOW_RANDOM_NUMBERS_KEY, result);
            setResult(Activity.RESULT_OK, dataIntent);

            //вариант написания верхних рех строчек
            //  setResult(Activity.RESULT_OK, new Intent().putExtra(ONE_WINDOW_RANDOM_NUMBERS_KEY, result));
        } else {
            informationText = "Попробуйте еще!";
        }
        resultTextView.setText(informationText);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RESULT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (!isFirstScreen()) {
                setResult(Activity.RESULT_OK);
                finish();
            } else {
                resultTextView.setText("Первый");
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //проверяем первый ли Intent или нет, ставим флажек
    private boolean isFirstScreen() {
        Intent intent = getIntent();
        if (intent == null) {
            return true;
        } else {
            return !intent.hasExtra(IS_NOT_FIRST_KEY);
        }
    }
}