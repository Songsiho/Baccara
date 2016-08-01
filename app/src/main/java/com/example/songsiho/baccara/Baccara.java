package com.example.songsiho.baccara;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.text.InputType;
import android.widget.Toast;

public class Baccara extends AppCompatActivity {

    private int capital, bet, base, win = 0;
    private boolean result = false;
    private boolean end = true;
    private boolean userslect = true;
    static final int DIALOG_CUSTOM2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baccara);

        Button btnCapital = (Button) findViewById(R.id.button_capital);
        btnCapital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inPutCapital();
                showDialog(DIALOG_CUSTOM2);
            }
        });

        /*Button btnStart = (Button) findViewById(R.id.button_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baccaraAlgorithm();
            }
        });*/
    }

    //바카라 알고리즘
    public void baccaraAlgorithm() {
        //2. 배팅 금액 띄우기 -> 메세지 박스
        while (end) {
            betMessagebox();

            //3. 결과 입력 받기 -> 메세지 박스, win lose 메소드

            //win
            if (isResult()) {
                winAlgorithm();
            }

            //lose
            else {
                loseAlgorithm();
            }
        }//while end message ->
    }//end baccaraAlgorithm

    //초기 Capital 입력받기
    protected void inPutCapital() {
        capitalMessagebox();
    }

    //Display Capital
    public void displayTextCapital(int capital) {
        TextView capitalView = (TextView) findViewById(R.id.text_capital);
        capitalView.setText(String.valueOf(capital));
    }

    //Display Winnings
    public void displayTextWinnings(int winnings) {
        TextView winningsView = (TextView) findViewById(R.id.text_winnigs);
        winningsView.setText(String.valueOf(winnings));
    }

    public void fivebetMessagebox() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Baccara.this);
        builder.setMessage("Bet " + (getBase() * 5)).setTitle("Betting");

        //AlertDialog dialog = builder.create();
        builder.setPositiveButton("Win", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                //finalAlgorithm();
                setResult(true);
            }
        });
        builder.setNegativeButton("Lose", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                setResult(false);
            }
        });
        // Set other dialog properties

        // Create the AlertDialog
        AlertDialog dialog = builder.create();

        dialog.show();
    }


    Dialog customDialogInstance;

    //Betting message
    public void betMessagebox() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Baccara.this);
        builder.setMessage("Bet " + getBet()).setTitle("Betting");

        //AlertDialog dialog = builder.create();
        builder.setPositiveButton("Win", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button\
                setResult(true);
            }
        });
        builder.setNegativeButton("Lose", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                setResult(false);
            }
        });
        // Set other dialog properties

        //stop

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog;
        switch(id) {
            case DIALOG_CUSTOM2:
                dialog = capitalMessagebox();
                customDialogInstance = dialog;
                baccaraAlgorithm();
                break;
            default:
                dialog = null;
        }
        return dialog;
    }

    /*
    public void capitalMessagebox() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Baccara.this);

        builder.setMessage("How much money do you have?").setTitle("RICH");

        // Set up the input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                setCapital(Integer.parseInt(input.getText().toString()));
                displayTextCapital(getCapital());
                setBase(getCapital() / 500);
                setBet(getBase());
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
    }
    */

    private Dialog capitalMessagebox() {
        AlertDialog.Builder builder;
        AlertDialog alertDialog;

        Context mContext = Baccara.this;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.baccara2, (ViewGroup) findViewById(R.id.layout_root));

        final EditText name = (EditText) layout.findViewById(R.id.dlgDisplayName);
        name.setInputType(InputType.TYPE_CLASS_NUMBER);
        final Button okButton = (Button) layout.findViewById(R.id.button1);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty((name.getText()))) {
                    Toast.makeText(getApplicationContext(), "capital is empty", Toast.LENGTH_SHORT).show();
                    setCapital(Integer.parseInt(name.getText().toString()));
                    displayTextCapital(getCapital());
                    setBase(getCapital() / 500);
                    setBet(getBase());
                } else {
                    Toast.makeText(getApplicationContext(), "capital is ok", Toast.LENGTH_SHORT).show();
                    customDialogInstance.dismiss();
                }
            }
        });
        final Button cancelButton = (Button)layout.findViewById(R.id.button2);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                customDialogInstance.dismiss();
            }
        });

        builder = new AlertDialog.Builder(mContext);
        builder.setView(layout);
        alertDialog = builder.create();

        return alertDialog;
    }


    public void finalbetMessagebox() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Baccara.this);
        builder.setMessage("Bet All-in! " + "Good Luck").setTitle("Betting");

        //AlertDialog dialog = builder.create();
        builder.setPositiveButton("Win", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button\
                setResult(true);
            }
        });
        builder.setNegativeButton("Lose", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                setResult(false);
            }
        });
        // Set other dialog properties

        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //이기고 질때 알고리즘
    public void winAlgorithm() {
        win += 1;
        bet = base;
        setResult(false);

        //if winnings = base * 5
        if (win == 5) {
            fivebetMessagebox();
            win = 0;

            //win
            if (isResult()) {
                setResult(false);
                capital = capital + (10 * base);
            }
            //lose
        }

        //winnings twice -> end
        if (capital >= 1000 * base) end = false;
    }

    public void loseAlgorithm() {
        setBet(getBet() * 2);

        //8 lose
        if (getBet() >= 256 * getBase()) {
            //All-in
            finalbetMessagebox();

            if (isResult()) {
                setResult(false);
                setBet(getBase());
            } else {
                end = false;
            }
        }
    }

    //setter
    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setUserslect(boolean userslect) {
        this.userslect = userslect;
    }

    //getter
    public int getCapital() {
        return capital;
    }

    public int getBase() {
        return base;
    }

    public int getBet() {
        return bet;
    }

    public boolean isResult() {
        return result;
    }

    public boolean isUserslect() {
        return userslect;
    }
}
