package com.example.todolist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodoListEntry.class}, version = 1)
public abstract class TodoListDatabase extends RoomDatabase {
    public abstract TodoListDao todoListDao();
}
