package com.issam.drmas.edittexttutorials;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

public class FloatingLabelEditTextActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
            "(?=.*[0-9])" +       // at least 1 digit
            "(?=.*[a-z])" +       //at least 1 lower case letter
            "(?=.*[A-Z])" +       //at least 1 upper case letter
           // "(?=.*[a-zA-Z])" +    // any letter
            "(?=.*[@#$%^&+=])" +  //at least 1 special character
            "(?=\\S+$)" +         // no white space
            ".{6,}" +             //at least 6 characters
            "$");

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_label_edit_text);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            return false;

        }else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Please enter a valid email address");
            return false;
        }
        else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername(){
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()){
            textInputUsername.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15){
            textInputUsername.setError("Username too long");
            return false;
        }else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            return false;
        } else if (PASSWORD_PATTERN.matcher(passwordInput).matches()){
            textInputPassword.setError("Password too weak");
            return false;
        }
        else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View view){
        if (!validateEmail() | !validateUsername() | !validatePassword()){
            return;
        }

        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
