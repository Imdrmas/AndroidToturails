package com.verbes.drmas.issamdrmas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        facebook = (Button)findViewById( R.id.btnfacebook );
        facebook.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent facebookIntent = btn_facebook(Home.this);
                startActivity(facebookIntent);

            }
        }

        );
    } // end Main

    public static Intent btn_facebook(Context context){
        try {
            context.getPackageManager()
                    .getPackageInfo( "com.facebook.fjeralhoria", 0 );
            return  new Intent( Intent.ACTION_VIEW,
                    Uri.parse( ("fb://page/704844969612141") ));
        } catch (Exception e){
            return new Intent( Intent.ACTION_VIEW,
                    Uri.parse( "https://www.facebook.com/fjeralhoria/" ));
        }
    } // and facebook


    public void btn_poem(View view) {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity( intent );
    }

    public void btn_mail(View view) {
        try {
            String txt = "Good morning \n" + "My suggestion is";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData( Uri.parse("mailto:"));
            sendemail.setType(("message/rfc822"));
            sendemail.putExtra(Intent.EXTRA_EMAIL, "imdrmas@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "Application Issam drmas");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);
        }catch (Exception e) {
            Toast.makeText(this,"Sorry cannot find the application", Toast.LENGTH_LONG).show();
        }
    }
    public void btn_share(View view) {
        String txtshare = "Issam Drmas";
        String sharelink = "https://play.google.com/store/apps/details?id=com.com.verbes.drmas.issamdrmas";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    }
}


















