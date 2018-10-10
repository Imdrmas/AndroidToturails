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
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionsParticipe;

public class ParticipeActivity extends AppCompatActivity {

    private QuestionsParticipe questionsParticipe = new QuestionsParticipe();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountParticipe, txtIncorrectCountParticipe;
    private TextView btnCounterQuestionParticipe;

    private TextView txtQuestionViewParticipe, txtAnswerViewParticipe;
    private TextView txtOneParticipe, txtTwoParticipe, txtThreeParticipe;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextParticipe;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participe);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountParticipe = findViewById(R.id.textCorrectCountParticipe);
        txtIncorrectCountParticipe = findViewById(R.id.textWrongCountParticipe);
        btnCounterQuestionParticipe = findViewById(R.id.counterQuestionParticipe);

        textNextParticipe = findViewById(R.id.textNextParticipe);

        txtQuestionViewParticipe = findViewById(R.id.textQuestionParticipe);
        txtAnswerViewParticipe = findViewById(R.id.textAnswerParticipe);

        txtOneParticipe = findViewById(R.id.txtOneParticipe);
        txtTwoParticipe = findViewById(R.id.txtTwoParticipe);
        txtThreeParticipe = findViewById(R.id.txtThreParticipe);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewParticipe);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountParticipe.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountParticipe.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionParticipe.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionsParticipe.getLength()){

            txtQuestionViewParticipe.setText(questionsParticipe.getTextQuestions(questionNumber));

            txtOneParticipe.setText(questionsParticipe.getChoice(questionNumber, 1));
            txtTwoParticipe.setText(questionsParticipe.getChoice(questionNumber, 2));
            txtThreeParticipe.setText(questionsParticipe.getChoice(questionNumber, 3));

            answer = questionsParticipe.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionsParticipe.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionsParticipe.getLength());

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

                    startActivity(new Intent(ParticipeActivity.this, MainActivity.class));
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

            textNextParticipe.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedParticipe(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

            score++;

            txtQuestionViewParticipe.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewParticipe.setText(txtAnswerQuestion);

            correctCount();
            volumeCorrect.start();

            disabledButton();
            textNextParticipe.setVisibility(View.VISIBLE);

        }
        else {

            txtQuestionViewParticipe.setText(txtAnswerQuestion);

            txtQuestionViewParticipe.setTextColor(Color.parseColor("#c0392b"));
            mAnswer.setTextColor(Color.parseColor("#c0392b"));

            txtAnswerViewParticipe.setText("La réponse est : "+answer);

            wrongCount();
            volumeIncorrect.start();

            disabledButton();
            textNextParticipe.setVisibility(View.VISIBLE);

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

    public void textNextParticipe(View view){

        txtOneParticipe.setEnabled(true);
        txtTwoParticipe.setEnabled(true);
        txtThreeParticipe.setEnabled(true);

        updateQuestions();

        txtAnswerViewParticipe.setText("");
        txtQuestionViewParticipe.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextParticipe.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionsParticipe.getLength());

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

                txtOneParticipe.setEnabled(true);
                txtTwoParticipe.setEnabled(true);
                txtThreeParticipe.setEnabled(true);

                updateQuestions();

                txtAnswerViewParticipe.setText("");
                txtQuestionViewParticipe.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextParticipe.setVisibility(View.INVISIBLE);

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

        Intent intent = new Intent(ParticipeActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreParticipe", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneParticipe.setEnabled(false);
        txtTwoParticipe.setEnabled(false);
        txtThreeParticipe.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionParticipe.setText("0");
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
