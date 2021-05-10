package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }//commit///

    private void initView() {
        Button buttonGreeting = findViewById(R.id.buttonGreating);
        final TextView textView = findViewById(R.id.textHello);
        final EditText editText = findViewById(R.id.textName);
        buttonGreeting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                //это чтобы эдатабл, который возврщает гет текст, превратить в стринг
                String sayText = " Привет, " + name;
                textView.setText(sayText);
            }
        });
    }
}