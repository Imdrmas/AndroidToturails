package com.drmas.issam.mycompany;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by drmas on 01/03/2018.
 */

public class DbContact extends SQLiteOpenHelper {

    private static final String DB_NAME = "myphone_db";
    private static final int DB_VERSION = 2;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ING = "image";

    public DbContact(Context context) {
        super( context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String create_table = "create table "+TABLE_CONTACT+"("+
                KEY_ID + " integer primary key, " +
                KEY_NAME + " varchar(30), " +
                KEY_PHONE + " integer);";

        Log.d("create", create_table);
       db.execSQL( create_table );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete_query = "DROP Table "+TABLE_CONTACT;
        db.execSQL( delete_query );
        onCreate( db );

    }
    public void addContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( KEY_NAME, contact.getName());
        values.put( KEY_PHONE, contact.getPhone());
      //  values.put( KEY_ING, contact.getImage());

        db.insert(TABLE_CONTACT, null, values);
    }

    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        String select_query = "select * from "+TABLE_CONTACT;
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery( select_query, null );

       if (cursor.moveToFirst()){
           do{
               int id = cursor.getInt( cursor.getColumnIndex( KEY_ID ) );
              String name = cursor.getString(cursor.getColumnIndex( KEY_NAME));
              int phone = cursor.getInt( cursor.getColumnIndex( KEY_PHONE ));
             //  byte[] image = cursor.getBlob( cursor.getColumnIndex( KEY_ING ) );

              Contact contact = new Contact(name, phone, id);
              contacts.add( contact );

           } while (cursor.moveToNext());
       }

        return contacts;
    }

     // Methot 1 to Get contact from database

   public Contact getContactById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String select_query = "select * from "+TABLE_CONTACT + " where id="+id;
        Cursor cursor = db.rawQuery( select_query, null );
        Contact contact = null;

        if (cursor.moveToFirst()){
            int id_contact = cursor.getInt( cursor.getColumnIndex( KEY_ID ) );
            String name = cursor.getString( cursor.getColumnIndex( KEY_NAME ) );
            int phone = cursor.getInt( cursor.getColumnIndex( KEY_PHONE )  );
           // byte[] image = cursor.getBlob( cursor.getColumnIndex( KEY_ING ) );

            contact = new Contact(name, phone, id);
        }

       return contact;
   }
  /*
   public Contact getContactById2(int id){
       Contact contact = null;
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.query( TABLE_CONTACT, new String[]{"id", "name", "phone"}, "id=?",
               new String[]{String.valueOf( id )}, null, null, null);

       if (cursor.moveToFirst()){
           int id_contact = cursor.getInt( cursor.getColumnIndex( KEY_ID ) );
           String name = cursor.getString( cursor.getColumnIndex( KEY_NAME ) );
           int phone = cursor.getInt( cursor.getColumnIndex( KEY_PHONE )  );

           contact = new Contact(name, phone, id);
       }

       return contact;
   }
*/
   public void updateContact(Contact contact){

       SQLiteDatabase db = this.getWritableDatabase();

       ContentValues values = new ContentValues( );
       values.put( KEY_NAME, contact.getName());
       values.put( KEY_PHONE, contact.getPhone());
      // values.put( KEY_NAME, contact.getImage());

       db.update( TABLE_CONTACT, values, "id=?", new String[]{String.valueOf( contact.getId())});
   }

   public void deleteContact(int id){
       SQLiteDatabase db = this.getWritableDatabase();
       db.delete( TABLE_CONTACT, "id=?", new String[]{String.valueOf( id )});
   }


}//Ending Class
