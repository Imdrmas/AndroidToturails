package com.drmas.issam.newtodoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SingleTask extends AppCompatActivity {

      private String task_key = null;
      private TextView singleTask;
      private TextView singleTime;
      private DatabaseReference mDatabasee;
      private ImageButton btnImgDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_single_task );

        task_key = getIntent().getExtras().getString( "TaskId" );

        mDatabasee = FirebaseDatabase.getInstance().getReference().child( "Tasks" );

        singleTask = (TextView) findViewById( R.id.singleTask);
        singleTime = (TextView) findViewById( R.id.singleTime);
        btnImgDel = (ImageButton)findViewById( R.id.btnImgDel);

        mDatabasee.child( task_key ).addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String task_task = (String) dataSnapshot.child("name").getValue();
                String task_time = (String) dataSnapshot.child("time").getValue();

                singleTask.setText(task_task);
                singleTime.setText(task_time);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //////////////////

        btnImgDel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showAlert();
            }
        });

    } // end main

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( this );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Do you want to delete" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDatabasee.child( task_key ).removeValue();
                        Toast.makeText( SingleTask.this, "Task Deleted", Toast.LENGTH_LONG ).show();
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



} //// ending
















