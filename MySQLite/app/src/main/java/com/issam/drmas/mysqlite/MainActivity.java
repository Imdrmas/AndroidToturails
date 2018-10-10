package com.issam.drmas.mysqlite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.issam.drmas.mysqlite.activities.AddTaskActivity;
import com.issam.drmas.mysqlite.activities.UsersListActivity;
import com.issam.drmas.mysqlite.sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView5;

    private String emailFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

       //emailFromIntent = getIntent().getStringExtra("EMAIL");
        int userID = getIntent().getIntExtra("userId", 0);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(userID+"");

    }

    public void btnMainPage(View view){
    }
    public void btnProfile(View view){
        Intent intent = new Intent(MainActivity.this, UsersListActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnAddTask(View view){
        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
        intent.putExtra("EMAIL", textView5.getText().toString());
        startActivity(intent);
        finish();
    }
    public void signOut(View view){

    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }


}
