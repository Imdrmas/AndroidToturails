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
public class ThreeFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static Fragment newInstance(Context context) {

        ThreeFragment fragment = new ThreeFragment();
        return fragment;
    }

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.content_main, null);
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
         CommonRecycleAdapter3 commonRecycleAdapter3 = new CommonRecycleAdapter3(createItemList());
         recyclerView.setAdapter(commonRecycleAdapter3);
    }

    private ArrayList<titleDate> createItemList() {

         ArrayList<titleDate> titleDates = new ArrayList<>();

         titleDates.add(new titleDate("أقوال وليام شكسبير")); // 10
         titleDates.add(new titleDate("اقوال ليو تولستوي"));
         titleDates.add(new titleDate("اقوال فولتير"));
         titleDates.add(new titleDate("أقوال جبران خليل جبران"));
         titleDates.add(new titleDate("اقوال أحمد شوقي"));
         titleDates.add(new titleDate("أقوال أبو الطيّب المتنبي"));
         titleDates.add(new titleDate("اقوال المعري"));
         titleDates.add(new titleDate("اقوال نجيب محفوظ"));
         titleDates.add(new titleDate("اقوال هيلين كيلر"));
         titleDates.add(new titleDate("اقوال محمود درويش"));

        titleDates.add(new titleDate("اقوال فيكتور هوجو")); //20
        titleDates.add(new titleDate("اقوال باولو كويلو"));
        titleDates.add(new titleDate("اقوال غوته"));
        titleDates.add(new titleDate("اقوال أحلام مستغانمي"));
        titleDates.add(new titleDate("أقوال نزار قباني"));
        titleDates.add(new titleDate("أقوال مصطفى صادق الرافعي"));
        titleDates.add(new titleDate("أقوال قيس بن الملوح"));
        titleDates.add(new titleDate("أقوال غسان كنفاني"));
        titleDates.add(new titleDate("أقوال غادة السمان"));
        titleDates.add(new titleDate("أقوال عنترة بن شداد"));

        titleDates.add(new titleDate("أقوال علي الوردي")); //30
        titleDates.add(new titleDate("أقوال عباس محمود العقاد"));
        titleDates.add(new titleDate("أقوال طه حسين"));
        titleDates.add(new titleDate("أقوال توفيق الحكيم"));
        titleDates.add(new titleDate("أقوال الطيب صالح"));
        titleDates.add(new titleDate("أقوال أنيس منصور"));
        titleDates.add(new titleDate("أقوال أحمد مطر"));
        titleDates.add(new titleDate("حكم افلاطون"));
        titleDates.add(new titleDate("اقوال سقراط"));
        titleDates.add(new titleDate("اقوال أرسطو"));

        titleDates.add(new titleDate("أقوال مصطفى محمود")); //40
        titleDates.add(new titleDate("أقوال جلال الدين الرومي"));
        titleDates.add(new titleDate("اقوال سيد قطب"));
        titleDates.add(new titleDate("اقوال جان جاك روسو"));
        titleDates.add(new titleDate("اقوال ابراهيم الفقي"));
        titleDates.add(new titleDate("اقوال جورج برنارد شو"));
        titleDates.add(new titleDate("أقوال فريدريك نيتشه"));
        titleDates.add(new titleDate("أقوال ديل كارنيجي"));
        titleDates.add(new titleDate("أقوال برتراند راسل"));
        titleDates.add(new titleDate("أقوال آرثر شوبنهاور"));

        titleDates.add(new titleDate("اقوال ستيف جوبز")); //50
        titleDates.add(new titleDate("أقوال بيل غيتس"));
        titleDates.add(new titleDate("اقوال ونستون تشرشل"));
        titleDates.add(new titleDate("أقوال مالكوم إكس"));
        titleDates.add(new titleDate("اقوال هتلر"));
        titleDates.add(new titleDate("اقوال نابليون بونابرت"));
        titleDates.add(new titleDate("اقوال نيلسون مانديلا"));
        titleDates.add(new titleDate("اقوال غاندي"));
        titleDates.add(new titleDate("اقوال كونفوشيوس"));
        titleDates.add(new titleDate("أقوال رجب طيب أردوغان"));

        titleDates.add(new titleDate("أقوال تشي جيفارا")); // 60
        titleDates.add(new titleDate("أقوال باراك أوباما"));
        titleDates.add(new titleDate("اقوال توماس اديسون"));
        titleDates.add(new titleDate("اقوال اينشتاين"));
        titleDates.add(new titleDate("أقوال علي بن أبي طالب"));
        titleDates.add(new titleDate("اقوال عمر بن الخطاب"));
        titleDates.add(new titleDate("أقوال أبو بكر الصديق"));
        titleDates.add(new titleDate("أقوال عثمان بن عفان"));
        titleDates.add(new titleDate("اقوال حسن البنا"));
        titleDates.add(new titleDate("اقوال احمد الشقيري"));

        titleDates.add(new titleDate("أقوال يوسف القرضاوي")); //70
        titleDates.add(new titleDate("أقوال محمد متولي الشعراوي"));
        titleDates.add(new titleDate("أقوال عمر عبد الكافي"));
        titleDates.add(new titleDate("أقوال عبد الكريم بكار"));
        titleDates.add(new titleDate("أقوال طارق السويدان"));
        titleDates.add(new titleDate("أقوال سلمان العودة"));
        titleDates.add(new titleDate("أقوال أحمد ديدات"));
        titleDates.add(new titleDate("اقوال الشيخ علي الطنطاوي"));
        titleDates.add(new titleDate("اقوال محمد الغزالي"));
        titleDates.add(new titleDate("اقوال الحسن البصري"));


        titleDates.add(new titleDate("اقوال ابن القيم")); //80
        titleDates.add(new titleDate("اقوال الشافعي"));
        titleDates.add(new titleDate("اقوال ابن تيمية"));
        titleDates.add(new titleDate("أقوال لقمان الحكيم"));
        titleDates.add(new titleDate("أقوال الفضيل بن عياض"));

         return titleDates;
    }

}
