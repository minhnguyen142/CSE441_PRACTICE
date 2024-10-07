package com.hikari.ex07_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextA, editTextB, editTextResult;
    private Button btnrequest;

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
        editTextResult = findViewById(R.id.editTextResult);
        btnrequest = findViewById(R.id.btnrequest);
        btnrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                myintent.putExtra("soa", a);
                myintent.putExtra("sob", b);
                startActivityForResult(myintent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            int sum = data.getIntExtra("kq", 0);
            editTextResult.setText(sum);
        }
        if (requestCode == 99 && resultCode == 34) {
            int sub = data.getIntExtra("kq", 0);
            editTextResult.setText(sub);
        }
    }
}