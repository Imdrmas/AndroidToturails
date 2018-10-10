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

public class CommonRecycleAdapter2 extends RecyclerView.Adapter<CommonRecycleAdapter2.ViewHolder> {

    private ArrayList<titleDate> titleDates;
    int lasPosition = -1;

    public CommonRecycleAdapter2(ArrayList<titleDate> titleDates){
        this.titleDates = titleDates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_common_items2, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

                 holder.textView.setText(titleDates.get(position).getTitle());
                 final int itemPosition2 = holder.getAdapterPosition();

                 holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent = new Intent(holder.linearLayout2.getContext(), View2Activity.class);
                         intent.putExtra("page2", itemPosition2);
                         holder.linearLayout2.getContext().startActivity(intent);
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

        @BindView(R.id.txtTitle2)
        TextView textView;

        @BindView(R.id.linearLayout2)
        LinearLayout linearLayout2;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
