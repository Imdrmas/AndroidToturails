package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class exercice_home extends AppCompatActivity {
    private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exercice_home );

    } // endding main


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

    public void etre_avoir(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity( intent );
    }
    public void premiergroup(View view) {
        Intent intent;
        intent = new Intent(this, premiergroup.class);
        startActivity( intent );
    }
    public void deuxgroup(View view) {
        Intent intent;
        intent = new Intent(this, deuxgroup.class);
        startActivity( intent );
    }
    public void troisgroup(View view) {
        Intent intent;
        intent = new Intent(this, troisgroup.class);
        startActivity( intent );
    }
    public void participepasse(View view) {
        Intent intent;
        intent = new Intent(this, participepasse.class);
        startActivity( intent );
    }
    public void groupe_verbe(View view) {
        Intent intent;
        intent = new Intent(this, groupe_verbe.class);
        startActivity( intent );
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
