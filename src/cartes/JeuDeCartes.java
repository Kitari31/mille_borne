package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuDeCartes {
    private List<Carte> listeCartes;

    private static final int NOMBRE_FEU_ROUGE = 5;
    private static final int NOMBRE_ESSENCE = 5;
    private static final int NOMBRE_CREVAISON = 5;
    private static final int NOMBRE_ACCIDENT = 5;
    private static final int NOMBRE_CITERNE_ESSENCE = 1;
    private static final int NOMBRE_INCREVABLE = 1;
    private static final int NOMBRE_AS_DU_VOLANT = 1;
    private static final int NOMBRE_VEHICULE_PRIORITAIRE = 1;

    public JeuDeCartes() {
        listeCartes = new ArrayList<>();

        // Ajout des cartes FeuRouge
        for (int i = 0; i < NOMBRE_FEU_ROUGE; i++) {
            listeCartes.add(new Attaque(i + 1, Probleme.Type.FEU));
        }

        // Ajout des cartes Essence
        for (int i = 0; i < NOMBRE_ESSENCE; i++) {
            listeCartes.add(new Attaque(i + 1, Probleme.Type.ESSENCE));
        }

        // Ajout des cartes Crevaison
        for (int i = 0; i < NOMBRE_CREVAISON; i++) {
            listeCartes.add(new Attaque(i + 1, Probleme.Type.CREVAISON));
        }

        // Ajout des cartes Accident
        for (int i = 0; i < NOMBRE_ACCIDENT; i++) {
            listeCartes.add(new Attaque(i + 1, Probleme.Type.ACCIDENT));
        }

        // Ajout des cartes CiterneEssence
        for (int i = 0; i < NOMBRE_CITERNE_ESSENCE; i++) {
            listeCartes.add(new Botte(i + 1, Probleme.Type.ESSENCE));
        }

        // Ajout des cartes Increvable
        for (int i = 0; i < NOMBRE_INCREVABLE; i++) {
            listeCartes.add(new Botte(i + 1, Probleme.Type.CREVAISON));
        }

        // Ajout des cartes AsDuVolant
        for (int i = 0; i < NOMBRE_AS_DU_VOLANT; i++) {
            listeCartes.add(new Botte(i + 1, Probleme.Type.ACCIDENT));
        }

        // Ajout des cartes VehiculePrioritaire
        for (int i = 0; i < NOMBRE_VEHICULE_PRIORITAIRE; i++) {
            listeCartes.add(new Botte(i + 1, Probleme.Type.FEU));
        }
        
        Collections.shuffle(listeCartes);
    }

    public List<Carte> getListeCartes() {
        return listeCartes;
    }
    
    public boolean checkCount() {
        int countFeuRouge = 0;
        int countEssence = 0;
        int countCrevaison = 0;
        int countAccident = 0;
        int countCiterneEssence = 0;
        int countIncrevable = 0;
        int countAsDuVolant = 0;
        int countVehiculePrioritaire = 0;

        for (Carte carte : listeCartes) {
            if (carte instanceof Attaque) {
                Attaque attaque = (Attaque) carte;
                switch (attaque.getType()) {
                    case FEU:
                        countFeuRouge++;
                        break;
                    case ESSENCE:
                        countEssence++;
                        break;
                    case CREVAISON:
                        countCrevaison++;
                        break;
                    case ACCIDENT:
                        countAccident++;
                        break;
                }
            } else if (carte instanceof Botte) {
                Botte botte = (Botte) carte;
                switch (botte.getType()) {
                    case ESSENCE:
                        countCiterneEssence++;
                        break;
                    case CREVAISON:
                        countIncrevable++;
                        break;
                    case ACCIDENT:
                        countAsDuVolant++;
                        break;
                    case FEU:
                        countVehiculePrioritaire++;
                        break;
                }
            }
        }

        return countFeuRouge == NOMBRE_FEU_ROUGE &&
               countEssence == NOMBRE_ESSENCE &&
               countCrevaison == NOMBRE_CREVAISON &&
               countAccident == NOMBRE_ACCIDENT &&
               countCiterneEssence == NOMBRE_CITERNE_ESSENCE &&
               countIncrevable == NOMBRE_INCREVABLE &&
               countAsDuVolant == NOMBRE_AS_DU_VOLANT &&
               countVehiculePrioritaire == NOMBRE_VEHICULE_PRIORITAIRE;
    }

}