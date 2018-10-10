package com.issam.drmas.nadyelhikma;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonRecycleAdapter3 extends RecyclerView.Adapter<CommonRecycleAdapter3.ViewHolder> {

    private ArrayList<titleDate> titleDates;
    int lasPosition = -1;

    public CommonRecycleAdapter3(ArrayList<titleDate> titleDates){
        this.titleDates = titleDates;
    }

    @NonNull
    @Override
    public CommonRecycleAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_common_items3, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CommonRecycleAdapter3.ViewHolder holder, int position) {

        holder.textView.setText(titleDates.get(position).getTitle());
        final int itemPosition3 = holder.getAdapterPosition();

        holder.linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.linearLayout3.getContext(), View3Activity.class);
                intent.putExtra("page3", itemPosition3);
                holder.linearLayout3.getContext().startActivity(intent);
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
        return titleDates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtTitle3)TextView textView;
        @BindView(R.id.linearLayout3)LinearLayout linearLayout3;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
