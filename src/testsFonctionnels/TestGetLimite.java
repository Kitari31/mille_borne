package testsFonctionnels;
import jeu.*;
import cartes.*;
import java.util.ArrayList;
import java.util.List;

public class TestGetLimite {
    public static void main(String[] args) {
        // Création d'un joueur
        Joueur joueur = creerJoueur();

        // Configuration 1 : Pile de limites vide
        List<Carte> pileLimitesVide = new ArrayList<>();
        int limite1 = joueur.getLimite(pileLimitesVide);
        System.out.println("Limite (pile de limites vide) : " + limite1);

        // Configuration 2 : Pile de limites avec FinDeLimite en haut
        List<Carte> pileLimitesAvecFinDeLimite = new ArrayList<>();
        pileLimitesAvecFinDeLimite.add(new FinLimite(1));
        int limite2 = joueur.getLimite(pileLimitesAvecFinDeLimite);
        System.out.println("Limite (pile avec FinDeLimite) : " + limite2);

        // Configuration 3 : Joueur prioritaire (a la botte de type FEU)
        List<Carte> ensembleBottes = new ArrayList<>();
        ensembleBottes.add(new Botte(1, Probleme.Type.FEU));
        joueur = creerJoueurAvecBottes(ensembleBottes);
        int limite3 = joueur.getLimite(pileLimitesVide);
        System.out.println("Limite (joueur prioritaire) : " + limite3);
    }

    private static Joueur creerJoueur() {
        return new Joueur("Joueur 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    private static Joueur creerJoueurAvecBottes(List<Carte> ensembleBottes) {
        return new Joueur("Joueur 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), ensembleBottes);
    }
}
