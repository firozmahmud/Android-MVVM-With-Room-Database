package com.example.android_mvvm_with_room_database.db_utilities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android_mvvm_with_room_database.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(User user);

    @Query("SELECT * FROM users")
    public LiveData<List<User>> getAllUsers();
}
