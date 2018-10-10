package com.issam.drmas.mytabs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SendActivity extends AppCompatActivity {

    private TextView textUserId;
    private String userName;

    private String userId;
    private String currentId;

    private EditText sendMessage;
    private Button btnSend;

    private FirebaseFirestore firebaseFirestore;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        firebaseFirestore = FirebaseFirestore.getInstance();
        currentId = FirebaseAuth.getInstance().getUid();

        textUserId = findViewById(R.id.userId);
        userId = getIntent().getStringExtra("userId");
        userName = getIntent().getStringExtra("name");
        textUserId.setText("Send To : "+ userName);

        sendMessage = findViewById(R.id.sendMessage);
        btnSend = findViewById(R.id.btnSend);

        progressBar = findViewById(R.id.progressBarSend);
        progressBar.setVisibility(View.INVISIBLE);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = sendMessage.getText().toString();

                if (!TextUtils.isEmpty(message)){

                    progressBar.setVisibility(View.VISIBLE);

                    Map<String, Object> notificationMessage = new HashMap<>();
                    notificationMessage.put("message", message);
                    notificationMessage.put("from", currentId);

                    firebaseFirestore.collection("Users/"+ userId + "/Notification").add(notificationMessage).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Toast.makeText(SendActivity.this, "Notification sent", Toast.LENGTH_SHORT).show();
                            sendMessage.setText("");
                            progressBar.setVisibility(View.INVISIBLE);

                            Intent intent = new Intent(SendActivity.this, MainActivity.class);
                            startActivity(intent);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SendActivity.this, "Error : ", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
    }
}
