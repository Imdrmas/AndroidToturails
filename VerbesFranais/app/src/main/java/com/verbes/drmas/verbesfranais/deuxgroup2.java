package com.verbes.drmas.verbesfranais;

import android.view.Display;

/**
 * Created by drmas on 29/12/2017.
 */

public class deuxgroup2 {
    // array of questions
    private String textQuestions2 [] = {

            "1. [garnir - présent] Maman ... sa robe de jolies dentelles.",
            "2. [bondir - présent] Le lapin ... hors du terrier à l'approche des chiens.",
            "3. [envahir - présent] Les mauvaises herbes ... le jardin abandonné.",
            "4. [réussir -  présent] Tu ... tes tests de contrôle et tu en es très heureux.",
            "5. [pâlir présent] Vous ... de frayeur en regardant un film d'épouvante.",
            "6. [salir - présent] Je ... mes vêtements en faisant de la peinture.",
            "7. [gémir - présent] Les blessés ... de douleur en attendant les secours.",
            "8. [embellir - présent] Nous ... notre maison en la faisant repeindre.",
            "9. [guérir - présent] Je ... avec peine d'une vilaine bronchite.",
            "10. [franchir - présent] Le cheval ... l'obstacle avec une grande facilité.",

            "11. Tu ... (accomplir - passé composé) ton travail avec succès.",
            "12. Nous ... (remplir - passé composé) les bouteilles d'eau fraîche.",
            "13. Mes parents ... (bâtir - passé composé) une maison à la campagne.",
            "14. Est-ce que vous ... (blanchir - passé composé) les murs de votre chambre ?",
            "15. Génial ! J' ... (réussir - passé composé) mon examen de fin d'année !",
            "16. Je suis étonné; cet enfant ... (agir - passé composé) tel un adulte.",
            "17. Tous les spectateurs ... (applaudir - passé composé) à la fin du spectacle.",
            "18. Nous ... (fournir - passé composé) des efforts énormes pour voir le projet aboutir.",
            "19. Le malade ... (gémir - passé composé) pendant toute la nuit.",
            "20. En lisant beaucoup vous ... (enrichir - passé composé) vos connaissances.",


            "21. Nous ... (finir - imparfait) de manger quand l'orage a éclaté.",
            "22. Dès le début de l'année j' ... (avertir - imparfait) les élèves que je n'acceptais pas le bavardage.",
            "23. Je ne savais pas que tu (rougir - imparfait) ... si facilement quand on te faisait un compliment !",
            "24. En juillet 1969 Apollo 11 ... (alunir - imparfait) et pour la première fois un homme marchait sur la lune.",
            "25. Si tu ... (approfondir - imparfait) tes recherches, tu saurais que Louis XIV n'est pas le grand-père de Louis XV, mais son arrière-grand-père.",
            "26. Sa longue robe noire l' ... (amincir - imparfait) , la rendait plus grande et plus attirante.",
            "27. Si vous ... (ralentir - imparfait) ! Il neige, nous risquons de déraper et d'avoir un accident.",
            "28. Les fruits ... (mûrir - imparfait) bien sur les arbres, mon père disait: 'La récolte sera bonne'.",
            "29. Quand nous lisions Blanche Neige nous ... (pâlir - imparfait) à la vue de la sorcière et de la pomme empoisonnée !",
            "30. Pierre savait très bien que s'il ... (désobéir - imparfait) il serait malade. Il a quand même mangé tous les bonbons au chocolat.",

            "31. Je m' (établir - passé simple) ... là, car l'endroit était fort calme.",
            "32. Je (rôtir - imparfait) ... des marrons lors de veillée.",
            "33. Les fourmis (accomplir - futur simple) ... un dur labeur.",
            "34. Il faut absolument que ces abeilles (bâtir - subjonctif présent) ... une nouvelle ruche.",
            "35. Il aurait fallu que vous (finir - subjonctif imparfait) ... ce travail avant la nuit.",
            "36. Je me (divertir - futur simple) ... en lisant cet ouvrage.",
            "37. (Réjouir - Impératif) ...-vous de ce beau temps.",
            "38. Si j'étais riche, je (réagir - conditionnnel présent) ... face aux injustices en partageant mes richesses.",
            "39. Il fallait que vous (réunir - subjonctif imparfait) ... tout le monde avant de prendre une décision.",
            "40. Quand vous (remplir - futur antérieur) ... mon panier, vous le porterez à l'intérieur.",


            "41. Je m' ... (attendrir - présent) devant la joie des enfants qui m'offraient des fleurs.",
            "42. Au cours d'une longue période de réflexion tu ... (mûrir - présent) ton projet. Le résultat est probant !",
            "43. Il faisait très chaud lorsque soudain, un coup de tonnerre ... (retentir - présent).",
            "44. Au terme d'une longue marche en forêt, nous ... (finir - passé simple) par apercevoir un écureuil.",
            "45. Lors de votre séjour vous ... (réussir - passé simple) à améliorer la pratique de cette langue étrangère.",
            "46. Entendant hurler les loups, ils ... (saisir - passé simple) vivement leurs fusils.",
            "47. Lorsque le rideau tomba sur la dernière scène, les spectateurs ... (applaudir - passé simple) à tout rompre.",
            "48. Les enfants ... (investir) le salon, afin de faire une ronde autour de la table.",
            "49. Les bagages retrouvés, nous les ... (remplir) de vêtements.",
            "50. Après la dernière averse, nous ... (finir) de bêcher le jardin.",

            "51. Tu ... (accomplir - futur intérieur) ton travail avec succès.",
            "52. Nous ... (remplir - futur intérieur) les bouteilles d'eau fraîche.",
            "53. Mes parents ... (bâtir - futur intérieur) une maison à la campagne.",
            "54. Est-ce que vous ... (blanchir - futur intérieur) les murs de votre chambre ?",
            "55. Génial ! J' ... (réussir - futur intérieur) mon examen de fin d'année !",
            "56. Je suis étonné ; cet enfant ... (agir - futur intérieur) tel un adulte.",
            "57. Tous les spectateurs ... (applaudir - futur intérieur) à la fin du spectacle.",
            "58. Nous ... (fournir - futur intérieur) des efforts énormes pour voir le projet aboutir.",
            "59. Le malade ... (gémir - futur intérieur) pendant toute la nuit.",
            "60. En lisant beaucoup vous ... (enrichir - futur intérieur) vos connaissances.",


            "61. Il disait: 'J' ... (abolir - futur simple) la royauté'.",
            "62. Nous ... (aboutir - futur simple) à une impasse si nous ne nous entendons pas.",
            "63. Mes parents ... (bâtir - futur simple) leur maison près de la colline.",
            "64. Tu ... (chérir - futur simple) tes enfants, j'en suis certain.",
            "65. S'il pleut, l'eau ... (croupir - futur simple) dans la cuvette.",
            "66. Vous ... (démolir - futur simple) la maison de votre aïeul.",
            "67. Un bouquet de fleurs ... (embellir - futur simple) la salle à manger.",
            "68. Ce soir je ... (remplir - futur simple) la bassine d'eau.",
            "69. Demain ils ... (finir - futur simple) leurs devoirs et vous rejoindront.",
            "70. Pour gagner cette course, nous ... (unir - futur simple) nos efforts.",


            "71. Dès que nous ... (recevoir - futur intérieur) les colis, nous vous téléphonerons.",
            "72. Je te téléphonerai aussitôt que j'... (recevoir - futur intérieur) son chèque.",
            "73. lorsque nous ...(gagner - futur intérieur), nous rentrerons très satisfaits.",
            "74. Dès que tu ... (finir - futur intérieur) le premier exercice, tu tourneras la page.",
            "75. Il ... (faloir - futur simple) qu'on sache assez rapidement, où aller.",
            "76. En septembre, les feuilles ...(jaunir - futur simple)",
            "77. Je pense qu'elle nous ... (rendre - futur intérieur) visite.",
            "78. Nous commencerons la fête quand ils ... (arriver - futur intérieur)",
            "79. Vous ... (passer - futur simple) me voir demain.",
            "80. Vous ne ... (sortir - futur simple) plus avec elles.",


            "81. Toutes mes félicitations, tu ... (mincir - passé composé) depuis notre dernière rencontre.",
            "82. À vue d'œil, les poules des voisins ... (grandir - présent) plus vite que les miennes.",
            "83. Je n'aime pas cette jupe très longue, ... (raccourcir - vous, impératif)la de vingt centimètres.",
            "84. Le varan ... (se remplir - passé composé) le ventre en dévorant les œufs du crocodile.",
            "85. Abattez ce mur, votre salle de séjour ... (s'élargir, futur simple) considérablement.",
            "86. Les arbres ... (rabougrir - imparfait) pendant cet automne interminable.",
            "87. Je vous conseille un autre tissu, celui-ci ... (rétrécir - futur simple) après le lavage.",
            "88. Dans la casserole, la sauce ... (épaissir - imparfait) sur un feu doux.",
            "89. Des dattes ... (farcir - participe passé) de beurre et d'amandes, quelle douceur tunisienne !",
            "90. Ce matin-là, un rayon de lumière ... (emplir - passé simple) ma chambre et vint me caresser.",

            "91. (tu - remplir - présent) ... cette bouteille avec de l'eau et emporte-la en excursion.",
            "92. (je - démolir - présent) ... ce mur qui est vieux, il risque de s'écrouler et de blesser quelqu'un.",
            "93. (il - choisir - présent) ... entre ces deux robes celle que tu préfères, je prendrai l'autre.",
            "94. (elle - fleurir - présent) ... ton balcon, il sera plus beau ainsi. Tu peux en faire un endroit accueillant.",
            "95. (ils - enrichir - présent) ... ton vocabulaire en lisant beaucoup, cela te rendra sevice plus tard.",
            "96. (nous - éclaircir - présent) ... ce problème afin de mieux le comprendre, si l'on n'y parvient pas on demandera de l'aide.",
            "97. (vous - garnir - présent) ... la table avec des fleurs, la pièce sera plus gaie.",
            "98. (nous - faiblir - présent) ne ... pas, nous sommes bientôt arrivés. Plus que vingt minutes de marche!",
            "99. (vous - obéir - présent) ... à nos parents et à nos maîtres.",
            "100. (nous - réagir - présent) ... toujours à l'injustice et faisons des efforts pour la combattre."

};

