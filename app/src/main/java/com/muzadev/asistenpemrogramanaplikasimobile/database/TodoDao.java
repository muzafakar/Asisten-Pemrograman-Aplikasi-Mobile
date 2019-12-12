package com.muzadev.asistenpemrogramanaplikasimobile.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createTodo(Todo todo);

    @Query("SELECT * FROM todo")
    List<Todo> readAllTodo();
}
