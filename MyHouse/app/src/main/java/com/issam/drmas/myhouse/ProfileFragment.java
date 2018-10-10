package com.issam.drmas.myhouse;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private FirebaseFirestore firebaseFirestore;

    private Button btnDeleteClicked;
    private Button btnSetupClicked;

    private CircleImageView imageUserView;
    private String image_user;
    private String name_user;

    private String userId;
    private String personEmail;
    private String personGivenName;
    private String personFamilyName;

    private ProgressBar progressDeleted;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnDeleteClicked = view.findViewById(R.id.btnDeleteClicked);
        btnSetupClicked = view.findViewById(R.id.btnSetupClicked);

        progressDeleted = view.findViewById(R.id.progressDeleted);
        progressDeleted.setVisibility(View.GONE);

        imageUserView = view.findViewById(R.id.userImageProfile);
        TextView firstNameUserTxt = view.findViewById(R.id.firstUserProfile);
        TextView lastNameUserTxt = view.findViewById(R.id.lastNameUserProfile);
        TextView emailUserTxt = view.findViewById(R.id.emailUserProfile);

        /*
        firebaseFirestore = FirebaseFirestore.getInstance();

                GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            name_user = acct.getDisplayName();
            personGivenName = acct.getGivenName();
            personFamilyName = acct.getFamilyName();
            personEmail = acct.getEmail();

            userId = acct.getId();
            image_user = acct.getPhotoUrl().toString();
        }

        firstNameUserTxt.setText("Firstname: "+personGivenName);
        lastNameUserTxt.setText("Lastname: "+personFamilyName);
        emailUserTxt.setText(personEmail);


                    RequestOptions placeHolder = new RequestOptions();
                    placeHolder.placeholder(R.drawable.user_avatar);

                    Glide.with(container.getContext()).setDefaultRequestOptions(placeHolder).load(image_user).into(imageUserView);

            btnSetupClicked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SetupActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    getActivity().finish();
                }
            });

            btnDeleteClicked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   showAlert();
                }
            });

        return view;

        }


    private void deleteAccount(){
        progressDeleted.setVisibility(View.VISIBLE);
       final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider.getCredential("user@example.com", "password1234");

        user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "User account deleted.");

                            Toast.makeText(getContext(), "User account deleted "+name_user, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), RegisterActivity.class));
                            getActivity().finish();
                        } else {
                            Toast.makeText(getContext(), "Error: can't deleted user", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    private void showAlert(){
        AlertDialog.Builder alertBuider = new AlertDialog.Builder( getActivity() );
        alertBuider.setTitle( "Confirmation" )
                .setMessage( "Do you want to delete user" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       deleteAccount();
                     firebaseFirestore.collection("Users").document(userId).delete();
                    }
                } ).setNegativeButton( "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = alertBuider.create();
        dialog.show();
    }
*/
        return view;

    }
}