    // array of multipe choice for each question
    private String multipeChoice2 [][] =  {
            {"garnit", "garni", "garnis"},
            {"bondi", "bondit", "bondis"},
            {"envahissent", "envahirent", "envahiront"},
            {"réussies", "réussis", "réussit"},
            {"pâliez", "pâlirez", "pâlissez"},
            {"salis", "salit", "salirai"},
            {"gémirent", "gémissent", "gémiront"},
            {"embellissiont", "embellissons", "embellirons"},
            {"guéries", "guéris", "guérit"},
            {"franchissait", "franchi", "franchit"},

            {"as accompli", "as accomplis", "as accomplit"},
            {"avons remplit", "avons remplis", "avons rempli"},
            {"ont bâtis", "ont bâti", "ont bâties"},
            {"avez blanchi", "avez blanchis", "avez blanchies"},
            {"ai réussi", "ai réussit", "ai réussis"},
            {"a agit", "a agis", "a agi"},
            {"ont applaudi", "ont applaudies", "ont applaudis"},
            {"avons fournis", "avons fourni", "avons fournit"},
            {"a gémi", "a gémis", "a gémit"},
            {"avez enrichis", "avez enrichi", "avez enrichit"},



            {"finissions", "finissons", "finirons"},
            {"avertissait", "avertissais", "avertira"},
            {"rougissais", "rougit", "rougira"},
            {"alunit", "alunira", "alunissait"},
            {"approfondiras", "approfondis", "approfondissais"},
            {"amincissait", "amincit", "amincira"},
            {"ralentirez", "ralentissiez", "ralentissez"},
            {"mûrissaient", "mûriront", "mûrissent"},
            {"pâlissions", "pâlissons", "pâlirons"},
            {"désobéissait", "désobéira", "désobéit"},


            {"établis", "établit", "établies"},
            {"rôtissait", "rôtissais", "rôtis"},
            {"accompliront", "accomplissent", "accomplissaient"},
        {"bâtissaient", "bâtissent", "bâtissants"},
        {"finirez", "finissiez", "finissez"},
        {"divertirai", "divertirait", "divertirais"},
        {"Réjouissez", "Réjouissiez", "Réjouirez"},
        {"réagissais", "réagis", "réagirais"},
        {"réunirez", "réunissez", "réunissiez"},
        {"aurez rempli", "aurez remplis", "aurez remplit"},


        {"attendris", "attendrissais", "attendrirai"},
        {"mûrit", "mûris", "mûriras"},
        {"retentira", "retentissait", "retentit"},
        {"finîmes", "finissons", "finirons"},
        {"réussirez", "réussîtes", "réussez"},
        {"saisiront", "saisissent", "saisirent"},
        {"applaudiront", "applaudirent", "applaudissent"},
        {"investiront", "investirent", "investissent"},
        {"remplissions", "remplissons", "remplîmes"},
        {"finirons", "finissons", "finîmes"},

        {"auras accomplit", "auras accompli", "auras accomplis"},
        {"aurons remplis", "aurons remplit", "aurons rempli"},
        {"auront bâti", "auront bâties", "auront bâtit"},
        {"aurez blanchis", "aurez blanchit", "aurez blanchi"},
        {"aurai réussis", "aurai réussi", "aurai réussit"},
        {"aura agi", "aura agit", "aura agis"},
        {"auront applaudi", "auront applaudis", "auront applaudit"},
        {"aurons fournis", "aurons fourni", "aurons fournit"},
        {"aura gémit", "aura gémis", "aura gémi"},
        {"aurez enrichis", "aurez enrichit", "aurez enrichi"},


        {"abolirai", "abolirais", "abolit"},
        {"aboutiront", "aboutissons", "aboutissions"},
        {"bâtissent", "bâtirent", "bâtiront"},
        {"chérirais", "chériras", "chéris"},
        {"croupiras", "croupis", "croupissais"},
        {"démolissez", "démolirez", "démolissiez"},
        {"embellis", "embellirai", "embellirais"},
        {"remplirait", "remplirais", "remplirai"},
        {"finissons", "finiront", "finissions"},
        {"unirons", "unissons", "unissions"},

        {"aurons reçu", "aurons reçus", "aurons reçues"},
        {"aurai reçus", "aurai reçu", "aurai reçut"},
        {"aurons gagnés", "aurions gagné", "aurons gagné"},
        {"auras fini", "auras finit", "auras finis"},
        {"faut", "faudra", "faudrait"},
        {"jaunirent", "jauniront", "jaunissons"},
        {"aura rendus", "aura rendu", "aura rendit"},
        {"seront arrivées", "seront arrivés", "seront arrivé"},
        {"passez", "passerez", "passiez"},
        {"sortis", "sortez", "sortirez"},


        {"as minci", "as mincit", "as mincis"},
        {"grandissaient", "grandissent", "grandiront"},
        {"raccourcirez", "raccourcissiez", "raccourcissez"},
        {"s'est remplis", "s'est remplie", "s'est rempli"},
        {"s'élargit", "s'élargira", "s'élargirait"},
        {"rabougrissent", "rabougrissaient", "rabougriront"},
        {"rétrécissait", "rétrécirait", "rétrécira"},
        {"épaissira", "épaississait", "épaississait"},
        {"farcies", "farcis", "farcie"},
        {"emplira", "emplissait", "emplit"},

        {"remplis", "remplit", "remplies"},
        {"démolit", "démolis", "démolirai"},
        {"choisi", "choisit", "choisie"},
        {"fleurit", "fleuri", "fleuris"},
        {"enrichiront", "enrichissent", "enrichissaient"},
        {"éclaircirons", "éclaircissons", "éclaircissions"},
        {"garnissez", "garnissiez", "garnirez"},
        {"faiblissons", "faiblirons", "faiblissions"},
        {"obéirez", "obéissez", "obéissiez"},
        {"réagissions", "réagirons", "réagissons"}



    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers2[] = {
            "garnit", "bondit", "envahissent", "réussis", "pâlissez", "salis", "gémissent", "embellissons", "guéris", "franchit",
            "as accompli", "avons rempli", "ont bâti", "avez blanchi", "ai réussi", "a agi", "ont applaudi", "avons fourni", "a gémi", "avez enrichi",
            "finissions", "avertissais", "rougissais", "alunissait", "approfondissais", "amincissait", "ralentissiez", "mûrissaient", "pâlissions", "désobéissait",
            "établis", "rôtissais", "accompliront", "bâtissent", "finissiez", "divertirai", "Réjouissez", "réagirais", "réunissiez", "aurez rempli",
            "attendris", "mûris", "retentit", "finîmes", "réussîtes", "saisirent", "applaudirent", "investirent", "investirent", "finîmes",
            "auras accompli", "aurons rempli", "auront bêti", "aurez blanchi", "aurai réussi", "aura agi", "auront applaudi", "aurons fourni", "aura gémi", "aurez enrichi",
            "abolirai", "aboutirons", "bâtiront", "chériras", "croupira", "démolirez", "embellira", "remplirai", "finiront", "unirons",
            "aurons reçu", "aurai reçu", "aurons gagné", "auras fini", "faudra", "jauniront", "aura rendu", "seront arrivés", "passerez", "sortirez",
            "as minci", "grandissent", "raccourcissez", "s'est rempli", "s'élargira", "rabougrissaient", "rétrécira", "épaississait", "farcies", "emplit",
            "remplis", "démolis", "choisit", "fleurit", "enrichissent", "éclaircissons", "garnissez", "faiblissons", "obéissez", "réagissons" };

    // method return numbers - in the same order as array of questions
    public int getLength() {return textQuestions2.length; }

    //method return question from array textQueston[] based on array index
    public String getQuestions(int a){
        String question = textQuestions2[a];
        return question;
    }
    // method return a single multipe choice item for question based on array index,
    // based on number of miltipe choice in the list - 1, 2, 3, or 4 as an arqument
    public String getChoice(int index, int num){
        String choice0 = multipeChoice2[index][num-1];
        return choice0;
    }
    // method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers2[a];
        return answer;
    }
}
