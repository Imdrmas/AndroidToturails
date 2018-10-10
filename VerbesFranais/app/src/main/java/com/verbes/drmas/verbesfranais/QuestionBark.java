package com.verbes.drmas.verbesfranais;

/**
 * This file containt question from QuestionBark
 */

public class QuestionBark {

    // array of questions
    private String textQuestions [] = {
            "1. Je ... (être - présent) heureuse de vivre.",
            "2. J' ... (avoir - présent) le temps de vivre.",
            "3. Il ... (être - présent) temps de rire !",
            "4. Elles ... (avoir - présent) envie de rire.",
            "5. Elles ... (être - présent) ravies !",
            "6. Il ... (avoir - présent) la joie au cœur.",
            "7. On ... (avoir - présent) le droit de rire.",
            "8. Je ... (être - présent) avec toi.",
            "9. Les enfants ... (être - présent) ensemble.",
            "10. Maman ... (être - présent) à la maison.",

            "11. J' ... (avoir - présent) un petit vélo.",
            "12. Le soleil ... (être - présent) au rendez-vous.",
            "13. Tu ... (être - présent) très beau ce matin.",
            "14. Je ... (être - présent) attendu à déjeuner chez mes parents.",
            "15. Valérie ... (être - présent) en vacances chez son ami.",
            "16. Jean et Mathilde ... (être - présent) aux Etats - Unis.",
            "17. Nous ... (être - présent) heureux de vous revoir !",
            "18. Tu ... (avoir - présent) de belles chaussures.",
            "19. (être - présent) ... -vous habité en Corse ?",
            "20. J' ... (avoir - présent) des gâteaux dans le placard.",

            "21. Christophe ... (avoir présent) un beau stylo.",
            "22. Elliott, Timothée et moi ... (avoir - présent) un ordinateur.",
            "23. Je ... (être - présent) prête à partir.",
            "24. Vous ... (être - présent) dans la même classe.",
            "25. Je (J') ... (avoir - conditionnel) une question à vous poser, si vous acceptez.",
            "26. Océane et moi ... (être - imparfait) amies.",
            "27. Elles ... (être - présent) dans la cuisine.",
            "28. Michèle ... (être - futur) à Paris au mois de juin.",
            "29. Mon amie ... (avoir - conditionnel) besoin d'aide pour ses devoirs.",
            "30. (avoir - présent) ... -tu un crayon à me prêter ?",

            "31. Il y ... (avoir - futur) 28 jours en février cette année. ",
            "32. La maitresse (être - présent) ... contente des notes des élèves de ma classe, nous avons bien travaillé.",
            "33. Mes deux chattes ... (avoir - imparfait) peur de l'eau.",
            "34. Tu ... (être - présent) à ma gauche.",
            "35. Vous ... (être - imparfait) sur la liste d'attente.",
            "36. Danielle ... (être - conditionnel) heureuse d'apprendre le tango.",
            "37. Je ... (être - conditionnel) heureuse si tu me présentais ton amie.",
            "38. Nous ... (être - imparfait) dans la forêt, près du lac.",
            "39. Camille n' ... (avoir - présent) pas de chance !",
            "40. Suzanne ne (n') ... (être - futur) pas de bonne humeur.",

            "41. Ces koalas ne (n') ... (avoir - imparfait) plus de mère.",
            "42. (être - futur) ... -vous de la fête ce soir?",
            "43. Je ... (être - présent) une élève très sérieuse en classe.",
            "44. Ma mère ... (avoir - présent) trouvé un chat perdu et nous l'avons gardé.",
            "45. Nous ... (avoir - présent) tous le droit d'apprendre à lire et à écrire.",
            "46. Où ... (être - présent)-tu ?Je ne te vois plus! Viens vite il est temps de rentrer.",
            "47. Les élèves (avoir - présent) ... la grippe. Ils vont manquer l'école huit jours.",
            "48. Paris ... (être - présent) la capitale de la France. Elle le devint définitivement sous le règne de Philippe-Auguste (1190-1220).",
            "49. Julie et toi (avoir - présent) ... couru trente minutes sous un chaud soleil. Venez vite prendre une douche.",
            "50. Les enfants ... (être présent) assez grands maintenant, ils peuvent nous aider et faire la vaisselle !",

            "51. Vous ... (être - présent) à Londres en visite ou y êtes-vous pour le travail?",
            "52. Vous ... (avoir - présent) le droit de garder le silence. Tout ce que vous direz pourra être retenu contre vous.",
            "53. Mon chien (être - présent) ... brun avec des taches blanches, je l'aime beaucoup.",
            "54. Maman (avoir - passé composé) ... acheté des livres de mathématiques pour me faire faire des exercices.",
            "55. Les chattes (avoir passé composé) ... mis bas, nous avons maintenant d'adorables chatons.",
            "56. Nous ... (avoir - présent) du riz pour le dîner.",
            "57. Nous ... (être - présent) partis à Paris.",
            "58. Je ... (être - présent) plus jeune que lui.",
            "59. J' ... (avoir - présent) du jus de fruits.",
            "60. Ils ... (avoir - présent) encore faim",

            "61. Il ... (être - présent) au parc pour la journée.",
            "62. Vous ... (être - présent) au stade de foot.",
            "63. Tu ... (être - présent) à la maison.",
            "64. Vous ... (avoir - présent) un chien.",
            "65. Tu ... (avoir - présent) de beaux yeux.",
            "66. Je ... (être - présent) dans ma chambre pour réviser mes leçons.",
            "67. Elle ... (avoir - présent) des amis qu'elle voit tous les jours.",
            "68. Nous ... (être - présent) toujours en retard au cours de gymnastique.",
            "69. Nous ...  (avoir - présent) un cours de chant tous les jeudis.",
            "70. On n' ... (être - présent) jamais content de se faire disputer.",

            "71. Vous ... (être - présent) en vacances au Portugal depuis un mois déjà !",
            "72. Est-ce que tu ... (avoir - présent) tes affaires aujourd'hui ? demande le professeur.",
            "73. Mes parents ne ... (être - présent) pas d'accord pour que je sorte la nuit.",
            "74. Vous ... (avoir - présent) un pantalon trop grand pour vous.",
            "75. Tu ... (être - présent) souvent absente cette année, méfie-toi!",
            "76. Je ... (être - présent) français de naissance.",
            "77. Ils ... (avoir - présent) mal à la tête.",
            "78. Qui ... (être - présent) -vous pour me dire ceci?",
            "79. Tu ... (être - présent) malade depuis hier.",
            "80. Bonjour ! Où ... (être - présent) Anna s'il te plaît?",

            "81. Ma chatte ... (avoir - présent) des petits dans son panier.",
            "82. Nous ... (être - présent) à sa recherche dans les bois.",
            "83. Aujourd'hui, il y ... (avoir - présent) du soleil.",
            "84. J' ... (avoir - présent) des vacances dans une semaine",
            "85. ... (avoir - présent) -vous faim ? J'ai des biscuits.",
            "86. Nous ... (être - présent) ravies de l'avoir rencontré.",
            "87. J' ... (avoir - présent) un beau cartable pour la rentrée.",
            "88. Nous ... (avoir - présent) des devoirs à faire ce soir.",
            "89. Elle ... (avoir - présent) un manteau en fourrure",
            "90. (être - présent) ... -tu capable de tout faire ?",

            "91. Il ... (être - présent) fort en mathématiques.",
            "92. Vous ... (avoir - présent) une petite maison à la campagne.",
            "93. Elles ... (être - présent) très intelligentes et le savent.",
            "94. Ils n' ... (avoir présent) pas beaucoup d'amis mais ils sont fidèles.",
            "95. Je ... (être - présent) heureux d'apprendre cette grande nouvelle.",
            "96. Tu ... (avoir - présent) tout ce qu'il te faut pour bien apprendre.",
            "97. ... (être - présent) - vous prêts à partir tout de suite?",
            "98. Beaucoup d'enfants (être - présent) ... malades. Il y a une épidémie de gastro-entérite.",
            "99. La troisième république (avoir - présent) ... commencé en 1870, elle a pris fin le 10 juillet 1940.",
            "100. Mon frère Michel (être - présent) ... vétérinaire, je l'aide souvent à soigner les animaux."




};

