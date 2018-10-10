package com.drmas.issam.socialmedia;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class SingleActivity extends AppCompatActivity {

    private ImageView singlePostImage;
    TextView singleTilte, singleDesc, singleTime, singleAddBy;
    private Button deleteButton;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String post_key = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_single );

        String post_key = getIntent().getExtras().getString( "PostId" );
        mDatabase = FirebaseDatabase.getInstance().getReference().child( "InsaApp");

        singleDesc = (TextView) findViewById( R.id.singleDesc );
        singleTilte = (TextView) findViewById( R.id.singleTitle );
        singlePostImage = (ImageView) findViewById( R.id.singleImageView);
        singleTime = (TextView) findViewById( R.id.singleTime );
        singleAddBy = (TextView) findViewById( R.id.singleAddBy );


        mAuth = FirebaseAuth.getInstance();
        deleteButton = (Button) findViewById( R.id.singleDeleteButton );
        deleteButton.setVisibility(View.INVISIBLE);

        mDatabase.child( post_key ).addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String post_title = (String) dataSnapshot.child("title").getValue();
                String post_desc = (String) dataSnapshot.child( "desc" ).getValue();
                String post_image = (String) dataSnapshot.child("image" ).getValue();
                String post_uid = (String) dataSnapshot.child( "uid" ).getValue();
                String post_time = (String) dataSnapshot.child("time" ).getValue();
                String post_username = (String) dataSnapshot.child( "username" ).getValue();

                singleTilte.setText(post_title );
                singleDesc.setText( post_desc );
                singleTime.setText( post_time );
                singleAddBy.setText( "Added by "+ post_username);

                Picasso.with( SingleActivity.this ).load( post_image ).into( singlePostImage );

                if (mAuth.getCurrentUser().getUid().equals(post_uid)){
                    deleteButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void deleteButtonClick(View view){
        showAlert();
        mDatabase.child(post_key).removeValue();

        Toast.makeText( SingleActivity.this, "Post deleted", Toast.LENGTH_LONG ).show();

        Intent homeIntent = new Intent( SingleActivity.this, HomeActivity.class );
        startActivity( homeIntent );

    }

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( this );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Do you want to delete" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        mDatabase.child(post_key).removeValue();

                        Toast.makeText( SingleActivity.this, "Image deleted", Toast.LENGTH_LONG ).show();

                        Intent homeIntent = new Intent( SingleActivity.this, HomeActivity.class );
                        startActivity( homeIntent );



                    }
                }).setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });
        AlertDialog dialog = alertBuider.create();
        dialog.show();
    }





}//// Ending
