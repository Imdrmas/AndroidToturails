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
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionsThreeGroup;

public class ThreeGroupActivity extends AppCompatActivity {

    private QuestionsThreeGroup questionsThreeGroup = new QuestionsThreeGroup();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountThree, txtIncorrectCountThree;
    private TextView btnCounterQuestionThree;

    private TextView txtQuestionViewThree, txtAnswerViewThree;
    private TextView txtOneThree, txtTwoThree, txtThreeThree;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextThree;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_group);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountThree = findViewById(R.id.textCorrectCountThree);
        txtIncorrectCountThree = findViewById(R.id.textWrongCountThree);
        btnCounterQuestionThree = findViewById(R.id.counterQuestionThree);

        textNextThree = findViewById(R.id.textNextThree);

        txtQuestionViewThree = findViewById(R.id.textQuestionThree);
        txtAnswerViewThree = findViewById(R.id.textAnswerThree);

        txtOneThree = findViewById(R.id.txtOneThree);
        txtTwoThree = findViewById(R.id.txtTwoThree);
        txtThreeThree = findViewById(R.id.txtThreThree);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewThreeGroup);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountThree.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountThree.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionThree.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionsThreeGroup.getLength()){

            txtQuestionViewThree.setText(questionsThreeGroup.getTextQuestions(questionNumber));

            txtOneThree.setText(questionsThreeGroup.getChoice(questionNumber, 1));
            txtTwoThree.setText(questionsThreeGroup.getChoice(questionNumber, 2));
            txtThreeThree.setText(questionsThreeGroup.getChoice(questionNumber, 3));

            answer = questionsThreeGroup.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionsThreeGroup.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionsThreeGroup.getLength());

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
                    startActivity(new Intent(ThreeGroupActivity.this, MainActivity.class));
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

            textNextThree.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedThree(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

            score++;

            txtQuestionViewThree.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewThree.setText(txtAnswerQuestion);

            correctCount();
            volumeCorrect.start();

            txtOneThree.setEnabled(false);
            txtTwoThree.setEnabled(false);
            txtThreeThree.setEnabled(false);

            textNextThree.setVisibility(View.VISIBLE);

        }
        else {

            txtQuestionViewThree.setText(txtAnswerQuestion);

            txtQuestionViewThree.setTextColor(Color.parseColor("#c0392b"));
            mAnswer.setTextColor(Color.parseColor("#c0392b"));

            txtAnswerViewThree.setText("La réponse est : "+answer);

            wrongCount();
            volumeIncorrect.start();

            txtOneThree.setEnabled(false);
            txtTwoThree.setEnabled(false);
            txtThreeThree.setEnabled(false);

            textNextThree.setVisibility(View.VISIBLE);

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

    public void textNextThree(View view){

        txtOneThree.setEnabled(true);
        txtTwoThree.setEnabled(true);
        txtThreeThree.setEnabled(true);

        updateQuestions();

        txtAnswerViewThree.setText("");
        txtQuestionViewThree.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextThree.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionsThreeGroup.getLength());

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

                txtOneThree.setEnabled(true);
                txtTwoThree.setEnabled(true);
                txtThreeThree.setEnabled(true);

                updateQuestions();

                txtAnswerViewThree.setText("");
                txtQuestionViewThree.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextThree.setVisibility(View.INVISIBLE);

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

        Intent intent = new Intent(ThreeGroupActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreThreeGroup", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneThree.setEnabled(false);
        txtTwoThree.setEnabled(false);
        txtThreeThree.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionThree.setText("0");
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
