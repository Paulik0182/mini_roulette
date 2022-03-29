package com.android.miniroulette;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        findViewById(R.id.show_fragment_button).setOnClickListener(v -> {
            Fragment fragment1 = new MainFragment();
            Fragment fragment2 = new MainFragment();
            Fragment fragment3 = new MainFragment();
            //getSupportFragmentManager() - возвращает объект FragmentManager, который управляет фрагментами.
            // всегда нужно использовать getSupportFragmentManager или из бибоиотеки androidx
            //getSupportFragmentManager () используется для доставки новых функций на более старые платформы

            //установлено управление фрагментом
            //объединение команд в одну транзакцию
            //создаем фрагмент
            //оканчание транзакции (обязательно)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_1, fragment1)
                    .add(R.id.fragment_container_2, fragment2)
                    .add(R.id.fragment_container_3, fragment3)
                    .commit();
        });
    }
}
