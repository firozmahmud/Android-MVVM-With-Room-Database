package com.example.android_mvvm_with_room_database.view.listener;

import com.example.android_mvvm_with_room_database.service.model.User;

public interface ItemClickListener {

    void onItemClick(User user);

    void onDeleteBtnClick(User user);
}