    // array of multipe choice for each question


    private String multipeChoice [][] =  {
            {"suis", "es", "est"},
            {"a", "ai", "avons"},
            {"sont", "es", "est"},
            {"avaient", "ont", "auront"},
            {"seront", "sont", "étaient"},
            {"aura", "avait", "a"},
            {"est", "a", "eut"},
            {"suis", "étais", "ai"},
            {"seraient", "sont", "seront"},
            {"sera", "a", "est"},

            {"sais", "ai", "avais"},
            {"sera", "est", "a"},
            {"es", "ai", "aurais"},
            {"ai", "serai", "suis"},
            {"aura", "est", "avait"},
            {"avaient", "ont", "sont"},
            {"sommes", "avons", "aurons"},
            {"auras", "as", "es"},
            {"êtes", "aviez", "avez"},
            {"aurais", "ai", "eus"},


            {"sera", "est", "a"},
            {"avons", "avions", "sommes"},
            {"aurais", "serais", "suis"},
            {"êtes", "avez", "étiez"},
            {"avais", "serais", "aurais"},
            {"serons", "étions", "sommes"},
            {"sont", "avaient", "étaient"},
            {"sera", "aura", "avait"},
            {"aurait", "serait", "était"},
            {"es", "as", "avais"},

            {"sera", "a", "aura"},
            {"est", "serait", "avait"},
            {"avaient", "étaient", "seront"},
            {"seras", "es", "as"},
            {"avez", "serez", "étiez"},
            {"serait", "avait", "était"},
            {"avais", "serais", "étais"},
            {"étions", "seront", "avions"},
            {"serait", "a", "avait"},
            {"était", "sera", "avait"},


            {"ont", "étaient", "avaient"},
            {"êtes", "serez", "seriez"},
            {"suis", "ai", "étais"},
            {"est", "avait", "a"},
            {"avons", "avions", "étions"},
            {"as", "es", "seras"},
            {"ont", "sont", "seront"},
            {"était", "est", "a"},
            {"avez", "aviez", "serez"},
            {"ont", "avaient", "sont"},

            {"êtes", "serez", "étiez"},
            {"avez", "étiez", "aviez"},
            {"est", "était", "as"},
            {"avait", "est", "a"},
            {"seront", "ont", "avient"},
            {"avons", "sommes", "serons"},
            {"étions", "sommes", "avions"},
            {"suis", "eus", "serais"},
            {"avais", "ai", "ais"},
            {"avaient", "seront", "ont"},


            {"est", "aura", "a"},
            {"avez", "aviez", "êtes"},
            {"es", "as", "serais"},
            {"aviez", "êtes", "avez"},
            {"ais", "es", "as"},
            {"avais", "suis", "ai"},
            {"avait", "est", "a"},
            {"serions", "sommes", "avions"},
            {"avons", "étions", "serons"},
            {"aura", "a", "est"},

            {"êtes", "serez", "avez"},
            {"es", "as", "avais"},
            {"sont", "ont", "seront"},
            {"êtes", "aviez", "avez"},
            {"serais", "es", "as"},
            {"avais", "suis", "ai"},
            {"ont", "sont", "étaient"},
            {"avez", "êtes", "aviez"},
            {"ai", "serais", "es"},
            {"a", "est", "avait"},


            {"avait", "a", "est"},
            {"aurons", "sommes", "avons"},
            {"serait", "a", "est"},
            {"aurais", "ai", "suis"},
            {"avez", "aviez", "êtes"},
            {"avons", "sommes", "êtes"},
            {"aaurais", "ai", "suis"},
            {"sommes", "avons", "serions"},
            {"est", "était", "a"},
            {"es", "as", "avais"},

            {"serait", "a", "est"},
            {"avez", "êtes", "seriez"},
            {"ont", "sont", "avaient"},
            {"étaient", "sont", "ont"},
            {"ai", "suis", "serais"},
            {"as", "es", "serais"},
            {"avez", "êtes", "étiez"},
            {"sont", "ont", "seront"},
            {"aura", "a", "est"},
            {"seras", "as", "es"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {
            "suis", "ai", "est", "ont", "sont", "a", "a", "suis", "sont", "est",
            "ai", "est", "es", "suis", "est", "sont", "sommes", "as", "avez", "ai",
            "a", "avons", "suis", "êtes", "aurais", "étions", "sont", "sera", "aurait", "as",
            "aura", "est", "avaient", "es", "étiez", "serait", "serais", "étions", "a", "sera",
            "avaient", "serez", "suis", "a", "avons", "es", "ont", "est", "avez", "sont",
            "êtes", "avez", "est", "a", "ont", "avons", "sommes", "suis", "ai", "ont",
            "est", "êtes", "es", "avez", "as", "suis", "a", "sommes", "avons", "est",
            "êtes", "as", "sont", "avez", "es", "suis", "ont", "êtes", "es", "est",
            "a", "sommes", "a", "ai", "avez", "sommes", "ai", "avons", "a", "es",
            "est", "avez", "sont", "ont", "suis", "as", "êtes", "sont", "a", "est"};

    // method return numbers - in the same order as array of questions
   public int getLength() {return textQuestions.length; }

    //method return question from array textQueston[] based on array index
    public String getQuestions(int a){
        String question = textQuestions[a];
        return question;
    }
    // method return a single multipe choice item for question based on array index,
    // based on number of miltipe choice in the list - 1, 2, 3, or 4 as an arqument
    public String getChoice(int index, int num){
        String choice0 = multipeChoice[index][num-1];
        return choice0;
    }
    // method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
