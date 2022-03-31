package com.android.miniroulette;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class ColorFragment extends Fragment {

    private Button startButton = null;

    //Создает View
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflater - раздуть (создать)
        // container - куда раздуть
        return inflater.inflate(R.layout.fragment_color, container, false);
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
    }

    private void setListeners() {
        //используется отлько один setOnClickListener, поэтому первые две записи ненужны так как последняя запись нерезапишет предыдущии
        startButton.setOnClickListener(v -> getRandomColor());
    }

    private void getRandomColor() {
        Random random = new Random();
        final int[] color = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, Color.CYAN};

        //вариант 1
        int pos = random.nextInt(color.length);
        //во фрагменте всегда есть view к которой можно всегда обратится
        getView().setBackgroundColor(color[pos]);

//        //вариант 2
//        int color2 = Color.argb(214, random.nextInt(214), random.nextInt(214), random.nextInt(214));
//        getView().setBackgroundColor(color2);

    }
}