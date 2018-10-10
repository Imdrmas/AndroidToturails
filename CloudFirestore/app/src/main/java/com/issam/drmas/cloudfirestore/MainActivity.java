package com.issam.drmas.cloudfirestore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextPriority;
    private EditText editTextTags;
    private TextView textViewData;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");
    private DocumentReference noteRef = db.collection("Notebook").document("My First Note");

    private DocumentSnapshot lastResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextPriority = findViewById(R.id.edit_text_priority);
        editTextTags = findViewById(R.id.edit_text_tags);
        textViewData = findViewById(R.id.text_view_data);

    }

    @Override
    protected void onStart() {
        super.onStart();

        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null){
                    return;
                }

                for (DocumentChange dc : queryDocumentSnapshots.getDocumentChanges()){
                    DocumentSnapshot documentSnapshot = dc.getDocument();
                    String id = documentSnapshot.getId();
                    int oldIndex = dc.getOldIndex();
                    int newIndex = dc.getNewIndex();

                    switch (dc.getType()){
                        case ADDED:
                            textViewData.append("\nAdded: " + id +
                            "\nOld Index: " + oldIndex + "New Index: " + newIndex);
                            break;
                        case MODIFIED:
                            textViewData.append("\nModified: " + id +
                                    "\nOld Index: " + oldIndex + "New Index: " + newIndex);
                            break;
                        case REMOVED:
                            textViewData.append("\nRemoved: " + id +
                                    "\nOld Index: " + oldIndex + "New Index: " + newIndex);
                            break;
                    }
                }
            }
        });


        /*
        notebookRef
                .get().addOnSuccessListener(this, new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data = "";

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String documentId = note.getDocumentId();
                    String title = note.getTitle();
                    String description = note.getDescription();
                    int priority = note.getPriority();

                    data += "ID: " + documentId
                            + "\nTitle: " + title + "\nDescription: " + description
                            + "\nPriority: " + priority + "\n\n";
                }
                textViewData.setText(data);
            }
        });




           noteRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (e != null){
                    Toast.makeText(MainActivity.this, "Error while loading!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, e.toString());
                    return;
                }
                if (documentSnapshot.exists()){

                    Note note = documentSnapshot.toObject(Note.class);
                    String title = note.getTitle();
                    String description = note.getDescription();

                    textViewData.setText("Title: " + title + "\n" + "Description: " + description);
                } else {
                    textViewData.setText("there is no data");
                }
            }
        });*/
    }

    public void addNote(View view){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

        if (editTextPriority.length() == 0){
            editTextPriority.setText("0");
        }

        int priority = Integer.parseInt(editTextPriority.getText().toString());

        String tagInput = editTextTags.getText().toString();
        String[] tagArray = tagInput.split("\\s*,\\s*");
        List<String> tags = Arrays.asList(tagArray);

        Note note = new Note(title, description, priority, tags);

        notebookRef.add(note);
    }

    public void loadNotes(View view){
        Query query;
        if (lastResult == null){
            query = notebookRef.orderBy("priority").limit(3);
        } else {
            query = notebookRef.orderBy("priority")
                    .startAt(lastResult)
                    .limit(3);
        }

                query.get().addOnSuccessListener(this, new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data = "";

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String documentId = note.getDocumentId();
                    String title = note.getTitle();
                    String description = note.getDescription();
                    int priority = note.getPriority();

                    data += "ID: " + documentId
                            + "\nTitle: " + title + "\nDescription: " + description
                            + "\nPriority: " + priority + "\n\n";
                }

                if (queryDocumentSnapshots.size() > 0) {
                    data += "___________\n\n";
                    textViewData.append(data);

                    lastResult = queryDocumentSnapshots.getDocuments()
                            .get(queryDocumentSnapshots.size() - 1);
                }
            }
        });
    }

    private void executeBatchWrite(){
        WriteBatch batch = db.batch();
        DocumentReference doc1 = notebookRef.document("New Note");
        batch.set(doc1, new Note("New Note", "New Note", 1, null));

        DocumentReference doc2 = notebookRef.document("Not existing Document");
        batch.update(doc2, "title", "Updated Note");

        DocumentReference doc3 = notebookRef.document("id");
        batch.delete(doc3);

        DocumentReference doc4 = notebookRef.document();
        batch.set(doc4, new Note("Added Note", "Added Note", 1, null));
        batch.commit().addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                textViewData.setText(e.toString());
            }
        });
    }

    private void executeTransaction(){
        db.runTransaction(new Transaction.Function<Object>() {
            @Nullable
            @Override
            public Object apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                DocumentReference exampleNoteRef = notebookRef.document("Example Note");
                DocumentSnapshot documentSnapshot = transaction.get(exampleNoteRef);
                long newPriority = documentSnapshot.getLong("priority") + 1;
                transaction.update(exampleNoteRef, "priority", newPriority);
                return null;
            }
        });
    }

    public void updateDescription(View view){
        String description = editTextDescription.getText().toString();
        Map<String, Object> note = new HashMap<>();
        note.put(KEY_DESCRIPTION, description);

        noteRef.set(note, SetOptions.merge());
       // noteRef.update(KEY_DESCRIPTION, description);
    }

    public void saveNote(View v){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

        Note note = new Note(title, description, 1, null);

        noteRef.set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }

    public void deleteDescription(View view){
        Map<String, Object> note = new HashMap<>();
        note.put(KEY_DESCRIPTION, FieldValue.delete());

        noteRef.update(note);
       // noteRef.update(KEY_DESCRIPTION, FieldValue.delete());
    }

    public void deleteNote(View view){
        noteRef.delete();
    }

    public void loadNote(View v){
        noteRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){

                            Note note = documentSnapshot.toObject(Note.class);

                            String title = note.getTitle();
                            String description = note.getDescription();

                            textViewData.setText("Title: " + title + "\n" + "Description: " + description);


                        }else {
                            Toast.makeText(MainActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, e.toString());
            }
        });
    }

    public void loadNoteWithTags(View view){
        notebookRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";

                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            Note note = documentSnapshot.toObject(Note.class);
                            note.setDocumentId(documentSnapshot.getId());

                            String documentId = note.getDocumentId();
                            data += "ID: " + documentId;

                            for (String tag : note.getTags()){
                                data += "\n-" + tag;
                            }
                            data += "\n\n";
                        }
                        textViewData.setText(data);
                    }
                });
    }

    private void updateArray(){
        notebookRef.document("id")
                //.update("tags", FieldValue.arrayUnion("new tags"));
        .update("tags", FieldValue.arrayRemove());
    }


}
