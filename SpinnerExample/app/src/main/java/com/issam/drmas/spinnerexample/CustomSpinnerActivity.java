package com.issam.drmas.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomSpinnerActivity extends AppCompatActivity {
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);

        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner_countries);

        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickItem.getCountryName();
                Toast.makeText(CustomSpinnerActivity.this,  clickedCountryName+ " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem("India", R.drawable.flag_of_india));
        mCountryList.add(new CountryItem("China", R.drawable.china_flag));
        mCountryList.add(new CountryItem("USA", R.drawable.usa_flag));
        mCountryList.add(new CountryItem("Germany", R.drawable.flag_germany));
    }


}
