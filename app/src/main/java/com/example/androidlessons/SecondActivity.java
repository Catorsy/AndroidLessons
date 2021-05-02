package com.example.androidlessons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

//    int counter1 = 0;
//    int counter2 = 0;
//    int counter3 = 0;
    //больше не надо, вынесли в отдельный класс

    private Count count; //в активити мы не инициализируем! а то перегрузим. Никаких нью. Нельзя замедлять открытие активити, там мы работаем в 1 потоке. В онкреейт.
    private TextView textCounter1; //все для всех трех кнопок
    private TextView textCounter2;
    private TextView textCounter3;

    private static final String COUNTER_PARAM = "COUNTER_PARAM";
    //psfs для константы быстрый набор
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");

        count = new Count();

        textCounter1 = findViewById(R.id.textView1);
        textCounter2 = findViewById(R.id.textView2);
        textCounter3 = findViewById(R.id.textView3);
        //в R лежать все наши ресурсы
        //сопоставили счетчик и вьюшку

        //для этой кнопки выберем анонимный класс
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //counter2++; уже не так
                count.incrementCounter2();
                textCounter2.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter2()));
                //раньше было просто counter3 вместо count.getCounter1())
            }
        });

        //а тут то же самое, но с лямбдой
        findViewById(R.id.button3).setOnClickListener(v -> {
            //counter3++;
            count.incrementCounter3();
            textCounter3.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter3()));
        });
        //еще можно активити задать implements View.OClickListener, а потом просто переать this и всё.
        //findViewById(R.id.button2).setOnClickListener(this);
        //потом переопределяем onClick. Нам туда приходит вью, и мы можем посмотреть, что это за вью
        //если много кнопок, можно задать им один и тот же клик листенер, а внутри уже определить
        //pv onClick (View v){
        //v.getId() == R.id.button
        //и что-то сделать
        //а если кнопку определили, то прямо сразу строки, что нужно делать при нажатии
    }

    @Override
    protected void onStart() {
        super.onStart(); //говорим родителю кое-что сделать
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
        count = (Count) savedInstanceState.getSerializable("COUNTER_PARAM");
        //тут мы получили каунт и сделали риведение типов, он ведь не каунт возвращает, а сериалайзбл
        textCounter1.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter1()));
        textCounter2.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter2()));
        textCounter3.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter3()));
        //по-хороему вынести в отдельный метод
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
        outState.putSerializable("COUNTER_PARAM", count);
                //это кладем в бандл. Можно положить просто объект - serialazible, parciable
        //по-хорошему экстра каунтер в константу выносим
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

    public void button1_onClick(View view) {
        //при нажатии на кнопку вызовется этот метод
        count.incrementCounter1();
        textCounter1.setText(String.format(Locale.getDefault(), "[%d]", count.getCounter1()));
        //or:
        //textCounter1.setText(String.valueOf(counter1));
    }
    //а как сохранить натыканное? способ 1: в манифесте запрещаем поворачивать экран.
    //способ 2:  манифесте конфигурейшн
    //способ 3: с перестройкой лайаута. в count implementsSerialazible, который сначала пакует класс, потом распаковывает
    //потом добавляем в onSaveInstanceState
    //потом в он ресторт инстант стейт и там же восстанавливаем текст
}