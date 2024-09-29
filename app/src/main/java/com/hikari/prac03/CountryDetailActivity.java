package com.hikari.prac03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hikari.prac03.entity.Country;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_country_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        ImageView flagImage = findViewById(R.id.flagImage);
        TextView tvCountryName = findViewById(R.id.tvCountryName);
        TextView tvCapital = findViewById(R.id.tvCapital);
        TextView tvPopulation = findViewById(R.id.tvPopulation);
        TextView tvArea = findViewById(R.id.tvArea);
        TextView tvDensity = findViewById(R.id.tvDensity);
        TextView tvWorldShare = findViewById(R.id.tvWorldShare);

        Country country = (Country) getIntent().getSerializableExtra("Country");


        StringBuilder stringBuilder = new StringBuilder();

        flagImage.setImageResource(country.getFlag());
        tvCountryName.setText(stringBuilder.append("Nation: ").append(country.getName()).toString());
        tvCapital.setText(stringBuilder.append("Capital: " ).append(country.getCapital()).toString());
        tvPopulation.setText(stringBuilder.append("Population: ").append((int) country.getPopulation()).toString());
        tvArea.setText(stringBuilder.append("Area: ").append((int) country.getArea()));
        tvDensity.setText(stringBuilder.append("Density: ").append((int) country.getDensity()).toString());
        tvWorldShare.setText(stringBuilder.append("World Share: ").append((int) country.getWorldShare()).toString());;

    }
}