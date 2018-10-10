package com.drmas.issam.mybirthdate;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GetContact extends AppCompatActivity {

    List<String> cont = new ArrayList<String>();
    Button btnGetCont;
    Cursor cursor;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_get_contact );

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        btnGetCont = (Button) findViewById( R.id.btnGetCont);
        lv = (ListView) findViewById( R.id.LV );
        cursor = getContentResolver().query(uri,null,null,null,null  );

        btnGetCont.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSomeContacts( 1);
            }
        } );
    } // End Main
    protected void getSomeContacts(int count){
        int x = 0;
        while (cursor.moveToNext()){
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER  );
            int nameIndex = cursor.getColumnIndex( ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME );
            String strPhone = cursor.getString( phoneIndex );
            String strName = cursor.getString( nameIndex );
            cont.add( strName + ": " + strPhone );

            x++;
            if(x==count)break;
        }
        ArrayAdapter<String> data = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, cont );
        lv.setAdapter(data);
    }


} // ending
