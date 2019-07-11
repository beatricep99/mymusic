package com.bpetrean.mymusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataset;
    private OnSongClickedListener listener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            view = v;
            textView = v.findViewById(R.id.song_title_text_view);
        }

        public void bind(String text, final OnSongClickedListener listener) {
            textView.setText(text);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSongClicked();
                }
            });
        }
    }

    public MyAdapter(String[] myDataset, OnSongClickedListener listener) {
        mDataset = myDataset;
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
        holder.bind(mDataset[position], listener);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    /**
     * This interface is used in order to handle the click on a song in the songs list.
     */
    public interface OnSongClickedListener {

        void onSongClicked();
    }
}