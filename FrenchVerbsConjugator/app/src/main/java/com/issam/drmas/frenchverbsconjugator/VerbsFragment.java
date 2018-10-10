package com.issam.drmas.frenchverbsconjugator;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerbsFragment extends Fragment {

    @BindView(R.id.recyclerViewMain) RecyclerView recyclerView;

    private CommonRecyclerAdapter adapter;
    private ArrayList<String> title;


    public static Fragment newInstance(Context context){
        VerbsFragment verbsFragment = new VerbsFragment();
        return verbsFragment;
    }

    public VerbsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.content_main, null);
         setUpView(viewGroup);
        return viewGroup;
    }

    private void setUpView(ViewGroup viewGroup) {

        ButterKnife.bind(this, viewGroup);
        setUpList();
    }

    private void setUpList() {

        title = new ArrayList<>();

        title.add("avoir"); //10
        title.add("être");
        title.add("faire");
        title.add("aller");
        title.add("pouvoir");
        title.add("prendre");
        title.add("voir");
        title.add("finir");
        title.add("vouloir");
        title.add("manger");

        title.add("venir"); //20
        title.add("dire");
        title.add("partir");
        title.add("savoir");
        title.add("devoir");
        title.add("mettre");
        title.add("courir");
        title.add("croire");
        title.add("lire");
        title.add("écrire");

        title.add("sortir"); //30
        title.add("aimer");
        title.add("boire");
        title.add("oublier");
        title.add("tenir");
        title.add("apprendre");
        title.add("travailler");
        title.add("appeler");
        title.add("vivre");
        title.add("jouer");

        title.add("falloir"); //40
        title.add("naître");
        title.add("chanter");
        title.add("attendre");
        title.add("acheter");
        title.add("peindre");
        title.add("parler");
        title.add("inviter");
        title.add("arriver");
        title.add("connaître");

        title.add("jeter"); //50
        title.add("envoyer");
        title.add("mourir");
        title.add("réussir");
        title.add("grandir");
        title.add("rire");
        title.add("taire");
        title.add("résoudre");
        title.add("dormir");
        title.add("choisir");

        title.add("tomber"); //60
        title.add("craindre");
        title.add("ouvrir");
        title.add("passer");
        title.add("asseoir");
        title.add("rester");
        title.add("comprendre");
        title.add("crier");
        title.add("devenir");
        title.add("suivre");

        title.add("commencer"); //70
        title.add("entendre");
        title.add("vendre");
        title.add("essayer");
        title.add("payer");
        title.add("sentir");
        title.add("rendre");
        title.add("apercevoir");
        title.add("regarder");
        title.add("penser");

        title.add("réfléchir"); //80
        title.add("marcher");
        title.add("revenir");
        title.add("descendre");
        title.add("offrir");
        title.add("cueillir");
        title.add("répondre");
        title.add("paraître");
        title.add("perdre");
        title.add("conduire");

        title.add("valoir"); //90
        title.add("fuir");
        title.add("remplir");
        title.add("trouver");
        title.add("joindre");
        title.add("plaire");
        title.add("rougir");
        title.add("donner");
        title.add("écouter");
        title.add("battre");

        title.add("coudre"); //100
        title.add("acquérir");
        title.add("permettre");
        title.add("obéir");
        title.add("danser");
        title.add("sourire");
        title.add("rentrer");
        title.add("lancer");
        title.add("demander");
        title.add("lever");

        title.add("servir"); //110
        title.add("entrer");
        title.add("pleuvoir");
        title.add("monter");
        title.add("étudier");
        title.add("éteindre");
        title.add("nager");
        title.add("atteindre");
        title.add("ranger");
        title.add("découvrir");

        title.add("respecter"); //120
        title.add("conseiller");
        title.add("créer");
        title.add("vaincre");
        title.add("saisir");
        title.add("agir");
        title.add("nettoyer");
        title.add("apparaître");
        title.add("mentir");
        title.add("placer");

        title.add("voyager"); //130
        title.add("prévoir");
        title.add("construire");
        title.add("arrêter");
        title.add("souvenir");
        title.add("laver");
        title.add("souhaiter");
        title.add("signer");
        title.add("laisser");
        title.add("rejoindre");

        title.add("retenir"); //140
        title.add("bâtir");
        title.add("préparer");
        title.add("nourir");
        title.add("essuayer");
        title.add("changer");
        title.add("moudre");
        title.add("gagner");
        title.add("décider");
        title.add("punir");

        title.add("disparaître"); //150
        title.add("sauter");
        title.add("chercher");
        title.add("porter");
        title.add("employer");
        title.add("conclure");
        title.add("télécharger");
        title.add("obtenir");
        title.add("parvenir");
        title.add("croître");

        title.add("revoir"); //160
        title.add("avancer");
        title.add("grossir");
        title.add("plaindre");
        title.add("pleurer");
        title.add("conjuguer");
        title.add("habiter");
        title.add("bondir");
        title.add("salir");
        title.add("réunir");

        title.add("retourner"); //170
        title.add("appuyer");
        title.add("montrer");
        title.add("souffrir");
        title.add("balayer");
        title.add("parcourir");
        title.add("espérer");
        title.add("convaincre");
        title.add("apporter");
        title.add("accueillir");

        title.add("applaudir"); //180
        title.add("subir");
        title.add("établir");
        title.add("bavarder");
        title.add("fournir");
        title.add("rencontrer");
        title.add("apprécier");
        title.add("continuer");
        title.add("plier");
        title.add("mordre");

        title.add("couvrir"); //190
        title.add("franchir");
        title.add("tuer");
        title.add("rêver");
        title.add("macher");
        title.add("bouillir");
        title.add("promener");
        title.add("aider");
        title.add("guérir");
        title.add("fermer");

        title.add("promettre"); //200
        title.add("préférer");
        title.add("abaisser");
        title.add("téléphoner");
        title.add("partager");
        title.add("abattre");
        title.add("avertir");
        title.add("dissoudre");
        title.add("amener");
        title.add("défaire");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommonRecyclerAdapter(title);
        recyclerView.setAdapter(adapter);
    }

    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() > 1){
            getFragmentManager().popBackStack();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }


}
