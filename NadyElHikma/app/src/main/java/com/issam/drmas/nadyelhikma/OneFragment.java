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

public class OneFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CommonRecycleAdapter adapter;

    public static Fragment newInstance(Context context){
        OneFragment fragment = new OneFragment();
        return fragment;
    }

    public OneFragment() {
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommonRecycleAdapter(createItemList());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private ArrayList<titleDate> createItemList() {

        ArrayList<titleDate> itemList = new ArrayList<>();

        itemList.add(new titleDate("حكم عن الأمانة        ")); //10
        itemList.add(new titleDate("كلام و حكم عن الأب        "));
        itemList.add(new titleDate("حكم عن العزة        "));
        itemList.add(new titleDate("حكم عن الابتسامة        "));
        itemList.add(new titleDate("حكم عن الأولاد        "));
        itemList.add(new titleDate("حكم عن الاخلاق        "));
        itemList.add(new titleDate("حكم عن الأنانية        "));
        itemList.add(new titleDate("كلام و حكم عن الأم        "));
        itemList.add(new titleDate("حكم و مقولات عن الامل        "));
        itemList.add(new titleDate("حكم عن البخل        "));

        itemList.add(new titleDate("حكم عن التربية         ")); //20
        itemList.add(new titleDate("حكم عن التأني و العجلة         "));
        itemList.add(new titleDate("حكم عن التشاؤم         "));
        itemList.add(new titleDate("حكم عن التكبر         "));
        itemList.add(new titleDate("حكم عن التواضع         "));
        itemList.add(new titleDate("حكم عن الجمال         "));
        itemList.add(new titleDate("حكم عن الحب         "));
        itemList.add(new titleDate("حكم عن الحرب         "));
        itemList.add(new titleDate("حكم عن الحرية         "));
        itemList.add(new titleDate("حكم عن المرأة         "));

        itemList.add(new titleDate("حكم عن الصداقة         "));
        itemList.add(new titleDate("حكم عن الصمت         ")); //30
        itemList.add(new titleDate("حكم عن الفراق         "));
        itemList.add(new titleDate("حكم عن العلم         "));
        itemList.add(new titleDate("حكم عن الظلم         "));
        itemList.add(new titleDate("حكم عن الصدق         "));
        itemList.add(new titleDate("حكم عن النجاح         "));
        itemList.add(new titleDate("حكم عن المال         "));
        itemList.add(new titleDate("حكم عن الموت         "));
        itemList.add(new titleDate("حكم عن الوقت         "));

        itemList.add(new titleDate("حكم و كلام عن الحزن         ")); //40
        itemList.add(new titleDate("حكم عن الغضب         "));
        itemList.add(new titleDate("حكم عن التاريخ         "));
        itemList.add(new titleDate("حكم عن العمل         "));
        itemList.add(new titleDate("حكم عن العمر         "));
        itemList.add(new titleDate("كلام عن الخيانة         "));
        itemList.add(new titleDate("حكم عن الوفاء         "));
        itemList.add(new titleDate("حكم عن السياسة         "));
        itemList.add(new titleDate("حكم عن السعادة         "));
        itemList.add(new titleDate("حكم عن الدنيا         "));

        itemList.add(new titleDate("حكم عن الانسان")); //50
        itemList.add(new titleDate("حكم عن القرآن"));
        itemList.add(new titleDate("حكم عن الغاية"));
        itemList.add(new titleDate("حكم عن البلاد"));
        itemList.add(new titleDate("حكم عن الإسلام"));
        itemList.add(new titleDate("حكم عن الكذب"));
        itemList.add(new titleDate("حكم عن الزواج"));
        itemList.add(new titleDate("حكم عن الصبر"));
        itemList.add(new titleDate("حكم عن القلب"));
        itemList.add(new titleDate("حكم عن النساء"));

        itemList.add(new titleDate("حكم عن الحقيقة")); // 60
        itemList.add(new titleDate("حكم عن الوطن"));
        itemList.add(new titleDate("حكم عن الصلاة"));
        itemList.add(new titleDate("حكم عن الناس"));
        itemList.add(new titleDate("حكم عن النوم"));
        itemList.add(new titleDate("حكم عن التسامح"));
        itemList.add(new titleDate("حكم عن الثقة بالنفس"));
        itemList.add(new titleDate("حكم عن التعاون"));
        itemList.add(new titleDate("حكم عن السلام"));
        itemList.add(new titleDate("حكم عن الشجاعة"));

        itemList.add(new titleDate("حكم عن القراءة و الكتب")); // 70
        itemList.add(new titleDate("حكم عن الاحترام"));
        itemList.add(new titleDate("كلام عن السفر"));
        itemList.add(new titleDate("حكم عن الطموح"));
        itemList.add(new titleDate("حكم عن الذكاء"));
        itemList.add(new titleDate("حكم عن العقل"));
        itemList.add(new titleDate("كلام عن الخداع"));
        itemList.add(new titleDate("حكم عن الكرم"));
        itemList.add(new titleDate("كلام عن الندم"));
        itemList.add(new titleDate("حكم عن الفقر"));

        itemList.add(new titleDate("حكم عن الاعتذار")); // 80
        itemList.add(new titleDate("كلام عن الغيرة"));
        itemList.add(new titleDate("كلام عن النسيان"));
        itemList.add(new titleDate("كلام عن الكرامة"));
        itemList.add(new titleDate("حكم عن بر الوالدين"));
        itemList.add(new titleDate("حكم عن النفاق"));
        itemList.add(new titleDate("كلام عن البعد"));
        itemList.add(new titleDate("حكم عن الحياء"));
        itemList.add(new titleDate("كلام عن الغرور"));
        itemList.add(new titleDate("اقوال عن الحق"));

        itemList.add(new titleDate("كلام عن الكبرياء")); // 90
        itemList.add(new titleDate("حكم عن العزيمة"));
        itemList.add(new titleDate("حكم عن العبقرية"));
        itemList.add(new titleDate("حكم عن الطاعة"));
        itemList.add(new titleDate("حكم عن المثابرة"));
        itemList.add(new titleDate("حكم عن الثروة"));
        itemList.add(new titleDate("حكم عن الإتقان"));
        itemList.add(new titleDate("حكم عن السرور"));
        itemList.add(new titleDate("حكم عن الاسرة"));
        itemList.add(new titleDate("كلام عن الرزق"));

        itemList.add(new titleDate("حكم عن العفو")); // 100
        itemList.add(new titleDate("اقوال عن الثقافة"));
        itemList.add(new titleDate("حكم عن الهجرة"));
        itemList.add(new titleDate("كلام عن الوداع"));
        itemList.add(new titleDate("حكم عن التعليم"));
        itemList.add(new titleDate("كلام عن التوبة"));
        itemList.add(new titleDate("حكم عن الصحة"));
        itemList.add(new titleDate("حكم عن القناعة"));
        itemList.add(new titleDate("كلام عن الصديق"));
        itemList.add(new titleDate("كلام عن الوحدة"));

        return itemList;
    }

}
