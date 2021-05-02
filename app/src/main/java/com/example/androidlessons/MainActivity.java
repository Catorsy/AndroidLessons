package com.example.androidlessons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanseState;
        if (savedInstanceState == null) {
            instanseState = "Первыйзапуск";
        } else {
            instanseState = "Повторный запуск";
        }
        Toast.makeText(getApplicationContext(), instanseState, Toast.LENGTH_LONG).show();
//                первая позиция - контекст. this, getContext можно вместо этого, здесь не важно. Потом пишем текст, потом длительность.
        findViewById(R.id.button).setOnClickListener(v -> {
        Intent intent = new Intent(); //вызываем новую активити
            intent.setComponent(new ComponentName(MainActivity.this, SecondActivity.class));
        startActivity(intent);
        });
    }

            //то же самое, что он клик в активити


        @Override
    protected void onStart() {
        super.onStart(); //говорим родителю коое-что сделать
        //Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart()"); //это чтобы писать в лог
        //Verbose - это все, что есть в логах
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "nDestroy()");
    }
}