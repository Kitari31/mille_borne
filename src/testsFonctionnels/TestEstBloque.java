package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.*;
import jeu.*;

public class TestEstBloque {
	public static void main(String[] args) {
        Joueur joueur = creerJoueurDeTest();
        
        // Test 1 : Le joueur a un "Feu Rouge". Doit renvoyer true.
        testerEstBloque(joueur, true);

        // Test 2 : Le joueur a un "Véhicule Prioritaire". Doit renvoyer false.
        testerEstBloque(joueur, false);

        // Test 3 : Le joueur a un "Accident". Doit renvoyer true.
        testerEstBloque(joueur, true);

        // Test 4 : Le joueur a un "As du Volant". Doit renvoyer false.
        testerEstBloque(joueur, false);

        // Test 5 : Le joueur a une "Panne d'Essence". Doit renvoyer true.
        testerEstBloque(joueur, true);

        // Test 6 : Le joueur a de l'"Essence". Doit renvoyer false.
        testerEstBloque(joueur, false);

        // Supprimer les bottes
        joueur.getEnsembleBottes().clear();

        // Test 7 : Le joueur n'a pas de botte. Doit renvoyer true.
        testerEstBloque(joueur, true);

        // Ajouter un "Feu Vert"
        joueur.donner(new Parade(1, Probleme.Type.FEU));

        // Test 8 : Le joueur a un "Feu Vert". Doit renvoyer false.
        testerEstBloque(joueur, false);
    }

    // Crée un joueur de test avec des cartes spécifiques dans sa main.
    public static Joueur creerJoueurDeTest() {
        List<Carte> pileLimitesVitesse = new ArrayList<>();
        List<Carte> pileBataille = new ArrayList<>();
        List<Carte> collectionBornes = new ArrayList<>();
        List<Carte> ensembleBottes = new ArrayList<>();
        Joueur joueur = new Joueur("Test", pileLimitesVitesse, pileBataille, collectionBornes, ensembleBottes);

        // Ajouter des cartes à la main du joueur.
        joueur.donner(new Attaque(1, Probleme.Type.FEU));  // Feu Rouge
        joueur.donner(new Botte(1, Probleme.Type.FEU));    // Véhicule Prioritaire
        joueur.donner(new Attaque(1, Probleme.Type.ACCIDENT));
        joueur.donner(new Botte(1, Probleme.Type.AS_DU_VOLANT));
        joueur.donner(new Attaque(1, Probleme.Type.PANNE_ESSENCE));
        joueur.donner(new Parade(1, Probleme.Type.ESSENCE));
        joueur.donner(new Botte(1, Probleme.Type.FEU));

        return joueur;
    }

    // Teste la méthode estBloque et affiche le résultat.
    public static void testerEstBloque(Joueur joueur, boolean expectedResult) {
        boolean estBloque = joueur.estBloque();
        System.out.println("estBloque renvoie " + estBloque + ". Résultat attendu : " + expectedResult);
    }
}
