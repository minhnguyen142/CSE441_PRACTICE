package com.hikari.btth04;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hikari.btth04.model.Student;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<Student, StudentViewHolder> adapter;
    private DatabaseReference studentRef;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Firebase reference to "sinhvien" node
        studentRef = FirebaseDatabase.getInstance().getReference("sinhvien");

        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });

        FirebaseRecyclerOptions<Student> options = new FirebaseRecyclerOptions.Builder<Student>()
                .setQuery(studentRef, Student.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Student, StudentViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull StudentViewHolder holder, int position, @NonNull Student model) {
                holder.setDetails(model);
                holder.btnEdit.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, EditStudentActivity.class);
                    intent.putExtra("mssv", getRef(position).getKey());
                    startActivity(intent);
                });

                holder.btnDelete.setOnClickListener(v -> studentRef.child(Objects.requireNonNull(getRef(position).getKey())).removeValue());
            }

            @NonNull
            @Override
            public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
                return new StudentViewHolder(view);
            }
        };

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}


