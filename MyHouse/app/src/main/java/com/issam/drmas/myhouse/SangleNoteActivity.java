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

import java.util.ArrayList;

public class SangleNoteActivity extends AppCompatActivity {

    private TextView nameTxt;
    private TextView moneyTxt;
    private TextView timeTxt;
    private TextView titleTxt;

    private String noteId;
    DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private ImageButton deleteNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sangle_note);

        nameTxt = findViewById(R.id.nameSangleView);
        titleTxt = findViewById(R.id.titleSangleView);
        moneyTxt = findViewById(R.id.noteSangleView);
        timeTxt = findViewById(R.id.timeSangleView);
/*
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {


            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            name_user = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();

            userId = acct.getId();
        }else {
            startActivity(new Intent(SangleNoteActivity.this, LoginActivity.class));
        }
        */

        deleteNote = findViewById(R.id.deleteSangleNote);
        noteId = getIntent().getExtras().getString("noteId");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Note");
        mDatabase.child(noteId).addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = (String) dataSnapshot.child("name").getValue();
                String money = (String) dataSnapshot.child("note").getValue();
                String time = (String) dataSnapshot.child("time").getValue();
                String title = (String) dataSnapshot.child("title").getValue();

                nameTxt.setText(name);
                moneyTxt.setText(money);
                timeTxt.setText(time);
                titleTxt.setText(title);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        deleteNote.setOnClickListener(new View.OnClickListener() {
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
                deleteNote.setVisibility(View.VISIBLE);
            }
            else {
                deleteNote.setVisibility(View.INVISIBLE);
            }

        }
*/
    }

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( this );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Do you want to delete the note" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference namesRef = reference.child("Note");

                        namesRef.child(noteId).removeValue();

                        Toast.makeText( SangleNoteActivity.this, "Your Note Deleted", Toast.LENGTH_LONG ).show();
                        startActivity(new Intent(SangleNoteActivity.this, SetupActivity.class));
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
        startActivity(new Intent(SangleNoteActivity.this, Main2Activity.class));
    }
}
