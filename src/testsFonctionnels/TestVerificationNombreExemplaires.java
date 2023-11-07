package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestVerificationNombreExemplaires {

    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();

        if (jeuDeCartes.check_count()) {
            System.out.println("Le jeu de cartes est correctement configuré.");
        } else {
            System.out.println("Le jeu de cartes est mal configuré.");
        }
    }
}
