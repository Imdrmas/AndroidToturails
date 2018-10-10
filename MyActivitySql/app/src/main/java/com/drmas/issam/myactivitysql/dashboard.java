package com.drmas.issam.myactivitysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class dashboard extends AppCompatActivity {

    String EmailHolder;
    TextView Email;
    Button LogOUT, btn_Project, btn_deprtment, btn_employye, btn_workon, btn_report ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );

        String username = getIntent().getStringExtra( "Username" );
        TextView tv = (TextView)findViewById( R.id.txtUsernameDisplay );
        tv.setText( username );

        Email = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);

        btn_Project = (Button)findViewById(R.id.Project_activity);
        btn_deprtment = (Button)findViewById(R.id.department_activity);
        btn_employye = (Button)findViewById(R.id.employye_activity);
        btn_workon = (Button)findViewById(R.id.workon_activity);
        btn_report = (Button)findViewById(R.id.report_activity);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(MainActivity.UserEmail);

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(dashboard.this,"Log Out Successfull", Toast.LENGTH_LONG).show();

            }
        });

        btn_Project.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( dashboard.this, SignUp.class );
                startActivity(i);
            }
        });


    }
}
