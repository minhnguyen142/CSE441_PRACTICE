package com.hikari.ex05_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);

        TextView textViewResult = findViewById(R.id.textViewResult);

        Button buttonSolve = findViewById(R.id.buttonSolve);
        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sa = editTextA.getText() + "";
                String sb = editTextB.getText() + "";
                String sc = editTextC.getText() + "";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String result = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if (a == 0) {
                    if (b == 0) {
                        if (c == 0)
                            result = "Phương trình vô số nghiệm";
                        else
                            result = "Phương trình vô nghiệm";
                    } else {
                        result = "Phương trình có 1 nghiệm, x = " + dcf.format(-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        result = "Phương trình vô nghiệm";
                    } else if (delta == 0) {
                        result = "Phương trình có nghiệm kép x1 = x2 = " + dcf.format(-b / (2 * a));
                    } else {
                        result = "Phương trình có 2 nghiệm: x1 = " + dcf.format((-b + Math.sqrt(delta)) / (2 * a)) + "; x2 = " + dcf.format((-
                                b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                textViewResult.setText(result);
            }
        });

        Button buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextA.setText("");
                editTextB.setText("");
                editTextC.setText("");
                editTextA.requestFocus();
            }
        });

        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thoát");
                builder.setMessage("Bạn muốn thoát không?");
                builder.setPositiveButton("Có", (dialog, which) -> finish());
                builder.setNegativeButton("Không", null);
                builder.show();
            }
        });
    }
}
