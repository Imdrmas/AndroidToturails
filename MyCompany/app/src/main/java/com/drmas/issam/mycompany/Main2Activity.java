package com.drmas.issam.mycompany;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView contactList;
    Button btnAdd;

    DbContact db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        contactList = (ListView) findViewById( R.id.contactList );
        btnAdd = (Button) findViewById( R.id.btnAdd);

        db = new DbContact( this );

        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, AddContact.class );
                startActivity( intent );
            }
        });

        contactList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contact selected_contect = (Contact) parent.getItemAtPosition( position );

                Intent intent = new Intent( Main2Activity.this, UpdateContact.class );
                intent.putExtra( "id", selected_contect.getId());
                startActivity( intent );
            }
        } );
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Contact> contacts = db.getAllContacts();
        ContactAdapter contactAdapter = new ContactAdapter( this, R.layout.item_contact, contacts );
        contactList.setAdapter( contactAdapter);
    }
}
