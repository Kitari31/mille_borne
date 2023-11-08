package testsfonctionnels;

import jeu.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.*;
import cartes.Probleme.Type;

public class TestCartes {
	
	public static void affichage(Carte probleme) {
		StringBuilder message = new StringBuilder();
		message.append("Je pioche ");
		message.append(probleme.toString());
		System.out.println(message);
	}

	public static void main(String[] args) {
		Carte familleAccident = new Attaque(2,Type.ACCIDENT);
		Carte familleReparation = new Parade(3,Type.ACCIDENT);
		
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(familleAccident, familleReparation);
		
		
		// Utilisation d'un iterateur et remove
		Iterator<Carte> iterator = sabot.iterator();
        while (iterator.hasNext()) {
            Carte cartePiochee = iterator.next();
            System.out.println("je pioche " + cartePiochee);
            iterator.remove();
            
        }
		
		// Ajout de "As du volant" et tentative de piocher
		Carte familleAsDuVolant = new Botte(1,Type.ACCIDENT);
		sabot.ajouterFamilleCarte(familleAsDuVolant);
		
		//Parcours des elements de Sabot
		for(Carte c:sabot) {
			//On declence l'erreur concurent
			try {
	            System.out.println("Je pioche " + sabot.piocher());
	        } catch (ConcurrentModificationException e) {
	            System.out.println("Exception levee : " + e.getMessage());
	        }
			
		}
		
		



	}

}