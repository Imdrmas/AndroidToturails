package com.issam.drmas.fragmentsdialog;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class AnimationCommunicateActivity extends AppCompatActivity implements AnimationFragment.OnFragmentInteractionListener {
    private FrameLayout frameLayoutContainer;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_communicate);

        frameLayoutContainer = (FrameLayout) findViewById(R.id.fragment_container_animate);
        editText = (EditText) findViewById(R.id.editText_animate);
        button = (Button) findViewById(R.id.button_animate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                openFragment(text);
            }
        });
    }

    @SuppressLint("ResourceType")
    private void openFragment(String text) {
        AnimationFragment fragment = AnimationFragment.newInstance(text);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_container_animate, fragment, "ANIMATE_FRAGMENT");
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(String sendBackText) {
        editText.setText(sendBackText);
        onBackPressed();
    }
}
