package com.bpetrean.mymusic.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bpetrean.mymusic.players.Playable;
import com.bpetrean.mymusic.players.PlayableFactory;
import com.bpetrean.mymusic.R;
import com.bpetrean.mymusic.persistence.SongEntity;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailsTextView;
    private TextView titleTextView;
    private ImageView imageView;
    private FloatingActionButton button;
    private ScrollView scrollView;

    private SongEntity song;
    TextView txtend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        txtend = (TextView) findViewById(R.id.song_title_text_view);
        //txtend.setSelected(true);

        song = (SongEntity) getIntent().getSerializableExtra("tag");

        detailsTextView = findViewById((R.id.details_second_text_view));
        titleTextView = findViewById((R.id.details_first_text_view));
        imageView = findViewById(R.id.song_image_image_view);
        button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Playable playable = PlayableFactory.getPlayable(song.getSource());
                String uri = playable.getId(song.getSongUri());
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(appIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        titleTextView.setText(song.getTitle());
        detailsTextView.setText(song.getId());
        Glide.with(this).load(song.getImageUrl()).into(imageView);


    }
}
