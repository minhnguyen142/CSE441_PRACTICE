package com.hikari.ex03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextA, editTextB, editTextResult;
    Button buttonSum, buttonSub, buttonMulti, buttonDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextResult = findViewById(R.id.editTextResult);
        buttonSum = findViewById(R.id.buttonSum);
        buttonSub = findViewById(R.id.buttonSub);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + editTextA.getText());
                int b = Integer.parseInt("0" + editTextB.getText());

                editTextResult.setText("a + b =" + (a + b));
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + editTextA.getText());
                int b = Integer.parseInt("0" + editTextB.getText());

                editTextResult.setText("a - b =" + (a - b));
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + editTextA.getText());
                int b = Integer.parseInt("0" + editTextB.getText());

                editTextResult.setText("a * b =" + (a * b));
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt("0" + editTextA.getText());
                int b = Integer.parseInt("0" + editTextB.getText());
                if (b == 0) {
                    editTextResult.setText("B phai khac 0");
                } else {
                    editTextResult.setText("a / b =" + (a / b));
                }
            }
        });

    }
}