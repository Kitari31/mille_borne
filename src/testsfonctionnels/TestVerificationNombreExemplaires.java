package testsfonctionnels;

import cartes.JeuDeCartes;

public class TestVerificationNombreExemplaires {

    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();

        if (jeuDeCartes.checkCount()) {
            System.out.println("Le jeu de cartes est correctement configure.");
        } else {
            System.out.println("Le jeu de cartes est mal configure.");
        }
    }
}
