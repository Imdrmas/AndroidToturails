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
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment {

    private RecyclerView viewMoney;
    private TextView txtAllMoney;
    private DatabaseReference mDatabase;

    public MoneyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_money, container, false);


        viewMoney = view.findViewById(R.id.viewMoney);
        viewMoney.setHasFixedSize(true);
        viewMoney.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Money");

        txtAllMoney = view.findViewById(R.id.txtAllMoney);

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
                   txtAllMoney.setText(format.format(sum));

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

    public static class MoneyViewHolder extends RecyclerView.ViewHolder {

        View mView;
        private TextView nameText;
        private TextView moneyText;
        private TextView timeTex;
        private TextView priceText;

        public MoneyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name){
            nameText = mView.findViewById(R.id.nameUserView);
            nameText.setText(name);
        }
        public void setMoney(String money){
            moneyText = mView.findViewById(R.id.taskNameView);
            moneyText.setText(money);
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

        final FirebaseRecyclerAdapter<Money, MoneyViewHolder> FBRA = new FirebaseRecyclerAdapter<Money, MoneyViewHolder>(
                Money.class,
                R.layout.list_item,
                MoneyViewHolder.class,
                mDatabase
        ) {

            @Override
            protected void populateViewHolder(MoneyViewHolder viewHolder, Money model, int position) {

                final String moneyId = getRef(position).getKey().toString();

                viewHolder.setName(model.getName());
                viewHolder.setMoney(model.getMoney());
                viewHolder.setTime(model.getTime());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    viewHolder.setPrice(model.getPrice());
                }

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getContext(), SankleItem.class);
                        intent.putExtra("moneyId", moneyId);
                        startActivity(intent);
                    }
                });

            }

        };
        viewMoney.setAdapter(FBRA);





    }

}
