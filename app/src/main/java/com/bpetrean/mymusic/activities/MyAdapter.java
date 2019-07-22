package com.bpetrean.mymusic.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bpetrean.mymusic.R;
import com.bpetrean.mymusic.persistence.SongEntity;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<SongEntity> songs;
    private OnSongClickedListener listener;

    public MyAdapter(Context context, List<SongEntity> songs, OnSongClickedListener listener) {
        this.context = context;
        this.songs = songs;
        this.listener = listener;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(this.context, songs.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView detailsTextView;
        public ImageView imageView;
        public TextView titleTextView;
        public ImageView sourceTextView;

        public MyViewHolder(View v) {
            super(v);
            view = v;
            titleTextView = v.findViewById(R.id.song_title_text_view);
            detailsTextView = v.findViewById(R.id.song_details_text_view);
            imageView = v.findViewById(R.id.song_image_image_view);
            sourceTextView = v.findViewById(R.id.song_source_image_view);
        }

        public void bind(Context context, final SongEntity song, final OnSongClickedListener listener) {
            titleTextView.setText(song.getTitle());
            detailsTextView.setText(song.getAuthor());
            sourceTextView.setImageDrawable(getSongSourceImage(context, song.getSource()));
            Glide.with(context).load(song.getImageUrl()).into(imageView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSongClicked(song);
                }
            });
        }

        public Drawable getSongSourceImage(Context context, String source) {
            switch (source) {
                case "/yt":
                    return context.getResources().getDrawable(R.drawable.ic_youtube_svg);
                case "/sc":
                    return context.getResources().getDrawable(R.drawable.ic_soundcloud_svg);
                case "/vi":
                    return context.getResources().getDrawable(R.drawable.ic_vinevimeo_svg);
                default:
                    return context.getResources().getDrawable(R.drawable.ic_youtube_svg);
            }
        }
    }


    /**
     * This interface is used in order to handle the click on a song in the songs list.
     */
    public interface OnSongClickedListener {

        void onSongClicked(SongEntity song);
    }
}