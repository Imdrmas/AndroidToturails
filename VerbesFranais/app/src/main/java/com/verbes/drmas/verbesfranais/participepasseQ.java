package com.verbes.drmas.verbesfranais;

import org.w3c.dom.Comment;

/**
 * Created by drmas on 31/12/2017.
 */

public class participepasseQ {

    private String textQuestions2 [] = {
            "1. Nous ... (cueillir - passé composé) des fleurs dans le jardin.",
            "2. Les garçons ... (revenir - passé composé) de l'école avec une punition.",
            "3. Voici les fleurs que nous ... (cueillir - passé composé) ce matin chez le voisin.",
            "4. Les filles ... (venir - passé composé) à l'école pour récupérer leur petit frère.",
            "5. Il ... (acheter - passé composé) des gants en prévision de cet hiver.",
            "6. Les gants qu'il ... (acheter - passé composé) sont fourrés.",
            "7. Quelle voisine as-tu ... (voir - passé composé) chez le boulanger ?",
            "8. Robert et Monique ...(aller - passé composé) ensemble à Montmartre.",
            "9. Elles ... (lire - passé composé) tous les scripts qui leur avaient été confiés.",
            "10. Elle ... (se laver - passé composé) avec de l'eau et le savon.",

            "11. Ils ... (emprunter - passé composé) ces livres à la bibliothèque.",
            "12. Les fleurs que j'ai ... (acheter - passé composé) sont magnifiques.",
            "13. Sophie a ... (dormir - passé composé) toute la soirée.",
            "14. Les coureurs ont été ... (accueillir - passif) en héros.",
            "15. Elle est ... (aller - passé composé) au cinéma hier soir.",
            "16. Carole et Pierre sont ... (partir - passé composé) tôt ce matin.",
            "17. Avec papa, nous sommes ... (aller - passé composé) chercher Fred à l'aéroport.",
            "18. Pierre a ... (garer - passé composé) sa voiture derrière la maison.",
            "19. Le chat de Juliette a ... (manger - passé composé) une souris.",
            "20.  Le poisson ... (pêcher) est dans la bourriche.",


            "21. Je ramasse les pommes ... (tomber) dans le jardin.",
            "22. La viande ... (griller) est très bonne.",
            "23. Le foin ... (couper) embaume l'air de la campagne.",
            "24. Le coffret ... (garnir) de bonbons coûte cher !",
            "25. La feuille ... (jaunir) se balance au vent.",
            "26. Cette famille ... (souder) vit des jours paisibles.",
            "27. Je range les assiettes ... (essuyer) dans le placard.",
            "28. L'oie ... (farcier) rissole dans son jus.",
            "29. Le pré ... (reverdir) se pare de pâquerettes.",
            "30. La chemise blanchie sera ensuite ...(repasser)",

            "31. La pomme que j'ai ... (manger - passé composé) était délicieuse, tu devrais en prendre une.",
            "32. ... (fatiguer - passé composé) de leur promenade, les filles se sont reposées devant un bon feu.",
            "33. Les commandes sont bien ... (arriver - passé composé), tu pourras appeler le fournisseur.",
            "34. J'ai ... (offrir - passé composé) ce cadeau à mon petit frère, il était ravi.",
            "35. La chemise que je t'ai ... (offrir - passé composé) est un peu grande, on ira l'échanger.",
            "36. Paul et Marie sont ... (partir - passé composé) pour le week-end, je suis toute seule.",
            "37. ...(aimer) par ses élèves, respecté par ses collègues, ce professeur est heureux.",
            "38. Les bêtises que Caroline a ... (faire - passé composé) ne sont pas si graves après tout !",
            "39. J'ai ... (expliquer - passé composé) les consignes et je ne recommencerai pas !",
            "40. C'est la robe que j'ai toujours ... (souhaiter - passé composé) ! Comment le savais-tu ?",


            "41. Les cadres qu'il lui a ... (donner - passé composé) sont beaux, elle y mettra des photos.",
            "42. Les enfants sont ... (partir - passé composé) avec leur tante passer quelques jours à la campagne.",
            "43. Les chats ont ...(manger - passé composé) toute leur ration, ce sont de vrais gloutons",
            "44. Ma mère, mon père et mon frère sont ... (sortir - passé composé), ils rentreront dans la soirée.",
            "45. La belle robe qu'on a ...; (acheter - passé composé) est décousue, passe moi la trousse à couture.",
            "46. Françoise est ... (arriver - passé composé) chez son frère hier matin, elle restera quelques jours avec lui.",
            "47. Quelques fleurs ont été ... (déposer - passé composé) devant chez lui.",
            "48. Les filles de Monique sont ... (inviter - passé composé) à l'anniversaire d'une amie.",
            "49. Ils ont  ... (acheter - passé composé) des pommes et des poires, ce sont de bons fruits.",
            "50. Les tapisseries qu'elle a faites, on les a ... (accrocher - passé composé) au mur.",

            "51. J'avais ... (recueillir - plus que imparfait) ses dernières volontés.",
            "52. Les trois toiles qu'il a ... (acheter - passé composé) sont très belles.",
            "53. La séance de la Bourse s'est ... (clôturer - passé composé) sur une baisse très importante.",
            "54. La directrice s'était ... (réserver - plus que imparfait) le petit salon.",
            "55. Tout s'était passé comme il l'avait ... (prévoir - plus que imparfait).",
            "56. De père en fils, les Dupont s'étaient ... (succéder - plus que imparfait) à la tête de ce magasin.",
            "57. Quels efforts avez-vous ... (faire - passé composé) ?",
            "58. Vous avez ... (laisser - passé composé) passer trop de temps avant de vous mettre au travail.",
            "59. Dès qu'elle se fut ... (apercevoir - passé intérieur) de son erreur, elle changea d'attitude.",
            "60. Elle s'est ... (faire - passé composé) une belle robe.",


            "61. Nous avons ... (cueillir - passé composé) des fleurs dans le jardin.",
            "62. Les garçons sont ... (revenir - passé composé) de l'école avec une punition.",
            "63. Voici les fleurs que nous avons ... (cueillir - passé composé) ce matin chez le voisin.",
            "64. Les filles sont ... (venir - passé composé) à l'école pour récupérer leur petit frère.",
            "65. Il a ... (acheter - passé composé) des gants en prévision de cet hiver.",
            "66. Les gants qu'il a ... (acheter - passé composé) sont fourrés.",
            "67. Quelle voisine as-tu ... (voir - passé composé) chez le boulanger ?",
            "68. Robert et Monique sont ... (aller - passé composé) ensemble à Montmartre.",
            "69. Elles ont ... (lire - passé composé) tous les scripts qui leur avaient été confiés.",
            "70. Elle s'est ... (se laver - passé composé) avec de l'eau et le savon.",

            "71. Ils ont ... (emprunter - passé composé) ces livres à la bibliothèque.",
            "72.  ... (transir) de froid et de frayeur, Cosette avançait à pas chancelants.",
            "73.  Mes yeux cherchent en vain leurs fleurs fraîches ... (éclore) (C.Delavigne)",
            "74.  Ce pays est toujours en guerre ... (ouvrir) contre ses voisins.",
            "75.  Nous dormirons quand vous aurez ... (éteindre) la lumière.",
            "76.  Millvina Dean a ... (survivre) au naufrage du Titanic.",
            "77.  Tout le monde a ...(croire) à son histoire de fantôme, pas moi !",
            "78.  ... (vêtir) d'une courte robe à fleurs, la jeune fille dansait la samba.",
            "79.  Les mimosas que vous avez ... (cueillir) sont très parfumés.",
            "80.  Ses revenus se sont ... (s'accroître) depuis son départ en Australie.",


            "81. Depuis quelques jours, la famille est ... (aller - passé composé) à la plage tous les après-midi.",
            "82. Les maisons que tu as ... (construire - passé composé) sont lumineuses, fonctionnelles et faciles à vivre.",
            "83. Hier, tu as ... (accompagner - passé composé) ton cousin à l'aéroport. Sais-tu si l'avion est parti à l'heure ?",
            "84. Nous avons ... (visiter - passé composé) la grotte de Jeita au Liban, elle est splendide.",
            "85. Où sont les crayons que tu as ... (acheter - passé composé) ce matin ? Je ne les trouve pas.",
            "86. Elles ont vu un beau film puis elles sont ... (aller - passé composé) manger au restaurant.",
            "87. Quels cadeaux d'anniversaire avez-vous ... (choisir - passé composé) pour votre ami ?",
            "88. Les notes que tu as ... (obtenir - passé composé) sont très bonnes. Félicitations tu as bien travaillé.",
            "89. Elles ont ... (offrir - passé composé) un bouquet de roses à leur mère pour sa fête.",
            "90. Pourquoi ton père est-il ... (partir - passé composé) si tard ce matin ?",

            "91. Les sportifs que j'ai ... (voir - passé composé) courir étaient plus rapides que moi.",
            "92. La pièce que j'ai ... (jouer - passé compsé était interprétée par des enfants.",
            "93. Les avions que nous avons ... (voir - passé composé) décoller partaient pour les Antilles.",
            "94. La carafe que tu as ... (faire - passé composé) tomber est cassée, bien sûr !",
            "95. Les chiens du voisin étaient seuls, je les ai ... (entendre - passé compsé) hurler toute la nuit.",
            "96. Les élèves que j'ai ... (envoyer - passé composé) chercher étaient en étude.",
            "97. La source s'écoulait doucement et nous l'avons ... (écouter - passé composé) chanter.",
            "98. Mes enfants, je les ai ... (regarder - passé composé) grandir chaque jour avec émotion.",
            "99. Les lettres sont enfin arrivées, je les ai ... (envoyer - passé composé) chercher.",
            "100. Les voiliers que nous avons ... (apercevoir - passé compsé) glisser au fil de l'eau, avançaient doucement,"
};


