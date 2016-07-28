package com.example.songsiho.baccara;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;
import com.example.songsiho.baccara.Baccara;

/**
 * Created by Songsiho on 2016-07-29.
 */
public class CapitalMessageBox1 extends Baccara{
    @Override
    public int getCapital() {
        return super.getCapital();
    }
    @Override
    public void setCapital(int capital) {
        super.setCapital(capital);
    }

    public void capitalMessageBox()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("How much money do you have?").setTitle("Capital");

        final EditText input = new EditText(this);
        builder.setView(input);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        // Add the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                // User clicked OK button
                setCapital(Integer.parseInt(input.getText().toString()));
                displayTextCapital(getCapital());
            }
        });
        // Set other dialog properties

        // Create the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
