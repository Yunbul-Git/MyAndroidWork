package com.lec.android.a004_widget;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    Button btnPlus = findViewById(R.id.btnPlus);
    Button btnMinus = findViewById(R.id.btnMinus);
    Button btnMul = findViewById(R.id.btnMul);
    Button btnDiv = findViewById(R.id.btnDiv);
    TextView op1 = findViewById(R.id.op1);
    TextView op2 = findViewById(R.id.op2);
    TextView tvResult = findViewById(R.id.tvResult);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        op1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    v.setBackgroundColor(Color.YELLOW);
                } else {
                    v.setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        });




    }

}
