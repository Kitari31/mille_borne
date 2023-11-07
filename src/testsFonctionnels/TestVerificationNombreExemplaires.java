package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Attaque;

public class TestVerificationNombreExemplaires {
    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();

        if (jeuDeCartes.checkCount()) {
            System.out.println("Tous les nombres d'exemplaires sont corrects.");
        } else {
            System.out.println("Des erreurs ont été trouvées dans les nombres d'exemplaires.");
        }
    }
}