package com.drmas.issam.photoblog;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

import java.text.SimpleDateFormat;

public class NewPostActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar newPostToolbar;

    private EditText editTxtDescPost;
    private Button btnAddPost;
    private ImageView imgNewPost;

    private static final int GALLERY_REQUEST = 2;
    private Uri uri = null;

    private StorageReference storageReference;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private FirebaseUser mCurrentUser;

    private ProgressBar newPostProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_new_post );

        newPostToolbar = findViewById( R.id.newPost_toolbar );
        setSupportActionBar( newPostToolbar );
        getSupportActionBar().setTitle( "" );

        newPostProgressBar = findViewById( R.id.NewPostProgress);

        btnAddPost = findViewById( R.id.btnAddPost );
        editTxtDescPost = findViewById( R.id.editTxtDescPost );
        imgNewPost = (ImageView) findViewById( R.id.imgNewPost );

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = database.getInstance().getReference().child("Posts");

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users").child( mCurrentUser.getUid());

    } /// End Main

    public void imageButtonClicked(View view){
        Intent intent = new Intent( Intent.ACTION_GET_CONTENT);
        intent.setType( "image/*" );
        startActivityForResult( intent,GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){

            uri = data.getData();
            imgNewPost.setImageURI(uri);
        }
    }


    public void submitButtonClicked(View view){

        final String descValue = editTxtDescPost.getText().toString().trim();

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat( " dd-MMM-yyyy  h:mm" );
        final String dataString = sdf.format( date );

        if (!TextUtils.isEmpty(descValue) && !TextUtils.isEmpty(dataString)){

            newPostProgressBar.setVisibility( View.VISIBLE );
            StorageReference filePath = storageReference.child( "PostImage" ).child(uri.getLastPathSegment());
            filePath.putFile( uri ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {

                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final  Uri downloaduri = taskSnapshot.getDownloadUrl();
                    Toast.makeText( NewPostActivity.this, "Upload Complete", Toast.LENGTH_LONG ).show();

                    final DatabaseReference newPost = databaseReference.push();
                    mDatabaseUsers.addValueEventListener( new ValueEventListener() {

                       Random rand = new Random();
                       int n = rand.nextInt(10000000) + 1;


                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            newPost.child( "desc" ).setValue( descValue );
                            newPost.child( "image" ).setValue( downloaduri.toString() + n + ".jpg" );
                            newPost.child( "uid" ).setValue( mCurrentUser.getUid());
                            newPost.child( "time" ).setValue( dataString );

                            newPost.child( "imgProfile" ).setValue(dataSnapshot.child( "ImgProfile" ).getValue());
                            newPost.child( "name").setValue(dataSnapshot.child( "Name" ).getValue());
                            newPost.child( "username" ).setValue( dataSnapshot.child( "Username" ).getValue()).addOnCompleteListener( new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Intent mainActivityIntent = new Intent( NewPostActivity.this, MainActivity.class );
                                    startActivity( mainActivityIntent );

                                }
                            });

                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            });
        } else {
            newPostProgressBar.setVisibility( View.INVISIBLE );
        }

    }

}
