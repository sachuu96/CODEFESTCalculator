package com.example.sachi.codefest_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    private Button zero,one,two,three,four,five,six,seven,eight,nine,dot,clear;
    private TextView finalResult,middleResult;
    private Double num1 = Double.NaN;
    private Double num2;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUATION = 0;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewsByIds();

    }

    //using this method get the views into variables
    private void setViewsByIds()
    {
        finalResult = (TextView)findViewById(R.id.textView4);
        zero = (Button)findViewById(R.id.button);
        one = (Button)findViewById(R.id.button28);
        two = (Button)findViewById(R.id.button27);
        three = (Button)findViewById(R.id.button26);
        four = (Button)findViewById(R.id.button32);
        five = (Button)findViewById(R.id.button31);
        six = (Button)findViewById(R.id.button30);
        seven = (Button)findViewById(R.id.button33);
        eight = (Button)findViewById(R.id.button34);
        nine = (Button)findViewById(R.id.button35);
        dot = (Button)findViewById(R.id.button2);
        clear = (Button)findViewById(R.id.button37);
        middleResult = (TextView)findViewById(R.id.textView);
    }

    //set text for numeric values
    public void onClickZero(View v)
    {
        middleResult.append(zero.getText().toString());
    }

    public void onClickOne(View v)
    {
        middleResult.append(one.getText().toString());
    }

    public void onClickTwo(View v)
    {
        middleResult.append(two.getText().toString());
    }

    public void onClickThree(View v)
    {
        middleResult.append(three.getText().toString());
    }

    public void onClickfour(View v)
    {
        middleResult.append(four.getText().toString());
    }

    public void onClickfive(View v)
    {
        middleResult.append(five.getText().toString());
    }

    public void onClickSix(View v)
    {
        middleResult.append(six.getText().toString());
    }

    public void onClickSeven(View v)
    {
        middleResult.append(seven.getText().toString());
    }

    public void onClickEight(View v)
    {
        middleResult.append(eight.getText().toString());
    }

    public void onClickNine(View v)
    {
        middleResult.append(nine.getText().toString());
    }

    public void onClickDot(View v)
    {
        middleResult.append(dot.getText().toString());
    }

    public void onClickClear(View v)
    {
        if(middleResult.getText().length()>0)
        {
            CharSequence seq = middleResult.getText().toString();
            middleResult.setText(seq.subSequence(0,seq.length()-1));
        }
        else
        {
            num1 = Double.NaN;
            num2 = Double.NaN;
            middleResult.setText(null);
            finalResult.setText(null);
        }

    }

    //function to do erithmetic operations
    public void doOperations()
    {

        if (!Double.isNaN(num1)){

            num2=Double.parseDouble(middleResult.getText().toString());


            switch (ACTION){

                case ADDITION:
                    num1=num1+num2;
                    break;
                case SUBTRACTION:
                    num1=num1-num2;
                    break;
                case MULTIPLICATION:
                    num1=num1*num2;
                    break;
                case DIVISION:
                    num1=num1/num2;
                    break;
                case EQUATION:
                    break;

            }

        }
        else {

            num1=Double.parseDouble(middleResult.getText().toString());

        }

    }

    //button click event on addition
    public void onClickAddition(View v)
    {
        if(middleResult.getText().length()==0)
        {

            Toast.makeText(MainActivity.this,"Syntax Error",Toast.LENGTH_LONG).show();
        }
        else
        {
            doOperations();
            ACTION = ADDITION;
            finalResult.setText(String.valueOf(num1)+" + ");
            middleResult.setText(null);
        }
    }

    public void onClickSubtraction(View v)
    {
        if(middleResult.getText().length()==0)
        {
            middleResult.append("-");
        }
        else
        {
            doOperations();
            ACTION = SUBTRACTION;
            finalResult.setText(String.valueOf(num1)+" - ");
            middleResult.setText(null);
        }
    }

    public void onClickDevition(View v)
    {
        if(middleResult.getText().length()==0)
        {
            Toast.makeText(MainActivity.this,"Syntax Error",Toast.LENGTH_LONG).show();
        }
        else
        {
            doOperations();
            ACTION = DIVISION;
            finalResult.setText(String.valueOf(num1)+" / ");
            middleResult.setText(null);
        }
    }

    public void onClickMultiplication(View v)
    {
        if(middleResult.getText().length()==0)
        {
            Toast.makeText(MainActivity.this,"Syntax Error",Toast.LENGTH_LONG).show();
        }
        else
        {
            doOperations();
            ACTION = MULTIPLICATION;
            finalResult.setText(String.valueOf(num1)+" * ");
            middleResult.setText(null);
        }
    }

    //do operations on click of equal button
    public void onClickEqual(View v)
    {
        if(middleResult.getText().length()==0)
        {
            Toast.makeText(MainActivity.this,"Syntax Error",Toast.LENGTH_LONG).show();
        }

        else
        {
            doOperations();
            ACTION = EQUATION;
            finalResult.setText(finalResult.getText().toString()+String.valueOf(num2)+" = "+String.valueOf(num1));
            middleResult.setText(null);
            Toast.makeText(MainActivity.this,"Final Value",Toast.LENGTH_LONG).show();
        }

    }


}
