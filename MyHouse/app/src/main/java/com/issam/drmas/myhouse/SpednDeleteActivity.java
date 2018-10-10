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

public class SpednDeleteActivity extends AppCompatActivity {

    private TextView nameTxt;
    private TextView spendTxt;
    private TextView timeTxt;
    private TextView priceTxt;

    private String spendId;
    DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private ImageButton deleteSpend;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spedn_delete);

        nameTxt = findViewById(R.id.nameSpendDel);
        priceTxt = findViewById(R.id.priceSpendDel);
        spendTxt = findViewById(R.id.SpendDel);
        timeTxt = findViewById(R.id.timeSpendDel);

        deleteSpend = findViewById(R.id.deleteSpend);
        spendId = getIntent().getExtras().getString("spendId");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Spend");
        mDatabase.child(spendId).addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = (String) dataSnapshot.child("name").getValue();
                String spend = (String) dataSnapshot.child("money").getValue();
                String time = (String) dataSnapshot.child("time").getValue();
                int price = dataSnapshot.child("price").getValue(Integer.class);

                DecimalFormat format = new DecimalFormat("$0.00");
                format.setMaximumFractionDigits(2);

                nameTxt.setText(name);
                spendTxt.setText(spend);
                timeTxt.setText(time);
                priceTxt.setText(format.format(price));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        deleteSpend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
/*
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null){

            String name = acct.getDisplayName();
            if (name.equals("Issam Drmas")){
                deleteSpend.setVisibility(View.VISIBLE);
            }
            else {
                deleteSpend.setVisibility(View.INVISIBLE);
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
                        DatabaseReference namesRef = reference.child("Spend");

                        namesRef.child(spendId).removeValue();

                        Toast.makeText( SpednDeleteActivity.this, "Money Spend Deleted", Toast.LENGTH_LONG ).show();
                        startActivity(new Intent(SpednDeleteActivity.this, SetupActivity.class));
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
        startActivity(new Intent(SpednDeleteActivity.this, Main2Activity.class));
    }
}
