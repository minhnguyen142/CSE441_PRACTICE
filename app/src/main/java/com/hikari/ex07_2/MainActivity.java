package com.hikari.ex07_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA, editTextB;
    private Button buttonResult, buttonBack;
    private TextView textViewResult;

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
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonResult = findViewById(R.id.buttonResult);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle1 = new Bundle();
                int a = Integer.parseInt(editTextA.getText() + "");
                int b = Integer.parseInt(editTextB.getText() + "");
                bundle1.putInt("soa", a);
                bundle1.putInt("sob", b);
                myintent.putExtra("mypackage", bundle1);
                startActivity(myintent);
            }
        });
    }
}