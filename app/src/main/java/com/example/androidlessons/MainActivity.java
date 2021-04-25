package com.example.androidlessons;
//активити - это экран
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//match_parent чтобы заняло размер контейнераа


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.layout_2);
        setContentView(R.layout.layout_calendar);

//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Привет!", Toast.LENGTH_LONG).show();
//            }
//        });
//    }//commit///
//    //TODO
        //FIXME
    }
}