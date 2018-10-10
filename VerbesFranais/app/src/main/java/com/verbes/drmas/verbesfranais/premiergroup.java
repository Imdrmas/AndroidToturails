package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class premiergroup extends AppCompatActivity {

    private premiergroup1 mQuestionLibarary = new premiergroup1();
    private TextView mScoreView; // view for current total score
    private TextView mQuestionview; // current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    // private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer; // correct anser for question in mQuestionView
    private int mScore = 0; // current total score
    private int mQuestionNumber = 0; // current question number

    private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_premiergroup );

        mScoreView = (TextView) findViewById( R.id.score );
        mQuestionview = (TextView) findViewById( R.id.question);
        mButtonChoice1 = (Button) findViewById( R.id.choice1 );
        mButtonChoice2 = (Button) findViewById( R.id.choice2 );
        mButtonChoice3 = (Button) findViewById( R.id.choice3 );
        // mButtonChoice4 = (Button) findViewById( R.id.choice4 );
        updateQuestion();
        // show current total score for user
        updateScore(mScore);


    } // endding main

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if (mQuestionNumber<mQuestionLibarary.getLength()){
            // set the text for new question, and new 4 alternative to answer on four buttons
            mQuestionview.setText(mQuestionLibarary.getQuestions(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibarary.getChoice(mQuestionNumber, 1 ));
            mButtonChoice2.setText(mQuestionLibarary.getChoice(mQuestionNumber, 2 ));
            mButtonChoice3.setText(mQuestionLibarary.getChoice(mQuestionNumber, 3 ));
            // mButtonChoice4.setText(mQuestionLibarary.getChoice(mQuestionNumber, 4 ));
            mAnswer = mQuestionLibarary.getCorrectAnswer( mQuestionNumber );
            mQuestionNumber++;
        }
        else {
            Toast.makeText(premiergroup.this, "It was the last question!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent( premiergroup.this, Score1.class );
            intent.putExtra( "score", mScore ); // pass the current score to the second screen
            startActivity( intent );
        }
    }

    // show current total score for the user
    private void updateScore(int point){
        mScoreView.setText("" + mScore+"/"+mQuestionLibarary.getLength());
    }

    public void ocCkickbtn(View view) {

        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the method
        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) findViewById( R.id.toast_root ));
            Toast toast = new Toast( getApplicationContext() );
            toast.setGravity( Gravity.TOP, 0, 0 );
            toast.setDuration( Toast.LENGTH_SHORT );
            toast.setView( layout );
            toast.show();
        }
        else {
            //Toast.makeText( MainActivity.this, "", Toast.LENGTH_LONG ).show();
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate( R.layout.toast_incorrect, (ViewGroup) findViewById( R.id.toast_incorrect ) );
            Toast toast = new Toast( getApplicationContext() );
            toast.setGravity( Gravity.TOP, 0, 0 );
            toast.setDuration( Toast.LENGTH_SHORT );
            toast.setView( layout );
            toast.show();
        }
        // show current total score for the user
        updateScore( mScore );
        // once user answer the question, we move on to the next one, if any
        updateQuestion();

    } // ennding btn

    // Start menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_icon:
                Intent intent;
                intent = new Intent(this, home_page.class);
                startActivity( intent );

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Start Send email
    public void img_mail(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND );
        intent.setData( Uri.parse( "mailto:" ));
        String[] to={"imdrmas@gmail.com", "issamdrmas@gmail.com"};
        intent.putExtra( Intent.EXTRA_EMAIL, to);
        intent.putExtra( Intent.EXTRA_SUBJECT, "My app verbe french" );
        intent.putExtra( Intent.EXTRA_TEXT, "Send your suggestions");
        intent.setType( "message/rfc822");
        chooser= Intent.createChooser( intent, "Send Email");
        startActivity( chooser );
    } // end send email

    public void img_share(View view) {
        String txtshare = "Issam Drmas";
        String sharelink = "https://play.google.com/store/apps/details?id=com.verbes.drmas.verbesfranais";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    }

    public void img_close(View view) {
        finish();
    }


} // andding
