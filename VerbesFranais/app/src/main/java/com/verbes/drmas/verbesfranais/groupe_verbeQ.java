package com.verbes.drmas.verbesfranais;

/**
 * Created by drmas on 31/12/2017.
 */

public class groupe_verbeQ {

    // array of questions
    private String textQuestions2 [] = {
            "1. Je (voyageais) ... souvent en train.",
            "2. Je (perdais) ... fréquemment mes bagages.",
            "3. Je (réussissais) ... parfois à les retrouver.",
            "4. Je (partais) ... voir mes amis en voiture quand je pouvais y aller.",
            "5. J' (aimais) ... voir les paysages par la fenêtre.",
            "6. Je (terminais) ... mes vacances par un bon bain de soleil.",
            "7. Je (salissais) ... rarement mes vêtements en mangeant de la crème glacée.",
            "8. Quand j'étais adolescent et je (grandissais) ... très vite.",
            "9. Loin de mes parents, j' (oubliais) ... souvent de me laver les dents.",
            "10. Ma grand-mère me nourrissait bien, alors je (grossissais) .... pendant l'été.",

            "11. Parfois, je (venais) ... visiter des amis.",
            "12. Quand je me chicanais avec ma sœur, ma grand-mère (intervenait) ... .",
            "13. En juillet, je (cueillais) ... des fraises des champs pour mes parents.",
            "14. Je (choisissais) ... les plus rouges, elles étaient si bonnes.",
            "15. donner ... ",
            "16. dire ... ",
            "17. paraître ... ",
            "18. répandre ... ",
            "19. répartir ... ",
            "20. ouvrir ... ",


            "21. goûter ... ",
            "22. montrer ... ",
            "23. rôtir ... ",
            "24. tourner ... ",
            "25. grandir ... ",
            "26. remplir ... ",
            "27. prendre ... ",
            "28. danser ... ",
            "29. boire ... ",
            "30. manger ... ",

            "31. Sa gentillesse me charme. ... groupe",
            "32. Vous commettez une grave erreur. ... groupe",
            "33. Le berger comptait ses moutons. ... groupe",
            "34. Il ne conduit pas la nuit. ... groupe",
            "35. Ce cheval prend une confortable avance. ... groupe",
            "36. Le photographe agrandit les photos. ... groupe",
            "37. Ma mère farcit des tomates pour le déjeûner. ... groupe",
            "38. Je me promène sur les grands boulevards. ... groupe",
            "39. Je recueille ce chien abandonné. ... groupe",
            "40. Attendons l'autobus suivant. ... groupe",


            "41. Les meubles qui garnissent un appartement. ... groupe",
            "42. Ils obéissent à cette loi. ... groupe",
            "43. Comprenez-vous mes explications ? ... groupe",
            "44. Le poète compare la vie à un long voyage. ... groupe",
            "45. Vous commettez une grave erreur. ... groupe",
            "46. Nous concluons un marché avec notre fournisseur. ... groupe",
            "47. L'eau bout à 100 degrés. ... groupe",
            "48. Cela ternit sa mémoire. ... groupe",
            "49. Elle étale de la confiture de fraises sur sa tartine. ... groupe",
            "50. Ce boulanger pétrit bien sa pâte. ... groupe",

            "51. Je (pars) bientôt en vacances. ...",
            "52. Mon père (écoute) souvent de la musique classique. ...",
            "53. Mon voisin (maigrit) à vue d'œil depuis quelques mois. ...",
            "54. Le pessimiste (voit) tout en noir. ...",
            "55. Les étudiants (passent) un concours dans trois jours. ...",
            "56. Cette adolescente (rougit) facilement. ...",
            "57. Maman (fait) des crêpes pour le goûter. ...",
            "58. Les enfants (jouent) dans le jardin. ...",
            "59. (Croyez-vous) en ces faits réels ? ...",
            "60. Nous (achetons) des livres anciens chez un bouquiniste. ...",


            "61. Je me suis (tordu) ... la cheville en jouant au football.",
            "62. Mon chien (finit) ... sa gamelle avant de sortir dans le jardin.",
            "63. Les filles sont (arrivées) ... en retard à l'école et ont été punies.",
            "64. Antoine (allait) moins aux cours de mathématiques qu'à ceux de latin ...",
            "65. Claude François (fut) ... le plus grand chanteur populaire.",
            "66. Le professeur de Technologie est absent. Le cours sera (rattrapé) ... .",
            "67. '...To be or not to be' (signifie) ... : être ou ne pas être.",
            "68. (Avoir) ... un enfant n'est pas toujours si facile.",
            "69. En 1793, le roi Louis XVI fut (guillotiné) ... à la Place de la Concorde.",
            "70. La matière que je (réussis) ... le moins est la Physique.",

            "71. Sans entraînement, l'équipe (adverse) nous battra ... à plate couture lors du prochain match",
            "72. Les enfants (grandissent) ... si vite !",
            "73. Les femmes (changent) ... souvent leur garde-robe.",
            "74. Pierre (concluait) ... toujours la conversation par un grand éclat de rire.",
            "75. Mes amis et moi (réfléchissons) ... à la destination de nos prochaines vacances.",
            "76. J' (achète) ... les fleurs et toi le dessert.",
            "77. Tu (connais) ... la nouvelle ? Non ! Pourquoi ?",
            "78. Nous (cédons) ... trop facilement aux caprices de nos enfants.",
            "79. Hum!..Vous (maigrissez) ... beaucoup trop vite.",
            "80. J' (irai) ... sans doute en Italie cet été.",


            "81. Paul (enverra) ... le colis bientôt.",
            "82. Elle a (rougi) ... de confusion après ce beau compliment.",
            "83. Quand je dors, je (fais) souvent des cauchemars. ...",
            "84. Sandra (travaille) dans un salon de coiffure. ...",
            "85. Je (cours) très vite lorsque je suis en retard. ...",
            "86. Je (prends) un taxi les jours de canicule. ... ",
            "87. Dès que je mange trop, je (deviens) malade. ...",
            "88. Mon chien (se gratte!) Il a des puces ! ...",
            "89. Je (hais) mon voisin car il est prétentieux. ...",
            "90. Ils (jettent) leurs papiers à la poubelle. ...",

            "91. Je ne (sais) pas à qui cela appartient. ...",
            "92. J' (écris) une lettre à ma grand-mère. ...",
            "93. Avant de dormir, je (bois) un verre d'eau. ...",
            "94. Ma sœur (agit) à sa façon. ... ",
            "95. Je ne (vais) pas à la piscine. ...",
            "96. Sophie (adore) les jeux vidéos. ...",
            "97. Quand Gilles a (fini) de manger, il va dormir. ...",
            "98. Chaque matin, nous (nous brossons) ... les dents.",
            "99. Quand la cloche sonne, nous (rangeons) ... nos affaires.",
            "100. Elle a (cousu) ... une jolie robe à sa poupée."
};

