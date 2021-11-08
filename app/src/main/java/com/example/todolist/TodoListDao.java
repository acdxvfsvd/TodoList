package com.example.todolist;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface TodoListDao {
    @Query("INSERT INTO todoListEntry(entryTime, content, isFinished) VALUES(:datetime, :content, 0)")
    void InsertEntry(String datetime, String content);

    @Query("SELECT * from todoListEntry")
    List<TodoListEntry> getAll();

    @Query("UPDATE todoListEntry SET isFinished=:isFinished WHERE id=:id")
    void UpdateIsFinished(int id, int isFinished);

    @Query("DELETE from todoListEntry WHERE id=:id")
    void DeleteEntry(int id);
}
