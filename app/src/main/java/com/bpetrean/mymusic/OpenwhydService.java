package com.bpetrean.mymusic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenwhydService {

    @GET("adrien/playlist/10?format=json&limit=5000")
    Call<List<Song>> fetchSongs();
}
