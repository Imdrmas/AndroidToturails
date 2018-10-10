package com.issam.drmas.mytabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private Button mLogoutBtn;
    private FirebaseAuth mAuth;

    private FirebaseFirestore firebaseFirestore;
    private String userId;

    private CircleImageView imageUser;
    private TextView nameUser;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth = FirebaseAuth.getInstance();
        mLogoutBtn = view.findViewById(R.id.btnLogoutClicked);

        firebaseFirestore = FirebaseFirestore.getInstance();
        userId = mAuth.getCurrentUser().getUid();

        imageUser = view.findViewById(R.id.userImageProfile);
        nameUser = view.findViewById(R.id.nameUserProfile);

        firebaseFirestore.collection("Users").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String name_user = documentSnapshot.getString("name");
                String image_user = documentSnapshot.getString("image");

                nameUser.setText(name_user);

                RequestOptions placeHolder = new RequestOptions();
                placeHolder.placeholder(R.drawable.user_avatar);

                Glide.with(container.getContext()).setDefaultRequestOptions(placeHolder).load(image_user).into(imageUser);
            }
        });

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                Intent intent = new Intent(container.getContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }

}
