package com.example.android_mvvm_with_room_database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.android_mvvm_with_room_database.model.User;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<User>> getAllUsers() {

        return null;
    }
}
