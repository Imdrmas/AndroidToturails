package com.drmas.issam.sharefood;

import android.*;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private Toolbar toolbarSetup;
    private CircleImageView setupImage;
    private Uri mainImageUri = null;

    private String user_id;
    private Boolean isChanged = false;

    private EditText setupName;
    private Button setupButton;
    private ProgressBar setupProgress;

    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setup );

        toolbarSetup = findViewById( R.id.toolbarSetup );
        setSupportActionBar( toolbarSetup );
        getSupportActionBar().setTitle( "Account Setup" );

        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        setupName = findViewById( R.id.setupTxtName );
        setupButton = findViewById( R.id.setupBtnAdd );
        setupProgress = findViewById( R.id.setupProgress );

        setupProgress.setVisibility( View.VISIBLE );
        setupButton.setEnabled( false );

        firebaseFirestore.collection( "Users" ).document(user_id).get()
                .addOnCompleteListener( new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){

                        String name = task.getResult().getString( "name" );
                        String image = task.getResult().getString( "image" );

                        setupName.setText( name );
                        mainImageUri = Uri.parse( image );

                        RequestOptions placeholderRequest = new RequestOptions();
                        placeholderRequest.placeholder( R.drawable.avatar );

                        Glide.with( SetupActivity.this ).applyDefaultRequestOptions( placeholderRequest )
                                .load( mainImageUri ).into( setupImage );
                    }

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText( SetupActivity.this, "Error: "+error, Toast.LENGTH_LONG ).show();

                }
                setupProgress.setVisibility( View.INVISIBLE );
                setupButton.setEnabled( true );
            }
        });

        setupButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user_name = setupName.getText().toString();

                if (setupName.length() < 4 || setupName.length() > 12){
                    setupName.setError( "Name must be between 4 and 12 Characters. " );
                }

                if (mainImageUri == null){
                    Toast.makeText( SetupActivity.this, "You have to choose a avatar.", Toast.LENGTH_SHORT ).show();
                }

                if (!TextUtils.isEmpty( user_name ) && mainImageUri != null) {

                 setupProgress.setVisibility( View.VISIBLE );

                if (isChanged) {

                    UUID uuid = UUID.randomUUID();
                    final String randomName = uuid.toString();

                        user_id = firebaseAuth.getCurrentUser().getUid();

                    StorageReference image_path = storageReference.child("profile_images/").child( user_id ).child( randomName + ".jpg" );

                        image_path.putFile( mainImageUri ).addOnCompleteListener( new OnCompleteListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                                if (task.isSuccessful()) {

                                    StoreFireStore( task, user_name );


                                } else {

                                    String error = task.getException().getMessage();
                                    Toast.makeText( SetupActivity.this, "Error: " + error, Toast.LENGTH_LONG ).show();
                                    setupProgress.setVisibility( View.INVISIBLE );
                                }

                            }
                        });
                    } else {

                    StoreFireStore(null, user_name);
                }
                }
            }
        });


        setupImage = findViewById( R.id.setup_image );
        setupImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    if (ContextCompat.checkSelfPermission( SetupActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions( SetupActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1 );

                    } else {

                       BringImagePicker();
                    }
                } else {

                    BringImagePicker();
                }
            }
        });

    } //// Main

    private void StoreFireStore(@NonNull Task<UploadTask.TaskSnapshot> task, String user_name) {

        Uri download_uri;

        if (task != null) {

             download_uri = task.getResult().getDownloadUrl();

        } else {
             download_uri = mainImageUri;
        }

        Map<String, String> userMap = new HashMap<>();
        userMap.put( "name", user_name );
        userMap.put( "image", download_uri.toString());


        firebaseFirestore.collection( "Users" ).document( user_id ).set(userMap ).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){

                    Toast.makeText( SetupActivity.this, "Welcome :", Toast.LENGTH_LONG ).show();

                    Intent mainIntent = new Intent( SetupActivity.this, MainActivity.class );
                    startActivity( mainIntent );
                    finish();

                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText( SetupActivity.this, "Error : "+ error, Toast.LENGTH_LONG ).show();
                }
                setupProgress.setVisibility( View.INVISIBLE );
            }
        });
    }

    private void BringImagePicker() {
        // start picker to get image for cropping and then use the image in cropping activity
        CropImage.activity()
                .setGuidelines( CropImageView.Guidelines.ON)
                .setAspectRatio( 1, 1)
                .start(SetupActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                mainImageUri = result.getUri();
                setupImage.setImageURI( mainImageUri );

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

    }

    // Fun Dialog to go back
    private void createDialog() {

        AlertDialog.Builder alerDlg = new AlertDialog.Builder( this );
        alerDlg.setMessage( "Are you sure want to exit ?" );
        alerDlg.setCancelable( false );

        // positive click
        alerDlg.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SetupActivity.super.onBackPressed();
                // rest in main page
            }
        });
        // negative click
        alerDlg.setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // back to last page
            }
        });
        alerDlg.create().show();
    }

    // Fun Go Back
    public void onBackPressed(){
        createDialog();
    }

}









