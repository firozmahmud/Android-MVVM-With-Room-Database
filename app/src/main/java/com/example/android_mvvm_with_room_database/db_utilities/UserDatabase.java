package com.example.android_mvvm_with_room_database.db_utilities;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.android_mvvm_with_room_database.model.User;

@Database(entities = User.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile UserDatabase userDatabase;

    public static UserDatabase getDatabase(Context context) {

        if (userDatabase == null) {
            synchronized (UserDatabase.class) {
                if (userDatabase == null) {

                    userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "note_database").build();
                }
            }
        }

        return userDatabase;
    }
}
