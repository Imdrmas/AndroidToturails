package com.drmas.issam.mycompany;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.InputStream;

public class AddContact extends AppCompatActivity {

    EditText editName, editPhone;
    Button btnConfirm;
    ImageButton pickImg;
    DbContact db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_contact );

        db = new DbContact( this );

        editName = (EditText) findViewById( R.id.editName );
        editPhone = (EditText) findViewById( R.id.editPHone );
        btnConfirm = (Button) findViewById( R.id.btnConfirm );
        pickImg = (ImageButton) findViewById( R.id.pickImg );

        btnConfirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int phone = Integer.parseInt( editPhone.getText().toString());
                int id = 0;
                Contact contact = new Contact(name, phone, id);

                db.addContact( contact );

                Toast.makeText( AddContact.this, "Contact added", Toast.LENGTH_LONG ).show();
                finish();

            }
        } );
    }

    public void openGallerie(View view){

        Intent intentImg = new Intent( Intent.ACTION_GET_CONTENT );
        intentImg.setType("image/*");
        startActivityForResult( intentImg, 100 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if(requestCode == RESULT_OK && resultCode == 100);
        Uri uri = data.getData();
        try {
            InputStream inputStream = getContentResolver().openInputStream( uri );
            Bitmap decodeStream = BitmapFactory.decodeStream( inputStream );
            pickImg.setImageBitmap( decodeStream );
        } catch (Exception ex){
            Log.e("ex", ex.getMessage());
        }
    }


} //anding class add
