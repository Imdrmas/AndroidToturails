package com.drmas.issam.newtodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class AddTask extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    EditText editTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_task );
    }

    public void AddButtonClicked(View view) {

        editTask = (EditText) findViewById( R.id.editTask );
        String name = editTask.getText().toString();

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat( "MMM, dd MM yyyy  h:mm a" );
        String dateString = sdf.format( date );

        if (!TextUtils.isEmpty( name ) && !TextUtils.isEmpty( dateString )) {

            myRef = database.getInstance().getReference().child( "Tasks" );
            DatabaseReference newTask = myRef.push();
            newTask.child( "name" ).setValue( name );
            newTask.child( "time" ).setValue( dateString );

            Toast.makeText( AddTask.this, "Task Added Sucessfully", Toast.LENGTH_LONG ).show();
            finish();

        } else {
            Toast.makeText( AddTask.this, "Name Can't Be Empty", Toast.LENGTH_LONG ).show();
        }
    }

}





























