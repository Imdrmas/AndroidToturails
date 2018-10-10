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
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionsSecondGroup;

public class SecondGroupActivity extends AppCompatActivity {

    private QuestionsSecondGroup questionsSecondGroup = new QuestionsSecondGroup();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountSecond, txtIncorrectCountSecond;
    private TextView btnCounterQuestionSecond;

    private TextView txtQuestionViewSecond, txtAnswerViewSecond;
    private TextView txtOneSecond, txtTwoSecond, txtThreeSecond;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextSecond;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_group);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountSecond = findViewById(R.id.textCorrectCountSecond);
        txtIncorrectCountSecond = findViewById(R.id.textWrongCountSecond);
        btnCounterQuestionSecond= findViewById(R.id.counterQuestionSecond);

        textNextSecond = findViewById(R.id.textNextSecond);

        txtQuestionViewSecond = findViewById(R.id.textQuestionSecond);
        txtAnswerViewSecond = findViewById(R.id.textAnswerSecond);

        txtOneSecond = findViewById(R.id.txtOneSecond);
        txtTwoSecond = findViewById(R.id.txtTwoSecond);
        txtThreeSecond = findViewById(R.id.txtThreSecond);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewSecondGroup);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountSecond.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountSecond.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionSecond.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionsSecondGroup.getLength()){

            txtQuestionViewSecond.setText(questionsSecondGroup.getTextQuestions(questionNumber));

            txtOneSecond.setText(questionsSecondGroup.getChoice(questionNumber, 1));
            txtTwoSecond.setText(questionsSecondGroup.getChoice(questionNumber, 2));
            txtThreeSecond.setText(questionsSecondGroup.getChoice(questionNumber, 3));

            answer = questionsSecondGroup.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionsSecondGroup.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionsSecondGroup.getLength());

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
                    startActivity(new Intent(SecondGroupActivity.this, MainActivity.class));
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

            textNextSecond.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedSecond(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

            score++;

            txtQuestionViewSecond.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewSecond.setText(txtAnswerQuestion);

            correctCount();
            volumeCorrect.start();

             disabledButton();
            textNextSecond.setVisibility(View.VISIBLE);

        }
        else {

            txtQuestionViewSecond.setText(txtAnswerQuestion);

            txtQuestionViewSecond.setTextColor(Color.parseColor("#c0392b"));
            mAnswer.setTextColor(Color.parseColor("#c0392b"));

            txtAnswerViewSecond.setText("La réponse est : "+answer);

            wrongCount();
            volumeIncorrect.start();

            disabledButton();
            textNextSecond.setVisibility(View.VISIBLE);
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

    public void textNextSecond(View view){

        txtOneSecond.setEnabled(true);
        txtTwoSecond.setEnabled(true);
        txtThreeSecond.setEnabled(true);

        updateQuestions();

        txtAnswerViewSecond.setText("");
        txtQuestionViewSecond.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextSecond.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionsSecondGroup.getLength());

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

                txtOneSecond.setEnabled(true);
                txtTwoSecond.setEnabled(true);
                txtThreeSecond.setEnabled(true);

                updateQuestions();

                txtAnswerViewSecond.setText("");
                txtQuestionViewSecond.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextSecond.setVisibility(View.INVISIBLE);

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

        Intent intent = new Intent(SecondGroupActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreSecondGroup", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneSecond.setEnabled(false);
        txtTwoSecond.setEnabled(false);
        txtThreeSecond.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionSecond.setText("0");
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
