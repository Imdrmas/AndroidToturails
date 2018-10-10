package com.issam.drmas.usingcolors;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;
    private Button buttonGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
        buttonGenerate = findViewById(R.id.random_color);
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                layout.setBackgroundColor(color);
            }
        });
    }

    public void ExtractColors(View view){
     startActivity(new Intent(MainActivity.this, ExtractColorsActivity.class));
    }

    public void ColorSeekBarLibrary(View view){
        startActivity(new Intent(MainActivity.this, ColorSeekBarLibraryActivity.class));
    }
}
