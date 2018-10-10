package com.issam.drmas.edittexttutorials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void editTextInput(View view){
        startActivity(new Intent(MainActivity.this, EditTextInputActivity.class));
    }

    public void floatingLabelEditText(View view){
        startActivity(new Intent(MainActivity.this, FloatingLabelEditTextActivity.class));
    }

    public void hideKeyboard(View view){
        startActivity(new Intent(MainActivity.this, HideKeyboardActivity.class));
    }

    public void maskEditText(View view){
        startActivity(new Intent(MainActivity.this, MaskEditTextActivity.class));
    }

    public void AutoCompleteTextView(View view){
        startActivity(new Intent(MainActivity.this, AutoCompleteTextViewActivity.class));
    }
    public void MultiAutoCompleteTextView(View view){
        startActivity(new Intent(MainActivity.this, MaskEditTextActivity.class));
    }

    public void CustomAutoCompleteTextView(View view){
        startActivity(new Intent(MainActivity.this, CustomAutoCompleteTextViewActivity.class));
    }
}
