package com.example.android_mvvm_with_room_database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class EditActivityViewModel extends AndroidViewModel {

    public EditActivityViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
