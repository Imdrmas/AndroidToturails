package com.issam.drmas.myhouse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    private List<Users> usersList;
    private Context context;

    public UserRecyclerAdapter(Context context, List<Users> usersList){
        this.usersList = usersList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameUser.setText(usersList.get(position).getName());

        CircleImageView userImage = holder.imageUser;
        Glide.with(context).load(usersList.get(position).getImage()).into(userImage);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private CircleImageView imageUser;
        private TextView nameUser;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            imageUser = mView.findViewById(R.id.allUserImageItem);
            nameUser = mView.findViewById(R.id.allNameUserItem);
        }
    }

}
