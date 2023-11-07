package testsFonctionnels;

import jeu.*;
import cartes.*;
import java.util.ArrayList;

public class TestJoueur {
    public static void main(String[] args) {
        // Création d'un joueur
        Joueur joueur = creerJoueur();

        // Ajout de bornes pour tester le kilométrage
        ajouterBornesAuJoueur(joueur);

        // Vérification du kilométrage
        int kilométrage = joueur.getKM();
        System.out.println("Kilométrage du joueur : " + kilométrage + " km");
    }

    private static Joueur creerJoueur() {
        // Création d'un joueur avec des listes vides pour les attributs
        return new Joueur("Joueur 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    private static void ajouterBornesAuJoueur(Joueur joueur) {
        // Création de quelques cartes Borne et ajout au joueur
        Borne borne1 = new Borne(1, 50);
        Borne borne2 = new Borne(2, 100);
        Borne borne3 = new Borne(3, 150);

        joueur.jouerBorne(borne1);
        joueur.jouerBorne(borne2);
        joueur.jouerBorne(borne3);
    }
}
