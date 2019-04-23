package com.example.android_mvvm_with_room_database.service.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android_mvvm_with_room_database.db_utilities.UserDao;
import com.example.android_mvvm_with_room_database.db_utilities.UserDatabase;
import com.example.android_mvvm_with_room_database.service.model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private UserDatabase userDatabase;


    public UserRepository(Application application) {
        userDatabase = UserDatabase.getDatabase(application);
        userDao = userDatabase.userDao();
    }

    public LiveData<List<User>> getAllUser() {

        return userDao.getAllUsers();
    }


    public void insert(User user) {
        new InsertAsyncTask().execute(user);
    }


    public void delete(User user) {
        //userDao.delete(user);
        new DeleteAsyncTask().execute(user);
    }


    class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {

            userDao.insert(users[0]);
            return null;
        }
    }

    class DeleteAsyncTask extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {

            userDao.delete(users[0]);
            return null;
        }
    }
}
