package com.issam.drmas.frenchverbsconjugator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonRecyclerAdapter extends RecyclerView.Adapter<CommonRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mTitle;
    private int lastPosition = -1;

    public CommonRecyclerAdapter(ArrayList<String> mTitle){
        this.mTitle = mTitle;
    }

    public void filterList(ArrayList<String> list){
        this.mTitle = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_verbs, null);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.textView.setText(mTitle.get(position));
        final int itemPosition = holder.getAdapterPosition();

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.linearLayout.getContext(), WebViewActivity.class);
                intent.putExtra("value", mTitle.get(position));
                holder.linearLayout.getContext().startActivity(intent);
            }
        });

        if (position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),
                    R.anim.down_from_top);
            holder.itemView.setAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtTitle)
        TextView textView;

        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
