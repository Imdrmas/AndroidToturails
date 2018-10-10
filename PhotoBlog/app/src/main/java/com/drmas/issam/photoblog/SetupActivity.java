package com.drmas.issam.photoblog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;

public class SetupActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbarSetup;
    private EditText setupTxtName;
    private Button setupBtnAdd;
    private CircleImageView ImgProfileSetup;
    private ProgressBar setupProgress;

    private static final int GALLERY_REQ = 1;

    private Uri imageUri = null;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseusers;
    private StorageReference mStorgeref;

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setup );

        toolbarSetup = findViewById( R.id.toolbarSetup );
        setSupportActionBar( toolbarSetup );
        getSupportActionBar().setTitle( "Account Setup" );

        mDatabaseusers = FirebaseDatabase.getInstance().getReference().child( "Users" );
        mAuth = FirebaseAuth.getInstance();
        databaseReference = database.getInstance().getReference().child("Post");
        mStorgeref = FirebaseStorage.getInstance().getReference().child( "profile_image" );


        setupTxtName = findViewById( R.id.setupTxtName );
        setupBtnAdd = findViewById( R.id.setupBtnAdd );
        ImgProfileSetup = findViewById( R.id.ImgProfileSetup );
        setupProgress = findViewById(R.id.setupProgress );

        /// setupBtnAdd.setEnabled( false );



    }/// end Main

    @Override
    protected void onStart() {
        super.onStart();

        final FirebaseUser currentUser = mAuth.getCurrentUser();

        mDatabaseusers.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (currentUser != null){

                    Toast.makeText( SetupActivity.this, "user is exists", Toast.LENGTH_LONG ).show();

                    String username = (String) dataSnapshot.child( "Username" ).getValue();
                    setupTxtName.setText( username );

                } else {

                    Toast.makeText( SetupActivity.this, "User not exists", Toast.LENGTH_LONG ).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );


    }

    public void ImgProfileSetup(View view){
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
                ImgProfileSetup.setImageURI( resultUri );
            }else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
                Exception error = result.getError();
            }
        }
    }



    public void setupBtnAdd(View view){

        final String name = setupTxtName.getText().toString().trim();
        final String user_id = mAuth.getCurrentUser().getUid();
        if (!TextUtils.isEmpty( name ) && imageUri!=null){

            setupProgress.setVisibility(View.VISIBLE);

            StorageReference filpath = mStorgeref.child( imageUri.getLastPathSegment());
            filpath.putFile( imageUri ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Random rand = new Random();
                    int n = rand.nextInt(1000000) + 1;


                    String downloadurl = taskSnapshot.getDownloadUrl().toString();
                    mDatabaseusers.child( user_id ).child( "Username" ).setValue( name );
                    mDatabaseusers.child( user_id ).child( "ImgProfile" ).setValue(downloadurl + n );
                    Toast.makeText( SetupActivity.this, "Infos added", Toast.LENGTH_LONG ).show();

                    Intent HomeIntent = new Intent(SetupActivity.this, MainActivity.class);
                    startActivity( HomeIntent );
                }
            } );

        } else {
            Toast.makeText( SetupActivity.this, "There is an error", Toast.LENGTH_LONG ).show();
        }
        setupProgress.setVisibility(View.INVISIBLE);

    }




} /// Ending
