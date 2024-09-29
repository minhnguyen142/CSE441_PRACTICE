package com.hikari.prac03;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hikari.prac03.entity.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private final Context context;
    private final List<Country> countries;

    public CountryAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.flagImage.setImageResource(country.getFlag());
        holder.tvCountryName.setText(country.getName());
        holder.tvCapital.setText(country.getCapital());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CountryDetailActivity.class);
            intent.putExtra("country", String.valueOf(country));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImage;
        TextView tvCountryName;
        TextView tvCapital;
        TextView tvPopulation;
        TextView tvArea;
        TextView tvDensity;
        TextView tvWorldShare;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.flagImage);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            tvCapital = itemView.findViewById(R.id.tvCapital);
            tvPopulation = itemView.findViewById(R.id.tvPopulation);
            tvArea = itemView.findViewById(R.id.tvArea);
            tvDensity = itemView.findViewById(R.id.tvDensity);
            tvWorldShare = itemView.findViewById(R.id.tvWorldShare);
        }
    }


}
