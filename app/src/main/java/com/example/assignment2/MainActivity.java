package com.example.assignment2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/*
    Brady Goldsworthy z1816747
            and
    Justin Dupre z1835941

    Assignment 2

    Quadratic Formula Calculator
 */


public class MainActivity extends Activity {

    //declaring variables
    private EditText aET, bET, cET;
    private TextView answer1TV, answer2TV;
    private Button calcBTN, clearBTN;
    private double a, b, c, discrim, result1, result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up variables
        aET = findViewById(R.id.aEditText);
        bET = findViewById(R.id.bEditText);
        cET = findViewById(R.id.cEditText);
        answer1TV = findViewById(R.id.answerText1);
        answer2TV = findViewById(R.id.answerText2);
        calcBTN = findViewById(R.id.calcButton);
        clearBTN = findViewById(R.id.clearButton);

        //Output format for doubles
        final DecimalFormat df = new DecimalFormat("#.00");

        //Calculating
        calcBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check for valid input
                if (aET.getText().toString().matches("") || bET.getText().toString().matches("") || cET.getText().toString().matches("") || aET.getText().toString().matches("0")) {
                    Toast.makeText(v.getContext(), "invalid input", Toast.LENGTH_LONG).show();
                    return;
                }

                //Convert to double
                a = Double.parseDouble(aET.getText().toString());
                b = Double.parseDouble(bET.getText().toString());
                c = Double.parseDouble(cET.getText().toString());

                discrim = Math.pow(b, 2) - 4 * a * c;

                //results depend on the discriminate
                if (discrim > 0) { //gives two answers
                    result1 = (-b + Math.sqrt(discrim)) / (2 * a);
                    result2 = (-b - Math.sqrt(discrim)) / (2 * a);

                    answer1TV.setText(df.format(result1));
                    answer2TV.setText(df.format(result2));
                } else if (discrim == 0) { //gives one answer
                    result1 = (-b + Math.sqrt(discrim)) / (2 * a);

                    answer1TV.setText(df.format(result1));
                    answer2TV.setText(df.format(result1));
                } else { //answer is imaginary
                    answer1TV.setText("Imaginary");
                    answer2TV.setText("Imaginary");
                }
            }
        });

        //CLear text fields
        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aET.setText("");
                bET.setText("");
                cET.setText("");
                answer1TV.setText("");
                answer2TV.setText("");
            }
        });

    }
}
