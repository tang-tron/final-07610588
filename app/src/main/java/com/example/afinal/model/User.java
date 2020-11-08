package com.example.afinal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "users")
public class User {

    @ColumnInfo(name = "meter")
    public final Double meter;

    @ColumnInfo(name = "second")
    public final Double second;

    public User(Double meter, Double second) {
        this.meter = meter;
        this.second = second;
    }
}
