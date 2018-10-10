package com.verbes.drmas.verbesfranais;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class verbe_en_e extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] strings;
    private ListView listView;
    ArrayAdapter<String> adapter;
    private android.content.Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_verbe_en_e );
        // Start ListView
        final ListView listView = (ListView)findViewById(R.id.ListView);
        strings = getResources().getStringArray( R.array.verbe_en_e);
        adapter = new ArrayAdapter<String>( verbe_en_e.this, R.layout.row_itme,R.id.textitem, strings);
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( this );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(verbe_en_e.this, webhtmlE.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        }); // end ListView


    } // end main
    // Start menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        //R.menu.menu est l'id de notre menu
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
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = adapter.getItem( position );
        Toast.makeText( getApplicationContext(), value, Toast.LENGTH_LONG ).show();
    } // endding Menu

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


} // endding
