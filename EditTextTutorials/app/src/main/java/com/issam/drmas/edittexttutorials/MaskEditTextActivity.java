package com.issam.drmas.edittexttutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

public class MaskEditTextActivity extends AppCompatActivity {
    private MaskEditText editTextPhone;
    private MaskEditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_edit_text);

        editTextPhone = findViewById(R.id.edit_text_phone);
        editTextDate = findViewById(R.id.edit_text_date);
    }

    public void showText(View view){
        Toast.makeText(this, editTextPhone.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, editTextDate.getText(), Toast.LENGTH_LONG).show();
    }

    public void showRawText(View view){
        Toast.makeText(this, editTextPhone.getRawText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, editTextDate.getRawText(), Toast.LENGTH_LONG).show();

    }
}
