package com.bpetrean.mymusic.tasks;

import android.os.AsyncTask;

import com.bpetrean.mymusic.persistence.SongDatabase;
import com.bpetrean.mymusic.persistence.SongEntity;

import java.util.List;

public class FetchSongsTask extends AsyncTask<Void, Void, List<SongEntity>> {

    private SongDatabase database;
    private OnSongsFetchedListener listener;

    public FetchSongsTask(SongDatabase database, OnSongsFetchedListener listener) {
        this.database = database;
        this.listener = listener;
    }

    @Override
    protected List<SongEntity> doInBackground(Void... voids) {
        return database.songDao().getAll();
    }

    @Override
    protected void onPostExecute(List<SongEntity> songEntities) {
        super.onPostExecute(songEntities);
        listener.onSongsFetched(songEntities);
    }

    public interface OnSongsFetchedListener {

        void onSongsFetched(List<SongEntity> songs);
    }
}
