package com.issam.drmas.nadyelhikma;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */

public class TwoFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

     public static Fragment newInstance(Context context) {

        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_main, container, false);
        setUpView(root);
        return root;
    }

    private void setUpView(ViewGroup root) {
        ButterKnife.bind(this, root);
        setUpList();
    }

    private void setUpList() {

         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         recyclerView.setHasFixedSize(true);
         CommonRecycleAdapter2 commonRecycleAdapter2 = new CommonRecycleAdapter2(createItemList());
         recyclerView.setAdapter(commonRecycleAdapter2);
    }

    private ArrayList<titleDate> createItemList() {

        ArrayList<titleDate> titleDates = new ArrayList<>();

        titleDates.add(new titleDate("أمثال عربية")); //10
        titleDates.add(new titleDate("أمثال هندية"));
        titleDates.add(new titleDate("أمثال صينية"));
        titleDates.add(new titleDate("أمثال فرنسية"));
        titleDates.add(new titleDate("أمثال انجليزية"));
        titleDates.add(new titleDate("أمثال يونانية"));
        titleDates.add(new titleDate("أمثال روسية"));
        titleDates.add(new titleDate("أمثال يوغوسلافية"));
        titleDates.add(new titleDate("أمثال يابانية"));
        titleDates.add(new titleDate("أمثال هولندية"));

        titleDates.add(new titleDate("أمثال نرويجية")); //20
        titleDates.add(new titleDate("أمثال منغولية"));
        titleDates.add(new titleDate("أمثال مدغشقرية"));
        titleDates.add(new titleDate("أمثال مجرية"));
        titleDates.add(new titleDate("أمثال ماليزية"));
        titleDates.add(new titleDate("أمثال لاتينية"));
        titleDates.add(new titleDate("أمثال كورية"));
        titleDates.add(new titleDate("أمثال كورسيكية"));
        titleDates.add(new titleDate("أمثال كمبودية"));
        titleDates.add(new titleDate("أمثال كردية"));

        titleDates.add(new titleDate("أمثال كتلونية")); //30
        titleDates.add(new titleDate("أمثال فيتنامية"));
        titleDates.add(new titleDate("أمثال فنلندية"));
        titleDates.add(new titleDate("أمثال فارسية"));
        titleDates.add(new titleDate("أمثال غجرية"));
        titleDates.add(new titleDate("أمثال سويسرية"));
        titleDates.add(new titleDate("أمثال سويدية"));
        titleDates.add(new titleDate("أمثال رومانية"));
        titleDates.add(new titleDate("أمثال دانمركية"));
        titleDates.add(new titleDate("أمثال حبشية"));

        titleDates.add(new titleDate("أمثال تشيكوسلوفاكية")); //40
        titleDates.add(new titleDate("أمثال تركية"));
        titleDates.add(new titleDate("أمثال بولونية"));
        titleDates.add(new titleDate("أمثال بلغارية"));
        titleDates.add(new titleDate("أمثال برتغالية"));
        titleDates.add(new titleDate("أمثال برازيلية"));
        titleDates.add(new titleDate("أمثال باسكية"));
        titleDates.add(new titleDate("أمثال إيطالية"));
        titleDates.add(new titleDate("أمثال إيسلندية"));
        titleDates.add(new titleDate("أمثال إيرلندية"));

        titleDates.add(new titleDate("أمثال إسبانية"));
        titleDates.add(new titleDate("أمثال أمريكية"));
        titleDates.add(new titleDate("أمثال ألمانية"));

        return titleDates;
    }

}
