package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Button button = (Button)findViewById(R.id.takeNoteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextNote);
                String noteText = editText.getText().toString();

                TodoListDatabase db = Room.databaseBuilder(getApplicationContext(),
                        TodoListDatabase.class, "todolist").allowMainThreadQueries().build();

                // getApplicationContext().

                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                db.todoListDao().InsertEntry(sdf.format(date), noteText);
                Intent intent = new Intent(NoteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}