package com.hikari.ex04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextCelsius, editTextFahrenheit;
    Button buttonToFahrenheit, buttonToCelsius, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        buttonToCelsius = findViewById(R.id.buttonToCelsius);
        buttonClear = findViewById(R.id.buttonClear);
        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = editTextCelsius.getText() + "";
//
                int C = Integer.parseInt(doC);
                editTextFahrenheit.setText("" + dcf.format(C * 1.8 + 32));
            }
        });
        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");

                String doF = editTextFahrenheit.getText() + "";
                int F = Integer.parseInt(doF);
                editTextCelsius.setText("" + dcf.format((F - 32) / 1.8));
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextCelsius.setText("");
                editTextFahrenheit.setText("");
            }
        });
    }
}