package com.bpetrean.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnSongClickedListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Name", "onCreate");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        // layout manager used by the recycler view
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(myDataset, this);
        recyclerView.setAdapter(mAdapter);
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
    public void startDetailsActivity() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSongClicked() {
        startDetailsActivity();
    }
}
