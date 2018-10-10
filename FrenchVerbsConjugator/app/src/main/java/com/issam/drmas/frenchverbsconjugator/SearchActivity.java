package com.issam.drmas.frenchverbsconjugator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommonRecyclerAdapter adapter;

    private EditText editText;
    private ArrayList<String> title;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        adView = findViewById(R.id.adViewSearch);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        recyclerView = findViewById(R.id.recyclerSearch);
        editText = findViewById(R.id.editTextSearch);

        title = new ArrayList<>();

        title.add("abaisser"); //6
        title.add("abandonner");
        title.add("abasoudir");
        title.add("abattre");
        title.add("abêtir");
        title.add("abhorrer");

        title.add("abîmer"); //12
        title.add("ablolir");
        title.add("abonder");
        title.add("abonner");
        title.add("aborder");
        title.add("aboutir");

        title.add("aboyer"); //18
        title.add("abréger");
        title.add("abreuver");
        title.add("abriter");
        title.add("abrutir");
        title.add("absenter");

        title.add("absoudre"); //24
        title.add("abstenir");
        title.add("abstraire");
        title.add("abuser");
        title.add("accabler");
        title.add("accaparer");

        title.add("accéder"); //30
        title.add("accélérer");
        title.add("accentuer");
        title.add("accepter");
        title.add("accoler");
        title.add("accommoder");

        title.add("accompagner");
        title.add("accomplir"); // 36
        title.add("accorder");
        title.add("accoucher");
        title.add("accourir");
        title.add("accrocher");

        title.add("accroire"); //42
        title.add("accroître");
        title.add("accroupir");
        title.add("accueillir");
        title.add("accumuler");
        title.add("accuser");

        title.add("acharner"); // 48
        title.add("acheminer");
        title.add("acheter");
        title.add("achever");
        title.add("aciérer");
        title.add("aciseler");

        title.add("acquérir"); //54
        title.add("acquiescer");
        title.add("acquitter");
        title.add("acter");
        title.add("activer");
        title.add("actualiser");

        title.add("adapter"); //60
        title.add("additionner");
        title.add("adhérer");
        title.add("adire");
        title.add("adjoindre");
        title.add("admettre");

        title.add("administrer"); //66
        title.add("admirer");
        title.add("adonner");
        title.add("adopter");
        title.add("adore");
        title.add("adoucir");

        title.add("adresser"); //72
        title.add("advenir");
        title.add("aérer");
        title.add("affaiblir");
        title.add("affecter");
        title.add("affectionner");

        title.add("afférer"); //78
        title.add("affermir");
        title.add("afficher");
        title.add("affiner");
        title.add("affirmer");
        title.add("affliger");

        title.add("affoler"); //86
        title.add("affranchir");
        title.add("affronter");
        title.add("agacer");
        title.add("agenouiller");
        title.add("aggraver");

        title.add("agir"); //92
        title.add("agiter");
        title.add("agonir");
        title.add("agrafer");
        title.add("agrandir");
        title.add("agréger");

        title.add("agresser"); //98
        title.add("agresser");
        title.add("agripper");
        title.add("aguerrir");
        title.add("aider");
        title.add("aiguiller");

        title.add("aiguiser"); //102
        title.add("ailler");
        title.add("aimer");
        title.add("airer");
        title.add("ajouter");
        title.add("alerter");

        title.add("aliéner"); //108
        title.add("aligner");
        title.add("alimenter");
        title.add("aliter");
        title.add("allécher");
        title.add("alléger");

        title.add("alléguer"); //116
        title.add("aller");
        title.add("allier");
        title.add("allonger");
        title.add("allouer");
        title.add("allumer");

        title.add("alourdir"); //122
        title.add("altérer");
        title.add("aluner");
        title.add("alunir");
        title.add("amaarrer");
        title.add("amasser");

        title.add("améliorer"); //128
        title.add("aménager");
        title.add("amener");
        title.add("amenuiser");
        title.add("amerrir");
        title.add("amoindrir");

        title.add("amonceler"); //134
        title.add("amorcer");
        title.add("amortir");
        title.add("amourer");
        title.add("amplifier");
        title.add("amuïr");

        title.add("amuser"); //140
        title.add("analyser");
        title.add("anéantir");
        title.add("animer");
        title.add("annihiler");
        title.add("annoncer");

        title.add("annoter"); //146
        title.add("annuler");
        title.add("anticiper");
        title.add("apaiser");
        title.add("apercevoir");
        title.add("apeurer");

        title.add("apitoyer"); //152
        title.add("aplanir");
        title.add("aplatir");
        title.add("apparaître");
        title.add("apparenter");
        title.add("apparier");

        title.add("apparoir"); //158
        title.add("appartenir");
        title.add("appauvrir");
        title.add("appeler");
        title.add("appendre");
        title.add("applaudir");

        title.add("appliquer"); //166
        title.add("apporter");
        title.add("apposer");
        title.add("apprécier");
        title.add("appréhender");
        title.add("apprendre");

        title.add("apprêter"); //172
        title.add("approcher");
        title.add("approfondir");
        title.add("approprier");
        title.add("approuver");
        title.add("approvisonner");

        title.add("appuyer"); //178
        title.add("arborer");
        title.add("arguer");
        title.add("arracher");
        title.add("arranger");
        title.add("arrêter");

        title.add("arriver"); //184
        title.add("arrondir");
        title.add("arroser");
        title.add("aspirer");
        title.add("assagir");
        title.add("assaillir");

        title.add("assainir"); //190
        title.add("assassiner");
        title.add("assembler");
        title.add("assener");
        title.add("asséner");
        title.add("asseoir");

        title.add("asservir"); //196
        title.add("assiéger");
        title.add("assimiler");
        title.add("assister");
        title.add("associer");
        title.add("assombrir");

        title.add("assomer"); //212
        title.add("assortir");
        title.add("assoupir");
        title.add("assouplir");
        title.add("assouvir");
        title.add("assujettir");

        title.add("assumer");
        title.add("assurer"); //218
        title.add("astreindre");
        title.add("attacher");
        title.add("attaquer");
        title.add("attarder");

        title.add("atteindre"); //224
        title.add("atteler");
        title.add("attendre");
        title.add("attendrir");
        title.add("attenter");
        title.add("atterrer");

        title.add("atterrir");
        title.add("attester");
        title.add("attirer"); //230
        title.add("attiser");
        title.add("attraper");
        title.add("attribuer");

        title.add("augmenter"); //236
        title.add("autoriser");
        title.add("autosuggestionner");
        title.add("avaler");
        title.add("avancer");
        title.add("aventurer");

        title.add("avérer"); //229
        title.add("avertir");
        title.add("aviser");
        title.add("avoir");
        title.add("avouer");
        title.add("avoyer");
        title.add("axer");

        /*
        Finished of array A
        */

        title.add("baigner"); //12
        title.add("bailler");
        title.add("bâiller");
        title.add("baisser");
        title.add("balader");
        title.add("balancer");

        title.add("balayer");
        title.add("balbutier");
        title.add("bander");
        title.add("bannir");
        title.add("baptiser");
        title.add("barrer");

        title.add("barrier"); //24
        title.add("basculer");
        title.add("baser");
        title.add("bâter");
        title.add("bâtir");
        title.add("battre");

        title.add("bavarder");
        title.add("baver");
        title.add("bayer");
        title.add("béer");
        title.add("bégayer");
        title.add("bêler");

        title.add("bénéficier"); //36
        title.add("bénir");
        title.add("bercer");
        title.add("besogner");
        title.add("bienvenir");
        title.add("biner");

        title.add("biper");
        title.add("biser");
        title.add("blaguer");
        title.add("blâmer");
        title.add("blanchir");
        title.add("blêmir");

        title.add("blesser"); //48
        title.add("bleuir");
        title.add("bloquer");
        title.add("blottir");
        title.add("boire");
        title.add("boiser");

        title.add("boiter");
        title.add("bîter");
        title.add("bonder");
        title.add("bondir");
        title.add("bonfier");
        title.add("bosser");

        title.add("botter"); //60
        title.add("boucher");
        title.add("bouder");
        title.add("bouffer");
        title.add("bouger");
        title.add("bouillir");

        title.add("bouler");
        title.add("bouleverser");
        title.add("bourrer");
        title.add("bousculer");
        title.add("bouter");
        title.add("braire");

        title.add("bramer"); //70
        title.add("brancher");
        title.add("brandir");
        title.add("branler");
        title.add("brayer");
        title.add("breveter");

        title.add("bricoler");
        title.add("briller");
        title.add("brimbaler");
        title.add("briser");

        title.add("bronzer"); //80
        title.add("brosser");
        title.add("brouter");
        title.add("broyer");
        title.add("bruire");
        title.add("brûler");
        title.add("brumer");

        title.add("brunir");
        title.add("budgéter");
        title.add("buriner");

        /*
        Finished of array B
         */

        title.add("cacher"); //12
        title.add("cacheter");
        title.add("calculer");
        title.add("caler");
        title.add("calmer");
        title.add("caner");

        title.add("capeler");
        title.add("caper");
        title.add("capter");
        title.add("caqueter");
        title.add("caractériser");
        title.add("caresser");

        title.add("carreler"); //24
        title.add("caser");
        title.add("casser");
        title.add("causer");
        title.add("caver");
        title.add("céder");
        title.add("ceindre");

        title.add("célébrer");
        title.add("celer");
        title.add("cerner");
        title.add("certifier");
        title.add("cesser");

        title.add("chahuter"); //36
        title.add("chaloir");
        title.add("chanceler");
        title.add("changer");
        title.add("chanter");
        title.add("charger");
        title.add("charmer");

        title.add("charrier");
        title.add("chasser");
        title.add("châtier");
        title.add("chauffer");
        title.add("chausser");

        title.add("chercher"); //48
        title.add("chérir");
        title.add("cherrer");
        title.add("chevaucher");
        title.add("chialer");
        title.add("choir");

        title.add("choisir");
        title.add("choper");
        title.add("choquer");
        title.add("choyer");
        title.add("chuchoter");
        title.add("chuter");

        title.add("circoncire"); //60
        title.add("circoncrire");
        title.add("circuler");
        title.add("cirer");
        title.add("ciseler");
        title.add("citer");

        title.add("claquer");
        title.add("clarifier");
        title.add("classer");
        title.add("clignoter");
        title.add("cliquer");
        title.add("cloner");

        title.add("clore"); //72
        title.add("clôturer");
        title.add("clouer");
        title.add("cocher");
        title.add("côcher");
        title.add("cogiter");

        title.add("cogner");
        title.add("coiffer");
        title.add("coincer");
        title.add("coïncider");
        title.add("collaborer");
        title.add("collecter");

        title.add("collectionner"); //84
        title.add("coller");
        title.add("colorer");
        title.add("colorier");
        title.add("combattre");
        title.add("combiner");
        title.add("combler");

        title.add("commander");
        title.add("commencer");
        title.add("commenter");
        title.add("commercer");
        title.add("commettre");

        title.add("communiquer"); //96
        title.add("comparaître");
        title.add("comparer");
        title.add("compatir");
        title.add("compenser");
        title.add("compiler");
        title.add("complaire");

        title.add("compléter");
        title.add("complexifier");
        title.add("compliquer");
        title.add("comporter");
        title.add("composer");

        title.add("comprendre"); //108
        title.add("compromettre");
        title.add("compter");
        title.add("concéder");
        title.add("concentrer");
        title.add("concerner");

        title.add("concevoir");
        title.add("concillier");
        title.add("conclure");
        title.add("concourir");
        title.add("concurrencer");
        title.add("condamner");

        title.add("conditionner"); //124
        title.add("conduire");
        title.add("confectionner");
        title.add("conférer");
        title.add("confesser");
        title.add("confier");

        title.add("configuer");
        title.add("confire");
        title.add("confirmer");
        title.add("confondre");
        title.add("conformer");
        title.add("confronter");

        title.add("congeler"); //236
        title.add("conjoindre");
        title.add("conjuguer");
        title.add("conjurer");
        title.add("connaître");
        title.add("connecter");

        title.add("conquérir");
        title.add("consacrer");
        title.add("conseiller");
        title.add("consentir");
        title.add("conserver");
        title.add("considérer");

        title.add("consister"); //248
        title.add("consoler");
        title.add("consommer");
        title.add("constater");
        title.add("constituer");
        title.add("construire");

        title.add("consulter");
        title.add("consumer");
        title.add("contacter");
        title.add("contempler");
        title.add("contenir");
        title.add("contenter");

        title.add("conter"); //260
        title.add("continuer");
        title.add("contraindre");
        title.add("contrarier");
        title.add("contredire");
        title.add("contrefaire");

        title.add("contrer");
        title.add("contrevenir");
        title.add("contribuer");
        title.add("contrôler");
        title.add("convaincre");
        title.add("convenir");

        title.add("convertir"); //272
        title.add("convier");
        title.add("convoiter");
        title.add("convoquer");
        title.add("convoyer");
        title.add("coppérer");

        title.add("coordonner");
        title.add("copier");
        title.add("corr&ler");
        title.add("correspondre");
        title.add("corriger");
        title.add("corroborer");

        title.add("corrompre"); //284
        title.add("coter");
        title.add("cotiser");
        title.add("côtoyer");
        title.add("coucher");
        title.add("coudre");

        title.add("couiner");
        title.add("couler");
        title.add("couper");
        title.add("courbaturer");
        title.add("courir");
        title.add("courre");

        title.add("coûter"); //296
        title.add("couver");
        title.add("couvrir");
        title.add("cracher");
        title.add("craindre");
        title.add("cramer");

        title.add("craquer");
        title.add("créditer");
        title.add("créer");
        title.add("creuser");
        title.add("crever");
        title.add("crier");

        title.add("critiquer"); //304
        title.add("croire");
        title.add("croiser");
        title.add("croître");
        title.add("croquer");
        title.add("crosser");

        title.add("crotter");
        title.add("croupir");
        title.add("cuillir");
        title.add("cuire");
        title.add("cuisiner");
        title.add("cultiver");
        title.add("cumuler");
        title.add("curer");

         /*
        Finished C
         */

        title.add("daigner"); //12
        title.add("daller");
        title.add("damer");
        title.add("damner");
        title.add("danser");
        title.add("dater");

        title.add("déballer");
        title.add("debarquer");
        title.add("débarrasser");
        title.add("débattre");
        title.add("débiter");
        title.add("déblatérer");

        title.add("déblayer"); //24
        title.add("débloquer");
        title.add("déborder");
        title.add("déboucher");
        title.add("débouillir");
        title.add("débouiller");
        title.add("débuter");

        title.add("décaler");
        title.add("décéder");
        title.add("déceler");
        title.add("décevoir");
        title.add("décharger");

        title.add("déchiqueter"); //36
        title.add("déchirer");
        title.add("déchoir");
        title.add("décider");
        title.add("déclarer");
        title.add("déclencher");

        title.add("décliner");
        title.add("décoller");
        title.add("décommettre");
        title.add("déconner");
        title.add("décorer");
        title.add("découdre");

        title.add("découper"); //48
        title.add("décourager");
        title.add("découvrir");
        title.add("décrier");
        title.add("décrire");
        title.add("décrocher");
        title.add("décroître");

        title.add("dédicacer");
        title.add("dédier");
        title.add("dédire");
        title.add("déduire");
        title.add("défaillir");

        title.add("défaire"); // 60
        title.add("défendre");
        title.add("défier");
        title.add("défiler");
        title.add("définir");
        title.add("défoncer");

        title.add("défrayer");
        title.add("dégager");
        title.add("dégeler");
        title.add("dégénérer");
        title.add("déglutir");
        title.add("dégourdir");

        title.add("dégoûter"); //72
        title.add("déguerpir");
        title.add("déguster");
        title.add("déjeuner");
        title.add("délayer");
        title.add("déléguer");

        title.add("délier");
        title.add("délivrer");
        title.add("demander");
        title.add("démanteler");
        title.add("démarrer");
        title.add("déménager");

        title.add("démener"); //84
        title.add("démentir");
        title.add("démettre");
        title.add("demeurer");
        title.add("démissionner");
        title.add("démolir");

        title.add("démontrer");
        title.add("démordre");
        title.add("démunir");
        title.add("dénier");
        title.add("dénigrer");
        title.add("dénoncer");

        title.add("dénuer"); //96
        title.add("dépanner");
        title.add("départir");
        title.add("dépasser");
        title.add("sépecer");
        title.add("dépêcher");

        title.add("dépeindre");
        title.add("dépendre");
        title.add("dépenser");
        title.add("dépérir");
        title.add("déplacer");
        title.add("déplaire");

        title.add("déplier"); //108
        title.add("déployer");
        title.add("déposer");
        title.add("déprimer");
        title.add("déranger");
        title.add("déraper");

        title.add("déroger");
        title.add("dérouler");
        title.add("désapprendre");
        title.add("descendre");
        title.add("désespérer");
        title.add("déshabiller");

        title.add("désigner"); //119
        title.add("désirer");
        title.add("désister");
        title.add("désobéir");
        title.add("désler");
        title.add("dessaisir");

        title.add("desservir");
        title.add("dessiner");
        title.add("détacher");
        title.add("détailler");
        title.add("détaler");

        title.add("détecter"); //132
        title.add("déteindre");
        title.add("détendre");
        title.add("détenir");
        title.add("détériorer");
        title.add("déterminer");

        title.add("détester");
        title.add("détruire");
        title.add("devacer");
        title.add("développer");
        title.add("devenir");
        title.add("dévêtir");

        title.add("dévier"); //144
        title.add("deviner");
        title.add("dévoiler");
        title.add("devoir");
        title.add("dévorer");
        title.add("dévouer");
        title.add("dévoyer");

        title.add("diagnostiquer");
        title.add("dialoguer");
        title.add("dicter");
        title.add("différencier");
        title.add("diffférer");

        title.add("diffuser"); //155
        title.add("digérer");
        title.add("diluer");
        title.add("diminuer");
        title.add("dîner");
        title.add("dire");

        title.add("diriger");
        title.add("disconvenir");
        title.add("discourir");
        title.add("discuter");
        title.add("disparaître");

        title.add("dispenser"); //168
        title.add("disperser");
        title.add("disposer");
        title.add("disputer");
        title.add("dissiper");
        title.add("dissoudre");

        title.add("distinguer");
        title.add("distraire");
        title.add("distribuer");
        title.add("diverger");
        title.add("divertir");
        title.add("diviser");

        title.add("divorcer"); //180
        title.add("divulguer");
        title.add("doigter");
        title.add("doler");
        title.add("dominer");
        title.add("donner");

        title.add("doper");
        title.add("dorer");
        title.add("dorloter");
        title.add("dormir");
        title.add("doter");
        title.add("doubler");

        title.add("doucher");
        title.add("douer");
        title.add("draguer");
        title.add("draper");
        title.add("dresser");
        title.add("duper");

        title.add("dupliquer");
        title.add("durcir");
        title.add("durer");

         /*
         Finished D
          */

        title.add("ébahir"); //12
        title.add("ébaire");
        title.add("éberluer");
        title.add("éblouir");
        title.add("échanger");
        title.add("échapper");

        title.add("écher");
        title.add("échoir");
        title.add("échouer");
        title.add("éclabousser");
        title.add("éclaircir");
        title.add("éclairer");

        title.add("éclater"); //24
        title.add("éclore");
        title.add("écoeirer");
        title.add("éconduire");
        title.add("écouler");
        title.add("écouter");

        title.add("écraser");
        title.add("écrier");
        title.add("écrire");
        title.add("éditer");
        title.add("éduquer");
        title.add("effacer");

        title.add("effectuer"); //36
        title.add("effeurer");
        title.add("effondrer");
        title.add("efforcer");
        title.add("effrayer");
        title.add("égaler");

        title.add("égarer");
        title.add("égayer");
        title.add("égoutter");
        title.add("égrainer");
        title.add("égrener");
        title.add("éjaculer");

        title.add("élaborer"); //48
        title.add("élaguer");
        title.add("élancer");
        title.add("élargir");
        title.add("élever");
        title.add("éliminer");

        title.add("élire");
        title.add("éloigner");
        title.add("émaner");
        title.add("emballer");
        title.add("embarquer");
        title.add("embarrasser");

        title.add("embatre"); //60
        title.add("embaucher");
        title.add("embellir");
        title.add("embêter");
        title.add("emboire");
        title.add("embraser");

        title.add("embrasser");
        title.add("embrayer");
        title.add("emerger");
        title.add("emettre");
        title.add("émier");
        title.add("emmêler");

        title.add("emménager"); //72
        title.add("emmener");
        title.add("émoudre");
        title.add("émouvoir");
        title.add("emparer");
        title.add("empêcher");

        title.add("empiéter");
        title.add("empirer");
        title.add("empirer");
        title.add("employer");
        title.add("emporter");
        title.add("empreindre");

        title.add("empresser"); //84
        title.add("empruner");
        title.add("émuler");
        title.add("encaisser");
        title.add("enchaîner");
        title.add("enchanter");

        title.add("enchérir");
        title.add("enclore");
        title.add("encourager");
        title.add("encourir");
        title.add("endommager");
        title.add("endormir");

        title.add("enduire"); //96
        title.add("endurer");
        title.add("énerver");
        title.add("enfermer");
        title.add("enfiler");
        title.add("enflammer");

        title.add("enfler");
        title.add("enfoncer");
        title.add("enfouir");
        title.add("enfreindre");
        title.add("enfuir");
        title.add("engager");

        title.add("engendrer"); //104
        title.add("engloutir");
        title.add("engueuler");
        title.add("enivrer");
        title.add("enjoindre");
        title.add("enlacer");
        title.add("enlever");

        title.add("ennoyer");
        title.add("ennuyer");
        title.add("énoncer");
        title.add("enorgueillir");
        title.add("énouer");

        title.add("enquérir"); //116
        title.add("enquêter");
        title.add("enrayer");
        title.add("enregistrer");
        title.add("enrhumer");
        title.add("enrichir");

        title.add("enseigner");
        title.add("ensevlir");
        title.add("ensorceler");
        title.add("entacher");
        title.add("entamer");
        title.add("entendre");

        title.add("enter"); //132
        title.add("entériner");
        title.add("enterrer");
        title.add("enthousiasmer");
        title.add("entourer");
        title.add("entraîner");

        title.add("entreprendre");
        title.add("entrer");
        title.add("entretenir");
        title.add("entrevoir");
        title.add("entrouvrir");
        title.add("énucléer");

        title.add("énumérer"); //144
        title.add("envahir");
        title.add("envelopper");
        title.add("envier");
        title.add("envisager");
        title.add("envoler");

        title.add("envoyer");
        title.add("épaissir");
        title.add("épandre");
        title.add("épanouir");
        title.add("épargner");
        title.add("épater");

        title.add("épeler"); //156
        title.add("épier");
        title.add("épiner");
        title.add("éplucher");
        title.add("épouser");
        title.add("épousseter");

        title.add("éprendre");
        title.add("éprouver");
        title.add("épuiser");
        title.add("équiser");
        title.add("équiper");
        title.add("errer");

        title.add("escalader"); //168
        title.add("espérer");
        title.add("essayer");
        title.add("essouffler");
        title.add("essuyer");
        title.add("estimer");

        title.add("établir");
        title.add("étaler");
        title.add("étayer");
        title.add("éteindre");
        title.add("étendre");
        title.add("éternuer");

        title.add("étinceler"); //179
        title.add("étiqueter");
        title.add("étirer");
        title.add("étoffer");
        title.add("étonner");
        title.add("étouffer");

        title.add("étourdir");
        title.add("être");
        title.add("étrécir");
        title.add("étreindre");
        title.add("étrenner");

        title.add("évacuer"); //192
        title.add("évader");
        title.add("évaluer");
        title.add("évanouir");
        title.add("éveiller");
        title.add("éviter");

        title.add("évoluer");
        title.add("évoquer");
        title.add("éxagérer");
        title.add("examiner");
        title.add("exaucer");
        title.add("excéder");

        title.add("exceller"); //104
        title.add("exciter");
        title.add("exclamer");
        title.add("exclure");
        title.add("excuser");
        title.add("exécrer");

        title.add("exécuter");
        title.add("exempter");
        title.add("exercer");
        title.add("exiger");
        title.add("exister");
        title.add("expédier");

        title.add("expirer"); //113
        title.add("expliquer");
        title.add("exploiter");
        title.add("explorer");
        title.add("exploser");
        title.add("exposer");

        title.add("exrimer");
        title.add("extaiser");
        title.add("extraire");

         /*
         Finished E
          */

        title.add("fabriquer"); //12
        title.add("fâcher");
        title.add("faciliter");
        title.add("façonner");
        title.add("facturer");
        title.add("fader");

        title.add("faiblir");
        title.add("failler");
        title.add("faillir");
        title.add("faire");
        title.add("faloir");
        title.add("familiariser");

        title.add("fander"); //24
        title.add("farcir");
        title.add("fasciner");
        title.add("fatiguer");
        title.add("fauter");
        title.add("favoriser");

        title.add("faxer");
        title.add("feindre");
        title.add("fêler");
        title.add("félicter");
        title.add("fendre");
        title.add("fermer");

        title.add("festoyer"); //36
        title.add("fêter");
        title.add("feuilleter");
        title.add("fiancer");
        title.add("ficeler");
        title.add("ficher");

        title.add("fier");
        title.add("figer");
        title.add("figurer");
        title.add("filer");
        title.add("filmer");
        title.add("finaliser");

        title.add("finir"); //48
        title.add("fixer");
        title.add("flamboyer");
        title.add("flâner");
        title.add("flatter");
        title.add("fléchir");

        title.add("fleurir");
        title.add("flûter");
        title.add("foirer");
        title.add("foncer");
        title.add("fonctionner");
        title.add("fonder");

        title.add("fondre"); //60
        title.add("forcer");
        title.add("forer");
        title.add("forger");
        title.add("formater");
        title.add("former");

        title.add("formuler");
        title.add("foudroyer");
        title.add("fouetter");
        title.add("fouiller");
        title.add("fouir");
        title.add("fournir");

        title.add("fourvoyer"); //72
        title.add("foutre");
        title.add("fraîchir");
        title.add("franchir");
        title.add("frapper");
        title.add("frayer");

        title.add("freiner");
        title.add("frémir");
        title.add("fréquenter");
        title.add("froisser");
        title.add("frôler");
        title.add("frotter");

        title.add("fuir"); //79
        title.add("fumer");
        title.add("fureter");
        title.add("fuser");
        title.add("fusionner");

        /*
         Finished F
         */

        title.add("gâcher");
        title.add("gager");
        title.add("gagber");
        title.add("galoper");
        title.add("garntir");
        title.add("garder");
        title.add("garer");

        title.add("garnir");
        title.add("gaspiller");
        title.add("gâter");
        title.add("gazer");
        title.add("geindre");
        title.add("geler");

        title.add("gémir");
        title.add("gêner");
        title.add("générer");
        title.add("gérer");
        title.add("gîter");
        title.add("glacer");

        title.add("glander");
        title.add("glisser");
        title.add("gonfler");
        title.add("gourer");
        title.add("goûter");
        title.add("grandir");

        title.add("grasseyer");
        title.add("gratter");
        title.add("graver");
        title.add("gravir");
        title.add("gréer");
        title.add("grever");

        title.add("gréver");
        title.add("grignoter");
        title.add("grimper");
        title.add("grogner");
        title.add("gronder");
        title.add("grossir");

        title.add("guérir");
        title.add("guetter");
        title.add("gueuler");
        title.add("guider");

        /*
        finished G
         */

        title.add("habiliter");
        title.add("habiller");
        title.add("habiter");
        title.add("habituer");
        title.add("habler");
        title.add("hacher");

        title.add("haîr");
        title.add("haler");
        title.add("hâler");
        title.add("haleter");
        title.add("halluciner");
        title.add("hanter");

        title.add("happer");
        title.add("harceler");
        title.add("hâter");
        title.add("hausser");
        title.add("haver");
        title.add("havir");

        title.add("héberger");
        title.add("héler");
        title.add("hennir");
        title.add("hériter");
        title.add("hésiter");
        title.add("heurter");

        title.add("homogénéiser");
        title.add("honnir");
        title.add("honorer");
        title.add("houer");
        title.add("huer");
        title.add("humer");
        title.add("humilier");
        title.add("hurler");

         /*
         Finished H
          */

        title.add("identifier"); //12
        title.add("ignorer");
        title.add("illuminer");
        title.add("illustrer");
        title.add("imager");
        title.add("imaginer");

        title.add("imiter");
        title.add("immiscer");
        title.add("impacter");
        title.add("impatienter");
        title.add("implanter");
        title.add("implémenter");

        title.add("impliquer"); //24
        title.add("importer");
        title.add("importuner");
        title.add("imposer");
        title.add("imprégner");
        title.add("impressuinner");

        title.add("imprimer");
        title.add("impaugurer");
        title.add("inaugurer");
        title.add("incliner");
        title.add("inclure");
        title.add("incomber");

        title.add("indiquer"); //36
        title.add("induire");
        title.add("influencer");
        title.add("influer");
        title.add("informer");
        title.add("inhiber");

        title.add("initier");
        title.add("inonder");
        title.add("inquiéter");
        title.add("inscrire");
        title.add("isérer");
        title.add("insinuer");

        title.add("insister"); //48
        title.add("inspirer");
        title.add("installer");
        title.add("instruire");
        title.add("intégrer");
        title.add("intensifier");

        title.add("intergir");
        title.add("interdire");
        title.add("intéresser");
        title.add("interférer");
        title.add("interpeller");
        title.add("interpréter");

        title.add("interroger"); //60
        title.add("interrompre");
        title.add("intervenir");
        title.add("intervertir");
        title.add("interiguer");
        title.add("introduire");

        title.add("inventer");
        title.add("inverser");
        title.add("investiguer");
        title.add("interviewer");
        title.add("investir");
        title.add("inviter");

        title.add("ioder");
        title.add("irriter");
        title.add("isoler");

        /*
        Finished I
         */

        title.add("jaillir"); //15
        title.add("jalouser");
        title.add("japper");
        title.add("jaser");
        title.add("jaunir");
        title.add("jeter");

        title.add("jeûner");
        title.add("joindre");
        title.add("jongler");
        title.add("jouer");
        title.add("jouir");
        title.add("juger");

        title.add("jurer");
        title.add("justifier");
        title.add("juter");

        /*
        Finished J
         */

        title.add("kiffer");
        title.add("koter");

        /*
        Finished K
         */

        title.add("lacer");
        title.add("lâcher");
        title.add("lainer");
        title.add("laisser");
        title.add("lamenter");
        title.add("lamer");

        title.add("lancer");
        title.add("languir");
        title.add("laper");
        title.add("larguer");
        title.add("lasser");
        title.add("laver");

        title.add("lécher");
        title.add("léguer");
        title.add("léser");
        title.add("leurrer");
        title.add("lever");
        title.add("librérer");

        title.add("licérer");
        title.add("licencier");
        title.add("lier");
        title.add("limiter");
        title.add("lire");
        title.add("lister");

        title.add("livrer");
        title.add("loger");
        title.add("longer");
        title.add("lotir");
        title.add("louer");
        title.add("louper");

        title.add("louvoyer");
        title.add("louver");
        title.add("luire");
        title.add("luter");
        title.add("lutter");
        title.add("luxer");

        /*
        Finished L
         */

        title.add("mâcher");
        title.add("maigrir");
        title.add("maintenir");
        title.add("maîtriser");
        title.add("manager");
        title.add("mander");

        title.add("manger");
        title.add("manier");
        title.add("manifester");
        title.add("manipuler");
        title.add("manquer");
        title.add("maquiller");

        title.add("marcher");
        title.add("marier");
        title.add("marquer");
        title.add("marrer");
        title.add("marteler");
        title.add("masser");

        title.add("mater");
        title.add("mâter");
        title.add("maudire");
        title.add("maugréer");
        title.add("mécroire");
        title.add("médire");

        title.add("méditer");
        title.add("méfier");
        title.add("mélenger");
        title.add("mêler");
        title.add("menacer");
        title.add("ménager");

        title.add("mendier");
        title.add("mener");
        title.add("mentionner");
        title.add("mentir");
        title.add("méprendre");
        title.add("mériter");

        title.add("mesurer");
        title.add("métrer");
        title.add("mettre");
        title.add("meuler");
        title.add("meurtir");
        title.add("miauler");

        title.add("migrer");
        title.add("mijoter");
        title.add("mimer");
        title.add("miner");
        title.add("mincir");
        title.add("mirer");

        title.add("miser");
        title.add("modeler");
        title.add("modérer");
        title.add("modifier");
        title.add("moisir");
        title.add("mollir");

        title.add("monnayer");
        title.add("monter");
        title.add("montrer");
        title.add("moquer");
        title.add("mordre");
        title.add("morfondre");

        title.add("motiver");
        title.add("moucher");
        title.add("moudre");
        title.add("mouiller");
        title.add("mouler");
        title.add("mourir");

        title.add("mouver");
        title.add("mouvoir");
        title.add("muer");
        title.add("multiplier");
        title.add("munir");
        title.add("murer");

        title.add("mûrir");
        title.add("murmurer");
        title.add("muser");
        title.add("muter");

        /*
         Finished M
         */

        title.add("nager");
        title.add("naître");
        title.add("narguer");
        title.add("narrer");
        title.add("naviguer");
        title.add("nécessiter");

        title.add("négliger");
        title.add("négocier");
        title.add("nettoyer");
        title.add("nier");
        title.add("niveler");
        title.add("noircir");

        title.add("nominer");
        title.add("nommer");
        title.add("noter");
        title.add("notifier");
        title.add("nouer");
        title.add("nourrir");

        title.add("noyer");
        title.add("nuer");
        title.add("nuire");

        /*
        Finished N
         */

        title.add("obéir");
        title.add("obliger");
        title.add("obscurcir");

        title.add("obséder");
        title.add("observer");
        title.add("obtempérer");
        title.add("obtenir");
        title.add("occaisionner");
        title.add("occire");

        title.add("occlure");
        title.add("occuper");
        title.add("ocrer");
        title.add("octroyer");
        title.add("oeuvrer");
        title.add("offenser");

        title.add("officier");
        title.add("offrir");
        title.add("oindre");
        title.add("omettre");
        title.add("opérer");
        title.add("opposerpter");

        title.add("opter");
        title.add("ordonner");
        title.add("organiser");
        title.add("orienter");
        title.add("orner");
        title.add("osciller");

        title.add("oser");
        title.add("ôter");
        title.add("oublier");
        title.add("ouîr");
        title.add("ourdir");
        title.add("ouvrrer");
        title.add("ouvrir");

        /*
        Finished O
         */

        title.add("pagayer");
        title.add("pager");
        title.add("pâlir");
        title.add("pallier");
        title.add("paner");
        title.add("panner");

        title.add("panser");
        title.add("paraître");
        title.add("paramétre");
        title.add("parcourir");
        title.add("pardonner");
        title.add("parer");

        title.add("parier");
        title.add("parler");
        title.add("parrainer");
        title.add("partager");
        title.add("participer");
        title.add("partir");

        title.add("parvenir");
        title.add("passer");
        title.add("passinner");
        title.add("pâter");
        title.add("patienter");
        title.add("patiner");

        title.add("pâtir");
        title.add("pauser");
        title.add("paver");
        title.add("payer");
        title.add("peaufiner");
        title.add("pêcher");

        title.add("pécher");
        title.add("pédaler");
        title.add("peigner");
        title.add("peindre");
        title.add("peiner");
        title.add("peinture");

        title.add("peler");
        title.add("pelleter");
        title.add("pencher");
        title.add("pendre");
        title.add("pénétrer");
        title.add("penser");
        title.add("percer");

        title.add("percevoir");
        title.add("perdre");
        title.add("perdure");
        title.add("pérenniser");
        title.add("périr");

        title.add("permettre");
        title.add("persévérer");
        title.add("persister");
        title.add("persuder");
        title.add("pertuber");
        title.add("peser");
        title.add("pétrir");

        title.add("photographier");
        title.add("piéger");
        title.add("pifer");
        title.add("pincer");
        title.add("piper");

        title.add("piquer");
        title.add("placer");
        title.add("plaider");
        title.add("plaindre");
        title.add("plaire");
        title.add("plaisanter");
        title.add("planer");

        title.add("planfier");
        title.add("planter");
        title.add("pleurer");
        title.add("pleuvoir");
        title.add("plier");

        title.add("plonger");
        title.add("ployer");
        title.add("poiler");
        title.add("pointer");
        title.add("polir");
        title.add("polluer");

        title.add("pondre");
        title.add("porter");
        title.add("poser");
        title.add("positionner");
        title.add("posséder");
        title.add("poster");

        title.add("postuler");
        title.add("poter");
        title.add("pourrir");
        title.add("poursuivre");
        title.add("pourvoir");
        title.add("pousser");

        title.add("pouvoir");
        title.add("pratiquer");
        title.add("précéder");
        title.add("prêcher");
        title.add("préciter");
        title.add("préciser");

        title.add("préconiser");
        title.add("prédire");
        title.add("préétablir");
        title.add("préférer");
        title.add("prendre");
        title.add("prénommer");

        title.add("préoccuper");
        title.add("préparer");
        title.add("prescrire");
        title.add("présenter");
        title.add("préserver");
        title.add("pressentir");

        title.add("presser");
        title.add("prétendre");
        title.add("prêter");
        title.add("prévaloir");
        title.add("prévenir");
        title.add("prévoir");
        title.add("prier");

        title.add("primer");
        title.add("priser");
        title.add("priver");
        title.add("privilégier");
        title.add("procéder");

        title.add("procurer");
        title.add("prodiguer");
        title.add("produire");
        title.add("profiter");
        title.add("programmer");
        title.add("progresser");

        title.add("projeter");
        title.add("prolonger");
        title.add("promener");
        title.add("promettre");
        title.add("promouvoir");
        title.add("prôner");

        title.add("prononcer");
        title.add("proposer");
        title.add("proscrire");
        title.add("protéger");
        title.add("prouver");
        title.add("prouvenir");
        title.add("provoquer");

        title.add("publier");
        title.add("puer");
        title.add("puiser");
        title.add("pulluler");
        title.add("punir");

        /*
        Finished P
         */

        title.add("qualifier");
        title.add("quémander");
        title.add("questionner");
        title.add("quêter");
        title.add("quitter");

        /*
        Finished Q
         */

        title.add("rabattre");
        title.add("raccourcir");
        title.add("raccrocher");
        title.add("racheter");
        title.add("raconter");
        title.add("raffoler");

        title.add("rafraîchir");
        title.add("rager");
        title.add("raidir");
        title.add("railler");
        title.add("raisonner");
        title.add("rajeunir");

        title.add("rajouter");
        title.add("râler");
        title.add("rallier");
        title.add("ramasser");
        title.add("ramener");

        title.add("ramer");
        title.add("ramollir");
        title.add("ranger");
        title.add("rapatrier");
        title.add("rapetisser");
        title.add("rappeler");

        title.add("rapporter");
        title.add("rapprocher");
        title.add("raser");
        title.add("rassasier");
        title.add("rassembler");
        title.add("rasseoir");

        title.add("rassurer");
        title.add("rater");
        title.add("rattacher");
        title.add("rattraper");
        title.add("ravager");

        title.add("ravir");
        title.add("rayer");
        title.add("rayonner");
        title.add("réagir");
        title.add("réaliser");
        title.add("réapparître");

        title.add("réapprendre");
        title.add("rebondir");
        title.add("recéler");
        title.add("receler");
        title.add("recenser");
        title.add("réceptionner");

        title.add("recevoir");
        title.add("réchauffer");
        title.add("rechercher");
        title.add("réciter");
        title.add("réclamer");
        title.add("récolter");

        title.add("recommander");
        title.add("recommencer");
        title.add("récompenser");
        title.add("réconilier");
        title.add("reconduire");
        title.add("réconforter");

        title.add("reconnaître");
        title.add("reconquérir");
        title.add("reconstruire");
        title.add("recontacter");
        title.add("recopier");
        title.add("recoudre");

        title.add("recourir");
        title.add("recouvrer");
        title.add("recréer");
        title.add("récrire");

        title.add("recruter");
        title.add("rectifier");
        title.add("recueillir");
        title.add("reculer");
        title.add("récupérer");
        title.add("redécouvrir");

        title.add("redémarrer");
        title.add("redescendre");
        title.add("redevenir");
        title.add("redevoir");
        title.add("rédiager");
        title.add("redire");

        title.add("redonner");
        title.add("réduire");
        title.add("réécrire");
        title.add("réélire");
        title.add("réer");
        title.add("réessayer");

        title.add("refaire");
        title.add("référencer");
        title.add("référer");
        title.add("refermer");
        title.add("réflichir");
        title.add("refléter");

        title.add("refroidir");
        title.add("réfugier");
        title.add("refuser");
        title.add("régaler");
        title.add("regarder");
        title.add("régir");

        title.add("réglementer");
        title.add("régler");
        title.add("régner");
        title.add("regretter");
        title.add("regrouper");
        title.add("réinscrire");

        title.add("réitérer");
        title.add("rejeter");
        title.add("rejoindre");
        title.add("réjouir");
        title.add("relâcher");
        title.add("relancer");

        title.add("relater");
        title.add("relayer");
        title.add("relever");
        title.add("relier");
        title.add("relire");

        title.add("remarquer");
        title.add("rembourser");
        title.add("remédier");
        title.add("remémorer");
        title.add("remercier");
        title.add("remettre");

        title.add("remonter");
        title.add("remplacer");
        title.add("remplir");
        title.add("remporter");
        title.add("remuer");

        title.add("rémunérer");
        title.add("renaître");
        title.add("renchérir");
        title.add("rencontrer");
        title.add("redormir");
        title.add("rendre");

        title.add("renforcer");
        title.add("renier");
        title.add("renommer");
        title.add("renoncer");
        title.add("renouveler");
        title.add("renseigner");

        title.add("renter");
        title.add("rentrer");
        title.add("renverser");
        title.add("renvoyer");
        title.add("repaître");
        title.add("répandre");

        title.add("reparaître");
        title.add("réparer");
        title.add("reparler");
        title.add("repartir");
        title.add("répartir");

        title.add("repasser");
        title.add("repeindre");
        title.add("rependre");
        title.add("repentir");
        title.add("repérer");
        title.add("répertorier");

        title.add("répéter");
        title.add("replier");
        title.add("répondre");
        title.add("reporter");
        title.add("reposer");

        title.add("repousser");
        title.add("reprendre");
        title.add("représenter");
        title.add("reprocher");
        title.add("reproduire");
        title.add("requérir");

        title.add("réserver");
        title.add("résider");
        title.add("résilier");
        title.add("résister");
        title.add("résonner");
        title.add("résoudre");

        title.add("respecter");
        title.add("respirer");
        title.add("resplendir");
        title.add("ressaisir");
        title.add("ressayer");
        title.add("ressembler");

        title.add("ressentir");
        title.add("resserrer");
        title.add("resservir");
        title.add("ressortir");
        title.add("ressusciter");
        title.add("restaurer");

        title.add("rester");
        title.add("restreindre");
        title.add("résulter");
        title.add("résumer");
        title.add("rétablir");

        title.add("retarder");
        title.add("retenir");
        title.add("retentir");
        title.add("retirer");
        title.add("retomber");
        title.add("retourner");

        title.add("retranscrire");
        title.add("retransmettre");
        title.add("rétrécir");
        title.add("retrouver");
        title.add("réunir");
        title.add("réussir");

        title.add("rêvasser");
        title.add("réveiller");
        title.add("révéler");
        title.add("revendiquer");
        title.add("revendre");
        title.add("revenir");

        title.add("rêver");
        title.add("revêtir");
        title.add("réviser");
        title.add("revivre");
        title.add("revoir");
        title.add("revouloir");

        title.add("rigoler");
        title.add("rimer");
        title.add("rincer");
        title.add("rire");
        title.add("risquer");
        title.add("rôder");

        title.add("roder");
        title.add("rompre");
        title.add("ronfler");
        title.add("ronger");
        title.add("ronronner");
        title.add("roquer");

        title.add("roser");
        title.add("rôtir");
        title.add("rougir");
        title.add("rouler");
        title.add("rouspéter");
        title.add("rouvrir");

        title.add("ruer");
        title.add("rugir");
        title.add("ruisseler");

        /*
        Finished R
         */

        title.add("sacrifier");
        title.add("saigner");
        title.add("saisir");
        title.add("saler");
        title.add("salir");
        title.add("saloper");

        title.add("saluer");
        title.add("sangloter");
        title.add("saouler");
        title.add("saper");
        title.add("satisfaire");
        title.add("saurer");

        title.add("sauter");
        title.add("sauvegarder");
        title.add("sauver");
        title.add("savoir");
        title.add("savonner");
        title.add("savourer");

        title.add("scanner");
        title.add("sceller");
        title.add("scier");
        title.add("scinder");
        title.add("scruter");
        title.add("sécher");

        title.add("secouer");
        title.add("secourir");
        title.add("séduire");
        title.add("séjourner");
        title.add("sélectionner");
        title.add("seller");

        title.add("sembler");
        title.add("semer");
        title.add("sentir");
        title.add("séparer");
        title.add("serrer");
        title.add("sertir");

        title.add("servir");
        title.add("sévir");
        title.add("sevrer");
        title.add("siéger");
        title.add("siffler");
        title.add("signaler");
        title.add("signer");

        title.add("signifier");
        title.add("simplifier");
        title.add("siroter");
        title.add("situer");
        title.add("skier");

        title.add("soigner");
        title.add("solliciter");
        title.add("solutionner");
        title.add("sommeiller");
        title.add("sommer");
        title.add("songer");

        title.add("sonner");
        title.add("sortir");
        title.add("soucier");
        title.add("souder");
        title.add("soudoyer");
        title.add("souffler");

        title.add("souffrir");
        title.add("souhaiter");
        title.add("soulager");
        title.add("soûler");
        title.add("soulever");
        title.add("souligner");

        title.add("soumettre");
        title.add("soupçonner");
        title.add("souper");
        title.add("soupirer");
        title.add("sourire");
        title.add("sous-entendre");

        title.add("sous-tendre");
        title.add("souscrire");
        title.add("soustraire");
        title.add("soutenir");
        title.add("souvenir");
        title.add("spécifier");

        title.add("statuer");
        title.add("stipuler");
        title.add("stocker");
        title.add("stopper");
        title.add("stresser");
        title.add("stupéfier");

        title.add("subir");
        title.add("subodorer");
        title.add("subsister");
        title.add("substituer");
        title.add("subvenir");
        title.add("succéder");

        title.add("succomber");
        title.add("sucer");
        title.add("suer");
        title.add("suffire");
        title.add("suffoquer");
        title.add("suqqérer");

        title.add("suicider");
        title.add("suivre");
        title.add("suppléer");
        title.add("supplier");
        title.add("supporter");
        title.add("supposer");

        title.add("supprimer");
        title.add("supputer");
        title.add("surfaire");
        title.add("surfer");
        title.add("surgir");
        title.add("surprendre");

        title.add("sursauter");
        title.add("surseoir");
        title.add("surveiller");
        title.add("survenir");
        title.add("survivre");
        title.add("susciter");

        title.add("suspendre");
        title.add("sustenter");
        title.add("susurrer");

        /*
        finished S
         */

        title.add("tacher");
        title.add("tâcher");
        title.add("tailler");
        title.add("taire");
        title.add("taler");
        title.add("tanner");

        title.add("taper");
        title.add("tapir");
        title.add("taquiner");
        title.add("tarder");
        title.add("tarer");
        title.add("tarir");

        title.add("tasser");
        title.add("tâter");
        title.add("tatouer");
        title.add("teindre");
        title.add("teinter");
        title.add("télécharger");

        title.add("téléphoner");
        title.add("témoigner");
        title.add("tendre");
        title.add("tenir");
        title.add("tenter");
        title.add("terminer");

        title.add("ternir");
        title.add("tester");
        title.add("têter");
        title.add("téter");
        title.add("tiédir");
        title.add("tinter");

        title.add("tirer");
        title.add("tracer");
        title.add("toiler");
        title.add("toiser");
        title.add("tolérer");
        title.add("tomber");

        title.add("tomer");
        title.add("tondre");
        title.add("toquer");
        title.add("tordre");
        title.add("toucher");
        title.add("tourner");

        title.add("tournoyer");
        title.add("tousser");
        title.add("tracasser");
        title.add("tracer");
        title.add("traduire");
        title.add("trahir");

        title.add("traîner");
        title.add("traire");
        title.add("traiter");
        title.add("tramer");
        title.add("transcrire");
        title.add("transférer");

        title.add("transformer");
        title.add("transmettre");
        title.add("transparapitre");
        title.add("transporter");
        title.add("travailler");
        title.add("traverser");

        title.add("trembler");
        title.add("tremper");
        title.add("tressaillir");
        title.add("tricher");
        title.add("tricoter");
        title.add("trier");

        title.add("tripoter");
        title.add("tromper");
        title.add("trotter");
        title.add("troubler");
        title.add("trouer");
        title.add("troyver");

        title.add("tuer");
        title.add("tuiler");
        title.add("tutoyer");

        /*
        Finished T
         */

        title.add("unier");
        title.add("uriner");
        title.add("user");
        title.add("utiliser");

        title.add("vagir");
        title.add("vaguer");
        title.add("vaincre");
        title.add("valider");
        title.add("valoir");
        title.add("vanner");

        title.add("vanter");
        title.add("vaquer");
        title.add("varier");
        title.add("veiller");
        title.add("vénérer");
        title.add("venger");

        title.add("venir");
        title.add("verdir");
        title.add("vérifier");
        title.add("vernir");
        title.add("verrouiller");
        title.add("verser");

        title.add("vêtir");
        title.add("vexer");
        title.add("vider");
        title.add("vieillir");
        title.add("viner");
        title.add("violer");

        title.add("virer");
        title.add("viser");
        title.add("visionner");
        title.add("visiter");
        title.add("visser");
        title.add("vivre");

        title.add("voguer");
        title.add("voiler");
        title.add("voir");
        title.add("voler");
        title.add("voleter");
        title.add("vomir");

        title.add("voter");
        title.add("vouer");
        title.add("vouloir");
        title.add("voûter");
        title.add("vouvoyer");
        title.add("voyager");
        title.add("vendre");

        /*
        Finished V
         */

        //////////////
        title.add("zapper");
        title.add("zézayer");


            recyclerView.setVisibility(View.INVISIBLE);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new CommonRecyclerAdapter(title);
            recyclerView.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                  filter(s.toString());
            }
        });

    } //End Main

    private void filter(String text) {

        recyclerView.setVisibility(View.VISIBLE);

        final ArrayList<String> titleData = new ArrayList<>();

        for (final String data : title){

            if (data.toLowerCase().contains(text.toLowerCase())){

             titleData.add(data);

            }
        }

        adapter.filterList(titleData);

    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() >1){
            getFragmentManager().popBackStack();
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}