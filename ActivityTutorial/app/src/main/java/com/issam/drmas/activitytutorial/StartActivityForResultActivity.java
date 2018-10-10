package com.issam.drmas.activitytutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivityForResultActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        mTextViewResult = findViewById(R.id.text_view_result);
        mEditTextNumber1 = findViewById(R.id.edit_text_number1);
        mEditTextNumber2 = findViewById(R.id.edit_text_number2);

        Button button = findViewById(R.id.butt_open_reserve);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextNumber1.getText().toString().equals("")
                        || mEditTextNumber2.getText().toString().equals("")){
                    Toast.makeText(StartActivityForResultActivity.this, "Please insert numbers !", Toast.LENGTH_SHORT).show();
                }else {
                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    Intent intent = new Intent(StartActivityForResultActivity.this, ReservestartActivityForResultActivity.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int result = data.getIntExtra("result", 0);
                mTextViewResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED){
                mTextViewResult.setText("Nothing selected");
            }
        }
    }
}
