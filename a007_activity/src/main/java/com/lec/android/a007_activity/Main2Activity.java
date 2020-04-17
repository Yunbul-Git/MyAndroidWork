package com.lec.android.a007_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * 화면(액티비티)전환 - 인텐트 사용 (인텐트 날린다?)
 *  1. 다음에 넘어갈 액티비티 준비
 *  2. 메니페스트에 액티비티 등록
 *  3. Intent 객체 만들어서 startActivity() 한다
 *      - Intent 로 데이터 주고 받기 :  putExtra() -> getXXXExtra()
 *      - 주고받은 Object 는 Serializable 되어 있어야 한다
 *
 *  안드로이드는 startActivity() 로 새 액티비티를 시작하면
 *  적측형(stack) 구조로 액티비티가 운영된다.
 */
public class Main2Activity extends AppCompatActivity {

    EditText etName, etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        Button btnStartTwo = findViewById(R.id.btnStartTwo);

        btnStartTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        MyTwo.class             // 다음 화면의 액티비티 클래스 지정
                );

                //데이터를 Intent 에 실어서 보내기
                //name : 데이터 형태로 보냄
                intent.putExtra("num", 3);
                intent.putExtra("num2", 7);
                intent.putExtra("long", 33L);
                intent.putExtra("msg", "안녕하세요");

                // 이름, 나이 ---> Person 에 담은뒤 Intent 에 실어 보내기
                Person p = new Person(
                        etName.getText().toString(),
                        Integer.parseInt(etAge.getText().toString())
                );

                intent.putExtra("Person", p);

                startActivity(intent); // 다음화면으로 넘어간다
            }
        });

        // 넘겨받은 Intent 객체를 받는다
        Intent intent = getIntent();

        int a = intent.getIntExtra("num", 0); // "num" 이라는 name 으로 넘어온 값
                                                                // 만악 "num"이라는 name 이 intent에 없으면
                                                                // defaultValue(두번째 매개변수 값)을 리턴

        int b = intent.getIntExtra("num2", 0);

        int c = intent.getIntExtra("num3", 999); // "num3" 라는 이름은 없었다

        long l = intent.getLongExtra("long", 0);
        String msg = intent.getStringExtra("msg"); // 리턴값이 Object 인 경우, default 값 설정 없다
                                                        // "name" 이 없으면 null 리턴

        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("인텐트 받은 값" + a + " : " + b + " : " + c + " : " + l + " : " + msg);

        // Person 데이터 받기
        Person p = (Person)intent.getSerializableExtra("Person");

        TextView tv2 = findViewById(R.id.tv2);
        tv2.setText("Person 받은 값" + p.getName() + " : " + p.getAge());

        // 첫번째 액티비티로 인텐트를 날리면??
        Button btnToMain = findViewById(R.id.btnToMain);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });



    }//end onCreate
}//end Activity
