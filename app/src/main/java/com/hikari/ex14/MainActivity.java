package com.hikari.ex14;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextA, editTextB;
    Button buttonAdd;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> myarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();


        TabHost tab = (TabHost) findViewById(R.id.tabhost);
        tab.setup();

        TabHost.TabSpec tab1 = tab.newTabSpec("Phép cộng");
        tab1.setIndicator("Phép cộng");
        tab1.setContent(R.id.tab1);
        tab.addTab(tab1);

        TabHost.TabSpec tab2 = tab.newTabSpec("Lịch sử");
        tab2.setIndicator("Lịch sử");
        tab2.setContent(R.id.tab2);
        tab.addTab(tab2);
    }

    private void addEvent() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xulycong();
            }

            private void Xulycong() {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                String c = a + " + " + b + " = " + (a + b);
                list.add(c);
                myarray.notifyDataSetChanged();
                editTextA.setText("");
                editTextB.setText("");
            }
        });
    }

    private void addControl() {
        editTextA = (EditText) findViewById(R.id.editTextA);
        editTextB = (EditText) findViewById(R.id.editTextB);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();
        myarray = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(myarray);
    }
}