    // array of multipe choice for each question
    private String multipeChoice2 [][] = {
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},

            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},

            {"3e groupe", "2e groupe", "1e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"2e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},

            {"charmer-2e", "charmer-3e", "charmer-1e"},
            {"commettre-1e", "commettre-2e", "commettre-3e"},
            {"compter-3e", "compter-2e", "compter-1e"},
            {"conduire-3e", "conduire-1e", "conduire-2e"},
            {"prendre-1e", "prendre-2e", "prendre-3e"},
            {"agrandir-1e", "agrandir-3e", "agrandir-2e"},
            {"farcir-2e", "farcir-3e", "farcir-1e"},
            {"se promener-2e", "se promener-3e", "se promener-1e"},
            {"recueillir-3e", "recueillir-1e", "recueillir-2e"},
            {"Attendre-1e", "Attendre-2e", "Attendre-3e"},

            {"garnir-2e", "garnir-3e", "garnir-1e"},
            {"obéir-1e", "obéir-2e", "obéir-3e"},
            {"comprendre-3e", "comprendre-1e", "comprendre-2e"},
            {"comparer-1e", "comparer-2e", "comparer-3e"},
            {"commettre-3e", "commettre-2e", "commettre-1e"},
            {"conclure-2e", "conclure-3e", "conclure-1e"},
            {"bouillir-1e", "bouillir-2e", "bouillir-3e"},
            {"ternir-2e", "ternir-1e", "ternir-3e"},
            {"étaler-3e", "étaler-2e", "étaler-1e"},
            {"pétrir-1e", "pétrir-2e", "pétrir-3e"},

            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},

            {"3e groupe", "1e groupe", "2e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},

            {"3e groupe", "2e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},

            {"1e groupe", "2e groupe", "3e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"2e groupe", "3e groupe", "1e groupe"},

            {"1e groupe", "2e groupe", "3e groupe"},
            {"3e groupe", "1e groupe", "2e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"1e groupe", "2e groupe", "3e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"1e groupe", "3e groupe", "2e groupe"},
            {"2e groupe", "1e groupe", "3e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"},
            {"3e groupe", "2e groupe", "1e groupe"}

    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers2[] = {
            "1e groupe", "3e groupe", "2e groupe", "3e groupe", "1e groupe", "1e groupe", "2e groupe", "2e groupe", "1e groupe", "2e groupe",
            "3e groupe", "3e groupe", "3e groupe", "2e groupe", "1e groupe", "3e groupe", "3e groupe", "3e groupe", "2e groupe", "3e groupe",

            "1e groupe", "1e groupe", "2e groupe", "1e groupe", "2e groupe", "2e groupe", "3e groupe", "1e groupe", "3e groupe", "1e groupe",
            "charmer-1e", "commettre-3e", "compter-1e", "conduire-3e", "prendre-3e", "agrandir-2e", "farcir-2e", "se promener-1e", "recueillir-3e", "Attendre-3e",

            "garnir-2e", "obéir-2e", "comprendre-3e", "comparer-1e", "commettre-3e", "conclure-3e", "bouillir-3e", "ternir-3e", "étaler-1e", "pétrir-2e",
            "3e groupe", "1e groupe", "2e groupe", "3e groupe", "1e groupe", "2e groupe", "3e groupe", "1e groupe", "3e groupe", "1e groupe",

            "3e groupe", "2e groupe", "1e groupe", "3e groupe", "3e groupe", "1e groupe", "1e groupe", "3e groupe", "1e groupe", "2e groupe",
            "3e groupe", "2e groupe", "1e groupe", "3e groupe", "2e groupe", "1e groupe", "3e groupe", "1e groupe", "2e groupe", "3e groupe",

            "1e groupe", "2e groupe", "3e groupe", "1e groupe", "3e groupe", "3e groupe", "3e groupe", "1e groupe", "2e groupe", "1e groupe",
            "3e groupe", "3e groupe", "3e groupe", "2e groupe", "3e groupe", "1e groupe", "2e groupe", "1e groupe", "1e groupe", "3e groupe"
    };


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
