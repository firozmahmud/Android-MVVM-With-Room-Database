package com.example.android_mvvm_with_room_database.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.databinding.ActivityMainBinding;
import com.example.android_mvvm_with_room_database.model.User;
import com.example.android_mvvm_with_room_database.view.adapter.UserAdapter;
import com.example.android_mvvm_with_room_database.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initComponent();
        initListener();
        loadData();
    }

    private void initComponent() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initListener() {

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void loadData() {

        viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                binding.recyclerView.setAdapter(new UserAdapter(MainActivity.this, users));
            }
        });
    }
}
