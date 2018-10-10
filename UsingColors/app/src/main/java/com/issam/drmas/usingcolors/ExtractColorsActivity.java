package com.issam.drmas.usingcolors;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExtractColorsActivity extends AppCompatActivity {
    private LinearLayout rootLayout;
    private TextView textViewTitle;
    private TextView textViewBody;
    private ImageView imageView;

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutesSwatch;

    private int swatchNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_colors);

        rootLayout = findViewById(R.id.rootLayout);
        textViewTitle = findViewById(R.id.text_view_title);
        textViewBody = findViewById(R.id.text_view_body);
        imageView = findViewById(R.id.image_view);

        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                vibrantSwatch = palette.getVibrantSwatch();
                lightVibrantSwatch = palette.getLightVibrantSwatch();
                darkVibrantSwatch = palette.getDarkVibrantSwatch();
                mutedSwatch = palette.getMutedSwatch();
                lightMutedSwatch = palette.getLightMutedSwatch();
                darkMutesSwatch = palette.getDarkMutedSwatch();
            }
        });

    }

    public void nextSwatch(View view){
        Palette.Swatch currentSwatch = null;

        switch (swatchNumber){
            case 0:
                currentSwatch = vibrantSwatch;
                textViewTitle.setText("Vibrant");
                break;
            case 1:
                currentSwatch = lightVibrantSwatch;
                textViewTitle.setText("Light Vibrant");
                break;
            case 2:
                currentSwatch = darkVibrantSwatch;
                textViewTitle.setText("Dark Vibrant");
                break;
            case 3:
                currentSwatch = mutedSwatch;
                textViewTitle.setText("Muted");
                break;
            case 4:
                currentSwatch = lightMutedSwatch;
                textViewTitle.setText("Light Muted");
                break;
            case 5:
                currentSwatch = darkMutesSwatch;
                textViewTitle.setText("Dark Muted");
                break;
        }

        if (currentSwatch != null){
            rootLayout.setBackgroundColor(currentSwatch.getRgb());
            textViewTitle.setTextColor(currentSwatch.getTitleTextColor());
            textViewBody.setTextColor(currentSwatch.getBodyTextColor());
        } else {
            rootLayout.setBackgroundColor(Color.WHITE);
            textViewTitle.setTextColor(Color.RED);
            textViewBody.setTextColor(Color.RED);
        }

        if (swatchNumber < 5){
            swatchNumber++;
        } else {
            swatchNumber = 0;
        }
    }
}
