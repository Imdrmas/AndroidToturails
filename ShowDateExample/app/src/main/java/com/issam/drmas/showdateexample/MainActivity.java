package com.issam.drmas.showdateexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);

    }

    public void getDate(View view){
        Calendar c = Calendar.getInstance();
        Date today = c.getTime();

        c.add(Calendar.DATE, 3);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, 1);
        Date future = c.getTime();

        TextView TextView = findViewById(R.id.text_view_get_date);
        TextView.setText("Today: " + today + "\n" + "Future: " + future);
    }

    public void buttonSheet(View view){
        startActivity(new Intent(MainActivity.this, ButtonSheetActivity.class));
    }

    public void modelButtonSheet(View view){
       startActivity(new Intent(MainActivity.this, ModelButtomSheetActivity.class));

    }
}
