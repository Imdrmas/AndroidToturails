package com.issam.drmas.alertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingEventAlertDialogActivity extends AppCompatActivity implements ExamplePassingDialog.ExampleDialogListener{
    private TextView textView;
    private Button button;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_event_alert_dialog);

        textView = findViewById(R.id.text_view_counter);
        button = findViewById(R.id.openPassingDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        ExamplePassingDialog examplePassingDialog = new ExamplePassingDialog();
        examplePassingDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void onYesClicked() {
        counter++;
        textView.setText("" +counter);
    }
}
