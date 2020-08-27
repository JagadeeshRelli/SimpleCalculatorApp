package com.example.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button z, o, t, th, f, fi, s, se, e, n, mul, minus, div, plus, equals, clear;
    private TextView txt, txt2;
    //txt is big result display, txt2 is small display for expression showing(top one)
    private double val1 = Double.NaN;
    private double val2;
    //for use in switch case in switching operations
    private final char PLUS = '+';
    private final char MINUS = '-';
    private final char DIV = '/';
    private final char MUL = '*';
    //switch case variable to select which type of actiont to be performed
    private char ACTION;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        z = findViewById(R.id.zero);
        o = findViewById(R.id.one);
        t = findViewById(R.id.two);
        th = findViewById(R.id.three);
        f = findViewById(R.id.four);
        fi = findViewById(R.id.five);
        s = findViewById(R.id.six);
        se = findViewById(R.id.seven);
        e = findViewById(R.id.eight);
        n = findViewById(R.id.nine);
        mul = findViewById(R.id.mul);
        plus = findViewById(R.id.plus);
        div = findViewById(R.id.div);
        minus = findViewById(R.id.minus);
        equals = findViewById(R.id.equals);
        clear = findViewById(R.id.clear);

        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);

//setting onclick listeners for every button

        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "0");

            }
        });

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "1");

            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "2");

            }
        });

        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "3");

            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "4");

            }
        });
        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "5");

            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "6");

            }
        });
        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "7");

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "8");

            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(txt.getText().toString() + "9");

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute();
                ACTION = PLUS;
                txt.setText(null);
                txt2.setText(String.valueOf(val1) + "+");


            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ACTION = MINUS;
                compute();

                txt.setText(null);
                txt2.setText(String.valueOf(val1) + "-");


            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute();
                ACTION = DIV;
                txt.setText(null);
                txt2.setText(String.valueOf(val1) + "/");


            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute();
                ACTION = MUL;
                txt.setText(null);
                txt2.setText(String.valueOf(val1) + "*");


            }
        });
/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//totally clearing the display
                val1 = Double.NaN;
                val2 = Double.NaN;
                txt.setText(null);
                txt2.setText(null);


            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ACTION = EQUALS;
                compute();


                txt.setText(String.valueOf(val1));
                txt2.setText(null);


            }
        });


    }

    //separate function for computing
    public void compute() {
        if (!Double.isNaN(val1)) {

            val2 = Double.parseDouble(txt.getText().toString());

            switch (ACTION) {
                case PLUS:
                    val1 = val1 + val2;
                    break;

                case MUL:
                    val1 = val1 * val2;
                    break;
                case MINUS:
                    val1 = val1 - val2;
                    break;
                case DIV:
                    val1 = val1 / val2;
                    break;


            }
        } else {
            val1 = Double.parseDouble(txt.getText().toString());

        }
    }


}