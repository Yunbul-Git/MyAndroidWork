package com.lec.android.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //int[] imageId = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }//end onCreate

    class MyListener implements View.OnClickListener{
        int i = 0;
        TextView tvResult = findViewById(R.id.tvResult);
        @Override
        public void onClick(View v) {
            i++;
            //if(i == imageId.length) i = 0;


        }
    }
}//end Activity
