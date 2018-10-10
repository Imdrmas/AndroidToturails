package com.drmas.issam.mywords;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "exmple.txt";

    EditText txtWord;
    TextView txtSize;
    Button btnBig;
    Button btnSmall;
    CheckBox cbxBold;
    CheckBox cbxUnderline;
    Spinner sColor;
    Spinner sFont;
    RadioButton rbLTR;
    RadioButton rbRTL;
    EditText txtFileName;
    Button btnNew;
    Button btnSave;
    Button btnGetFile;

    String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

         txtWord = (EditText)findViewById( R.id.txtWord);
         txtSize = (TextView)findViewById( R.id.txtSize );
         btnBig = (Button)findViewById( R.id.btn_Plus );
         btnSmall = (Button)findViewById( R.id.btn_Mins );
         cbxBold = (CheckBox)findViewById( R.id.cbx_Bold );
         cbxUnderline = (CheckBox)findViewById( R.id.cbx_Line );
         sColor = (Spinner)findViewById( R.id.sColor );
         sFont = (Spinner)findViewById( R.id.sFont );
         rbLTR = (RadioButton)findViewById( R.id.rdi_LR );
         rbRTL = (RadioButton)findViewById( R.id.rdi_RL );
         txtFileName = (EditText)findViewById( R.id.txtFileName);
         btnNew = (Button)findViewById( R.id.btn_New );
         btnSave = (Button)findViewById( R.id.btn_Save );
         btnGetFile = (Button)findViewById( R.id.btn_getFile );

         fillColors();
         fillFonts();

         btnBig.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 setSize( '+' );
             }
         });
         btnSmall.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 setSize( '-' );
             }
         } );
         cbxBold.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 setBold();
             }
         });
         cbxUnderline.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setUnderline();
             }

         });
         sColor.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 setOneColor();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         } );
         sFont.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 setOneFont();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         } );
         rbLTR.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 setAlign();
             }
         });
         rbRTL.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 setAlign();
             }
         });
         btnNew.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 newFile();
             }
         } );
         btnSave.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 saveFile();
             }
         } );





    } //end Main

    protected void fillColors(){
        String[] strColors = {
                "black",
                "red",
                "blue",
                "green",
                "gray",
                "orange",
                "navy",
                "brown",
                "pink",
                "yellow",
                "pruple"
        };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, strColors );
        sColor.setAdapter( arrayAdapter );
    }
    protected void fillFonts(){
        String[] strFonts = {
                "sans-serif",
                "lobster",
                "openSans",
                "semibold",
                "oswald",
                "quicksand",
                "raleway",
                "roboto",
                "source"
        };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strFonts  );
        sFont.setAdapter( arrayAdapter );

    }
    protected void setSize(char bigORsamll){
        int size = Integer.parseInt(txtSize.getText()+"");
        if(bigORsamll=='+') size++;
        else  size--;
        if(size > 99) size=99;
        if (size < 6) size=6;
        txtWord.setTextSize(size);
        txtSize.setText(size+"");
    }
    protected void setBold(){
        setOneFont();
    }
    protected void setUnderline(){
        if(cbxUnderline.isChecked()){
            txtWord.setPaintFlags( Paint.UNDERLINE_TEXT_FLAG);
        }else{
            txtWord.setPaintFlags( Paint.LINEAR_TEXT_FLAG);
        }
        setOneFont();
    }
    protected void setOneColor(){
        String strColor = sColor.getSelectedItem().toString();
        switch (strColor){
            case "black":
                txtWord.setTextColor( getResources().getColor(R.color.black ) );
                break;
            case "red":
                txtWord.setTextColor( getResources().getColor( R.color.red ));
                break;
            case "blue":
                txtWord.setTextColor( getResources().getColor( R.color.blue));
                break;
            case "green":
                txtWord.setTextColor( getResources().getColor( R.color.green ));
                break;
            case "gray":
                txtWord.setTextColor( getResources().getColor( R.color.gray ));
                break;
            case "orange":
                txtWord.setTextColor( getResources().getColor( R.color.orange ));
                break;
            case "navy":
                txtWord.setTextColor( getResources().getColor( R.color.navy ));
                break;
            case "brown":
                txtWord.setTextColor( getResources().getColor( R.color.brown ));
                break;
            case "pink":
                txtWord.setTextColor( getResources().getColor( R.color.pink ));
                break;
            case "yellow":
                txtWord.setTextColor( getResources().getColor( R.color.yellow ));
                break;
            case "pruple":
                txtWord.setTextColor( getResources().getColor( R.color.pruple ));
                break;
        }
    }
    protected void setOneFont(){
        String strfont = sFont.getSelectedItem().toString();
        Typeface tf = Typeface.SANS_SERIF;
        switch (strfont){
            case "sans-serif":
                tf = Typeface.SANS_SERIF;
                break;
            case "lobster":
                tf = Typeface.createFromAsset( getAssets(),"Lobster_1.3.otf" );
                break;
            case "openSans":
                tf = Typeface.createFromAsset( getAssets(), "OpenSans-Bold.ttf");
                break;
            case "semibold":
                tf = Typeface.createFromAsset( getAssets(), "OpenSans-Semibold.ttf");
                break;
            case "oswald":
                tf = Typeface.createFromAsset( getAssets(), "Oswald-Light.ttf");
                break;
            case "quicksand":
                tf = Typeface.createFromAsset( getAssets(), "Quicksand_Dash.otf");
                break;
            case "raleway":
                tf = Typeface.createFromAsset( getAssets(), "Raleway-Black.ttf");
                break;
            case "roboto":
                tf = Typeface.createFromAsset( getAssets(), "Roboto-Black.ttf");
                break;
            case "source":
                tf = Typeface.createFromAsset( getAssets(), "SourceSansPro-Regular.otf");
                break;
        }
        if(cbxBold.isChecked())
        txtWord.setTypeface(tf, Typeface.BOLD);
        else txtWord.setTypeface( tf, Typeface.NORMAL);

    }
    protected void setAlign(){
        if(rbLTR.isChecked()){
            txtWord.setGravity( Gravity.LEFT);
        }else{
            txtWord.setGravity( Gravity.RIGHT);
        }
    }
    protected void newFile(){
        txtWord.setText("");
        txtSize.setText("14");
        txtWord.setTextSize(14);
        cbxBold.setChecked(false);
        cbxUnderline.setChecked(false);
        sColor.setSelection(0);
        sFont.setSelection(0);
        //rbLTR.setChecked(true);
        txtFileName.setText(getResources().getText( R.string.fileName ));
        txtWord.requestFocus();
    }

   protected void saveFile() {
        if ("".equals( txtFileName.getText().toString().trim() )) {
            Toast.makeText( this, "File name is Empty !", Toast.LENGTH_SHORT ).show();
            txtFileName.requestFocus();
        } else {

            try {


               String strPath = Environment.getExternalStorageDirectory().getPath() + "/mywords";
                File f = new File( strPath );
                f.mkdir();
                PrintWriter pw = new PrintWriter( txtFileName.getText() + ".txt" );
                pw.write(txtWord.getText().toString());
                pw.close();


                PrintWriter pwSet = new PrintWriter( txtFileName.getText() + "Set.txt" );
                String strSet =
                          txtSize.getText()
                        + "\n" + cbxBold.isChecked()
                        + "\n" + cbxUnderline.isChecked()
                        + "\n" + sColor.getSelectedItem()
                        + "\n" + sFont.getSelectedItem()
                        + "\n" + rbLTR.isChecked()
                        + "\n" + rbRTL.isChecked();
                pwSet.write( strSet );
                pwSet.close();

                Toast.makeText( this, "File is saved", Toast.LENGTH_SHORT ).show();
            }
         catch(Exception e){
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG ).show();
        }
    }
    }


}// endding
