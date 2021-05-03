package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //Я знаю, что метод для обработки кнопки 1 - не лучший метод обработки кнопки! И что код должен быть однообразным.
    //Но это же домашка, дайте попробовать несколько вариантов :) Давайте представим, что в настоящем коде я для всех кнопок использую лямбду.

    private void initView() {
        textView = findViewById(R.id.textView);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button6);
        Button button6 = findViewById(R.id.button7);
        Button button7 = findViewById(R.id.button9);
        Button button8 = findViewById(R.id.button10);
        Button button9 = findViewById(R.id.button11);
        Button button0 = findViewById(R.id.button13);
        Button buttonClearAll = findViewById(R.id.button16);
        Button buttonErase = findViewById(R.id.button17);
        Button buttonPlus = findViewById(R.id.button5);
        Button buttonMinus = findViewById(R.id.button8);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "2");
            }
        });
        button3.setOnClickListener(v -> textView.setText(textView.getText() + "3"));
        button4.setOnClickListener(v -> textView.setText(textView.getText() + "4"));
        button5.setOnClickListener(v -> textView.setText(textView.getText() + "5"));
        button6.setOnClickListener(v -> textView.setText(textView.getText() + "6"));
        button7.setOnClickListener(v -> textView.setText(textView.getText() + "7"));
        button8.setOnClickListener(v -> textView.setText(textView.getText() + "8"));
        button9.setOnClickListener(v -> textView.setText(textView.getText() + "9"));
        button0.setOnClickListener(v -> textView.setText(textView.getText() + "0"));

        buttonClearAll.setOnClickListener(v -> textView.setText(" "));
        buttonErase.setOnClickListener(v -> {
            String memory = textView.getText().toString();
            if (memory.isEmpty()){
                textView.setText(" ");
            }else {
                memory = memory.substring(0, memory.length() - 1);
                textView.setText(memory);
            }
        });
        buttonPlus.setOnClickListener(this);
    }

    public void button1_onClick(View view){
        textView.setText(textView.getText() + "1");
        //textView.setText(String.format(textView.getText() +  Locale.getDefault(), "%d", buttom1));
    }

    //это для способа implements View.OnClickListener
    @Override
    public void onClick(View v) {
        textView.setText(textView.getText() + "+");
    }
}