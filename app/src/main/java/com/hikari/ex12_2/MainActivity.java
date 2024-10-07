package com.hikari.ex12_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapater;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edth = findViewById(R.id.HourEditText);
        edtm = findViewById(R.id.MinuteEditText);
        edtwork = findViewById(R.id.WorkEditText);
        btnwork = findViewById(R.id.AddButton);
        lv = findViewById(R.id.WorkListView);
        txtdate = findViewById(R.id.DateTextView);

        arraywork = new ArrayList<>();

        arrAdapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);

        lv.setAdapter(arrAdapater);

        Date currentDate = Calendar.getInstance().getTime();

        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");

        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("") || edtm.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                } else {
                    String str = edtwork.getText().toString() + " - " + edth.getText().toString() + ":" + edtm.getText().toString();
                    arraywork.add(str);
                    arrAdapater.notifyDataSetChanged();
                    edth.setText("");
                    edtm.setText("");
                    edtwork.setText("");
                }
            }
        });
    }
}