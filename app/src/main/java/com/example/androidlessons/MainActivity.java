package com.example.androidlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String YOUR_NAME = "YOUR_NAME";
    //с помощью этой константы передадим значение из мейн активити в сеттингсактивити

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }//commit///

    private void initView() {
        Button buttonGreeting = findViewById(R.id.buttonGreating);
        //могли бы использовать мтериал баттон, но лучше просто батт. Всегда лучше использовать интерфейсы!
        //Хотя баттон это класс.
        final TextView textView = findViewById(R.id.textHello);
        final EditText editText = findViewById(R.id.textName);
       // String name = editText.getText().toString(); //строка переехала сюда, была такой, а стала как ниже

        buttonGreeting.setOnClickListener(v -> {
            //String name = editText.getText().toString();
            //Раньше эта строка стояла тут. Это чтобы эдатабл, который возврщает гет текст, превратить в стринг
            // String sayText = " Привет, " + name; было, ниже стало
            String sayText = " Привет, " + editText.getText().toString();
            textView.setText(sayText);
        });

        findViewById(R.id.buttonSettings).setOnClickListener(v -> {
            //у интента куча конструкторов
            //нам нужен контекст и класс, т.е. Мейн активити и this, но раз мы в лямбде, можно только this
        Intent intent = new Intent(this, SettingsActivity.class);
                //второе - что мы хотим запустить. Мы явно указали, что хотим запустить.
            //то же самое:
            //startActivity(new Intent(this, SettingsActivity.class));
            //добавим сюда немножко данных. По ключу кладем значение. Похоже на бандл.
            intent.putExtra(YOUR_NAME, editText.getText().toString());
            //положили и отправили. Бандл по сути! Теперь надо его принять, это в сеттингс активити
            startActivity(intent);
        });
    }
}