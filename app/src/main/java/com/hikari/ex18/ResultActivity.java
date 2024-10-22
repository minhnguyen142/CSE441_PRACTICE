package com.hikari.ex18;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hikari.ex18.entity.Song;

public class ResultActivity extends AppCompatActivity {
    private TextView txtSongId, txtSongName, txtAuthor, txtLyric;
    private ImageView imgFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupViews();
    }

    private void setupViews() {
        txtSongId = findViewById(R.id.res_txt_song_id);
        txtSongName = findViewById(R.id.res_txt_song_name);
        txtAuthor = findViewById(R.id.res_txt_author);
        txtLyric = findViewById(R.id.res_txt_lyrics);
        imgFavorite = findViewById(R.id.btnDislike);

        Song song = (Song) getIntent().getSerializableExtra("song");
        txtSongId.setText(song.getId());
        txtSongName.setText(song.getName());
        txtAuthor.setText(song.getAuthor());
        txtLyric.setText(song.getLyric());
        imgFavorite.setImageResource(song.isFavorite()==1 ? R.drawable.ic_favorite_24 : R.drawable.ic_favorite_border_24);
        imgFavorite.setOnClickListener(v -> {
            song.setFavorite(song.isFavorite()==1 ? 0 : 1);
            imgFavorite.setVisibility(View.VISIBLE );
            imgFavorite.setImageResource(song.isFavorite()==1 ? R.drawable.ic_favorite_24 : R.drawable.ic_favorite_border_24);
            ContentValues values = new ContentValues();
            values.put("favorite", song.isFavorite());
            MainActivity.db.update("songs", values, "id = ?", new String[]{song.getId()});
//            finish();
        });

        imgFavorite.setOnClickListener(v -> {
            song.setFavorite(song.isFavorite() ==1? 0 : 1);
            imgFavorite.setVisibility( View.VISIBLE );
            imgFavorite.setImageResource(song.isFavorite()==1 ? R.drawable.ic_favorite_24 : R.drawable.ic_favorite_border_24);
            ContentValues values = new ContentValues();
            values.put("favorite", song.isFavorite());
            MainActivity.db.update("songs", values, "id = ?", new String[]{song.getId()});
        });

    }
}