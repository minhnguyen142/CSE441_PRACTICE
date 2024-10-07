package com.hikari.ex07_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText editTextA, editTextB;
        Button button_sum, button_subtract;
        Intent myintent;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        button_sum = findViewById(R.id.button_sum);
        button_subtract = findViewById(R.id.button_subtract);
        myintent = getIntent();
        int a = myintent.getIntExtra("soa", 0);
        int b = myintent.getIntExtra("sob", 0);
        editTextA.setText(a + "");
        editTextB.setText(b + "");
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = a + b;
                myintent.putExtra("kq", sum);
                setResult(33, myintent);
                finish();
            }
        });
        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sub = a - b;
                myintent.putExtra("kq", sub);
                setResult(34, myintent);
                finish();
            }
        });
    }
}
