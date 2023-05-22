package com.example.ebass.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ebass.MainBottomNavigation;
import com.example.ebass.R;

public class Problem_Actionbar extends AppCompatActivity {

    ImageView go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_actionbar);

        go = (ImageView) findViewById(R.id.goHome);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
