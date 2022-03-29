package com.android.miniroulette;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class MainFragment extends Fragment {

    private Button startButton = null;
    //    FrameLayout layout;
    FrameLayout fragmentContainer1;
    FrameLayout fragmentContainer2;
    FrameLayout fragmentContainer3;

    //Создает View
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflater - раздуть (создать)
        // container - куда раздуть
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    //Сразу после создания View.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);//
        setListeners();
    }

    //Всегда нужно передовать view так как у нее есть findViewById
    private void initViews(View view) {
        startButton = view.findViewById(R.id.start_button);
//        layout = view.findViewById(R.id.layout);
        fragmentContainer1 = view.findViewById(R.id.fragment_container_1);
        fragmentContainer2 = view.findViewById(R.id.fragment_container_2);
        fragmentContainer3 = view.findViewById(R.id.fragment_container_3);
    }

    private void setListeners() {
        //используется отлько один setOnClickListener, поэтому первые две записи ненужны так как последняя запись нерезапишет предыдущии
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomColor();
            }
        });
    }

    private void getRandomColor() {
        Random random = new Random();
        final int[] color = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, Color.CYAN};
        int pos = random.nextInt(color.length);

        int color2 = Color.argb(214, random.nextInt(214), random.nextInt(214), random.nextInt(214));

//        layout.setBackgroundColor(color2);

//        fragmentContainer1.setBackgroundColor(color2);
//        fragmentContainer2.setBackgroundColor(color2);
//        fragmentContainer3.setBackgroundColor(color2);

        fragmentContainer1.setBackgroundColor(color[pos]);
        fragmentContainer2.setBackgroundColor(color[pos]);
        fragmentContainer3.setBackgroundColor(color[pos]);
    }
}