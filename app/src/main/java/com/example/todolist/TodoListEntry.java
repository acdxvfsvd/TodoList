package com.example.todolist;


import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

import java.util.Date;

@Entity
public class TodoListEntry {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "entryTime")
    public String entryTime;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "isFinished")
    public int isFinished;

}
