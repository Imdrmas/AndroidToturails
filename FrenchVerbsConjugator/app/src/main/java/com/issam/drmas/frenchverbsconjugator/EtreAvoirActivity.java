package com.issam.drmas.frenchverbsconjugator;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionEtreAvoir;

public class EtreAvoirActivity extends AppCompatActivity {

    private QuestionEtreAvoir questionEtreAvoir = new QuestionEtreAvoir();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountEtreAvoir, txtIncorrectCountEtreAvoir;
    private TextView btnCounterQuestionEtreAvoir;

    private TextView txtQuestionViewEtreAvoir, txtAnswerViewEtreAvoir;
    private TextView txtOneEtreAvoir, txtTwoEtreAvoir, txtThreeEtreAvoir;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextEtreAvoir;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etre_avoir);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountEtreAvoir = findViewById(R.id.textCorrectCountEtreAvoir);
        txtIncorrectCountEtreAvoir = findViewById(R.id.textWrongCountEtreAvoir);
        btnCounterQuestionEtreAvoir = findViewById(R.id.counterQuestionEtreAvoir);

        textNextEtreAvoir = findViewById(R.id.textNextEtreAvoir);

        txtQuestionViewEtreAvoir = findViewById(R.id.textQuestionEtreAvoir);
        txtAnswerViewEtreAvoir = findViewById(R.id.textAnswerEtreAvoir);

        txtOneEtreAvoir = findViewById(R.id.txtOneEtreAvoir);
        txtTwoEtreAvoir = findViewById(R.id.txtTwoEtreAvoir);
        txtThreeEtreAvoir = findViewById(R.id.txtThreEtreAvoir);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewEtreAvoir);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountEtreAvoir.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountEtreAvoir.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionEtreAvoir.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionEtreAvoir.getLength()){

            txtQuestionViewEtreAvoir.setText(questionEtreAvoir.getTextQuestions(questionNumber));

            txtOneEtreAvoir.setText(questionEtreAvoir.getChoice(questionNumber, 1));
            txtTwoEtreAvoir.setText(questionEtreAvoir.getChoice(questionNumber, 2));
            txtThreeEtreAvoir.setText(questionEtreAvoir.getChoice(questionNumber, 3));

            answer = questionEtreAvoir.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionEtreAvoir.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionEtreAvoir.getLength());

            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            heightScore = sharedPreferences.getInt("heightScore", 0);

            if (heightScore >= score){

                txtResult.setText("Top Score "+heightScore);
            }
            else {
                txtResult.setText("New Score "+ score);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("heightScore", score);
                editor.commit();
            }

            Button btnContinue = (Button) dialog.findViewById(R.id.custom_result_continue);
            btnContinue.setText("Exercises");
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                    startActivity(new Intent(EtreAvoirActivity.this, MainActivity.class));
                }
            });

            Button btnCancel = (Button) dialog.findViewById(R.id.custom_result_cancel);
            btnCancel.setText("Top score");
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                    sendScoreToTop();

                }
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

            textNextEtreAvoir.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedEtreAvoir(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

            score++;

            txtQuestionViewEtreAvoir.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewEtreAvoir.setText(txtAnswerQuestion);

            correctCount();
            volumeCorrect.start();

            txtOneEtreAvoir.setEnabled(false);
            txtTwoEtreAvoir.setEnabled(false);
            txtThreeEtreAvoir.setEnabled(false);

            textNextEtreAvoir.setVisibility(View.VISIBLE);

        }
        else {

            txtQuestionViewEtreAvoir.setText(txtAnswerQuestion);

            txtQuestionViewEtreAvoir.setTextColor(Color.parseColor("#c0392b"));
            mAnswer.setTextColor(Color.parseColor("#c0392b"));

            txtAnswerViewEtreAvoir.setText("La réponse est : "+answer);

            wrongCount();
            volumeIncorrect.start();

            txtOneEtreAvoir.setEnabled(false);
            txtTwoEtreAvoir.setEnabled(false);
            txtThreeEtreAvoir.setEnabled(false);

            textNextEtreAvoir.setVisibility(View.VISIBLE);

        }

    }

    private void changeFunction(){

        switch (questionNumber){

            case 20:
                showResult();
                zeroCountDown();
                questionCounter = 21;
                break;

            case 40:
                showResult();
                zeroCountDown();
                questionCounter = 21;
                break;

            case 60:
                showResult();
                zeroCountDown();
                questionCounter = 21;
                break;

            case 80:
                showResult();
                zeroCountDown();
                questionCounter = 21;
                break;

        }
    }

    public void textNextEtreAvoir(View view){

        txtOneEtreAvoir.setEnabled(true);
        txtTwoEtreAvoir.setEnabled(true);
        txtThreeEtreAvoir.setEnabled(true);

        updateQuestions();

        txtAnswerViewEtreAvoir.setText("");
        txtQuestionViewEtreAvoir.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextEtreAvoir.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionEtreAvoir.getLength());

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        heightScore = sharedPreferences.getInt("heightScore", 0);

        if (heightScore >= score){

            txtResult.setText("Top Score "+heightScore);
        }
        else {
            txtResult.setText("New Score "+ score);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("heightScore", score);
            editor.commit();

            if (score == 100){
                txtResult.setText("Top");
            }

        }

        Button btnContinue = (Button) dialog.findViewById(R.id.custom_result_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtOneEtreAvoir.setEnabled(true);
                txtTwoEtreAvoir.setEnabled(true);
                txtThreeEtreAvoir.setEnabled(true);

                updateQuestions();

                txtAnswerViewEtreAvoir.setText("");
                txtQuestionViewEtreAvoir.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextEtreAvoir.setVisibility(View.INVISIBLE);
                dialog.dismiss();
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.custom_result_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                sendScoreToTop();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private void sendScoreToTop(){

        Intent intent = new Intent(EtreAvoirActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreEtreAvoir", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneEtreAvoir.setEnabled(false);
        txtTwoEtreAvoir.setEnabled(false);
        txtThreeEtreAvoir.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionEtreAvoir.setText("0");
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() >1){
            getFragmentManager().popBackStack();
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}
