package com.issam.drmas.menututorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuSubItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sub_item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_sub_item, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.item1:
                Toast.makeText(this, "Item 1 seclected", Toast.LENGTH_SHORT).show();
                return true;
            case R.item2:
                Toast.makeText(this, "Item 2 seclected", Toast.LENGTH_SHORT).show();
                return true;
            case R.item3:
                Toast.makeText(this, "Item 3 seclected", Toast.LENGTH_SHORT).show();
                return true;
            case R.sub_item1:
                Toast.makeText(this, "Sub Item 1 seclected", Toast.LENGTH_SHORT).show();
                return true;
            case R.sub_item2:
                Toast.makeText(this, "Sub Item 2 seclected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                    return super.onOptionsItemSelected(item);

        }
    }

    */
}
