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

import java.text.SimpleDateFormat;

public class UpdateActivity extends AppCompatActivity {

    private ImageButton imageButtonUpdate;
    private EditText editTextUpdateName, editTextUpdateDesc;

    private static final int GALLERY_REQUEST = 1;
    private Uri imageUri = null;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseusers;
    private StorageReference mStorgeref;
    private FirebaseUser mCurrentUser;


    private int progressState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update );


        editTextUpdateName = (EditText) findViewById( R.id.editTextUpdateName );
        editTextUpdateDesc = (EditText) findViewById( R.id.editTextUpdateDesc );

        mDatabaseusers = FirebaseDatabase.getInstance().getReference().child("InsaApp");
      //  mDatabaseusers = FirebaseDatabase.getInstance().getReference().child( "InsaApp" );
        mAuth = FirebaseAuth.getInstance();
        mStorgeref = FirebaseStorage.getInstance().getReference().child( "Edit_image" );


    } //// End Main

    public void imageButtonUpdateClicked(View view){
        Intent intent = new Intent( Intent.ACTION_GET_CONTENT);
        intent.setType( "image/*" );
        startActivityForResult( intent,GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            imageUri = data.getData();
            imageButtonUpdate = (ImageButton)findViewById( R.id.imageButtonUpdate);
            imageButtonUpdate.setImageURI(imageUri);
        }
    }

    public void submitButtonUpdateClicked(View view){

        final String name = editTextUpdateName.getText().toString().trim();
        final String desc = editTextUpdateDesc.getText().toString().trim();
        final String user_id = mAuth.getCurrentUser().getUid();

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat( " dd MM yyyy  h:mm" );
        final String dataString = sdf.format( date );


        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty( dataString ) && imageUri!=null){

             showProgressDialog();
            StorageReference filpath = mStorgeref.child( imageUri.getLastPathSegment());
            filpath.putFile( imageUri ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    String downloadurl = taskSnapshot.getDownloadUrl().toString();
                    mDatabaseusers.child( "name" ).setValue( name );
                    mDatabaseusers.child( "desc" ).setValue( desc );
                    mDatabaseusers.child( "time" ).setValue( dataString );
                    mDatabaseusers.child( "uid" ).child( user_id );
                    mDatabaseusers.child( "image" ).setValue(downloadurl );

                    Toast.makeText( UpdateActivity.this, "Poste updated", Toast.LENGTH_LONG ).show();

                    Intent HomeIntent = new Intent(UpdateActivity.this, HomeActivity.class);
                    startActivity( HomeIntent );
                }
            } );

        } else {
            Toast.makeText( UpdateActivity.this, "There is an error", Toast.LENGTH_LONG ).show();
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



} /// Ending
