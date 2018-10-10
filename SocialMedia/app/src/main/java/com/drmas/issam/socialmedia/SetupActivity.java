package com.drmas.issam.socialmedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


public class SetupActivity extends AppCompatActivity {

    private EditText editDisplayName;
    private ImageButton displayImage;
    private static final int GALLERY_REQ = 1;
    private Uri imageUri = null;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseusers;
    private StorageReference mStorgeref;
    private int progressState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setup );

        editDisplayName = (EditText)findViewById( R.id.displayName );
        displayImage = (ImageButton)findViewById( R.id.setupImageButton );

        mDatabaseusers = FirebaseDatabase.getInstance().getReference().child( "Users" );
        mAuth = FirebaseAuth.getInstance();
        mStorgeref = FirebaseStorage.getInstance().getReference().child( "profile_image" );

    }

    public void imageButtonClicked(View view){
        Intent intent = new Intent( Intent.ACTION_GET_CONTENT);
        intent.setType( "image/*" );
        startActivityForResult( intent,GALLERY_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == GALLERY_REQ && resultCode == RESULT_OK){

             imageUri = data.getData();
             CropImage.activity(imageUri)
                    .setGuidelines( CropImageView.Guidelines.ON )
                    .setAspectRatio( 1,1 )
                    .start( this );

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult( data );
            if (resultCode==RESULT_OK){
                Uri resultUri = result.getUri();
                displayImage.setImageURI( resultUri );
            }else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
                Exception error = result.getError();
            }
        }
    }

    public void doneButtonClicked(View view){

        final String name = editDisplayName.getText().toString().trim();
        final String user_id = mAuth.getCurrentUser().getUid();
        if (!TextUtils.isEmpty( name ) && imageUri!=null){

            showProgressDialog();
            StorageReference filpath = mStorgeref.child( imageUri.getLastPathSegment());
            filpath.putFile( imageUri ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    String downloadurl = taskSnapshot.getDownloadUrl().toString();
                    mDatabaseusers.child( user_id ).child( "Username" ).setValue( name );
                    mDatabaseusers.child( user_id ).child( "ImgProfile" ).setValue(downloadurl );
                    Toast.makeText( SetupActivity.this, "Infos added", Toast.LENGTH_LONG ).show();

                    Intent HomeIntent = new Intent(SetupActivity.this, HomeActivity.class);
                    startActivity( HomeIntent );
                }
            } );

        } else {
            Toast.makeText( SetupActivity.this, "There is an error", Toast.LENGTH_LONG ).show();
        }
    }

    public void notNowColicked(View view){
        Intent loginIntent = new Intent( SetupActivity.this, HomeActivity.class );
        startActivity( loginIntent );

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
} ///ending
