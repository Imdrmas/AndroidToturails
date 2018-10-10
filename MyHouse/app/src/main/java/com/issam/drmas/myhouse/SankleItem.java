package com.issam.drmas.myhouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

public class SankleItem extends AppCompatActivity {

    private TextView nameTxt;
    private TextView moneyTxt;
    private TextView timeTxt;
    private TextView priceTxt;

    private String moneyId;
    DatabaseReference mDatabase;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;

    private ImageButton deleteMoney;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sankle_item);

        nameTxt = findViewById(R.id.nameSankle);
        priceTxt = findViewById(R.id.priceSankle);
        moneyTxt = findViewById(R.id.moneySankle);
        timeTxt = findViewById(R.id.timeSankle);


        deleteMoney = findViewById(R.id.deleteMoney);
        moneyId = getIntent().getExtras().getString("moneyId");

            mDatabase = FirebaseDatabase.getInstance().getReference().child("Money");
            mDatabase.child(moneyId).addValueEventListener(new ValueEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    String name = (String) dataSnapshot.child("name").getValue();
                    String money = (String) dataSnapshot.child("money").getValue();
                    String time = (String) dataSnapshot.child("time").getValue();
                    int price = dataSnapshot.child("price").getValue(Integer.class);

                    DecimalFormat format = new DecimalFormat("$0.00");
                    format.setMaximumFractionDigits(2);

                    nameTxt.setText(name);
                    moneyTxt.setText(money);
                    timeTxt.setText(time);
                    priceTxt.setText(format.format(price));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
/*

            deleteMoney.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlert();
                }
            });
*/

    } ///Main

    @Override
    protected void onStart() {
        super.onStart();
/*
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null){

            String name = acct.getDisplayName();
            if (name.equals("Issam Drmas")){
                deleteMoney.setVisibility(View.VISIBLE);
            }
            else {
                deleteMoney.setVisibility(View.INVISIBLE);
            }

        }
*/

    }

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( this );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Do you want to delete" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference namesRef = reference.child("Money");

                        namesRef.child(moneyId).removeValue();

                        Toast.makeText(SankleItem.this, "Money deleted Successfully !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SankleItem.this, SetupActivity.class));
                        finish();
                    }


                } ).setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = alertBuider.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SankleItem.this, Main2Activity.class));
    }
}
