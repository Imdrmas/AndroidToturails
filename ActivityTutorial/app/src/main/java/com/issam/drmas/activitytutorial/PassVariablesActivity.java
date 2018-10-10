package com.issam.drmas.activitytutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassVariablesActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.issam.drmas.activitytutorial.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.issam.drmas.activitytutorial.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_variables);

        Button button = findViewById(R.id.button_activity2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    private void openActivity2() {
        EditText editText1 = findViewById(R.id.editText1);
        String text = editText1.getText().toString();

        EditText editText2 = findViewById(R.id.editText2);
        int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);

    }
}
