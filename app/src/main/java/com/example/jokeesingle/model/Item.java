package com.example.jokeesingle.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity (tableName = "item")
public class Item {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String name;
    private String strJoke;
    private String active;

    public Item(String name, String strJoke, String active) {
        this.name = name;
        this.strJoke = strJoke;
        this.active = active;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrJoke() {
        return strJoke;
    }

    public void setStrJoke(String strJoke) {
        this.strJoke = strJoke;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
