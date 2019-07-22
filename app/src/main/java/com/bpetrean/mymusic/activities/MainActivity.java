package com.bpetrean.mymusic.activities;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bpetrean.mymusic.tasks.FetchSongsTask;
import com.bpetrean.mymusic.tasks.InsertSongTask;
import com.bpetrean.mymusic.rest.OpenwhydService;
import com.bpetrean.mymusic.R;
import com.bpetrean.mymusic.json.Song;
import com.bpetrean.mymusic.persistence.SongDatabase;
import com.bpetrean.mymusic.persistence.SongEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements MyAdapter.OnSongClickedListener, Callback<List<Song>>,
        SwipeRefreshLayout.OnRefreshListener, InsertSongTask.OnSongsInsertedListener, FetchSongsTask.OnSongsFetchedListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Name", "onCreate");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        // layout manager used by the recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        fetchSongs();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("Swipe", "On refresh");
                fetchSongs();
            }
        });
    }

    @Override
    protected void onPause() {
        Log.d("Name", "onPause");
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Name", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void fetchSongs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openwhyd.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenwhydService service = retrofit.create(OpenwhydService.class);
        service.fetchSongs().enqueue(this);
        Log.d("Name", "onResume");
    }


    @Override
    protected void onStop() {
        Log.d("Name", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Name", "onDestroy");
        super.onDestroy();

    }

    /**
     * This method creates an {@link Intent} using {@link MainActivity} as context and
     * {@link DetailsActivity} as targeted activity and calls {@link android.app.Activity#startActivity(Intent)}
     * in order to start the above mentioned target activity.
     */
    public void startDetailsActivity(SongEntity song) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("tag", song);
        startActivity(intent);
    }

    @Override
    public void onSongClicked(SongEntity song) {
        startDetailsActivity(song);
    }

    @Override
    public void onResponse(@NonNull Call<List<Song>> call, @NonNull Response<List<Song>> response) {
        SongDatabase songDatabase = Room.databaseBuilder(getApplicationContext(),
                SongDatabase.class, "songs").build();
        InsertSongTask task = new InsertSongTask(response.body(), songDatabase, this);
        task.execute();
    }

    @Override
    public void onFailure(@NonNull Call<List<Song>> call, @NonNull Throwable t) {
        Log.d("Name", "Ups something is wrong: " + t.getLocalizedMessage());
        swipeRefreshLayout.setRefreshing(false);
        SongDatabase songDatabase = Room.databaseBuilder(getApplicationContext(),
                SongDatabase.class, "songs").build();
        FetchSongsTask task = new FetchSongsTask(songDatabase, this);
        task.execute();
    }

    @Override
    public void onRefresh() {
        fetchSongs();
    }

    @Override
    public void onSongsInserted() {
        SongDatabase songDatabase = Room.databaseBuilder(getApplicationContext(),
                SongDatabase.class, "songs").build();
        FetchSongsTask task = new FetchSongsTask(songDatabase, this);
        task.execute();
    }

    @Override
    public void onSongsFetched(List<SongEntity> songs) {
        RecyclerView.Adapter mAdapter = new MyAdapter(this, songs, this);
        recyclerView.setAdapter(mAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }
}
