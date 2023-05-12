package com.example.jokeesingle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jokeesingle.model.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM ITEM")
    List<Item> list();

    @Insert
    void  insertData(Item item);

    @Query("UPDATE item SET active=:isActive WHERE id = :id")
    void updateData(String isActive , int id);
}
