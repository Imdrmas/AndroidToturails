package com.issam.drmas.edittexttutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MultiAutoCompleteTextViewActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola"
    };

    private MultiAutoCompleteTextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_auto_complete_text_view);

        editText = findViewById(R.id.mActv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, COUNTRIES);
        editText.setAdapter(adapter);
        editText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    public void showInput(View view){
        String input = editText.getText().toString().trim();
        String[] singleInput = input.split("\\s*,\\s*");

        String toastText = "";
        for (int i = 0; i < singleInput.length; i++){
            toastText += "Item " + i + ": " + singleInput[i] + "\n";
        }

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }

}
