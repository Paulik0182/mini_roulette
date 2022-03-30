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

        Fragment fragment1 = new ColorFragment();
        Fragment fragment2 = new ColorFragment();
        Fragment fragment3 = new ColorFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_1, fragment1)
                .add(R.id.fragment_container_2, fragment2)
                .add(R.id.fragment_container_3, fragment3)
                .commit();

    }
}
