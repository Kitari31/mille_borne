package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        afficherCartes(jeuDeCartes.getListeCartes());
    }

    public static void afficherCartes(Iterable<Carte> cartes) {
        for (Carte carte : cartes) {
            System.out.println(carte);
        }
    }
}

