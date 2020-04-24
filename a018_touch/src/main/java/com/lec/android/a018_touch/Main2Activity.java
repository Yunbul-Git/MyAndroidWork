package com.lec.android.a018_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity {

    ImageView ivRobot;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivRobot = findViewById(R.id.ivRobot);
        ll = findViewById(R.id.linearLayout1);

        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN: // 버튼이 눌렸을 때


                    case MotionEvent.ACTION_MOVE:


                    case MotionEvent.ACTION_UP:


                        ivRobot.setX(event.getX());
                        ivRobot.setY(event.getY());


                }//end switch

                return true;
            }
        });
    }//end onCreate
}//end Activity