    // array of multipe choice for each question
    private String multipeChoice2 [][] = {
            {"avons cueilli", "avons cueillis", "avons cueillions"},
            {"sont revenues", "sont revenus", "sont revenu"},
            {"avions cueilli", "avons cueillis", "avons cueillies"},
            {"sont venues", "sont venus", "sont venu"},
            {"a achetées", "a achetés", "a acheté"},
            {"a acheté", "a achetés", "a achetée"},
            {"vue", "vues", "vu"},
            {"sont allées", "sont allée", "sont allés"},
            {"ont lus", "ont lu", "ont lut"},
            {"s'est lavées", "s'est lavé", "s'est lavée"},

            {"ont emprunté", "ont empruntée", "ont empruntés"},
            {"achetée", "achetées", "acheté"},
            {"dormit", "dormi", "dormis"},
            {"accueillis", "accueillit", "accueilli"},
            {"allées", "allée", "allé"},
            {"partis", "partits", "parties"},
            {"allées", "allés", "allé"},
            {"garés", "garée", "garé"},
            {"mangées", "mangée", "mangé"},
            {"pêché", "pêchée", "pêchés"},


            {"tombée", "tombées", "tombé"},
            {"grillées", "grillé", "grillée"},
            {"coupés", "coupé", "coupée"},
            {"garni", "garnis", "garnies"},
            {"jaunie", "jaunies", "jauni"},
            {"soudées", "soudé", "soudée"},
            {"essuyée", "essuyées", "essuyé"},
            {"farcies", "farcie", "farci"},
            {"reverdis", "reverdie", "reverdi"},
            {"repassées", "repassée", "repassé"},

            {"mangées", "mangée", "mangé"},
            {"fatiguées", "fatiguée", "fatigué"},
            {"arrivée", "arrivé", "arrivées"},
            {"offert", "offerts", "offerte"},
            {"offerte", "offerts", "offert"},
            {"parties", "partis", "parti"},
            {"aimés", "aimé", "aimée"},
            {"faites", "faite", "fait"},
            {"expliquée", "expliqué", "expliqués"},
            {"souhaitée", "souhaité", "souhaitées"},


            {"donnés", "donné", "donnée"},
            {"parti", "partis", "parties"},
            {"mangé", "mangés", "mangée"},
            {"sorties", "sorti", "sortis"},
            {"achetées", "acheté", "achetée"},
            {"arrivé", "arrivée", "arrivées"},
            {"déposée", "déposées", "déposé"},
            {"invité", "invité", "invitées"},
            {"acheté", "achetés", "achetée"},
            {"accrochée", "accroché", "accrochées"},

            {"recueillit", "recueilli", "recueillis"},
            {"achetées", "achetés", "achetée"},
            {"clôturé", "clôturées", "clôturée"},
            {"réservé", "réservée", "réservés"},
            {"prévus", "prévu", "prévue"},
            {"succédés", "succédé", "succédée"},
            {"faits", "faites", "fait"},
            {"laissée", "laissés", "laissé"},
            {"aperçus", "aperçue", "aperçu"},
            {"fait", "faits", "faite"},


            {"cueillis", "cueillie", "cueilli"},
            {"revenus", "revenues", "revenue"},
            {"cueillis", "cueillies", "cueillie"},
            {"venues", "venue", "venus"},
            {"achetés", "achetée", "acheté"},
            {"acheté", "achetées", "achetés"},
            {"vues", "vue", "vu"},
            {"allées", "allés", "allé"},
            {"lus", "lu", "lut"},
            {"lavées", "lavée", "lavé"},

            {"empruntés", "emprunté", "empruntée"},
            {"transie", "transis", "transies"},
            {"éclos", "éclose", "écloses"},
            {"ouverte", "ouvertes", "ouvert"},
            {"éteins", "éteint", "éteinte"},
            {"survécu", "survécue", "survécus"},
            {"crue", "crut", "cru"},
            {"vêtue", "vêtu", "vêtues"},
            {"cueilli", "cueillis", "cueillies"},
            {"accrues", "accrus", "accru"},


            {"allée", "allé", "allées"},
            {"construit", "construite", "construites"},
            {"accompagnés", "accompagné", "accompagnée"},
            {"visités", "visité", "visitée"},
            {"achetées", "achetés", "acheté"},
            {"allée", "allé", "allées"},
            {"choisis", "choisi", "choisies"},
            {"obtenue", "obtenus", "obtenues"},
            {"offert", "offerts", "offerte"},
            {"partis", "parti", "partie"},

            {"vus", "vu", "vues"},
            {"jouée", "joue", "jouait"},
            {"vues", "vu", "vus"},
            {"fait", "faite", "faits"},
            {"entendues", "entendus", "entendu"},
            {"envoyée", "envoyés", "envoyé"},
            {"écouté", "écoutée", "écoutées"},
            {"regardés", "regardées", "regardé"},
            {"envoyé", "envoyés", "envoyée"},
            {"aperçu", "aperçue", "aperçus"}

    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers2 [] = {
            "avons cueilli", "sont revenus", "avons cueillies", "sont venues", "a acheté", "a achetés", "vue", "sont allés", "ont lu", "s'est lavée",
            "ont emprunté", "achetées", "dormi", "accueillis", "allée", "partis", "allés", "garé", "mangé", "pêché",

            "tombées", "grillée", "coupé", "garni", "jaunie", "soudée", "essuyées", "farcie", "reverdi","repassée",
            "mangée", "fatiguées", "arrivées", "offert", "offerte", "partis", "aimé", "faites", "expliqué", "souhaitée",

            "donnés", "partis", "mangé", "sortis", "achetée", "arrivée", "déposées", "invitées", "acheté", "accrochées",
            "recueilli", "achetées", "clôturée", "réservé", "prévu", "succédé", "faits", "laissé", "aperçue", "faite",

            "cueilli", "revenus", "cueillies", "venues", "acheté", "achetés", "vue", "allés", "lu", "lavée",
            "emprunté", "transie", "écloses", "ouverte", "éteint", "survécu", "cru", "vêtue", "cueillis", "accrus",

            "allée", "construites", "accompagné", "visité", "achetés", "allées", "choisis", "obtenues", "offert", "parti",
            "vus", "jouée", "vus", "fait", "entendus", "envoyé", "écoutée", "regardés", "envoyé", "aperçus"
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
