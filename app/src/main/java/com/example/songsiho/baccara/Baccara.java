package com.example.songsiho.baccara;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.app.AlertDialog.Builder;
import java.util.Scanner;
import java.lang.Object;


public class Baccara extends AppCompatActivity {

    int capital, bet, base, win =0;
    boolean result = false;
    //String inputMoney=null;

    //문자 입력 받을 스캐너
    Scanner scanner = new Scanner(System.in);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baccara);
        baccaraAlgorithm();
    }

    //바카라 알고리즘
    protected void baccaraAlgorithm(){
        //1. Capital 입력 받고 기본값 세팅 -> 메세지 박스
        inPutCapital();

        //2. 배팅 금액 띄우기 -> 메세지 박스

        //3. 결과 입력 받기 -> 메세지 박스

        //4. if(result) -> win lose 메소드

    }

    //초기 Capital 입력받기
    protected void inPutCapital(){
        capital = scanner.nextInt();
        base = capital/500;
        bet = base;
        displayTextCapital(capital);
        displayTextWinnings(0);
    }

    //Display Capital
    public void displayTextCapital(int capital) {
        TextView capitalView = (TextView) findViewById(R.id.text_capital);
        capitalView.setText(String.valueOf(capital));
    }

    //Display Winnings
    public void displayTextWinnings(int winnings){
        TextView winningsView = (TextView) findViewById(R.id.text_winnigs);
        winningsView.setText(String.valueOf(winnings));
    }


    public class messageBox {
        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(Baccara.this);
        alert_confirm.setMessage("프로그램을 종료 하시겠습니까?").setCancelable(false).setPositiveButton("확인",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 'YES'
            }
        }).setNegativeButton("취소",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 'No'
                return;
            }
        });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }









}
