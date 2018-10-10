package com.verbes.drmas.issamdrmas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ListView listView = (ListView)findViewById(R.id.ListView);


        String[] itme = getResources().getStringArray(R.array.index);
        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_itme,R.id.textitem,itme);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Webhtml.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        });

    }

    // start img_icons
    public void img_share(View view){
        String txtshare = "Issam drmas";
        String sharelink = "https://play.google.com/store/apps/details?id=com.verbes.drmas.verbesfranais";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare + "\n" + sharelink);
        startActivity(share);

    } // end Share

    // Start Send email
    public void img_email(View view) {
        try {
            String txt = "Good morning \n" + "My suggestion is";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData( Uri.parse("mailto:"));
            sendemail.setType(("message/rfc822"));
            sendemail.putExtra(Intent.EXTRA_EMAIL, "imdrmas@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "Application Issam Drmas");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);
        }catch (Exception e) {
            Toast.makeText(this,"Sorry cannot find the application", Toast.LENGTH_LONG).show();
        }
    } // end send email





    public void img_close(View view) {
        finish();
    }
}
