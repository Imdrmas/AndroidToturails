package com.drmas.issam.mybirthdate;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyCall extends AppCompatActivity {

    TextView txtNum;
    EditText txtMsg;
    TextView txtName;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_call );

        txtNum = (EditText) findViewById( R.id.txtNum );
        txtMsg = (EditText) findViewById( R.id.txtSendNow );
        txtName = (TextView) findViewById( R.id.txtName );


        Button btnCall = (Button) findViewById( R.id.btnCall );
        Button btnOpenSms = (Button) findViewById( R.id.btnOpenSms );
        Button btnsenNow = (Button) findViewById( R.id.btnSendNow );
        Button btnOpenCont = (Button)findViewById( R.id.btnOpenCont );
        Button btnGet = (Button) findViewById( R.id.btnGetCont );

        final Intent icall = new Intent( Intent.ACTION_CALL );
        final Intent iSms = new Intent( Intent.ACTION_VIEW );
        final Intent iContact = new Intent( Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI );
        final Intent iContScreen = new Intent(this, GetContact.class );

        btnCall.setOnClickListener( new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
             startActivity(icall);

            }
        });

        btnOpenSms.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iSms.setData( Uri.parse( "sms:" +txtNum.getText()) );
                startActivity(iSms);
            }
        });

        btnsenNow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms(txtNum.getText()+"", txtMsg.getText()+"");

            }
        });

        btnOpenCont.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity( iContact );
                startActivityForResult( iContact, 1);
            }
        });
        btnGet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( iContScreen );
            }
        });




    }//end Main
    protected void sendSms(String phoneNumber, String message) {
        try {
            SmsManager mySms = SmsManager.getDefault();
            mySms.sendTextMessage( phoneNumber, null, message, null, null );
            Toast.makeText( this, "Message Is Send", Toast.LENGTH_LONG ).show();

        }catch (Exception e){
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
        }
    }
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data){
        Uri uri = data.getData();
        Cursor cursor = getContentResolver().query( uri, null, null, null, null );
        cursor.moveToFirst();
        int numIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        int nameIndex = cursor.getColumnIndex( ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME );
        String strNumber = cursor.getString( numIndex);
        String strName = cursor.getString( nameIndex );
        txtNum.setText( strNumber);
        txtName.setText( strName);
    }
    /*protected void fillContact(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null  );
        int x = 0;
        while (cursor.moveToNext()){
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER  );
            int nameIndex = cursor.getColumnIndex( ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME );
            String strPhone = cursor.getString( phoneIndex );
            String strName = cursor.getString( nameIndex );
            txtContact.setText( txtContact.getText() + "\n" + strName + ": " + strPhone );
             x++;
             if (x==2)break;

        }
    }*/


} // Ending
