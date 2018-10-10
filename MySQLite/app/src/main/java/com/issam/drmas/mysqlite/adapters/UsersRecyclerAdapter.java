package com.issam.drmas.mysqlite.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.issam.drmas.mysqlite.MainActivity;
import com.issam.drmas.mysqlite.R;
import com.issam.drmas.mysqlite.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    private List<User> listUsers;
    private Context context;

    public UsersRecyclerAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

       // password = listUsers.get(position).getPassword();
        final int userid = listUsers.get(position).getId();
        holder.textViewName.setText(listUsers.get(position).getName());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText("**************");

        holder.appCompatButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("userId", userid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        View mView;
        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        public AppCompatButton appCompatButtonMain;

        public UserViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = (AppCompatTextView) mView.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) mView.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) mView.findViewById(R.id.textViewPassword);
            appCompatButtonMain = (AppCompatButton) mView.findViewById(R.id.appCompatButtonMain);
        }
    }


}