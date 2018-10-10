package com.issam.drmas.alertdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotDismissAlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_dismiss_alert_dialog);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Tile")
                .setMessage("Example Message")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .show();

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotDismissAlertDialogActivity.this, "Not closing", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
