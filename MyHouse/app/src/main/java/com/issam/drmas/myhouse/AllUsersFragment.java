package com.issam.drmas.myhouse;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllUsersFragment extends Fragment {

    private RecyclerView viewAllUsers;
    private FirebaseFirestore firebaseFirestore;

    private UserRecyclerAdapter userRecyclerAdapter;
    private List<Users> usersList;

    public AllUsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_users, container, false);

        firebaseFirestore = FirebaseFirestore.getInstance();

        viewAllUsers = view.findViewById(R.id.viewAllUsers);
        usersList = new ArrayList<>();
        userRecyclerAdapter = new UserRecyclerAdapter(container.getContext(), usersList);

        viewAllUsers.setHasFixedSize(true);
        viewAllUsers.setLayoutManager(new LinearLayoutManager(container.getContext()));
        viewAllUsers.setAdapter(userRecyclerAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        usersList.clear();

        firebaseFirestore.collection("Users").addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                for (DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        Users users = doc.getDocument().toObject(Users.class);
                        usersList.add(users);
                        userRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
