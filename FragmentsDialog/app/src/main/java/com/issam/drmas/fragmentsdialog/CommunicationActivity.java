package com.issam.drmas.fragmentsdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CommunicationActivity extends AppCompatActivity implements FragmentCommunication.FragmentAListener,
FragmentCommunicationb.FragmentBListener {

    private FragmentCommunication fragmentCommunication;
    private FragmentCommunicationb fragmentCommunicationb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        fragmentCommunication = new FragmentCommunication();
        fragmentCommunicationb = new FragmentCommunicationb();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentCommunication)
                .replace(R.id.container_b, fragmentCommunicationb)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentCommunicationb.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentCommunication.updateEditText(input);
    }
}
