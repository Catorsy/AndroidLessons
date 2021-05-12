package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }//commit///

    private void initView() {
        Button buttonGreeting = findViewById(R.id.buttonReturn);

        buttonGreeting.setOnClickListener(v -> {
            finish();
        });

        //получаем
        EditText nameEditText = findViewById(R.id.editName);
        nameEditText.setText(getIntent().getExtras().getString(MainActivity.YOUR_NAME));
        //getExstras возвращает бандл
        //нельзя из 2й активити запускать 1ю для сохранения данных! дурной тон
    }
}