package com.gmail.kaj4380.Yunbul.blockgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Start extends AppCompatActivity implements View.OnClickListener {
    TextView tvTime; // 시간표시
    TextView tvPoint; // 점수표시
    int time = 30; // 제한시간
    int point = 0; // 시작점수

    // 블럭이미지 리소스 배열
    int [] img = {R.drawable.block_red, R.drawable.block_green, R.drawable.block_blue};

    // 떨어지는 블럭의 ImageView 배열 객체
    ImageView [] iv = new ImageView[8];

    private Vibrator vibrator; // 진동
    private SoundPool soundPool; // 음향

    private int soundId_OK;  // 음향 id : 블럭 맞추었을때
    private int soundId_Error; // 음향 id : 블럭 못 맞추었을때

    private MediaPlayer mp; // 배경음

    final int DIALOG_TIMEOVER = 1;// 다이얼로그 ID

    Handler handler = new Handler();// 시간,

    // 게임진행 쓰레드
    class GameThread extends Thread{
        @Override
        public void run() {
            // 시간을 1초마다 다시 표시(업데이트)
            // Handler 사용하여 화면 UI 업데이트

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(time >= 0){
                        tvTime.setText("시간 : " + time);
                        if(time > 0){
                            time--; // 1초 감소, 1초후에 다시 run() 수행
                            handler.postDelayed(this, 1000);
                        } else {
                            // time = 0 인 경우
                            AlertDialog.Builder builder =
                                    new AlertDialog.Builder(Start.this);
                            builder.setTitle("Time's up!")
                                    .setMessage("점수 : " + point)
                                    .setNegativeButton("그만하기", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                        }
                                    })
                            .setPositiveButton("다시하기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 게임 리셋하고, 새 게임 시작
                                    time = 30;
                                    point = 0;
                                    tvTime.setText("시간 : " + time);
                                    tvPoint.setText("점수 : " + point);
                                    new GameThread().start(); // 새로운 게임 시작
                                }
                            })
                            .setCancelable(false)
                            ;
                            builder.show();
                        }//end if
                    }
                }//end run
            },1000) // 1초후에 시간 표시
            ;
        }
    }//end GameThread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 상태바(status bar) 없애기, 반드시 setContentView 전에 처리
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.start);

        // 레이아웃 객체(뷰) 초기화
        tvTime = findViewById(R.id.tvTime);
        tvPoint = findViewById(R.id.tvPoint);

        ImageView ivRed = findViewById(R.id.ivRed);
        ImageView ivGreen = findViewById(R.id.ivGreen);
        ImageView ivBlue = findViewById(R.id.ivBlue);

        iv[0] = findViewById(R.id.ivBlock1);
        iv[1] = findViewById(R.id.ivBlock2);
        iv[2] = findViewById(R.id.ivBlock3);
        iv[3] = findViewById(R.id.ivBlock4);
        iv[4] = findViewById(R.id.ivBlock5);
        iv[5] = findViewById(R.id.ivBlock6);
        iv[6] = findViewById(R.id.ivBlock7);
        iv[7] = findViewById(R.id.ivBlock8);

        // 게임이 시작되면, 초기화
        // 랜덤으로 블럭의 색상 지정
        for (int i = 0 ; i < iv.length ; i++){
            // 0 ,1 ,2 <- red, green, blue
            int num = new Random().nextInt(3); // 0, 1, 2 중의 랜덤 정수
            iv[i].setImageResource(img[num]);
            iv[i].setTag(num +""); // 태그를 버튼의 색상 판단하기 위한 값으로 활용
        }

        // 점수 초기화
        point = 0;
        tvPoint.setText("점수 : " + point);

        // r, g, b 버튼의 이벤트 리스너 등록
        ivRed.setOnClickListener(this);
        ivGreen.setOnClickListener(this);
        ivBlue.setOnClickListener(this);

        // 시간표시, 게임진행 쓰레드 시작하기
        new GameThread().start();



    }//end onCreate

    @Override
    public void onClick(View v) {
        // 버튼을 눌렀을때 호출되는 콜백
        // 블럭과 같은 색상의 버튼이 눌렸는지 판별, 같은 블럭이면 이미지 블럭 한칸씩 내려오기, 맨위에는 새로운 블럭 생성
        boolean isOK = false; // 맞추었는지 판별 결과

        ImageView imageView = (ImageView) v;
        switch (imageView.getId()){
            // 맨 아래 블럭 ImageView 의 색상과 일치하는 버튼인지 판정
            case R.id.ivRed: // 빨강버튼 클릭시

                if ("0".equals(iv[7].getTag().toString())) isOK = true; // 빨강 블럭의 tag값 "0"

                break;
            case R.id.ivGreen: // 초록버튼 클릭시

                if ("1".equals(iv[7].getTag().toString())) isOK = true; // 초록 블럭의 tag값 "1"

                break;
            case R.id.ivBlue: // 파랑버튼 클릭시

                if ("2".equals(iv[7].getTag().toString())) isOK = true; // 파랑 블럭의 tag값 "2"

                break;


        }//end switch

        if (isOK){ // 버튼 색깔을 맞추었다면

            // 위의 7개 블럭을 한칸 아래로 이동, iv[i] -> iv[i + 1]
            for(int i = iv.length -2; i >= 0; i--){
                int num = Integer.parseInt(iv[i].getTag().toString()); // "0", "1", "2"
                iv[i + 1].setImageResource(img[num]); // 아래쪽 블럭 이미지 업데이트
                iv[i + 1].setTag(num + "");
            }//end for

            // 가장 위의 블럭 ImageView 는 랜덤으로 생성
            int num = new Random().nextInt(3); // 0, 1, 2
            iv[0].setImageResource(img[num]);
            iv[0].setTag(num + "");

            // 진동 & 음향
            vibrator.vibrate(200);
            soundPool.play(soundId_OK,1,1,0,0,1);

            // 점수 올리기
            point++;
            tvPoint.setText("점수 : " + point);
        } else {  // 버튼 색깔이 틀리다면

            // 진동 & 음향
            vibrator.vibrate(new long [] {20, 80, 20, 80, 20, 80}, -1);
            soundPool.play(soundId_Error,1,1,0,0,1);

            // 점수 깎기
            point--;
            tvPoint.setText("점수 : " + point);
        }
    }//end onClick

    @Override
    protected void onResume() {
        super.onResume();
        // 자원획득

        // Vibrator 객체 얻어오기
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        // SoundPool 객체
        soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        soundId_OK = soundPool.load(Start.this, R.raw.gun3, 1);
        soundId_Error = soundPool.load(Start.this, R.raw.error, 1);

        // MediaPlayer 객체, 배격음악 연주 시작
        mp = MediaPlayer.create(getApplicationContext(), R.raw.bgm);
        mp.setLooping(false);
        mp.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 자원해제
        if (mp != null){
            mp.stop();
            mp.release();
        }

    }
}//end Activity
