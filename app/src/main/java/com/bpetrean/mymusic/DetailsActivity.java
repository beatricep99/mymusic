package com.bpetrean.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailsTextView;
    private TextView titleTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        detailsTextView=findViewById((R.id.details_second_text_view));
        titleTextView=findViewById((R.id.details_first_text_view));
        imageView=findViewById(R.id.song_image_image_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Song song = (Song) getIntent().getSerializableExtra("tag");

        titleTextView.setText(song.getName());
        detailsTextView.setText(song.getId());
        Glide.with(this).load(song.getImg()).into(imageView);


    }
}
