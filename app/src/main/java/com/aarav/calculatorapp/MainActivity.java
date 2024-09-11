package com.aarav.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDel, btnPerc, btnDivide, btnMultiply, btnMinus, btnPlus, btnEqual;
    double num1;
    String operation;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnPerc = findViewById(R.id.btnPer);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);

        TextView screen = findViewById(R.id.result);

        ArrayList<Button> nums = new ArrayList<>();

        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for (Button b : nums) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!screen.getText().toString().equals("0")) {
                        screen.setText(screen.getText().toString() + b.getText().toString());
                    } else {
                        screen.setText(b.getText().toString());
                    }
                }
            });
        }

        ArrayList<Button> op = new ArrayList<>();
        op.add(btnDivide);
        op.add(btnMultiply);
        op.add(btnMinus);
        op.add(btnPlus);
        op.add(btnPerc);

        //String n = screen.getText().toString();

//        if (n.length() > 0) {
//            btnAC.setText("DEL");
//        } else if (n.length() == 1 && !n.equals("0")) {
//            btnAC.setText("AC");
//        } else if (n.equals("0")) {
//            btnAC.setText("AC");
//        }

        for (Button b : op) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Double.parseDouble(screen.getText().toString());
                    operation = b.getText().toString();
                    screen.setText("0");
                }
            });
        }

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = screen.getText().toString();
                if (num.length() > 0) {
                    screen.setText(num.substring(0, num.length() - 1));
                } else if (num.length() == 1 && !num.equals("0")) {
                    screen.setText("0");
                    num1 = 0;
                }
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("0");
            }
        });

        Button btnDecimal = findViewById(R.id.btnDecimal);

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().contains(".")) {
                    screen.setText(screen.getText().toString() + ".");
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num2 = Double.parseDouble(screen.getText().toString());
                double result;


                switch (operation) {
                    case "/":
                        result = num1 / num2;
                        break;

                    case "X":
                        result = num1 * num2;
                        break;

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "%":
                        result = num1 % num2;
                        break;

                    default:
                        result = num1 + num2;
                }

                screen.setText(String.valueOf(result));
                num1 = result;
            }
        });

    }
}