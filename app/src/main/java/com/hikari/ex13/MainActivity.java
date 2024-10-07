package com.hikari.ex13;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView selectionTextView;

    AutoCompleteTextView autoTextView;

    MultiAutoCompleteTextView multiAutoCompleteTextView;

    String arr[] = {"hà nội", "Huế", "Sài Gòn", "Hà Giang", "hội an", "Kiên giang", "Lâm đồng", "Long Khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectionTextView = findViewById(R.id.SelectionTextView);

        autoTextView = findViewById(R.id.AutoTextView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arr);
        autoTextView.setAdapter(arrayAdapter);

        multiAutoCompleteTextView = findViewById(R.id.MultiAutoTextView);

        multiAutoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arr));

        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}