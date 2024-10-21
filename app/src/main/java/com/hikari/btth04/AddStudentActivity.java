package com.hikari.btth04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hikari.btth04.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    private EditText edtMSSV, edtName, edtClass, edtScore;
    private Button btnSave;
    private DatabaseReference studentRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtMSSV = findViewById(R.id.edtMSSV);
        edtName = findViewById(R.id.edtName);
        edtClass = findViewById(R.id.edtClass);
        edtScore = findViewById(R.id.edtScore);
        btnSave = findViewById(R.id.btnSave);

        studentRef = FirebaseDatabase.getInstance().getReference("sinhvien");

        btnSave.setOnClickListener(v -> {
            String mssv = edtMSSV.getText().toString().trim();
            String name = edtName.getText().toString().trim();
            String lop = edtClass.getText().toString().trim();
            String diemStr = edtScore.getText().toString().trim();

            if (mssv.isEmpty() || name.isEmpty() || lop.isEmpty() || diemStr.isEmpty()) {
                Toast.makeText(AddStudentActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            double diem = Double.parseDouble(diemStr);

            studentRef.child(mssv).setValue(new Student(mssv, name, lop, diem))
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(AddStudentActivity.this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(AddStudentActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show());
        });
    }
}


