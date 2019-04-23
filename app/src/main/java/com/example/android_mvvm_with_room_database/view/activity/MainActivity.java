package com.example.android_mvvm_with_room_database.view.activity;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.databinding.ActivityMainBinding;
import com.example.android_mvvm_with_room_database.service.model.User;
import com.example.android_mvvm_with_room_database.view.adapter.UserAdapter;
import com.example.android_mvvm_with_room_database.view.listener.ItemClickListener;
import com.example.android_mvvm_with_room_database.viewmodel.MainActivityViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

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

                // Add new user
                addNewUser();
            }
        });

    }

    private void addNewUser() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_new_user_layout);
        dialog.setCancelable(false);

        final EditText nameEt = dialog.findViewById(R.id.new_name);
        final EditText addressEt = dialog.findViewById(R.id.new_address);
        final EditText numberEt = dialog.findViewById(R.id.new_number);

        Button saveBtn = dialog.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.insert(new User(nameEt.getText().toString().trim(), addressEt.getText().toString().trim(),
                        numberEt.getText().toString().trim()));


                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void loadData() {

        viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                binding.recyclerView.setAdapter(new UserAdapter(MainActivity.this, users));
            }
        });
    }

    @Override
    public void onItemLongClick(User user, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_edit:
                EventBus.getDefault().postSticky(user);
                startActivity(new Intent(this, EditActivity.class));
                break;
            case R.id.menu_details:
                EventBus.getDefault().postSticky(user);
                startActivity(new Intent(this, DetailsActivity.class));
                break;
        }
    }

    @Override
    public void onDeleteBtnClick(User user) {

        viewModel.delete(user);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
