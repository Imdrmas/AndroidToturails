package com.verbes.drmas.verbesfranais;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class home_page extends AppCompatActivity {

    Button facebook;
    private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_page );

        facebook = (Button)findViewById( R.id.btn_facebook );
        facebook.setOnClickListener( new View.OnClickListener(){
      @Override
      public void onClick(View v){
      Intent facebookIntent = btn_facebook(home_page.this);
      startActivity(facebookIntent);

      }
      });
    } // and Main


    public void btn_conj(View view) {
        Intent intent;
        intent = new Intent(this, conjugation.class);
        startActivity( intent );
    }
    public void btn_gramar(View view) {
        Intent intent;
        intent = new Intent(this, Grammar.class);
        startActivity( intent );
    }

    public void btn_exice(View view) {
        Intent intent;
        intent = new Intent(this, exercice_home.class);
        startActivity( intent );
    }

    public static Intent btn_facebook(Context context){
        try {
            context.getPackageManager()
                    .getPackageInfo( "com.facebook.apprenez12", 0 );
            return  new Intent( Intent.ACTION_VIEW,
                    Uri.parse( ("fb://page/329967313701208") ));
        } catch (Exception e){
            return new Intent( Intent.ACTION_VIEW,
                    Uri.parse( "https://www.facebook.com/apprenez12/" ));
        }
    }

    // Start Send email
    public void btn_mail(View view) {

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

    public void btn_share(View view) {
        String txtshare = "Issam Drmas";
        String sharelink = "https://play.google.com/store/apps/details?id=com.verbes.drmas.verbesfranais";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    }



} // endding
