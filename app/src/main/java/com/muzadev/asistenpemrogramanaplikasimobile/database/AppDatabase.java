package com.muzadev.asistenpemrogramanaplikasimobile.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

@Database(
        entities = {Todo.class},
        version = 2
)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        synchronized (AppDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "databaseName")
                        .build();
            }
        }

        return INSTANCE;
    }
}
