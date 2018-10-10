package com.drmas.issam.sharefood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mainToolbar;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private String current_user_id;

    private FloatingActionButton addPostBtn;

    private RecyclerView post_listView;
    private List<Posts> posts_List;

    private PostsRecyclerAdapter postsRecyclerAdapter;

    private DocumentSnapshot lastVisible;
    private Boolean isFirstPageFirstLoad = true;

    private ProgressBar progressMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        mainToolbar = findViewById( R.id.main_toolbar);
        setSupportActionBar( mainToolbar );

        if (mAuth.getCurrentUser() != null) {

        posts_List = new ArrayList<>();
        post_listView = findViewById(R.id.mainRc);

        postsRecyclerAdapter = new PostsRecyclerAdapter(posts_List);
        post_listView.setLayoutManager(new LinearLayoutManager(this));
        post_listView.setAdapter(postsRecyclerAdapter);
        post_listView.setHasFixedSize(true);

        progressMain = (ProgressBar)findViewById( R.id.progressMain );

            addPostBtn = findViewById( R.id.addPostBtn );
            addPostBtn.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent newPostIntent = new Intent( MainActivity.this, NewPostActivity.class );
                    startActivity( newPostIntent );
                }
            } );

        }
    } //// End Main

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null){

            sendToLogin();

        } else {

            current_user_id = mAuth.getCurrentUser().getUid();

            firebaseFirestore.collection("Users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if(task.isSuccessful()){

                        if(!task.getResult().exists()){


                        } else {

                            loadData();

                        }

                    } else {

                        String errorMessage = task.getException().getMessage();
                        Toast.makeText(MainActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();

                    }

                }
            });

        }

    }

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
            finish();
        }
        else if (id == R.id.actionSeetingsBtn){

            Intent setupIntent = new Intent( MainActivity.this, SetupActivity.class );
            startActivity( setupIntent );
            finish();
        }
        return super.onOptionsItemSelected( item );
    }

    private void loginOut() {

        mAuth.signOut();
        sendToLogin();
        finish();
    }

    private void sendToLogin(){

        Intent loginIntent = new Intent( MainActivity.this, LoginActivity.class );
        startActivity( loginIntent );

    }

    public void loadData(){


           post_listView.addOnScrollListener( new RecyclerView.OnScrollListener() {
               @Override
               public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                   super.onScrolled( recyclerView, dx, dy );

                   Boolean reachedButton = !recyclerView.canScrollVertically( 1 );

                   if (reachedButton) {

                    loadMorePosts();
                    progressMain.setVisibility( View.VISIBLE );
                  //  mainToolbar.setVisibility( View.VISIBLE );

                   } else {
                       progressMain.setVisibility( View.INVISIBLE );
                     //  mainToolbar.setVisibility( View.INVISIBLE );
                   }
               }
           });


           Query firstQuery = firebaseFirestore.collection( "Posts" )
                   .orderBy( "timestamp", Query.Direction.DESCENDING )
                   .limit( 3 );

           firstQuery.addSnapshotListener( new EventListener<QuerySnapshot>() {

               @Override
               public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                   if (!documentSnapshots.isEmpty()) {

                       if (isFirstPageFirstLoad) {

                           lastVisible = documentSnapshots.getDocuments().get( documentSnapshots.size() - 1 );
                           posts_List.clear();
                       }

                       for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                           if (doc.getType() == DocumentChange.Type.ADDED) {

                               String postId = doc.getDocument().getId();
                               Posts posts = doc.getDocument().toObject( Posts.class ).withid( postId );

                               if (isFirstPageFirstLoad) {

                                   posts_List.add( posts );

                               } else {
                                   posts_List.add( 0, posts );
                               }

                               postsRecyclerAdapter.notifyDataSetChanged();

                           }
                       }

                       isFirstPageFirstLoad = false;
                   }
               }
           });


   }

    public void loadMorePosts() {

            Query nextQuery = firebaseFirestore.collection( "Posts" )
                    .orderBy( "timestamp", Query.Direction.DESCENDING )
                    .startAfter( lastVisible )
                    .limit( 3 );

            nextQuery.addSnapshotListener( new EventListener<QuerySnapshot>() {

                @Override
                public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                    if (!documentSnapshots.isEmpty()) {

                        lastVisible = documentSnapshots.getDocuments().get( documentSnapshots.size() - 1 );

                        for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                            if (doc.getType() == DocumentChange.Type.ADDED) {

                                String postId = doc.getDocument().getId();
                                Posts posts = doc.getDocument().toObject( Posts.class ).withid( postId );
                                posts_List.add( posts );

                                postsRecyclerAdapter.notifyDataSetChanged();

                            }
                        }
                    }
                }
            } );
        }

    public void mainNotificationIcon(View view){
        Intent notificationIntent = new Intent( MainActivity.this, NotificationActivity.class );
        startActivity( notificationIntent );
    }

    public void mainAccountIcon(View view){
        Intent accountIntent = new Intent( MainActivity.this, AccountActivity.class );
        startActivity( accountIntent );
    }


}//// Ending
