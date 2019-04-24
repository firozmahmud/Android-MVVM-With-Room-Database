package com.example.android_mvvm_with_room_database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.android_mvvm_with_room_database.service.model.User;
import com.example.android_mvvm_with_room_database.service.repository.UserRepository;

public class EditActivityViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public EditActivityViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }


    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
