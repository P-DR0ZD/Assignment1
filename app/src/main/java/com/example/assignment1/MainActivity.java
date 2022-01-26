package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Calculator calculator;
    TextView textBox;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnC;
    Button btn0;
    Button btnEquals;

    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;

    Button btnAdv;

    Button btnMod;
    Button btnPow;
    Button btnMax;
    Button btnMin;

    LinearLayout adv;

    boolean isEqual = false;
    boolean isAdv = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = findViewById(R.id.calculatorTextBox);

        calculator = new Calculator();

        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);


        btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);

        btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);

        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);

        btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(this);

        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(this);

        btnAdv = findViewById(R.id.btnAdv);
        btnAdv.setOnClickListener(this);

        btnMod = findViewById(R.id.btnModulus);
        btnMod.setOnClickListener(this);

        btnPow = findViewById(R.id.btnPow);
        btnPow.setOnClickListener(this);

        btnMax = findViewById(R.id.btnMax);
        btnMax.setOnClickListener(this);

        btnMin = findViewById(R.id.btnMin);
        btnMin.setOnClickListener(this);

        adv = findViewById(R.id.advLayout);
    }


    @Override
    public void onClick(View view) {
        if (isEqual)
        {
            textBox.setText("");
            calculator.clear();
            isEqual = false;
        }
        int id = view.getId();
        if (id == R.id.btnC)
        {
            textBox.setText("");
            calculator.clear();
        }
        else if (id == R.id.btnEquals)
        {
            String tmp = textBox.getText().toString();
            textBox.setText("");
            String sum;
            try {
                 sum = Integer.toString(calculator.calculate());
            } catch (Exception e) {
                sum = e.getMessage();
            }

            textBox.append(tmp.concat(" = " + sum));
            isEqual = true;
        }
        else if (id == R.id.btnAdv)
        {
            if (!isAdv) {
                adv.setVisibility(View.VISIBLE);
                isAdv = true;
                btnAdv.setText("Standard");
            }
            else
            {
                adv.setVisibility(View.INVISIBLE);
                isAdv = false;
                btnAdv.setText("Advanced - Scientific");
            }
        }
        else
        {
            textBox.setText("");
            Button tmp = findViewById(id);
            calculator.push(tmp.getText().toString());

            for (String app: calculator.expression)
            textBox.append(" " + app);
        }
    }
}