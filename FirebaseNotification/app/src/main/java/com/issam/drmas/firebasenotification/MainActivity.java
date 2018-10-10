package com.issam.drmas.firebasenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);

    }

    private void fillCountryList(){
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("afghanistan", R.drawable.ic_launcher_foreground));
        countryList.add(new CountryItem("albania", R.drawable.ic_launcher_foreground));
        countryList.add(new CountryItem("algeria", R.drawable.ic_launcher_foreground));
        countryList.add(new CountryItem("andorra", R.drawable.ic_launcher_foreground));
        countryList.add(new CountryItem("angola", R.drawable.ic_launcher_foreground));
    }
}
