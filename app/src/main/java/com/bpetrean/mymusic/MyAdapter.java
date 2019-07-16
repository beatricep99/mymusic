package com.bpetrean.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Song> songs;
    private OnSongClickedListener listener;

    public MyAdapter(Context context, List<Song> songs, OnSongClickedListener listener) {
        this.context=context;
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
        holder.bind(this.context,songs.get(position), listener);
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

        public MyViewHolder(View v) {
            super(v);
            view = v;
            titleTextView = v.findViewById(R.id.song_title_text_view);
            detailsTextView= v.findViewById(R.id.song_title2_text_view);
            imageView=v.findViewById(R.id.song_image_image_view);
        }

        public void bind(Context context, final Song song, final OnSongClickedListener listener) {
            String songName;
            String songAuthor;
            String[] parts = song.getName().split("-");

            if (parts.length < 2) {
                songName = parts[0];
                songAuthor = "Unknown author";
            } else {
                songAuthor = parts[0];
                songName = parts[1];
                if (songName.startsWith(" ")) {
                     songName = songName.substring(1);
                }
            }

            titleTextView.setText(songName);
            detailsTextView.setText(songAuthor);
            Glide.with(context).load(song.getImg()).into(imageView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSongClicked(song);
                }
            });
        }
    }

    /**
     * This interface is used in order to handle the click on a song in the songs list.
     */
    public interface OnSongClickedListener {

        void onSongClicked(Song song);
    }
}