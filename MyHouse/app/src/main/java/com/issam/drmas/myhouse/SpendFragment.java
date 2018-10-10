package com.issam.drmas.myhouse;


import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpendFragment extends Fragment {

    private RecyclerView viewSpend;
    private TextView txtAllSpend;
    private DatabaseReference mDatabase;

    public SpendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spend, container, false);

        viewSpend = view.findViewById(R.id.viewSpend);
        viewSpend.setHasFixedSize(true);
        viewSpend.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Spend");

        txtAllSpend = view.findViewById(R.id.txtAllSpend);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object price = map.get("price");
                    int pValue = Integer.parseInt(String.valueOf(price));
                    sum += pValue;

                    DecimalFormat format = new DecimalFormat("$0.00");
                    format.setMaximumFractionDigits(2);
                    txtAllSpend.setText(format.format(sum));

                    Log.d("Sum", String.valueOf(sum));
                    //  txtAllMoney.setText(String.valueOf("All "+sum));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    public static class SpendViewHolder extends RecyclerView.ViewHolder {


        View mView;
        private TextView nameText;
        private TextView moneyText;
        private TextView timeTex;
        private TextView priceText;

        public SpendViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name){
            nameText = mView.findViewById(R.id.nameUserView);
            nameText.setText(name);
        }
        public void setSpend(String spend){
            moneyText = mView.findViewById(R.id.taskNameView);
            moneyText.setText(spend);
        }
        public void setTime(String time){
            timeTex = mView.findViewById(R.id.timeView);
            timeTex.setText(time);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void setPrice(double price){
            DecimalFormat format = new DecimalFormat("$0.00");
            format.setMaximumFractionDigits(2);
            priceText = mView.findViewById(R.id.taskPriceView);
            priceText.setText(format.format(price));

        }
    }

    @Override
    public void onStart() {
        super.onStart();

   FirebaseRecyclerAdapter<Spend, SpendViewHolder> FBRA = new FirebaseRecyclerAdapter<Spend, SpendViewHolder>(
           Spend.class,
           R.layout.list_item,
           SpendViewHolder.class,
           mDatabase
   ) {
       @RequiresApi(api = Build.VERSION_CODES.N)
       @Override
       protected void populateViewHolder(SpendViewHolder viewHolder, Spend model, int position) {
           final String spendId = getRef(position).getKey().toString();

           viewHolder.setName(model.getName());
           viewHolder.setSpend(model.getSpend());
           viewHolder.setPrice(model.getPrice());
           viewHolder.setTime(model.getTime());

           viewHolder.mView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getContext(), SpednDeleteActivity.class);
                   intent.putExtra("spendId", spendId);
                   startActivity(intent);
                   getActivity().finish();
               }
           });
       }
   };
       viewSpend.setAdapter(FBRA);
    }


}
