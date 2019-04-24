package com.example.android_mvvm_with_room_database.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.databinding.ActivityEditBinding;
import com.example.android_mvvm_with_room_database.service.model.User;
import com.example.android_mvvm_with_room_database.viewmodel.EditActivityViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditActivity extends AppCompatActivity {

    private ActivityEditBinding binding;
    private EditActivityViewModel viewModel;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit);
        setTitle(getResources().getText(R.string.edit_txt));

        viewModel = ViewModelProviders.of(this).get(EditActivityViewModel.class);

        // Register for event bus
        EventBus.getDefault().register(this);

        // Add Listener to update button
        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(User user) {

        binding.nameEt.setText(user.getName());
        binding.addressEt.setText(user.getAddress());
        binding.numberEt.setText(user.getNumber());

        this.user = user;
    }

    private void updateUser() {

        user.setName(binding.nameEt.getText().toString().trim());
        user.setAddress(binding.addressEt.getText().toString().trim());
        user.setNumber(binding.numberEt.getText().toString().trim());

        viewModel.updateUser(user);

    }
}
