package com.issam.drmas.frenchverbsconjugator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class TopScoreActivity extends AppCompatActivity {

    private Button btnFirstGroupScore;
    int scoreFirstGroup;
    
    int scoreSecondGroup;
    private Button btnSecondGroupScore;

    int scoreThreeGroup;
    private Button btnThreeGroupScore;

    int scoreEtreAvoir;
    private Button btnEtreAvoirScore;

    int scoreGroup;
    private Button btnScoreGroup;

    int scoreParticipe;
    private Button btnScoreParticipe;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_score);

        Toolbar ToolbarTopScore = findViewById(R.id.ToolbarTopScore);
        setSupportActionBar(ToolbarTopScore);
        getSupportActionBar().setTitle(R.string.top_score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ToolbarTopScore.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TopScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intentFirstGroup = getIntent();
        scoreFirstGroup = intentFirstGroup.getIntExtra("scoreFirstGroup",  0);
        btnFirstGroupScore = findViewById(R.id.btnFirstGroupScore);
        btnFirstGroupScore.setText(scoreFirstGroup+"");

        Intent intentSecondGroup = getIntent();
        scoreSecondGroup = intentSecondGroup.getIntExtra("scoreSecondGroup",  0);
        btnSecondGroupScore = findViewById(R.id.btnSecondGroupScore);
        btnSecondGroupScore.setText(scoreSecondGroup+"");

        Intent intentThreeGroup = getIntent();
        scoreThreeGroup = intentThreeGroup.getIntExtra("scoreThreeGroup",  0);
        btnThreeGroupScore = findViewById(R.id.btnThreeGroupScore);
        btnThreeGroupScore.setText(scoreThreeGroup+"");

        Intent intentEtreAvoir = getIntent();
        scoreEtreAvoir = intentEtreAvoir.getIntExtra("scoreEtreAvoir",  0);
        btnEtreAvoirScore = findViewById(R.id.btnEtreAvoirScore);
        btnEtreAvoirScore.setText(scoreEtreAvoir+"");

        Intent intentParticipe = getIntent();
        scoreParticipe = intentParticipe.getIntExtra("scoreParticipe", 0);
        btnScoreParticipe = findViewById(R.id.btnScoreParticipe);
        btnScoreParticipe.setText(scoreParticipe+"");

        Intent intentGroup = getIntent();
        scoreGroup = intentGroup.getIntExtra("scoreGroup",  0);
        btnScoreGroup = findViewById(R.id.btnScoreGroup);
        btnScoreGroup.setText(scoreGroup+"");

        loadScoreFirstGroup();
        loadScoreSecondGroup();
        loadScoreThreeGroup();

        loadScoreEtreAvoir();
        loadScoreGroup();
        loadScoreParticipe();

        adView = findViewById(R.id.adViewTopScore);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    private void loadScoreParticipe(){

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int heightScoreParticipe = sharedPreferences.getInt("heightScoreParticipe", 0);

        if (heightScoreParticipe >= scoreParticipe){

            btnScoreParticipe.setText(""+heightScoreParticipe);
        }
        else {

            btnScoreParticipe.setText(""+ scoreParticipe);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreParticipe", scoreParticipe);
            editor.commit();

            if (scoreParticipe == 100){
                btnScoreParticipe.setText("Top");
            }
        }
    }

    private void loadScoreGroup() {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int heightScoreGroup = sharedPreferences.getInt("heightScoreGroup", 0);

        if (heightScoreGroup >= scoreGroup){

            btnScoreGroup.setText(""+heightScoreGroup);
        }
        else {
            btnScoreGroup.setText(""+ scoreGroup);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreGroup", scoreGroup);
            editor.commit();

            if (scoreGroup == 100){
                btnScoreGroup.setText("Top");
            }

        }
    }

    private void loadScoreEtreAvoir() {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int heightScoreEtreAvoir= sharedPreferences.getInt("heightScoreEtreAvoir", 0);

        if (heightScoreEtreAvoir >= scoreEtreAvoir){

            btnEtreAvoirScore.setText(""+heightScoreEtreAvoir);
        }
        else {

            btnEtreAvoirScore.setText(""+ scoreEtreAvoir);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreEtreAvoir", scoreEtreAvoir);
            editor.commit();

            if (scoreEtreAvoir == 100){
                btnEtreAvoirScore.setText("Top");
            }
        }
    }

    private void loadScoreThreeGroup() {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int heightScoreThreeGroup = sharedPreferences.getInt("heightScoreThreeGroup", 0);

        if (heightScoreThreeGroup >= scoreThreeGroup){

            btnThreeGroupScore.setText(""+heightScoreThreeGroup);
        }
        else {

            btnThreeGroupScore.setText(""+ scoreThreeGroup);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreThreeGroup", scoreThreeGroup);
            editor.commit();

            if (scoreThreeGroup == 100){
                btnThreeGroupScore.setText("Top");
            }
        }

    }

    private void loadScoreSecondGroup() {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
       int heightScoreSecondGroup = sharedPreferences.getInt("heightScoreSecondGroup", 0);

        if (heightScoreSecondGroup >= scoreSecondGroup){

            btnSecondGroupScore.setText(""+heightScoreSecondGroup);
        }
        else {
            btnSecondGroupScore.setText(""+ scoreSecondGroup);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreSecondGroup", scoreSecondGroup);
            editor.commit();

            if (scoreSecondGroup == 100){
                btnSecondGroupScore.setText("Top");
            }

        }
    }

    private void loadScoreFirstGroup(){

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int heightScoreScoreFirstGroup = sharedPreferences.getInt("heightScoreScoreFirstGroup", 0);

        if (heightScoreScoreFirstGroup >= scoreFirstGroup){

            btnFirstGroupScore.setText(""+heightScoreScoreFirstGroup);
        }
        else {
            btnFirstGroupScore.setText(""+ scoreFirstGroup);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScoreScoreFirstGroup", scoreFirstGroup);
            editor.commit();

            if (scoreFirstGroup == 100){
                btnFirstGroupScore.setText("Top");
            }

        }

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(TopScoreActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void firstGroupClickedTop(View view){
       startActivity(new Intent(TopScoreActivity.this, FirstGroupActivity.class));
       finish();
    }
    public void secondGroupClickedTop(View view){
        startActivity(new Intent(TopScoreActivity.this, SecondGroupActivity.class));
        finish();
    }
    public void threeGroupClickedTop(View view){
        startActivity(new Intent(TopScoreActivity.this, ThreeGroupActivity.class));
        finish();
    }
    public void etreAvoirClickedTop(View view){
        startActivity(new Intent(TopScoreActivity.this, EtreAvoirActivity.class));
        finish();
    }
    public void groupClickedTop(View view){
        startActivity(new Intent(TopScoreActivity.this, GroupActivity.class));
        finish();
    }
    public void participeClickedTop(View view){
        startActivity(new Intent(TopScoreActivity.this, ParticipeActivity.class));
        finish();
    }



}
