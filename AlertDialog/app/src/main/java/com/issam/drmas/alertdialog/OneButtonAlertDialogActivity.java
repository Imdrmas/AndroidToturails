package com.issam.drmas.alertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OneButtonAlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_button_alert_dialog);
    }

    public void OpenAlertDialog(View view){
     ExampleDialog exampleDialog = new ExampleDialog();
     exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
