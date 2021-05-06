package com.example.androidlessons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Calculations calculations;
    private static final String SAVE = "SAVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //Я знаю, что метод для обработки кнопки 1 - не лучший метод обработки кнопки! И что код должен быть однообразным.
    //Но это же домашка, дайте попробовать несколько вариантов :) Давайте представим, что в настоящем коде я для всех кнопок использую лямбду.

    private void initView() {
        calculations = new Calculations();
        textView = findViewById(R.id.textView);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button13);
        Button buttonClearAll = findViewById(R.id.button16);
        Button buttonErase = findViewById(R.id.button17);
        Button buttonPlus = findViewById(R.id.button20);
        Button buttonMinus = findViewById(R.id.button21);
        Button buttonEquals = findViewById(R.id.button18);
        Button buttonMulti = findViewById(R.id.button15);
        Button buttonDiv = findViewById(R.id.button12);

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

        buttonClearAll.setOnClickListener(v -> {
            clearField();
            calculations.setNumber1(0);
            calculations.setNumber2(0);
            calculations.setResult(0);
            calculations.setLastNumber(0);
        });
        buttonErase.setOnClickListener(v -> {
            String memory = textView.getText().toString();
            if (!memory.isEmpty()) {
                memory = memory.substring(0, memory.length() - 1);
                textView.setText(memory);
                textView.setHint(R.string.writeYourNumber);
            }
        });
        buttonPlus.setOnClickListener(this);

        buttonMinus.setOnClickListener(v -> {
            calculations.setOperator("-");
            try {
                calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                ///!!! Важный вопрос. Это одна строка, но она встречается в нескольких местах. Надо такое выносить в метод или нет?
                setNumber1andClear();
            } catch (NumberFormatException e) {
            }
            textView.setHint(calculations.getNumber1() + "-");
        });
        buttonMulti.setOnClickListener(v -> {
            calculations.setOperator("*");
            try {
                calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                setNumber1andClear();
            } catch (NumberFormatException e) {
            }
            textView.setHint(calculations.getNumber1() + "*");
        });
        buttonDiv.setOnClickListener(v -> {
            calculations.setOperator(":");
            try {
                calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                setNumber1andClear();
            } catch (NumberFormatException e) {
            }
            textView.setHint(calculations.getNumber1() + ":");
        });

        buttonEquals.setOnClickListener(v -> {
            try {
                switch (calculations.getOperator()) {
                    case "-":
                        calculations.setNumber2(Integer.parseInt(String.valueOf(textView.getText())));
                        calculations.setResult(calculations.getNumber1() - calculations.getNumber2());
                        textView.setText(String.format(String.valueOf(calculations.getResult())));
                        calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                        break;
                    case "+":
                        calculations.setNumber2(Integer.parseInt(String.valueOf(textView.getText())));
                        calculations.setResult(calculations.getNumber1() + calculations.getNumber2());
                        textView.setText(String.format(String.valueOf(calculations.getResult())));
                        calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                        break;
                    case "*":
                        calculations.setNumber2(Integer.parseInt(String.valueOf(textView.getText())));
                        calculations.setResult(calculations.getNumber1() * calculations.getNumber2());
                        textView.setText(String.format(String.valueOf(calculations.getResult())));
                        calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                        break;
                    case ":":
                        calculations.setNumber2(Integer.parseInt(String.valueOf(textView.getText())));
                        try {
                            calculations.setResult(calculations.getNumber1() / calculations.getNumber2());
                            textView.setText(String.format(String.valueOf(calculations.getResult())));
                            calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
                            break;
                        } catch (ArithmeticException e) {
                            clearField();
                            textView.setHint(R.string.Dividir);
                        }
                }
            } catch (NullPointerException | NumberFormatException e) {
                clearField();
                textView.setHint(R.string.tooEarly);
            }
        });
    }

    public void button1_onClick(View view) {
        textView.setText(textView.getText() + "1");
    }

    //это для способа implements View.OnClickListener
    @Override
    public void onClick(View v) {
        calculations.setOperator("+");
        try {
            calculations.setLastNumber(Integer.parseInt(String.valueOf(textView.getText())));
            setNumber1andClear();
        } catch (NumberFormatException e) {
        }
        textView.setHint(calculations.getNumber1() + "+");
    }

    private void clearField() {
        textView.setText("");
        textView.setHint(R.string.writeYourNumber);
    }

    private void setNumber1andClear() {
        calculations.setNumber1(Integer.parseInt(String.valueOf(textView.getText())));
        clearField();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVE, calculations);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculations = (Calculations) savedInstanceState.getSerializable(SAVE);
        textView.setHint(String.format(String.valueOf(calculations.getLastNumber())));
        }
    }