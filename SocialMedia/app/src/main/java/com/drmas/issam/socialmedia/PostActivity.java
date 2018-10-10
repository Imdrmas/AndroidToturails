package com.drmas.issam.socialmedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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

import java.net.URI;
import java.text.SimpleDateFormat;

public class PostActivity extends AppCompatActivity {

    private static final int GALLERY_REQUEST = 2;
    private Uri uri = null;
    private ImageButton imageButton;
    private EditText editTextTitle, editTextDesc;
    private StorageReference storageReference;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private FirebaseUser mCurrentUser;
    private int progressState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_post );

        editTextTitle = (EditText)findViewById( R.id.editTextTitle );
        editTextDesc = (EditText)findViewById( R.id.editTextDesc );

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = database.getInstance().getReference().child("InsaApp");

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
            imageButton = (ImageButton)findViewById( R.id.imageButton );
            imageButton.setImageURI(uri);
        }
    }

    public void submitButtonClicked(View view){

      final String titleValue = editTextTitle.getText().toString().trim();
      final String descValue = editTextDesc.getText().toString().trim();

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat( " dd-MMM-yyyy  h:mm" );
        final String dataString = sdf.format( date );

      if (!TextUtils.isEmpty(titleValue) && !TextUtils.isEmpty(descValue) && !TextUtils.isEmpty(dataString)){

          showProgressDialog();
          StorageReference filePath = storageReference.child( "PostImage" ).child(uri.getLastPathSegment());
          filePath.putFile( uri ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                final  Uri downloaduri = taskSnapshot.getDownloadUrl();
                Toast.makeText( PostActivity.this, "Upload Complete", Toast.LENGTH_LONG ).show();

                final DatabaseReference newPost = databaseReference.push();
               mDatabaseUsers.addValueEventListener( new ValueEventListener() {

                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       newPost.child( "title" ).setValue( titleValue );
                       newPost.child( "desc" ).setValue( descValue );
                       newPost.child( "image" ).setValue( downloaduri.toString());
                       newPost.child( "uid" ).setValue( mCurrentUser.getUid());
                       newPost.child( "time" ).setValue( dataString );

                       newPost.child( "imgProfile" ).setValue(dataSnapshot.child( "ImgProfile" ).getValue());
                       newPost.child( "name").setValue(dataSnapshot.child( "Name" ).getValue());
                       newPost.child( "username" ).setValue( dataSnapshot.child( "Username" ).getValue()).addOnCompleteListener( new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {

                            Intent mainActivityIntent = new Intent( PostActivity.this, HomeActivity.class );
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
      }
    }

    public void showProgressDialog(){

        final ProgressDialog pDialog = new ProgressDialog( this );
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        pDialog.setProgressStyle( ProgressDialog.STYLE_HORIZONTAL );
        pDialog.setProgress( 0 );
        pDialog.setMax(100);

        pDialog.show();

        new Thread( new Runnable() {
            @Override
            public void run() {
                while (progressState < 100){
                    progressState += 10;

                    try {
                        Thread.sleep( 1000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pDialog.setProgress( progressState );
                }
                if (progressState >= 100){
                    pDialog.dismiss();
                }
            }
        }).start();
    }

} //// ending
