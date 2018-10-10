package com.issam.drmas.showdateexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModelButtomSheetActivity extends AppCompatActivity implements ExampleBottomSheetDialog.BottomSheetListener{
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_buttom_sheet);

        mTextView = findViewById(R.id.text_view_button_clicked);

        Button buttonOpenBottomSheet = findViewById(R.id.button_open_bottom_sheet);
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleBottomSheetDialog bootomSheet = new ExampleBottomSheetDialog();
                bootomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });
    }


    @Override
    public void onButtonClicked(String text) {
        mTextView.setText(text);
    }
}
