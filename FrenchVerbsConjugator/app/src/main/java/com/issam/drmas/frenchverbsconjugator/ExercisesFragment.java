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
public class ExercisesFragment extends Fragment {

    public ExercisesFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.firstGroupExercise) LinearLayout firstGroupExercise;
    @BindView(R.id.secondGroupExercise) LinearLayout secondGroupExercise;
    @BindView(R.id.threeGroupExercise) LinearLayout threeGroupExercise;

    @BindView(R.id.avoirEtreExercise) LinearLayout avoirEtreExercise;
    @BindView(R.id.groupExercise) LinearLayout groupExercise;
    @BindView(R.id.participeExercise) LinearLayout participeExercise;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_exercises, container, false);
        setUpView(viewGroup);
        return viewGroup;
    }

    private void setUpView(ViewGroup viewGroup) {
        ButterKnife.bind(this, viewGroup);
        setUpPage();
    }

    private void setUpPage() {

        firstGroupExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFirstGroup = new Intent(getActivity(), FirstGroupActivity.class);
                startActivity(intentFirstGroup);
            }
        });

        secondGroupExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecondGroup = new Intent(getActivity(), SecondGroupActivity.class);
                startActivity(intentSecondGroup);
            }
        });
        threeGroupExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThreeGroup = new Intent(getActivity(), ThreeGroupActivity.class);
                startActivity(intentThreeGroup);
            }
        });
        avoirEtreExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEtreAvoir = new Intent(getActivity(), EtreAvoirActivity.class);
                startActivity(intentEtreAvoir);
            }
        });
        groupExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentGroup = new Intent(getActivity(), GroupActivity.class);
                startActivity(intentGroup);
            }
        });
        participeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentParticipe = new Intent(getActivity(), ParticipeActivity.class);
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
