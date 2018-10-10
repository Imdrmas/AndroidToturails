package com.issam.drmas.mysqlite.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.issam.drmas.mysqlite.MainActivity;
import com.issam.drmas.mysqlite.R;
import com.issam.drmas.mysqlite.model.User;
import com.issam.drmas.mysqlite.sql.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTaskActivity extends AppCompatActivity {

  //  private String nameFromIntent;
    private ProgressBar progressAdd;

    private TextInputEditText textInputEditTextPriceMoney;
    private TextInputEditText textInputEditTextMoney;
    private Button btnAddMoney;

    //Spend Activity
    private EditText editSpendPriceTxt;
    private EditText editSpendTxt;
    private Button btnAddSpend;

    //Note Activity
    private EditText editTitleTxt;
    private EditText editNoteTxt;
    private Button btnAddNote;

    private DatabaseHelper databaseHelper;

    private String userName;
    private String userEmail;
    private String userPass;
    private String userId;

    private String emailFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().hide();

        emailFromIntent = getIntent().getStringExtra("EMAIL");

        textInputEditTextPriceMoney = (TextInputEditText) findViewById(R.id.textInputEditTextPriceMoney);
        textInputEditTextMoney = (TextInputEditText) findViewById(R.id.textInputEditTextMoney);

        progressAdd = findViewById(R.id.progressAdd);
        btnAddMoney = findViewById(R.id.btnAddMoney);
        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String priceMoney = textInputEditTextPriceMoney.getText().toString().trim();
                String money = textInputEditTextMoney.getText().toString().trim();

                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat(" dd MMM yyyy  h:mm");
                String dateString = sdf.format(date);

                if (textInputEditTextPriceMoney.length() < 2 || textInputEditTextPriceMoney.length() > 10){
                    textInputEditTextPriceMoney.setError("Please Enter Minimum Number Is 2 !");
                    textInputEditTextPriceMoney.requestFocus();

                } else if (textInputEditTextMoney.length() < 4 || textInputEditTextMoney.length() > 40){
                    textInputEditTextMoney.setError("Please Enter How Much In Arabic");
                    textInputEditTextMoney.requestFocus();

                } else if (!TextUtils.isEmpty(money) && !TextUtils.isEmpty(priceMoney)
                        && !TextUtils.isEmpty(emailFromIntent)) {

                    progressAdd.setVisibility(View.VISIBLE);
                    double  priceValue = Double.parseDouble(priceMoney);

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference namesRef = reference.child("Money");
                    String moneyKey = reference.push().getKey().toString();

                    Map<String, Object> newMoney = new HashMap<>();
                  //  newMoney.put("name", userName);
                    newMoney.put("email", emailFromIntent);
                    newMoney.put("money", money);
                    newMoney.put("price", priceValue);
                    newMoney.put("time", dateString);

                    namesRef.child(moneyKey).setValue(newMoney);

                    Toast.makeText(AddTaskActivity.this, "Money Added Successfully Thanks !", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                    intent.putExtra("EMAIL", emailFromIntent);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(AddTaskActivity.this, "Name And Number Can't Be Empty", Toast.LENGTH_LONG).show();
                }

            }
        });





    } ///Main


}
