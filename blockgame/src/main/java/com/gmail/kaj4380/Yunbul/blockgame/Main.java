package com.gmail.kaj4380.Yunbul.blockgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnHowto = findViewById(R.id.btnHowto);
        Button btnInfo = findViewById(R.id.btnInfo);



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 게임시작
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
            }
        });

        btnHowto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 게임방법
                Intent intent = new Intent(getApplicationContext(), HowToPlay.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 정보보기
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        });




    }//end onCreate
}//end Activity
