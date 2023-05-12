package com.example.jokeesingle.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jokeesingle.model.Item;

@Database(entities = {Item.class},version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    private static final String DAT_NAME = "item.db";
    private static ItemDatabase instance;

    public  static synchronized ItemDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
            ,ItemDatabase.class,DAT_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract ItemDAO itemDAO();
}
