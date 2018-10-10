package com.issam.drmas.sqlitetutorials;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDoa noteDoa();

    public static synchronized NoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private NoteDoa noteDoa;

        private PopulateDbAsyncTask(NoteDatabase db){
            noteDoa = db.noteDoa();
            new PopulateDbAsyncTask(instance).execute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDoa.insert(new Note("Title 1", "Description 1", 1));
            noteDoa.insert(new Note("Title 2", "Description 2", 2));
            noteDoa.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}
