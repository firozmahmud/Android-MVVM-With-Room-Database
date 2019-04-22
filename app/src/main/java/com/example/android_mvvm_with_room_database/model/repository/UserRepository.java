package com.example.android_mvvm_with_room_database.model.repository;

import android.app.Application;

public class UserRepository {

    private Application application;

    public UserRepository(Application application) {
        this.application = application;
    }
}
