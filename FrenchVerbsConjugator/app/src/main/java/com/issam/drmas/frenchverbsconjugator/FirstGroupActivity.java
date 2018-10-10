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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionsFirstGroup;

public class FirstGroupActivity extends AppCompatActivity {

    private QuestionsFirstGroup questionsFirstGroup = new QuestionsFirstGroup();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountFirst, txtIncorrectCountFirst;
    private TextView btnCounterQuestionFirst;

    private TextView txtQuestionViewFirst, txtAnswerViewFirst;
    private TextView txtOneFirst, txtTwoFirst, txtThreeFirst;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextFirst;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_group);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountFirst = findViewById(R.id.textCorrectCountFrist);
        txtIncorrectCountFirst = findViewById(R.id.textWrongCountFrist);
        btnCounterQuestionFirst = findViewById(R.id.counterQuestionFrist);

        textNextFirst = findViewById(R.id.textNextFrist);

        txtQuestionViewFirst = findViewById(R.id.textQuestionFrist);
        txtAnswerViewFirst = findViewById(R.id.textAnswerFrist);

        txtOneFirst = findViewById(R.id.txtOneFirst);
        txtTwoFirst = findViewById(R.id.txtTwoFirst);
        txtThreeFirst = findViewById(R.id.txtThreFirst);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewFirstGroup);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountFirst.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountFirst.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionFirst.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionsFirstGroup.getLength()){

            txtQuestionViewFirst.setText(questionsFirstGroup.getTextQuestions(questionNumber));

            txtOneFirst.setText(questionsFirstGroup.getChoice(questionNumber, 1));
            txtTwoFirst.setText(questionsFirstGroup.getChoice(questionNumber, 2));
            txtThreeFirst.setText(questionsFirstGroup.getChoice(questionNumber, 3));

            answer = questionsFirstGroup.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionsFirstGroup.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionsFirstGroup.getLength());

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
                    startActivity(new Intent(FirstGroupActivity.this, MainActivity.class));
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

            textNextFirst.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedFirst(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

         score++;

            txtQuestionViewFirst.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewFirst.setText(txtAnswerQuestion);

         correctCount();
         volumeCorrect.start();

         disabledButton();
         textNextFirst.setVisibility(View.VISIBLE);

        }
        else {

        txtQuestionViewFirst.setText(txtAnswerQuestion);

        txtQuestionViewFirst.setTextColor(Color.parseColor("#c0392b"));
        mAnswer.setTextColor(Color.parseColor("#c0392b"));

        txtAnswerViewFirst.setText("La réponse est : "+answer);

        wrongCount();
        volumeIncorrect.start();

        disabledButton();
        textNextFirst.setVisibility(View.VISIBLE);

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
                questionCounter = 21;
                break;

        }
    }

    public void textNextFirst(View view){

        txtOneFirst.setEnabled(true);
        txtTwoFirst.setEnabled(true);
        txtThreeFirst.setEnabled(true);

        updateQuestions();

        txtAnswerViewFirst.setText("");
        txtQuestionViewFirst.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextFirst.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionsFirstGroup.getLength());

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

                txtOneFirst.setEnabled(true);
                txtTwoFirst.setEnabled(true);
                txtThreeFirst.setEnabled(true);

                updateQuestions();

                txtAnswerViewFirst.setText("");
                txtQuestionViewFirst.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextFirst.setVisibility(View.INVISIBLE);
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

        Intent intent = new Intent(FirstGroupActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreFirstGroup", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneFirst.setEnabled(false);
        txtTwoFirst.setEnabled(false);
        txtThreeFirst.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionFirst.setText("0");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (getFragmentManager().getBackStackEntryCount() >1){
            getFragmentManager().popBackStack();
            finish();
        }
        else {
            super.onBackPressed();
        }

    }

}
