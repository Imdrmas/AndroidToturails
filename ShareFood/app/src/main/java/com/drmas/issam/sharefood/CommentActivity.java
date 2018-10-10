package com.drmas.issam.sharefood;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentActivity extends AppCompatActivity {

    private Toolbar commentToolbar;

    private EditText comment_field;
    private ImageButton comment_post_btn;

    private String comment_post_id;
    private String current_user_id;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    private RecyclerView comment_listView;
    private List<Comments> comment_List;

    private CommentRecyclerAdapter commentRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_comment );

        commentToolbar = findViewById( R.id.comment_toolbar);
        setSupportActionBar( commentToolbar );
        getSupportActionBar().setTitle( "Share Food" );
        commentToolbar.setNavigationIcon( R.mipmap.home_comment );
        commentToolbar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent( CommentActivity.this, MainActivity.class );
                startActivity( mainIntent );
            }
        } );

        comment_field = findViewById( R.id.comment_field);
        comment_listView = findViewById( R.id.comment_list);
        comment_post_btn = findViewById( R.id.comment_post_btn);

        comment_List = new ArrayList<>();
        commentRecyclerAdapter = new CommentRecyclerAdapter(comment_List);
        comment_listView.setLayoutManager( new LinearLayoutManager(CommentActivity.this));
        comment_listView.setHasFixedSize( true );
        comment_listView.setAdapter( commentRecyclerAdapter);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        current_user_id = mAuth.getCurrentUser().getUid();
        comment_post_id = getIntent().getStringExtra( "comment_post_id" );

        Query query = firebaseFirestore.collection( "Posts/" + comment_post_id + "/Comments" )
                .orderBy( "timestamp", Query.Direction.DESCENDING );
        query.addSnapshotListener( CommentActivity.this, new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                        if (!queryDocumentSnapshots.isEmpty()){

                            for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){

                                if (doc.getType() == DocumentChange.Type.ADDED){

                                    String commentId = doc.getDocument().getId();
                                    Comments comments = doc.getDocument().toObject( Comments.class );
                                    comment_List.add( comments );
                                    commentRecyclerAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                });


        comment_post_btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        } );


    } //// Main



    public void addComment(){

                String comment_message = comment_field.getText().toString();
                Map<String, Object> commentsMap = new HashMap<>();

                if (!TextUtils.isEmpty( comment_message )) {
                    commentsMap.put( "message", comment_message );
                    commentsMap.put( "user_id", current_user_id );
                    commentsMap.put( "timestamp", FieldValue.serverTimestamp() );

                    firebaseFirestore.collection( "Posts/" + comment_post_id + "/Comments" )
                            .add( commentsMap ).addOnCompleteListener( new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {

                            if (!task.isSuccessful()) {

                                Toast.makeText( CommentActivity.this, "Error Posting Comment : " + task.getException().getMessage(), Toast.LENGTH_SHORT ).show();

                            } else {

                                finish();
                                startActivity(getIntent());

                            }

                        }
                    });

                } else {
                    Toast.makeText( this, "The field can,t be Empty", Toast.LENGTH_SHORT ).show();
                }
            }

    @Override
    public void onBackPressed() {

    }
}