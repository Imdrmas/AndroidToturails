package com.issam.drmas.fragmentsdialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void valuesBetweenFragment(View view){
        startActivity(new Intent(Main2Activity.this, MainActivity.class));
    }
    public void fragmentCommunication(View view){
        startActivity(new Intent(Main2Activity.this, CommunicationActivity.class));
    }

    public void fragmentSendingInformation(View view){
        startActivity(new Intent(Main2Activity.this, SendingInformationActivity.class));
    }
    public void fragmentAnimationCommunicate(View view){
        startActivity(new Intent(Main2Activity.this, AnimationCommunicateActivity.class));
    }
}
