package com.verbes.drmas.verbesfranais;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class conjugation extends AppCompatActivity  {


    private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_conjugation );




    } // end Main


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
    } // end menu

    public void verbeA(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_a.class);
        startActivity( intent );
    }
    public void verbeB(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_b.class);
        startActivity( intent );
    }
    public void verbeC(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_c.class);
        startActivity( intent );
    }
    public void verbeD(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_d.class);
        startActivity( intent );
    }
    public void verbeE(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_e.class);
        startActivity( intent );
    }
    public void verbeFGH(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_fgh.class);
        startActivity( intent );
    }
    public void verbeIJKL(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_ijkl.class);
        startActivity( intent );
    }
    public void verbeMNOP(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_mnop.class);
        startActivity( intent );
    }
    public void verbeQP(View view) {
        Intent intent;
        intent = new Intent(this, verbe_en_qp.class);
        startActivity( intent );
    }
    public void verbeSTUVZ(View view) {
        Intent intent;
        intent = new Intent(this, verbe_stuvz.class);
        startActivity( intent );
    }

// start img_icons
    public void img_share(View view){
        String txtshare = "Conjugaison les verbes français";
        String sharelink = "https://play.google.com/store/apps/details?id=com.verbes.drmas.verbesfranais";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    } // end Share

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


    public void img_close(View view) {
        finish();
    }


} // the endding
