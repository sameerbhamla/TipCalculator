package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {
    //creating variables
    Button buttonCompute; //button
    EditText fifteenTip, twentyTip, twentyfiveTip, fifteenTotal, twentyfiveTotal, twentyTotal, checkAmount, partySize;
    float amount;
    int tip15, tip20, tip25, total15, total20, total25;
    int party;

    Toast f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all id's
        checkAmount = (EditText)findViewById(R.id.checkAmountValue);
        partySize = (EditText)findViewById(R.id.partySizeValue);
        fifteenTip = (EditText)findViewById(R.id.fifteenPercentTipValue);
        twentyTip = (EditText)findViewById(R.id.twentyPercentTipValue);
        twentyfiveTip = (EditText)findViewById(R.id.twentyfivePercentTipValue);
        fifteenTotal = (EditText)findViewById(R.id.fifteenPercentTotalValue);
        twentyTotal = (EditText)findViewById(R.id.twentyPercentTotalValue);
        twentyfiveTotal = (EditText)findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute = (Button)findViewById(R.id.buttonCompute);

//perform action listener when click
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the values
                if(checkAmount.getText().toString().isEmpty() || partySize.getText().toString().isEmpty()){
                    f1.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }else {
                    amount = Float.parseFloat(checkAmount.getText().toString());
                    party = Integer.parseInt(partySize.getText().toString());

                    //tip calculations
                    tip15 = (int) (((amount / party) * 15) / 100) + 1;
                    tip20 = (int) (((amount / party) * 20) / 100);
                    tip25 = (int) (((amount / party) * 25) / 100) + 1;

                    //total calculations
                    total15 = (int) ((amount / party) + tip15);
                    total20 = (int) ((amount / party) + tip20);
                    total25 = (int) ((amount / party) + tip25);

                    //setting the final values
                    fifteenTip.setText("" + tip15);
                    twentyTip.setText("" + tip20);
                    twentyfiveTip.setText("" + tip25);
                    fifteenTotal.setText("" + total15);
                    twentyTotal.setText("" + total20);
                    twentyfiveTotal.setText("" + total25);
                }
            }
        });
    }
}