package com.example.android_mvvm_with_room_database.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.databinding.ActivityDetailsBinding;
import com.example.android_mvvm_with_room_database.service.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        // Set the actionbar title
        setTitle(getResources().getText(R.string.details_txt));

        // Resister for event bus
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(User user) {

        binding.nameTv.setText(user.getName());
        binding.addressTv.setText(user.getAddress());
        binding.numberTv.setText(user.getNumber());
    }
}
