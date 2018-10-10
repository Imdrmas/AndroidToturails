package com.drmas.issam.mycompany;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContact extends AppCompatActivity {

    EditText editName, editPhone;
    DbContact db;
    Button btnUpdate;
     int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_contact );

        id = getIntent().getIntExtra("id", 0);

        db = new DbContact(this);

        editName = (EditText) findViewById( R.id.editName );
        editPhone = (EditText) findViewById( R.id.editPHone );
        btnUpdate = (Button) findViewById( R.id.btnUpdate);

        Contact contact = db.getContactById( id );

        editName.setText( contact.getName());
        editPhone.setText( contact.getPhone()+"");

        btnUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int phone = Integer.parseInt( editPhone.getText().toString());

                Contact newContact = new Contact(name, phone, id);

                db.updateContact( newContact );

                Toast.makeText( UpdateContact.this, "Contact Updated", Toast.LENGTH_LONG ).show();
                finish();

            }
        });

    } /// ending main

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate( R.menu.delete_menu, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item_delete:
                showAlert();
                break;

        }
        return super.onOptionsItemSelected( item );
    }

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( this );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Are You Sure ?" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     // Delete Contact
                        db.deleteContact( id );
                        finish();
                    }
                })
                .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = alertBuider.create();
        dialog.show();
    }

} // ending Oncreate









