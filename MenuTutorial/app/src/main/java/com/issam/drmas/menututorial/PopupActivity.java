package com.issam.drmas.menututorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
    }

    public void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemPopup1:
                Toast.makeText(this, "Item Popup 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemPopup2:
                Toast.makeText(this, "Item Popup 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemPopup3:
                Toast.makeText(this, "Item Popup 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemPopup4:
                Toast.makeText(this, "Item Popup 4 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                    return false;
        }
    }
}
