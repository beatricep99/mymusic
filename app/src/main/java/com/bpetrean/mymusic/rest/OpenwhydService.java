package com.bpetrean.mymusic.rest;

import com.bpetrean.mymusic.json.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenwhydService {

    @GET("https://openwhyd.org/bpetrean/playlist/0?format=json&limit=100000")
    Call<List<Song>> fetchSongs();
}
