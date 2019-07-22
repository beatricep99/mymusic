package com.bpetrean.mymusic.tasks;

import android.os.AsyncTask;

import com.bpetrean.mymusic.json.Song;
import com.bpetrean.mymusic.persistence.SongDatabase;
import com.bpetrean.mymusic.persistence.SongEntity;

import java.util.ArrayList;
import java.util.List;

public class InsertSongTask extends AsyncTask<Void, Void, Void> {

    private List<Song> songs;
    private SongDatabase songDatabase;
    private OnSongsInsertedListener listener;

    public InsertSongTask(List<Song> songs, SongDatabase database, OnSongsInsertedListener listener) {
        this.songs = songs;
        this.songDatabase = database;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        List<SongEntity> songEntities = new ArrayList<>();
        for (Song song : songs) {
            SongEntity songEntity = new SongEntity();
            songEntity.setId(song.getId());
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
            songEntity.setAuthor(songAuthor);
            songEntity.setTitle(songName);
            songEntity.setSource(song.getEId().substring(0, 3));
            songEntity.setImageUrl(song.getImg());
            songEntity.setSongUri(song.getEId());
            songEntities.add(songEntity);
        }
        songDatabase.songDao().insert(songEntities);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onSongsInserted();
    }

    public interface OnSongsInsertedListener {

        void onSongsInserted();
    }
}
