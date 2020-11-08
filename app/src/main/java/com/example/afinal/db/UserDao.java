package com.example.afinal.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.afinal.model.User;

public interface UserDao {
    @Query("SELECT * FROM users")
    User[] getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(int id);

    @Insert
    void addUser(User... users);

    @Delete
    void deleteUser(User user);

}
