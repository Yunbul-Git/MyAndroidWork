package com.lec.android.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btn;
    int[] color = {Color.YELLOW, Color.CYAN, Color.BLUE, Color.RED, Color.GREEN};
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                    //tvResult.setBackgroundColor(Color.parseColor("#00000000"));
                if (i > 3) {
                    i = 0;
                } else {
                    tvResult.setBackgroundColor(color[i]);
                    i++;
                }

            }
        });
    }//end onCreate
}//end Activity
