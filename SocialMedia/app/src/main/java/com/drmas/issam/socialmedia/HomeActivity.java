package com.drmas.issam.socialmedia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    // Declaration var FireDatabase
    private RecyclerView mInstList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    private int superHero = 0;
    private TextView textCounterVistit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        // initialise vars FireDatabase
        mInstList = (RecyclerView) findViewById( R.id.insta_list );
        mInstList.setHasFixedSize( true );
        mInstList.setLayoutManager( new LinearLayoutManager( this ));
        mDatabase = FirebaseDatabase.getInstance().getReference().child( "InsaApp" );
        mAuth = FirebaseAuth.getInstance();



        //Check info user is null
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()==null){
                    Intent RegisterIntent = new Intent( HomeActivity.this, RegisterActivity.class );
                    startActivity( RegisterIntent );
                }
            }
        };

    } /// end main // ************************************

    // Fun Set Main Value in home page
    public static class InstaViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public InstaViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setTitle(String title){
            TextView post_title = (TextView) mView.findViewById( R.id.textTitle );
            post_title.setText( title );
        }
        public void setDesc(String desc){
            TextView post_desc = (TextView) mView.findViewById( R.id.textDescription );
            post_desc.setText( desc );
        }
        public void setImage(Context context, String image){
            ImageView post_image = (ImageView) mView.findViewById( R.id.post_image );
            Picasso.with(context).load(image).into(post_image);
        }
        public void setName(String Name){
            TextView post_name = (TextView) mView.findViewById( R.id.textName );
            post_name.setText( Name );
        }
        public void setTimes(String time){
            TextView post_time = (TextView) mView.findViewById( R.id.textTime);
            post_time.setText( time );
        }
        public void setImg_profile(Context context, String image_profile){
            ImageView post_image_profile = (ImageView) mView.findViewById( R.id.post_image );
            Picasso.with(context).load(image_profile).into(post_image_profile);
        }
    }

    // Fun ViewHolder to set Value In List
    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener( mAuthListener);
        FirebaseRecyclerAdapter<insta, HomeActivity.InstaViewHolder> FBRA = new FirebaseRecyclerAdapter<insta, HomeActivity.InstaViewHolder>(

                insta.class,  // imitation Class User info
                R.layout.insta_row, // List array;
                HomeActivity.InstaViewHolder.class,
                mDatabase

        ) {

            // Fun To Send Post to single activity
            @Override

            protected void populateViewHolder(final HomeActivity.InstaViewHolder viewHolder, insta model, final int position) {

                // Key item index
                final String post_key = getRef( position ).getKey().toString();


                // Set All Value
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage( getApplicationContext(),model.getImage());
                viewHolder.setName( model.getUsername());
                viewHolder.setTimes( model.getTime());
               // viewHolder.setImg_profile( getApplicationContext(),model.getImg_profile());

                viewHolder.mView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent singleIntentActivity = new Intent( HomeActivity.this, SingleActivity.class );
                        singleIntentActivity.putExtra( "PostId", post_key);
                        startActivity( singleIntentActivity );

                    }
                });
            }
        };
        mInstList.setAdapter( FBRA );
    }


    // Fun Menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    // Fun Button in Action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent setupActivityIntent = new Intent( HomeActivity.this, SetupActivity.class );
            startActivity( setupActivityIntent );
        }
        else if (id == R.id.addIcon){
            Intent intent = new Intent( HomeActivity.this, PostActivity.class );
            startActivity( intent );
        }
        else if (id == R.id.logout){
            mAuth.signOut();
        }

        return super.onOptionsItemSelected( item );
    }

    // Fun To go back
    public void onBackPressed(){
        //super.onBackPressed();
      //  createDialogonBackPressed();
    }


}//// Ending
