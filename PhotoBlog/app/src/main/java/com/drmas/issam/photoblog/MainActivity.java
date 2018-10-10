package com.drmas.issam.photoblog;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.Collection;
import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mainToolbar;
    private FloatingActionButton addPostBtn;

    private RecyclerView mInstList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mainToolbar = findViewById( R.id.main_toolbar);
        setSupportActionBar( mainToolbar );


        //// initialise vars FireDatabase
        mInstList = (RecyclerView) findViewById( R.id.Blog_list );
        mInstList.setHasFixedSize( true );
        mInstList.setLayoutManager( new LinearLayoutManager( this ));
        mDatabase = FirebaseDatabase.getInstance().getReference().child( "Posts" );
        mAuth = FirebaseAuth.getInstance();




        //// Check info user is null
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null){
                    Intent RegisterIntent = new Intent( MainActivity.this, RegisterActivity.class );
                    startActivity( RegisterIntent );
                }
            }
        };


      addPostBtn = findViewById( R.id.addPostBtn );
        addPostBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent newPostIntent = new Intent( MainActivity.this, NewPostActivity.class );
                  startActivity( newPostIntent );
            }
        } );



    }/// and Main



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

          int id = item.getItemId();

          if (id == R.id.actionLogoutBtn){
              loginOut();
          }
          else if (id == R.id.actionSeetingsBtn){

              Intent setupIntent = new Intent( MainActivity.this, SetupActivity.class );
              startActivity( setupIntent );
          }
        return super.onOptionsItemSelected( item );
    }

    private void loginOut() {
        mAuth.signOut();
        sendToLoginActivity();

    }

    private void sendToLoginActivity() {

        Intent intent = new Intent( MainActivity.this, LoginActivity.class );
        startActivity( intent );
        finish();
    }

    //// Fun set main values in main page
    public static class PostInfoViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public PostInfoViewHolder(View itemView) {
            super( itemView );
            mView = itemView;
        }
        public void setName(String name){
            TextView post_name = (TextView) mView.findViewById( R.id.txtNameBlog );
            post_name.setText( name );
        }
        public void setTime(String time){
            TextView post_time = (TextView) mView.findViewById( R.id.txtDateBlog );
            post_time.setText( time );
        }
        public void setDesc(String desc){
            TextView post_desc = (TextView) mView.findViewById( R.id.txtDescBlog );
            post_desc.setText( desc );
        }
        public void setImageProfile(Context context, String imageProfile){
            CircleImageView post_image_profile = (CircleImageView) mView.findViewById( R.id.imgProfileBlog );
            Picasso.with( context ).load( imageProfile ).into( post_image_profile );
        }
        public void setImagePost(Context context, String imgPost){
           ImageView  post_image = (ImageView) mView.findViewById( R.id.imgBlog );
           Picasso.with( context ).load( imgPost ).into( post_image );
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null){

            // Toast.makeText( MainActivity.this, "You are welcome", Toast.LENGTH_LONG ).show();

        } else {
            sendToLoginActivity();
        }

        Query query = mDatabase.orderByChild("image");

        mAuth.addAuthStateListener( mAuthListener);
        mAuth.addAuthStateListener( mAuthListener);
        FirebaseRecyclerAdapter<PostInfo, PostInfoViewHolder> FBRA = new FirebaseRecyclerAdapter<PostInfo, PostInfoViewHolder>(

                PostInfo.class,  // imitation Class User info
                R.layout.blog_sangle_list, // List array;
                PostInfoViewHolder.class,
                query//mDatabase

        ){
            @Override
            protected void populateViewHolder(PostInfoViewHolder viewHolder, PostInfo model, int position) {

                /// key item index
                final String post_key = getRef( position ).getKey().toString();

                /// Set All Values
                viewHolder.setName( model.getUserame());
                viewHolder.setTime( model.getTime());
                viewHolder.setDesc( model.getDesc());
                viewHolder.setImagePost( getApplicationContext(), model.getImage());
                viewHolder.setImageProfile( getApplicationContext(), model.getImgProfile());

                viewHolder.mView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent singleIntentActivity = new Intent( MainActivity.this, SingleActivity.class );
                        singleIntentActivity.putExtra( "PostId", post_key );
                        startActivity( singleIntentActivity);
                    }
                } );

            }
        };
        mInstList.setAdapter( FBRA );

    }

    public void homeClicked(View view){
        Intent mainIntent = new Intent( MainActivity.this, MainActivity.class );
        startActivity( mainIntent );
    }
    public void notificationClicked(View view){
        Intent notificationIntent = new Intent( MainActivity.this, NotificationActivity.class );
        startActivity( notificationIntent );
    }
    public void accountClicked(View view){
        Intent accountIntent = new Intent( MainActivity.this, AccountActivity.class );
        startActivity( accountIntent );
    }



} ///// Ending
