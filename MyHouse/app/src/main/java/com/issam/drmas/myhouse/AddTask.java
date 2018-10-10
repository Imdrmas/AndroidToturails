package com.issam.drmas.myhouse;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.sql.Timestamp;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class AddTask extends AppCompatActivity {

    private String userId;
    private String name_user;

    private ProgressBar progressAdd;

    private EditText editPriceTxt;
    private EditText editMoneyTxt;
    private Button btnAddMoney;

    //Spend Activity
    private EditText editSpendPriceTxt;
    private EditText editSpendTxt;
    private Button btnAddSpend;

    //Note Activity
    private EditText editTitleTxt;
    private EditText editNoteTxt;
    private Button btnAddNote;

    private String issamdrmas = "Issam Drmas";
    private String mohaned = "Mohaned Abdallah";

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        progressAdd = findViewById(R.id.progressAdd);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        /*
        if (acct != null) {
            name_user = acct.getDisplayName();
            userId = acct.getId();

*/
/*
        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();

          firebaseFirestore = FirebaseFirestore.getInstance();
          firebaseFirestore.collection("Users").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
          name_user = documentSnapshot.getString("name");

            }
        });
*/


          editPriceTxt = (EditText) findViewById(R.id.editPriceTxt);
          editMoneyTxt = (EditText) findViewById(R.id.editMoneyTxt);


        Random rand = new Random();
        int n = rand.nextInt(200);
        userId = String.valueOf(n);

          btnAddMoney = findViewById(R.id.btnAddMoney);
          btnAddMoney.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                 String priceMoney = editPriceTxt.getText().toString().trim();
                 String money = editMoneyTxt.getText().toString().trim();

                  long date = System.currentTimeMillis();
                  SimpleDateFormat sdf = new SimpleDateFormat(" dd MMM yyyy  h:mm");
                  String dateString = sdf.format(date);

                  if (editPriceTxt.length() < 2 || editPriceTxt.length() > 10){
                      editPriceTxt.setError("Please Enter Minimum Number Is 2 !");
                      editPriceTxt.requestFocus();

                  } else if (editMoneyTxt.length() < 4 || editMoneyTxt.length() > 40){
                      editMoneyTxt.setError("Please Enter How Much In Arabic");
                      editMoneyTxt.requestFocus();

                  } else if (!TextUtils.isEmpty(money) && !TextUtils.isEmpty(priceMoney) && !TextUtils.isEmpty(userId)
                              && !TextUtils.isEmpty(dateString) && !TextUtils.isEmpty(issamdrmas)) {

                             progressAdd.setVisibility(View.VISIBLE);
                             double  priceValue = Double.parseDouble(priceMoney);

                             DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                             DatabaseReference namesRef = reference.child("Money");
                             String moneyKey = reference.push().getKey().toString();

                             Map<String, Object> newMoney = new HashMap<>();
                             newMoney.put("userId", userId);
                             newMoney.put("name", issamdrmas);
                             newMoney.put("money", money);
                             newMoney.put("price", priceValue);
                             newMoney.put("time", dateString);

                             namesRef.child(moneyKey).setValue(newMoney);

                          Toast.makeText(AddTask.this, "Money Added Successfully Thanks !", Toast.LENGTH_LONG).show();
                          Intent intent = new Intent(AddTask.this, Main2Activity.class);
                          startActivity(intent);
                          finish();

                      } else {
                          Toast.makeText(AddTask.this, "Name And Number Can't Be Empty", Toast.LENGTH_LONG).show();
                      }

              }
          });

           //////////////////////////////////// Spend Activity //////////////////////////////
        editSpendPriceTxt = findViewById(R.id.editSpendPriceTxt);
        editSpendTxt = findViewById(R.id.editSpendTxt);
        btnAddSpend = findViewById(R.id.btnAddSpend);
        btnAddSpend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String priceSpend = editSpendPriceTxt.getText().toString().trim();
                String spend = editSpendTxt.getText().toString().trim();

                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat(" dd MMM yyyy  h:mm");
                String dateString = sdf.format(date);

                if (editSpendPriceTxt.length() < 2 || editSpendPriceTxt.length() > 10){
                    editSpendPriceTxt.setError("Please Enter Minimum Number Is 2 !");
                    editSpendPriceTxt.requestFocus();

                } else if (editSpendTxt.length() < 4 || editSpendTxt.length() > 40){
                    editSpendTxt.setError("Please Enter How Much In Arabic");
                    editSpendTxt.requestFocus();

                } else {

                    if (!TextUtils.isEmpty(spend) && !TextUtils.isEmpty(priceSpend) && !TextUtils.isEmpty(userId)
                            && !TextUtils.isEmpty(dateString) && !TextUtils.isEmpty(name_user)) {

                        progressAdd.setVisibility(View.VISIBLE);
                        double priceValue = Double.parseDouble(priceSpend);

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference namesRef = reference.child("Spend");
                        String spendKey = reference.push().getKey().toString();

                        Map<String, Object> newMoney = new HashMap<>();
                        newMoney.put("userId", userId);
                        newMoney.put("name", name_user);
                        newMoney.put("spend", spend);
                        newMoney.put("price", priceValue);
                        newMoney.put("time", dateString);

                        namesRef.child(spendKey).setValue(newMoney);

                        Toast.makeText(AddTask.this, "Money Spend Added Successfully Thanks !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AddTask.this, Main2Activity.class);
                        startActivity(intent);

                        finish();

                    } else {
                        Toast.makeText(AddTask.this, "Name And Number Can't Be Empty", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        ///////////////////////////// Note Activity ///////////////////////////////////
        editTitleTxt = findViewById(R.id.editTitleTxt);
        editNoteTxt = findViewById(R.id.editNoteTxt);
        btnAddNote = findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editTitleTxt.getText().toString().trim();
                String note = editNoteTxt.getText().toString().trim();

                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat(" dd MMM yyyy  h:mm");
                String dateString = sdf.format(date);

                if (editTitleTxt.length() < 2 || editTitleTxt.length() > 20){
                    editTitleTxt.setError("Please Title Maximum 20 Characters !");
                    editTitleTxt.requestFocus();

                } else if (editNoteTxt.length() < 4 || editNoteTxt.length() > 240){
                    editNoteTxt.setError("Please Note Maximum 240 Characters !");
                    editNoteTxt.requestFocus();

                } else {

                    if (!TextUtils.isEmpty(note) && !TextUtils.isEmpty(dateString) && !TextUtils.isEmpty(userId)
                            && !TextUtils.isEmpty(name_user) && !TextUtils.isEmpty(title)) {

                        progressAdd.setVisibility(View.VISIBLE);
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        DatabaseReference namesRef = reference.child("Note");
                        String noteKey = reference.push().getKey().toString();

                        Map<String, Object> newMoney = new HashMap<>();
                        newMoney.put("userId", userId);
                        newMoney.put("name", name_user);
                        newMoney.put("title", title);
                        newMoney.put("note", note);
                        newMoney.put("time", dateString);

                        namesRef.child(noteKey).setValue(newMoney);

                        Toast.makeText(AddTask.this, "Money Added Successfully Thanks !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AddTask.this, Main2Activity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(AddTask.this, "Title And Note Can't Be Empty", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    } ///Main


}
