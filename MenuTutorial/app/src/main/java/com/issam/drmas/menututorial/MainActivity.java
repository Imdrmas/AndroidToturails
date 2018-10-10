package com.issam.drmas.menututorial;

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

    public void menuSubItemActivity(View view){
        startActivity(new Intent(MainActivity.this, MenuSubItemActivity.class));
    }
    public void menuPopupActivity(View view){
        startActivity(new Intent(MainActivity.this, PopupActivity.class));
    }
    public void menuContextActivity(View view){
        startActivity(new Intent(MainActivity.this, MenuContextActivity.class));
    }

    public void contextualActionModeActivity(View view){
        startActivity(new Intent(MainActivity.this, contextualActionModeActivity.class));
    }
}
