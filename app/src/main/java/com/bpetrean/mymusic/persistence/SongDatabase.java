package com.bpetrean.mymusic.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SongEntity.class}, version = 1)
public abstract class SongDatabase extends RoomDatabase {

    public abstract SongDao songDao();
}


