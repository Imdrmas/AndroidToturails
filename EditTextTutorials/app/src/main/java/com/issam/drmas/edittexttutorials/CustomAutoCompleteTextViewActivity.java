package com.issam.drmas.edittexttutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAutoCompleteTextViewActivity extends AppCompatActivity {
    private List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_auto_complete_text_view);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.text_active);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);
    }

    private void fillCountryList(){
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("afghanistan", R.drawable.afghanistan));
        countryList.add(new CountryItem("albania", R.drawable.albania));
        countryList.add(new CountryItem("algeria", R.drawable.algeria));
        countryList.add(new CountryItem("andorra", R.drawable.andorra));
        countryList.add(new CountryItem("angola", R.drawable.angola));
    }
}
