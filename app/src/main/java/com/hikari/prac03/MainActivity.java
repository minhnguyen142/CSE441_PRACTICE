package com.hikari.prac03;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hikari.prac03.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCountries;

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

        List<Country> countries = new ArrayList<>();
        countries.add(new Country(R.drawable.uk, "United Kingdom", "London", 66.97, 243.610, 279, 2.3));
        countries.add(new Country(R.drawable.japan, "Japan", "Tokyo", 125.1, 377.973, 338, 1.4));


        rvCountries = findViewById(R.id.rvCountries);
        rvCountries.setAdapter(new CountryAdapter(this, countries));
        rvCountries.setLayoutManager(new LinearLayoutManager(this));
        rvCountries.setHasFixedSize(true);

    }

}