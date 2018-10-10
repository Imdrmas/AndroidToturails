package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HighostScoreActivity extends AppCompatActivity {
      private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_highost_score );





        TextView textScore = (TextView) findViewById( R.id.textscore );
        TextView texHightScore = (TextView) findViewById( R.id.texthightscore );

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", (byte) 0 );

        textScore.setText( "New score: " + score );

        SharedPreferences mypref = getPreferences( MODE_PRIVATE );
        int hightscore = mypref.getInt( "heightscore", 0);

        if (hightscore>= score){
            texHightScore.setText( "Hight score: "+hightscore );

        }
        else {
            texHightScore.setText( "New hightscore: "+score );
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt( "heightscore", score );
            editor.commit();
        }

    } // end main












    public void ocCkickbtn(View view) {
        Intent intent = new Intent(HighostScoreActivity.this, MainActivity.class );
        startActivity(intent);
    } //endding


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
}
