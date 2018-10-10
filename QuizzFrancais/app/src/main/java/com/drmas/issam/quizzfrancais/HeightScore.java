package com.drmas.issam.quizzfrancais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class HeightScore extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    int scoreHistory;
    private TextView newScoreHistoryText, heightScoreHistoryText;

    int scoreReligion;
    private TextView newScoreReligionTxt, heightScoreReligionTxt;

    int scoreGeographic;
    private TextView newScoreGeographicTxt, heightScoreGeographicTxt;

    int scoreCapital;
    private TextView newScoreCapitaTxt, heightScoreCapitalTxt;

    int scoreSciences;
    private TextView newScoreSciencesTxt, heightScoreSciencesTxt;

    int scoreTelevision;
    private TextView newScoreTelevisionTxt, heightScoreTelevisionTxt;

    int scoreArt;
    private TextView newScoreArtTxt, heightScoreArtTxt;

    int scoreSport;
    private TextView newScoreSportTxt, heightScoreSportTxt;

    int scoreAnimal;
    private TextView newScoreAnimalTxt, heightScoreAnimalTxt;

    int scorePolitic;
    private TextView newScorePoliticTxt, heightScorePoliticTxt;

    int scoreCultural;
    private TextView newScoreCulturalTxt, heightScoreCulturalTxt;

    int scoreGeneral;
    private TextView newScoreGeneralTxt, heightScoreGeneralTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_height_score );

        Intent intentHistory = getIntent();
        scoreHistory = intentHistory.getIntExtra( "scoreHistory", (byte) 0 );

        newScoreHistoryText = (TextView) findViewById( R.id.newScoreHistoryView );
        heightScoreHistoryText = (TextView) findViewById( R.id.heigthScoreHistorycView);

        Intent intentReligion = getIntent();
        scoreReligion = intentReligion.getIntExtra( "scoreReligion", (byte) 0 );

        newScoreReligionTxt = (TextView) findViewById( R.id.newScoreReligionView );
        heightScoreReligionTxt = (TextView) findViewById( R.id.heigthScoreReligionView);

        Intent intentGeographic = getIntent();
        scoreGeographic = intentGeographic.getIntExtra( "scoreGeographic", (byte) 0 );

        newScoreGeographicTxt = (TextView) findViewById( R.id.newScoreGeographicView );
        heightScoreGeographicTxt = (TextView) findViewById( R.id.heigthScoreGeographicView);

        Intent intentCapital = getIntent();
        scoreCapital = intentCapital.getIntExtra( "scoreCapital", (byte) 0 );

        newScoreCapitaTxt = (TextView) findViewById( R.id.newScoreCapitalView );
        heightScoreCapitalTxt = (TextView) findViewById( R.id.heigthScoreCapitalView);

        Intent intentSciences = getIntent();
        scoreSciences = intentSciences.getIntExtra( "scoreSciences", (byte) 0 );

        newScoreSciencesTxt = (TextView) findViewById( R.id.newScoreSciencesView );
        heightScoreSciencesTxt = (TextView) findViewById( R.id.heigthScoreSciencesView);

        Intent intentTelevision = getIntent();
        scoreTelevision = intentTelevision.getIntExtra( "scoreTelevision", (byte) 0 );

        newScoreTelevisionTxt = (TextView) findViewById( R.id.newScoreTelevisionView );
        heightScoreTelevisionTxt = (TextView) findViewById( R.id.heigthScoreTelevisionView);

        Intent intentArt = getIntent();
        scoreArt= intentArt.getIntExtra( "scoreArt", (byte) 0 );

        newScoreArtTxt = (TextView) findViewById( R.id.newScoreArtView );
        heightScoreArtTxt = (TextView) findViewById( R.id.heigthScoreArtView);
        heightScoreArtTxt.setFocusable(false);

        Intent intentSport = getIntent();
        scoreSport = intentSport.getIntExtra( "scoreSport", (byte) 0 );

        newScoreSportTxt = (TextView) findViewById( R.id.newScoreSportView );
        heightScoreSportTxt = (TextView) findViewById( R.id.heigthScoreSportView);
        heightScoreSportTxt.setFocusable(false);

        Intent intentAnimal = getIntent();
        scoreAnimal = intentAnimal.getIntExtra( "scoreAnimal", (byte) 0 );

        newScoreAnimalTxt = (TextView) findViewById( R.id.newScoreAnimalView );
        heightScoreAnimalTxt = (TextView) findViewById( R.id.heigthScoreAnimalView);
        heightScoreAnimalTxt.setFocusable(false);

        Intent intentPolitic = getIntent();
        scorePolitic = intentPolitic.getIntExtra( "scorePolitic", (byte) 0 );

        newScorePoliticTxt = (TextView) findViewById( R.id.newScorePoliticView );
        heightScorePoliticTxt = (TextView) findViewById( R.id.heigthScorePoliticView );
        heightScorePoliticTxt.setFocusable(false);

        Intent intentCultural = getIntent();
        scoreCultural = intentCultural.getIntExtra( "scoreCultural", (byte) 0 );

        newScoreCulturalTxt = (TextView) findViewById( R.id.newScoreCulturalView );
        heightScoreCulturalTxt = (TextView) findViewById( R.id.heigthScoreCulturalView );
        heightScoreCulturalTxt.setFocusable(false);

        Intent intentGeneral = getIntent();
        scoreGeneral = intentGeneral.getIntExtra( "scoreGeneral", (byte) 0 );

        newScoreGeneralTxt = (TextView) findViewById( R.id.newScoreGeneralView );
        heightScoreGeneralTxt = (TextView) findViewById( R.id.heigthScoreGeneralView );
        heightScoreGeneralTxt.setFocusable(false);

        loadScoreHistory();
        loadScoreReligion();

        loadScoreGeographic();
        loadScoreCapital();

        loadScoreSciences();
        loadScoreTelevision();

        loadScoreArt();
        loadScoreSport();

        loadScoreAnimal();
        loadScorePolitic();

        loadScoreCultural();
        loadScoreGeneral();


    }//End Main

    /// All Functions
    private void loadScoreReligion() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreReligionTxt.setText(sharedPreferences.getString("scoreReligion",String.valueOf( scoreReligion+" / 100" )));

        newScoreReligionTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreReligionTxt.setTextColor( Color.WHITE );

        heightScoreReligionTxt.setEnabled( true );
        heightScoreReligionTxt.setText( sharedPreferences.getString( "playNowReligion", "Play now !" ));

        heightScoreReligionTxt.setTextColor( Color.WHITE );
        heightScoreReligionTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreReligion >= 1 && scoreReligion <= 19){

            heightScoreReligionTxt.setText( "Mal" );
            newScoreReligionTxt.setText( scoreReligion+" / 100" );
            heightScoreReligionTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreReligion >= 20 && scoreReligion <= 39){

            heightScoreReligionTxt.setText( "Bien" );
            newScoreReligionTxt.setText( scoreReligion+" / 100" );
            heightScoreReligionTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreReligion >= 40 && scoreReligion <= 59){

            heightScoreReligionTxt.setText( "Excellent" );
            newScoreReligionTxt.setText( scoreReligion+" / 100" );
            heightScoreReligionTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreReligion >= 60 && scoreReligion <= 79){

            heightScoreReligionTxt.setText( "Incroyable" );
            newScoreReligionTxt.setText( scoreReligion+" / 100" );
            heightScoreReligionTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreReligion >= 80 && scoreReligion <= 99){

            heightScoreReligionTxt.setText( "Formidable" );
            newScoreReligionTxt.setText( scoreReligion+" / 100" );
            heightScoreReligionTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreReligion == 100){

            heightScoreReligionTxt.setText( "Complet" );
            heightScoreReligionTxt.setTextColor( Color.YELLOW );
            newScoreReligionTxt.setText( "100 / 100");
            heightScoreReligionTxt.setBackgroundResource( R.drawable.finished_score_normal );


        }

    }

    private void loadScoreHistory(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreHistoryText.setText(sharedPreferences.getString("scoreHistory",String.valueOf( scoreHistory+" / 100" )));

        newScoreHistoryText.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreHistoryText.setTextColor( Color.WHITE );

        heightScoreHistoryText.setEnabled( true );
        heightScoreHistoryText.setText( sharedPreferences.getString( "playNowHistory", "Play now !" ));

        heightScoreHistoryText.setTextColor( Color.WHITE );
        heightScoreHistoryText.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreHistory >= 1 && scoreHistory <= 19){

            heightScoreHistoryText.setText( "Mal" );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreHistory >= 20 && scoreHistory <= 39){

            heightScoreHistoryText.setText( "Bien" );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreHistory >= 40 && scoreHistory <= 59){

            heightScoreHistoryText.setText( "Excellent" );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreHistory >= 60 && scoreHistory <= 79){

            heightScoreHistoryText.setText( "Incroyable" );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreHistory >= 80 && scoreHistory <= 99){

            heightScoreHistoryText.setText( "Formidable" );
            newScoreHistoryText.setText( scoreHistory+" / 100" );
            heightScoreHistoryText.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreHistory == 100){

            heightScoreHistoryText.setText( "Complet" );
            heightScoreHistoryText.setTextColor( Color.YELLOW );
            newScoreHistoryText.setText( "100 / 100");
            heightScoreHistoryText.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreGeographic(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreGeographicTxt.setText(sharedPreferences.getString("scoreGeographic",String.valueOf( scoreGeographic+" / 100" )));

        newScoreGeographicTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreGeographicTxt.setTextColor( Color.WHITE );

        heightScoreGeographicTxt.setEnabled( true );
        heightScoreGeographicTxt.setText( sharedPreferences.getString( "playNowGeographic", "Play now !" ));

        heightScoreGeographicTxt.setTextColor( Color.WHITE );
        heightScoreGeographicTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreGeographic >= 1 && scoreGeographic <= 19){

            heightScoreGeographicTxt.setText( "Mal" );
            newScoreGeographicTxt.setText( scoreGeographic+" / 100" );
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreGeographic >= 20 && scoreGeographic <= 39){

            heightScoreGeographicTxt.setText( "Bien" );
            newScoreGeographicTxt.setText( scoreGeographic+" / 100" );
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreGeographic >= 40 && scoreGeographic <= 59){

            heightScoreGeographicTxt.setText( "Excellent" );
            newScoreGeographicTxt.setText( scoreGeographic+" / 100" );
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreGeographic >= 60 && scoreGeographic <= 79){

            heightScoreGeographicTxt.setText( "Incroyable" );
            newScoreGeographicTxt.setText( scoreGeographic+" / 100" );
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreGeographic >= 80 && scoreGeographic <= 99){

            heightScoreGeographicTxt.setText( "Formidable" );
            newScoreGeographicTxt.setText( scoreGeographic+" / 100" );
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreGeographic == 100){

            heightScoreGeographicTxt.setText( "Complet" );
            heightScoreGeographicTxt.setTextColor( Color.YELLOW );
            newScoreGeographicTxt.setText( "100 / 100");
            heightScoreGeographicTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreCapital(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreCapitaTxt.setText(sharedPreferences.getString("scoreCapital",String.valueOf( scoreCapital+" / 100" )));

        newScoreCapitaTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreCapitaTxt.setTextColor( Color.WHITE );

        heightScoreCapitalTxt.setEnabled( true );
        heightScoreCapitalTxt.setText( sharedPreferences.getString( "playNowCapital", "Play now !" ));

        heightScoreCapitalTxt.setTextColor( Color.WHITE );
        heightScoreCapitalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreCapital >= 1 && scoreCapital <= 19){

            heightScoreCapitalTxt.setText( "Mal" );
            newScoreCapitaTxt.setText( scoreCapital+" / 100" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreCapital >= 20 && scoreCapital <= 39){

            heightScoreCapitalTxt.setText( "Bien" );
            newScoreCapitaTxt.setText( scoreCapital+" / 100" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreCapital >= 40 && scoreCapital <= 59){

            heightScoreCapitalTxt.setText( "Excellent" );
            newScoreCapitaTxt.setText( scoreCapital+" / 100" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreCapital >= 60 && scoreCapital <= 79){

            heightScoreCapitalTxt.setText( "Incroyable" );
            newScoreCapitaTxt.setText( scoreCapital+" / 100" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreCapital >= 80 && scoreCapital <= 99){

            heightScoreCapitalTxt.setText( "Formidable" );
            newScoreCapitaTxt.setText( scoreCapital+" / 100" );
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreCapital == 100){

            heightScoreCapitalTxt.setText( "Complet" );
            heightScoreCapitalTxt.setTextColor( Color.YELLOW );
            newScoreCapitaTxt.setText( "100 / 100");
            heightScoreCapitalTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }

    }

    private void loadScoreSciences(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreSciencesTxt.setText(sharedPreferences.getString("scoreSciences",String.valueOf( scoreSciences+" / 100" )));

        newScoreSciencesTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreSciencesTxt.setTextColor( Color.WHITE );

        heightScoreSciencesTxt.setEnabled( true );
        heightScoreSciencesTxt.setText( sharedPreferences.getString( "playNowSciences", "Play now !" ));

        heightScoreSciencesTxt.setTextColor( Color.WHITE );
        heightScoreSciencesTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreSciences >= 1 && scoreSciences <= 19){

            heightScoreSciencesTxt.setText( "Mal" );
            newScoreSciencesTxt.setText( scoreSciences+" / 100" );
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreSciences >= 20 && scoreSciences <= 39){

            heightScoreSciencesTxt.setText( "Bien" );
            newScoreSciencesTxt.setText( scoreSciences+" / 100" );
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreSciences >= 40 && scoreSciences <= 59){

            heightScoreSciencesTxt.setText( "Excellent" );
            newScoreSciencesTxt.setText( scoreSciences+" / 100" );
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreSciences >= 60 && scoreSciences <= 79){

            heightScoreSciencesTxt.setText( "Incroyable" );
            newScoreSciencesTxt.setText( scoreSciences+" / 100" );
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreSciences >= 80 && scoreSciences <= 99){

            heightScoreSciencesTxt.setText( "Formidable" );
            newScoreSciencesTxt.setText( scoreSciences+" / 100" );
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreSciences == 100){

            heightScoreSciencesTxt.setText( "Complet" );
            heightScoreSciencesTxt.setTextColor( Color.YELLOW );
            newScoreSciencesTxt.setText( "100 / 100");
            heightScoreSciencesTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreTelevision(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreTelevisionTxt.setText(sharedPreferences.getString("scoreTelevision",String.valueOf( scoreTelevision+" / 100" )));

        newScoreTelevisionTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreTelevisionTxt.setTextColor( Color.WHITE );

        heightScoreTelevisionTxt.setEnabled( true );
        heightScoreTelevisionTxt.setText( sharedPreferences.getString( "playNowTelevision", "Play now !" ));

        heightScoreTelevisionTxt.setTextColor( Color.WHITE );
        heightScoreTelevisionTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreTelevision >= 1 && scoreTelevision <= 100){

            heightScoreTelevisionTxt.setFocusable(true);
            heightScoreTelevisionTxt.setFocusableInTouchMode(true);
            heightScoreTelevisionTxt.requestFocus();

        }

        if (scoreTelevision >= 1 && scoreTelevision <= 19){

            heightScoreTelevisionTxt.setText( "Mal" );
            newScoreTelevisionTxt.setText( scoreTelevision+" / 100" );
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreTelevision >= 20 && scoreTelevision <= 39){

            heightScoreTelevisionTxt.setText( "Bien" );
            newScoreTelevisionTxt.setText( scoreTelevision+" / 100" );
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreTelevision >= 40 && scoreTelevision <= 59){

            heightScoreTelevisionTxt.setText( "Génial" );
            newScoreTelevisionTxt.setText( scoreTelevision+" / 100" );
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreTelevision >= 60 && scoreTelevision <= 79){

            heightScoreTelevisionTxt.setText( "Incroyable" );
            newScoreTelevisionTxt.setText( scoreTelevision+" / 100" );
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreTelevision >= 80 && scoreTelevision <= 99){

            heightScoreTelevisionTxt.setText( "Formidable" );
            newScoreTelevisionTxt.setText( scoreTelevision+" / 100" );
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreTelevision == 100){

            heightScoreTelevisionTxt.setText( "Complet" );
            heightScoreTelevisionTxt.setTextColor( Color.YELLOW );
            newScoreTelevisionTxt.setText( "100 / 100");
            heightScoreTelevisionTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreArt(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreArtTxt.setText(sharedPreferences.getString("scoreArt",String.valueOf( scoreArt+" / 100" )));

        newScoreArtTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreArtTxt.setTextColor( Color.WHITE );


        heightScoreArtTxt.setEnabled( true );
        heightScoreArtTxt.setText( sharedPreferences.getString( "playNowArt", "Play now !" ));

        heightScoreArtTxt.setTextColor( Color.WHITE );
        heightScoreArtTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreArt >= 1 && scoreArt <= 19){

            heightScoreArtTxt.setText( "Mal" );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreArt >= 20 && scoreArt <= 39){

            heightScoreArtTxt.setText( "Bien" );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreArt >= 40 && scoreArt <= 59){

            heightScoreArtTxt.setText( "Excellent" );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreArt >= 60 && scoreArt <= 79){

            heightScoreArtTxt.setText( "Incroyable" );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreArt >= 80 && scoreArt <= 99){

            heightScoreArtTxt.setText( "Formidable" );
            newScoreArtTxt.setText(scoreArt+" / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreArt == 100){

            heightScoreArtTxt.setText( "Complet" );
            heightScoreArtTxt.setTextColor( Color.YELLOW );
            newScoreArtTxt.setText( "100 / 100");
            heightScoreArtTxt.setBackgroundResource( R.drawable.finished_score_normal );

        }
    }

    private void loadScoreSport(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreSportTxt.setText(sharedPreferences.getString("scoreSport",String.valueOf( scoreSport+" / 100" )));

        newScoreSportTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreSportTxt.setTextColor( Color.WHITE );

        heightScoreSportTxt.setEnabled( true );
        heightScoreSportTxt.setText( sharedPreferences.getString( "playNowSport", "Play now !" ));

        heightScoreSportTxt.setTextColor( Color.WHITE );
        heightScoreSportTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreSport >= 1 && scoreSport <= 100){

            heightScoreSportTxt.setFocusable(true);
            heightScoreSportTxt.setFocusableInTouchMode(true);
            heightScoreSportTxt.requestFocus();

        }

        if (scoreSport >= 1 && scoreSport <= 19){

            heightScoreSportTxt.setText( "Mal" );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreSport >= 20 && scoreSport <= 39){

            heightScoreSportTxt.setText( "Bien" );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreSport >= 40 && scoreSport <= 59){

            heightScoreSportTxt.setText( "Excellent" );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreSport >= 60 && scoreSport <= 79){

            heightScoreSportTxt.setText( "Incroyable" );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreSport >= 80 && scoreSport <= 99){

            heightScoreSportTxt.setText( "Formidable" );
            newScoreSportTxt.setText(scoreSport+" / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreSport == 100){

            heightScoreSportTxt.setText( "Complet" );
            heightScoreSportTxt.setTextColor( Color.YELLOW );
            newScoreSportTxt.setText( "100 / 100");
            heightScoreSportTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreAnimal(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreAnimalTxt.setText(sharedPreferences.getString("scoreAnimal",String.valueOf( scoreAnimal+" / 100" )));

        newScoreAnimalTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreAnimalTxt.setTextColor( Color.WHITE );

        heightScoreAnimalTxt.setEnabled( true );
        heightScoreAnimalTxt.setText( sharedPreferences.getString( "playNowAnimal", "Play now !" ));

        heightScoreAnimalTxt.setTextColor( Color.WHITE );
        heightScoreAnimalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreAnimal >= 1 && scoreAnimal <= 19){

            heightScoreAnimalTxt.setText( "Mal" );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreAnimal >= 20 && scoreAnimal <= 39){

            heightScoreAnimalTxt.setText( "Bien" );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreAnimal >= 40 && scoreAnimal <= 59){

            heightScoreAnimalTxt.setText( "Excellent" );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreAnimal >= 60 && scoreAnimal <= 79){

            heightScoreAnimalTxt.setText( "Incroyable" );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreAnimal >= 80 && scoreAnimal <= 99){

            heightScoreAnimalTxt.setText( "Formidable" );
            newScoreAnimalTxt.setText(scoreAnimal+" / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreAnimal == 100){

            heightScoreAnimalTxt.setText( "Complet" );
            heightScoreAnimalTxt.setTextColor( Color.YELLOW );
            newScoreAnimalTxt.setText( "100 / 100");
            heightScoreAnimalTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScorePolitic(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScorePoliticTxt.setText(sharedPreferences.getString("scorePolitic",String.valueOf( scorePolitic+" / 100" )));
        heightScorePoliticTxt.setText( sharedPreferences.getString( "playNowPolitic", "Play now !" ));

        newScorePoliticTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScorePoliticTxt.setTextColor( Color.WHITE );

        heightScorePoliticTxt.setEnabled( true );

        heightScorePoliticTxt.setTextColor( Color.WHITE );
        heightScorePoliticTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scorePolitic >= 1 && scorePolitic <= 19){

            heightScorePoliticTxt.setText( "Mal" );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scorePolitic >= 20 && scorePolitic <= 39){

            heightScorePoliticTxt.setText( "Bien" );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scorePolitic >= 40 && scorePolitic <= 59){

            heightScorePoliticTxt.setText( "Excellent" );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scorePolitic >= 60 && scorePolitic <= 79){

            heightScorePoliticTxt.setText( "Incroyable" );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scorePolitic >= 80 && scorePolitic <= 99){

            heightScorePoliticTxt.setText( "Formidable" );
            newScorePoliticTxt.setText(scorePolitic+" / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scorePolitic == 100){

            heightScorePoliticTxt.setText( "Complet" );
            heightScorePoliticTxt.setTextColor( Color.YELLOW );
            newScorePoliticTxt.setText( "100 / 100");
            heightScorePoliticTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreCultural(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreCulturalTxt.setText(sharedPreferences.getString("scoreCultural",String.valueOf( scoreCultural+" / 100" )));
        heightScoreCulturalTxt.setText( sharedPreferences.getString( "playNowCultural", "Play now !" ));

        newScoreCulturalTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreCulturalTxt.setTextColor( Color.WHITE );

        heightScoreCulturalTxt.setEnabled( true );

        heightScoreCulturalTxt.setTextColor( Color.WHITE );
        heightScoreCulturalTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreCultural >= 1 && scoreCultural <= 19){

            heightScoreCulturalTxt.setText( "Mal" );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreCultural >= 20 && scoreCultural <= 39){

            heightScoreCulturalTxt.setText( "Bien" );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreCultural >= 40 && scoreCultural <= 59){

            heightScoreCulturalTxt.setText( "Excellent" );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreCultural >= 60 && scoreCultural <= 79){

            heightScoreCulturalTxt.setText( "Incroyable" );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreCultural >= 80 && scoreCultural <= 99){

            heightScoreCulturalTxt.setText( "Formidable" );
            newScoreCulturalTxt.setText(scoreCultural+" / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreCultural == 100){

            heightScoreCulturalTxt.setText( "Complet" );
            heightScoreCulturalTxt.setTextColor( Color.YELLOW );
            newScoreCulturalTxt.setText( "100 / 100");
            heightScoreCulturalTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    private void loadScoreGeneral(){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        newScoreGeneralTxt.setText(sharedPreferences.getString("scoreGeneral",String.valueOf( scoreGeneral+" / 100" )));
        heightScoreGeneralTxt.setText( sharedPreferences.getString( "playNowGeneral", "Play now !" ));

        newScoreGeneralTxt.setBackgroundResource(R.drawable.custom_start_btn );
        newScoreGeneralTxt.setTextColor( Color.WHITE );

        heightScoreGeneralTxt.setEnabled( true );

        heightScoreGeneralTxt.setTextColor( Color.WHITE );
        heightScoreGeneralTxt.setBackgroundResource( R.drawable.not_stared_score_normal );

        if (scoreGeneral >= 1 && scoreGeneral <= 100){

            heightScoreGeneralTxt.setFocusable(true);
            heightScoreGeneralTxt.setFocusableInTouchMode(true);
            heightScoreGeneralTxt.requestFocus();

        }
        if (scoreGeneral >= 1 && scoreGeneral <= 19){

            heightScoreGeneralTxt.setText( "Mal" );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.custom_cancel_btn);

        }
        else if (scoreGeneral >= 20 && scoreGeneral <= 39){

            heightScoreGeneralTxt.setText( "Bien" );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.medium_score_normal );

        }
        else if (scoreGeneral >= 40 && scoreGeneral <= 59){

            heightScoreGeneralTxt.setText( "Excellent" );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.height_score_normal );

        }
        else if (scoreGeneral >= 60 && scoreGeneral <= 79){

            heightScoreGeneralTxt.setText( "Incroyable" );
            newScoreGeneralTxt.setText(scoreGeneral+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.good_score_normal );

        }
        else if (scoreGeneral >= 80 && scoreGeneral <= 99){

            heightScoreGeneralTxt.setText( "Formidable" );
            newScoreGeneralTxt.setText(scoreCultural+" / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.awsome_score_normal );

        }
        else if (scoreGeneral == 100){

            heightScoreGeneralTxt.setText( "Complet" );
            heightScoreGeneralTxt.setTextColor( Color.YELLOW );
            newScoreGeneralTxt.setText( "100 / 100");
            heightScoreGeneralTxt.setBackgroundResource( R.drawable.finished_score_normal );
        }
    }

    /// Save data with Reference
    private void savePreferences(String key, String value) {

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){

        savePreferences( "scoreReligion", newScoreReligionTxt.getText().toString() );
        savePreferences( "playNowReligion", heightScoreReligionTxt.getText().toString());

        savePreferences( "scoreHistory", newScoreHistoryText.getText().toString());
        savePreferences( "playNowHistory", heightScoreHistoryText.getText().toString());

        savePreferences( "scoreGeographic", newScoreGeographicTxt.getText().toString());
        savePreferences( "playNowGeographic", heightScoreGeographicTxt.getText().toString());

        savePreferences( "scoreCapital", newScoreCapitaTxt.getText().toString());
        savePreferences( "playNowCapital", heightScoreCapitalTxt.getText().toString());

        savePreferences( "scoreSciences", newScoreSciencesTxt.getText().toString());
        savePreferences( "playNowSciences", heightScoreSciencesTxt.getText().toString());

        savePreferences( "scoreTelevision", newScoreTelevisionTxt.getText().toString());
        savePreferences( "playNowTelevision", heightScoreTelevisionTxt.getText().toString());

        savePreferences( "scoreArt", newScoreArtTxt.getText().toString());
        savePreferences( "playNowArt", heightScoreArtTxt.getText().toString());

        savePreferences( "scoreSport", newScoreSportTxt.getText().toString());
        savePreferences( "playNowSport", heightScoreSportTxt.getText().toString());

        savePreferences( "scoreAnimal", newScoreAnimalTxt.getText().toString());
        savePreferences( "playNowAnimal", heightScoreAnimalTxt.getText().toString());

        savePreferences( "scorePolitic", newScorePoliticTxt.getText().toString());
        savePreferences( "playNowPolitic", heightScorePoliticTxt.getText().toString());

        savePreferences( "scoreCultural", newScoreCulturalTxt.getText().toString());
        savePreferences( "playNowCultural", heightScoreCulturalTxt.getText().toString());

        savePreferences("scoreGeneral", newScoreGeneralTxt.getText().toString());
        savePreferences( "playNowGeneral", heightScoreGeneralTxt.getText().toString());

    }

    /// Stat Activity
    public void mainActivity(){

        Intent mainIntent = new Intent( HeightScore.this, MainActivity.class );
        startActivity( mainIntent );
    }

    public void startNewReligion(View view){

        Intent intent = new Intent( HeightScore.this, ReligionActivity.class );
        startActivity( intent );
    }

    public void startNewHistory(View view){

        Intent intent = new Intent( HeightScore.this, HistoireActivity.class );
        startActivity( intent );

    }

    public void startNewCapital(View view){

        Intent intent = new Intent( HeightScore.this, CapitalActivity.class );
        startActivity( intent );

    }

    public void startNewGeographic(View view){

        Intent intent = new Intent( HeightScore.this, GeographicActivity.class );
        startActivity( intent );

    }

    public void startNewSciences(View view){

        Intent intent = new Intent( HeightScore.this, SciencesActivity.class );
        startActivity( intent );

    }

    public void startNewTelevision(View view){

        Intent intent = new Intent( HeightScore.this, TelevisionActivity.class );
        startActivity( intent );

    }

    public void startNewArt(View view){

        Intent intent = new Intent( HeightScore.this, ArtActivity.class );
        startActivity( intent );

    }

    public void startNewSport(View view){

        Intent intent = new Intent( HeightScore.this, SportActivity.class );
        startActivity( intent );

    }

    public void startNewAnimal(View view){

        Intent intent = new Intent( HeightScore.this, AnimalActivity.class );
        startActivity( intent );
    }

    public void startNewPolitic(View view) {

        Intent intent = new Intent( HeightScore.this, PoliticActivity.class );
        startActivity( intent );
    }

    public void startNowCultural(View view){

        Intent intent = new Intent( HeightScore.this, CulturalActivity.class );
        startActivity( intent );

    }

    public void startNewGeneral(View view){

        Intent intent = new Intent( HeightScore.this, GeneralActivity.class );
        startActivity( intent );

    }

    public void goToMainActivity(View view){
        Intent mainIntent = new Intent( HeightScore.this, MainActivity.class );
        startActivity( mainIntent );
    }


    /// Main Function
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        saveData();

        mainActivity();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }


}
