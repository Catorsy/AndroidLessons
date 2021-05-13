package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.androidlessons.Memory.STYLE;

public class SecondActivity extends AppCompatActivity implements Memory {
    private int myStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NightButtons);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        Button buttonOk = findViewById(R.id.buttonOk);
        Button buttonNight = findViewById(R.id.checkBoxNight);
        Button buttonDay = findViewById(R.id.checkBoxDay);;

        buttonOk.setOnClickListener(v -> {
            Intent intentMyStyle = new Intent(SecondActivity.this, MainActivity.class);
            intentMyStyle.putExtra(STYLE, myStyle);
            setResult(RESULT_OK, intentMyStyle);
            finish();
        });
        buttonDay.setOnClickListener(v -> myStyle = 1);
        buttonNight.setOnClickListener(v -> myStyle = 2);
    }
}