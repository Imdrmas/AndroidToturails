package com.issam.drmas.toastexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showToast(View view){

      Toast toast =  Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT);
      toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 90, 0);
      toast.show();

    }

    public void customToast(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();

    }

    public void styleableToast(View view){
        StyleableToast.makeText(this, "Hello World", R.style.exampleToast).show();

    }

    public void showToasts(View view){

        switch (view.getId()){
            case R.id.button_error:
                Toasty.error(this, "This is an error toast.", Toast.LENGTH_SHORT, true ).show();
            break;
            case R.id.button_success:
                Toasty.success(this, "This is sucsess toast.", Toast.LENGTH_SHORT, true ).show();
                break;
            case R.id.button_info:
                Toasty.info(this, "This is an info toast.", Toast.LENGTH_SHORT, true ).show();
                break;
            case R.id.button_warning:
                Toasty.warning(this, "This is warning toast.", Toast.LENGTH_SHORT, true ).show();
                break;
            case R.id.button_normal:
                Toasty.normal(this, "This is an normal toast.", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this, R.drawable.ic_android)).show();
                break;

        }
    }
}
