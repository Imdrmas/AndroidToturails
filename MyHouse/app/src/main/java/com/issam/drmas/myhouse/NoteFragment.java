package com.issam.drmas.myhouse;


import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {

    private RecyclerView viewNote;
    private DatabaseReference mDatabase;


    public NoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        viewNote = view.findViewById(R.id.viewNote);
        viewNote.setHasFixedSize(true);
        viewNote.setLayoutManager(new LinearLayoutManager(getContext()));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Note");

        return view;
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        View mView;
        public NoteViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name){
            TextView nameTxt = (TextView) mView.findViewById(R.id.nameUserViewNote);
            nameTxt.setText(name);
        }
        public void setNote(String note){
            TextView noteTxt = (TextView) mView.findViewById(R.id.noteNameView);
            noteTxt.setText(note);
        }
        public void setTitle(String title){
            TextView titleTxt = (TextView) mView.findViewById(R.id.noteTitleView);
            titleTxt.setText(title);
        }
        public void setTitme(String titme){
            TextView titmeTxt = (TextView) mView.findViewById(R.id.timeViewNote);
            titmeTxt.setText(titme);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Note, NoteViewHolder> FBRA = new FirebaseRecyclerAdapter<Note, NoteViewHolder>(
                Note.class,
                R.layout.liste_note,
                NoteViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(NoteViewHolder viewHolder, Note model, int position) {
                final String noteId = getRef(position).getKey().toString();
                viewHolder.setName(model.getName());
                viewHolder.setNote(model.getNote());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setTitme(model.getTime());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(getContext(), SangleNoteActivity.class);
                        intent.putExtra("noteId", noteId);
                        startActivity(intent);
                    }
                });
            }
        };
        viewNote.setAdapter(FBRA);
    }
}










