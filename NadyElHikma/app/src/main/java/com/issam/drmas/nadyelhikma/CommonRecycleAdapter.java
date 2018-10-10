package com.issam.drmas.nadyelhikma;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonRecycleAdapter extends RecyclerView.Adapter<CommonRecycleAdapter.ViewHolder> {

    ArrayList<titleDate> myList;
    int lasPosition = -1;

    public CommonRecycleAdapter(ArrayList<titleDate> myList) {
        this.myList = myList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       final View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_common_items, null);
       final ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.textView.setText(myList.get(position).getTitle());
        final int itemPosition = holder.getAdapterPosition();

          holder.linearLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(holder.linearLayout.getContext(), ViewActivity.class);
                  intent.putExtra("page", itemPosition);
                  holder.linearLayout.getContext().startActivity(intent);
              }
          });

          if (position > lasPosition){
              Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),
                      (position > lasPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
              holder.itemView.startAnimation(animation);
              lasPosition = position;
          }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtTitle)
        TextView textView;

        @BindView(R.id.linearLayout) LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}














