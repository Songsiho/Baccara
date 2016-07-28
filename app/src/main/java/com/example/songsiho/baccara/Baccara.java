package com.example.songsiho.baccara;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

public class Baccara extends AppCompatActivity{
    private int capital, bet, base, win =0;
    private boolean result = false;
    //String inputMoney=null;
    CapitalMessageBox1 cmb;

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
        cmb = new CapitalMessageBox1();
        cmb.capitalMessageBox();
        base = capital/500;
        bet = base;
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

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
}
