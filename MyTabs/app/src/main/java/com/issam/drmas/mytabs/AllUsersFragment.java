package com.issam.drmas.mytabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllUsersFragment extends Fragment {

    private RecyclerView viewAllUsers;
    private List<Users> usersList;
    private UserRecyclerAdapter userRecyclerAdapter;
    private FirebaseFirestore firebaseFirestore;

    public AllUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_users, container, false);

        viewAllUsers = view.findViewById(R.id.viewAllUsers);
        usersList = new ArrayList<>();
        userRecyclerAdapter = new UserRecyclerAdapter(container.getContext(), usersList);

        firebaseFirestore = FirebaseFirestore.getInstance();

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

                        String userID = doc.getDocument().getId();

                        Users users = doc.getDocument().toObject(Users.class).withId(userID);
                        usersList.add(users);

                        userRecyclerAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
    }
}
