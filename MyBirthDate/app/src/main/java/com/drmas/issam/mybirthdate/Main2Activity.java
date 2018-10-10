package com.drmas.issam.mybirthdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText txtNum1;
    EditText txtNum2;
    Button btnAdd;
    Button btnSub;
    Button btnMulti;
    Button btnDiv;
    Button btnMod;
    TextView txtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        txtNum1 = findViewById( R.id.num1 );
        txtNum2 = findViewById( R.id.num2 );
        btnAdd = findViewById( R.id.btnAdd );
        btnSub = findViewById( R.id.btnSub );
        btnMulti = findViewById( R.id.btnMulti);
        btnDiv = findViewById( R.id.btnDiv );
        btnMod = findViewById( R.id.btnMod );
        txtR = findViewById( R.id.txtResult);

        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calc('+');
            }
        } );
        btnSub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calc( '-' );
            }
        } );
        btnMulti.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calc( '*' );
            }
        } );
        btnDiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calc( '%' );
            }
        } );
        btnMod.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calc( '/' );
            }
        } );
    }

    protected void Calc(char ope){
        try{
            int num1 = Integer.parseInt(txtNum1.getText()+"");
            int num2 = Integer.parseInt( txtNum2.getText()+"" );
            int r;

            switch (ope){
                case '+':
                    r = num1 + num2;
                    break;
                case '-':
                    r = num1 - num2;
                    break;
                case '*':
                    r = num1 * num2;
                    break;
                case '%':
                    r = num1 % num2;
                    break;
                default:
                    r = num1 / num2;
                    break;
            }
            txtR.setText("Result = " + r+"");

        }catch (Exception e){
            Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
        }
    }
}
