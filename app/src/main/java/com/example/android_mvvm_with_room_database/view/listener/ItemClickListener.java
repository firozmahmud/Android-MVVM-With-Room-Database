package com.example.android_mvvm_with_room_database.view.listener;

import android.view.MenuItem;

import com.example.android_mvvm_with_room_database.service.model.User;

public interface ItemClickListener {

    void onItemLongClick(User user, MenuItem item);

    void onDeleteBtnClick(User user);
}
