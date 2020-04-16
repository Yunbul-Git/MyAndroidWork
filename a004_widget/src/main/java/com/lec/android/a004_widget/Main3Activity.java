package com.lec.android.a004_widget;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4;
    Button btnComplete;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        tvResult = findViewById(R.id.tvResult);
        btnComplete = findViewById(R.id.btnComplete);

        //버튼 클릭하면 체크된 내용들만 결과창에 출력하기
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                if(cb1.isChecked()) result += cb1.getText();
                if(cb2.isChecked()) result += cb2.getText();
                if(cb3.isChecked()) result += cb3.getText();
                if(cb4.isChecked()) result += cb4.getText();
                tvResult.setText("선택결과 : " + result);
            }
        });
        cb1.setOnCheckedChangeListener(new CbListener());
        cb2.setOnCheckedChangeListener(new CbListener());
        cb3.setOnCheckedChangeListener(new CbListener());
        cb4.setOnCheckedChangeListener(new CbListener());
    } //end onCreate

    class CbListener implements CompoundButton.OnCheckedChangeListener {

        // CheckBox의 '상태'가 변할때마다 호출되는 메소드
        // isChecked : true 체크가 된 상태 / false 체크가 안된 상태
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int count = 0;
            if(cb1.isChecked()) count++;
            if(cb2.isChecked()) count++;
            if(cb3.isChecked()) count++;
            if(cb4.isChecked()) count++;
            tvResult.setText(count + "개 선택");

        }
    }

}//end Activity
