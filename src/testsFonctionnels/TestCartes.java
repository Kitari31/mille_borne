package testsFonctionnels;

import jeu.Sabot;
import java.util.Iterator;
import cartes.*;

public class TestCartes {
    public static void main(String[] args) {
        // Créez un sabot
        Sabot sabot = new Sabot();

        // Ajoutez les familles de cartes "accident", "réparation" et "asDuVolant"
        Carte accident = new Attaque(3, Probleme.Type.ACCIDENT);
        Carte reparation = new Parade(3, Probleme.Type.ACCIDENT);
        Carte asDuVolant = new Botte(1, Probleme.Type.ACCIDENT);

        sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);

        // Utilisez un itérateur pour piocher et afficher les cartes du sabot jusqu'à ce qu'il soit vide
        Iterator<Carte> iterator = sabot.iterator();
        while (iterator.hasNext()) {
            Carte cartePiochee = iterator.next();
            System.out.println("je pioche " + cartePiochee);
            iterator.remove();
        }
    }
}
