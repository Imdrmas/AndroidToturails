package com.drmas.issam.mybirthdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Editor extends AppCompatActivity {

    EditText txtHtml;
    Button btnNew;
    Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_editor );

        txtHtml = (EditText)findViewById( R.id.txtHtml);
        btnNew = (Button)findViewById( R.id.btnNew);
        btnRun = (Button)findViewById( R.id.btnRun);

        String strStarHTML = "" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "input{\n" +
                "font-size:25px;\n" +
                "color:blue;\n" +
                "font-weight:bold;\n" +
                "width:300px;\n" +
                "margin:6px 20px;\n" +
                "background:blue;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Test About HTML & Css & Javascript </h1>\n" +
                "<h2> Press on submit button </h2>\n" +
                "<input id='txt' />\n<br/>\n" +
                "<input type='submit' onclick='window.txt.value+=7;' />\n" +
                "</body>\n" +
                "</html>";
        txtHtml.setText(strStarHTML);

       final Intent myAct = new Intent( this, ActRun.class );
       btnRun.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               MyVar.strHTML = txtHtml.getText()+"";
               startActivity( myAct);
           }
       });

       btnNew.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String strNewHtml = "" +
                       "<html>\n" +
                       "<head>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "   \n" +
                       "</body>\n" +
                       "</html>";
               txtHtml.setText(strNewHtml);
           }
       } );

    }
}
