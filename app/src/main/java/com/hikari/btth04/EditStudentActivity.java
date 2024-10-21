package com.hikari.btth04;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hikari.btth04.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    private EditText edtName, edtClass, edtScore;
    private Button btnUpdate;
    private DatabaseReference studentRef;
    private String mssv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        edtName = findViewById(R.id.edtName);
        edtClass = findViewById(R.id.edtClass);
        edtScore = findViewById(R.id.edtScore);
        btnUpdate = findViewById(R.id.btnUpdate);

        studentRef = FirebaseDatabase.getInstance().getReference("sinhvien");
        mssv = getIntent().getStringExtra("mssv");

        edtName.setText("");
        edtClass.setText("");
        edtScore.setText("");

        studentRef.child(mssv).get().addOnSuccessListener(snapshot -> {
            if (snapshot.exists()) {
                Student student = snapshot.getValue(Student.class);
                if (student != null) {
                    edtName.setText(student.getHoten());
                    edtClass.setText(student.getLop());
                    edtScore.setText(String.valueOf(student.getDiem()));
                }
            }
        });

        studentRef.child(mssv).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Student student = snapshot.getValue(Student.class);
                if (student != null) {
                    edtName.setText(student.getHoten());
                    edtClass.setText(student.getLop());
                    edtScore.setText(String.valueOf(student.getDiem()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EditStudentActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String lop = edtClass.getText().toString().trim();
            String diemStr = edtScore.getText().toString().trim();

            if (name.isEmpty() || lop.isEmpty() || diemStr.isEmpty()) {
                Toast.makeText(EditStudentActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            double diem = Double.parseDouble(diemStr);

            studentRef.child(mssv).setValue(new Student(mssv, name, lop, diem))
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(EditStudentActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(EditStudentActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show());
        });
    }
}

