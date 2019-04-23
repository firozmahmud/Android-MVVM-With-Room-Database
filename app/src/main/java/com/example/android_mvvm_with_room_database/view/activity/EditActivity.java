package com.example.android_mvvm_with_room_database.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.service.model.User;

import org.greenrobot.eventbus.Subscribe;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle(getResources().getText(R.string.edit_txt));

    }

    @Subscribe
    public void onEvent(User user) {
        Toast.makeText(this, "" + user.getAddress(), Toast.LENGTH_SHORT).show();
    }
}
