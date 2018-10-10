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
import com.issam.drmas.frenchverbsconjugator.Questions.QuestionsGroup;

public class GroupActivity extends AppCompatActivity {

    private QuestionsGroup questionsGroup = new QuestionsGroup();
    private String answer;

    private int questionNumber = 0;

    private int score = 0;
    private int heightScore;

    private TextView txtCorrectCountGroup, txtIncorrectCountGroup;
    private TextView btnCounterQuestionGroup;

    private TextView txtQuestionViewGroup, txtAnswerViewGroup;
    private TextView txtOneGroup, txtTwoGroup, txtThreeGroup;

    private int correctCounter = 0;
    private int wrongCounter = 0;
    private int questionCounter = 21;

    private TextView mAnswer, textNextGroup;
    private MediaPlayer volumeCorrect, volumeIncorrect;

    private Dialog dialog;
    private String txtAnswerQuestion;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        volumeCorrect = MediaPlayer.create( this, R.raw.correct );
        volumeIncorrect = MediaPlayer.create( this, R.raw.incorrect );

        txtCorrectCountGroup = findViewById(R.id.textCorrectCountGroup);
        txtIncorrectCountGroup = findViewById(R.id.textWrongCountGroup);
        btnCounterQuestionGroup = findViewById(R.id.counterQuestionGroup);

        textNextGroup = findViewById(R.id.textNextGroup);

        txtQuestionViewGroup = findViewById(R.id.textQuestionGroup);
        txtAnswerViewGroup = findViewById(R.id.textAnswerGroup);

        txtOneGroup = findViewById(R.id.txtOneGroup);
        txtTwoGroup = findViewById(R.id.txtTwoGroup);
        txtThreeGroup = findViewById(R.id.txtThreGroup);

        dialog = new Dialog(this);

        updateQuestions();

        adView = findViewById(R.id.adViewGroup);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public void correctCount(){

        correctCounter++;
        txtCorrectCountGroup.setText(String.valueOf(correctCounter));
    }

    public void wrongCount(){

        wrongCounter++;
        txtIncorrectCountGroup.setText(String.valueOf(wrongCounter));

    }

    public void countQuestionDown(){

        questionCounter--;
        btnCounterQuestionGroup.setText( String.valueOf( questionCounter ));
    }

    private void updateQuestions(){

        if (questionNumber < questionsGroup.getLength()){

            txtQuestionViewGroup.setText(questionsGroup.getTextQuestions(questionNumber));

            txtOneGroup.setText(questionsGroup.getChoice(questionNumber, 1));
            txtTwoGroup.setText(questionsGroup.getChoice(questionNumber, 2));
            txtThreeGroup.setText(questionsGroup.getChoice(questionNumber, 3));

            answer = questionsGroup.getCorrectAnswers(questionNumber);
            questionNumber++;
            countQuestionDown();

            txtAnswerQuestion = questionsGroup.getTextAnswers(questionNumber);

        }
        else {

            Toast.makeText(this, "Please Click in Top Score To Save Your Result :", Toast.LENGTH_LONG).show();
            zeroCountDown();
            disabledButton();

            dialog.setContentView(R.layout.custom_result);
            dialog.setCancelable(false);

            TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
            TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
            txtScore.setText("Score " +score + "/" +questionsGroup.getLength());

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
                    startActivity(new Intent(GroupActivity.this, MainActivity.class));
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

            textNextGroup.setVisibility(View.VISIBLE);

        }


    }

    public void btnClickedGroup(View view){

        changeFunction();

        mAnswer = (TextView) view;

        if (mAnswer.getText() == answer){

            score++;

            txtQuestionViewGroup.setTextColor(Color.parseColor("#1abc9c"));
            mAnswer.setTextColor(Color.parseColor("#1abc9c"));

            txtQuestionViewGroup.setText(txtAnswerQuestion);

            correctCount();
            volumeCorrect.start();

            disabledButton();
            textNextGroup.setVisibility(View.VISIBLE);

        }
        else {

            txtQuestionViewGroup.setText(txtAnswerQuestion);

            txtQuestionViewGroup.setTextColor(Color.parseColor("#c0392b"));
            mAnswer.setTextColor(Color.parseColor("#c0392b"));

            txtAnswerViewGroup.setText("La réponse est : "+answer);

            wrongCount();
            volumeIncorrect.start();

            disabledButton();
            textNextGroup.setVisibility(View.VISIBLE);

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

    public void textNextGroup(View view){

        txtOneGroup.setEnabled(true);
        txtTwoGroup.setEnabled(true);
        txtThreeGroup.setEnabled(true);

        updateQuestions();

        txtAnswerViewGroup.setText("");
        txtQuestionViewGroup.setTextColor(Color.parseColor("#2c3e50"));
        mAnswer.setTextColor(Color.parseColor("#2c3e50"));

        textNextGroup.setVisibility(View.INVISIBLE);

    }

    private void showResult(){

        dialog.setContentView(R.layout.custom_result);
        dialog.setCancelable(false);

        TextView txtResult = (TextView) dialog.findViewById(R.id.textResultUser);
        TextView txtScore = (TextView) dialog.findViewById(R.id.textScore);
        txtScore.setText("Score " +score + "/" +questionsGroup.getLength());

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

                txtOneGroup.setEnabled(true);
                txtTwoGroup.setEnabled(true);
                txtThreeGroup.setEnabled(true);

                updateQuestions();

                txtAnswerViewGroup.setText("");
                txtQuestionViewGroup.setTextColor(Color.parseColor("#2c3e50"));
                mAnswer.setTextColor(Color.parseColor("#2c3e50"));

                textNextGroup.setVisibility(View.INVISIBLE);
                dialog.dismiss();
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.custom_result_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendScoreToTop();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private void sendScoreToTop(){

        Intent intent = new Intent(GroupActivity.this, TopScoreActivity.class);
        intent.putExtra("scoreGroup", heightScore);
        startActivity(intent);
        finish();
    }

    private void disabledButton(){

        txtOneGroup.setEnabled(false);
        txtTwoGroup.setEnabled(false);
        txtThreeGroup.setEnabled(false);
    }

    private void zeroCountDown(){
        btnCounterQuestionGroup.setText("0");
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
