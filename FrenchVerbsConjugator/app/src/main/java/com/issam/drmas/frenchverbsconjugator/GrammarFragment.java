package com.issam.drmas.frenchverbsconjugator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */

public class GrammarFragment extends Fragment {

    public GrammarFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.firstGroupGram) LinearLayout firstGroupGram;
    @BindView(R.id.secondGroupGram) LinearLayout secondGroupGram;
    @BindView(R.id.threeGroupGram) LinearLayout threeGroupGram;

    @BindView(R.id.irreguarGram) LinearLayout gerleGram;
    @BindView(R.id.grammarGram) LinearLayout grammarGram;
    @BindView(R.id.participeGram) LinearLayout participeGram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_grammar, container, false);
        setUpView(viewGroup);
        return viewGroup;
    }

    private void setUpView(ViewGroup viewGroup) {
        ButterKnife.bind(this, viewGroup);
        setUpPage();
    }

    private void setUpPage() {

        final String firstGroup = "firstgroup";
        firstGroupGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFirst = new Intent(getContext(), WebViewActivity.class);
                intentFirst.putExtra("value", firstGroup);
                startActivity(intentFirst);
            }
        });

        final String secondGroup = "secondgroup";
        secondGroupGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecond = new Intent(getContext(), WebViewActivity.class);
                intentSecond.putExtra("value", secondGroup);
                startActivity(intentSecond);
            }
        });

        final String threeGroup = "thregroup";
        threeGroupGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThree = new Intent(getContext(), WebViewActivity.class);
                intentThree.putExtra("value", threeGroup);
                startActivity(intentThree);
            }
        });

        final String regle = "regle";
        gerleGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrreguar = new Intent(getContext(), WebViewActivity.class);
                intentIrreguar.putExtra("value", regle);
                startActivity(intentIrreguar);
            }
        });

        final String grammar = "grammar";
        grammarGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGrammar = new Intent(getContext(), WebViewActivity.class);
                intentGrammar.putExtra("value", grammar);
                startActivity(intentGrammar);
            }
        });

        final String participe = "participe";
        participeGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentParticipe = new Intent(getContext(), WebViewActivity.class);
                intentParticipe.putExtra("value", participe);
                startActivity(intentParticipe);
            }
        });

    }

    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() > 1){
            getFragmentManager().popBackStack();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }
}
