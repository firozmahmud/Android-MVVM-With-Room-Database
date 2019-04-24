package com.example.android_mvvm_with_room_database.db_utilities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android_mvvm_with_room_database.service.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insert(User user);

    @Query("SELECT * FROM users")
    public LiveData<List<User>> getAllUsers();

    @Delete
    public void delete(User user);

    @Update
    public void update(User user);
}
