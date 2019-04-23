package com.example.android_mvvm_with_room_database.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android_mvvm_with_room_database.R;
import com.example.android_mvvm_with_room_database.service.model.User;
import com.example.android_mvvm_with_room_database.view.listener.ItemClickListener;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<User> users;
    ItemClickListener listener;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
        listener = (ItemClickListener) context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_layout, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, final int i) {
        userViewHolder.name.setText(users.get(i).getName());
        userViewHolder.address.setText(users.get(i).getAddress());

        userViewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onDeleteBtnClick(users.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name, address;
        ImageButton deleteBtn;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTv);
            address = itemView.findViewById(R.id.address);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
