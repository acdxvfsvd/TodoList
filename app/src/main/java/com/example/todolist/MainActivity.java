package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EntryAdapter mEntryAdapter = new EntryAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TodoListDatabase db = Room.databaseBuilder(getApplicationContext(),
                TodoListDatabase.class, "todolist").allowMainThreadQueries().build();

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mEntryAdapter);

        List<TodoListEntry> entries = db.todoListDao().getAll();
        for (TodoListEntry entry:
             entries) {
            Log.d("TodoList", entry.content);
        }
        mEntryAdapter.notifyItems(entries);

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        onCreate(null);
//    }
}